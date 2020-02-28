package io.weeks.FileService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public String deleteFile(String filePath) throws Exception{

        String result = "success";

        try{

            File file = new File(filePath);
            if( file.exists() ){
                if(file.delete()){
                    System.out.println("파일삭제 성공");
                } else{
                    System.out.println("파일삭제 실패");
                    result = "파일삭제 실패";
                }
            } else{
                System.out.println("파일이 존재하지 않습니다.");
                result = "파일이 존재하지 않습니다.";
            }

        } catch(Exception e){
            result = "파일 삭제 중 에러가 발생하였습니다.";
        }

        return result;
    }

    public String restore(MultipartFile multipartFile, String path) {
        String url = null;

        try {

            File Folder = new File(path);

            // 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
            if (!Folder.exists()) {
                Folder.mkdirs(); //상위디렉토리 포함 폴더 생성

                // 폴더 권한 부여
                Runtime.getRuntime().exec("chmod -R 777 " + path );
            }

            // 파일 정보
            String originFilename = multipartFile.getOriginalFilename();
            String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
            String size = Long.toString(multipartFile.getSize());

            // 서버에서 저장 할 파일 이름
            String saveFileName = genSaveFileName(size, extName);

            writeFile(multipartFile, saveFileName, path);
            url = "/" + saveFileName;

        } catch (IOException e) {
            // 원래라면 RuntimeException 을 상속받은 예외가 처리되어야 하지만
            // 편의상 RuntimeException을 던진다.

            throw new RuntimeException(e);
        }

        return url;
    }


    // 현재 시간을 기준으로 파일 이름 생성
    private String genSaveFileName(String size, String extName) {
        String fileName = "";

        Calendar calendar = Calendar.getInstance();
        fileName += calendar.get(Calendar.YEAR);
        fileName += calendar.get(Calendar.MONTH);
        fileName += calendar.get(Calendar.DATE);
        fileName += calendar.get(Calendar.HOUR);
        fileName += calendar.get(Calendar.MINUTE);
        fileName += calendar.get(Calendar.SECOND);
        fileName += calendar.get(Calendar.MILLISECOND);
        fileName += size;

        fileName += extName;

        return fileName;
    }


    // 파일을 실제로 write 하는 메서드
    private boolean writeFile(MultipartFile multipartFile, String saveFileName, String path)
            throws IOException{
        boolean result = false;

        byte[] data = multipartFile.getBytes();
        FileOutputStream fos = new FileOutputStream(path + "/" + saveFileName);
        fos.write(data);
        fos.close();

        return result;
    }

    //앱이름과 년도일을 이용한 path 생성
    public String makeSaveFilePath() {

        String path = "/";
        Calendar cal = Calendar.getInstance();
        //현재 년도, 월, 일
        String year = Integer.toString(cal.get ( cal.YEAR ));
        String month = Integer.toString(cal.get ( cal.MONTH ) + 1);
        String date = Integer.toString(cal.get ( cal.DATE ));

        path = path + year + "/" + month + "/" + date;

        return path;
    }

}

package io.weeks.FileService;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    String deleteFile(String filePath) throws RuntimeException;

    String restore(MultipartFile multipartFile)  throws RuntimeException;

}

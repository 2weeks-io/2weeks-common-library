package io.weeks.config.configuration;

import io.weeks.FileService.FileService;
import io.weeks.config.dto.FileConfigDto;
import io.weeks.config.properties.FileProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FileProperties.class)
public class FileConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public FileConfigDto fileConfigDto(FileProperties fileProperties) {

        FileConfigDto fileConfigDto = new FileConfigDto();
        fileConfigDto.setFileUploadPath(fileProperties.getFileUploadPath());
        fileConfigDto.setApplicationName(fileProperties.getApplicationName());

        return fileConfigDto;
    }

}

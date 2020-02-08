package io.weeks.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("weeks")
public class FileProperties {

    private String fileUploadPath;

    private String applicationName;

}

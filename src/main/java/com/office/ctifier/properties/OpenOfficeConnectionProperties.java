package com.office.ctifier.properties;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ONE
 * @version 1.0
 * @date 2021/6/2 16:37
 */
@Data
@ConfigurationProperties(prefix = "open.office.connect")
public class OpenOfficeConnectionProperties {

    @ApiModelProperty("IP")
    private String ip;

    @ApiModelProperty("端口")
    private Integer port;

}

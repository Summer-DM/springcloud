package com.summer.springcloud.springcloudcommon.fileModel;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author Summer_DM
 * @Summary TODO  文件实体类
 * @Version 1.0
 * @Date 2021/8/18 下午 05:12
 **/
@ConfigurationProperties(prefix = "file")
public class FileProperty {

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

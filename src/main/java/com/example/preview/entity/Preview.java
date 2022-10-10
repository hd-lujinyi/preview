package com.example.preview.entity;/*
@author lujinyi
@creatr 2022-04-2022/4/7-16:29
*/

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Data
@Component
@ConfigurationProperties(prefix = "core")
public class Preview implements Serializable {
    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件地址
     */
    private String path;
    /**
     * 文件类型
     */
    private String type;
    /**
     * 访问地址
     */
    @Value("${fssc.url}")
    private String url;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}


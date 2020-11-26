package com.imooc.web.dto;

/**
 * @program: immoc-security-learn
 * @description: 文件信息实体
 * @author: linxinting
 * @create: 2020-11-25 14:53
 **/
public class FileInfo {
    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;

}

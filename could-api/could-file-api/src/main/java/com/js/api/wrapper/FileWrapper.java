package com.js.api.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * @author Jim.L
 * @title: FileWrapper
 * @projectName web-could
 * @date 2021/12/31
 * @dateTime 17:20
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileWrapper {

    public FileWrapper(String fileName, File file) {
        this.fileName = fileName;
        this.file = file;
    }

    public FileWrapper(String fileName, byte[] fileForByte) {
        this.fileName = fileName;
        this.fileForByte = fileForByte;
    }

    private String fileName;
    private byte[] fileForByte;
    private File file;


}

package com.js.could.file.opertaion;

import com.js.api.wrapper.FileWrapper;

/**
 * @author Jim.L
 * @title: FileHelper
 * @projectName web-could
 * @date 2021/12/30
 * @dateTime 21:27
 * @description: TODO
 */
public interface FileHeader {

    public boolean uploadFile(String fileName, byte[] fileByte);

    public FileWrapper downloadFile(String fileName);

    Boolean removeFile(String fileName);

}

package com.js.could.file.ceph;

import com.js.api.wrapper.FileWrapper;
import com.js.could.file.opertaion.FileHeader;
import org.javaswift.joss.model.Container;
import org.javaswift.joss.model.StoredObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jim.L
 * @title: SimpleFileHeader
 * @projectName web-could
 * @date 2021/12/28
 * @dateTime 22:57
 * @description: TODO
 */
@Component("SimpleFileHeader")
public class SimpleFileHeader implements FileHeader {

    @Autowired
    private Container container;

    @Override
    public boolean uploadFile(String fileName, byte[] fileByte) {
        return simpleUploadFile(fileName, fileByte);
    }

    @Override
    public FileWrapper downloadFile(String fileName) {

        return new FileWrapper(fileName,simpleDownloadFile(fileName));
    }

    public boolean simpleUploadFile(String fileName, byte[] fileByte) {

        StoredObject stored = container.getObject(fileName);
        stored.uploadObject(fileByte);

        return true;
    }

    public byte[] simpleDownloadFile(String fileName) {
        StoredObject stored = container.getObject(fileName);
        return stored.downloadObject();

    }

    @Override
    public Boolean removeFile(String fileName) {
        return simpleRemoveFile(fileName);
    }

    public Boolean simpleRemoveFile(String fileName) {
        StoredObject object = container.getObject(fileName);
        object.delete();
        return true;
    }
}

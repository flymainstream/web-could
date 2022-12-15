package com.js.could.file.controller;

import com.js.api.wrapper.FileWrapper;
import com.js.bean.request.RequestGateway;
import com.js.bean.response.ResponseResult;
import com.js.could.file.opertaion.FileHeader;
import com.js.could.file.vo.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jim.L
 * @title: UploadController
 * @projectName web-could
 * @date 2021/12/28
 * @dateTime 23:09
 * @description: TODO
 */
@RestController
@RequestMapping("/fileStored")
public class UploadController {

    @Qualifier("SimpleFileHeader")
    @Autowired
    private FileHeader fileHeader;

    @PostMapping("/upload")
    public ResponseResult upload(
            @RequestParam(value = "file", required = false) MultipartFile multipartFile
    ) throws IOException {
        if (multipartFile == null) {
            return ResponseResult.error();
        }
        return ResponseResult.UnknownStatus(fileHeader.uploadFile(multipartFile.getOriginalFilename(), multipartFile.getBytes()));
    }

    @PostMapping("/download")
    public void download(
            @RequestBody() RequestGateway<FileInfo> requestGateway,
            HttpServletResponse response
    ) throws IOException {

        FileWrapper fileWrapper = fileHeader.downloadFile(requestGateway.getBean().getFileName());
        byte[] bytes = fileWrapper.getFileForByte();

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();

    }

    @DeleteMapping()
    public ResponseResult remove(
            @RequestBody RequestGateway<FileInfo> requestGateway
    ) throws IOException {

        return ResponseResult.UnknownStatus(fileHeader.removeFile(requestGateway.getBean().getFileName()));

    }


}

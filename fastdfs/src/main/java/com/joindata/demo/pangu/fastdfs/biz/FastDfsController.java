package com.joindata.demo.pangu.fastdfs.biz;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.joindata.inf.common.support.fastdfs.support.component.FastDfsClient;
import com.joindata.inf.common.support.fastdfs.support.component.web.FastDfsFile;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fastdfs")
public class FastDfsController
{
    @Autowired
    private FastDfsClient client;

    @ApiOperation("上传文件到默认组")
    @PostMapping("/_/")
    public String upload(@RequestParam MultipartFile file, @RequestParam String savePath) throws IllegalStateException, IOException, InterruptedException, ExecutionException
    {
        FastDfsFile remoteFile = new FastDfsFile(savePath);
        file.transferTo(remoteFile);

        return remoteFile.getId();
    }

    @ApiOperation("上传文件到指定组")
    @PostMapping("/{saveGroup}/")
    public String upload(@RequestParam MultipartFile file, @PathVariable String saveGroup, @RequestParam String savePath) throws IllegalStateException, IOException, InterruptedException, ExecutionException
    {
        FastDfsFile remoteFile = new FastDfsFile(saveGroup, savePath);
        file.transferTo(remoteFile);

        return remoteFile.getId();
    }

    @ApiOperation(value = "下载文件", notes = "**下载时请直接从浏览器访问该 URL，使浏览器自行决定如何显示该文件**, __无需指定 group, 因为文件 ID 中包含该信息")
    @GetMapping("/_/")
    public void download(@RequestParam String fileId, ServletResponse response) throws IOException, InterruptedException, ExecutionException
    {
        client.download(fileId, response);
    }
}

package com.edu.xc.controller.fdfs;

import com.edu.mm.common.util.FDFSUtil;
import com.edu.mm.common.util.RUtils;
import com.edu.mm.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FdfsController {
    @Autowired
    private FDFSUtil fdfsUtil;

    //上传
    @PostMapping("fileupload.do")
    public R upload(@RequestParam("file")MultipartFile file) throws Exception {
        if (file != null && !file.isEmpty()) {
            String filePath = file.getOriginalFilename();
            String stuff = filePath.substring(filePath.lastIndexOf("."));
            String desFile = fdfsUtil.upload_file(filePath.getBytes(), stuff, null);
            System.out.println("upload:" + "http://10.8.164.32/" + desFile);
            return RUtils.getR(200, "http://10.8.164.32/" + desFile, "http://10.8.164.32/" + desFile);

        } else {
            return RUtils.setERROR("请上传文件，名称为file");
        }
    }

    //下载
    //查询列表
    //删除
}

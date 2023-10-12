package com.example.complaint_system.serivce;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 系统接口
 */
@Service
public interface SystemService {
    /**
     * @author bryan yang 2023 10-12
     * 幂等性处理
     * @return String.class
     */
    public String getNonPower();

    /**
     * @author bryan yang 2023 10-12
     * 文件下载
     * @return byte[]
     */
    @ApiOperation("文件下载")
    @GetMapping(value ="/getimage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@RequestParam("imgUrl") String imgUrl) throws IOException;

    /**
     * @author bryan yang 2023 10-12
     * 上传图片
     * @return String.class
     */
    public String imgUpDown(@RequestParam("file") MultipartFile file, @RequestParam("token")String token) throws IOException;
}

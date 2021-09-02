package com.summer.springcloud.springcloudcommon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Summer_DM
 * @Summary TODO  文件上传类：主要用于单文件和多文件上传
 * @Version 1.0
 * @Date 2021/8/12 下午 05:04
 **/
@Controller
@RequestMapping("/upload")
public class UploadFileController {

    private static final Logger log = LoggerFactory.getLogger(UploadFileController.class);

    @Value("${file.upload.path}")
    private String filePath;
    /*
     * 获取index.html页面
     */
    @RequestMapping("home")
    public String index() {
        return "index";
    }

    /*
     * 获取file.html页面
     */
    @RequestMapping("/fileIndex")
    public String file(ModelMap map) {
        map.put("title", "index界面");
        map.put("message","hello");
        System.out.println("进来了！");
        return "file";
    }

    /*
     * 获取multifile.html页面
     */
    @RequestMapping("/multifileIndex")
    public String multifile() {
        return "multifile";
    }

    /**
     * 单文件上传（适用于本地或者项目根路径文件的上传）
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadFile")
    @ResponseBody
    public String upload(@RequestParam(required=false) MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件为空,请检查！";
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            //获取文件类型
            String fileContentType = file.getContentType();
            //获取文件大小
            long size = file.getSize();
            log.info("上传的文件名为：" + fileName);//写日志
            // 获取文件的后缀名
            //String extension = "." + FilenameUtils.getExtension(originalFilename); //.jpg
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);//写日志
            // 设置文件存储路径
            String path = filePath + "/" + fileName;
            File dest = new File(new File(path).getAbsolutePath());// dist为文件，有多级目录的文件
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {//因此这里使用.getParentFile()，目的就是取文件前面目录的路径
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            return String.format("单文件上传成功！\n文件名:%s，\n文件类型:%s，\n文件大小:%s", fileName, fileContentType, size);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    /**
     * 多个文件一起上传
     *
     * @param request
     * @return
     */
    @PostMapping("/batch")
    public String handleFileUpload(HttpServletRequest request) {   //注意参数
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            File dest = new File(filePath);
            // 检测是否存在目录
            if (!dest.exists()) {
                dest.mkdirs();// 新建文件夹
            }
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(filePath + file.getOriginalFilename())));//设置文件路径及名字
                    stream.write(bytes);// 写入
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "第 " + i + " 个文件上传失败 ==> " + e.getMessage();
                }
            } else {
                return "第 " + i + " 个文件上传失败因为文件为空";
            }
        }
        return "上传成功";
    }


    /**
     * 多文件上传
     * 由于是多图片上传所以用数组来接。此处应该注意参数名应该和<input>中的name值相对应：
     * @param pictures
     * @return
     * @throws Exception
     */
    //@RequestMapping("/pic")
    //@ResponseBody
    //public ResponseEntity<String> pic(MultipartFile[] pictures) throws Exception {
    //    ResponseEntity<String> responseEntity = new ResponseEntity<>();
    //    long count = Arrays.asList(pictures).stream().
    //            map(MultipartFile::getOriginalFilename).
    //            filter(String::isEmpty).count();
    //    if (count == pictures.length) {
    //        responseEntity.setCode(ResponseEntity.ERROR);
    //        throw new Null0rEmptyException("图片不能同时为空");
    //    }
    //        responseEntity.setCode(ResponseEntity.OK);
    //        responseEntity.setMessage("上传成功");
    //        return responseEntity;
    //}
}

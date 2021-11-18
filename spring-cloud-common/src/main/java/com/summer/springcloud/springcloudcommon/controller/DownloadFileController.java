package com.summer.springcloud.springcloudcommon.controller;

import com.summer.springcloud.springcloudcommon.commonResult.Result;
import com.summer.springcloud.springcloudcommon.fileModel.TreeModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Summer_DM
 * @Summary TODO  文件下载类：主要用于单文件和多文件下载
 * @Version 1.0
 * @Date 2021/8/12 下午 05:04
 **/
@Controller
@RequestMapping("/download")
public class DownloadFileController {

    @Value("${file.upload.path}")
    private String filePath;
    /**
     * 文件下载（适用于本地或者项目根路径文件的下载）
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/downloadFile")
    @ResponseBody
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        // 文件名：从前台传来或者数据库中获取
        //String fileName = "timg (5).jpg";
        String fileName = "JAVA  SE  笔记.docx";
        if (fileName != null) {
            //设置文件路径
            File file = new File(filePath + "/" + fileName);
            if (file.exists()) {
                //String encodenickname = URLEncoder.encode(fjmc,"UTF-8");//转Unicode不然ie会乱码
                long fileLength = file.length();
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.setCharacterEncoding("UTF-8");//设置文件编码
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                response.setHeader("Content-Length", String.valueOf(fileLength));//设置文件长度
                byte[] buffer = new byte[2048];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return String.format("文件下载成功！\n文件名:%s，\n文件路径:%s", fileName,file.getAbsolutePath());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally { // 做关闭操作
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }

    @RequestMapping("/tree")
    @ResponseBody
    public Result getFilePath() {
        Result re = new Result();
        List<TreeModel> treeodel = new ArrayList<>();
        List<TreeModel> treeodel2 = new ArrayList<>();
        List<TreeModel> treeodel4 = new ArrayList<>();
        TreeModel model = new TreeModel();
        TreeModel model2 = new TreeModel();
        TreeModel model3 = new TreeModel();
        TreeModel model4 = new TreeModel();

        model4.setId(4L);
        model4.setParentId(2L);
        model4.setName("大孙子");
        treeodel4.add(model4);

        model2.setId(2L);
        model2.setParentId(1L);
        model2.setName("大儿子");
        model2.setChildModel(treeodel4);
        treeodel2.add(model2);

        model3.setId(3L);
        model3.setParentId(1L);
        model3.setName("二儿子");
        treeodel2.add(model3);

        model.setId(1L);
        model.setName("父级");
        model.setChildModel(treeodel2);
        treeodel.add(model);

        List<TreeModel> treeToJson = TreeModel.modelToJson(treeodel);
        System.out.println("json转换成tree："+treeToJson);
        re.setData(treeToJson);
        re.setMessage("转换成功");
        re.setCode("1");
        return re;
    }
}

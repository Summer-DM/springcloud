package com.summer.springcloud.springcloudcommon.utils.fileUtils;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author Summer_DM
 * @Summary TODO   操作文件的工具类（主要是利用了HuTool的工具）
 * @Version 1.0
 * @Date 2021/8/20 上午 09:18
 **/
public class FileUtils {

    private static  final Logger log = LoggerFactory.getLogger(FileUtils.class);

    public static void main(String[] args) {
        //测试文件流读取
        //getFileContent();
        //获取项目中的文件
        //getFilePath();
        //获取文件类型
        //getFileType();
    }
    /**
     * 获取sic/main/resources下面任何路径的文件
     */
    public void getFileContent(){
        ClassPathResource resource = new ClassPathResource("templates/file.jsp");
        Properties properties = new Properties();
        try {
            log.info("读取sic/main/resources下的文件流");
            properties.load(resource.getStream());
        } catch (IOException e) {
            log.error("读取sic/main/resources下的文件流失败，详细信息："+e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Properties:"+ properties);
    }

    /**
     * 获取项目工程文件的根路径
     * @return  返回文件绝对路径
     */
    public String getFilePath(){
        ClassPathResource resource = new ClassPathResource("templates/file.jsp");
        //path:E:\workspaces\practice\demo\demos\basic\spring-cloud-common\target\classes\templates\file.jsp
        String path = resource.getFile().getPath();
        //absolutePath:E:\workspaces\practice\demo\demos\basic\spring-cloud-common\target\classes\templates\file.jsp
        String absolutePath = resource.getFile().getAbsolutePath();
        System.out.println("path:"+path +"\nabsolutePath:"+absolutePath);
        return path;
    }

    /**
     * 获取文件类型
     * @param failPath  文件路径   例如sic/main/resources下面的：   "templates/file.jsp"
     * @return  返回文件类型  jsp
     */
    public String getFileType(String failPath){
        File file = FileUtil.file(failPath);
        String type = FileTypeUtil.getType(file);
        //这里还可以自定义文件类型
        //String newType = FileTypeUtil.putFileType("ffd8ffe000104a464946", "new_jpg");
        System.out.println("type:"+type);
        return type;
    }
}

package com.system.core.util;

import com.system.core.exception.ResultException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jx on 2017/4/26.
 */
public class FileUtil {

    public static String uploadFile(CommonsMultipartFile file) throws ResultException {
        String path = new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());
        String extName = getExtName(file.getOriginalFilename());
        String name = String.valueOf((int)(Math.random()*10000));
        String absPath = Const.ROOT_PATH + Const.UPLOAD_PATH + path + name + "." + extName;
        File dir = new File(Const.ROOT_PATH + Const.UPLOAD_PATH + path);
        if (!dir.exists()) dir.mkdirs();
        File newFile = new File(absPath);
        String savePath = Const.UPLOAD_PATH + path + name + "." + extName;
        try {
            file.transferTo(newFile);
//            System.out.println("path ===== " + path);
//            System.out.println("extName ===== " + extName);
//            System.out.println("fileName ===== " + name);
//            System.out.println("absPath ===== " + absPath);
//            System.out.println("url ===== " + savePath);
            return savePath;
        } catch (IOException e) {
            System.out.println("path ===== " + path);
            System.out.println("extName ===== " + extName);
            System.out.println("fileName ===== " + name);
            System.out.println("absPath ===== " + absPath);
            System.out.println("url ===== " + savePath);
            throw new ResultException(HttpStatus.ERROR, "上传失败");
        }
    }

    private static String getExtName(String filename) {
        return filename.substring(filename.lastIndexOf(".")+1, filename.length());
    }
}
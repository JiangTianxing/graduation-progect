package com.system.controller.home;

import com.system.core.exception.ResultException;
import com.system.core.util.Const;
import com.system.core.util.FileUtil;
import org.apache.http.entity.ContentType;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jx on 2017/4/30.
 */
@Controller("HomeCommonController")
@RequestMapping("/common")
public class CommonController {

    @RequestMapping(value = "/kindeditor/upload", method = RequestMethod.POST)
    public void uploadimage(@RequestParam(value = "imgFile", required = false) CommonsMultipartFile file,
                            HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        try {
            String path = FileUtil.uploadFile(file);
            result.put("error", 0);
            result.put("url", Const.PROJECT_PATH + path);
        } catch (ResultException e) {
            result.put("error", 1);
            result.put("message", "上传失败");
        }
        response.setContentType(ContentType.APPLICATION_JSON.toString());
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(result.toString());
    }
}
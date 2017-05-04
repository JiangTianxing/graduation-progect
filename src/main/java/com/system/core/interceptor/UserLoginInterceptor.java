package com.system.core.interceptor;

import com.system.core.util.Const;
import com.system.core.util.SessionUtil;
import com.system.data.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jx on 2017/4/24.
 */
public class UserLoginInterceptor implements BaseInterceptor {
    @Override
    public boolean interceptor(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        Object object =  SessionUtil.getAttr(httpServletRequest, Const.USER);
        if (object != null && object instanceof User)
            return true;
        httpServletResponse.sendRedirect(Const.PROJECT_PATH + "/admin/login");
        return false;
    }
}
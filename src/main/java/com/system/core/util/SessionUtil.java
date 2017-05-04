package com.system.core.util;

import com.system.data.entity.Manager;
import com.system.data.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jx on 2017/4/24.
 */
public class SessionUtil {
    public static User getUser(HttpServletRequest request) {
        return (User) getAttr(request, Const.USER);
    }

    public static Manager getManager(HttpServletRequest request) {
        return (Manager) getAttr(request, Const.MANAGER);
    }

    public static boolean checkIfUser(HttpServletRequest request) {
        return getAttr(request, Const.USER) != null;
    }

    public static boolean checkIfManager(HttpServletRequest request) {
        return getAttr(request, Const.MANAGER) != null;
    }

    public static Object getAttr(HttpServletRequest request, String name) {
        return request.getSession().getAttribute(name);
    }

    public static void setAttr(HttpServletRequest request, String name, Object object) {
        request.getSession().setAttribute(name, object);
    }

    public static void clearAttr(HttpServletRequest request, String name) {
        request.setAttribute(name, null);
        request.getSession().setAttribute(name, null);
    }
}

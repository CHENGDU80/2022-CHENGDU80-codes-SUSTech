package cn.edu.sustech.zxc.booking.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionUtil {
    public static String getAttribute(HttpServletRequest request, String attributeName) {
        return request.getSession().getAttribute(attributeName).toString();
    }


    public static boolean hasAttribute(HttpServletRequest request, String attributeName) {
        return request.getSession().getAttribute(attributeName) != null;
    }

    public static String getUserName(HttpServletRequest request) {
        return SessionUtil.getAttribute(request, "userName");
    }
}

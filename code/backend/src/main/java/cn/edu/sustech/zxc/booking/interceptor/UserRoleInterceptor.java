package cn.edu.sustech.zxc.booking.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;


@Component
public class UserRoleInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Override
//    public boolean preHandle
//            (HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        if (!(handler instanceof HandlerMethod)) {
//            return true;
//        }
//        String uri = request.getRequestURI();
//        if (uri.contains("login"))
//            return true;
//        try {
//            if (uri.contains("admin") && !SessionUtil.getAttribute(request, "isAdmin").equals("true")) {
//                response.sendError(401);
//                return false;
//            }
//            if (uri.contains("api") && !SessionUtil.hasAttribute(request, "userName")) {
//                response.sendError(401);
//                return false;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//
//
//        return true;
//    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response,
//                           Object handler, ModelAndView modelAndView) throws Exception {
//        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
//        System.out.println(request.getMethod());
//        System.out.println(request.getRequestURL().toString());
//        while (attributeNames.hasMoreElements()) {
//            String attri = attributeNames.nextElement();
//            System.out.println(String.format("Request Attribute: %s, Value: %s", attri, request.getSession().getAttribute(attri)));
//        }
//        System.out.println("Post Handle method is Calling");
//        System.out.println();
//    }

//    @Override
//    public void afterCompletion
//            (HttpServletRequest request, HttpServletResponse response, Object
//                    handler, Exception exception) throws Exception {
//        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
//        System.out.println();
//        System.out.println(request.getMethod());
//        System.out.println(request.getRequestURL().toString());
//        while (attributeNames.hasMoreElements()) {
//            String attri = attributeNames.nextElement();
//            System.out.println(String.format("Request Attribute: %s, Value: %s", attri, request.getSession().getAttribute(attri)));
//        }
//        System.out.println("Request and Response is completed");
//        System.out.println();
//    }
}

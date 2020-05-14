//package com.diary.diaryserver.intercetor;
//
//import com.diary.diaryserver.bean.Admin;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
////@Component
//public class LoginInterceptor implements HandlerInterceptor {
//    /*
//     * 进入controller层之前拦截请求
//     * 返回值：表示是否将当前的请求拦截下来  false：拦截请求，请求别终止。true：请求不被拦截，继续执行
//     * Object obj:表示被拦的请求的目标对象（controller中方法）
//     */
//    @Override
//    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        HttpSession session = httpServletRequest.getSession();
//        String contextPath=session.getServletContext().getContextPath();
//        String[] requireAuthPages = new String[]{
//                "index",
//        };
//
//        String uri = httpServletRequest.getRequestURI();
//
//        uri = StringUtils.remove(uri, contextPath+"/");
//        String page = uri;
//
//        if(begingWith(page, requireAuthPages)){
//            Admin admin = (Admin) session.getAttribute("admin");
//            if(admin==null) {
//                httpServletResponse.sendRedirect("login");
//                System.out.println("已成功拦截并转发跳转");
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean begingWith(String page, String[] requiredAuthPages) {
//        boolean result = false;
//        for (String requiredAuthPage : requiredAuthPages) {
//            if(StringUtils.startsWith(page, requiredAuthPage)) {
//                result = true;
//                break;
//            }
//        }
//        return result;
//    }
//}

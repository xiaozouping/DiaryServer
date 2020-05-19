//package com.diary.diaryserver.intercetor;
//
//import com.diary.diaryserver.bean.Admin;
//import org.json.JSONObject;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//    /*
//     * 进入controller层之前拦截请求
//     * 返回值：表示是否将当前的请求拦截下来  false：拦截请求，请求别终止。true：请求不被拦截，继续执行
//     * Object obj:表示被拦的请求的目标对象（controller中方法）
//     */
//    @Override
//    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        //这里可以根据session的用户是否登录
//        if (request.getSession().getAttribute("admin") == null) {
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json; charset=utf-8");
//            PrintWriter out = null;
//            try {
//                JSONObject res = new JSONObject();
//                res.put("success", false);
//                res.put("message", "用户未登录！");
//                out = response.getWriter();
//                out.append(res.toString());
//                return false;
//            } catch (Exception e) {
//                e.printStackTrace();
//                response.sendError(500);
//                return false;
//            }
//        }
//        return true;
//
//
////        String uri = httpServletRequest.getRequestURI();
////
////        uri = StringUtils.remove(uri, contextPath+"/");
////        String page = uri;
////
////        if(begingWith(page, requireAuthPages)){
////            Admin admin = (Admin) session.getAttribute("admin");
////            if(admin==null) {
////                httpServletResponse.sendRedirect("login");
////                System.out.println("已成功拦截并转发跳转");
////                return false;
////            }
////        }
////        return true;
////    }
////
////    private boolean begingWith(String page, String[] requiredAuthPages) {
////        boolean result = false;
////        for (String requiredAuthPage : requiredAuthPages) {
////            if(StringUtils.startsWith(page, requiredAuthPage)) {
////                result = true;
////                break;
////            }
////        }
////        return result;
//    }
//}

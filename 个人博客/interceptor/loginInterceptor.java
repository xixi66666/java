package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginInterceptor implements HandlerInterceptor {
    @Override
    /*
    preHandle：目标方法执行之前
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //登录检查逻辑
//        HttpSession session = request.getSession();
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null) {
//            //放行
//            return true;
//        }
//        //拦截住。未登录。跳转到登录页
//        request.setAttribute("msg", "请先登录");
////        re.sendRedirect("/");
//        request.getRequestDispatcher("/").forward(request, response);
//        return false;
        return true;
    }

    @Override
    /*
    postHandle:目标方法执行之后（返回页面之前）
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    /*
    afterCompletion：页面渲染之后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

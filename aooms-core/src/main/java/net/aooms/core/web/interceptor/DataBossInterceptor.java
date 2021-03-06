package net.aooms.core.web.interceptor;


import net.aooms.core.databoss.DataBoss;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 数据拦截器
 * Created by 风象南(yuboon) on 2018-04-19
 */
public class DataBossInterceptor extends AoomsAbstractInterceptor {

    public DataBossInterceptor(String[] pathPatterns, String[] ignores) {
        super(pathPatterns, ignores);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        DataBoss.create();
        return true;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){

    }

    @Override
    public void finalHandle(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        DataBoss.destroy();
    }
}
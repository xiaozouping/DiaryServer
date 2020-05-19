package com.diary.diaryserver.config;

//import com.diary.diaryserver.intercetor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class Crosconfig implements WebMvcConfigurer {

//    @Bean
//    LoginInterceptor loginInterceptor(){
//        return new LoginInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //拦截器按照顺序执行
//        registry.addInterceptor(loginInterceptor())
//                .addPathPatterns("/admin/**")
//                .addPathPatterns("/orders/**")
//                .excludePathPatterns("/admin/login");
//    }



    //解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }


}

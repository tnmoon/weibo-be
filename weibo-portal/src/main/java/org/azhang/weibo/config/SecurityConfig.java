package org.azhang.weibo.config;

import org.azhang.weibo.bo.AdminUserDetails;
import org.azhang.weibo.component.JwtAuthenticationTokenFilter;
import org.azhang.weibo.component.RestfulAccessDeniedHandler;
import org.azhang.weibo.component.RestfulAuthenticationEntryPoint;
import org.azhang.weibo.dto.Permission;
import org.azhang.weibo.model.User;
import org.azhang.weibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestfulAuthenticationEntryPoint restfulAuthenticationEntryPoint;
    @Autowired
    private UserService userService;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable() // 禁用CSRF
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 禁用session
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js").permitAll() // 对静态资源的访问
                .antMatchers("/login", "/register").permitAll() // 对登录注册页的匿名访问
                .antMatchers(HttpMethod.OPTIONS).permitAll() // 跨域时发送的OPTIONS请求
//                .antMatchers("/**").permitAll(); //测试时全部运行访问
                .anyRequest().authenticated(); // 除以上列出的情况外，均需鉴权认证

        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT Filter，制定将我们自定义的jwt filter放置于UsernamePasswordAuthenticationFilter之前
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // 将验证失败时的返回值Restful化
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restfulAuthenticationEntryPoint);
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 获取登录用户信息
        return username -> {
            User user = userService.getUserByUsername(username);
            if (user != null) {
                List<Permission> permissionList = userService.getPermissionList(user.getId());
                return new AdminUserDetails(user, permissionList);
            }
            throw new UsernameNotFoundException("用户名不存在");
        };
    }
}

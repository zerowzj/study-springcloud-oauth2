package study.springcloud.oauth2.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityCfg extends WebSecurityConfigurerAdapter {

    /**
     * 认证管理器
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    /**
     * 用户信息服务
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetailsService detailsService = super.userDetailsService();
        return detailsService;
    }

    /**
     * 定义用户名 密码和角色
     * 1.
     * 2.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("wang")
                .password("{noop}123").roles("USER");
    }

    /**
     * HttpSecurity中配置所有请求的安全验证
     * 1.
     * 2.
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers().anyRequest()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/oauth/**")
//                .permitAll();
//    }
}

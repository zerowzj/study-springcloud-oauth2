package study.springcloud.oauth2.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

//@EnableEurekaClient
@EnableAuthorizationServer
@SpringBootApplication(scanBasePackages = "study.springcloud.oauth2")
public class SpringBootCfg {
}

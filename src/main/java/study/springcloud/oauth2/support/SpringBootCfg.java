package study.springcloud.oauth2.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "study.springcloud.oauth2")
public class SpringBootCfg {
}

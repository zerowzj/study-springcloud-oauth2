package study.springcloud.oauth2.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
public class AuthorizationServerCfg extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 客户端配置
     * 1. 客户端详情信息在这里进行初始化
     * 2. 你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     * 3. 定义通过验证服务注册了哪些客户端应用程序，ClientDetailsServiceConfigurer支持两种不同类型的存储：内存存储和JDBC存储
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer client) throws Exception {
        client.inMemory()
                //客户端id和秘钥
                .withClient("client_id")
                .secret("client_secret")
                //支持的授权模式
                .authorizedGrantTypes("client_credentials")
                //定义访问作用域，也就是当用户使用某一个scope授权之后，
                //可以根据不同的scope封装不同的user信息，
                //比如webclient会封装角色，mobileclient封装角色和资源api，由开发人员定义即可
                .scopes("webclient", "mobileclient");
//        client.withClientDetails();
    }

    /**
     * 端点配置
     * 1. 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)，还有token的存储方式(tokenStore)
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //使用默认的验证管理器和用户信息服务
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    /**
     * 111
     * 1. 用来配置令牌端点(Token Endpoint)的安全约束
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }
}

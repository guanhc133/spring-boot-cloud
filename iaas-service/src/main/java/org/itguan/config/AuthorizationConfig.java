package org.itguan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.annotation.Resource;

/**
 * 授权服务器配置实现
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * passwordEncoder,authenticationManager 在WebSecurityConfig完成注入
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Resource(name = "userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("auth-client")// 第三方客户端的名称
                .secret(passwordEncoder.encode("auth-client"))//  外部第三方客户端的密钥
                .scopes("all")//第三方客户端的授权范围
                .authorizedGrantTypes("password","refresh_token")
                .accessTokenValiditySeconds(7 * 24 *3600) // token的有效期
                .refreshTokenValiditySeconds(30 * 24 * 3600)// refresh_token的有效期
                .and()
                .withClient("inside-app")
                .secret(passwordEncoder.encode("inside-secret")) //内部系统微服务之间的访问
                .authorizedGrantTypes("client_credentials")
                .scopes("all")
                .accessTokenValiditySeconds(Integer.MAX_VALUE) ;
                ;
        super.configure(clients);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenStore(jwtTokenStore())// tokenStore 来存储我们的token jwt 存储token
                .tokenEnhancer(jwtAccessTokenConverter());
        super.configure(endpoints);
    }

    private TokenStore jwtTokenStore() {
        JwtTokenStore jwtTokenStore = new JwtTokenStore(jwtAccessTokenConverter());
        return jwtTokenStore;
    }

    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();

        // 加载我们的私钥
        ClassPathResource classPathResource = new ClassPathResource("bootcloud.jks");
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource, "bootcloud".toCharArray());
        tokenConverter.setKeyPair(keyStoreKeyFactory.getKeyPair("bootcloud", "bootcloud".toCharArray()));
        return tokenConverter;
    }
}

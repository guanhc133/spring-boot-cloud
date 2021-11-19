项目启动前准备：
1，安装nacos，sentinel-dashboard，如果想启动zookeeper-server模块（用作配置中心，需安装zookeeper，zkui，可不启动，本项目示例用nacos作为配置中心）
2，依次启动isaas-service，provider，consumer

iaas-service 授权服务器 启动
1，postman访问：http://localhost:1007/oauth/token?grant_type=password&username=1001&password=12345 为当前用户产生token 可到jwt.io解析验证
        ps：注意选到Authorization->type->basic auth username：auth-client password：auth-client
        tips：/oauth/token这个内置接口会调用UserDetailsServiceImpl.loadUserByUsername将用户信息写进token（此时既为token也保存了用户信息，后期可拿到token解析作业务逻辑）
        
2，拿到上面产生的token 访问http://localhost:1007/user/info 获取当前用户的授权状况  入参为 access_token：上面产生的token

3，1，postman访问：http://localhost:1007/oauth/token?grant_type=client_credentials 为当前用户刷新产生新token，解决token失效的问题 可到jwt.io解析验证

4，测试org.itguan.AppTest#passToken 了解token的传递（非http访问，所以不可能携带token，中间会调用OAuth2FeignConfig拦截并添加token再去访问目标需授权访问方法）
    OAuth2FeignConfig该方法还不完善，token写死的，后面可以调用http://localhost:1007/oauth/token?grant_type=client_credentials产生新token替代写死的token
    
common-service
1，ResourceServerConfig制定了拦截规则以及加解密公私钥，公私钥可通过
    生成私钥：
    keytool -genkeypair -alias bootcloud -keyalg RSA -keypass bootcloud -keystore bootcloud.jks -validity 365 -storepass bootcloud
    获取当前执行命令目录生成的.jks文件 eg:iaas-service/src/main/resources/bootcloud.jks
    
    解析公钥：
    keytool -list -rfc --keystore bootcloud.jks | openssl x509 -inform pem -pubkey
    获取公钥 eg:common-service/src/main/resources/bootcloud.pub
    
gateway-service
1，通过网关访问/user/info，了解路由机制



总结：
    比较重要的几个类:
    1，AuthorizationConfig 授权服务器配置实现，包含
    指定第三方客户端，token有效期，refresh_token等，
    指定用户角色，权限，密码等数据来源（自定义userDetailsService），以及指定公私钥用作token的加解密
    2，isaas-service中ResourceServerConfig加@EnableResourceServer将所在项目作为资源服务器（也就是对外暴露的接口需要权限校验）
    
    3，所有需要授权操作的都需要依赖common-service模块，里面ResourceServerConfig类指定了校验规则（配置哪些接口路径需要校验及用公钥解密）
    4，OAuth2FeignConfig类用作拦截访问需授权接口的请求，在请求头加上token，仅针对于非http访问（仅通过接口直接的调用是没有token请求头的概念的，所以无法访问授权接口）
    
   
    
   


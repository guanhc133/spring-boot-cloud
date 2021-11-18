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


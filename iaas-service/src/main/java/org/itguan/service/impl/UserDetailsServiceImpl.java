package org.itguan.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        /**
         * 实际业务应该从数据库取用户及对应角色数据 数据库里的密码是加密存储
         */
        return new User(
                "1001",
                "$2a$10$o/BmAUsECmmsPlTEDiqIKOGw.3cpnP52VdKwltX0jBX5lWBD/tI2y",//明文密码1001 本地方法 WebSecurityConfig.main
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}

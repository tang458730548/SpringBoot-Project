package com.springboot.ztproject.common.realm;

import com.springboot.ztproject.pojo.TbUser;
import com.springboot.ztproject.service.TbUserService;
import com.springboot.ztproject.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义realm
 * @date 2019年3月27日22:30:08
 * @author tsc
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private TbUserService tbUserService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo (PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo (AuthenticationToken token) throws AuthenticationException {
        /*获取输入的用户名及密码*/
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        TbUser tbUser = tbUserService.findByUserName(username);
        if(tbUser == null){
            log.warn("---------------------------  当前用户不存在 -------------------------");
            throw new UnknownAccountException ("账号不存在");
        }if(!MD5Util.MD5Encode (password ,"utf-8").equals (tbUser.getPassword ())){
            log.warn ("-------------------------- 密码错误 ----------------------------");
            throw new IncorrectCredentialsException ("密码错误");
        }
        return new SimpleAuthenticationInfo(tbUser, password, getName());
    }
}

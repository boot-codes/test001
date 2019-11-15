package com.aosica.openapi.security;


import com.aosica.openapi.service.OpenUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatelessRealm extends AuthorizingRealm {

    private final  static Logger LOGGER = LoggerFactory.getLogger(StatelessRealm.class) ;

    @Autowired
    private OpenUserService openUserService ;

//    @Autowired
//    private OpenUserRoleService openUserRoleService ;

    //@Autowired
    //SysPermissionService sysPermissionService ;



    @Override
    public boolean supports(AuthenticationToken token) {

        return token instanceof JwtToken;
    }

    /**
     * 登录验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("***************** 登录验证 doGetAuthenticationInfo ***********************");
        JwtToken statelessToken = (JwtToken) token ;

        System.out.println(statelessToken);
//        String account  = statelessToken.getUsername() ;
//        System.out.println("登录验证帐号："+ account);

        //String key = new Md5Hash(account).toBase64();
        //在服务器端生成客户端参数消息摘要
        //String serverDigest = EncryptUtils.getDigest(key, statelessToken.getRequestURI());
        //然后进行客户端消息摘要和服务器端消息摘要的匹配
        //if(!serverDigest.equals(statelessToken.getClientDigest())){
           // return null;
        //}

        //String account = (String) token.getPrincipal();
        //if(StringUtils.isNotBlank(account)) {
        //    SysUser sysUser = this.sysUserService.findUserByAccount(account,true) ;
        //    if(sysUser == null) {
        //        return  null ;
        //    }
        //    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword().trim(), this.getName());
        //    authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(sysUser.getSalt()));
        //    return authenticationInfo ;
        //}

//        SysUser sysUser = this.openUserService.getUserByAccount("yuzp") ;
//        if(sysUser == null) {
//            return  null ;
//        }
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword().trim(), this.getName());
//        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(sysUser.getSalt()));
//        return authenticationInfo ;

        //com.zdst.sxcs.auth.entity.Account serviceAccount = accountDao.findByCode(statelessToken.getUsername());
        //if(serviceAccount == null)//账号不存在
        //    throw new UnknownAccountException();
        //
        //return new SimpleAuthenticationInfo(
        //    username,
        //    serverDigest,
        //    getName());
        //}

        return  null ;
    }


    /**
     *  权限管理
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("............doGetAuthorizationInfo............");
//        User user = (User) principals.getPrimaryPrincipal();
//        if(user == null ) {
//            return  null ;
//        }
//        //得到该用户的所属的角色
//        SysRole role = this.roleService.getRole(user.getRoldId());
//        System.out.println(role);
//
//        //根据角色id，得到该角色所属的权限
//        List<SysPermission> permissionList = this.sysPermissionService.getPermission(user.getRoldId());
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.addRole(role.getRoleName());
//        for(SysPermission p:permissionList){
//            authorizationInfo.addStringPermission(p.getPermission());
//        }
        //super.doGetAuthorizationInfo(principals) ;
        return  null  ;
    }

}

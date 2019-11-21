package com.example.jwtsecurity.dto;

import com.example.jwtsecurity.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class MyUserDetails implements UserDetails {

    private User user;
    //用户权限
    private List<String> permissionList;
    public MyUserDetails(User user,List<String> permissionList){
        this.user=user;
        this.permissionList = permissionList;
    }

    /**
     *返回权限集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissionList.stream()
                .filter(d->d!=null && !Objects.equals(d, ""))
                .map(s->new SimpleGrantedAuthority(s))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return "1".equals(user.getStatucode());
    }
}

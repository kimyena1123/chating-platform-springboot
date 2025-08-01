package com.practice.preview_spring_security_db.auth;

import com.fasterxml.jackson.annotation.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@Class")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageUserDetails implements UserDetails {

    private final Long userId;
    private final String username;
    private String password;

    @JsonCreator
    public MessageUserDetails(
            @JsonProperty("userId") Long userId,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    //Getter
    public Long getUserId() {
        return userId;
    }

    public void erasePassword(){
        password = "";
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    //권한 정보가 필요하다. 그런데 나는 권한 정보를 안쓸 거라서 빈 list로 두겠다
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MessageUserDetails that = (MessageUserDetails) object;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}

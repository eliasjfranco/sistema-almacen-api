package com.sistema.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
@IdClass(UserPK.class)
@Table(name = "USER")
public class User implements UserDetails{

	@Id
	@Column(name = "appid")
	private Integer appId;
	@Column(name = "nombre")
	private String firstname;
	@Column(name = "apellido")
	private String lastname;
	@Id
	@Column(name = "documento")
	private String document;
	@Column(name = "telefono")
	private String tel;
	@Column(name = "email")
	private String email;
	@Column(name = "fecha_nacimiento")
	private LocalDate birthday;
	@Column(name = "password")
	private String password;
	private String role = "user";
	
	private Collection<? extends GrantedAuthority> authorities;

	public User(Integer appId, String firstname, String lastname, String tel, String email, LocalDate birthday, String password, String document, Collection<? extends GrantedAuthority> authorities) {
		this.appId = appId;
		this.firstname = firstname;
        this.lastname = lastname;
        this.tel = tel;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.authorities = authorities;
        this.document = document;
	}
	
	public static User build(User user) {
		List<GrantedAuthority> authorities =
				user.get
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return document;
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
		return false;
	}
	
	
}

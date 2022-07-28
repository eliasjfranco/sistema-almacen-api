package com.sistema.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@IdClass(UserPK.class)
@Table(name = "USER")
public class User implements UserDetails{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
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
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))
	private Set<Role> role;
	
	@Transient
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
				user.getRole()
				.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getRole().name()))
				.collect(Collectors.toList());
		return new User(user.getAppId(), user.getFirstname(), user.getLastname(), user.getTel(), user.getEmail(), user.getBirthday(), user.getPassword(),  user.getDocument(), authorities);
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

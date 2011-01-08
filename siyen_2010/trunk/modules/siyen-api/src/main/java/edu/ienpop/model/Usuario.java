package edu.ienpop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author neodevelop
 *
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable,UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	@Column
	private String password;
	@Column
	private boolean enabled;
	@Transient
	private String nombre;
	@Transient
	private String email;
	@Transient
	private List<Instructor> instructores;
	@Transient
	private List<Puerto> puertos;
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER, mappedBy = "usuario")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
          org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private List<Autoridad> autoridades;
	
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for(Autoridad autoridad:autoridades){
			auths.add(new GrantedAuthorityImpl(autoridad.getAuthority()));
		}
		return auths;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return enabled;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Instructor> getInstructores() {
		return instructores;
	}
	public void setInstructores(List<Instructor> instructores) {
		this.instructores = instructores;
	}
	public List<Puerto> getPuertos() {
		return puertos;
	}
	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}
	public List<Autoridad> getAutoridades() {
		return autoridades;
	}
	public void setAutoridades(List<Autoridad> autoridades) {
		this.autoridades = autoridades;
	}
}

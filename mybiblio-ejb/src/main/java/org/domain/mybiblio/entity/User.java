package org.domain.mybiblio.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "USER", catalog = "biblio")
public class User implements java.io.Serializable {

	private Integer idUser;
	private String name;
	private String firstname;
	private String email;
	private String password;
	private Set<Rent> rents = new HashSet<Rent>(0);

	public User() {
	}

	public User(String name, String firstname, String email, String password) {
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.password = password;
	}

	public User(String name, String firstname, String email, String password,
			Set<Rent> rents) {
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.password = password;
		this.rents = rents;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER", unique = true, nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	@NotNull
	@Length(max = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "FIRSTNAME", nullable = false, length = 100)
	@NotNull
	@Length(max = 100)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "EMAIL", nullable = false, length = 50)
	@NotNull
	@Length(max = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD", nullable = false, length = 50)
	@NotNull
	@Length(max = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Rent> getRents() {
		return this.rents;
	}

	public void setRents(Set<Rent> rents) {
		this.rents = rents;
	}

}
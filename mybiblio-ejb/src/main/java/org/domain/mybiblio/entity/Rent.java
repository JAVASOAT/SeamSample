package org.domain.mybiblio.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.NotNull;

/**
 * Rent generated by hbm2java
 */
@Entity
@Table(name = "RENT", catalog = "biblio")
public class Rent implements java.io.Serializable {

	private Integer idRent;
	private Book book;
	private User user;
	private Date dateRent;
	private Date dateReturn;

	public Rent() {
	}

	public Rent(Book book, User user) {
		this.book = book;
		this.user = user;
	}

	public Rent(Book book, User user, Date dateRent, Date dateReturn) {
		this.book = book;
		this.user = user;
		this.dateRent = dateRent;
		this.dateReturn = dateReturn;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_RENT", unique = true, nullable = false)
	public Integer getIdRent() {
		return this.idRent;
	}

	public void setIdRent(Integer idRent) {
		this.idRent = idRent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BOOK", nullable = false)
	@NotNull
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USER", nullable = false)
	@NotNull
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_RENT", length = 19)
	public Date getDateRent() {
		return this.dateRent;
	}

	public void setDateRent(Date dateRent) {
		this.dateRent = dateRent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_RETURN", length = 19)
	public Date getDateReturn() {
		return this.dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

}
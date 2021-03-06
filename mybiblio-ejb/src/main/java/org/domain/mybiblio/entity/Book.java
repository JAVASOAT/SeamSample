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
 * Book generated by hbm2java
 */
@Entity
@Table(name = "BOOK", catalog = "biblio")
public class Book implements java.io.Serializable {

	private Integer idBook;
	private String isbn;
	private String title;
	private String author;
	private String shortDescription;
	private String longDescription;
	private String imageName;
	private Set<Rent> rents = new HashSet<Rent>(0);
	private Set<CategoryBook> categoryBooks = new HashSet<CategoryBook>(0);

	public Book() {
	}

	public Book(String isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public Book(String isbn, String title, String author,
			String shortDescription, String longDescription, String imageName,
			Set<Rent> rents, Set<CategoryBook> categoryBooks) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.imageName = imageName;
		this.rents = rents;
		this.categoryBooks = categoryBooks;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_BOOK", unique = true, nullable = false)
	public Integer getIdBook() {
		return this.idBook;
	}

	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}

	@Column(name = "ISBN", nullable = false, length = 50)
	@NotNull
	@Length(max = 50)
	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "TITLE", nullable = false, length = 50)
	@NotNull
	@Length(max = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "AUTHOR", nullable = false, length = 50)
	@NotNull
	@Length(max = 50)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "SHORT_DESCRIPTION", length = 65535)
	@Length(max = 65535)
	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Column(name = "LONG_DESCRIPTION", length = 65535)
	@Length(max = 65535)
	public String getLongDescription() {
		return this.longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Column(name = "IMAGE_NAME", length = 150)
	@Length(max = 150)
	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<Rent> getRents() {
		return this.rents;
	}

	public void setRents(Set<Rent> rents) {
		this.rents = rents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<CategoryBook> getCategoryBooks() {
		return this.categoryBooks;
	}

	public void setCategoryBooks(Set<CategoryBook> categoryBooks) {
		this.categoryBooks = categoryBooks;
	}

}

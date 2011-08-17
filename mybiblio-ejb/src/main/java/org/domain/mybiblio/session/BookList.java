package org.domain.mybiblio.session;

import org.domain.mybiblio.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("bookList")
public class BookList extends EntityQuery<Book> {

	private static final String EJBQL = "select book from Book book";

	private static final String[] RESTRICTIONS = {
			"lower(book.isbn) like lower(concat(#{bookList.book.isbn},'%'))",
			"lower(book.title) like lower(concat(#{bookList.book.title},'%'))",
			"lower(book.author) like lower(concat(#{bookList.book.author},'%'))",
			"lower(book.shortDescription) like lower(concat(#{bookList.book.shortDescription},'%'))",
			"lower(book.longDescription) like lower(concat(#{bookList.book.longDescription},'%'))",
			"lower(book.imageName) like lower(concat(#{bookList.book.imageName},'%'))", };

	private Book book = new Book();

	public BookList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Book getBook() {
		return book;
	}
}

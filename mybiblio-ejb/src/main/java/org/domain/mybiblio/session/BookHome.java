package org.domain.mybiblio.session;

import org.domain.mybiblio.entity.*;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("bookHome")
public class BookHome extends EntityHome<Book> {

	public void setBookIdBook(Integer id) {
		setId(id);
	}

	public Integer getBookIdBook() {
		return (Integer) getId();
	}

	@Override
	protected Book createInstance() {
		Book book = new Book();
		return book;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Book getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Rent> getRents() {
		return getInstance() == null ? null : new ArrayList<Rent>(getInstance()
				.getRents());
	}

	public List<CategoryBook> getCategoryBooks() {
		return getInstance() == null ? null : new ArrayList<CategoryBook>(
				getInstance().getCategoryBooks());
	}

}

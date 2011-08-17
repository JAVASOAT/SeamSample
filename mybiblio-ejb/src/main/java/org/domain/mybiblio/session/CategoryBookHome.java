package org.domain.mybiblio.session;

import org.domain.mybiblio.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("categoryBookHome")
public class CategoryBookHome extends EntityHome<CategoryBook> {

	@In(create = true)
	BookHome bookHome;
	@In(create = true)
	CategoryHome categoryHome;

	public void setCategoryBookIdCategoryBook(Integer id) {
		setId(id);
	}

	public Integer getCategoryBookIdCategoryBook() {
		return (Integer) getId();
	}

	@Override
	protected CategoryBook createInstance() {
		CategoryBook categoryBook = new CategoryBook();
		return categoryBook;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Book book = bookHome.getDefinedInstance();
		if (book != null) {
			getInstance().setBook(book);
		}
		Category category = categoryHome.getDefinedInstance();
		if (category != null) {
			getInstance().setCategory(category);
		}
	}

	public boolean isWired() {
		if (getInstance().getBook() == null)
			return false;
		if (getInstance().getCategory() == null)
			return false;
		return true;
	}

	public CategoryBook getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

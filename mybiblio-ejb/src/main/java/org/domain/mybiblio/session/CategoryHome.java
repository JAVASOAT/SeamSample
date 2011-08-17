package org.domain.mybiblio.session;

import org.domain.mybiblio.entity.*;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("categoryHome")
public class CategoryHome extends EntityHome<Category> {

	public void setCategoryIdCategory(Integer id) {
		setId(id);
	}

	public Integer getCategoryIdCategory() {
		return (Integer) getId();
	}

	@Override
	protected Category createInstance() {
		Category category = new Category();
		return category;
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

	public Category getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<CategoryBook> getCategoryBooks() {
		return getInstance() == null ? null : new ArrayList<CategoryBook>(
				getInstance().getCategoryBooks());
	}

}

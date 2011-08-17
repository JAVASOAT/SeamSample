package org.domain.mybiblio.session;

import org.domain.mybiblio.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("categoryList")
public class CategoryList extends EntityQuery<Category> {

	private static final String EJBQL = "select category from Category category";

	private static final String[] RESTRICTIONS = { "lower(category.nameCategory) like lower(concat(#{categoryList.category.nameCategory},'%'))", };

	private Category category = new Category();

	public CategoryList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Category getCategory() {
		return category;
	}
}

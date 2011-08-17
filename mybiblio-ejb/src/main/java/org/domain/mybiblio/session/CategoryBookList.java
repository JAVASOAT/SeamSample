package org.domain.mybiblio.session;

import org.domain.mybiblio.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("categoryBookList")
public class CategoryBookList extends EntityQuery<CategoryBook> {

	private static final String EJBQL = "select categoryBook from CategoryBook categoryBook";

	private static final String[] RESTRICTIONS = {};

	private CategoryBook categoryBook = new CategoryBook();

	public CategoryBookList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public CategoryBook getCategoryBook() {
		return categoryBook;
	}
}

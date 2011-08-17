package org.domain.mybiblio.session;

import org.domain.mybiblio.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("rentList")
public class RentList extends EntityQuery<Rent> {

	private static final String EJBQL = "select rent from Rent rent";

	private static final String[] RESTRICTIONS = {};

	private Rent rent = new Rent();

	public RentList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Rent getRent() {
		return rent;
	}
}

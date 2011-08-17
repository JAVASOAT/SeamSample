package org.domain.mybiblio.session;

import org.domain.mybiblio.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("userList")
public class UserList extends EntityQuery<User> {

	private static final String EJBQL = "select user from User user";

	private static final String[] RESTRICTIONS = {
			"lower(user.name) like lower(concat(#{userList.user.name},'%'))",
			"lower(user.firstname) like lower(concat(#{userList.user.firstname},'%'))",
			"lower(user.email) like lower(concat(#{userList.user.email},'%'))",
			"lower(user.password) like lower(concat(#{userList.user.password},'%'))", };

	private User user = new User();

	public UserList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public User getUser() {
		return user;
	}
}

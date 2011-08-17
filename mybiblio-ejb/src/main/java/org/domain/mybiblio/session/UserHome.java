package org.domain.mybiblio.session;

import org.domain.mybiblio.entity.*;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("userHome")
public class UserHome extends EntityHome<User> {

	public void setUserIdUser(Integer id) {
		setId(id);
	}

	public Integer getUserIdUser() {
		return (Integer) getId();
	}

	@Override
	protected User createInstance() {
		User user = new User();
		return user;
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

	public User getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Rent> getRents() {
		return getInstance() == null ? null : new ArrayList<Rent>(getInstance()
				.getRents());
	}

}

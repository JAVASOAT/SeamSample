package org.domain.mybiblio.session;

import org.domain.mybiblio.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("rentHome")
public class RentHome extends EntityHome<Rent> {

	@In(create = true)
	BookHome bookHome;
	@In(create = true)
	UserHome userHome;

	public void setRentIdRent(Integer id) {
		setId(id);
	}

	public Integer getRentIdRent() {
		return (Integer) getId();
	}

	@Override
	protected Rent createInstance() {
		Rent rent = new Rent();
		return rent;
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
		User user = userHome.getDefinedInstance();
		if (user != null) {
			getInstance().setUser(user);
		}
	}

	public boolean isWired() {
		if (getInstance().getBook() == null)
			return false;
		if (getInstance().getUser() == null)
			return false;
		return true;
	}

	public Rent getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

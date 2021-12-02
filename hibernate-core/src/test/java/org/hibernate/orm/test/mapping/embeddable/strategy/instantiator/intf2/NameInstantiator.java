/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.orm.test.mapping.embeddable.strategy.instantiator.intf2;

import java.util.function.Supplier;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.EmbeddableInstantiator;

/**
 * @author Steve Ebersole
 */
public class NameInstantiator implements EmbeddableInstantiator {
	@Override
	public Object instantiate(Supplier<Object[]> valuesAccess, SessionFactoryImplementor sessionFactory) {
		return new Name();
	}

	@Override
	public boolean isInstance(Object object, SessionFactoryImplementor sessionFactory) {
		return object instanceof Name;
	}

	@Override
	public boolean isSameClass(Object object, SessionFactoryImplementor sessionFactory) {
		return object.getClass().equals( Name.class );
	}
}

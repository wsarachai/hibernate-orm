/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.orm.test.mapping.embeddable.strategy.instantiator.intf2;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.EmbeddableInstantiator;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "persons")
//tag::embeddable-instantiator-property[]
@Entity
public class Person {
	@Id
	public Integer id;

	@Embedded
	@EmbeddableInstantiator( NameInstantiator.class )
	@Access( AccessType.PROPERTY )
	public Name name;

	@ElementCollection
	@Embedded
	@EmbeddableInstantiator( NameInstantiator.class )
	@Access( AccessType.PROPERTY )
	public Set<Name> aliases;

	//end::embeddable-instantiator-property[]

	private Person() {
		// for Hibernate use
	}

	public Person(Integer id, Name name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Name> getAliases() {
		return aliases;
	}

	public void setAliases(Set<Name> aliases) {
		this.aliases = aliases;
	}

	public void addAlias(Name alias) {
		if ( aliases == null ) {
			aliases = new HashSet<>();
		}
		aliases.add( alias );
	}

//tag::embeddable-instantiator-property[]
}
//end::embeddable-instantiator-property[]
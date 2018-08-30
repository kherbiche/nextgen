/*
 * Copyright 2008, 2018 Lyes Kherbiche
 * <kerbiche@gmail.com>
 */
package dz.ummto.ansejNextGen.jpa.dao;

import java.util.List;

/**
 * The <code>IDao</code> Interface represents a generic DAO Interface provides
 * the common operation with entities. Each class that implements this interface
 * have to indicate what the type of entity it manages E and the type of
 * identificator K
 *
 * @param <K>
 *            is the type to use as the key
 * @param <E>
 *            is the type of the entity
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public interface IDao<K, E> {

	E save(E entity);

	E update(E entity);

	void remove(E entity);

	E findById(K id);

	List<E> findAll();

}

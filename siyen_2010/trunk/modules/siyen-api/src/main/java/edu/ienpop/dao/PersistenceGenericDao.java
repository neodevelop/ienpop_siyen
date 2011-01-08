package edu.ienpop.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author neodevelop
 * 
 * @param <T>
 * @param <PK>
 */
public interface PersistenceGenericDao<T, PK extends Serializable> {
	void create(T newInstance);

	T read(PK id);

	void update(T transientObject);

	void delete(T persistentObject);

	List<T> findAll();
	
	//void merge(T transientObject);
	
	void flush();
}

package edu.ienpop.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao {
	Serializable save(Object o);
	void update(Object o);
	void delete(Object o);
	List getAll(String entity);
	Object getByPK(Class clazz, Serializable pk);
}

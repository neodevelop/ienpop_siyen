package edu.ienpop.services;

import java.io.Serializable;
import java.util.List;
@SuppressWarnings("unchecked")
public interface PersistenceService {
	Serializable createEntity(Object o);
	void updateEntity(Object o);
	void deleteEntity(Object o);
	List getAllEntities(String entity);
	Object findById(Class clazz,Serializable pk);
}

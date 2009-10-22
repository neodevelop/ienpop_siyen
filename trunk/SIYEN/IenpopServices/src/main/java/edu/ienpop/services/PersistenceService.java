package edu.ienpop.services;

import java.io.Serializable;
import java.util.List;
@SuppressWarnings("unchecked")
public interface PersistenceService {
	Serializable createEntity(Object o) throws BusinessException;
	void updateEntity(Object o) throws BusinessException;
	void deleteEntity(Object o) throws BusinessException;
	List getAllEntities(String entity) throws BusinessException;
	Object findById(Class clazz,Serializable pk) throws BusinessException;
}

package edu.ienpop.services.impl;

import java.io.Serializable;
import java.util.List;

import edu.ienpop.dao.Dao;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.PersistenceService;

public class PersistenceServiceDefaultImpl implements PersistenceService {
	
	private Dao dao;
	

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public Serializable createEntity(Object o) throws BusinessException {
		// TODO Auto-generated method stub
		return getDao().save(o);
	}

	public void deleteEntity(Object o) throws BusinessException {
		// TODO Auto-generated method stub
		getDao().delete(o);
	}

	@SuppressWarnings("unchecked")
	public Object findById(Class clazz, Serializable pk)
			throws BusinessException {
		// TODO Auto-generated method stub
		return getDao().getByPK(clazz, pk);
	}

	@SuppressWarnings("unchecked")
	public List getAllEntities(String entity) throws BusinessException {
		// TODO Auto-generated method stub
		return getDao().getAll(entity);
	}

	public void updateEntity(Object o) throws BusinessException {
		// TODO Auto-generated method stub
		getDao().update(o);
	}

}

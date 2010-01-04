package edu.ienpop.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ienpop.dao.Dao;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.PersistenceService;

@SuppressWarnings("unchecked")
@Service("persistenceService")
public class PersistenceServiceDefaultImpl implements PersistenceService {
	
	@Autowired
	private Dao dao;

	public Serializable createEntity(Object o) throws BusinessException {
		// TODO Auto-generated method stub
		return dao.save(o);
	}

	public void deleteEntity(Object o) throws BusinessException {
		// TODO Auto-generated method stub
		dao.delete(o);
	}

	public Object findById(Class clazz, Serializable pk)
			throws BusinessException {
		// TODO Auto-generated method stub
		return dao.getByPK(clazz, pk);
	}

	public List getAllEntities(String entity) throws BusinessException {
		// TODO Auto-generated method stub
		return dao.getAll(entity);
	}

	public void updateEntity(Object o) throws BusinessException {
		// TODO Auto-generated method stub
		dao.update(o);
	}

}

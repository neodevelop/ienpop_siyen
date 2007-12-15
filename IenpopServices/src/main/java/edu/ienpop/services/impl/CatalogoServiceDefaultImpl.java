package edu.ienpop.services.impl;

import java.util.List;

import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CatalogoService;
import edu.ienpop.services.PersistenceService;

public class CatalogoServiceDefaultImpl implements CatalogoService {

	PersistenceService persistenceService;
	
	public PersistenceService getPersistenceService() {
		return persistenceService;
	}

	public void setPersistenceService(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}

	public List getCatalogoCurso() throws BusinessException {
		// TODO Auto-generated method stub
		return getPersistenceService().getAllEntities("CatalogoCurso");
	}

	public List getCatalogoPuerto() throws BusinessException {
		// TODO Auto-generated method stub
		return getPersistenceService().getAllEntities("CatalogoPuerto");
	}

	public List getCatalogoStatusAlumno() throws BusinessException {
		// TODO Auto-generated method stub
		return getPersistenceService().getAllEntities("CatalogoStatusAlumno");
	}

	public List getCatalogoStatusCurso() throws BusinessException {
		// TODO Auto-generated method stub
		return getPersistenceService().getAllEntities("CatalogoStatusCurso");
	}

}

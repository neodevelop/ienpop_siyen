package edu.ienpop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CatalogoService;
import edu.ienpop.services.PersistenceService;

@SuppressWarnings("unchecked")
@Service("catalogoService")
public class CatalogoServiceDefaultImpl implements CatalogoService {

	@Autowired
	PersistenceService persistenceService;

	public List getCatalogoCurso() throws BusinessException {
		// TODO Auto-generated method stub
		return persistenceService.getAllEntities("CatalogoCurso");
	}

	public List getCatalogoPuerto() throws BusinessException {
		// TODO Auto-generated method stub
		return persistenceService.getAllEntities("CatalogoPuerto");
	}

	public List getCatalogoStatusAlumno() throws BusinessException {
		// TODO Auto-generated method stub
		return persistenceService.getAllEntities("CatalogoStatusAlumno");
	}

	public List getCatalogoStatusCurso() throws BusinessException {
		// TODO Auto-generated method stub
		return persistenceService.getAllEntities("CatalogoStatusCurso");
	}

}

package edu.ienpop.services;

import java.util.List;
@SuppressWarnings("unchecked")
public interface CatalogoService {
	List getCatalogoCurso() throws BusinessException;
	List getCatalogoPuerto() throws BusinessException;
	List getCatalogoStatusAlumno() throws BusinessException;
	List getCatalogoStatusCurso() throws BusinessException;
}

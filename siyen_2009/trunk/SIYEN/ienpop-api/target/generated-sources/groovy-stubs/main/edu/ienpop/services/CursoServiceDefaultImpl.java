//
// Generated stub from file:/Users/neodevelop/Documents/Workspaces/ienpopWorkspace/svn/trunk/SIYEN/ienpop-api/src/main/groovy/edu/ienpop/services/impl/CursoServiceDefaultImpl.groovy
//

package edu.ienpop.services;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.Curso;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ienpop.dao.CatalogoDao;
import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.CatalogoCurso;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoService;
import edu.ienpop.services.LlaveService;
import edu.ienpop.services.PersistenceService;

public class CursoServiceDefaultImpl
    extends java.lang.Object
    implements groovy.lang.GroovyObject, CursoService
{
    private Logger log = null;
    public Logger getLog() {
        throw new InternalError("Stubbed method");
    }
    public void setLog(Logger value) {
        throw new InternalError("Stubbed method");
    }

    private PersistenceService persistenceService = null;
    public PersistenceService getPersistenceService() {
        throw new InternalError("Stubbed method");
    }
    public void setPersistenceService(PersistenceService value) {
        throw new InternalError("Stubbed method");
    }

    private LlaveService llaveService = null;
    public LlaveService getLlaveService() {
        throw new InternalError("Stubbed method");
    }
    public void setLlaveService(LlaveService value) {
        throw new InternalError("Stubbed method");
    }

    private CursoDao cursoDao = null;
    public CursoDao getCursoDao() {
        throw new InternalError("Stubbed method");
    }
    public void setCursoDao(CursoDao value) {
        throw new InternalError("Stubbed method");
    }

    private CatalogoDao catalogoDao = null;
    public CatalogoDao getCatalogoDao() {
        throw new InternalError("Stubbed method");
    }
    public void setCatalogoDao(CatalogoDao value) {
        throw new InternalError("Stubbed method");
    }

    public long addCursoCertificado(long idCursoXCertificar, java.lang.String llave) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public Curso generateCertificadosXCurso(long idCurso) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public List getInformePeriodico(Date desde, Date hasta) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public List getInformeXTipoLibreta(int mes, int anio, java.lang.String libreta, java.lang.String idPuerto) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public List getOficio(Date fechaInicio, Date fechaFin, java.lang.String idPuerto) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public List getCursosXStatus(CursoCriteria cursoCriteria) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public java.lang.String getIdTipoCursoById(java.lang.String idCurso) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public Curso getCursoByTokenCertificado(java.lang.String token) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public Integer getCountCursosByCriteria(CursoCriteria cursoCriteria) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public Curso getCursoById(Long id) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public void recoveryCursoCertificado(Curso cursoModificar, List alumnos) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public long updateCursoCertificado(long idCursoXCertificar, java.lang.String llave) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public Curso generateCertificadosXCursoRecuperado(long idCurso) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public void cambiarAgregarAlumnosACurso(List alumnos, Curso curso) {
        throw new InternalError("Stubbed method");
    }

    public groovy.lang.MetaClass getMetaClass() {
        throw new InternalError("Stubbed method");
    }

    public void setMetaClass(groovy.lang.MetaClass metaClass) {
        throw new InternalError("Stubbed method");
    }

    public java.lang.Object invokeMethod(java.lang.String name, java.lang.Object args) {
        throw new InternalError("Stubbed method");
    }

    public java.lang.Object getProperty(java.lang.String name) {
        throw new InternalError("Stubbed method");
    }

    public void setProperty(java.lang.String name, java.lang.Object value) {
        throw new InternalError("Stubbed method");
    }
}

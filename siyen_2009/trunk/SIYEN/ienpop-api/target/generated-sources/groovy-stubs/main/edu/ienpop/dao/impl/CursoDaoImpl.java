//
// Generated stub from file:/Users/neodevelop/Documents/Workspaces/ienpopWorkspace/svn/trunk/SIYEN/ienpop-api/src/main/groovy/edu/ienpop/dao/impl/CursoDaoImpl.groovy
//

package edu.ienpop.dao.impl;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.jms.Session;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoXCertificar;

public class CursoDaoImpl
    extends HibernateDaoSupport
    implements groovy.lang.GroovyObject, CursoDao
{
    private Logger log = null;
    public Logger getLog() {
        throw new InternalError("Stubbed method");
    }
    public void setLog(Logger value) {
        throw new InternalError("Stubbed method");
    }

    /**
     * Magic constructor
     */
    private CursoDaoImpl(java.lang.Void void0, java.lang.Void void1, java.lang.Void void2) {
        throw new InternalError("Stubbed method");
    }

    public CursoDaoImpl(HibernateTemplate hibernateTemplate) {
        this((java.lang.Void)null, (java.lang.Void)null, (java.lang.Void)null);
        throw new InternalError("Stubbed method");
    }

    public List getCursoXCertificarPorCriteria(CursoCriteria cursoCriteria) {
        throw new InternalError("Stubbed method");
    }

    public List getCursosPorCriteria(CursoCriteria cursoCriteria) {
        throw new InternalError("Stubbed method");
    }

    public java.lang.String getTipoCursoByIdCurso(java.lang.String idCurso) {
        throw new InternalError("Stubbed method");
    }

    public Curso getCursoByIdLlaveCertificada(long id) {
        throw new InternalError("Stubbed method");
    }

    public Integer getCountCursosPorCriteria(CursoCriteria cursoCriteria) {
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

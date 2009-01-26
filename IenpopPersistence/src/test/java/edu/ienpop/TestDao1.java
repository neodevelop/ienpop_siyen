package edu.ienpop;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.dao.Dao;
import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.CatalogoCurso;
import edu.ienpop.model.CatalogoPuerto;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.model.Usuario;

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/DataSourceAppCtx.xml"})
public class TestDao1 {

	@Autowired
	Dao dao;

	@Test
	public void testDao() {
		//List list = dao.getAll("Alumno");
		//for (Iterator it = list.iterator(); it.hasNext();) {
		//	Alumno alumno = (Alumno) it.next();
		//	System.out.println(alumno.getIdCurso());
		//	System.out.println(alumno.getNombreCompleto());
		//	System.out.println(alumno.getId());
		//}
	}

	@Test
	public void testDao2() {
		//List list = dao.getAll("Curso");
		//for (Iterator it = list.iterator(); it.hasNext();) {
		//	Curso curso = (Curso) it.next();
		//	System.out.println(curso.getId());
		//	System.out.println(curso.getIdUsuario());
		//	System.out.println(ToStringBuilder.reflectionToString(curso.getTipoCurso()));
		//}
	}

	@Test
	public void testDao3() {
		Usuario usuario = new Usuario();
		usuario = (Usuario)dao.getByPK(Usuario.class, "JUANG");
		System.out.println(usuario.getIdUsuario());
		Set<CatalogoPuerto> puertos = usuario.getPuertos();
		if(puertos!=null){
			for(CatalogoPuerto puerto:puertos){
				System.out.println(puerto.getIdPuerto());
			}
		}
		System.out.println(puertos.getClass().getName());
	}

	@Test
	public void testDao4() {
		List list = dao.getAll("CatalogoCurso");
		for (Iterator it = list.iterator(); it.hasNext();) {
			CatalogoCurso catalogoCurso = (CatalogoCurso) it.next();
			System.out.println(ToStringBuilder
					.reflectionToString(catalogoCurso));
		}
	}

	@Test
	public void testDao5() {
		List list = dao.getAll("CatalogoPuerto");
		for (Iterator it = list.iterator(); it.hasNext();) {
			CatalogoPuerto catalogoPuerto = (CatalogoPuerto) it.next();
			System.out.println(ToStringBuilder
					.reflectionToString(catalogoPuerto));
		}
	}

	@Test
	public void testDao6() {
		CursoXCertificar nuevoCurso = new CursoXCertificar();
		nuevoCurso.setIdPuerto("ACG");
		nuevoCurso.setIdTipoCurso("CAPACO3234");
		nuevoCurso.setFechaHoraRegistro(new Date());
		nuevoCurso.setIdUsuario("JUANG");
		Calendar calendar = Calendar.getInstance();
		calendar.set(2007, 6, 10);
		nuevoCurso.setFechaInicio(calendar.getTime());
		nuevoCurso.setIdStatusCurso(1);
		dao.save(nuevoCurso);
		dao.update(nuevoCurso);
	}

	@Test
	public void testDao7() {
		AlumnoXCertificar alumnoNuevo = new AlumnoXCertificar();
		alumnoNuevo.setFechaHoraRegistro(new Date());
		alumnoNuevo.setIdCursoXCertificar(2);
		alumnoNuevo.setIdStatusAlumno(1);
		alumnoNuevo.setNombreCompleto("SARA ESPINOSA PEREZ");
		dao.save(alumnoNuevo);
		dao.update(alumnoNuevo);
	}

	@Test
	public void testDao8() {
		CursoXCertificar nuevoCurso = new CursoXCertificar();
		nuevoCurso.setIdPuerto("ACG");
		nuevoCurso.setIdTipoCurso("CAPACO3234");
		nuevoCurso.setFechaHoraRegistro(new Date());
		nuevoCurso.setIdUsuario("JUANG");
		Calendar calendar = Calendar.getInstance();
		calendar.set(2007, 6, 10);
		nuevoCurso.setFechaInicio(calendar.getTime());
		nuevoCurso.setIdStatusCurso(1);

		dao.save(nuevoCurso);
		dao.update(nuevoCurso);

	}

	@Test
	public void testDao9() {
		CursoXCertificar nuevoCurso = (CursoXCertificar) dao.getByPK(
				CursoXCertificar.class, new Long(7));

		AlumnoXCertificar alumnoNuevo = new AlumnoXCertificar();
		alumnoNuevo.setFechaHoraRegistro(new Date());
		alumnoNuevo.setIdStatusAlumno(1);
		alumnoNuevo.setNombreCompleto("SARA ESPINOSA PEREZ");
		// alumnoNuevo.setCursoXCertificar(nuevoCurso);
		dao.save(alumnoNuevo);
		dao.update(alumnoNuevo);

		AlumnoXCertificar alumnoNuevo2 = new AlumnoXCertificar();
		alumnoNuevo2.setFechaHoraRegistro(new Date());
		alumnoNuevo2.setIdStatusAlumno(1);
		alumnoNuevo2.setNombreCompleto("JUANIS REYES ZU�IGA");
		// alumnoNuevo2.setCursoXCertificar(nuevoCurso);
		dao.save(alumnoNuevo2);
		dao.update(alumnoNuevo2);

		AlumnoXCertificar alumnoNuevo3 = new AlumnoXCertificar();
		alumnoNuevo3.setFechaHoraRegistro(new Date());
		alumnoNuevo3.setIdStatusAlumno(1);
		alumnoNuevo3.setNombreCompleto("CRISTINA REYES ZU�IGA");
		// alumnoNuevo3.setCursoXCertificar(nuevoCurso);
		dao.save(alumnoNuevo3);
		dao.update(alumnoNuevo3);
		Set alumnos = new HashSet();

		// nuevoCurso.getAlumnos().add(alumnoNuevo);
		// nuevoCurso.getAlumnos().add(alumnoNuevo2);
		// nuevoCurso.getAlumnos().add(alumnoNuevo3);
		alumnos.add(alumnoNuevo);
		alumnos.add(alumnoNuevo2);
		alumnos.add(alumnoNuevo3);
		nuevoCurso.setAlumnos(alumnos);

		dao.update(nuevoCurso);
	}

	@Test
	public void testDao10() {
		CursoXCertificar curso = (CursoXCertificar) dao.getByPK(
				CursoXCertificar.class, new Long(1));
		System.out.println(curso.getClass().getName());
		Set set = curso.getAlumnos();
		System.out.println(set.getClass().getName());
		for (Iterator it = set.iterator(); it.hasNext();) {
			AlumnoXCertificar alumnoXCertificar = (AlumnoXCertificar) it.next();
			System.out.println(alumnoXCertificar.getId());
		}
	}

	@Test
	public void testDao11() {
		AlumnoXCertificar alumno = (AlumnoXCertificar) dao.getByPK(
				AlumnoXCertificar.class, new Long(5));
		System.out.println(ToStringBuilder.reflectionToString(alumno));
		// System.out.println(ToStringBuilder.reflectionToString(alumno.getCursoXCertificar()));
	}
}

package edu.ienpop.dao

import java.util.Calendar
import java.util.Date
import java.util.HashSet
import java.util.Iterator
import java.util.List
import java.util.Set

import org.apache.commons.lang.builder.ToStringBuilder
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import edu.ienpop.dao.Dao
import edu.ienpop.model.AlumnoXCertificar
import edu.ienpop.model.CatalogoCurso
import edu.ienpop.model.CatalogoPuerto
import edu.ienpop.model.CursoXCertificar
import edu.ienpop.model.Usuario

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=["/DataSourceAppCtx.xml"])
class TestDao1 {

	@Autowired
	Dao dao

	@Test
	void testDao() {
		//List list = dao.getAll("Alumno")
		//for (Iterator it = list.iterator() it.hasNext()) {
		//	Alumno alumno = (Alumno) it.next()
		//	System.out.println(alumno.getIdCurso())
		//	System.out.println(alumno.getNombreCompleto())
		//	System.out.println(alumno.getId())
		//}
	}

	@Test
	void testDao2() {
		//List list = dao.getAll("Curso")
		//for (Iterator it = list.iterator() it.hasNext()) {
		//	Curso curso = (Curso) it.next()
		//	System.out.println(curso.getId())
		//	System.out.println(curso.getIdUsuario())
		//	System.out.println(ToStringBuilder.reflectionToString(curso.getTipoCurso()))
		//}
	}

	@Test
	void testDao3() {
		Usuario usuario = dao.getByPK(Usuario.class, "JUANG")
		println(usuario.getIdUsuario())
		def puertos = usuario.getPuertos()
		if(puertos){
			puertos.each{ puerto ->
				println(puerto.dump())
			}
		}
		println(puertos.getClass().getName())
	}

	@Test
	void testDao4() {
		def list = dao.getAll("CatalogoCurso")
		list.each { catalogoCurso ->
			println(ToStringBuilder.reflectionToString(catalogoCurso))
		}
	}

	@Test
	void testDao5() {
		def list = dao.getAll("CatalogoPuerto")
		list.each { catalogoPuerto ->
			println(ToStringBuilder.reflectionToString(catalogoPuerto))
		}
	}

	@Test
	void testDao6() {
		def nuevoCurso = new CursoXCertificar([idPuerto:"ACG",idTipoCurso:"CAPACO3234",fechaHoraRegistro:new Date(),idUsuario:"JUANG"])
		//nuevoCurso.setIdPuerto("ACG")
		//nuevoCurso.setIdTipoCurso("CAPACO3234")
		//nuevoCurso.setFechaHoraRegistro(new Date())
		//nuevoCurso.setIdUsuario("JUANG")
		Calendar calendar = Calendar.getInstance()
		calendar.set(2007, 6, 10)
		nuevoCurso.setFechaInicio(calendar.getTime())
		nuevoCurso.setIdStatusCurso(1)
		dao.save(nuevoCurso)
		dao.update(nuevoCurso)
	}

	@Test
	void testDao7() {
		AlumnoXCertificar alumnoNuevo = new AlumnoXCertificar()
		alumnoNuevo.setFechaHoraRegistro(new Date())
		alumnoNuevo.setIdCursoXCertificar(2)
		alumnoNuevo.setIdStatusAlumno(1)
		alumnoNuevo.setNombreCompleto("SARA ESPINOSA PEREZ")
		dao.save(alumnoNuevo)
		dao.update(alumnoNuevo)
	}

	@Test
	void testDao8() {
		CursoXCertificar nuevoCurso = new CursoXCertificar()
		nuevoCurso.setIdPuerto("ACG")
		nuevoCurso.setIdTipoCurso("CAPACO3234")
		nuevoCurso.setFechaHoraRegistro(new Date())
		nuevoCurso.setIdUsuario("JUANG")
		Calendar calendar = Calendar.getInstance()
		calendar.set(2007, 6, 10)
		nuevoCurso.setFechaInicio(calendar.getTime())
		nuevoCurso.setIdStatusCurso(1)

		dao.save(nuevoCurso)
		dao.update(nuevoCurso)

	}

	@Test
	void testDao9() {
		CursoXCertificar nuevoCurso = (CursoXCertificar) dao.getByPK(
				CursoXCertificar.class, new Long(7))

		AlumnoXCertificar alumnoNuevo = new AlumnoXCertificar()
		alumnoNuevo.setFechaHoraRegistro(new Date())
		alumnoNuevo.setIdStatusAlumno(1)
		alumnoNuevo.setNombreCompleto("SARA ESPINOSA PEREZ")
		// alumnoNuevo.setCursoXCertificar(nuevoCurso)
		dao.save(alumnoNuevo)
		dao.update(alumnoNuevo)

		AlumnoXCertificar alumnoNuevo2 = new AlumnoXCertificar()
		alumnoNuevo2.setFechaHoraRegistro(new Date())
		alumnoNuevo2.setIdStatusAlumno(1)
		alumnoNuevo2.setNombreCompleto("JUANIS REYES ZU�IGA")
		// alumnoNuevo2.setCursoXCertificar(nuevoCurso)
		dao.save(alumnoNuevo2)
		dao.update(alumnoNuevo2)

		AlumnoXCertificar alumnoNuevo3 = new AlumnoXCertificar()
		alumnoNuevo3.setFechaHoraRegistro(new Date())
		alumnoNuevo3.setIdStatusAlumno(1)
		alumnoNuevo3.setNombreCompleto("CRISTINA REYES ZU�IGA")
		// alumnoNuevo3.setCursoXCertificar(nuevoCurso)
		dao.save(alumnoNuevo3)
		dao.update(alumnoNuevo3)
		Set alumnos = new HashSet()

		// nuevoCurso.getAlumnos().add(alumnoNuevo)
		// nuevoCurso.getAlumnos().add(alumnoNuevo2)
		// nuevoCurso.getAlumnos().add(alumnoNuevo3)
		alumnos.add(alumnoNuevo)
		alumnos.add(alumnoNuevo2)
		alumnos.add(alumnoNuevo3)
		nuevoCurso.setAlumnos(alumnos)

		dao.update(nuevoCurso)
	}

	@Test
	void testDao10() {
		CursoXCertificar curso = (CursoXCertificar) dao.getByPK(CursoXCertificar.class, new Long(1))
		println(curso.getClass().getName())
		def set = curso.getAlumnos()
		println(set.getClass().getName())
		set.each{ alumnoXCertificar ->
			println(alumnoXCertificar.dump())
		}
	}

	@Test
	void testDao11() {
		AlumnoXCertificar alumno = (AlumnoXCertificar) dao.getByPK(AlumnoXCertificar.class, new Long(5))
		println(ToStringBuilder.reflectionToString(alumno))
		// System.out.println(ToStringBuilder.reflectionToString(alumno.getCursoXCertificar()))
	}
}

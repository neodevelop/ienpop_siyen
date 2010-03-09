package edu.ienpop.integration.mail.resources;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.dao.Dao;
import edu.ienpop.integration.mail.MailService;
import edu.ienpop.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=["/mailAppCtx.xml","/DataSourceAppCtx.xml"])
public class TestMailService {

	@Autowired
	MailService mailService;
	@Autowired
	Dao dao;
	
	@Test
	public void testMail(){
		mailService.sendMail("neodevelop@gmail.com", "Mensaje desde la aplicación...");
	}
	
	@Test
	public void testMail2(){
		mailService.sendMimeMail("neodevelop@gmail.com", "Mensaje MIME desde la aplicación...", "Notificación de sistema");
	}
	
	public void _testMail3() throws MessagingException{
		FileSystemResource attach = new FileSystemResource("/home/ubuntu/Documentos/IngenieriaHS/Desarrollo_Empresarial_con_SL_y_OS_v0.1.pdf");
		mailService.sendMailWithAttach("neodevelop@gmail.com", "Mensaje con documento adjunto...", "Notificación de informe", attach);
	}
	
	public void _testMail4() throws MessagingException{
		FileSystemResource attach = new FileSystemResource("/home/ubuntu/Imágenes/carbonite.jpg");
		mailService.sendMailWithInline("neodevelop@gmail.com", "Mensaje con documento adjunto...", "Notificación de informe", attach);
	}
	
	@Test
	public void testMail5() throws MessagingException{
		Usuario usuario = (Usuario)dao.getByPK(Usuario.class, "JUANG");
		System.out.println(usuario);
		Date fecha = GregorianCalendar.getInstance().getTime();
		Map model = new HashMap();
		model.put("usuario", usuario);
		model.put("current",fecha);
		mailService.sendMailWithEngine("neodevelop@gmail.com", model, "Notificación de Acceso", "mail/NotificacionAcceso.ftl");
	}
}

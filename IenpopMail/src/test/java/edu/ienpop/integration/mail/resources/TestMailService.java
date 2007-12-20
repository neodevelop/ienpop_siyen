package edu.ienpop.integration.mail.resources;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.dao.Dao;
import edu.ienpop.integration.mail.MailService;
import edu.ienpop.model.Usuario;

public class TestMailService extends
		AbstractDependencyInjectionSpringContextTests {

	MailService mailService;
	Dao dao;
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"mailAppCtx.xml","DataSourceAppCtx.xml"};
	}
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(mailService==null)
			mailService =(MailService)applicationContext.getBean("mailService");
		if(dao==null)
			 dao = (Dao)applicationContext.getBean("dao");
	}
	
	public void _testMail(){
		mailService.sendMail("jjuan.reyes@synergyj.com", "Mensaje desde la aplicación...");
	}
	
	public void _testMail2(){
		mailService.sendMimeMail("jjuan.reyes@synergyj.com", "Mensaje MIME desde la aplicación...", "Notificación de sistema");
	}
	
	public void _testMail3() throws MessagingException{
		FileSystemResource attach = new FileSystemResource("/home/ubuntu/Documentos/IngenieriaHS/Desarrollo_Empresarial_con_SL_y_OS_v0.1.pdf");
		mailService.sendMailWithAttach("jjuan.reyes@synergyj.com", "Mensaje con documento adjunto...", "Notificación de informe", attach);
	}
	
	public void _testMail4() throws MessagingException{
		FileSystemResource attach = new FileSystemResource("/home/ubuntu/Imágenes/carbonite.jpg");
		mailService.sendMailWithInline("jjuan.reyes@synergyj.com", "Mensaje con documento adjunto...", "Notificación de informe", attach);
	}
	
	@SuppressWarnings("unchecked")
	public void testMail5() throws MessagingException{
		Usuario usuario = (Usuario)dao.getByPK(Usuario.class, "JUANG");
		System.out.println(usuario);
		Date fecha = GregorianCalendar.getInstance().getTime();
		Map model = new HashMap();
		model.put("usuario", usuario);
		model.put("current",fecha);
		mailService.sendMailWithEngine("jjuan.reyes@synergyj.com", model, "Notificación de Acceso", "mail/NotificacionAcceso.ftl");
	}
}

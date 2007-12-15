package edu.ienpop.integration.mail.resources;

import javax.mail.MessagingException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.integration.mail.MailService;

public class TestMailService extends
		AbstractDependencyInjectionSpringContextTests {

	MailService mailService;
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"mailAppCtx.xml"};
	}
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(mailService==null)
			mailService =(MailService)applicationContext.getBean("mailService");
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
	
	public void testMail4() throws MessagingException{
		FileSystemResource attach = new FileSystemResource("/home/ubuntu/Imágenes/carbonite.jpg");
		mailService.sendMailWithInline("jjuan.reyes@synergyj.com", "Mensaje con documento adjunto...", "Notificación de informe", attach);
	}
}

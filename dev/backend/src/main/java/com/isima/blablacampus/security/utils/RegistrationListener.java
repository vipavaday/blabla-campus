package com.isima.blablacampus.security.utils;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.isima.blablacampus.mail.MailBuilder;
import com.isima.blablacampus.security.model.User;
import com.isima.blablacampus.security.services.IUserService;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

	
	@Autowired
    private IUserService userService;
	
	@Autowired
    private MessageSource messages;
  
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private MailBuilder mailBuilder;
    
	
	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		
		this.confirmRegistration(event);
	}
	
	private void confirmRegistration(OnRegistrationCompleteEvent event) {
        
		User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.createVerificationToken(user, token);
         
        String recipientAddress = user.getEmail();
        String subject = messages.getMessage("message.regSuccSubject", null, event.getLocale());;
        String message = messages.getMessage("message.regSucc", null, event.getLocale());
        
        String confirmationUrl = event.getAppUrl() 
        		+ messages.getMessage("message.regActivationUrl", null, event.getLocale()) 
        		+ token;
        
        String confirmationMsg = messages.getMessage("message.regActivationMsg", null, event.getLocale());
         
        MimeMessagePreparator messagePreparator = mimeMessage -> {
        	
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(recipientAddress);
            messageHelper.setSubject(subject);
            messageHelper.setText(mailBuilder.buildRegistrationSuccessMsg(message, confirmationUrl, confirmationMsg), true);
        };

        mailSender.send(messagePreparator);
    }
	
	

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public MessageSource getMessages() {
		return messages;
	}

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public MailBuilder getMailBuilder() {
		return mailBuilder;
	}

	public void setMailBuilder(MailBuilder mailBuilder) {
		this.mailBuilder = mailBuilder;
	}

}

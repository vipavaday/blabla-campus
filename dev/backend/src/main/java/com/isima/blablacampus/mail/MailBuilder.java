package com.isima.blablacampus.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailBuilder {

  private TemplateEngine templateEngine;
  
    @Autowired
    public MailBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

	public String buildRegistrationSuccessMsg(String regSucc, String regActivationUrl, String regActivationMsg) {
		
		Context context = new Context();
        context.setVariable("message", regSucc);
        context.setVariable("activationLink", regActivationUrl);
        context.setVariable("activationLinkMsg", regActivationMsg);
        
        return templateEngine.process("accountActivationMail", context);
	}
}

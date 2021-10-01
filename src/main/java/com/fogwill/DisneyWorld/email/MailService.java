package com.fogwill.DisneyWorld.email;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class MailService {
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);

	public String sendTextEmail(String email) throws IOException {
		// the sender email should be the same as we used to Create a Single Sender
		// Verification
		Email from = new Email("tomasfogwill@gmail.com");
		String subject = "DisneyWorld";
		Email to = new Email(email);
		Content content = new Content("text/plain", "Bienvenido al Maravilloso Mundo de Disney");
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			logger.info(response.getBody());
			return response.getBody();
		} catch (IOException ex) {
			throw ex;
		}
	}
}
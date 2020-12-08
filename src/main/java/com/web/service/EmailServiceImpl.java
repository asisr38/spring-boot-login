package com.web.service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.web.controller.vo.EmailVO;

@Service
public class EmailServiceImpl implements EmailService {
	/*
	 * <dependency> <groupId>org.springframework.boot</groupId>
	 * <artifactId>spring-boot-starter-mail</artifactId> </dependency>
	 */
	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private SpringTemplateEngine springTemplateEngine;

	@Override
	public void sendUpdateRoleEmail(EmailVO emailVO) {
		try {

			MimeMessage message = emailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Context context = new Context();

			Map<String, Object> props = new HashMap<>();
			props.put("name", emailVO.getName());
			props.put("croles", emailVO.getCurrentRoles());
			props.put("nroles", emailVO.getNewRoles());
			props.put("sign", "By Cubic Bank");
			props.put("location", "Fremont CA100 , USA");
			props.put("email", "cubitadmin@gmail.com");
			context.setVariables(props);

			// parsed html template
			String html = springTemplateEngine.process("update-roles-template", context);

			helper.setTo(emailVO.getTo());
			helper.setText(html, true);
			helper.setSubject("Regarding customer roleupdation!!!!");
			helper.setFrom("o03938938@gmail.com", "Cubic Technologies!!");

			// first image
			File file = new ClassPathResource("images/roles.png", EmailServiceImpl.class.getClassLoader()).getFile();
			byte[] bytes = Files.readAllBytes(file.toPath()); // JAVA7 NIO2
			InputStreamSource newImagegeSource = new ByteArrayResource(bytes);
			helper.addInline("cb", newImagegeSource, "image/png");

			// second!
			file = new ClassPathResource("images/team.png", EmailServiceImpl.class.getClassLoader()).getFile();
			bytes = Files.readAllBytes(file.toPath()); // JAVA7 NIO2
			InputStreamSource imageSource = new ByteArrayResource(bytes);
			helper.addInline("team", imageSource, "image/png");

			emailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendUpdatePswdEmail(EmailVO emailVO) {

		try {
			MimeMessage message = emailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_NO,
					StandardCharsets.UTF_8.name());
			String html = "<h2>Hello User, Yout Password has changed!!!</h2><br><p>your OTP is <strong>555555</strong></p>";

			helper.setTo(emailVO.getTo());
			helper.setText(html, true);
			helper.setSubject(emailVO.getSubject());
			helper.setFrom(emailVO.getFrom());

			emailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

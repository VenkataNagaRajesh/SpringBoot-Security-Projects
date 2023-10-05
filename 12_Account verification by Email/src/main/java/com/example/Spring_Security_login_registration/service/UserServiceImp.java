package com.example.Spring_Security_login_registration.service;

import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Spring_Security_login_registration.entity.User;
import com.example.Spring_Security_login_registration.repository.UserRepository;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImp implements userService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	private JavaMailSender mailSender;
	
	@Override
	public User saveUser(User user,String path) {

		String upassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(upassword);
		user.setRole("ROLE_USER");
		user.setEnable(false);
		user.setVerificationCode(UUID.randomUUID().toString());
		User newUser = userRepo.save(user);
		
		if(newUser!=null)
		{
			sendEmail(newUser,upassword);
		}
			
		return newUser;
		
	}

	@Override
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();
		session.removeAttribute("msg");
	}
	
	
	
	 @Override
	    public User findUserByEmail(String email) {
	        return userRepo.findByEmail(email);
	    }

	@Override
	public void sendEmail(User user, String path) {
		
		String from = "gullipallirajesh860@gmail.com";
		String to = user.getEmail();
		String subject = "Account Verification";
		String content = "Dear [[name]],<br>"+" please click the below link to verify"
				+ "<h3><a href=\"[[URL]]\" target\"_self\">VERIFY</a></h3>"
				+ " Thank you	";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			
			helper.setFrom(from," Be Coder");
			helper.setTo(to);
			helper.setSubject(subject);
			
			content = content.replace("[[name]]", user.getName());
			String siteUrl = path + "/verify?code =	"+user.getVerificationCode();
			content = content.replace("[[URL]]", siteUrl);
			helper.setText(content, true);
			mailSender.send(message);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
					
	}

	@Override
	public boolean verifyAccount(String verificationCode) {
		return false;
	}

	 
	 
}

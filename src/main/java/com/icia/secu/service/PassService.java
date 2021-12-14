package com.icia.secu.service;

import com.icia.secu.dao.PassDAO;
import com.icia.secu.dto.PassMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Service
public class PassService {

    @Autowired
    private PassDAO dao;

    @Autowired
    private PasswordEncoder pwEnc;

    @Autowired
    private JavaMailSender mailsender;

    private ModelAndView mav = new ModelAndView();

    public ModelAndView pss(PassMail passmail) {
        // 암호화
        passmail.setPw(pwEnc.encode(passmail.getPw()));
        System.out.println(passmail);

        String uuid = UUID.randomUUID().toString().substring(1,7);

        MimeMessage email = mailsender.createMimeMessage();

        String str = "<h2>안녕하세요. 인천일보 아카데미 입니다.</h2>"
                + "<p>인증번호는 " + uuid + "입니다.";

        try {
            email.setSubject("스프링부트 이메일 인증테스트🐱‍🏍🐱‍🏍");
            email.setText(str, "UTF-8","html");
            email.addRecipient(Message.RecipientType.TO, new InternetAddress(passmail.getMail()));
            mailsender.send(email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        int result = dao.pss(passmail);

        if(result>0){
            mav.setViewName("start2");
        }


        return mav;
    }

    public ModelAndView pss2(PassMail passmail) {

        PassMail pm = dao.pss2(passmail.getMail());

        if (pwEnc.matches(passmail.getPw(), pm.getPw())){
            System.out.println("일치");
            mav.setViewName("index");
        } else {
            System.out.println("불일치");
            mav.setViewName("start2");
        }

        return mav;

    }
}

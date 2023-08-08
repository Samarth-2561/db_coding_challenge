package com.db.schedular;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.db.mail.EmailSenderService;
import com.db.model.Security;
import com.db.model.Trade;
import com.db.model.User;

@Component
public class BondSchedular {
	@Autowired
	private EmailSenderService senderService;

			
	@PersistenceContext
	EntityManager em;
	
	@Scheduled(initialDelay = 10000, fixedDelay = 30000)
	public void checkExpiredBonds() throws MessagingException {
		System.out.println("Runned At: "+ new Date());
		Query q1 = em.createNativeQuery("SELECT users.email, security.issuer, security.maturity_date, security.status, books.book_name, counterparty.name FROM trade inner join bookusers on trade.book_id = bookusers.book_id inner join users on users.id = bookusers.user_id inner join security on security.id = trade.security_id inner join books on books.id = trade.book_id inner join counterparty on trade.counter_party_id = counterparty.id WHERE security_id in (SELECT id FROM security WHERE status= 'not-mature' AND current_date() > maturity_date);");
		List<Object[]> user_data = q1.getResultList();
		for(Object[] i :  user_data) {
			System.out.println(i[0] +" " +i[1]+ " "+ i[2]+ " "+ i[3] +" " + i[4] +" " +i[5] );
		}

	}
	
	
	public void sendMail(String email) {
		try {
			senderService.sendSimpleEmail("thebotop62@gmail.com",
					"This is email body",
					"This is email subject");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

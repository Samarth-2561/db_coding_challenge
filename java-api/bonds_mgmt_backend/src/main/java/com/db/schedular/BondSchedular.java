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
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${spring.mail.username}")
	private String email;

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Scheduled(initialDelay = 20000, fixedDelay = 10000)
	public void checkExpiredBonds() throws MessagingException {
		if(email.length() == 0) {
			return;
		}
		Query q1 = em.createNativeQuery("SELECT users.email, security.issuer, security.maturity_date, security.status, books.book_name, counterparty.name FROM trade inner join bookusers on trade.book_id = bookusers.book_id inner join users on users.id = bookusers.user_id inner join security on security.id = trade.security_id inner join books on books.id = trade.book_id inner join counterparty on trade.counter_party_id = counterparty.id WHERE security_id in (SELECT id FROM security WHERE status= 'not-mature' AND current_date() > maturity_date);");
		List<Object[]> user_data = q1.getResultList();
		for(Object[] i :  user_data) {
			sendMail(i[0],i[1], i[2] , i[4] ,i[5]);
		}
		em.joinTransaction();
		em.createNativeQuery("UPDATE security SET status = 'post-mature' WHERE id in (SELECT id FROM security WHERE status= 'not-mature' AND current_date() > maturity_date);").executeUpdate();
		
	}
	


	public void sendMail(Object email,Object issuer, Object maturity_date, Object book_name, Object counter_party) {
		try {
			senderService.sendSimpleEmail((String) email,
					"Security issued by "+(String)issuer+ " is post matured",
					"Security "+issuer.toString()+ " is post matured \n\n"+
					"Security Information:\n\n"+
				    "Issuer: "+issuer.toString()+"\nMaturity Date: "+maturity_date.toString()+"\nCounter Party: "+counter_party.toString()+"\nBook Name: "+book_name.toString());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

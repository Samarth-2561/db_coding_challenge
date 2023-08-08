/**
 * 
 */
package com.db.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.BookUsers;
import com.db.model.Trade;
import com.db.model.UserData;
import com.db.response.MessageResponse;
import com.db.response.TradeResponse;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/trade")
public class TradeController {
	
	@PersistenceContext
	EntityManager em;
	
	/**
	 * get all trade related to users book id
	 */
	@GetMapping("/getTradeByUserID")
	public MessageResponse getTradeByUserId(@RequestAttribute UserData user_data) {
		
		Query q = em.createNamedQuery("Trade.getTradeByUserID");    
		q.setParameter(1, user_data.getId()); 
		List<Trade> trades = q.getResultList();
        for (Trade i : trades) {
 
            // Print all elements of ArrayList
            System.out.println(i.toString());
        }		
        return new MessageResponse("Hello!");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTradeByID(@PathVariable Long id,@RequestAttribute UserData user_data) {
		Query q = em.createNamedQuery("Trade.getTradeByID"); 
		System.out.println("ID - " + id);
		q.setParameter(1, id); 
		List<Trade> trades = q.getResultList();
		Trade trade = trades.get(0);		
		
		System.out.println(trade.getPrice());
		
        return ResponseEntity
				.ok(new TradeResponse(trade.getPrice(), trade.getQuantity(), trade.getSettlement_date(), 
				trade.getStatus(), trade.getTrade_date(), trade.getTrade_type(), 
				trade.getBook().getBookName(), trade.getCounterParty().getCounterPartyName(), 
				trade.getSecurity().getIssuer()));
	}

}

package com.db.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.User;
import com.db.model.UserData;
import com.db.repository.UserRepository;
import com.db.request.AddSecurityRequest;
import com.db.request.AddTradeRequest;
import com.db.request.LoginRequest;
import com.db.request.SignupRequest;
import com.db.response.JwtResponse;
import com.db.response.MessageResponse;
import com.db.security.jwt.JwtUtils;
import com.db.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PersistenceContext
	EntityManager em;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateuser(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		return ResponseEntity
				.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), userDetails.getRole()));
	}

	@PostMapping("/signup")	
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest, @RequestAttribute UserData user_data) {	
		if(!user_data.getRole().equalsIgnoreCase("admin")) {
			return ResponseEntity.status(401).body(new MessageResponse("Error: username not authorized for this request!"));
		}
		
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getRole());

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("user registered successfully!"));
	}
	
	@Transactional
	@PostMapping("/add_security")	
	public ResponseEntity<?> addSecurity(@RequestBody AddSecurityRequest addSecurityRequest, @RequestAttribute UserData user_data) {	
		if(!user_data.getRole().equalsIgnoreCase("admin")) {
			return ResponseEntity.status(401).body(new MessageResponse("Error: username not authorized for this request!"));
		}
		System.out.println(addSecurityRequest.getMaurityDate());
		em.joinTransaction();
		int q = em.createNamedQuery("Security.addSecurity")
				.setParameter(1, addSecurityRequest.getIssuer())
				.setParameter(2, addSecurityRequest.getMaurityDate()) 
				.setParameter(3, addSecurityRequest.getCoupon())
				.setParameter(4, addSecurityRequest.getType())
				.setParameter(5, addSecurityRequest.getFaceValue())
				.setParameter(6, addSecurityRequest.getStatus()).executeUpdate();
		return ResponseEntity.ok(new MessageResponse("successfully added security!"));
	}
	
	@Transactional
	@PostMapping("/add_trades")	
	public ResponseEntity<?> addTrades(@RequestBody AddTradeRequest addTradeRequest, @RequestAttribute UserData user_data) {	
		if(!user_data.getRole().equalsIgnoreCase("admin")) {
			return ResponseEntity.status(401).body(new MessageResponse("Error: username not authorized for this request!"));
		}
		System.out.println(addTradeRequest.getBookId() + " "
				           + addTradeRequest.getCounterPartyId() + " " + addTradeRequest.getSecurityId() + " " + addTradeRequest.getQuantity() + " "
				           + addTradeRequest.getStatus() + " " + addTradeRequest.getPrice() + " " + addTradeRequest.getTradeType() + " "
				           + addTradeRequest.getTradeDate() + " " + addTradeRequest.getSettlementDate());
		em.joinTransaction();
		int q = em.createNamedQuery("Trade.addTrade")
				.setParameter(1, addTradeRequest.getBookId())
				.setParameter(2, addTradeRequest.getCounterPartyId()) 
				.setParameter(3, addTradeRequest.getSecurityId())
				.setParameter(4, addTradeRequest.getQuantity())
				.setParameter(5, addTradeRequest.getStatus())
				.setParameter(6, addTradeRequest.getPrice())
				.setParameter(7, addTradeRequest.getTradeType())
				.setParameter(8, addTradeRequest.getTradeDate())
				.setParameter(9, addTradeRequest.getSettlementDate())
				.executeUpdate();
		return ResponseEntity.ok(new MessageResponse("successfully added trades!"));
	}
}

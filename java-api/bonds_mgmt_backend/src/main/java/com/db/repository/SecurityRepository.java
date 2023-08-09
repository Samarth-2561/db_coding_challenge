package com.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;


import com.db.model.Security;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long>  {

//	@Query(value = "SELECT * FROM security " +
//            "INNER JOIN bookusers ON trade.book_id = bookusers.book_id " +
//            "INNER JOIN users ON users.id = bookusers.user_id " +
//            "INNER JOIN security ON security.id = trade.security_id " +
//            "INNER JOIN books ON books.id = trade.book_id", 
//    nativeQuery = true)
//	static
//	List<Security> getSecuritiesWithDetails() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
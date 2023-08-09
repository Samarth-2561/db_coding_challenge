/**
 * 
 */
package com.db.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 */

@Entity
@Table(name = "bookusers")
@NamedNativeQueries({

    @NamedNativeQuery(
        name = "BookUsers.findAllBooksWithUsers",
        query =
            "SELECT * FROM bookusers inner join books on bookusers.book_id = books.id inner join users on users.id = bookusers.user_id;", resultClass = BookUsers.class
    ),


    @NamedNativeQuery(
        name = "BookUsers.findAllBooksWithSpecificUsers",
        query =
            "SELECT * FROM bookusers inner join books on bookusers.book_id = books.id inner join users on users.id = bookusers.user_id WHERE users.id = ?;", resultClass = BookUsers.class
    )
})
public class BookUsers {
	
	private @Id @GeneratedValue Long id;
	@OneToOne
    private Books book;
	@OneToOne
    private User user;
	
	public Books getBookDetails() {
		return book;
	}
	
	public User getUserDetails() {
		return user;
	}


}

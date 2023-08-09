package com.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@NamedNativeQueries({

    @NamedNativeQuery(
        name = "Book.findAllBooks",
        query =
            "SELECT * " +
            "FROM books ", resultClass = Books.class
    )
    })
public class Books {
	
	private @Id @GeneratedValue Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String book_name;
	
	public String getBookName() {
		return book_name;
	}
	
	

}
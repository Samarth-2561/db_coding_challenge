CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    role varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS books (
    id INT NOT NULL AUTO_INCREMENT,
    book_Name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS security (
    id INT NOT NULL AUTO_INCREMENT,
    issuer varchar(255) NOT NULL,
    maturity_date DATE NOT NULL,
    coupon BIGINT NOT NULL,
    type varchar(255) NOT NULL,
    face_value BIGINT NOT NULL,
    status ENUM('not-mature','mature', 'post-mature') NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS counterparty (
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS bookusers (
   	id INT NOT NULL AUTO_INCREMENT,
    book_id INT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN key
        (book_id) REFERENCES books (id),
    FOREIGN key
        (user_id) REFERENCES users (id)
);


CREATE TABLE IF NOT EXISTS trade (
   id INT NOT NULL AUTO_INCREMENT,
   book_Id INT NOT NULL,
   counter_party_id INT NOT NULL,
   security_id INT NOT NULL,
   quantity BIGINT NOT NULL,
   status ENUM('success', 'pending', 'failed') NOT NULL,  
   price BIGINT NOT NULL,
   trade_type ENUM('buy','sell') NOT NULL,
   trade_date DATETIME NOT NULL,
   settlement_date DATETIME NULL,
   PRIMARY KEY (id),
   FOREIGN key
       (book_Id) REFERENCES books (id),
   FOREIGN key
       (counter_party_id) REFERENCES counterparty (id),
   FOREIGN key
       (security_id) REFERENCES security (id)
);



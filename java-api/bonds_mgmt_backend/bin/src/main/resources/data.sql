INSERT INTO users (id, username, role, email, password) VALUES (1, 'admin', 'admin','admin@gmail.com','$2a$10$rYc3NTOoXkuItSrEI9navekqajlJ.IS7ZfScu5xYLP..uwvcICvPi');
INSERT INTO users (id, username, role, email, password) VALUES (2, 'user', 'user','user@gmail.com','$2a$10$6Oxx8CREBurd.JZ0KK8mW.hcmZsaCjyC7h/xD4v1z2s1Z5PqeXiMW');

INSERT INTO books (id, book_name) VALUES (1,'test 1');
INSERT INTO books (id, book_name) VALUES (2,'test 2');
INSERT INTO books (id, book_name) VALUES (3,'test 3');

INSERT INTO bookusers (id, book_id, user_id) VALUES (1,1,1);
INSERT INTO bookusers (id, book_id, user_id) VALUES (2,2,2);

INSERT INTO counterparty (id, name) VALUES (1,'DB');
INSERT INTO counterparty (id, name) VALUES (2,'CITI');
INSERT INTO counterparty (id, name) VALUES (3,'HSBC');

INSERT INTO security (id, issuer, maturity_date, coupon, type, face_value, status) VALUES (1,'CITI', '2023-09-04', 100, 'test', 120, 'not-mature');
INSERT INTO security (id, issuer, maturity_date, coupon, type, face_value, status) VALUES (2,'APPL', '2023-10-15', 120, 'test', 220, 'not-mature');

INSERT INTO trade (id, book_id, counter_party_id, security_id, quantity, status, price, trade_type, trade_date, settlement_date) 
VALUES (1,1,2,1, 120, 'pending', 250, 'buy', '2023-08-05 12:12:12', null);

INSERT INTO trade (id, book_id, counter_party_id, security_id, quantity, status, price, trade_type, trade_date, settlement_date) 
VALUES (2,2,2,2, 220, 'success', 350, 'buy', '2023-08-01 12:12:12', '2023-08-04 15:12:12');

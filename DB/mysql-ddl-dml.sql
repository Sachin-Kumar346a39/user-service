CREATE TABLE `user` ( `username` varchar(50) DEFAULT NULL, `admin` bit(1) NOT NULL, `password` varchar(255) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `loan` ( `loan_id` int(11) NOT NULL AUTO_INCREMENT, `address_line_1` varchar(255) NOT NULL, `address_line_2` varchar(255) NOT NULL, `borrower_name` varchar(255) NOT NULL, `city` varchar(255) NOT NULL, `legal_description` varchar(255) NOT NULL, `lien_id` varchar(255) NOT NULL, `lien_type` varchar(255) NOT NULL, `loan_amount` double NOT NULL, `loan_number` varchar(255) NOT NULL, `loan_term` float NOT NULL, `state` varchar(255) NOT NULL, `zip` int(11) NOT NULL, PRIMARY KEY (`loan_id`) ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8


INSERT INTO user (username, password, admin) VALUES ("admin@sw.com", "pass", 1);
INSERT INTO user (username, password, admin) VALUES ("user@sw.com", "pass", 0);
INSERT INTO user (username, password, admin) VALUES ("user123@sw.com", "pass", 0);
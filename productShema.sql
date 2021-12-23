Drop schema if exists products ;
Create Schema products;
Use products;

CREATE TABLE USER ( 
            userId INTEGER auto_increment NOT NULL,
			userName VARCHAR(30) NOT NULL,
            password VARCHAR(30) NOT NULL,
            firstName VARCHAR(30) NOT NULL,
            lastName VARCHAR(30) NOT NULL,
            address VARCHAR(30) NOT NULL,
			phone CHAR(12),
			PRIMARY KEY (userId) );
CREATE TABLE ADMIN ( 
           userId INTEGER auto_increment NOT NULL,
			userName VARCHAR(30) NOT NULL,
            password VARCHAR(30) NOT NULL,
            firstName VARCHAR(30) NOT NULL,
            lastName VARCHAR(30) NOT NULL,
            address VARCHAR(30) NOT NULL,
			phone CHAR(12),
			PRIMARY KEY (userId) );

CREATE TABLE CATEGORY (
			categoryName VARCHAR(30) NOT NULL,
			description VARCHAR(100) ,
			PRIMARY KEY (categoryName)
            );
            
CREATE TABLE PRODUCT ( 
            productId INTEGER auto_increment NOT NULL,
			CategoryName VARCHAR(30) NOT NULL,
            name VARCHAR(30) NOT NULL,
            description VARCHAR(100) NOT NULL,
            price VARCHAR(30) NOT NULL,
            quantity VARCHAR(30) NOT NULL,
			discount CHAR(12),
            image long,
			PRIMARY KEY (productId),
            FOREIGN KEY (categoryName) REFERENCES CATEGORY (categoryName) ON DELETE CASCADE ON UPDATE CASCADE);

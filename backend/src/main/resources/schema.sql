DROP TABLE IF EXISTS user;
CREATE TABLE user (
        id INT AUTO_INCREMENT  PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        password VARCHAR(50) NOT NULL
);


DROP TABLE IF EXISTS Item;
CREATE TABLE Item (
            id INT AUTO_INCREMENT  PRIMARY KEY,
            name VARCHAR(50) NOT NULL,
            price INT NOT NULL
);

DROP TABLE IF EXISTS Order_items;
CREATE TABLE Order_items (
                id INT AUTO_INCREMENT  PRIMARY KEY,
                item_id INT NOT NULL,
                price DOUBLE NOT NULL,
                quantity int NOT NULL ,
                order_id Int NOT NULL
);

DROP TABLE IF EXISTS Order_Table;
CREATE TABLE Order_Table (
        id INT AUTO_INCREMENT  PRIMARY KEY,
        user_id INT NOT NULL,
        total_Price DOUBLE NOT NULL,
        status VARCHAR(50) NOT NULL
);



CREATE DATABASE workshop2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE workshop2;

CREATE TABLE users(
    id INT(11) NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(60) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users(email, username, password) VALUES ('jannowak@gmail.com', 'jan_nowak', 'sssssssss');

SELECT COUNT(id) as size FROM users;

DROP TABLE users;
DELETE FROM users;

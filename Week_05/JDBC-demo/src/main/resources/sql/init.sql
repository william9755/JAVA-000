CREATE DATABASE testdb;

CREATE USER 'testdb_admin'@'localhost' IDENTIFIED BY '123456';

GRANT ALL ON testdb.* to 'testdb_admin'@'localhost';

USE testdb;

CREATE TABLE IF NOT EXISTS `user`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `username` VARCHAR(100) NOT NULL,
   `phone` VARCHAR(50) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
#create database IF NOT EXISTS store;

CREATE TABLE IF NOT EXISTS user (
id INT PRIMARY KEY AUTO_INCREMENT,
email varchar(50),
username varchar(50),
password varchar(50));
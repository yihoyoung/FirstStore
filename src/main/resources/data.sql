#create database IF NOT EXISTS store;

CREATE TABLE IF NOT EXISTS user (
id INT PRIMARY KEY AUTO_INCREMENT,
email varchar(50) not null,
username varchar(50) not null,
password varchar(50) not null);
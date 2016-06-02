create database IF NOT EXISTS store;

CREATE TABLE IF NOT EXISTS user (
user_id INT PRIMARY KEY AUTO_INCREMENT comment '유저ID',
email varchar(50) not null comment 'email',
username varchar(50) not null comment 'username',
password varchar(50) not null comment 'password',
social_id varchar(200) comment 'facebook id'
UNIQUE KEY `user_email_uix`(`email`));

CREATE TABLE IF NOT EXISTS product (
product_id INT PRIMARY KEY AUTO_INCREMENT comment 'product_id',
name varchar(200) not null comment 'name',
price varchar(100) not null comment 'price',
product_type varchar(2) not null comment 'c: camera, a: accessory',
main_image_url varchar(200) not null comment 'main image url',
description text not null
);

CREATE TABLE IF NOT EXISTS product_describe (
describe_id INT PRIMARY KEY AUTO_INCREMENT comment 'describe_id',
product_id INT comment 'product_id',
name varchar(200) not null comment 'name',
image varchar(200) not null comment 'image_url',
describe_text text not null comment 'describe',
describe_url varchar(200) comment 'describe_url'
);

CREATE TABLE IF NOT EXISTS cart (
cart_id int PRIMARY KEY AUTO_INCREMENT comment 'cart_id',
product_id INT comment 'product_id',
user_id varchar(200) not null comment 'user_id'
);


/**
 * 
 * 
insert into product (name, price, product_type, url, descrption) values ('HERO4 BLACK', '679350', 'c', '

*/
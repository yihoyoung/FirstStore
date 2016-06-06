create database IF NOT EXISTS store;

CREATE TABLE IF NOT EXISTS user (
user_id INT PRIMARY KEY AUTO_INCREMENT comment '유저ID',
email varchar(50) not null comment 'email',
username varchar(50) not null comment 'username',
password varchar(50) not null comment 'password',
social_id varchar(200) comment 'facebook id',
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
insert into product (name, price, product_type, main_image_url, description) values ('HERO1 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。1');
insert into product (name, price, product_type, main_image_url, description) values ('HERO2 BLACK', '679360', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。2');
insert into product (name, price, product_type, main_image_url, description) values ('HERO3 BLACK', '679370', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。3');
insert into product (name, price, product_type, main_image_url, description) values ('HERO4 BLACK', '679380', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。4');
insert into product (name, price, product_type, main_image_url, description) values ('HERO5 BLACK', '679900', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。5');
insert into product (name, price, product_type, main_image_url, description) values ('HERO6 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。6');
insert into product (name, price, product_type, main_image_url, description) values ('HERO7 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。7');
insert into product (name, price, product_type, main_image_url, description) values ('HERO8 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。8');
insert into product (name, price, product_type, main_image_url, description) values ('HERO9 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。9');
insert into product (name, price, product_type, main_image_url, description) values ('HER10 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。10');
insert into product (name, price, product_type, main_image_url, description) values ('HER11 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。11');
insert into product (name, price, product_type, main_image_url, description) values ('HER12 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。12');
insert into product (name, price, product_type, main_image_url, description) values ('HER13 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。13');
insert into product (name, price, product_type, main_image_url, description) values ('HER14 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。14');
insert into product (name, price, product_type, main_image_url, description) values ('HER15 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。15');
insert into product (name, price, product_type, main_image_url, description) values ('HER16 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。16');
insert into product (name, price, product_type, main_image_url, description) values ('HER17 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。17');
insert into product (name, price, product_type, main_image_url, description) values ('HER18 BLACK', '679350', 'c', 'http://demandware.edgesuite.net/aavy_prd/on/demandware.static/-/Library-Sites-sharedGoProLibrary/default/dwda24e33c/images/new-homepage/Hero4Silver_Masthead_main.jpg','专业视频及照片品质，外加强大的功能，足以捕捉和分享您的世界。18');

*/
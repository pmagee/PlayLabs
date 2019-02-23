# --- !Ups
delete from user;

insert into user (email,name,password,role) values ( 'admin@products.com', 'Alice Admin', 'password', 'admin' );

insert into user (email,name,password,role) values ( 'manager@products.com', 'Bob Manager', 'password', 'manager' );

insert into user (email,name,password,role) values ( 'customer@products.com', 'Charlie Customer', 'password', 'customer' );
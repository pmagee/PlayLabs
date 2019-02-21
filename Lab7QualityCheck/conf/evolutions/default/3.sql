# --- !Ups
delete from user;

insert into user (type,email,name,password,role) values ( 'a','admin@ofm.com', 'Alice Admin', 'password', 'admin' );


insert into role (id, name) values(1, 'ADMIN');
insert into role (id, name) values(2, 'USER');
insert into role (id, name) values(3, 'PREMIUM');
insert into role (id, name) values(4, 'PREMIUM_PLUS');

insert into user (id, firstname, lastname, login, password, email, phone_number, gender, birthday, creating_account_date) values (1000, 'Jan','Kowalski','admin','$2a$10$csIVj5k8CB74npTTstUQuO3ObjmaM6y8cRMxvsKqpHmT3zNQxY/IK','Kowal99@gmail.com',544234324,'Male','2010-02-01', '2022-05-01');
insert into user (id, firstname, lastname, login, password, email, phone_number, gender, birthday, creating_account_date) values (1001, 'Janina','Nowak','user','$2a$10$csIVj5k8CB74npTTstUQuO3ObjmaM6y8cRMxvsKqpHmT3zNQxY/IK','Kowal99@gmail.com',544234324,'Female','2002-02-01', '2022-05-12');
insert into user (id, firstname, lastname, login, password, email, phone_number, gender, birthday, creating_account_date) values (1002, 'Paweł','Kot','premium','$2a$10$csIVj5k8CB74npTTstUQuO3ObjmaM6y8cRMxvsKqpHmT3zNQxY/IK','Kowal99@gmail.com',544234324,'No_Binary','1988-02-01', '2021-04-22');
insert into user (id, firstname, lastname, login, password, email, phone_number, gender, birthday, creating_account_date) values (1003, 'Ola','Sas','premiumplus','$2a$10$csIVj5k8CB74npTTstUQuO3ObjmaM6y8cRMxvsKqpHmT3zNQxY/IK','Kowal99@gmail.com',544234324,'Male','1966-02-01', '2020-03-27');

insert into user_role (user_id, role_id) values(1000,1);
insert into user_role (user_id, role_id) values(1001,2);
insert into user_role (user_id, role_id) values(1002,3);
insert into user_role (user_id, role_id) values(1003,4);
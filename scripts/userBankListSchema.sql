create table user
(
   id int not null auto_increment,
   name varchar (45) not null,
   surname varchar (45) not null,
   primary key (id)
);

create table account
(
   id int not null auto_increment,
   account int not null,
   user_id int not null,
   primary key (id),
   constraint fk_account foreign key (user_id) references user (id)
);
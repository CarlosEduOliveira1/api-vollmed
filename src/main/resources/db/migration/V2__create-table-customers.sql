create table customers(
   id bigint not null auto_increment,
   name varchar(100) not null,
   email varchar(100) not null unique,
   phone varchar(20),
   birthdate date not null,
   gender varchar(2) not null,
   street  varchar(100) not null,
   neighbourhood varchar(100) not null,
   postcode varchar(100) not null,
   city varchar(100) not null,
   uf varchar(2) not null,
   number varchar(100),
   complement varchar(100) not null,

   primary key(id)

);
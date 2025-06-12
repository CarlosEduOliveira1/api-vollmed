create table doctors(
   id bigint not null auto_increment,
   name varchar(100) not null,
   email varchar(100) not null unique,
   crm varchar(6) not null unique,
   specialty varchar(100) not null,
   phone varchar(20),
   street  varchar(100) not null,
   neighbourhood varchar(100) not null,
   postcode varchar(100) not null,
   city varchar(100) not null,
   uf varchar(2) not null,
   number varchar(100),
   complement varchar(100) not null,

   primary key(id)

);
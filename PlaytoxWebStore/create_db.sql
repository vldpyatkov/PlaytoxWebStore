create database webstore;
use webstore;
create table if not exists Users ( 
  login varchar(30) not null unique key,
  id integer not null primary key auto_increment,
  password not null char(32)
);

create table if not exists Roles (
  role varchar(30) not null unique key,
  id integer not null primary key auto_increment
);
create table if not exists UserInRoles ( 
  role_id integer not null,
  user_id integer not null,
  constraint fk_userinrole_role foreign key (role_id) references Roles(id),
  constraint fk_userinrole_user foreign key (user_id) references Users(id),
  primary key (role_id, user_id)
);

insert into roles (role) values ('manager')
insert into roles (role) values ('client')

DELIMITER $$
DROP PROCEDURE IF EXISTS create_client;
create procedure create_client (
  in login varchar(30),
  in password varchar(30),
  in role varchar(30)
)
BEGIN
  DECLARE user_id INT DEFAULT 0;
  DECLARE role_id INT DEFAULT 0;
  DECLARE EXIT HANDLER FOR SQLEXCEPTION 
  BEGIN
    ROLLBACK; 
  END;
  START TRANSACTION;
  
  INSERT INTO users (
    `login`,
	`password`
  ) values (
    login,
	md5(password)
  );
  
  select id into role_id from roles where `role` = role;
  select id into user_id from users where `login` = login;
  
  insert into userinroles (
    `user_id`,
	`role_id`
  ) values (
    user_id,
	role_id
  );
  
  COMMIT;
END;
$$ DELIMITER;


create table id_table (
         pk varchar(255),
         value int4
    );

    insert into id_table values ("app_users", 2);
    insert into id_table values ("app_products", 2);
    insert into id_table values ("app_purchase", 2);



create table if not exists UserInRoles (
  role_id integer not null,
  user_id integer not null,
  constraint fk_userinrole_role foreign key (role_id) references Roles(id),
  constraint fk_userinrole_user foreign key (user_id) references Users(id),
  primary key (role_id, user_id)
);

create table if not exists Roles (
  role varchar(30) not null unique key,
  id integer not null primary key auto_increment
);

create table if not exists products (
  id integer not null primary key auto_increment,
  title varchar(30) not null,
  description varchar(300),
  price decimal(18,4) not null,
  quantity integer
);

create table if not exists purchase (
  id integer not null primary key auto_increment,
  user_id integer not null,
  product_id integer not null,
  purchase_date datetime not null,
  price decimal(18,4) not null,
  constraint fk_purchase_product foreign key (product_id) references products(id),
  constraint fk_purchase_user foreign key (user_id) references users(id)
);

insert into products values (3, "Неваляшка", "Ля-ля Ля", 206.5, 4)



create table User(
      id mediumint not null auto_increment,
      name char(30) not null,
      email char(40) not null,
      password char(30) not null,
      role ENUM('ADMIN', 'USER'),
      primary key (id)
);
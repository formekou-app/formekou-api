CREATE TABLE IF NOT EXIST  user(
    id varchar(250) primary key,
    name varchar(250) not null,
    first_name varchar(250),
    email varchar(50),
    password varchar(50)
);
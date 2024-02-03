CREATE TABLE IF NOT EXIST  "user"(
    id varchar(255) primary key,
    name varchar(255) not null,
    first_name varchar(250),
    email varchar(255) not null,
    password varchar(50)
);
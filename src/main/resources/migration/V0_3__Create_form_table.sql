CREATE DATABASE form(
    id varchar(250) primary key,
    title varchar(250) not null,
    description varchar(250),
    visibility varchar (250),
    created_at datetime,
    updated_at datetime,
    open_at datetime,
    close_at datetime,
    id varchar(250) REFERENCES user(id)
);
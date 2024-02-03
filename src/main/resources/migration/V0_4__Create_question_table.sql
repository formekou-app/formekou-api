CREATE DATABASE question(
    id varchar(250) primary key,
    order int,
    content text,
    required bool,
    id varchar(250) REFERENCES form(id),
    id varchar(250) REFERENCES question_type(id)
);
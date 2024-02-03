CREATE TABLE IF NOT EXIST "question_type"(
    id varchar(255) primary key,
    type varchar(200) not null ,
    description text
);
CREATE TABLE IF NOT EXIST "reply"(
    id varchar(255) primary key,
    user_id varchar(255) REFERENCES "user"(id) not null,
    form_id varchar(255) REFERENCES "form"(id) not null 
);

CREATE TABLE IF NOT EXIST "form"(
    id varchar(255) primary key,
    title varchar(250) not null,
    description varchar(250),
    visibility varchar (250),
    created_at timestamp,
    updated_at timestamp,
    open_at timestamp,
    close_at timestamp,
    user_id varchar(250) REFERENCES user(id)
);
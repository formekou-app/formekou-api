CREATE TABLE IF NOT EXIST "form"(
    id varchar(255) primary key,
    title varchar(250) not null,
    description text,
    visibility varchar (250) not null,
    created_at timestampz not null,
    updated_at timestampz not null,
    open_at timestampz not null,
    close_at timestampz not null,
    user_id varchar(255) REFERENCES "user"(id) not null
);
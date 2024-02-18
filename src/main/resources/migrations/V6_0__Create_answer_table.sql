create table if not exists "answer"(
    id varchar(255) primary key,
    value varchar(255) not null,
    created_at timestamp default current_timestamp not null,
    updated_at timestamp default current_timestamp not null,
    id_user varchar(255) references "user"(id) not null,
    id_question varchar(255) references "user"(id) not null
);
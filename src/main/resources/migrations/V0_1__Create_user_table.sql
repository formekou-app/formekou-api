create table if not exists "user"(
    id varchar(255) primary key,
    last_name varchar(255) not null,
    first_name varchar(255),
    email varchar(255) not null
);

create index if not exists idx_email_user on "user"(email);

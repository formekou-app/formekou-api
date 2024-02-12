create table if not exists "form"(
    id varchar(255) primary key,
    title text not null,
    description text,
    color varchar(7) not null,
    opened_at timestamptz default current_timestamp not null,
    closed_at timestamptz,
    is_private bool default false not null,
    allow_multiple_response bool default false not null,
    id_user varchar(255) references "user"(id) not null
);
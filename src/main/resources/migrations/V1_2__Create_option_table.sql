create table if not exists "option"(
    id varchar(255) primary key,
    value text not null,
    is_correct bool default false not null,
    points int default 0 not null,
    id_question varchar(255) references "question"(id) not null
);

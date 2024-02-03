CREATE TABLE IF NOT EXIST "question"(
    id varchar(255) primary key,
    order int not null,
    content text,
    required bool not null,
    description text,
    form_id varchar(255) REFERENCES "form"(id) not null,
    question_type_id varchar(255) REFERENCES "question_type"(id) not null
);
CREATE TABLE IF NOT EXIST "question"(
    id varchar(255) primary key,
    order int,
    content text,
    required bool,
    form_id varchar(250) REFERENCES form(id),
    question_type_id varchar(250) REFERENCES question_type(id)
);
CREATE TABLE IF NOT EXIST "answer"(
    id varchar(255) primary key,
    content text not null,
    description text,
    question_id varchar(255) REFERENCES "question"(id) not null
);
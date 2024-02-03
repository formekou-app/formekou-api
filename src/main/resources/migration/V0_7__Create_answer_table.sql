CREATE TABLE IF NOT EXIST "answer"(
    id varchar(255) primary key,
    content varchar(250),
    description varchar(250),
    question_id varchar(250) REFERENCES question(id)
);
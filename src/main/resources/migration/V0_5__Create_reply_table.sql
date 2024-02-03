CREATE TABLE IF NOT EXIST "reply"(
    user_id varchar(255) REFERENCES user(id),
    form_id varchar(255) REFERENCES form(id)
);

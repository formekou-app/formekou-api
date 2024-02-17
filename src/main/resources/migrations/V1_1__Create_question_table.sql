do
$$
    begin
        if not exists(select from pg_type where typname = 'question_type') then
            create type "question_type" as enum (
                'RADIO',
                'CHECKBOX',
                'TEXT',
                'PARAGRAPH',
                'NUMBER'
            );
        end if;
    end
$$;

create table if not exists "question"(
    id varchar(255) primary key,
    title text not null,
    description text,
    is_required bool default false not null,
    type question_type not null,
    points int default 0 not null,
    id_form varchar(255) references "form"(id)
);
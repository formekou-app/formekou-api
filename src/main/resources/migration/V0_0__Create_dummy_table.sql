create table if not exists "dummy" (
    id varchar primary key,
    name varchar not null
);

INSERT INTO "dummy" ("id", "name")
VALUES
    ('dummy_id1', 'my_dummy_table_1'),
    ('dummy_id2', 'my_dummy_table_2'),
    ('dummy_id3', 'my_dummy_table_3')
ON CONFLICT ("id") DO NOTHING;
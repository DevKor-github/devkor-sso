create table Users
(
    uid uuid primary key,
    password varchar,
    name varchar(200) not null,
    KUPID_email varchar not null unique
)
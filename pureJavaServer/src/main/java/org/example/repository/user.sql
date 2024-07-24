create table users
(
    id   varchar(128) primary key not null,
    name varchar(128)             not null,
    age  int
);

insert into user(id, name, age)
values ('a317e707-cd04-4a0c-b93a-37eef1d81151', 'John', 22),
       ('a317e707-cd04-4a0c-b93a-37eef1d81152', 'Tiranosaur', 33),
       ('a317e707-cd04-4a0c-b93a-37eef1d81153', 'Korob', 44);
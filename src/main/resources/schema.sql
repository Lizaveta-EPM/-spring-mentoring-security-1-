create table users (
    username varchar_ignorecase(50) not null,
    password varchar_ignorecase(500) not null,
    authority varchar_ignorecase(50) not null,
    enabled boolean not null default true,
    constraint pk_user primary key (username)
);
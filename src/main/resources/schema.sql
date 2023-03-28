create table users (
    username varchar(50) not null,
    password varchar(500) not null,
    enabled boolean not null,
    constraint pk_user primary key (username)
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);


create table secret (
    id bigint not null,
    content varchar not null,
    link varchar not null,
    created_at TIMESTAMP not null,
    constraint pk_secret primary key (id)
);

create index ix_auth_username on authorities (username, authority);
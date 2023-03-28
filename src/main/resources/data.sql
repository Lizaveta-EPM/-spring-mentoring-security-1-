insert into users(username, password, enabled)
values  ('user', 'c0dddcb17cc847c3972c867c3014107c68e780351506c2f33d125e04b080e620521b2fb45dc18bb4', true);

insert into authorities(username, authority)
values ('user', 'ROLE_STANDARD');
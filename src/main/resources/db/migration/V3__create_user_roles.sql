create table if not exists users_roles
(
    user_id int       not null,
    role    varchar(255) not null,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references Users (id) on delete cascade on update no action
);
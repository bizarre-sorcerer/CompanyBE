create table employees
(
    id                             uuid primary key ,
    first_name                     varchar(255),
    last_name                      varchar(255),
    email                          varchar(255),
    department                     varchar(255),
    skill_level                    varchar(255),
    role                           varchar(255),
    experience                     varchar(255),
    salary                         varchar(255)
);

create table departments
(
    id   uuid primary key,
    department_name     varchar(255)
)
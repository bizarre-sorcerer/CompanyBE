-- noinspection SqlCurrentSchemaInspectionForFile

create table if not exists departments(
    id                              bigint primary key,
    department_name                 varchar(255)
);

create table if not exists positions(
    id                              bigint primary key,
    job_title                       varchar(255)
);

create table if not exists qualification(
    id                              bigint primary key,
    qualification                   varchar(255),
    salary                          varchar(255)
);

create table if not exists employees(
    id                              bigint primary key,
    first_name                      varchar(255),
    last_name                       varchar(255),
    email                           varchar(255),
    phone_number                    varchar(255),
    password                        varchar(255),
    department_id                   bigint references departments(id),
    position_id                     bigint references positions(id),
    qualification                   bigint references qualification(id),
    experience                      varchar(255),
    salary                          varchar(255)
);

create table if not exists roles(
    id                              bigint primary key,
    role                            varchar(255)
);

create table if not exists employee_roles(
    employee_id                     bigint references employees(id),
    role_id                         bigint references roles(id)
);

create sequence if not exists all_sequence;

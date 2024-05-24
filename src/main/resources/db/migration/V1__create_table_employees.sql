-- noinspection SqlCurrentSchemaInspectionForFile

create table if not exists departments(
    id                              integer primary key,
    department_name                 varchar(255)
);

create table if not exists positions(
    id                              integer primary key,
    job_title                       varchar(255)
);

create table if not exists qualification(
    id                              integer primary key,
    qualification                   varchar(255),
    salary                          varchar(255)
);

create table if not exists employees(
    id                              integer primary key,
    first_name                      varchar(255),
    last_name                       varchar(255),
    email                           varchar(255),
    department_id                   integer references departments(id),
    position_id                     integer references positions(id),
    qualification                   integer references qualification(id),
    experience                      varchar(255),
    salary                          varchar(255)
);

create sequence if not exists departments_seq;
create sequence if not exists positions;
create sequence if not exists qualification;
create sequence if not exists employees_seq;

-- noinspection SqlCurrentSchemaInspectionForFile

create table if not exists departments(
    id                              integer primary key,
    department_name                 varchar(255)
);

create table if not exists position(
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
    role                            integer references position(id),
    qualification                   integer references qualification(id),
    experience                      varchar(255),
    salary                          varchar(255) references qualification(salary)
);

create table if not exists psychlogical_evaluation(
    id                              integer primary key,
    employee                        integer references employees(id),
    evaluation                      varchar(255)
);

create table if not exists projects(
    id                              integer primary key,
    project_name                    varchar(255),
    start_data                      varchar(255),
    deadline_data                   varchar(255),
    responsible_team                varchar(255),
    budget                          varchar(255)
);

create table if not exists teams(
    id                              integer primary key,
    team_name                       varchar(255),
    team_lead                       integer
);

create table if not exists team_membership(
    team_id                         integer,
    employee_id                     integer,
    primary key (team_id, employee_id),
    foreign key (team_id) references teams(id),
    foreign key (employee_id) references employees(id)
);

create table if not exists tasks(
    id                              integer primary key,
    task_name                       varchar(255),
    responsible_employee            varchar(255),
    start_date                      varchar(255),
    deadline_date                   varchar(255)
);

create table if not exists project_attachments(
    id                              integer primary key,
    attachment                      varchar(255),
    attached_by                     varchar(255)
);

CREATE SEQUENCE departments_seq;
CREATE SEQUENCE employees_seq;

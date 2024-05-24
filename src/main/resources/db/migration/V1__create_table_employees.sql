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

create table if not exists evaluations(
    id                              integer primary key,
    employee                        integer references employees(id),
    evaluation                      varchar(255)
);

create table if not exists teams(
    id                              integer primary key,
    team_name                       varchar(255),
    team_lead                       integer references employees(id)
);

create table if not exists team_membership(
    id                   integer primary key,
    employee_id                     integer references employees(id),
    team_id                         integer references teams(id)
);

create table if not exists projects(
    id                              integer primary key,
    project_name                    varchar(255),
    start_date                      varchar(255),
    deadline_date                   varchar(255),
    responsible_team                integer references teams(id),
    budget                          varchar(255)
);

create table if not exists tasks(
    id                              integer primary key,
    task_name                       varchar(255),
    part_of_project                         integer references projects(id),
    responsible_employee            integer references employees(id),
    start_date                      varchar(255),
    deadline_date                   varchar(255)
);

create table if not exists project_attachments(
    id                              integer primary key,
    attachment                      varchar(255),
    attachet_to                     integer references projects(id),
    attached_by                     integer references employees(id)
);

create sequence if not exists departments_seq;
create sequence if not exists positions;
create sequence if not exists qualification;
create sequence if not exists employees_seq;
create sequence if not exists psychological_evaluation;
create sequence if not exists teams;
create sequence if not exists team_membership;
create sequence if not exists projects;
create sequence if not exists tasks;
create sequence if not exists project_attachments

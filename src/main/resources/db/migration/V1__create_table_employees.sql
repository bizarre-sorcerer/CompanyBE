create table employees(
    id                              uuid primary key ,
    first_name                      varchar(255),
    last_name                       varchar(255),
    email                           varchar(255),
    department                      varchar(255),
    skill_level                     varchar(255),
    role                            varchar(255),
    experience                      varchar(255),
    salary                          varchar(255)
);

create table departments(
    id                              uuid primary key,
    department_name     varchar(255)
);

create table roles(
    id                              uuid,
    job_title                       varchar(255)
);

create table tech_stack(
    id                              uuid,
    stack                           varchar(255)
);

create table salaries(
    id                              uuid,
    salarie                       varchar(255)
);

create table projects(
    id                              uuid,
    project_name                    varchar(255),
    start_data                      varchar(255),
    deadline_data                   varchar(255),
    responsible_team                varchar(255),
    budget                          varchar(255)
);

create table tasks(
    id                              uuid,
    task_name                       varchar(255),
    responsible_employee            varchar(255),
    start_date                      varchar(255),
    deadline_date                   varchar(255)
);

create table budgets(
    id                              uuid,
    budget                          varchar(255)
);

create table project_attachments(
    id                              uuid,
    attachment                      varchar(255),
    attached_by                     varchar(255)
)
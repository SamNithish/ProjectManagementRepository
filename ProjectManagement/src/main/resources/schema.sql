CREATE SEQUENCE IF NOT EXISTS employee_seq;

CREATE TABLE IF NOT EXISTS employee (

emp_id BIGINT NOT NULL DEFAULT nextval('employee_seq') PRIMARY KEY,
email VARCHAR(100) NOT NULL,
name VARCHAR(100) NOT NULL


);

CREATE SEQUENCE IF NOT EXISTS project_seq;

CREATE TABLE IF NOT EXISTS project (

proj_id BIGINT NOT NULL DEFAULT nextval('project_seq') PRIMARY KEY,
name VARCHAR(100) NOT NULL,
stage VARCHAR(100) NOT NULL,
start_date date NOT NULL,
end_date date NOT NULL


);


CREATE TABLE IF NOT EXISTS project_employee (

proj_id BIGINT REFERENCES project, 
emp_id BIGINT REFERENCES employee

);

CREATE SEQUENCE IF NOT EXISTS user_accounts_seq;

create table users(
	username varchar(50) not null primary key,
	password varchar(500) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

insert into authorities (username,authority) values ('SamAdmin','ROLE_ADMIN');
insert into authorities (username,authority) values ('SamUser','ROLE_USER');
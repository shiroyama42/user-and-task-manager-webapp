CREATE TABLE roles(
	id INT NOT NULL auto_increment primary key,
    name VARCHAR(250)
);

CREATE TABLE department(
	id INT NOT NULL auto_increment primary key,
    name VARCHAR(250)
);

CREATE TABLE task(
	id INT NOT NULL auto_increment primary key,
    task VARCHAR(500),
    end_date DATE
);

CREATE TABLE users(
	id INT NOT NULL auto_increment primary key,
    name VARCHAR(250),
    email_address VARCHAR(250) UNIQUE,
    password VARCHAR(250),
    birth_date DATE,
    phone VARCHAR(20),
    role_id INT NOT NULL,
    dep_id INT NOT NULL,
    constraint FK_users_role_id foreign key (role_id) references roles(id),
    constraint FK_users_dep_id foreign key (dep_id) references department(id)
);

CREATE TABLE user_task(
	user_id INT NOT NULL,
    task_id INT NOT NULL,
    start_date DATE,
    primary key(user_id, task_id),
    constraint FK_usertask_user_id foreign key (user_id) references users(id),
    constraint FK_usertask_task_id foreign key (task_id) references task(id)
);
CREATE TABLE task_list (
    id int primary key not null auto_increment,
    task_id int not null REFERENCES task (id),
    posicao int not null
);
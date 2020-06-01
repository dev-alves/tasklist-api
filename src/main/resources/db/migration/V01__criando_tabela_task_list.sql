CREATE TABLE task (
    id integer primary key auto_increment,
    titulo varchar(50) not null,
    status int not null,
    descricao text not null,
    data_criacao date,
    data_edicao date,
    data_remocao date,
    data_conclusao date,
    data_final date
);
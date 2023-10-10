create table usuarios(

    id serial not null,
    nome varchar(100) not NULL,
    email varchar(100) not null,
    senha varchar(255) not null,

    primary key(id)

);
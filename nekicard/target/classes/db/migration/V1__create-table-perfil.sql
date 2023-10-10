    create table perfil(

    id serial not null,
    email varchar(100) not null unique,
    nome_completo varchar(100) not null,
    nome_social varchar(100),
    data_nasc date not null,
    foto varchar(255) not null,
    telefone varchar(100),
    linkedin varchar(100),
    github varchar(100),
    instagram varchar(100),
    facebook varchar(100),

    primary key(id)

);
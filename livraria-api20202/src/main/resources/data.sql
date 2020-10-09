insert into tb_livros(livro_id, titulo, data_publicacao, numero_paginas, preco) values (1,'Sobre Mouses e Homens', '1954-11-08', 100, 11.00);
insert into tb_livros(livro_id, titulo, data_publicacao, numero_paginas, preco) values (2,'Um Estranho no Ninho', '1973-11-08', 200, 15.00);
insert into tb_livros(livro_id, titulo, data_publicacao, numero_paginas, preco) values (3,'Por Quem os Sinos Dobram', '1932-11-08', 100, 13.00);
insert into tb_livros(livro_id, titulo, data_publicacao, numero_paginas, preco) values (4,'Guerra e Paz', '1955-11-08', 140, 15.00);
insert into tb_livros(livro_id, titulo, data_publicacao, numero_paginas, preco) values (5,'As Vinhas da Ira', '1955-11-08', 300, 16.00);
insert into tb_livros(livro_id, titulo, data_publicacao, numero_paginas, preco) values (6,'Padrões de Design', '1996-11-08', 180, 14.00);
insert into tb_livros(livro_id, titulo, data_publicacao, numero_paginas, preco) values (7,'Um Conto de Duas Cidades', '1943-11-08', 400, 15.00);

insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(1, 'Campus', 'Rio de Janeiro', 2000);
insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(2, 'Saraiva', 'São Paulo', 1950);
insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(3, 'Moderna', 'Rio de Janeiro', 1964);
insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(4, 'Bookman', 'Florianópolis', 2002);
insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(5, 'Atlas', 'Porto Alegre', 1994);
insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(6, 'Pearson', 'São Paulo', 2010);

insert into tb_autores(autor_id, nome, pais) values (1,'Orson Welles', 'Inglaterra');
insert into tb_autores(autor_id, nome, pais) values (2,'Aldous Huxley', 'Inglaterra');
insert into tb_autores(autor_id, nome, pais) values (3,'Leo Tolstoi', 'Rússia');
insert into tb_autores(autor_id, nome, pais) values (4,'Sérgio Iudicibus', 'Brasil');
insert into tb_autores(autor_id, nome, pais) values (5,'Harvey Deitel', 'Estados Unidos');
insert into tb_autores(autor_id, nome, pais) values (6,'Paul Deitel', 'Estados Unidos');

insert into tb_livros_autores(autores_autor_id, livros_livro_id) values (1, 1);
insert into tb_livros_autores(autores_autor_id, livros_livro_id) values (2, 2);
insert into tb_livros_autores(autores_autor_id, livros_livro_id) values (3, 4);
insert into tb_livros_autores(autores_autor_id, livros_livro_id) values (4, 5);
insert into tb_livros_autores(autores_autor_id, livros_livro_id) values (5, 3);
insert into tb_livros_autores(autores_autor_id, livros_livro_id) values (6, 3);

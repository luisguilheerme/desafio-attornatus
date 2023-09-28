INSERT INTO tb_pessoa(nome, data_nascimento) VALUES ('Maria', TIMESTAMP WITH TIME ZONE '2001-07-25T13:00:00Z');
INSERT INTO tb_pessoa(nome, data_nascimento) VALUES ('João', TIMESTAMP WITH TIME ZONE '1998-06-22T13:00:00Z');
INSERT INTO tb_pessoa(nome, data_nascimento) VALUES ('José', TIMESTAMP WITH TIME ZONE '2000-01-05T13:00:00Z');
INSERT INTO tb_pessoa(nome, data_nascimento) VALUES ('Pedro', TIMESTAMP WITH TIME ZONE '1989-07-02T13:00:00Z');
INSERT INTO tb_pessoa(nome, data_nascimento) VALUES ('Rosa', TIMESTAMP WITH TIME ZONE '1981-05-11T13:00:00Z');
INSERT INTO tb_pessoa(nome, data_nascimento) VALUES ('Artur', TIMESTAMP WITH TIME ZONE '1990-01-02T13:00:00Z');
INSERT INTO tb_pessoa(nome, data_nascimento) VALUES ('Sebastiana', TIMESTAMP WITH TIME ZONE '1975-04-05T13:00:00Z');


INSERT INTO tb_endereco(logradouro,numero,cep,cidade,pessoa_id,endereco_principal) values('Rua das Palmeiras','20','1111111','Rio de Janeiro',1,true)
INSERT INTO tb_endereco(logradouro,numero,cep,cidade,pessoa_id,endereco_principal) values('Rua Projetada 10','11','2222222','Salvador',2,true)
INSERT INTO tb_endereco(logradouro,numero,cep,cidade,pessoa_id,endereco_principal) values('Rua das Alamedas','390','1111222','Rio de Janeiro',1,false)
INSERT INTO tb_endereco(logradouro,numero,cep,cidade,pessoa_id,endereco_principal) values('Rua Sem Nome','945','0000000','Florianópolis',3,true)
INSERT INTO tb_endereco(logradouro,numero,cep,cidade,pessoa_id,endereco_principal) values('Rua Escondida','210','2121212','Curitiba',4,true)
INSERT INTO tb_endereco(logradouro,numero,cep,cidade,pessoa_id,endereco_principal) values('Rua Projetada 2','30','5151515','São Paulo',5,true)
INSERT INTO tb_endereco(logradouro,numero,cep,cidade,pessoa_id,endereco_principal) values('Rua Capitao Caverna','180','3333333','Brasilia',6,true)
INSERT INTO tb_endereco(logradouro,numero,cep,cidade,pessoa_id,endereco_principal) values('Rua Infinito','120','8484844','Rio de Janeiro',7,true)
INSERT INTO tb_endereco(logradouro,numero,cep,cidade,pessoa_id,endereco_principal) values('Rua Quinze','450','2626262','Curitiba',4,false)

INSERT INTO DEPARTAMENTO(nome, numero, orcamento, dtini, dtfim) VALUES('Tecnologia', '100', '11000', '2020-01-01', '2020-12-31');
INSERT INTO DEPARTAMENTO(nome, numero, orcamento, dtini, dtfim) VALUES('Logística', '200', '5000', '2020-01-01', '2020-12-31');
INSERT INTO DEPARTAMENTO(nome, numero, orcamento, dtini, dtfim) VALUES('Vendas', '300', '17000', '2020-01-01', '2020-12-31');
INSERT INTO DEPARTAMENTO(nome, numero, orcamento, dtini, dtfim) VALUES('Backoffice', '400', '19000', '2020-01-01', '2020-12-31');

INSERT INTO ENDERECO(pais, uf, cidade, rua, cep) VALUES('Brasil', 'MG', 'Belo Horizonte', 'Avenida Afonso Pena', '31210-244');
INSERT INTO ENDERECO(pais, uf, cidade, rua, cep) VALUES('Brasil', 'SC', 'Florianopolis', 'Rua Capim Branco', '4125-652');
INSERT INTO ENDERECO(pais, uf, cidade, rua, cep) VALUES('Estados Unidos', 'NY', 'New York', '195th ave', '003-652');
INSERT INTO ENDERECO(pais, uf, cidade, rua, cep) VALUES('Canada', 'BC', 'Surrey', 'Fletwood way 13', '1121-122');

INSERT INTO PROJETO(nome, iddepartamento, custo) VALUES('Construção 2020', 2, '3000');
INSERT INTO PROJETO(nome, iddepartamento, custo) VALUES('Implementação novo sistema', 1, '1500');
INSERT INTO PROJETO(nome, iddepartamento, custo) VALUES('Novo site', 2, '4578');
INSERT INTO PROJETO(nome, iddepartamento, custo) VALUES('Kanban', 4, '7852');
INSERT INTO PROJETO(nome, iddepartamento, custo) VALUES('Troca Fornecedor', 2, '1245');

INSERT INTO FUNCIONARIO(nome, cpf, datanascimento, sexo, idEndereco, idSupervisor, idDepartamento, salario)
    VALUES('Kawagura Toko', '111.885.111-01', '1988-2-1', 'M', 2, 1, 2, '4500.00');
INSERT INTO FUNCIONARIO(nome, cpf, datanascimento, sexo, idEndereco, idSupervisor, idDepartamento, salario)
    VALUES('Leonardo Augusto Moreira Lourenço', '070.632,336-02', '1992-12-27', 'M', 1, 1, 2, '1500');
INSERT INTO FUNCIONARIO(nome, cpf, datanascimento, sexo, idEndereco, idSupervisor, idDepartamento, salario)
    VALUES('Marcelo da silva', '321.123.547-00', '1998-11-01', 'M', 1, 2, 3, '2700');
INSERT INTO FUNCIONARIO(nome, cpf, datanascimento, sexo, idEndereco, idSupervisor, idDepartamento, salario)
    VALUES('Mariano Ferreira', '080.751.136-12', '1990-03-12', 'M', 3, 3, 1, '5600');
INSERT INTO FUNCIONARIO(nome, cpf, datanascimento, sexo, idEndereco, idSupervisor, idDepartamento, salario)
    VALUES('Eliza Dinah Silva', '071.632.444-02', '2000-02-22', 'F', 2, 2, 4, '4800');

INSERT INTO FUNCIONARIO_PROJETO (idfuncionario, idprojeto) VALUES (1, 1);
INSERT INTO FUNCIONARIO_PROJETO (idfuncionario, idprojeto) VALUES (1, 3);
INSERT INTO FUNCIONARIO_PROJETO (idfuncionario, idprojeto) VALUES (2, 4);
INSERT INTO FUNCIONARIO_PROJETO (idfuncionario, idprojeto) VALUES (3, 2);
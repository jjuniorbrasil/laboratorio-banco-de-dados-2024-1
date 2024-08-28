INSERT INTO filial (id, endereco, nome, telefone) VALUES (1, 'Rua das Flores, 123', 'Filial Centro', '(11) 99999-1234');
INSERT INTO filial (id, endereco, nome, telefone) VALUES (2, 'Avenida Paulista, 456', 'Filial Paulista', '(11) 98888-5678');
INSERT INTO filial (id, endereco, nome, telefone) VALUES (3, 'Rua dos Pinheiros, 789', 'Filial Pinheiros', '(11) 97777-9123');
INSERT INTO filial (id, endereco, nome, telefone) VALUES (4, 'Avenida Brasil, 321', 'Filial Brasil', '(21) 99999-4567');
INSERT INTO filial (id, endereco, nome, telefone) VALUES (5, 'Rua Sete de Setembro, 654', 'Filial Copacabana', '(21) 98888-6789');
INSERT INTO filial (id, endereco, nome, telefone) VALUES (6, 'Avenida Goiás, 987', 'Filial Goiânia', '(62) 99999-7890');
INSERT INTO filial (id, endereco, nome, telefone) VALUES (7, 'Rua das Palmeiras, 111', 'Filial São Francisco', '(48) 99999-1111');
INSERT INTO filial (id, endereco, nome, telefone) VALUES (8, 'Avenida Independência, 222', 'Filial Porto Alegre', '(51) 99999-2222');
INSERT INTO filial (id, endereco, nome, telefone) VALUES (9, 'Rua das Orquídeas, 333', 'Filial Florianópolis', '(48) 98888-3333');
INSERT INTO filial (id, endereco, nome, telefone) VALUES (10, 'Avenida Amazonas, 444', 'Filial Belo Horizonte', '(31) 99999-4444');

INSERT INTO pessoa_fisica (cpf, email, nome, telefone) VALUES ('123.456.789-01', 'joao.silva@email.com', 'João Silva', '(11) 99999-5678');
INSERT INTO pessoa_fisica (cpf, email, nome, telefone) VALUES ('987.654.321-02', 'maria.souza@email.com', 'Maria Souza', '(21) 98888-1234');
INSERT INTO pessoa_fisica (cpf, email, nome, telefone) VALUES ('456.789.123-03', 'antonio.oliveira@email.com', 'Antônio Oliveira', '(31) 97777-5678');
INSERT INTO pessoa_fisica (cpf, email, nome, telefone) VALUES ('321.654.987-04', 'ana.lima@email.com', 'Ana Lima', '(62) 98888-6789');
INSERT INTO pessoa_fisica (cpf, email, nome, telefone) VALUES ('789.123.456-05', 'carlos.almeida@email.com', 'Carlos Almeida', '(48) 99999-7890');
INSERT INTO pessoa_fisica (cpf, email, nome, telefone) VALUES ('654.321.987-06', 'lucas.pereira@email.com', 'Lucas Pereira', '(51) 98888-1111');
INSERT INTO pessoa_fisica (cpf, email, nome, telefone) VALUES ('147.258.369-07', 'fernanda.santos@email.com', 'Fernanda Santos', '(48) 99999-2222');
INSERT INTO pessoa_fisica (cpf, email, nome, telefone) VALUES ('258.369.147-08', 'paulo.silva@email.com', 'Paulo Silva', '(11) 98888-3333');
INSERT INTO pessoa_fisica (cpf, email, nome, telefone) VALUES ('369.147.258-09', 'juliana.mendes@email.com', 'Juliana Mendes', '(21) 99999-4444');
INSERT INTO pessoa_fisica (cpf, email, nome, telefone) VALUES ('741.852.963-10', 'rafael.rodrigues@email.com', 'Rafael Rodrigues', '(31) 98888-5678');

INSERT INTO cidade (id, estado, nome, uf) VALUES (1, 'São Paulo', 'São Paulo', 'SP');
INSERT INTO cidade (id, estado, nome, uf) VALUES (2, 'Rio de Janeiro', 'Rio de Janeiro', 'RJ');
INSERT INTO cidade (id, estado, nome, uf) VALUES (3, 'Minas Gerais', 'Belo Horizonte', 'MG');
INSERT INTO cidade (id, estado, nome, uf) VALUES (4, 'Goiás', 'Goiânia', 'GO');
INSERT INTO cidade (id, estado, nome, uf) VALUES (5, 'Santa Catarina', 'Florianópolis', 'SC');
INSERT INTO cidade (id, estado, nome, uf) VALUES (6, 'Rio Grande do Sul', 'Porto Alegre', 'RS');
INSERT INTO cidade (id, estado, nome, uf) VALUES (7, 'Bahia', 'Salvador', 'BA');
INSERT INTO cidade (id, estado, nome, uf) VALUES (8, 'Pernambuco', 'Recife', 'PE');
INSERT INTO cidade (id, estado, nome, uf) VALUES (9, 'Paraná', 'Curitiba', 'PR');
INSERT INTO cidade (id, estado, nome, uf) VALUES (10, 'Ceará', 'Fortaleza', 'CE');

INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (2, 1, 500);  -- Rio de Janeiro para São Paulo
INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (1, 2, 500);  -- São Paulo para Rio de Janeiro
INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (3, 1, 586);  -- Belo Horizonte para São Paulo
INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (4, 1, 926);  -- Goiânia para São Paulo
INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (5, 1, 705);  -- Florianópolis para São Paulo
INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (6, 1, 1116); -- Porto Alegre para São Paulo
INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (7, 2, 1200); -- Salvador para Rio de Janeiro
INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (8, 2, 2335); -- Recife para Rio de Janeiro
INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (9, 1, 408);  -- Curitiba para São Paulo
INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (10, 2, 2738);-- Fortaleza para Rio de Janeiro
INSERT INTO distancia (id_cidade_destino, id_cidade_origem, quilometros) VALUES (3, 4, 878);  -- Belo Horizonte para Goiânia

INSERT INTO cliente (ativo, contato, cpf) VALUES (true, 'joao.silva@email.com', '123.456.789-01');
INSERT INTO cliente (ativo, contato, cpf) VALUES (true, 'maria.souza@email.com', '987.654.321-02');
INSERT INTO cliente (ativo, contato, cpf) VALUES (false, 'antonio.oliveira@email.com', '456.789.123-03');
INSERT INTO cliente (ativo, contato, cpf) VALUES (true, 'ana.lima@email.com', '321.654.987-04');
INSERT INTO cliente (ativo, contato, cpf) VALUES (false, 'carlos.almeida@email.com', '789.123.456-05');

INSERT INTO funcionario (id_filial, matricula, cpf) VALUES (6, '20230006', '654.321.987-06');
INSERT INTO funcionario (id_filial, matricula, cpf) VALUES (7, '20230007', '147.258.369-07');
INSERT INTO funcionario (id_filial, matricula, cpf) VALUES (8, '20230008', '258.369.147-08');
INSERT INTO funcionario (id_filial, matricula, cpf) VALUES (9, '20230009', '369.147.258-09');
INSERT INTO funcionario (id_filial, matricula, cpf) VALUES (10, '20230010', '741.852.963-10');

INSERT INTO dependente (dataNascimento, id, nome, tutor_cpf) VALUES ('2011-06-30', 6, 'Lucas Pereira Filho', '654.321.987-06');
INSERT INTO dependente (dataNascimento, id, nome, tutor_cpf) VALUES ('2013-04-05', 7, 'Fernanda Santos Junior', '147.258.369-07');
INSERT INTO dependente (dataNascimento, id, nome, tutor_cpf) VALUES ('2015-08-18', 8, 'Paulo Silva Filho', '258.369.147-08');
INSERT INTO dependente (dataNascimento, id, nome, tutor_cpf) VALUES ('2010-02-27', 9, 'Juliana Mendes Junior', '369.147.258-09');

insert into categoriafrete (id, percentual_adicional, descricao, nome) values (1, 0.0, "Entrega normal, sem acréscimo no valor do frete.", "Normal");
insert into categoriafrete (id, percentual_adicional, descricao, nome) values (2, 0.1, "Entrega rápida, com acréscimo de 10% no valor do frete.", "Rápida");
insert into categoriafrete (id, percentual_adicional, descricao, nome) values (3, 0.3, "Entrega super-rápida, com acréscimo de 30% no valor do frete.", "Super-Rápida");

insert into tipo_veiculo (id, peso_max, descricao) VALUES (1, 3000.0, "Veículo de carga padrão");

insert into veiculo (id_filial, id_tipo, numero_placa) VALUES (1, 1, 'ESG-9999');
insert into veiculo (id_filial, id_tipo, numero_placa) VALUES (2, 1, 'XYZ-1234');
insert into veiculo (id_filial, id_tipo, numero_placa) VALUES (3, 1, 'ABC-5678');
insert into veiculo (id_filial, id_tipo, numero_placa) VALUES (2, 1, 'LMN-3456');
insert into veiculo (id_filial, id_tipo, numero_placa) VALUES (1, 1, 'OPQ-7890');
insert into veiculo (id_filial, id_tipo, numero_placa) VALUES (3, 1, 'RST-1234');
insert into veiculo (id_filial, id_tipo, numero_placa) VALUES (1, 1, 'UVW-5678');
insert into veiculo (id_filial, id_tipo, numero_placa) VALUES (2, 1, 'XYZ-4321');
insert into veiculo (id_filial, id_tipo, numero_placa) VALUES (3, 1, 'ABC-8765');
insert into veiculo (id_filial, id_tipo, numero_placa) VALUES (1, 1, 'DEF-1234');

insert into frete (codigo, id_categoria, id_cidade_destino, id_cidade_origem, id_filial, numero_nota_fiscal, valor_Km_rodado, id_cliente, placa_veiculo) VALUES (1, 1, 1, 2, 1, 5324212, 0.5, '123.456.789-01', "ESG-9999");
insert into frete (codigo, id_categoria, id_cidade_destino, id_cidade_origem, id_filial, numero_nota_fiscal, valor_Km_rodado, id_cliente, placa_veiculo) VALUES (2, 2, 2, 3, 2, 5334213, 0.6, '987.654.321-02', "XYZ-1234");
insert into frete (codigo, id_categoria, id_cidade_destino, id_cidade_origem, id_filial, numero_nota_fiscal, valor_Km_rodado, id_cliente, placa_veiculo) VALUES (3, 1, 5, 3, 3, 5326213, 0.8, '987.654.321-02', "ABC-5678");

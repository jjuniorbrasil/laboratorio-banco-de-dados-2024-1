insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Rudney", "11967482932", "Advogado", 300.0);
insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Ana", "11987654321", "Corretora de Imóveis", 35.0);
insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Carlos", "11912345678", "Engenheiro Civil", 40.0);
insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Paula", "11923456789", "Arquiteta", 45.0);
insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Felipe", "11934567890", "Avaliador de Imóveis", 32.0);
insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Mariana", "11945678901", "Gerente de Propriedades", 30.0);
insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Rafael", "11956789012", "Consultor Imobiliário", 300.0);
insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Juliana", "11967890123", "Especialista em Financiamento Imobiliário", 340.0);
insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Roberto", "11978901234", "Advogado Imobiliário", 450.0);
insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Bianca", "11989012345", "Design de Interiores", 60.0);
insert into Profissionais (nome, telefone1, profissao, valor_hora) values ("Eduardo", "11990123456", "Agente de Locação", 45.0);

insert into Clientes (nome, CPF, telefone) values ("Frieren", "100.090.190-23", "11978349283");
insert into Clientes (nome, CPF, telefone) values ("Fern", "200.180.270-34", "11987654321");
insert into Clientes (nome, CPF, telefone) values ("Stark", "300.270.360-45", "11912345678");
insert into Clientes (nome, CPF, telefone) values ("Diana", "400.360.450-56", "11923456789");
insert into Clientes (nome, CPF, telefone) values ("Eduardo", "500.450.540-67", "11934567890");
insert into Clientes (nome, CPF, telefone) values ("Fernanda", "600.540.630-78", "11945678901");
insert into Clientes (nome, CPF, telefone) values ("Gustavo", "700.630.720-89", "11956789012");
insert into Clientes (nome, CPF, telefone) values ("Helena", "800.720.810-90", "11967890123");
insert into Clientes (nome, CPF, telefone) values ("Igor", "900.810.900-01", "11978901234");
insert into Clientes (nome, CPF, telefone) values ("Juliana", "010.900.990-12", "11989012345");
insert into Clientes (nome, CPF, telefone) values ("Leonardo", "020.990.080-23", "11990123456");

INSERT INTO laboratorioiv.imoveis (ID_proprietario, banheiros, dormitorios, id, metragem, suites, vagas_garagem, valor_aluguel_sugerido, CEP, bairro, logradouro, observacao, ID_tipo_imovel) VALUES (1, 2, null, 1, null, null, null, 800, '12342-678', 'Centro', 'Rua A', null, 'TIPO3');
INSERT INTO laboratorioiv.imoveis (ID_proprietario, banheiros, dormitorios, id, metragem, suites, vagas_garagem, valor_aluguel_sugerido, CEP, bairro, logradouro, observacao, ID_tipo_imovel) VALUES (2, 2, null, 2, null, null, null, 700, '12342-678', 'Centro', 'Rua A', null, 'TIPO2');
INSERT INTO laboratorioiv.imoveis (ID_proprietario, banheiros, dormitorios, id, metragem, suites, vagas_garagem, valor_aluguel_sugerido, CEP, bairro, logradouro, observacao, ID_tipo_imovel) VALUES (3, 2, null, 3, null, null, null, 1200, '12342-678', 'Centro', 'Rua A', null, 'TIPO1');

insert into Locacao (ID_imovel, ID_inquilino, ativo, dia_vencimento, percentual_multa, valor_aluguel, data_fim, data_inicio, observacao) values (1, 3, true, 5, 0.20, 300.00, '2025-07-27 19:19:36.000000', '2024-07-27 19:19:46.000000', 'Sem observação');

insert into Alugueis (ID_locacao, valor_pago, data_pagamento, data_vencimento, observacao) values (1, 300.00, '2024-11-27 19:26:54.000000', '2024-07-25 19:27:04.000000', 'Pagou atrasado');


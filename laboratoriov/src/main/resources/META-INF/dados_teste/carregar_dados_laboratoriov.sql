use laboratoriov;
-- Tabela: categoriafrete
INSERT INTO `categoriafrete` (`id`, `descricao`, `nome`, `percentual_adicional`) VALUES
(1, 'Frete local', 'Local', 5.0),
(2, 'Frete intermunicipal', 'Intermunicipal', 7.5),
(3, 'Frete interestadual', 'Interestadual', 10.0),
(4, 'Frete internacional', 'Internacional', 15.0),
(5, 'Entrega expressa', 'Expressa', 20.0),
(6, 'Frete econômico', 'Econômico', 2.5),
(7, 'Frete noturno', 'Noturno', 8.0),
(8, 'Frete diurno', 'Diurno', 4.0),
(9, 'Frete prioritário', 'Prioritário', 12.5),
(10, 'Frete de retorno', 'Retorno', 3.0);

-- Tabela: filial
INSERT INTO `filial` (`id`, `endereco`, `nome`, `telefone`) VALUES
(1, 'Rua A, 100', 'Filial São Paulo', '(11) 1234-5678'),
(2, 'Rua B, 200', 'Filial Rio de Janeiro', '(21) 2345-6789'),
(3, 'Rua C, 300', 'Filial Belo Horizonte', '(31) 3456-7890'),
(4, 'Rua D, 400', 'Filial Curitiba', '(41) 4567-8901'),
(5, 'Rua E, 500', 'Filial Salvador', '(71) 5678-9012'),
(6, 'Rua F, 600', 'Filial Porto Alegre', '(51) 6789-0123'),
(7, 'Rua G, 700', 'Filial Brasília', '(61) 7890-1234'),
(8, 'Rua H, 800', 'Filial Recife', '(81) 8901-2345'),
(9, 'Rua I, 900', 'Filial Fortaleza', '(85) 9012-3456'),
(10, 'Rua J, 1000', 'Filial Belém', '(91) 0123-4567');

-- Tabela: tipo_veiculo
INSERT INTO `tipo_veiculo` (`id`, `descricao`, `peso_max`) VALUES
(1, 'Caminhão', 15000),
(2, 'Van', 3000),
(3, 'Moto', 200),
(4, 'Bicicleta', 50),
(5, 'Carro', 500),
(6, 'Barco', 20000),
(7, 'Avião', 50000),
(8, 'Trem', 80000),
(9, 'Navio', 200000),
(10, 'Caminhonete', 1000);

-- Inserção de dados na tabela pessoa_fisica
INSERT INTO `pessoa_fisica` (`cpf`, `email`, `nome`, `telefone`) VALUES
('11111111111', 'joao.silva@example.com', 'João Silva', '(11) 91234-5678'),
('22222222222', 'maria.oliveira@example.com', 'Maria Oliveira', '(21) 92345-6789'),
('33333333333', 'jose.souza@example.com', 'José Souza', '(31) 93456-7890'),
('44444444444', 'ana.costa@example.com', 'Ana Costa', '(41) 94567-8901'),
('55555555555', 'carlos.lima@example.com', 'Carlos Lima', '(71) 95678-9012'),
('66666666666', 'mariana.gomes@example.com', 'Mariana Gomes', '(51) 96789-0123'),
('77777777777', 'rafael.santos@example.com', 'Rafael Santos', '(61) 97890-1234'),
('88888888888', 'paula.fernandes@example.com', 'Paula Fernandes', '(81) 98901-2345'),
('99999999999', 'ricardo.martins@example.com', 'Ricardo Martins', '(85) 99012-3456'),
('00000000000', 'beatriz.carvalho@example.com', 'Beatriz Carvalho', '(91) 90123-4567');

-- Tabela: cliente
INSERT INTO `cliente` (`ativo`, `contato`, `cpf`) VALUES
(b'1', 'João Silva', '11111111111'),
(b'1', 'Maria Oliveira', '22222222222'),
(b'1', 'José Souza', '33333333333'),
(b'1', 'Ana Costa', '44444444444'),
(b'1', 'Carlos Lima', '55555555555'),
(b'1', 'Mariana Gomes', '66666666666'),
(b'1', 'Rafael Santos', '77777777777'),
(b'1', 'Paula Fernandes', '88888888888'),
(b'1', 'Ricardo Martins', '99999999999'),
(b'1', 'Beatriz Carvalho', '00000000000');

-- Tabela: funcionario
INSERT INTO `funcionario` (`matricula`, `cpf`, `id_filial`) VALUES
(1, '11111111111', 1),
(2, '22222222222', 2),
(3, '33333333333', 3),
(4, '44444444444', 4),
(5, '55555555555', 5),
(6, '66666666666', 6),
(7, '77777777777', 7),
(8, '88888888888', 8),
(9, '99999999999', 9),
(10, '00000000000', 10);

-- Tabela: cidade
INSERT INTO `cidade` (`id`, `estado`, `nome`, `uf`) VALUES
(1, 'São Paulo', 'São Paulo', 'SP'),
(2, 'Rio de Janeiro', 'Rio de Janeiro', 'RJ'),
(3, 'Minas Gerais', 'Belo Horizonte', 'MG'),
(4, 'Paraná', 'Curitiba', 'PR'),
(5, 'Bahia', 'Salvador', 'BA'),
(6, 'Rio Grande do Sul', 'Porto Alegre', 'RS'),
(7, 'Distrito Federal', 'Brasília', 'DF'),
(8, 'Pernambuco', 'Recife', 'PE'),
(9, 'Ceará', 'Fortaleza', 'CE'),
(10, 'Pará', 'Belém', 'PA');



-- Tabela: dependente
INSERT INTO `dependente` (`id`, `dataNascimento`, `nome`, `tutor_cpf`) VALUES
(1, '2010-05-12', 'Pedro Silva', '11111111111'),
(2, '2012-07-15', 'Luiza Oliveira', '22222222222'),
(3, '2014-09-20', 'Felipe Souza', '33333333333'),
(4, '2008-03-30', 'Gabriela Costa', '44444444444'),
(5, '2011-12-05', 'Marcos Lima', '55555555555'),
(6, '2013-11-22', 'Júlia Gomes', '66666666666'),
(7, '2015-01-18', 'Lucas Santos', '77777777777'),
(8, '2016-08-07', 'Isabela Fernandes', '88888888888'),
(9, '2009-04-10', 'Gustavo Martins', '99999999999'),
(10, '2017-02-28', 'Sophia Carvalho', '00000000000');

-- Tabela: distancia
INSERT INTO `distancia` (`quilometros`, `id_cidade_destino`, `id_cidade_origem`) VALUES
(400, 2, 1),
(500, 3, 1),
(300, 4, 2),
(1200, 5, 2),
(800, 6, 3),
(600, 7, 4),
(2000, 8, 5),
(2500, 9, 6),
(2800, 10, 7),
(700, 1, 8);

-- Inserção de dados na tabela veiculo
INSERT INTO `veiculo` (`numero_placa`, `id_filial`, `id_tipo`) VALUES
('ABC1234', 1, 1),
('DEF5678', 2, 2),
('GHI9101', 1, 3),
('JKL1122', 3, 1),
('MNO3344', 2, 2),
('PQR5566', 4, 3),
('STU7788', 1, 1),
('VWX9900', 3, 2),
('YZA1112', 4, 3),
('BCD1314', 2, 1);

-- Inserções na tabela frete com referências corrigidas

INSERT INTO `frete` (`numero_nota_fiscal`, `valor_Km_rodado`, `id_categoria`, `id_cidade_destino`, `id_cidade_origem`, `id_cliente`, `id_filial`, `placa_veiculo`) VALUES
(1001, 2000.00, 1, 2, 1, '11111111111', 1, 'ABC1234'), -- São Paulo -> Rio de Janeiro
(1002, 1500.00, 2, 3, 1, '22222222222', 1, 'GHI9101'), -- São Paulo -> Belo Horizonte
(1003, 3000.00, 3, 4, 2, '33333333333', 3, 'JKL1122'), -- Rio de Janeiro -> Curitiba
(1004, 1000.00, 4, 5, 2, '44444444444', 2, 'MNO3344'), -- Rio de Janeiro -> Salvador
(1005, 5000.00, 5, 6, 3, '55555555555', 2, 'DEF5678'), -- Belo Horizonte -> Porto Alegre
(1006, 2500.00, 6, 7, 3, '66666666666', 4, 'PQR5566'), -- Belo Horizonte -> Brasília
(1007, 4000.00, 7, 8, 4, '77777777777', 1, 'STU7788'), -- Curitiba -> Recife
(1008, 3500.00, 8, 9, 4, '88888888888', 3, 'VWX9900'), -- Curitiba -> Fortaleza
(1009, 4500.00, 9, 10, 5, '99999999999', 4, 'YZA1112'), -- Salvador -> Belém
(1010, 6000.00, 10, 1, 5, '00000000000', 2, 'BCD1314'); -- Salvador -> São Paulo


-- Tabela: item_frete
INSERT INTO `item_frete` (`id_frete`, `descricao`, `peso`) VALUES
(1, 'Eletrônicos', 5.5),
(2, 'Roupas', 2.0),
(3, 'Móveis', 30.0),
(4, 'Alimentos', 10.0),
(5, 'Medicamentos', 1.5),
(6, 'Brinquedos', 3.0),
(7, 'Livros', 4.5),
(8, 'Eletrodomésticos', 20.0),
(9, 'Ferramentas', 7.0),
(10, 'Cosméticos', 1.0);


CREATE TABLE `empresa` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(200) NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `data_criacao` datetime NOT NULL,
  `razao_social` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `funcionario` (
  `id` BIGINT(20) NOT NULL,
  `cpf` VARCHAR(200) NOT NULL,
  `data_atualizacao` DATETIME NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `perfil` VARCHAR(200) NOT NULL,
  `qtd_horas_almoco` FLOAT NULL,
  `qtd_horas_trabalho_dia` FLOAT NULL,
  `senha` VARCHAR(200) NOT NULL,
  `valor_hora` DECIMAL(19,2) NULL,
  `empresa_id` BIGINT(20) NULL,
  `nome` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));
  
  
CREATE TABLE `lancamento` (
  `id` BIGINT(20) NOT NULL,
  `data` DATETIME NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  `data_atualizacao` DATETIME NOT NULL,
  `localizacao` VARCHAR(200) NOT NULL,
  `tipo` VARCHAR(200) NOT NULL,
  `funcionario_id` BIGINT(20) NOT NULL,
  `lancamentocol` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
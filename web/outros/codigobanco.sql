CREATE SCHEMA `exame` ;


CREATE TABLE `exame`.`cliente` (
  `codigo` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `telefone` INT NOT NULL,
  `endereco` VARCHAR(145) NOT NULL,
  `clientecol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`));

CREATE TABLE `exame`.`processos` (
  `codigo` INT NOT NULL,
  `descricao` VARCHAR(500) NOT NULL,
  `dataDeAbertura` DATETIME NOT NULL,
  PRIMARY KEY (`codigo`));

CREATE TABLE `exame`.`advogado` (
  `codigo` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `registroOAB` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`));

CREATE TABLE `exame`.`audiencia` (
  `codigo` INT NOT NULL,
  `dataHora` DATETIME NOT NULL,
  `local` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`codigo`));

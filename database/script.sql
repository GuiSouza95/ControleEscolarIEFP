CREATE TABLE role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL,
    tentativas INT DEFAULT 0 NOT NULL,
    account_non_locked BOOLEAN DEFAULT TRUE,
    failed_attempts INT DEFAULT 0,
    data_criacao DATETIME,
    data_alteracao DATETIME
);

CREATE TABLE user_role (
    usuario_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, role_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    apelido VARCHAR(255) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    data_nascimento DATE,
    ativo BOOLEAN DEFAULT TRUE,    
    usuario_id BIGINT,
    data_criacao DATETIME DEFAULT current_timestamp,
    data_alteracao DATETIME,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

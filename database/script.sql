CREATE DATABASE `app_controle_escolar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `aluno` (
  `ativo` bit(1) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `data_alteracao` datetime(6) DEFAULT NULL,
  `data_criacao` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `usuario_id` bigint DEFAULT NULL,
  `apelido` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsgpw6tb2kerkceshx1b10rhkg` (`usuario_id`),
  CONSTRAINT `FKsgpw6tb2kerkceshx1b10rhkg` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `disciplina` (
  `id` bigint NOT NULL,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `disciplina_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `nota` (
  `media` decimal(2,2) NOT NULL,
  `nota1` decimal(2,2) NOT NULL,
  `nota2` decimal(2,2) NOT NULL,
  `aluno_id` bigint NOT NULL,
  `disciplina_id` bigint NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `situacao` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ntsgem4ql46uy34ile14rg74` (`aluno_id`),
  KEY `FKsvtulgi5u9owlahm6coc3mn00` (`disciplina_id`),
  CONSTRAINT `FK7ntsgem4ql46uy34ile14rg74` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`),
  CONSTRAINT `FKsvtulgi5u9owlahm6coc3mn00` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplina` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `professor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `usuario_id` bigint NOT NULL,
  `nome` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKn3f1mi90f5bhejx5jlwwa0l2a` (`usuario_id`),
  CONSTRAINT `FK4e8my94n7xeso7f1xrylw8fld` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `professor_disciplina` (
  `disciplina_id` bigint NOT NULL,
  `professor_id` bigint NOT NULL,
  KEY `FKdvomwj1mgrxe2j3ray89irp37` (`disciplina_id`),
  KEY `FKmg7je0fa76naldh1rcwbwdvjc` (`professor_id`),
  CONSTRAINT `FKdvomwj1mgrxe2j3ray89irp37` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplina` (`id`),
  CONSTRAINT `FKmg7je0fa76naldh1rcwbwdvjc` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `professor_turma` (
  `professor_id` bigint NOT NULL,
  `turma_id` bigint NOT NULL,
  KEY `FKi8takmq6g12wrxgnrmi5nyj84` (`turma_id`),
  KEY `FK76orhtbpyl63abq18tk5dt3et` (`professor_id`),
  CONSTRAINT `FK76orhtbpyl63abq18tk5dt3et` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`),
  CONSTRAINT `FKi8takmq6g12wrxgnrmi5nyj84` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKpsbnsrja0jvuncak7b0sqo2fi` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `role_menu_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `route` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_role_role_menu_item` (`role_id`),
  CONSTRAINT `FK_role_role_menu_item` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `turma` (
  `create_time` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `periodo` varchar(50) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `turma_disciplina` (
  `disciplina_id` bigint NOT NULL,
  `turma_id` bigint NOT NULL,
  `carga_horaria` bigint DEFAULT NULL,
  `professor_id` bigint NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `turma_disciplina_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `turma_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_role` (
  `role_id` bigint NOT NULL,
  `usuario_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`,`usuario_id`),
  KEY `FKnar8ltv71sf5lmp9b1duaydaq` (`usuario_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKnar8ltv71sf5lmp9b1duaydaq` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `account_non_locked` bit(1) NOT NULL,
  `tentativas` int DEFAULT NULL,
  `data_alteracao` datetime(6) DEFAULT NULL,
  `data_criacao` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK863n1y3x0jalatoir4325ehal` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

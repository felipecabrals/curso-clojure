CREATE TABLE pessoas
		(pes_codigo int auto_increment,
		 pes_nome VARCHAR(200) not null,
		 pes_endereco VARCHAR(255),
		 pes_numero VARCHAR(30),
		 pes_bairro VARCHAR(50),
		 pes_complemento VARCHAR(60),
		 pes_cep VARCHAR(8),
		 pes_telefone VARCHAR(10),
		 pes_celular VARCHAR(11),
		 pes_obs VARCHAR(500),
		 pes_data timestamp not null default current_timestamp);
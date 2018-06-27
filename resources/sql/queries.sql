-- :name set-pessoa! :! :n
-- :doc creates a new user record
INSERT INTO pessoas
    (pes_nome,
    pes_endereco, 
    pes_numero, 
    pes_bairro, 
    pes_complemento, 
    pes_cep, 
    pes_telefone, 
    pes_celular, 
    pes_obs)
VALUES (:pes_nome, 
        :pes_endereco, 
        :pes_numero, 
        :pes_bairro, 
        :pes_complemento, 
        :pes_cep, 
        :pes_telefone, 
        :pes_celular, 
        :pes_obs)

-- :name put-pessoa! :! :n
-- :doc updates an existing user record
UPDATE pessoas
SET pes_nome = :pes_nome, 
	pes_endereco = :pes_endereco, 
	pes_numero = :pes_numero,
	pes_bairro = :pes_bairro,
	pes_complemento = :pes_complemento,
	pes_cep = :pes_cep,
	pes_telefone = :pes_telefone,
	pes_celular = :pes_celular,
	pes_obs = :pes_obs
WHERE pes_codigo = :pes_codigo	

-- :name list-pessoa :? :*
-- :doc retrieves a user record given the id
SELECT * FROM pessoas

-- :name get-pessoa :? :1
-- :doc retrieves a user record given the id
SELECT * FROM pessoas
WHERE pes_codigo = :pes_codigo

-- :name del-pessoa! :! :n
-- :doc deletes a user record given the id
DELETE FROM pessoas
WHERE pes_codigo = :pes_codigo
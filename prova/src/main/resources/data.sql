INSERT INTO beneficiario ( nome, telefone, data_nascimento) VALUES ( 'Teste1', '11 1234-5678', '1976-08-20');
INSERT INTO beneficiario ( nome, telefone) VALUES ( 'Teste2', '12 1234-5678');

INSERT INTO documento ( beneficiario_id, tipo_Documento, descricao) VALUES ( 1, 'CPF', 'Descricao CPF');
INSERT INTO documento ( beneficiario_id, tipo_Documento, descricao) VALUES ( 1, 'RG', 'Descricao RG');
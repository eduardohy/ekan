Como a aplicação foi desenvolvida:
- O Spring Initializr(https://start.spring.io/) foi usado para criar a estrutura inicial - Maven, Java, Spring Boot 3.3.3, Packaging jar, Java 17 e dependencias Spring Web, Spring Security, Spring Data JPA, H2 Database.
- A estrutura inicial foi importada no Eclipse.
- Criado as tabelas/entities do beneficiario e documento.
- Testado o acesso ao banco de dados H2 pela aplicação.
- Criado os endpoints.
- Endpoints testados no Postman.
- Adicionado a autenticação de usuário e o swagger.
- Endpoints testados no Postman novamente.

Instruções para executar o build:
- Copiar os fontes que estão no github: "git clone https://github.com/eduardohy/ekan.git ."
- No Eclipse, clicar em File -> Import -> Maven -> Existing Maven Projects. Next.
- Clicar em Browse. Selecionar a pasta dos fontes e Finish.
- Esperar o download das dependências (barra inferior direita chegar em 100%).
- No Package Explorer, no lado esquerdo, expandir o projeto Prova.
- Nos itens expandidos da prova, clicar com o botão direito em src/main/java.
- Clicar em Run As -> Java Application

Endereço do swagger: http://localhost:8080/swagger-ui/index.html
username: sa
password: sa

As tabelas já são carregadas com os dados iniciais que estão no arquivo src/main/resources/data.sql:
INSERT INTO beneficiario ( nome, telefone, data_nascimento) VALUES ( 'Teste1', '11 1234-5678', '1976-08-20');
INSERT INTO beneficiario ( nome, telefone) VALUES ( 'Teste2', '12 1234-5678');
INSERT INTO documento ( beneficiario_id, tipo_Documento, descricao) VALUES ( 1, 'CPF', 'Descricao CPF');
INSERT INTO documento ( beneficiario_id, tipo_Documento, descricao) VALUES ( 1, 'RG', 'Descricao RG');

Para teste pelo Postman, adicionar em Authorization, Type Basic Auth:
username: sa
password: sa

-Lista todos os beneficiarios: GET localhost:8080/rest/findAll

-Lista todos os documentos do beneficiario: GET localhost:8080/rest/listaDocumentosByBeneficiarioId/1
onde 1 é o id do beneficiário.

-Cadastrar um beneficiário: POST localhost:8080/rest/insereBeneficiario
Em Body, raw, JSON:
{"nome":"Teste5","telefone":"11 1234-5678","dataNascimento":"1976-08-20T03:00:00.000+00:00","dataInclusao":null,"dataAtualizacao":null}

-Cadastrar um documento: POST localhost:8080/rest/insereDocumento
Em Body, raw, JSON:
{"id": 2,"tipoDocumento": "CPF","descricao": "Descricao CPF","dataInclusao": null,"dataAtualizacao": null}
onde id = 2 é o id do beneficiário.

-Atualizar os dados cadastrais de um beneficiário: PATCH localhost:8080/rest/atualizaBeneficiario
Em Body, raw, JSON:
{"id": 1, "nome":"Teste1 update","telefone":"11 1234-5678","dataNascimento":"1976-08-20T03:00:00.000+00:00","dataInclusao":null,"dataAtualizacao":null}
onde 1 é o id do beneficiário.

-Atualizar os dados cadastrais de um documento: PATCH localhost:8080/rest/atualizaDocumento
Em Body, raw, JSON:
{"id": 2,"tipoDocumento": "RG editado","descricao": "Descricao CPF","dataInclusao": null,"dataAtualizacao": null}
onde id = 2 é o id do documento

-Remover um beneficiário: DELETE localhost:8080/rest/removeBeneficiario/1
onde 1 é o id do beneficiário
















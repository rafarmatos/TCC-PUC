# Servidor para autenticação

Projeto responsável por realizar o processo de autenticação de usuário utilizando oauth2.

## Como funciona
- O Usuário acessa um cliente/ projeto. Para ter acesso ao conteúdo protegido da api (Resource Server) o cliente solicita Autorização ao <b>Resource Owner.</b>
- A Autorização é concedida pelo usuário <b>Resource Owner</b>
- O cliente/ projeto solicita um token de acesso ao <b>Authorization Server</b> através da autenticação de sua própria identidade.
- O <b>Resource Owner</b> confirma sua identidade através do seu usuário e senha ou através de um terceiro (Google). Se tudo ocorrer bem um Access Token será criado e devolvido para o cliente gerenciar.
- Por fim o cliente informa o Access Token ao <b>Resorce Server</b>.
- O <b>Resource Server</b> faz validação e retorna o conteúdo Protegido.

![Image description](https://www.brunobrito.net.br/content/images/2018/08/roles-2.png)

## Executando o projeto
- Faça o download do projeto
- Faça o download da dependência <a href="https://github.com/skyrafael/TCC-PUC/tree/master/entities">entities</a>
- Execute o comando abaixo dentro da basta do projeto:

```
mvn clean install
```

## Serviços
- Para autenticar, realize uma requisição para <a>http://localhost:8080/</a>. 
Será solicita permissão de acesso aos seus dados na conta do Google e posteriormente, a requisação será direcionada para a tela com as credencias do usuário.


- Para realizar o processo de logout, realize uma requisição do tipo POST para:
http://localhost:8080/logout



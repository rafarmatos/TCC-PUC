# business

Projeto responsável por manter as funcionalidades de negócio do sistema


## Executando o projeto
- Faça o download do projeto e suas dependencias: <a href="https://github.com/skyrafael/TCC-PUC">entities, security-client</a>
- Execute o comando abaixo dentro da basta do projeto:

```
mvn clean install
```
- Inicie o projeto.

## Testando funcionalidade
- Para verificar se o projeto esta funcionando, faça uma requisição para 
<br /><a href="http://localhost:8081/_user">http://localhost:8081/_user</a> <br />
enviando no header um Authorization. Este authorization pode ser obtido em <a href="https://github.com/skyrafael/TCC-PUC/tree/master/security-server">security-server</a> 

# security-client

Projeto responsável por interceptar as requisições e verificar se há um usuário válido/ autenticado.

## Como funciona
Ao realizar uma requisição, esta será interceptada e recuperado o valor do Authorization contido no header da requisição. Exemplo:
```
Authorization: 3978574BC2E65F4F3149690777914A30
```
Com este valor é possível verificar se o token é valido. 
O token sendo válido a requisição será processada normalmente. Caso contrário, um <code>401 Unauthorized</code> será enviado como resposta para o usuário.

## Executando o projeto
- Faça o download do projeto
- Faça o download da dependência <a href="https://github.com/skyrafael/TCC-PUC/tree/master/entities">entities</a>
- Execute o comando abaixo dentro da basta do projeto:

```
mvn clean install
```

Agora, adicione esta dependência em seu pom.xml:

```
<dependency>
	<groupId>br.mg.puc.minas.sica</groupId>
	<artifactId>security-client</artifactId>
	<version>versao_projeto</version>
</dependency>
```
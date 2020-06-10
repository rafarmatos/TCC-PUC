# business

Projeto responsável por manter dados dos usuários.


## Executando o projeto
- Faça o download do projeto
- Faça o download do projeto security-client

Execute o comando abaixo dentro da pasta do projeto security-client
```
mvn clean install
```

Execute o comando abaixo dentro da basta do business:

```
mvn clean install
```

- Inicie o projeto.

## Testando funcionalidade
- Para verificar se o projeto esta funcionando, faça uma requisição para 
<br /><a href="http://localhost:8081/_user">http://localhost:8081/_user</a> <br />
enviando no header um Authorization. Este authorization pode ser obtido em <a href="https://github.com/skyrafael/TCC-PUC/tree/master/security-server">security-server</a> 

## Adicionando o projeto de seguranca como uma dependencia
Dentro do projeto que receberá o módulo de segurança como dependência, crie a pasta <b>repo</b>. A estrutura ficará semelhante a:
```
seu_projeto
+- pom.xml
+- src
+- repo
```

Adicione ao seu pom.xml o plugin abaixo:

```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-deploy-plugin</artifactId>
</plugin>
```

e a extensão

```
<extension>
	<groupId>org.apache.maven.wagon</groupId>
	<artifactId>wagon-http</artifactId>
	<version>2.10</version>
</extension>
```

Seu pom.xml ficará semelhante a:
```
<build>
	<plugins>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-deploy-plugin</artifactId>
		</plugin>
	</plugins>
	<extensions>
		<extension>
			<groupId>org.apache.maven.wagon</groupId>
			<artifactId>wagon-http</artifactId>
			<version>2.10</version>
		</extension>
	</extensions>
</build>
```

Acesse a pasta do projeto security-client e execute o comando:
```
mvn clean install
``` 

Vamos voltar para a pasta do projeto que estamos construindo e executar o seguinte comando:
```
mvn deploy:deploy-file -Durl=file:///PATH_PROJETO/repo/ -Dfile=PATH_MODULO_SEGURANCA/target/security-client-version.jar -DgroupId=br.mg.puc.minas.sica -DartifactId=security-client -Dpackaging=jar -Dversion=version
```
Consulte a versão do  <a href="https://github.com/skyrafael/TCC-PUC/tree/master/security-client"> projeto security-client clicando aqui</a>.

Caso você receba uma mensagem semelhante a esta:
```
No plugin found for prefix 'deploy'
```

Adicione ao seu pom.xml a seguinte configuração:

```
<repositories>
	<repository>
		<id>spring-snapshots</id>
		<name>Spring Snapshots</name>
		<url>https://repo.spring.io/snapshot</url>
		<snapshots>
			<enabled>true</enabled>
		</snapshots>
	</repository>
	<repository>
		<id>spring-milestones</id>
		<name>Spring Milestones</name>
		<url>https://repo.spring.io/milestone</url>
		<snapshots>
			<enabled>false</enabled>
		</snapshots>
	</repository>
	<repository>
		<id>project.local</id>
		<name>project</name>
		<url>file:${project.basedir}/repo</url>
	</repository>
</repositories>

<pluginRepositories>
	<pluginRepository>
		<id>spring-snapshots</id>
		<name>Spring Snapshots</name>
		<url>https://repo.spring.io/snapshot</url>
		<snapshots>
			<enabled>true</enabled>
		</snapshots>
	</pluginRepository>
	<pluginRepository>
		<id>spring-milestones</id>
		<name>Spring Milestones</name>
		<url>https://repo.spring.io/milestone</url>
		<snapshots>
			<enabled>false</enabled>
		</snapshots>
	</pluginRepository>
</pluginRepositories>
```

O comando sendo executado com sucesso, a estrutura do seu projeto deverá parecer com a seguinte:

```
seu_projeto
+- pom.xml
+- src
+- repo
   +- br
      +- mg 
         +- ....
         	+- security-client
	            +- maven-metadata.xml
	            +- ...
	            +- 0.0.1
	               +- security-client-0.0.1.jar
	               +- security-client-0.0.1.pom
	               +- ...
```        

Agora temos que adicionar o repositorio local ao nosso pom.xml
```   
<repository>
      <id>project.local</id>
      <name>project</name>
      <url>file:${project.basedir}/repo</url>
</repository>       
 ```   
 
Adicione a dependencia do security-client ao pom.xml. Copie o trecho do código abaixo e adicione ao seu pom.xml:
 ``` 
	<dependency>
		<groupId>br.mg.puc.minas.sica</groupId>
		<artifactId>security-client</artifactId>
		<version>version</version>
	</dependency>
``` 		
Consulte a versão do  <a href="https://github.com/skyrafael/TCC-PUC/tree/master/security-client"> projeto security-client clicando aqui</a>.

Uma dica importante é que você deve adicionar a classe principal do seu projeto a seguinte propriedade:

 ``` 
@SpringBootApplication(scanBasePackages = {"br.mg.puc.minas.sica", "br.mg.exemplo"})
 ``` 
 
 onde o valor <b>br.mg.exemplo</b> é o pacote onde encontra-se a classe principal do seu projeto.
 
 
 Na próxima vez em que você "subir" o projeto, a dependência será resolvida e o aplicativo será construído sem problemas.
 
 # Heroku
 Esta aplicação de teste esta disponível no Heroku. Para fazer o teste da aplicação siga os passos a seguir:
 - obtenha um token de acesso em: https://sica-security.herokuapp.com/
 - faça uma requisição:
	1. Endereço: https://sica-business.herokuapp.com/_user
	2. Verbo: GET
	3. Authorization: valor recebido no passo anterior
 
 O resultado esperado para esta requisição é:
```   
 {
"email": "abcd@gmail.com",
"name": "Name",
"picture": "https://lh3.googleusercontent.com/a-/abcd",
"authorization": "123456789"
 ```   
}
   
 
 
 

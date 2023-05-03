# Projeto Rede Social SYSMAP

💎 O objetivo principal é desenvolver uma aplicação simulando uma rede social com o back-end (API Java) e front-end (ReactJs) proposto pela empresa e para 
documentação será utilizado o Swagger.

## 🛑 Pré-Requisitos
✅ Java JDK 17 </br >
✅ IDE para desenvolvimento Java </br >
✅ Spring boot 3+ </br >
✅ Banco dados MongoDB </br >
✅ Docker </br >

## 👣 Passo-a-Passo
BACK-END
1. Neste projeto foram aplicadas técnicas de controle com camadas de API, DATA, EXCEPTION e 
SERVICE, para modelar aplicação.
2. No Pacote API foram criadas as subcamadas de CONTROLLER e EXCEPTION. A CONTROLLER foram criados os mapeamentos, por ser uma API usamos o padrão REST com as 
anotações específicas para recursos HTTPs, já na EXCEPTION foram criadas os tratamentos das exceções utilizando a EXCEPTIONHANDLER para 
customizar o retorno das mensagens.;
3. Do pacote DATA foram criadas subclasses ENTITIES e REPOSITORY. A ENTITIES foram criados os requisitos e regras de negócios, já na REPOSITORY foi criado a 
persistência, onde a classe estende a interface MongoRepository para utilização de recursos específicos como CRUD.
4. No pacote SERVICE foi criada a configuração para requisições, retornos e interface implementada para retorno da CONTROLLER.
5. A documentação foi criada com SWAGGER 3, onde foi aplicada apenas às dependências do SWAGGER 3 no pom.xml para descrever a API RESTFul usando JSON.

## 👏 Conclusão
Neste projeto foi possível aplicar técnicas de desenvolvimento web através de uma API RESTFul.

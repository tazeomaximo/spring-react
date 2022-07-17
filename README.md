# Spring e React

* Projeto Demo feito a partir das aulas disponibilizadas pelo site [DevSuperior](https://devsuperior.com.br/)

- Link do projeto hospedado https://dsmeta-spring-react.netlify.app/

## Ferramentas utilizadas
* Hospedagem do backend no [Heroku](https://www.heroku.com/)
* Hospedagem do frontend no [Netlify](https://www.netlify.com/)
* Envio de SMS pelo [Twillio](https://www.twilio.com/)
* Banco de dados H2
* Spring
  * lombok
* React
  * axios@0.27.2
  * react-datepicker@4.8.0 
    * @types/react-datepicker@4.4.2
  * react-toastify@9.0.5

## Comandos

### Heroku
```
heroku -v
heroku login
heroku git:remote -a <nome-do-app>
git remote -v
git subtree push --prefix backend heroku main
```

### YARN
* Criar projeto react
```
yarn create vite frontend --template react-ts
```
* Iniciar aplicação react em dev
```
yarn dev
```
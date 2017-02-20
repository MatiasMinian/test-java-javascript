# Test Java Javascript

- Descargar o clonar proyecto.
- Correr script init.sql en MySql. Usuario: root y contraseña: root.
- Ir a la carpeta client y ejecutar los siguientes comandos en orden:
  - npm install
  - npm run production
- Ir a la carpeta server y ejecutar mvn spring-boot:run
- Entrar en localhost:8080 para ver la app.
- API:
  - localhost:8080/api/users
  - localhost:8080/api/quotation/dollar
  - localhost:8080/api/quotation/peso
  - localhost:8080/api/quotation/real

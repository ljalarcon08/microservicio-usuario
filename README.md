# microservicio-usuario

Contiene controlador para administracion de usuarios:

- Actualizar usuario
- Eliminar usuario
- Buscar usuario

- Crear rol
- Actualizar rol
- Eliminar rol
- Buscar rol

## Ejecución

1. Crear ejecutable: mvn clean package
2. java -jar microservicio-usuario.jar --spring.profiles.active=dev
3. Desde navegador, ingresar a http://localhost:8088

##Swagger

http://localhost:8088/usuario/swagger-ui.html

## Docker

Para creacion en docker revisar Dockerfile
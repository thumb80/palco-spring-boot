# palco-spring-boot

Spring Boot Application For CRUD Operations with MySQL Database

## Application Properties :
```
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/databse
spring.datasource.username=username
spring.datasource.password=password
```
## Database MySQL Schema :

| Field  | Type        | Null | Key |   Extra        |
|--------|-------------|------|-----|----------------|
| id     | mediumint   | NO   | PRI | auto_increment |
| artist | varchar(50) | NO   |     |                |
| place  | varchar(60) | NO   |     |                |
| city   | varchar(50) | NO   |     |                |
| time   | datetime    | NO   |     |                |

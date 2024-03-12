# Introduce

Docker Secret을 사용해 Spring Boot 애플리케이션의 데이터베이스와 관련된 민감한 환경 변수를 안전하게 설정

</br>

# resources/application.yml

docker-secret의 bind-path를 사용해 DockerSecretProcessor를 사용하고, 동시에 Docker Secret 변수들을 삽입함

```yml

spring:
  datasource:
    url: ${docker-secret-mysql-url}
    username: ${docker-secret-mysql-user}
    password: ${docker-secret-mysql-user-pw}

docker-secret:
  bind-path: /run/secrets

  ...

```

</br>

# resources/META-INF/spring.factories

DockerSecretProcessor의 자동구성 설정을 위해 spring.factories 을 설정함

```factories
org.springframework.boot.env.EnvironmentPostProcessor=common.refactoring.DockerSecretProcessor
```
</br>

# Dockerfile

Docker Image 생성용

```Dockerfile
FROM openjdk:17-alpine

# 작업 디렉토리 설정
WORKDIR /app

# 호스트의 target 디렉토리에서 JAR 파일을 컨테이너의 /app 디렉토리로 복사
COPY /docker-secret-with-springboot/refactoring/build/libs/refactoring-0.0.1-SNAPSHOT.jar refactoring-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "refactoring-0.0.1-SNAPSHOT.jar"]
```

</br>

# Docker Secret Setting

Docker Secret으로 사용할 변수들을 선언함

```shell
# DB URL
echo -n "jdbc:mysql://YOUR_IP_OR_DOMAIN:DB_PORT/DB_NAME?useSSL=false&allowPublicKeyRetrieval=true"| sudo docker secret create mysql-url -
```

```shell
# DB USER
echo -n "DB_USER"| sudo docker secret create mysql-user -
```

```shell
# DB PASSWORD
echo -n "DB_PASSWORD"| sudo docker secret create mysql-user-pw -
```

</br>

# Docker Secret Apply

```shell
sudo docker stack deploy -c docker-compose.yml refacotring
```

</br>

# Blog

https://velog.io/@gudtjr2949/Docker-Secret-Spring-Boot-MySQL-1

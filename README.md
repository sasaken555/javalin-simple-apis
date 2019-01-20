# Kotlin Simple CRUD API with Javalin

## About

Java と Kotlin の Web Application Framework の Javalin で簡単な REST API を作成するプロジェクトです。
Javalin 公式のチュートリアル[Kotlin CRUD REST API](https://javalin.io/tutorials/simple-kotlin-example)をベースにしています。

上記のチュートリアルとはクラス構成を変えています。

```
/src/main/kotlin
  |- Application.kt
  |- /service
       |- UserSerice.kt
  |- /repository
       |- UserRepository.kt
  |- /entity
       |- UserEntity.kt
```

外部のDBとの連携は行なっていませんが今後追加予定です!!

## Usage

### Gradle

```bash
./gradlew build
java -jar javalin-qs-1.0.0-SNAPSHOT.jar
```

### Docker

```bash
docker build -t javalin-simple-apis:1.0.0 .
docker run --rm -p 7000:7000 javalin-simple-apis:1.0.0
```

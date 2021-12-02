# java-url-shortner

This is a simple project to make a url shortner backend. Feel free to fork it and  use as you want.

## Build with

- Java
- Spring
- MongoDB
- Junit
- Mockito

## How to init

This project was made to run with docker, so you just have to have maven installed to build the project and start the docker.

Commands:
```
mvn clean install
docker-compose up --build 
```

## API

How this project is a api backend, I added a postman collection to help you test it. Import it in your postman and run the api requests.

## MongoDB Web Console

To check mongo collections, just access mongo-express on your browser: [mongo-express](http://localhost:8081/)
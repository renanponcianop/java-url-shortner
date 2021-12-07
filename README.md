# java-url-shortner

This is a simple project to make a url shortner backend. Feel free to fork it and  use as you want.

## What the project do?

This project is only to short a URL and contabilizate access count. I'm also created a service to create a QRCode, so, It keeps redirecting to the target URL but also counting the access.

## Build with

- Java
- Spring
- MongoDB
- Junit
- Mockito

## How to init

This project was made to run with docker, so you just need to have docker installed.

Commands:
```
docker-compose up --build 
```

## API

How this project is a api backend, I added a postman collection to help you test it. Import it in your postman and run the api requests.

## MongoDB Web Console

To check mongo collections, just access mongo-express on your browser: [mongo-express](http://localhost:8081/)
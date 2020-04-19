# Oxus LOAN referential component

## Build from source
mvn clean install docker:build

## Pull existing image
docker pull oxuscloud/refarch-oxus-loan

## Run on local
docker run -p 8082:8080 -t oxuscloud/refarch-oxus-loan

## Swagger UI
http://localhost:8082/

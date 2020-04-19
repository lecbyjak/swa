# Oxus CRM referential component

## Build from source
mvn clean install docker:build

## Pull existing image
docker pull oxuscloud/refarch-oxus-crm

## Run on local
docker run -p 8081:8080 -t oxuscloud/refarch-oxus-crm

## Swagger UI
http://localhost:8081/

## Mock Data
client id 1-5
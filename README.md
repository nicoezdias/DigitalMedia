# DigitalMedia

### Lamentablemente no pude terminar de dockerizar el microservicio getway-api, mando el poryecto entero pero para probar su correcto funcionamiento debera provarlo localmente

### Correr el doker-compose.yml para levantar bases de datos , eureka y keycloak.

### Luego levantar el resto de los servicios.

## Preconditions

> docker installed

## make.sh

### In the main folder use the command `sh make.sh` to start the whole project.

## Keycloak

### Keycloak realm imports/exports are done via Docker volumes

## Ports

```
Keycloak: 8082
Eureka: 8761
Gateway: 8080
Movies: 8086
Users: 8087
Bills: 8088
```

## gateway-api

### Use the browser to test the gateway-api microservice

# cd eureka-service/
# docker build . -t eureka-service
# cd ..

# cd movies-api/
# docker build . -t movies-service
# cd ..

# cd ms-bills/
# docker build . -t bills-service
# cd ..

# cd users-service/
# docker build . -t users-service
# cd ..

cd gateway-api/
docker build . -t gateway-service
cd ..

docker-compose up
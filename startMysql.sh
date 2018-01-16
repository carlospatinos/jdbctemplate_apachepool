docker run --name mysql -e MYSQL_ROOT_PASSWORD=secret-pw -d mysql:5
docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mysql
docker logs -f mysql
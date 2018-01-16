docker run --name mysql -e MYSQL_ROOT_PASSWORD=secret-pw -d mysql:5
docker logs -f mysql
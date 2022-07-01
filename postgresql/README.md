docker run -d -it --rm --name crud-quarkus-postgres -p 5432:5432 -e POSTGRES_DB=crudquarkus -e POSTGRES_PASSWORD=password -e POSTGRES_USER=postgres -v $(pwd)/db/scripts/init.sql:/docker-entrypoint-initdb.d/init.sql:ro -v $(pwd)/db/scripts/insertdata.sql:/docker-entrypoint-initdb.d/insertdata.sql:ro -v $(pwd)/data/datasource.csv:/data/datasource.csv:ro postgres:12

docker exec -it crud-quarkus-postgres /bin/bash

psql -U postgres postgres

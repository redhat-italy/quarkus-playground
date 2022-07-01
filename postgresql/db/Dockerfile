FROM postgres:alpine
ADD scripts/init.sql /docker-entrypoint-initdb.d
ADD scripts/insertdata.sql /docker-entrypoint-initdb.d
RUN chmod a+r /docker-entrypoint-initdb.d/*
## Docker-Mysql:

### Run cmd to start mysql in docker, if image not found it will pull and start.

```docker start --detach \ 
  --env MYSQL_ROOT_PASSWORD=admin \
  --env MYSQL_USER=todos-user \
  --env MYSQL_PASSWORD=admin \
  --env MYSQL_DATABASE=todos \
  --name mysql \
  --publish 3306:3306 \
  mysql:8-oracle
```

### Open-Container-Terminal:

```docker exec -it mysql mysql -u todos-user -p  admin```


### Mysql-Commands:


>SHOW DATABASES;
```
+--------------------+
| Database           |
+--------------------+
| information_schema |
| performance_schema |
| todos              |
+--------------------+
```

>USE todos;

```
Database changed
```

>SHOW TABLES;

```
+-----------------+
| Tables_in_todos |
+-----------------+
| todo            |
| todo_sequence   |
+-----------------+
```

>SELECT * FROM todo;

```
+-----+-------------+------------+-------------+----------+
| id  | description | done       | target_date | username |
+-----+-------------+------------+-------------+----------+
| 100 | Learn AWS   | 0x00       | 2024-11-18  | admin    |
+-----+-------------+------------+-------------+----------+

```

> DROP DATABASE todos;

> CREATE DATABASE todos;


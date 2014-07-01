twilio-activiti
===============

Test code for integrating Activiti (http://www.activiti.org/) and Twilio (https://www.twilio.com/)

expects environment:
```
DATABASE_URL=....
TWILIO_AUTH_TOKEN=...
JDBC_DRIVER_CLASS=...
DATABASE_TYPE=...
```

for example:
```
heroku config:set DATABASE_URL=...
heroku config:set TWILIO_AUTH_TOKEN=...
heroku config:set JDBC_DRIVER_CLASS=...
heroku config:set DATABASE_TYPE=...
```

For MySQL:com.mysql.jdbc.Driver
```
JDBC_DRIVER_CLASS=com.mysql.jdbc.Driver
DATABASE_TYPE=mysql
```

For Postgres:
```
DATABASE_URL -> already set by Heroku
heroku config:set TWILIO_AUTH_TOKEN=
heroku config:set JDBC_DRIVER_CLASS="org.postgresql.Driver"
heroku config:set DATABASE_TYPE="postgres"
```

Deploy SQL to Heroku:
```
heroku pg:psql < git/Activiti/modules/activiti-engine/src/main/resources/org/activiti/db/create/activiti.postgres.create.engine.sql
heroku pg:psql < git/Activiti/modules/activiti-engine/src/main/resources/org/activiti/db/create/activiti.postgres.create.history.sql
heroku pg:psql < git/Activiti/modules/activiti-engine/src/main/resources/org/activiti/db/create/activiti.postgres.create.identity.sql
```
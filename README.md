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

for example, with Postgres on Heroku
```
DATABASE_URL -> already set by Heroku
heroku config:set TWILIO_AUTH_TOKEN=
heroku config:set JDBC_DRIVER_CLASS="org.postgresql.Driver"
heroku config:set DATABASE_TYPE="postgres"
```

For MySQL on dev machine
```
export JDBC_DRIVER_CLASS="com.mysql.jdbc.Driver"
export DATABASE_TYPE="mysql"
```

Deploy SQL to Heroku:
```
heroku pg:psql < git/Activiti/modules/activiti-engine/src/main/resources/org/activiti/db/create/activiti.postgres.create.engine.sql
heroku pg:psql < git/Activiti/modules/activiti-engine/src/main/resources/org/activiti/db/create/activiti.postgres.create.history.sql
heroku pg:psql < git/Activiti/modules/activiti-engine/src/main/resources/org/activiti/db/create/activiti.postgres.create.identity.sql
```

In Twilio, create a new app with endpoint:
```
http://example.com/sms/create
```
Send SMS to your Twilio phone number, and go to http://example.com/myapp/list

Run locally with:
```
java $JAVA_OPTS -jar target/dependency/jetty-runner.jar --port $PORT target/*.war
```
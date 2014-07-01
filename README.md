twilio-activiti
===============

Test code for integrating Activiti (http://www.activiti.org/) and Twilio (https://www.twilio.com/)

expects environment:
DATABASE_URL=....
TWILIO_AUTH_TOKEN=...
JDBC_DRIVER_CLASS=...
DATABASE_TYPE=...


for example:
heroku config:set DATABASE_URL=...
heroku config:set TWILIO_AUTH_TOKEN=...
heroku config:set JDBC_DRIVER_CLASS=...
heroku config:set DATABASE_TYPE=...

For MySQL:com.mysql.jdbc.Driver

JDBC_DRIVER_CLASS=com.mysql.jdbc.Driver
DATABASE_TYPE=mysql,pg

For Postgres:

DATABASE_URL -> already set by Heroku
heroku config:set TWILIO_AUTH_TOKEN=
heroku config:set JDBC_DRIVER_CLASS="org.postgresql.Driver"
heroku config:set DATABASE_TYPE="postgres"
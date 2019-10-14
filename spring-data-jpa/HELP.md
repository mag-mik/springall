* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

mysql> create database db_example; -- Creates the new database
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

$ curl localhost:8080/demo/add -d name=First -d email=someemail@someemailprovider.com
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
-----------------------------------------------------------------
mysql> create database db_example;|Creates the new database
---|---
mysql> create user 'springuser'@'%' identified by 'ThePassword';|Creates the user
mysql> grant all on db_example.* to 'springuser'@'%';|Gives all privileges to the new user on the newly created database

**add new User**
$ curl localhost:8080/demo/add -d name=First -d email=someemail@someemailprovider.com


[All JPA Annotations](https://dzone.com/articles/all-jpa-annotations-mapping-annotations)
# Types of relationships

* @OneToOne
* @OneToMany

[Configuring Separate Spring DataSource for Tests](https://www.baeldung.com/spring-testing-separate-data-source)

Add initial data to db 
-> create insert SQL -> move to resources folder -> import.sql (Hibernate) / data.sql (Spring JDBC support) will be executed after starting app.
-> hibernate -> add to properties
spring.jpa.properties.hibernate.hbm2ddl.import_files=import_active_users.sql,import_inactive_users.sql
-> JDBC
spring.datasource.data=import_active_users.sql,import_inactive_users.sql

----------------
https://www.baeldung.com/database-auditing-jpa
@MappedSuperclass annotation to
 allow an entity to inherit properties from a base class.
----------------
@Audited
properties - spring.jpa.properties.org.hibernate.envers.audit_table_suffix=_SUF (default _AUD)
pom - hibernate-envers 5.3.9.Final
Access the audit history AuditReader
 reader = AuditReaderFactory.get(EntityManagerEm);
getHistory
 = reader.getRevison(clazz,id)

historyService.getHistory(Document.class, id)
-------
abstaract parent Audit

@MappedSuperclass

@EnableJpaAuditing - to the main App class

# DON'T WORK 
# FIND NEW SPRING HIBERNATE EXAMPLE 

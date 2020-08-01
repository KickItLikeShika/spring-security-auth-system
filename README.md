# Spring Security Authentication System

Securing Web app and authentication using Spring Boot, Spring Security, MySQL, and JPA.
It shows some features of Spring security, how to login/register, and make some other security configurations.
It also uses Thymeleaf as a template engine.

# Why? 

I wrote this because I had to get into Spring security and found that actually quite hard to find good examples and documentation. I hope others can learn from this.

# Run
before running the app you should write this query in your database

    REPLACE INTO `role` VALUES (1,'ADMIN');

- 'role' is the name of the roles tables

# Hints
 - You have to edit the data source in the application.properties file depends on your data source

# Servlet-CRUD-Web-Application
This Project uses Java, SQL, Html, Css, JDBC and Java Servlet for basic CRUD Operations
Firstly, If any User wants to Run this Project, They should create DataBase name called 'btm' in Mysql and inside that DataBase they should 
create Table name called 'CRUD'. Query is : CREATE TABLE CRUD 
   (EMAIL VARCHAR2(50) NOT NULL, 
	 NAME  VARCHAR2(50) NOT NULL, 
	 PHONE BIGINT(20), 
	 COLLAGE VARCHAR2(50) NOT NULL, 
	 DEPT VARCHAR2(50) NOT NULL,
	 YEAR VARCHAR2(10) NOT NULL,
	 Per10 DECIMAL(4,2) NOT NULL,
	 Perc12 DECIMAL(4,2) NOT NULL,
	 DEGREEPER DECIMAL(4,2) NOT NULL,
	 GENDER VARCHAR2(10) NOT NULL,
	 PASS VARCHAR2(100) NOT NULL,
	 CONSTRAINT "PHONE_PK" PRIMARY KEY ("PHONE")
   )

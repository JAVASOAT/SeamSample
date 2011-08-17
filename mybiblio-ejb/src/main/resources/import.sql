-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'

/*
Created: 11/06/2010
Modified: 11/06/2010
Model: RE MySQL 5.1
Database: MySQL 5.1
*/
drop DATABASE IF EXISTS biblio;
CREATE DATABASE IF NOT EXISTS biblio;

USE biblio;

-- Drop tables section ---------------------------------------------------

DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS RENT;
DROP TABLE IF EXISTS CATEGORY_BOOK;
DROP TABLE IF EXISTS CATEGORY;
DROP TABLE IF EXISTS BOOK;

-- Create tables section -------------------------------------------------

-- Table BOOK
CREATE TABLE BOOK
(
	ID_BOOK Int(9) UNSIGNED NOT NULL AUTO_INCREMENT,
	ISBN Varchar(50) NOT NULL,
	TITLE Varchar(50) NOT NULL,
	AUTHOR Varchar(50) NOT NULL,
	SHORT_DESCRIPTION Text,
	LONG_DESCRIPTION Text,
	IMAGE_NAME Varchar(150),
	PRIMARY KEY (ID_BOOK)
) ENGINE = InnoDB
  ROW_FORMAT = Compact
;

-- Table USER
CREATE TABLE USER
(
	ID_USER Int(9) UNSIGNED NOT NULL AUTO_INCREMENT,
	NAME Varchar(100) NOT NULL,
	FIRSTNAME Varchar(100) NOT NULL,
	EMAIL Varchar(50) NOT NULL,
	PASSWORD Varchar(50) NOT NULL,
	PRIMARY KEY (ID_USER)
) ENGINE = InnoDB
  ROW_FORMAT = Compact
;

-- Table CATEGORY
CREATE TABLE CATEGORY
(
	ID_CATEGORY Int(9) UNSIGNED NOT NULL AUTO_INCREMENT,
	NAME_CATEGORY Varchar(150),
	PRIMARY KEY (ID_CATEGORY)
) ENGINE = InnoDB
  ROW_FORMAT = Compact
;

-- Table RENT
CREATE TABLE RENT
(
	ID_RENT Int(9) UNSIGNED NOT NULL AUTO_INCREMENT,
	ID_USER Int(9) UNSIGNED NOT NULL,
	ID_BOOK Int(9) UNSIGNED NOT NULL,
	DATE_RENT Timestamp NULL,
	DATE_RETURN Timestamp NULL,
	PRIMARY KEY (ID_RENT)
) ENGINE = InnoDB
  ROW_FORMAT = Compact
;

ALTER TABLE RENT ADD CONSTRAINT RENT_FK1 FOREIGN KEY (ID_USER) REFERENCES USER (ID_USER) ON DELETE NO ACTION ON UPDATE NO ACTION
;
ALTER TABLE RENT ADD CONSTRAINT RENT_FK2 FOREIGN KEY (ID_BOOK) REFERENCES BOOK (ID_BOOK) ON DELETE NO ACTION ON UPDATE NO ACTION
;

-- Table CATEGORY_BOOK
CREATE TABLE CATEGORY_BOOK
(
	ID_CATEGORY_BOOK Int(9) UNSIGNED NOT NULL AUTO_INCREMENT,
	ID_CATEGORY Int(9) UNSIGNED NOT NULL,
	ID_BOOK Int(9) UNSIGNED NOT NULL,
	PRIMARY KEY (ID_CATEGORY_BOOK),
	FOREIGN KEY (ID_CATEGORY) REFERENCES CATEGORY (ID_CATEGORY) ON DELETE NO ACTION ON UPDATE NO ACTION,
	FOREIGN KEY (ID_BOOK) REFERENCES BOOK (ID_BOOK) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  ROW_FORMAT = Compact
;
CREATE INDEX id_category USING BTREE ON CATEGORY_BOOK (ID_CATEGORY)
;



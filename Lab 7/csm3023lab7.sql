CREATE DATABASE csm3023lab7;

CREATE TABLE users(
userid VARCHAR (15) NOT NULL,
firstname VARCHAR (35),
lastname VARCHAR (15),
CONSTRAINT users_userid_pk PRIMARY KEY(userid));

CREATE TABLE userprofile (
    username CHAR(15) PRIMARY KEY,
    icno CHAR(15),
    firstname VARCHAR(50)
);
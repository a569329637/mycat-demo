-- 创建数据库
drop database if exists `mycat-demo1`;
create database `mycat-demo1`;
use `mycat-demo1`;

-- 创建表
drop table if exists t_user;
create table t_user (
	id int not null auto_increment primary key,
	user_name varchar(20) not null,
	password varchar(20) not null
);

-- 创建数据库
drop database if exists `mycat-demo2`;
create database `mycat-demo2`;
use `mycat-demo2`;

-- 创建表
drop table if exists t_user;
create table t_user (
	id int not null auto_increment primary key,
	user_name varchar(20) not null,
	password varchar(20) not null
);

-- 创建数据库
drop database if exists `mycat-demo3`;
create database `mycat-demo3`;
use `mycat-demo3`;

-- 创建表
drop table if exists t_user;
create table t_user (
	id int not null auto_increment primary key,
	user_name varchar(20) not null,
	password varchar(20) not null
);


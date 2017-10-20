-- 创建数据库
drop database if exists mycat_demo1;
create database mycat_demo1;
use mycat_demo1;

-- 创建表
drop table if exists t_user;
create table t_user (
	id int not null auto_increment primary key,
	user_name varchar(20) not null,
	password varchar(20) not null
);

-- 创建数据库
drop database if exists mycat_demo2;
create database mycat_demo2;
use mycat_demo2;

-- 创建表
drop table if exists t_user;
create table t_user (
	id int not null auto_increment primary key,
	user_name varchar(20) not null,
	password varchar(20) not null
);

-- 创建数据库
drop database if exists mycat_demo3;
create database mycat_demo3;
use mycat_demo3;

-- 创建表
drop table if exists t_user;
create table t_user (
	id int not null auto_increment primary key,
	user_name varchar(20) not null,
	password varchar(20) not null
);


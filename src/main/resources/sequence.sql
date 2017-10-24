-- 创建MYCAT_SEQUENCE表
DROP TABLE IF EXISTS MYCAT_SEQUENCE;
CREATE TABLE MYCAT_SEQUENCE (
  name VARCHAR(50) NOT NULL,
  current_value INT NOT NULL,
  increment INT NOT NULL DEFAULT 100,
  PRIMARY KEY(name)
) ENGINE=InnoDB;

-- 获取当前sequence的值（返回当前值,增量）
DROP FUNCTION IF EXISTS mycat_seq_currval;
DELIMITER $
CREATE FUNCTION mycat_seq_currval(seq_name VARCHAR(50)) RETURNS varchar(64)     CHARSET utf8
DETERMINISTIC
	BEGIN
		DECLARE retval VARCHAR(64);
		SET retval="-999999999,null";
		SELECT concat(CAST(current_value AS CHAR),",",CAST(increment AS CHAR)) INTO retval FROM MYCAT_SEQUENCE WHERE name = seq_name;
		RETURN retval;
	END $
DELIMITER ;

-- 设置sequence值
DROP FUNCTION IF EXISTS mycat_seq_setval;
DELIMITER $
CREATE FUNCTION mycat_seq_setval(seq_name VARCHAR(50),value INTEGER) RETURNS     varchar(64) CHARSET utf8
DETERMINISTIC
	BEGIN
		UPDATE MYCAT_SEQUENCE
		SET current_value = value
		WHERE name = seq_name;
		RETURN mycat_seq_currval(seq_name);
	END $
DELIMITER ;

-- 获取下一个sequence值
DROP FUNCTION IF EXISTS mycat_seq_nextval;
DELIMITER $
CREATE FUNCTION mycat_seq_nextval(seq_name VARCHAR(50)) RETURNS varchar(64)     CHARSET utf8
DETERMINISTIC
	BEGIN
		UPDATE MYCAT_SEQUENCE
		SET current_value = current_value + increment WHERE name = seq_name;
		RETURN mycat_seq_currval(seq_name);
	END $
DELIMITER ;

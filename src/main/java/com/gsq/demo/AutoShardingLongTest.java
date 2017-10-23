package com.gsq.demo;

import com.gsq.model.TravelRecord;
import com.gsq.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

/**
 * 按照 rule/auto-sharding-long 里的规则进行分表
 */
public class AutoShardingLongTest {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);

        sqlSession.delete("travelRecordMapper.delAll");

        for (int i = 0; i < 100; i ++) {
            TravelRecord travelRecord = new TravelRecord(i+1, "深圳" + i, new Timestamp(System.currentTimeMillis()));
            sqlSession.insert("travelRecordMapper.insert", travelRecord);
        }

        List<TravelRecord> list = sqlSession.selectList("travelRecordMapper.getAll");
        if (list != null) {
            for (TravelRecord travelRecord : list) {
                System.out.println("travelRecord = " + travelRecord);
            }
        }
    }
}

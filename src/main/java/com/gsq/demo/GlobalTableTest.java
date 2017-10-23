package com.gsq.demo;

import com.gsq.model.Company;
import com.gsq.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 全局表
 */
public class GlobalTableTest {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);

        sqlSession.delete("companyMapper.delAll");

        for (int i = 0; i < 5; ++ i) {
            Company company = new Company("company_name_" + i, "深圳");
            sqlSession.insert("companyMapper.insert", company);
        }

        List<Company> list = sqlSession.selectList("companyMapper.getAll");
        if (list != null) {
            for (Company company : list) {
                System.out.println("company = " + company);
            }
        }
    }
}

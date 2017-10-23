package com.gsq.demo;

import com.gsq.model.Customer;
import com.gsq.model.Order;
import com.gsq.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * ER关系分表测试
 *
 * 分表字段customer.id，分表规则如下
 * 10000=0
 * 10010=1
 * 默认=2
 */
public class ERTableTest {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(true);

        sqlSession.delete("customerMapper.delAll");
        sqlSession.delete("orderMapper.delAll");

        // 全部都插入到节点0
        Customer customer1 = new Customer(10000, "gsq", "sz");
        sqlSession.insert("customerMapper.insert", customer1);
        for (int i = 0; i < 10; i++) {
            Order order1 = new Order(null, "code_10000_" + i, 88, customer1.getId());
            sqlSession.insert("orderMapper.insert", order1);
        }

        // 全部都插入到节点1
        Customer customer2 = new Customer(10010, "gsq", "sz");
        sqlSession.insert("customerMapper.insert", customer2);
        for (int i = 0; i < 10; ++i) {
            Order order2 = new Order(null, "code_10010_" + i, 66, customer2.getId());
            sqlSession.insert("orderMapper.insert", order2);
        }

        // 全部都插入默认节点，节点2
        for (int i = 0; i < 3; i ++) {
            Customer customer3 = new Customer(10011 + i, "gsq", "sz");
            sqlSession.insert("customerMapper.insert", customer3);
            for (int j = 0; j < 5; j ++) {
                Order order3 = new Order(null, "code_" + customer3.getId() +"_" + i, 33, customer3.getId());
                sqlSession.insert("orderMapper.insert", order3);
            }
        }

        List<Customer> list = sqlSession.selectList("customerMapper.getAll");
        if (list != null) {
            for (Customer customer : list) {
                System.out.println("customer = " + customer);
                List<Order> list1 = sqlSession.selectList("orderMapper.getByCustomerId", customer.getId());
                if (list1 != null) {
                    for (Order order : list1) {
                        System.out.println("order = " + order);
                    }
                }
                System.out.println("");
            }
        }
    }
}

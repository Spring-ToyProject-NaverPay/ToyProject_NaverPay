package org.example.products.dao;

import org.example.products.database.JDBCMgr;
import org.example.shopping.entity.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO {
    private static ProductDAO orderDAO = null;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String SELECT_LIST = "select * from PRODUCT where pId = ?";
    private static final String SELECT_PERIOD_LIST = "select * from orderinfo where userNum = ? AND ORDERDATE >= ? AND ORDERDATE <= ?";

    // 싱글톤
    public static ProductDAO getInstance() {
        if (orderDAO == null) {
            orderDAO = new ProductDAO();
        }
        return orderDAO;
    }
    // 자료 만들어서 데이터를 삽입하는 method임
    public List<Product> getAlllist(int pId) {
        List<Product> orderList = new ArrayList<>();

        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SELECT_LIST);
            stmt.setString(1, String.valueOf(pId));

            rs = stmt.executeQuery();
            while (rs.next()) {
                String pName = rs.getString("pName");
                int pPrice = rs.getInt("pPrice");
                String pCompany = rs.getString("pCompany");
                String pCompanyPhone = rs.getString("pCompanyPhone");

                orderList.add(new Product(pName, pPrice, pCompany, pCompanyPhone));
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            JDBCMgr.close(rs, stmt, conn);
        }
        return orderList;
    }





} // 클래스 마지막



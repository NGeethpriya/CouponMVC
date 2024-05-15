package com.coupon.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.coupon.models.Product;
import com.coupon.utility.ConnectDatabase;

public class ProductDAO {
	private Connection connect = null;
	private String sql;
	private PreparedStatement pstate = null;

	public ProductDAO() {
		connect = ConnectDatabase.connect();
	}

	public String save(Product prod) {
		String sql1 = "select * from product where pname = ?";
		String message = null;
		try {
			PreparedStatement pstate1 = connect.prepareStatement(sql1);
			pstate1.setString(1, prod.getPname());
			ResultSet queryResult = pstate1.executeQuery();
			if (queryResult.next()) {
				message = "exists";
			}else {
				sql = "insert into product (pname, description, price, ccode) values(?, ?, ?, ?)";
				try {
					pstate = connect.prepareStatement(sql);
					pstate.setString(1, prod.getPname());
					pstate.setString(2,prod.getDescription());
					pstate.setBigDecimal(3,prod.getPrice());
					pstate.setString(4,prod.getCcode());
					int insertProduct = pstate.executeUpdate();
					if (insertProduct > 0) 
						message = "created";
					else
						message = "invalid";
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
}

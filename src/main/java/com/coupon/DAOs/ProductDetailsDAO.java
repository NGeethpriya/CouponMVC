package com.coupon.DAOs;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coupon.models.Product;
import com.coupon.utility.ConnectDatabase;

public class ProductDetailsDAO {

	public static List<Product> productList() {

		Connection connect = ConnectDatabase.connect();
		List<Product> plist = new ArrayList<Product>();
		String sql = "select * from product";
		try {
			PreparedStatement pstate = connect.prepareStatement(sql);
			ResultSet queryResult = pstate.executeQuery();
			while (queryResult.next()) {

				int sno = queryResult.getInt(1);
				String pname = queryResult.getString(2);
				String description = queryResult.getString(3);
				BigDecimal price = queryResult.getBigDecimal(4);
				String ccode = queryResult.getString(5);
				
				Product prod = new Product();

				prod.setPid(sno);
				prod.setPname(pname);
				prod.setDescription(description);
				prod.setPrice(price);
				prod.setCcode(ccode);

				plist.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plist;
	}
}

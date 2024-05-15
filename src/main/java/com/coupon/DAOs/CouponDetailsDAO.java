package com.coupon.DAOs;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coupon.models.Coupon;
import com.coupon.utility.ConnectDatabase;

public class CouponDetailsDAO {

	public static List<Coupon> couponList() {
		
		Connection connect = ConnectDatabase.connect();
		List<Coupon> clist = new ArrayList<Coupon>();
		String sql = "select * from ccoupon";
		try {
			PreparedStatement pstate = connect.prepareStatement(sql);
			ResultSet queryResult = pstate.executeQuery();
			while (queryResult.next()) {

				int sno = queryResult.getInt(1);
				String ccode = queryResult.getString(2);
				BigDecimal discount = queryResult.getBigDecimal(3);
				String edate = queryResult.getString(4);
				
				Coupon coup = new Coupon();
				coup.setCid(sno);
				coup.setCcode(ccode);
				coup.setDiscount(discount);
				coup.setEdate(edate);
				
				clist.add(coup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clist;
	}

	}


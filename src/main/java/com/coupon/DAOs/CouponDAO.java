package com.coupon.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.coupon.models.Coupon;
import com.coupon.utility.ConnectDatabase;

public class CouponDAO {
	private Connection connect = null;
	private String sql;
	private PreparedStatement pstate = null;

	public CouponDAO() {
		connect = ConnectDatabase.connect();
	}

	public String save(Coupon coup) {
		String sql1 = "select * from ccoupon where ccode =  ?";
		String message = null;
		try {
			PreparedStatement pstate1 = connect.prepareStatement(sql1);
			pstate1.setString(1, coup.getCcode());
			ResultSet queryResult = pstate1.executeQuery();
			if (queryResult.next()) {
				message = "exists";
			} else {
				sql = "insert into ccoupon (ccode, discount, edate) values(?, ?, ?)";
				try {
					pstate = connect.prepareStatement(sql);
					pstate.setString(1, coup.getCcode());
					pstate.setBigDecimal(2, coup.getDiscount());
					pstate.setString(3, coup.getEdate());
					int insertCoupon = pstate.executeUpdate();
					if (insertCoupon > 0)
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

	public Coupon find(String ccode) {
		Coupon coup = new Coupon();
		sql = "select * from ccoupon where ccode = ?";
		try {
			pstate = connect.prepareStatement(sql);
			pstate.setString(1, ccode);
			ResultSet resultCoupon = pstate.executeQuery();
			if (resultCoupon.next()) {
				coup.setCcode(resultCoupon.getString(2));
				coup.setDiscount(resultCoupon.getBigDecimal(3));
				coup.setEdate(resultCoupon.getString(4));
			}else {
				coup.setCcode("0");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coup;
	}
}

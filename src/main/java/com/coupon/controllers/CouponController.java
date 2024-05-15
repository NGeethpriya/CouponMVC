package com.coupon.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;

import com.coupon.DAOs.CouponDAO;
import com.coupon.models.*;

@WebServlet("/ccoupon")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String ccode, edate, discount;
	private BigDecimal bdiscount;
	private Coupon coup = null;
	private CouponDAO cdao = new CouponDAO();
	private RequestDispatcher rdispatch = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ccode = request.getParameter("ccode");
		discount = request.getParameter("discount");
		if (discount.length() > 2) {
			request.setAttribute("message", "Enter a single or 2-digit number for discount");
			rdispatch = request.getRequestDispatcher("CreateCoupon.jsp");
		} else {
			edate = request.getParameter("edate");
			bdiscount = new BigDecimal(discount);
			Coupon coup = new Coupon();
			coup.setCcode(ccode);
			coup.setDiscount(bdiscount);
			coup.setEdate(edate);
			String message = cdao.save(coup);
			if (message.equals("exists")) {
				request.setAttribute("message", "Coupon Code already exists");
				rdispatch = request.getRequestDispatcher("CreateCoupon.jsp");
			} else if (message.equals("created")) {
				request.setAttribute("mess", "Coupon has been created");
				rdispatch = request.getRequestDispatcher("Success.jsp");
			} else if (message.equals("invalid")) {
				request.setAttribute("message", "Invalid Inputs. Try again");
				rdispatch = request.getRequestDispatcher("CreateCoupon.jsp");
			}
		}
		rdispatch.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ccode = request.getParameter("ccode");
		coup = cdao.find(ccode);
		if (coup.getCcode().equals("0")) {
			request.setAttribute("message", "Coupon does not exist");
			rdispatch = request.getRequestDispatcher("FindCoupon.jsp");
		} else {
			request.setAttribute("coup", coup);
			rdispatch = request.getRequestDispatcher("Success.jsp");
		}
		rdispatch.forward(request, response);

	}
}

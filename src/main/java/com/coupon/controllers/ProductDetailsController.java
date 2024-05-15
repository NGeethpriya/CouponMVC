package com.coupon.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.coupon.DAOs.ProductDetailsDAO;
import com.coupon.models.Product;
@WebServlet ("/productDetails")
public class ProductDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Product> prodList = ProductDetailsDAO.productList();
	request.setAttribute("plist", prodList);
	RequestDispatcher rdispatch = request.getRequestDispatcher("ProductDetails.jsp");
	rdispatch.forward(request, response);
	}
}

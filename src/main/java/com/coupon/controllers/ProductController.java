package com.coupon.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import com.coupon.DAOs.ProductDAO;
import com.coupon.models.Product;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/cproduct")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pname, price, description, ccode;
	private ProductDAO pdao = new ProductDAO();
	private BigDecimal bprice;
	RequestDispatcher rdispatch = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pname = request.getParameter("pname");
		description = request.getParameter("describe");
		price = request.getParameter("price");
		ccode = request.getParameter("ccode");
		bprice = new BigDecimal(price);
		Product prod = new Product();
		prod.setPname(pname);
		prod.setDescription(description);
		prod.setPrice(bprice);
		prod.setCcode(ccode);
		String message = pdao.save(prod);
		if (message.equals("exists")) {
			request.setAttribute("mess", "Product Name Already Exists, Try different name");
			rdispatch = request.getRequestDispatcher("CreateProduct.jsp");
		} else if (message.equals("created")) {
			request.setAttribute("mess", "New Product has been created");
			rdispatch = request.getRequestDispatcher("Success.jsp");
		} else if (message.equals("invalid")) {
			request.setAttribute("mess", "Invalid Inputs. Try Again");
			rdispatch = request.getRequestDispatcher("CreateProduct.jsp");
		}

		rdispatch.forward(request, response);
	}
}

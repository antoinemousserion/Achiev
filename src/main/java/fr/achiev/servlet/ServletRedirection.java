package fr.achiev.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.achiev.bean.UserAchiev;

//@WebServlet(urlPatterns = { "/index.html", "/signin.html", "/login.html", "/account.html" })
public class ServletRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		UserAchiev UserAchiev = (UserAchiev) request.getSession().getAttribute("UserConnected");
		System.out.println(UserAchiev);
		List<String> accesIfConnected = new ArrayList<>();
		accesIfConnected.add("/account.html");

		response.setHeader("Cache-Control", "no-cache");

		if (path.equals("/index.html")) {
			request.getRequestDispatcher("/WEB-INF/index.html").forward(request, response);
			return;
		}
		if (UserAchiev != null) {
			
			System.out.println("on passe la 1");
			request.getRequestDispatcher("/WEB-INF/IsConnected" + path).forward(request, response);
		} else {
			
			if (accesIfConnected.contains(path)) {
				System.out.println("on passe la 2");
				request.getRequestDispatcher("/WEB-INF/error.html").forward(request, response);
			} else {
				System.out.println("on passe la 3");
				request.getRequestDispatcher("/WEB-INF/NotConnected" + path).forward(request, response);

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

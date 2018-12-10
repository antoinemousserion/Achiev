package fr.achiev.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.achiev.bean.User;

@WebServlet(urlPatterns = { "/index.html", "" })
public class ServletRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		User user = (User) request.getSession().getAttribute("User");

		response.setHeader("Cache-Control", "no-cache");
		if (path.equals("/index.html")) {
			request.getRequestDispatcher("/WEB-INF/index.html").forward(request, response);
		}
		if (user != null) {

			request.getRequestDispatcher("/WEB-INF/IsConnected" + path).forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/NotConnected" + path).forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

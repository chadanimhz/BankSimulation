package com.banksimulation.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banksimulation.dao.UserDao;
import com.banksimulation.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (MainClass.checklogin(request)) {
			processRequest(request, response);
		}else {
			showUserLoginForm(request, response);
		}

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/login":
				validateUser(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/addUser":
				showNewForm(request, response);
				break;
			case "/insertUser":
				insertUser(request, response);
				break;
			case "/deleteuser":
				deleteUser(request, response);
				break;
			case "/editUser":
				showEditForm(request, response);
				break;
			case "/updateUser":
				updateUser(request, response);
				break;
			case "/listUser":
				listUser(request, response);
				break;
			default:
				showUserLoginForm(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("message", "Logout Successfully");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login-form.jsp");
		dispatcher.forward(request, response);

	}

	private void showUserLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login-form.jsp");
		dispatcher.forward(request, response);
	}

	private void validateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String email = request.getParameter("email");
		User existingUser = userDao.selectUserByEmail(email);
		String password = request.getParameter("password");
		String ePassword = MainClass.encryptPassword(password);
		if (existingUser != null && ePassword.equals(existingUser.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("login", 1);
			session.setAttribute("type", existingUser.getType());
			session.setAttribute("userid", existingUser.getId());
			request.setAttribute("message", "Login Successfully");
			listUser(request, response);
		} else {
			request.setAttribute("message", "Invalid Username/password");
			showUserLoginForm(request, response);
		}

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<User> listUser = userDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String type = request.getParameter("type");
		String password = request.getParameter("password");
		String ePassword = MainClass.encryptPassword(password);
		User newUser = new User(name, email, type, ePassword);
		userDao.insertUser(newUser);
		response.sendRedirect("listUser");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String type = request.getParameter("type");

		User book = new User(id, name, email, type);
		userDao.updateUser(book);
		response.sendRedirect("listUser");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("listUser");

	}
}

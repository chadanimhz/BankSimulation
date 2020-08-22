//package com.banksimulation.controller;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.banksimulation.dao.UserDao;
//import com.banksimulation.model.User;
//
///**
// * Servlet implementation class UserServlet
// */
//@WebServlet("/user")
//public class UserServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private UserDao userDao;
//
//	public void init() {
//		userDao = new UserDao();
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//System.out.println(request);
//System.out.println(action);
//		try {
//			switch (action) {
//			case "/user/new":
//				showNewForm(request, response);
//				break;
//			case "/user/insert":
//				insertUser(request, response);
//				break;
//			case "/user/delete":
//				deleteUser(request, response);
//				break;
//			case "/edit":
//				showEditForm(request, response);
//				break;
//			case "/user/update":
//				updateUser(request, response);
//				break;
//			default:
//				listUser(request, response);
//				break;
//			}
//		} catch (SQLException ex) {
//			throw new ServletException(ex);
//		}
//	}
//
//	private void listUser(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//		List<User> listUser = userDao.selectAllUsers();
//		request.setAttribute("listUser", listUser);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		User existingUser = userDao.selectUser(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//		request.setAttribute("user", existingUser);
//		dispatcher.forward(request, response);
//
//	}
//
//	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String type = request.getParameter("type");
//		User newUser = new User(name, email, type);
//		userDao.insertUser(newUser);
//		response.sendRedirect("list");
//	}
//
//	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String country = request.getParameter("country");
//
//		User book = new User(id, name, email, country);
//		userDao.updateUser(book);
//		response.sendRedirect("list");
//	}
//
//	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		userDao.deleteUser(id);
//		response.sendRedirect("list");
//
//	}
//}

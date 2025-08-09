package dev.viniduminsara.pahanaedu.business.user.servlet;

import dev.viniduminsara.pahanaedu.business.user.dto.UserDTO;
import dev.viniduminsara.pahanaedu.business.user.service.UserService;
import dev.viniduminsara.pahanaedu.business.user.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "user", urlPatterns = "/login")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageTitle", "Login to Pahana Edu");
        req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            req.getSession().setAttribute("flash_error", "Username and password are required.");
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        UserDTO user = userService.findUserByUsernameAndPassword(username, password);

        System.out.println(user);
        if (user != null) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.getSession().setAttribute("flash_error", "Invalid username or password.");
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}

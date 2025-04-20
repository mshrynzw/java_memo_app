package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.MemoDAO;
import model.Memo;

@WebServlet("/add")
public class AddMemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/add.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        Memo newMemo = new Memo(title, content);
        MemoDAO memoDAO = new MemoDAO();
        memoDAO.addMemo(newMemo);
        
        response.sendRedirect("list");
    }
}
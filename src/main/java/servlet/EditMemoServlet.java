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

@WebServlet("/edit")
public class EditMemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        MemoDAO memoDAO = new MemoDAO();
        Memo memo = memoDAO.getMemoById(id);
        
        request.setAttribute("memo", memo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/edit.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        Memo updatedMemo = new Memo();
        updatedMemo.setId(id);
        updatedMemo.setTitle(title);
        updatedMemo.setContent(content);
        
        MemoDAO memoDAO = new MemoDAO();
        memoDAO.updateMemo(updatedMemo);
        
        response.sendRedirect("list");
    }
}
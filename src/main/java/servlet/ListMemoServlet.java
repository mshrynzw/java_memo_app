package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.MemoDAO;
import model.Memo;

@WebServlet("/list")
public class ListMemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        MemoDAO memoDAO = new MemoDAO();
        List<Memo> memoList = memoDAO.getAllMemos();
        
        request.setAttribute("memoList", memoList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
        dispatcher.forward(request, response);
    }
}
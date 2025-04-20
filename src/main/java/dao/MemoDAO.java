package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Memo;
import util.DBUtil;

public class MemoDAO {
    
    // すべてのメモを取得
    public List<Memo> getAllMemos() {
        List<Memo> memos = new ArrayList<>();
        Connection conn = null;
        
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM memos ORDER BY updated_at DESC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Memo memo = new Memo(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
                memos.add(memo);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        
        return memos;
    }
    
    // IDでメモを取得
    public Memo getMemoById(int id) {
        Memo memo = null;
        Connection conn = null;
        
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM memos WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                memo = new Memo(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
            }
            
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        
        return memo;
    }
    
    // メモを追加
    public boolean addMemo(Memo memo) {
        Connection conn = null;
        boolean result = false;
        
        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO memos (title, content) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memo.getTitle());
            pstmt.setString(2, memo.getContent());
            
            int rowsAffected = pstmt.executeUpdate();
            result = rowsAffected > 0;
            
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        
        return result;
    }
    
    // メモを更新
    public boolean updateMemo(Memo memo) {
        Connection conn = null;
        boolean result = false;
        
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE memos SET title = ?, content = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memo.getTitle());
            pstmt.setString(2, memo.getContent());
            pstmt.setInt(3, memo.getId());
            
            int rowsAffected = pstmt.executeUpdate();
            result = rowsAffected > 0;
            
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        
        return result;
    }
    
    // メモを削除
    public boolean deleteMemo(int id) {
        Connection conn = null;
        boolean result = false;
        
        try {
            conn = DBUtil.getConnection();
            String sql = "DELETE FROM memos WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            
            int rowsAffected = pstmt.executeUpdate();
            result = rowsAffected > 0;
            
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        
        return result;
    }
}
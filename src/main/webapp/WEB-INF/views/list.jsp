<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Tomcat 10.xではJSTLのタグライブラリも変更 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メモアプリ</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f5f5f5; }
        .container { max-width: 800px; margin: 0 auto; background: white; padding: 20px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h1 { color: #333; }
        .memo-list { list-style: none; padding: 0; }
        .memo-item { border: 1px solid #ddd; margin-bottom: 10px; padding: 15px; border-radius: 5px; }
        .memo-title { font-size: 18px; font-weight: bold; margin-bottom: 5px; }
        .memo-content { white-space: pre-line; margin-bottom: 10px; }
        .memo-date { color: #666; font-size: 12px; }
        .action-buttons { margin-top: 10px; }
        .action-buttons a { display: inline-block; margin-right: 10px; text-decoration: none; padding: 5px 10px; border-radius: 3px; color: white; }
        .edit-btn { background-color: #4CAF50; }
        .delete-btn { background-color: #f44336; }
        .add-btn { display: block; margin: 20px 0; background-color: #2196F3; color: white; text-decoration: none; padding: 10px 15px; border-radius: 5px; text-align: center; }
    </style>
</head>
<body>
    <div class="container">
        <h1>メモ一覧</h1>
        
        <a href="add" class="add-btn">新規メモ作成</a>
        
        <ul class="memo-list">
            <c:forEach var="memo" items="${memoList}">
                <li class="memo-item">
                    <div class="memo-title">${memo.title}</div>
                    <div class="memo-content">${memo.content}</div>
                    <div class="memo-date">作成日時: ${memo.createdAt} | 更新日時: ${memo.updatedAt}</div>
                    <div class="action-buttons">
                        <a href="edit?id=${memo.id}" class="edit-btn">編集</a>
                        <a href="delete?id=${memo.id}" class="delete-btn" onclick="return confirm('このメモを削除してもよろしいですか？')">削除</a>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
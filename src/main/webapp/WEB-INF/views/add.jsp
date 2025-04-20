<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新規メモ作成</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f5f5f5; }
        .container { max-width: 800px; margin: 0 auto; background: white; padding: 20px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h1 { color: #333; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], textarea { width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
        textarea { height: 200px; resize: vertical; }
        .button-group { margin-top: 20px; }
        button { padding: 10px 15px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }
        .cancel-btn { background-color: #f44336; margin-left: 10px; }
        a { text-decoration: none; color: #2196F3; }
    </style>
</head>
<body>
    <div class="container">
        <h1>新規メモ作成</h1>
        
        <form action="add" method="post">
            <div class="form-group">
                <label for="title">タイトル:</label>
                <input type="text" id="title" name="title" required>
            </div>
            
            <div class="form-group">
                <label for="content">内容:</label>
                <textarea id="content" name="content"></textarea>
            </div>
            
            <div class="button-group">
                <button type="submit">保存</button>
                <button type="button" class="cancel-btn" onclick="location.href='list'">キャンセル</button>
            </div>
        </form>
    </div>
</body>
</html>
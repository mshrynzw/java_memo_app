package model;

import java.sql.Timestamp;

public class Memo {
    private int id;
    private String title;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    // コンストラクタ
    public Memo() {}
    
    public Memo(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    public Memo(int id, String title, String content, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    // ゲッターとセッター
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
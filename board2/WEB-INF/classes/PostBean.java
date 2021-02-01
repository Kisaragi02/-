package tera;

import java.io.Serializable;

public class PostBean implements Serializable {
	
	private String title;
	private int postID;
	private String name;
	private String comment;
	private String date;
	
	public PostBean(){}
	
	public int getPostID(){
		return postID;
	}
	public void setPostID(int postID){
		this.postID = postID
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.threadID = title;
	}
}

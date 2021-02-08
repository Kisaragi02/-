package bean;

import java.io.Serializable;

public class PostBean implements Serializable {
	
    private int threadID;
	private String title;
    private String threadCreateName;
    private String content;
    private String date;
    private String genre;

	private int resID;
	private String resName;
	private String resContent;
	
	public PostBean(){}
	
	public int getThreadID(){
		return threadID;
	}
	public void setThreadID(int threadID){
		this.threadID = threadID;
	}
    public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
    public String getThreadCreateName() {
		return threadCreateName;
	}
	public void setThreadCreateName(String threadCreateName) {
		this.threadCreateName = threadCreateName;
	}
    public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
    public int getResID(){
		return resID;
	}
	public void setResID(int resID){
		this.resID = resID;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
    public String getResContent() {
		return resContent;
	}
	public void setResContent(String resContent) {
		this.resContent = resContent;
	}


	/*public String getThreadID(){
		return threadID;
	}
	public void setThreadID(String threadID){
		this.threadID = threadID;
	}
    public String getResID(){
		return resID;
	}
	public void setResID(String resID){
		this.resID = resID;
	}*/
}
package com.kh.app.board;

public class BoardVo {
	
	private String no;
	private String title;
	private String content;
	private String writer_no;
	private String created_date;
	private String hit;
	private String del_yn;
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVo(String no, String title, String content, String writer_no, String created_date, String hit,
			String del_yn) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer_no = writer_no;
		this.created_date = created_date;
		this.hit = hit;
		this.del_yn = del_yn;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	public String getWriter_no() {
		return writer_no;
	}
	public void setWriter_no(String writer_no) {
		this.writer_no = writer_no;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", writer_no=" + writer_no
				+ ", created_date=" + created_date + ", hit=" + hit + ", del_yn=" + del_yn + "]";
	}
	
	

}

package com.vam.model;

import java.util.Date;
import java.util.Objects;

public class BoardVO {
	
	/* 게시판 번호 */
    private int bno;
    /* 게시판 제목 */
    private String title;
    /* 게시판 내용 */
    private String content;
    /* 게시판 작가 */
    private String writer;
    /* 등록 날짜 */
    private Date regdate;
    /* 수정 날짜 */
    private Date updateDate;
    
    public BoardVO() {}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public BoardVO(int bno, String title, String content, String writer, Date regdate, Date updateDate) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", updateDate=" + updateDate + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bno, content, regdate, title, updateDate, writer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		return bno == other.bno && Objects.equals(content, other.content) && Objects.equals(regdate, other.regdate)
				&& Objects.equals(title, other.title) && Objects.equals(updateDate, other.updateDate)
				&& Objects.equals(writer, other.writer);
	}

}

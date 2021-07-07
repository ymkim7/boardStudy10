package com.vam.model;

import java.util.Arrays;
import java.util.Objects;

public class Criteria {
	
	/* 현재 페이지 */
    private int pageNum;
    /* 한 페이지 당 보여질 게시물 갯수 */
    private int amount;
	/* 검색 키워드 */
    private String keyword;
	/* 검색 타입 */
    private String type;
	/* 검색 타입 배열 변한 */
    private String[] typeArr;
    
    /* 기본 생성자 -> 기봅 세팅 : pageNum = 1, amount = 10 */
    public Criteria() {
        this(1,10);
    }
    
    /* 생성자 => 원하는 pageNum, 원하는 amount */
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

	public Criteria(String keyword) {
		super();
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		this.typeArr = type.split("");
	}

	public String[] getTypeArr() {
		return typeArr;
	}

	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}

	public Criteria(int pageNum, int amount, String keyword, String type, String[] typeArr) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
		this.keyword = keyword;
		this.type = type;
		this.typeArr = typeArr;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", type=" + type
				+ ", typeArr=" + Arrays.toString(typeArr) + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(typeArr);
		result = prime * result + Objects.hash(amount, keyword, pageNum, type);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria other = (Criteria) obj;
		return amount == other.amount && Objects.equals(keyword, other.keyword) && pageNum == other.pageNum
				&& Objects.equals(type, other.type) && Arrays.equals(typeArr, other.typeArr);
	}

}

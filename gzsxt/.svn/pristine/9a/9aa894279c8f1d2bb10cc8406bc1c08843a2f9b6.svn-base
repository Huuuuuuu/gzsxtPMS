package com.gzsxt.util;

import java.util.List;

public class PageUtil {
	private int currPage; // 当前页
	private int pageSize; // 每页多少条记录
	private int navCount; // 导航条数量
	private int rowCount; // 总记录数（表中所有数据）

	private List pageData; // 一页的数据

	private int startRow; // limit的第一参数
	private int pageCount; // 总页数

	private int nextPage; // 下一页
	private int prevPage; // 上一页

	private int firstPage; // 首页
	private int lastPage; // 尾页

	private int navStart; // 起始导航条的数字
	private int navEnd; // 结束导航条的数字

	public PageUtil(int currPage, int pageSize, int navCount, int rowCount) {
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.navCount = navCount;
		this.rowCount = rowCount;

		this.pageCount = (int) Math.ceil(this.rowCount * 1.0 / this.pageSize);
		this.startRow = (this.currPage - 1) * this.pageSize;

		this.firstPage = 1;
		this.lastPage = this.pageCount;

		this.prevPage = this.currPage - 1 > this.firstPage ? this.currPage - 1
				: this.firstPage;
		this.nextPage = this.currPage + 1 > this.lastPage ? this.lastPage
				: this.currPage + 1;

		// 我们可以将总页数赋值给navCount（如果总页数少于导航栏的条数，则将总页数赋值给导航条数）
		this.navCount = this.pageCount < this.navCount ? this.pageCount
				: this.navCount;

		this.navStart = this.currPage - this.navCount / 2 > this.firstPage ? this.currPage
				- this.navCount / 2
				: this.firstPage;
		this.navEnd = this.navStart + this.navCount - 1 > this.lastPage ? this.lastPage
				: this.navStart + this.navCount - 1;
		this.navStart = this.navEnd - this.navStart == this.navCount - 1 ? this.navStart
				: this.navEnd - (this.navCount - 1);

	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getNavCount() {
		return navCount;
	}

	public void setNavCount(int navCount) {
		this.navCount = navCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public List getPageData() {
		return pageData;
	}

	public void setPageData(List pageData) {
		this.pageData = pageData;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getNavStart() {
		return navStart;
	}

	public void setNavStart(int navStart) {
		this.navStart = navStart;
	}

	public int getNavEnd() {
		return navEnd;
	}

	public void setNavEnd(int navEnd) {
		this.navEnd = navEnd;
	}

	public PageUtil() {
		super();
	}

}

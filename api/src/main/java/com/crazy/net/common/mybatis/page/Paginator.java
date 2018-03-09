/*
 * $Id$
 *
 * Copyright ( c ) 2014 TH Supcom Corporation. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of TH Supcom
 * Corporation ("Confidential Information").  You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with TH Supcom Corporation or a TH Supcom
 * authorized reseller (the "License Agreement"). TH Supcom may make changes to the
 * Confidential Information from time to time. Such Confidential Information may
 * contain errors.
 *
 * EXCEPT AS EXPLICITLY SET FORTH IN THE LICENSE AGREEMENT, TH Supcom DISCLAIMS ALL
 * WARRANTIES, COVENANTS, REPRESENTATIONS, INDEMNITIES, AND GUARANTEES WITH
 * RESPECT TO SOFTWARE AND DOCUMENTATION, WHETHER EXPRESS OR IMPLIED, WRITTEN OR
 * ORAL, STATUTORY OR OTHERWISE INCLUDING, WITHOUT LIMITATION, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, TITLE, NON-INFRINGEMENT AND FITNESS FOR A
 * PARTICULAR PURPOSE. TH Supcom DOES NOT WARRANT THAT END USER'S USE OF THE
 * SOFTWARE WILL BE UNINTERRUPTED, ERROR FREE OR SECURE.
 *
 * TH Supcom SHALL NOT BE LIABLE TO END USER, OR ANY OTHER PERSON, CORPORATION OR
 * ENTITY FOR INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY OR CONSEQUENTIAL
 * DAMAGES, OR DAMAGES FOR LOSS OF PROFITS, REVENUE, DATA OR USE, WHETHER IN AN
 * ACTION IN CONTRACT, TORT OR OTHERWISE, EVEN IF TH Supcom HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES. TH Supcom' TOTAL LIABILITY TO END USER SHALL NOT
 * EXCEED THE AMOUNTS PAID FOR THE TH Supcom SOFTWARE BY END USER DURING THE PRIOR
 * TWELVE (12) MONTHS FROM THE DATE IN WHICH THE CLAIM AROSE.  BECAUSE SOME
 * STATES OR JURISDICTIONS DO NOT ALLOW LIMITATION OR EXCLUSION OF CONSEQUENTIAL
 * OR INCIDENTAL DAMAGES, THE ABOVE LIMITATION MAY NOT APPLY TO END USER.
 *
 * Copyright version 2.0
 */
package com.crazy.net.common.mybatis.page;

import java.io.Serializable;

/**
 * 分页器，根据page,limit,totalCount用于页面上分页显示多项内容，计算页码和当前页的偏移量，方便页面分页使�?
 * 
 * @author byang
 */
public class Paginator implements Serializable {
	private static final long serialVersionUID = -2429864663690465105L;

	private static final int DEFAULT_SLIDERS_COUNT = 7;

	/**
	 * 分页大小
	 */
	private int limit;
	/**
	 * 页数
	 */
	private int page;
	/**
	 * 总记录数
	 */
	private int totalCount;

	public Paginator(int page, int limit, int totalCount) {
		super();
		this.limit = limit;
		this.totalCount = totalCount;
		this.page = computePageNo(page);
	}

	/**
	 * 取得当前页�?
	 */
	public int getPage() {
		return page;
	}

	public int getLimit() {
		return limit;
	}

	/**
	 * 取得总项数�?
	 * 
	 * @return 总项�?
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 是否是首页（第一页），第�?��页码�?
	 * 
	 * @return 首页标识
	 */
	public boolean isFirstPage() {
		return page <= 1;
	}

	/**
	 * 是否是最后一�?
	 * 
	 * @return 末页标识
	 */
	public boolean isLastPage() {
		return page >= getTotalPages();
	}

	public int getPrePage() {
		if (isHasPrePage()) {
			return page - 1;
		} else {
			return page;
		}
	}

	public int getNextPage() {
		if (isHasNextPage()) {
			return page + 1;
		} else {
			return page;
		}
	}

	/**
	 * 判断指定页码是否被禁止，也就是说指定页码超出了范围或等于当前页码�?
	 * 
	 * @param page
	 *            页码
	 * @return boolean 是否为禁止的页码
	 */
	public boolean isDisabledPage(int page) {
		return ((page < 1) || (page > getTotalPages()) || (page == this.page));
	}

	/**
	 * 是否有上�?��
	 * 
	 * @return 上一页标�?
	 */
	public boolean isHasPrePage() {
		return (page - 1 >= 1);
	}

	/**
	 * 是否有下�?��
	 * 
	 * @return 下一页标�?
	 */
	public boolean isHasNextPage() {
		return (page + 1 <= getTotalPages());
	}

	/**
	 * �?��行，可以用于oracle分页使用 (1-based)�?
	 */
	public int getStartRow() {
		if (getLimit() <= 0 || totalCount <= 0)
			return 0;
		return page > 0 ? (page - 1) * getLimit() + 1 : 0;
	}

	/**
	 * 结束行，可以用于oracle分页使用 (1-based)�?
	 */
	public int getEndRow() {
		return page > 0 ? Math.min(limit * page, getTotalCount()) : 0;
	}

	/**
	 * offset，计数从0�?��，可以用于mysql分页使用(0-based)
	 */
	public int getOffset() {
		return page > 0 ? (page - 1) * getLimit() : 0;
	}

	/**
	 * 得到 总页�?
	 * 
	 * @return
	 */
	public int getTotalPages() {
		if (totalCount <= 0) {
			return 0;
		}
		if (limit <= 0) {
			return 0;
		}

		int count = totalCount / limit;
		if (totalCount % limit > 0) {
			count++;
		}
		return count;
	}

	protected int computePageNo(int page) {
		return computePageNumber(page, limit, totalCount);
	}

	/**
	 * 页码滑动窗口，并将当前页尽可能地放在滑动窗口的中间部位�?
	 * 
	 * @return
	 */
	public Integer[] getSlider() {
		return slider(DEFAULT_SLIDERS_COUNT);
	}

	/**
	 * 页码滑动窗口，并将当前页尽可能地放在滑动窗口的中间部位�? 注意:不可以使�?getSlider(1)方法名称，因为在JSP中会�?
	 * getSlider()方法冲突，报exception
	 * 
	 * @return
	 */
	public Integer[] slider(int slidersCount) {
		return generateLinkPageNumbers(getPage(), (int) getTotalPages(),
				slidersCount);
	}

	private static int computeLastPageNumber(int totalItems, int pageSize) {
		if (pageSize <= 0)
			return 1;
		int result = (int) (totalItems % pageSize == 0 ? totalItems / pageSize
				: totalItems / pageSize + 1);
		if (result <= 1)
			result = 1;
		return result;
	}

	private static int computePageNumber(int page, int pageSize, int totalItems) {
		if (page <= 1) {
			return 1;
		}
		if (Integer.MAX_VALUE == page
				|| page > computeLastPageNumber(totalItems, pageSize)) { // last
																			// page
			return computeLastPageNumber(totalItems, pageSize);
		}
		return page;
	}

	private static Integer[] generateLinkPageNumbers(int currentPageNumber,
			int lastPageNumber, int count) {
		int avg = count / 2;

		int startPageNumber = currentPageNumber - avg;
		if (startPageNumber <= 0) {
			startPageNumber = 1;
		}

		int endPageNumber = startPageNumber + count - 1;
		if (endPageNumber > lastPageNumber) {
			endPageNumber = lastPageNumber;
		}

		if (endPageNumber - startPageNumber < count) {
			startPageNumber = endPageNumber - count;
			if (startPageNumber <= 0) {
				startPageNumber = 1;
			}
		}

		java.util.List<Integer> result = new java.util.ArrayList<Integer>();
		for (int i = startPageNumber; i <= endPageNumber; i++) {
			result.add(new Integer(i));
		}
		return result.toArray(new Integer[result.size()]);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Paginator");
		sb.append("{page=").append(page);
		sb.append(", limit=").append(limit);
		sb.append(", totalCount=").append(totalCount);
		sb.append('}');
		return sb.toString();
	}

	/** 公司版权信息. */
	public static final String copyright = "Copyright 2014, TH Supcom Corporation";

	/** 提交路径. */
	public static final String SCC_BRANCH = "$URL$";

	/** 提交日期. */
	public static final String SCC_LAST_MODIFICATION_DATE = "$Date$";

	/** �?��修改人员. */
	public static final String SCC_LAST_MODIFIER_NAME = "$Author$";

	/** �?��版本�? */
	public static final String SCC_REVISION = "$Revision$";
}

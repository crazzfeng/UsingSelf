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

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * 包含“分页�?信息的List
 * 
 * <p>
 * 要得到�?页数请使�?toPaginator().getTotalPages();
 * </p>
 * 
 * @author byang
 */
public class PageList<E> extends ArrayList<E> {
	private static final long serialVersionUID = 1412759446332294208L;

	private Paginator paginator;

	public PageList() {
	}

	public PageList(Collection<? extends E> c) {
		super(c);
	}

	public PageList(Collection<? extends E> c, Paginator p) {
		super(c);
		this.paginator = p;
	}

	public PageList(Paginator p) {
		this.paginator = p;
	}

	/**
	 * 得到分页器，通过Paginator可以得到总页数等�?
	 * 
	 * @return
	 */
	public Paginator getPaginator() {
		return paginator;
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

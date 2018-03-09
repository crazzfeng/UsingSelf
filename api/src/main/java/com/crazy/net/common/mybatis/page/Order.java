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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 
 * @author byang
 */
public class Order implements Serializable {
	private static final long serialVersionUID = 8138022018100161833L;
	private Direction direction;
	private String property;
	private String orderExpr;

	public Order(String property, Direction direction, String orderExpr) {
		this.direction = direction;
		this.property = property;
		this.orderExpr = orderExpr;
	}

	public Direction getDirection() {
		return direction;
	}

	public String getProperty() {
		return property;
	}

	public String getOrderExpr() {
		return orderExpr;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void setOrderExpr(String orderExpr) {
		this.orderExpr = orderExpr;
	}

	private static String INJECTION_REGEX = "[A-Za-z0-9\\_\\-\\+\\.]+";

	public static boolean isSQLInjection(String str) {
		return !Pattern.matches(INJECTION_REGEX, str);
	}

	@Override
	public String toString() {
		if (isSQLInjection(property)) {
			throw new IllegalArgumentException("SQLInjection property: "
					+ property);
		}
		if (orderExpr != null && orderExpr.indexOf("?") != -1) {
			String[] exprs = orderExpr.split("\\?");
			if (exprs.length == 2) {
				return String.format(orderExpr.replaceAll("\\?", "%s"),
						property)
						+ (direction == null ? "" : " " + direction.name());
			}
			return String.format(orderExpr.replaceAll("\\?", "%s"), property,
					direction == null ? "" : " " + direction.name());
		}
		return property + (direction == null ? "" : " " + direction.name());
	}

	public static List<Order> formString(String orderSegment) {
		return formString(orderSegment, null);
	}

	/**
	 * @param orderSegment
	 *            ex: "id.asc,code.desc" or "code.desc"
	 */
	public static List<Order> formString(String orderSegment, String orderExpr) {
		if (orderSegment == null || orderSegment.trim().equals("")) {
			return new ArrayList<Order>(0);
		}

		List<Order> results = new ArrayList<Order>();
		String[] orderSegments = orderSegment.trim().split(",");
		for (int i = 0; i < orderSegments.length; i++) {
			String sortSegment = orderSegments[i];
			Order order = _formString(sortSegment, orderExpr);
			if (order != null) {
				results.add(order);
			}
		}
		return results;
	}

	private static Order _formString(String orderSegment, String orderExpr) {

		if (orderSegment == null || orderSegment.trim().equals("")
				|| orderSegment.startsWith("null.")
				|| orderSegment.startsWith(".")) {
			return null;
		}

		String[] array = orderSegment.trim().split("\\.");
		if (array.length != 1 && array.length != 2) {
			throw new IllegalArgumentException(
					"orderSegment pattern must be {property}.{direction}, input is: "
							+ orderSegment);
		}

		return create(array[0], array.length == 2 ? array[1] : "asc", orderExpr);
	}

	public static Order create(String property, String direction) {
		return create(property, direction, null);
	}

	/**
	 * 
	 * @param property
	 * @param direction
	 * @param orderExpr
	 *            placeholder is "?", in oracle like:
	 *            "nlssort( ? ,'NLS_SORT=SCHINESE_PINYIN_M')". Warning: you must
	 *            prevent orderExpr SQL injection.
	 * @return
	 */
	public static Order create(String property, String direction,
			String orderExpr) {
		return new Order(property, Order.Direction.fromString(direction),
				orderExpr);
	}

	/**
	 * PropertyPath implements the pairing of an {@link Direction} and a
	 * property. It is used to provide input for
	 * 
	 * @author Oliver Gierke
	 */
	public static enum Direction {
		ASC, DESC;
		public static Direction fromString(String value) {
			try {
				return Direction.valueOf(value.toUpperCase(Locale.US));
			} catch (Exception e) {
				return ASC;
			}
		}
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

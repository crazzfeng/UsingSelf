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

import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分页查询对象
 * 
 * @author byang
 */
public class PageBounds extends RowBounds implements Serializable
{
    private static final long serialVersionUID = -6414350656252331011L;
    public final static int NO_PAGE = 1;
    /** 页号 */
    protected int page = NO_PAGE;
    /** 分页大小 */
    protected int limit = NO_ROW_LIMIT;
    /** 分页排序信息 */
    protected List <Order> orders = new ArrayList <Order> ();
    /** 结果集是否包含TotalCount */
    protected boolean containsTotalCount;
    /**异步查询�?��  默认false �?��异步查询将同时查询list 和count,�?��异步查询�?�?��在web.xml中开启com.th.supcom.mybatis.paginator.CleanupMybatisPaginatorListener**/
    protected Boolean asyncTotalCount;

    public PageBounds ()
    {
        containsTotalCount = false;
    }

    public PageBounds (RowBounds rowBounds)
    {
        if (rowBounds instanceof PageBounds)
        {
            PageBounds pageBounds = (PageBounds) rowBounds;
            this.page = pageBounds.page;
            this.limit = pageBounds.limit;
            this.orders = pageBounds.orders;
            this.containsTotalCount = pageBounds.containsTotalCount;
            this.asyncTotalCount = pageBounds.asyncTotalCount;
        }
        else
        {
            this.page = (rowBounds.getOffset () / rowBounds.getLimit ()) + 1;
            this.limit = rowBounds.getLimit ();
        }

    }

    /**
     * Query TOP N, default containsTotalCount = false
     * 
     * @param limit
     */
    public PageBounds (int limit)
    {
        this.limit = limit;
        this.containsTotalCount = false;
    }

    public PageBounds (int page, int limit)
    {
        this (page, limit, new ArrayList <Order> (), true);
    }

    public PageBounds (int page, int limit, boolean containsTotalCount)
    {
        this (page, limit, new ArrayList <Order> (), containsTotalCount);
    }

    /**
     * Just sorting, default containsTotalCount = false
     * 
     * @param orders
     */
    public PageBounds (List <Order> orders)
    {
        this (NO_PAGE, NO_ROW_LIMIT, orders, false);
    }

    /**
     * Just sorting, default containsTotalCount = false
     * 
     * @param order
     */
    public PageBounds (Order... order)
    {
        this (NO_PAGE, NO_ROW_LIMIT, order);
        this.containsTotalCount = false;
    }

    public PageBounds (int page, int limit, Order... order)
    {
        this (page, limit, Arrays.asList (order), true);
    }

    public PageBounds (int page, int limit, List <Order> orders)
    {
        this (page, limit, orders, true);
    }

    public PageBounds (int page, int limit, List <Order> orders, boolean containsTotalCount)
    {
        this.page = page;
        this.limit = limit;
        this.orders = orders;
        this.containsTotalCount = containsTotalCount;
    }

    public int getPage ()
    {
        return page;
    }

    public void setPage (int page)
    {
        this.page = page;
    }

    public int getLimit ()
    {
        return limit;
    }

    public void setLimit (int limit)
    {
        this.limit = limit;
    }

    public boolean isContainsTotalCount ()
    {
        return containsTotalCount;
    }

    public void setContainsTotalCount (boolean containsTotalCount)
    {
        this.containsTotalCount = containsTotalCount;
    }

    public List <Order> getOrders ()
    {
        return orders;
    }

    public void setOrders (List <Order> orders)
    {
        this.orders = orders;
    }

    public Boolean getAsyncTotalCount ()
    {
        return asyncTotalCount;
    }

    public void setAsyncTotalCount (Boolean asyncTotalCount)
    {
        this.asyncTotalCount = asyncTotalCount;
    }

    @Override
    public int getOffset ()
    {
        if (page >= 1)
        {
            return (page - 1) * limit;
        }
        return 0;
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ("PageBounds{");
        sb.append ("page=").append (page);
        sb.append (", limit=").append (limit);
        sb.append (", orders=").append (orders);
        sb.append (", containsTotalCount=").append (containsTotalCount);
        sb.append (", asyncTotalCount=").append (asyncTotalCount);
        sb.append ('}');
        return sb.toString ();
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
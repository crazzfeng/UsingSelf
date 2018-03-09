package com.crazy.net.service;

import com.crazy.net.pojo.WebsiteInfo;

import java.util.List;

public interface WebsiteInfoService
{
    /**
     * 增加
     * @param websiteInfo
     * @return
     */
    int add(WebsiteInfo websiteInfo);
    /**
     * 更新
     * @param websiteInfo
     * @return
     */
    int update(WebsiteInfo websiteInfo);
    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 查找单个
     * @param id
     * @return
     */
    WebsiteInfo get(Integer id);

    /**
     * 查找多个
     * @param websiteInfo
     * @return
     */
    List<WebsiteInfo> findList(WebsiteInfo websiteInfo);

    /**
     * 查找数量
     * @param websiteInfo
     * @return
     */
    int findCount(WebsiteInfo websiteInfo);

    /**
     * 查找多个
     * @param websiteInfo
     * @return
     */
    List<WebsiteInfo> findListWithPage(WebsiteInfo websiteInfo,int start,int end);

}

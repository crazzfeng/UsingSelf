package com.crazy.net.dao;

import com.crazy.net.common.mybatis.page.PageBounds;
import com.crazy.net.pojo.WebsiteInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteInfoMapper
{
    /**
     * 增加
     *
     * @param websiteInfo
     * @return
     */
    int add(WebsiteInfo websiteInfo);

    /**
     * 更新
     *
     * @param websiteInfo
     * @return
     */
    int update(WebsiteInfo websiteInfo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 查找单个
     *
     * @param id
     * @return
     */
    WebsiteInfo get(Integer id);

    /**
     * 查找多个
     *
     * @param websiteInfo
     * @return
     */
    List<WebsiteInfo> findList(WebsiteInfo websiteInfo);

    /**
     * 查找数量
     *
     * @param websiteInfo
     * @return
     */
    int findCount(WebsiteInfo websiteInfo);

    /**
     * 查找多个
     *
     * @param websiteInfo
     * @return
     */
    List<WebsiteInfo> findListWithPage(PageBounds pageBounds,WebsiteInfo websiteInfo);
}

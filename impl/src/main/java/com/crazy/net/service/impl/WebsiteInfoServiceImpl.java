package com.crazy.net.service.impl;

import com.crazy.net.common.mybatis.page.PageBounds;
import com.crazy.net.dao.WebsiteInfoMapper;
import com.crazy.net.pojo.WebsiteInfo;
import com.crazy.net.service.WebsiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.carefx.framework.exception.BusinessException;

import java.util.List;

@Service
public class WebsiteInfoServiceImpl implements WebsiteInfoService
{
    @Autowired
    WebsiteInfoMapper websiteInfoMapper;

    /**
     * 增加
     *
     * @param websiteInfo
     * @return
     */
    public int add(WebsiteInfo websiteInfo)
    {
        if(websiteInfo == null)
        {
            throw new BusinessException("添加的对象为空");
        }
        return websiteInfoMapper.add(websiteInfo);
    }

    /**
     * 更新
     *
     * @param websiteInfo
     * @return
     */
    public int update(WebsiteInfo websiteInfo)
    {
        if(websiteInfo == null)
        {
            throw new BusinessException("要更新的对象为空");
        }
        return websiteInfoMapper.update(websiteInfo);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delete(Integer id)
    {
        if(id == null)
        {
            throw new BusinessException("传入id为空，无法删除");
        }
        return websiteInfoMapper.delete(id);
    }

    /**
     * 查找单个
     *
     * @param id
     * @return
     */
    public WebsiteInfo get(Integer id)
    {
        if(id == null)
        {
            throw new BusinessException("传入id为空，无法查找单个");
        }
        return websiteInfoMapper.get(id);
    }

    /**
     * 查找多个
     *
     * @param websiteInfo
     * @return
     */
    public List<WebsiteInfo> findList(WebsiteInfo websiteInfo)
    {

        return websiteInfoMapper.findList(websiteInfo);
    }

    /**
     * 查找数量
     *
     * @param websiteInfo
     * @return
     */
    public int findCount(WebsiteInfo websiteInfo)
    {
        return websiteInfoMapper.findCount(websiteInfo);
    }

    /**
     * 查找多个
     *
     * @param websiteInfo
     * @param start
     * @param end         @return
     */
    public List<WebsiteInfo> findListWithPage(WebsiteInfo websiteInfo, int start, int end)
    {
        return websiteInfoMapper.findListWithPage(new PageBounds(start,end), websiteInfo);
    }
}

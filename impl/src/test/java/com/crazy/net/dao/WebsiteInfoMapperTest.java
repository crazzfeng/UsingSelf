package com.crazy.net.dao;

import com.crazy.net.common.mybatis.page.PageBounds;
import com.crazy.net.pojo.WebsiteInfo;
import com.crazy.net.service.BaseServiceTest;
import com.crazy.net.service.WebsiteInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WebsiteInfoMapperTest extends BaseServiceTest
{
    @Autowired
    WebsiteInfoMapper websiteInfoService;

    @Test
    public void test_add()
    {
        WebsiteInfo websiteInfo = new WebsiteInfo();
        websiteInfo.setName("baidu");
        websiteInfo.setHttp("www.baidu.com");
        websiteInfo.setRemark("百度，国内最好的搜索网站");
        websiteInfo.setParam("查询条件");
        int add = 0;
        for (int i = 0; i < 3; i++)
        {
            add += websiteInfoService.add(websiteInfo);
        }
        /*add = websiteInfoService.add(websiteInfo);*/
        System.err.print(add);
    }

    @Test
    public void test_update()
    {
        WebsiteInfo websiteInfo = new WebsiteInfo();
        websiteInfo.setId(3);
        websiteInfo.setName("baidu-2147482646");
        websiteInfo.setHttp("https://www.baidu.com");
        websiteInfo.setRemark("百度，国内最好的搜索网站");
        websiteInfo.setParam("查询条件");
        int ud = websiteInfoService.update(websiteInfo);
        System.err.print(ud);
    }

    @Test
    public void test_delete()
    {
        int del = websiteInfoService.delete(13);
        System.err.print(del);
    }

    @Test
    public void test_findlistWithPage()
    {
        WebsiteInfo user = new WebsiteInfo();
        user.setHttp("baidu");

        List<WebsiteInfo> users = websiteInfoService.findListWithPage(new PageBounds(0,5), user);

        for (WebsiteInfo user1 : users)
        {
            System.err.print(user1.toString()+"\n");
        }
    }

    @Test
    public void test_findCount()
    {
        WebsiteInfo user = new WebsiteInfo();
        /*user.setName("baidu");*/
        user.setHttp("baidu");
        int co = websiteInfoService.findCount(user);
        System.err.print(co);
    }

    @Test
    public void test_get()
    {
        WebsiteInfo websiteInfo = websiteInfoService.get(5);
        System.err.print(websiteInfo.toString());
    }

    @Test
    public void test_findlist()
    {
        WebsiteInfo user = new WebsiteInfo();
/*        user.setName("baidu");*/
        user.setHttp("baidu");

        List<WebsiteInfo> users = websiteInfoService.findList(user);

        for (WebsiteInfo user1 : users)
        {
            System.err.print(user1.toString());
        }
    }
}

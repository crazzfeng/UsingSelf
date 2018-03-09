package com.crazy.net.service;

import com.crazy.net.pojo.WebsiteInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WebsiteInfoServiceTest extends BaseServiceTest
{
    @Autowired
    WebsiteInfoService websiteInfoService;

    @Test
    public void test_add()
    {
        WebsiteInfo websiteInfo = new WebsiteInfo();
        websiteInfo.setName("baidu");
        websiteInfo.setHttp("www.baidu.com");
        websiteInfo.setRemark("百度，国内最好的搜索网站");
        websiteInfo.setParam("查询条件");
        int add = 0;
        for (int i = 0; i < 10; i++)
        {
            add += websiteInfoService.add(websiteInfo);
        }

        System.err.print(add);
    }

    @Test
    public void test_update()
    {
        WebsiteInfo websiteInfo = new WebsiteInfo();
        websiteInfo.setId(3);
        websiteInfo.setName("baidu");
        websiteInfo.setHttp("www.baidu.com");
        websiteInfo.setRemark("百度，国内最好的搜索网站");
        websiteInfo.setParam("查询条件");
        int ud = websiteInfoService.update(websiteInfo);
        System.err.print(ud);
    }

    @Test
    public void test_delete()
    {
        int del = websiteInfoService.delete(9);
        System.err.print(del);
    }

    @Test
    public void test_findlistWithPage()
    {
        WebsiteInfo user = new WebsiteInfo();
        user.setName("baidu");

        List<WebsiteInfo> users = websiteInfoService.findListWithPage(user, 0, 5);

        for (WebsiteInfo user1 : users)
        {
            System.err.print(user1.toString());
        }
    }

    @Test
    public void test_findCount()
    {
        WebsiteInfo user = new WebsiteInfo();
        user.setName("baidu");
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
        user.setName("baidu");

        List<WebsiteInfo> users = websiteInfoService.findList(user);

        for (WebsiteInfo user1 : users)
        {
            System.err.print(user1.toString());
        }
    }
}

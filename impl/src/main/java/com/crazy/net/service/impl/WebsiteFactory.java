package com.crazy.net.service.impl;

import com.crazy.net.service.UserService;
import com.crazy.net.service.WebsiteInfoService;

public class WebsiteFactory
{

    private WebsiteFactory()
    {
    }

    public static UserService getUserService(){

        return new UserServiceImpl();
    }

    public static WebsiteInfoService getWebsiteInfoService(){
        return new WebsiteInfoServiceImpl();
    }
}

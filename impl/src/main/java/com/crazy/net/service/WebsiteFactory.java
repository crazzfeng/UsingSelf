package com.crazy.net.service;

import com.crazy.net.service.UserService;
import com.crazy.net.service.WebsiteInfoService;
import com.crazy.net.service.impl.UserServiceImpl;
import com.crazy.net.service.impl.WebsiteInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class WebsiteFactory {
    @Autowired
    private UserService userService;

    @Autowired
    private WebsiteInfoService WebsiteInfoService;

    private WebsiteFactory() {
    }

    public UserService getUserService() {
        return userService;
    }

    public WebsiteInfoService getWebsiteInfoService() {
        return WebsiteInfoService;
    }
}

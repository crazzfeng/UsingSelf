package com.crazy.net.controller;

import com.crazy.net.common.ConvertUtils;
import com.crazy.net.model.WebsiteInfoModel;
import com.crazy.net.pojo.WebsiteInfo;
import com.crazy.net.service.WebsiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/websiteInfo")
public class WebsiteInfoController
{

    @Autowired
    WebsiteInfoService websiteInfoService;

    @RequestMapping(value = "/findListWithPage",params = {"start","end","websiteInfoModel"})
    public List<WebsiteInfoModel> findListWithPage(WebsiteInfoModel websiteInfoModel, int start,int end){
        WebsiteInfo websiteInfo = ConvertUtils.convert(WebsiteInfo.class,websiteInfoModel);
        List<WebsiteInfo> websiteInfos = websiteInfoService.findListWithPage(websiteInfo,start,end);
        List<WebsiteInfoModel> websiteInfoModels = ConvertUtils.convert(WebsiteInfoModel.class,websiteInfos);
        return  websiteInfoModels;
    }

}

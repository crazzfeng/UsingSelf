package com.crazy.net.controller;

import com.crazy.net.common.ConvertUtils;
import com.crazy.net.model.WebsiteInfoModel;
import com.crazy.net.pojo.WebsiteInfo;
import com.crazy.net.service.WebsiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class WebsiteInfoController
{

    @Autowired
    WebsiteInfoService websiteInfoService;

    public List<WebsiteInfoModel> findListWithPage(WebsiteInfoModel websiteInfoModel, int start,int end){
        WebsiteInfo websiteInfo = ConvertUtils.convert(WebsiteInfo.class,websiteInfoModel);
        List<WebsiteInfo> websiteInfos = websiteInfoService.findListWithPage(websiteInfo,start,end);
        List<WebsiteInfoModel> websiteInfoModels = ConvertUtils.convert(WebsiteInfoModel.class,websiteInfos);
        return  websiteInfoModels;
    }

}

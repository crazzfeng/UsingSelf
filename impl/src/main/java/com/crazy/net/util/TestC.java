package com.crazy.net.util;

import java.util.List;

/**
 * @author yufeng li
 * @title: TestC
 * @description:
 * @date 2018/9/18 18:11
 */
public class TestC {
    private List<Site> sites;
    private String remark;
    private User user;

    public TestC() {
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

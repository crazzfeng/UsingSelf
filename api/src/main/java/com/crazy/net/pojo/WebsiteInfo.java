package com.crazy.net.pojo;

import java.io.Serializable;

public class WebsiteInfo implements Serializable
{

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 网站名称
     */
    private String name;
    /**
     * 网站地址
     */
    private String http;
    /**
     * 网站描述或备注
     */
    private String remark;
    /**
     * 参数
     */
    private String param;
    /**
     * 扩展属性1
     */
    private String extendProperty1;
    /**
     * 扩展属性2
     */
    private String extendProperty2;
    /**
     * 扩展属性3
     */
    private String extendProperty3;
    /**
     * 扩展属性4
     */
    private String extendProperty4;
    /**
     * 扩展属性5
     */
    private String extendProperty5;
    /**
     * 扩展属性6
     */
    private String extendProperty6;
    /**
     * 扩展属性7
     */
    private String extendProperty7;
    /**
     * 扩展属性8
     */
    private String extendProperty8;
    /**
     * 扩展属性9
     */
    private String extendProperty9;

    public WebsiteInfo()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getHttp()
    {
        return http;
    }

    public void setHttp(String http)
    {
        this.http = http;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getParam()
    {
        return param;
    }

    public void setParam(String param)
    {
        this.param = param;
    }

    public String getExtendProperty1()
    {
        return extendProperty1;
    }

    public void setExtendProperty1(String extendProperty1)
    {
        this.extendProperty1 = extendProperty1;
    }

    public String getExtendProperty2()
    {
        return extendProperty2;
    }

    public void setExtendProperty2(String extendProperty2)
    {
        this.extendProperty2 = extendProperty2;
    }

    public String getExtendProperty3()
    {
        return extendProperty3;
    }

    public void setExtendProperty3(String extendProperty3)
    {
        this.extendProperty3 = extendProperty3;
    }

    public String getExtendProperty4()
    {
        return extendProperty4;
    }

    public void setExtendProperty4(String extendProperty4)
    {
        this.extendProperty4 = extendProperty4;
    }

    public String getExtendProperty5()
    {
        return extendProperty5;
    }

    public void setExtendProperty5(String extendProperty5)
    {
        this.extendProperty5 = extendProperty5;
    }

    public String getExtendProperty6()
    {
        return extendProperty6;
    }

    public void setExtendProperty6(String extendProperty6)
    {
        this.extendProperty6 = extendProperty6;
    }

    public String getExtendProperty7()
    {
        return extendProperty7;
    }

    public void setExtendProperty7(String extendProperty7)
    {
        this.extendProperty7 = extendProperty7;
    }

    public String getExtendProperty8()
    {
        return extendProperty8;
    }

    public void setExtendProperty8(String extendProperty8)
    {
        this.extendProperty8 = extendProperty8;
    }

    public String getExtendProperty9()
    {
        return extendProperty9;
    }

    public void setExtendProperty9(String extendProperty9)
    {
        this.extendProperty9 = extendProperty9;
    }

    @Override
    public String toString()
    {
        return "网站信息{" + "ID=" + id + ", 网站名称='" + name + "', 网址='" + http + "', 备注描述='" + remark + "', 参数='" + param + "', 扩展属性1='" + extendProperty1 + '\'' + ", 扩展属性2='"
                + extendProperty2 + "', 扩展属性3='" + extendProperty3 + "', 扩展属性4='" + extendProperty4 + "', 扩展属性5='" + extendProperty5 + "', 扩展属性6='" + extendProperty6 + "', 扩展属性7='"
                + extendProperty7 + "', 扩展属性8='" + extendProperty8 + "', 扩展属性9='" + extendProperty9 + "'}";
    }
}

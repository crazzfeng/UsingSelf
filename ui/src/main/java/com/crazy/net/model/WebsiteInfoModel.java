package com.crazy.net.model;

import java.io.Serializable;

public class WebsiteInfoModel implements Serializable
{

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Integer m_id;
    /**
     * 网站名称
     */
    private String m_name;
    /**
     * 网站地址
     */
    private String m_http;
    /**
     * 网站描述或备注
     */
    private String m_remark;
    /**
     * 参数
     */
    private String m_param;
    /**
     * 扩展属性1
     */
    private String m_extendProperty1;
    /**
     * 扩展属性2
     */
    private String m_extendProperty2;
    /**
     * 扩展属性3
     */
    private String m_extendProperty3;
    /**
     * 扩展属性4
     */
    private String m_extendProperty4;
    /**
     * 扩展属性5
     */
    private String m_extendProperty5;
    /**
     * 扩展属性6
     */
    private String m_extendProperty6;
    /**
     * 扩展属性7
     */
    private String m_extendProperty7;
    /**
     * 扩展属性8
     */
    private String m_extendProperty8;
    /**
     * 扩展属性9
     */
    private String m_extendProperty9;

    public WebsiteInfoModel()
    {
    }

    public Integer getId()
    {
        return m_id;
    }

    public void setId(Integer id)
    {
        this.m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        this.m_name = name;
    }

    public String getHttp()
    {
        return m_http;
    }

    public void setHttp(String http)
    {
        this.m_http = http;
    }

    public String getRemark()
    {
        return m_remark;
    }

    public void setRemark(String remark)
    {
        this.m_remark = remark;
    }

    public String getParam()
    {
        return m_param;
    }

    public void setParam(String param)
    {
        this.m_param = param;
    }

    public String getExtendProperty1()
    {
        return m_extendProperty1;
    }

    public void setExtendProperty1(String extendProperty1)
    {
        this.m_extendProperty1 = extendProperty1;
    }

    public String getExtendProperty2()
    {
        return m_extendProperty2;
    }

    public void setExtendProperty2(String extendProperty2)
    {
        this.m_extendProperty2 = extendProperty2;
    }

    public String getExtendProperty3()
    {
        return m_extendProperty3;
    }

    public void setExtendProperty3(String extendProperty3)
    {
        this.m_extendProperty3 = extendProperty3;
    }

    public String getExtendProperty4()
    {
        return m_extendProperty4;
    }

    public void setExtendProperty4(String extendProperty4)
    {
        this.m_extendProperty4 = extendProperty4;
    }

    public String getExtendProperty5()
    {
        return m_extendProperty5;
    }

    public void setExtendProperty5(String extendProperty5)
    {
        this.m_extendProperty5 = extendProperty5;
    }

    public String getExtendProperty6()
    {
        return m_extendProperty6;
    }

    public void setExtendProperty6(String extendProperty6)
    {
        this.m_extendProperty6 = extendProperty6;
    }

    public String getExtendProperty7()
    {
        return m_extendProperty7;
    }

    public void setExtendProperty7(String extendProperty7)
    {
        this.m_extendProperty7 = extendProperty7;
    }

    public String getExtendProperty8()
    {
        return m_extendProperty8;
    }

    public void setExtendProperty8(String extendProperty8)
    {
        this.m_extendProperty8 = extendProperty8;
    }

    public String getExtendProperty9()
    {
        return m_extendProperty9;
    }

    public void setExtendProperty9(String extendProperty9)
    {
        this.m_extendProperty9 = extendProperty9;
    }

    @Override
    public String toString()
    {
        return "网站信息{" + "ID=" + m_id + ", 网站名称='" + m_name + "', 网址='" + m_http + "', 备注描述='" + m_remark + "', 参数='" + m_param + "', 扩展属性1='" + m_extendProperty1 + '\'' + ", 扩展属性2='"
                + m_extendProperty2 + "', 扩展属性3='" + m_extendProperty3 + "', 扩展属性4='" + m_extendProperty4 + "', 扩展属性5='" + m_extendProperty5 + "', 扩展属性6='" + m_extendProperty6 + "', 扩展属性7='"
                + m_extendProperty7 + "', 扩展属性8='" + m_extendProperty8 + "', 扩展属性9='" + m_extendProperty9 + "'}";
    }
}

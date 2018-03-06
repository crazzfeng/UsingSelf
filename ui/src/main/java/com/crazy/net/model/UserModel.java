package com.crazy.net.model;

import java.io.Serializable;

public class UserModel implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer m_id;

    private String m_name;

    private String m_gender;

    private Integer m_age;

    private String m_remark;

    public UserModel()
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

    public String getGender()
    {
        return m_gender;
    }

    public void setGender(String gender)
    {
        this.m_gender = m_gender;
    }

    public Integer getAge()
    {
        return m_age;
    }

    public void setAge(Integer age)
    {
        this.m_age = m_age;
    }

    public String getRemark()
    {
        return m_remark;
    }

    public void setRemark(String remark)
    {
        this.m_remark = remark;
    }

    @Override
    public String toString()
    {
        return "User{" + "ID[id]=" + m_id + ", 姓名[name]='" + m_name + '\'' + ", 性别[gender]='" + m_gender + '\'' + ", 年龄[age]=" + m_age + ", 备注[remark]='" + m_remark + '\'' + '}';
    }

}

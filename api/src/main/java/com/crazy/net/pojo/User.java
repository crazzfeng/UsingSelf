package com.crazy.net.pojo;

import java.io.Serializable;

public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String gender;

    private Integer age;

    private String remark;

    public User()
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

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    @Override
    public String toString()
    {
        return "User{" + "ID[id]=" + id + ", 姓名[name]='" + name + '\'' + ", 性别[gender]='" + gender + '\'' + ", 年龄[age]=" + age + ", 备注[remark]='" + remark + '\'' + '}';
    }
}

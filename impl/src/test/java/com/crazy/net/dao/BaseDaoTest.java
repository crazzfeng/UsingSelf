package com.crazy.net.dao;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

/**
 * Dao层测试基类
 */
@ContextConfiguration(locations = { "classpath:META-INF/dao.spring.xml", "classpath:META-INF/dataSource.xml" })

public abstract class BaseDaoTest extends AbstractJUnit38SpringContextTests
{

}
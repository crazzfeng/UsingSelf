package com.crazy.net.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration(locations = { "classpath:META-INF/service-all.spring.xml" })
public abstract class BaseServiceTest extends AbstractJUnit38SpringContextTests
{

}
package com.crazy.net.common;

import net.carefx.framework.util.Convert;
import org.apache.commons.beanutils.converters.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.sql.Date;
import java.util.*;

public class ConvertUtils
{
    @SuppressWarnings ("rawtypes")
    private static Map <Class, Convert <Object, Object>> map = new HashMap <Class, Convert <Object, Object>> ();
    
    static
    {
        org.apache.commons.beanutils.ConvertUtils.register(new IntegerConverter(null), Integer.class);   
        org.apache.commons.beanutils.ConvertUtils.register(new FloatConverter(null), Float.class);   
        org.apache.commons.beanutils.ConvertUtils.register(new DoubleConverter(null), Double.class);   
        org.apache.commons.beanutils.ConvertUtils.register(new LongConverter(null), Long.class);   
        org.apache.commons.beanutils.ConvertUtils.register(new SqlDateConverter(null), Date.class);   
    }

    @SuppressWarnings ({ "unchecked", "rawtypes" })
    public static <X> X convert (Class  clz, Object object)
    {
        if (object == null)
        {
            return null;
        }
        if (object instanceof List)
        {
            List <Object> list = (List <Object>) object;
            List <Object> result = new ArrayList <Object> ();
            for (Object obj : list)
            {
                result.add (convert (clz, obj));
            }
            return (X) result;
        }
        else
        {
            try
            {
                Object target = clz.newInstance ();
                BeanUtils.copyProperties (object, target);
                return (X) target;
            }
            catch (Exception e)
            {
                e.printStackTrace ();
                logger.warn ("数据拷贝失败!", e);
            }
        }
        return null;
    }
    @SuppressWarnings ("unchecked")
    public static <X> X convert (Object object, @SuppressWarnings ("rawtypes") Convert convert)
    {
        if (object instanceof List)
        {
            List <Object> list = (List <Object>) object;
            List <Object> result = new ArrayList <Object> ();
            for (Object obj : list)
            {
                result.add (convert (obj, convert));
            }
            return (X) result;
        }
        else
        {
            @SuppressWarnings ("rawtypes")
            Class clazz = convert.getClass ();
            if (map.get (clazz) == null)
            {
                try
                {
                    map.put (clazz, convert);
                }
                catch (Exception e)
                {
                    logger.warn ("数据拷贝失败!", e);
                }
            }
            Convert <Object, Object> instance = map.get (clazz);
            return (X) instance.convert (object);
        }
    }
    
    public static final Set <String> excludeProperties = new HashSet <String>();
    static{
        excludeProperties.add("logger");
        excludeProperties.add("copyright");
        excludeProperties.add("SCC_BRANCH");
        excludeProperties.add("SCC_LAST_MODIFICATION_DATE");
        excludeProperties.add("SCC_LAST_MODIFIER_NAME");
        excludeProperties.add("SCC_REVISION");
    }
    

    /**
     * 日志记录器.
     */
    public static final Logger logger = LoggerFactory.getLogger (net.carefx.framework.util.ConvertUtils.class.getName ());
    /**
     * 公司版权信息.
     */
    public static final String copyright = "Copyright 2010, Carefx Corporation";
    /**
     * 提交路径.
     */
    public static final String SCC_BRANCH = "$URL: https://192.168.32.4/svn/SourceCodeBase/framework/trunk/framework-core/src/net/carefx/framework/util/ConvertUtils.java $";
    /**
     * 提交日期.
     */
    public static final String SCC_LAST_MODIFICATION_DATE = "$Date: 2011-05-04 15:28:06 +0800 (星期三, 04 五月 2011) $";
    /**
     * 最终修改人员.
     */
    public static final String SCC_LAST_MODIFIER_NAME = "$Author: szhou $";
    /**
     * 最终版本号.
     */
    public static final String SCC_REVISION = "$Revision: 30453 $";
}

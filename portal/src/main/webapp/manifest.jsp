<%@page import="java.io.*"%>
<%@page import="java.net.*"%>
<%@page import="java.util.jar.*"%>
<%@page import="java.util.jar.Attributes.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

	.manifest-table {
	font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
    width:500px;
    border-collapse:collapse;
	display: table;
}

.manifest-table-item {
	font: "Trebuchet MS", Arial, Helvetica, sans-serif;
	padding: 3px 10px 3px 10px;
	border: 1px solid #fff;
	border-bottom: 1px solid #eeeeee;
	white-space: normal;
	color: #555;
	text-align: left;
}

.manifest-table-item-th {
	white-space: normal;
	color: #red;
	text-align: left;
	font-size:1em;
    border:1px solid #98bf21;
    padding:3px 7px 2px 7px;
    text-overflow: ellipsis; /* for IE */
	-moz-text-overflow: ellipsis; /* for Firefox,mozilla */
	overflow: hidden;
}

.manifest-table-item-td {
	white-space: normal;
	color: #333;
	text-overflow: ellipsis; /* for IE */
	-moz-text-overflow: ellipsis; /* for Firefox,mozilla */
	
	text-align: left;
	font-size:1em;
    border:1px solid #98bf21;
    padding:3px 7px 2px 7px;
	
}
</style>

</head>
<body>
	
	<%
	    InputStream stream = null;
	    try
	    {
	        URL url = request.getSession ().getServletContext ().getResource ("/META-INF/MANIFEST.MF");

	        stream = url.openStream ();
	        Manifest manifest = new Manifest (stream);
	        Attributes attrs = manifest.getMainAttributes ();
	        StringBuffer buffer = new StringBuffer ();
	        buffer.append ("<h3 align='center'>Manifest文件内容</h3>");
	        buffer.append ("<table class='manifest-table' align='center' >");
	        buffer.append ("<tr>");
	        buffer.append ("<th class='manifest-table-item-th'>键</th>");
	        buffer.append ("<th class='manifest-table-item-th'>值</th>");
	        buffer.append ("</tr>");

	        for (Object key : attrs.keySet ())
	        {
	            buffer.append ("<tr>");
	            String value = attrs.getValue ((Name) key);
	            buffer.append ("<td class='manifest-table-item-td'>" + key + "</td>");
	            buffer.append ("<td class='manifest-table-item-td'>" + value + "</td>");
	            buffer.append ("</tr>");
	        }
	        buffer.append ("<table>");

	        response.getWriter ().write (buffer.toString ());
	    }
	    catch (MalformedURLException e)
	    {
	        response.getWriter ().write ("MalformedURLException：" + e.getMessage ());
	    }
	    catch (IOException e)
	    {
	        response.getWriter ().write ("IO异常：" + e.getMessage ());
	    }
	    finally
	    {
	        if (stream != null)
	        {
	            try
	            {
	                stream.close ();
	            }
	            catch (IOException e)
	            {
	                response.getWriter ().write ("关闭流失败：" + e.getMessage ());
	            }
	        }
	    }
	%>

</body>
</html>
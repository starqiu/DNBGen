<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>DNB generator and analysis</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<form action="genDNB.do" method="post">
	    <label for="basePath">base path :</label>
	    <input id="basePath"	 name="basePath"	type="text"   value="~/gdm/"   /><br /><br />
	    <label for="fileName">file name :</label>
	    <input id="fileName"	 name="fileName" type="text"  value="liver_labeled_data.txt"   /><br /><br />
	    
	    <label for="periodCount">period count :</label>
	    <input id="periodCount"	 name="periodCount"	type="text"   value="5"  /><br /><br />
	    <label for="periodSampleCount">period.sample.count :</label>
	    <input id="periodSampleCount"	 name="periodSampleCount"	 type="text"  value="5"   /><br /><br />
	    <label for="periodSampleSep">period.sample.sep :</label>
	    <input id="periodSampleSep"	 name="periodSampleSep"	 type="text"  value="10"   /><br /><br />
	    
	    <label for="featuresSdThreshold">features.sd.threshold:</label>
	    <input id="featuresSdThreshold"	 name="featuresSdThreshold"	 type="text"   value="0.001"  /><br /><br />
	    <label for="clusterHclustH">cluster.hclust.h :</label>
	    <input id="clusterHclustH"	 name="clusterHclustH"	type="text"  value="0.75"   /><br /><br />
	    <label for="pccOutAmount">pcc.out.amount :</label>
	    <input id="pccOutAmount"	 name="pccOutAmount"	 type="text"   value="50"  /><br /><br />
	    
	    <label for="cores">cores :</label>
	    <input id="cores"	 name="cores"	 type="text"   value="6"  /><br /><br />
	    
	    <input type="submit" value="submit" />
  	</form>
  </body>
</html>

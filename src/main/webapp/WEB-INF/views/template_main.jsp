<%@ page language="java"  contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html lang="en">
<head>
	<tiles:insertAttribute name="header" />
</head>
<body>
	<!-- top -->
	<tiles:insertAttribute name="top" />
	<!-- Main -->
	<div id="content">
		<div class="container">
			<div class="row">
				<div class="span3">
					<tiles:insertAttribute name="sider" />
				</div>
				<div class="span9">
				  	<tiles:insertAttribute name="content" />
				</div>
			</div>
		</div>
	</div>
	<!-- /content -->
	
	<tiles:insertAttribute name="footer" />
</body>
</html>
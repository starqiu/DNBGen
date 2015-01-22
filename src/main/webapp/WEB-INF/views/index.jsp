<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<tiles:insertTemplate template="/WEB-INF/views/header.jsp" />
</head>

<body>
	<!-- top -->
	<tiles:insertTemplate template="/WEB-INF/views/top.jsp" />
	<!-- Main -->
	<div id="content">
		<div class="container">
			<div class="row">
				<div class="span3">
					<tiles:insertTemplate template="/WEB-INF/views/sider.jsp" />
				</div>
				<!-- /span3 -->
				<div class="span9">
					<tiles:insertTemplate template="/WEB-INF/views/indexContent.jsp" />
				</div>
				<!-- /span9 -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /content -->
	<tiles:insertTemplate template="/WEB-INF/views/footer.jsp" />
	
	<script src="<c:url value='/js/excanvas.min.js' />"></script>
	<script src="<c:url value='/js/jquery.flot.js' />"></script>
	<script src="<c:url value='/js/jquery.flot.pie.js' />"></script>
	<script src="<c:url value='/js/jquery.flot.orderBars.js' />"></script>
	<script src="<c:url value='/js/jquery.flot.resize.js' />"></script>

	<script src="<c:url value='/js/charts/bar.js' />"></script>
</body>
</html>

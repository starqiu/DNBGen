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
					<tiles:insertTemplate template="/WEB-INF/views/dataManage.jsp" />
				</div>
				<!-- /span9 -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /content -->
	<tiles:insertTemplate template="/WEB-INF/views/footer.jsp" />
	<script type="text/javascript">
		$("#dataManage").addClass("active");
	</script>
</body>
</html>

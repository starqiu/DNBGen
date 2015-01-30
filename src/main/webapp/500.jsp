<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
	`<title>500!</title>
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
					<h1 class="page-title">
						<i class="icon-th-large"></i> 500错误!
					</h1>
					
					<div class="widget">
						<div class="widget-header">
							<h3>错误描述</h3>
						</div>
						<div class="widget-content">
							该页无法显示!<br />
							请与系统管理员联系!
						</div>
					</div>
					<div class="widget">
						<div class="widget-header">
							<h3>错误信息</h3>
						</div>
						<div class="widget-content">
							该页无法显示!
						</div>
					</div>
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

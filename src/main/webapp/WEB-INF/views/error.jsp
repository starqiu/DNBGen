<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%
		Exception e = (Exception) request.getAttribute("e");
	%>
<h1 class="page-title">
	<i class="icon-th-large"></i> Error
</h1>

<div class="widget">

	<div class="widget-header">
		<h3>未知错误</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">
		<%=e.getClass().getSimpleName()%>
	</div>
</div>

<div class="widget">
	<div class="widget-header">
		<h3>错误描述</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">
		<%=e.getMessage()%>
		<%--
		<c:forEach items="${e.stackTrace }"    var="s">
			${s }
		</c:forEach>
	--%>
	</div>
</div>
<%--
	
 	<div class="widget">
		<div class="widget-header">
			<h3>错误信息</h3>
		</div>

		<div class="widget-content">
			<% e.printStackTrace(new java.io.PrintWriter(out)); %>
		</div> 
	</div>
--%>

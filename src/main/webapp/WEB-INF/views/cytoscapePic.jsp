<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<script src="<c:url value='/js/jquery-1.7.2.min.js' />"></script>
<script src="<c:url value='/js/cytoscape.js' />"></script>
<script src="<c:url value='/js/custom/changePeriod.js' />"></script>
<h1 class="page-title">
	<i class="icon-signal"></i> Cytoscape Picture
</h1>

<div class="widget">
	<div class="widget-header">
		<i class="icon-star"></i>
		<h3>Current Period:${currentPeriod }</h3>
		<form  id="form" name="form" action="cytoscapePic.do" method="post" class="pull-right">
			Please select period:
			<select id="period" name="period"  style='width:100px;' onchange="changePeriod()">
				<c:forEach items="${dnbPeriods }" var="p" >
						<option value="${p }" >${p }</option>
				</c:forEach>
			</select>
		</span>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">
		<div id="cy"  class="chart-holder">
		</div>
	</div>
	<!-- /widget-content -->
	
</div>
<!-- /widget --><%--

		<div id="cy"  >
		</div>

	--%><script src="<c:url value='/js/custom/cytoscapePic.js' />"></script>
<script type="text/javascript">
	$("#cytoscapePic").addClass("active");
</script>

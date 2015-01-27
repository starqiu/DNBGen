<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<script src="<c:url value='/js/jquery-1.7.2.min.js' />"></script>
<script src="<c:url value='/js/highcharts.js' />"></script>
<script src="<c:url value='/js/modules/exporting.js' />"></script>
<script src="<c:url value='/js/custom/dnbGenerateResult.js' />"></script>
<h1 class="page-title">
	<i class="icon-signal"></i> Charts
</h1>

<div class="widget">

	<div class="widget-header">
		<i class="icon-star"></i>
		<h3>CI's Line Chart</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">

		<div id="ciLinechart" class="chart-holder">
			<div id="container"
				style="min-width: 310px; height: 400px; margin: 0 auto"></div>
			<script type="text/javascript">
				drawLineChart('${ciData}');
			</script>
		</div>
		<!-- /donut-chart -->

	</div>
	<!-- /widget-content -->

</div>
<!-- /widget -->

<div class="widget-header">
	<i class="icon-th-list"></i>
	<h3>DNB Table</h3>
</div>
<!-- /widget-header -->
<div class="row">
	<%--
	<div id="dnbTable" class="chart-holder">
		--%>
	<c:if test="${!empty  dnbDatas}">
		<c:forEach items="${dnbDatas }" varStatus="s" var="dnb">
			<div class="span3">
				<div class="widget">
					<div class="widget-content">
						Period : ${dnb.period }<br /> DNB Gene Ids :<br />
						<textarea rows="10" cols="10" readonly>
							<c:forEach items="${dnb.ids }" var="id"><fmt:message key="line.break"><fmt:param value="${id}" /></fmt:message></c:forEach>
						</textarea>
						<br />
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>
</div>
<script type="text/javascript">
	$("#charts").addClass("active");
</script>

<!--<script src="<c:url value='/js/bootstrap.js' />"></script>
<script src="<c:url value='/js/excanvas.min.js' />"></script>
<script src="<c:url value='/js/jquery.flot.js' />"></script>
<script src="<c:url value='/js/jquery.flot.pie.js' />"></script>
<script src="<c:url value='/js/jquery.flot.orderBars.js' />"></script>
<script src="<c:url value='/js/jquery.flot.resize.js' />"></script>

-->
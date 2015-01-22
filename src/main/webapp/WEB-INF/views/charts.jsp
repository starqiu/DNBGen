<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h1 class="page-title">
	<i class="icon-signal"></i> Charts
</h1>




<div class="widget">

	<div class="widget-header">
		<h3>Area Chart</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">

		<div id="area-chart" class="chart-holder"></div>
		<!-- /area-chart -->



	</div>
	<!-- /widget-content -->

</div>
<!-- /widget -->




<div class="widget">

	<div class="widget-header">
		<h3>Line Chart</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">

		<div id="line-chart" class="chart-holder"></div>
		<!-- /donut-chart -->



	</div>
	<!-- /widget-content -->

</div>
<!-- /widget -->



<div class="widget">

	<div class="widget-header">
		<h3>Bar Chart</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">

		<div id="bar-chart" class="chart-holder"></div>
		<!-- /donut-chart -->



	</div>
	<!-- /widget-content -->

</div>
<!-- /widget -->




<div class="widget">

	<div class="widget-header">
		<h3>Pie Chart</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">

		<div id="pie-chart" class="chart-holder"></div>
		<!-- /donut-chart -->

	</div>
	<!-- /widget-content -->

</div>
<!-- /widget -->
<script src="<c:url value='/js/jquery-1.7.2.min.js' />"></script>
<script src="<c:url value='/js/bootstrap.js' />"></script>
<script src="<c:url value='/js/excanvas.min.js' />"></script>
<script src="<c:url value='/js/jquery.flot.js' />"></script>
<script src="<c:url value='/js/jquery.flot.pie.js' />"></script>
<script src="<c:url value='/js/jquery.flot.orderBars.js' />"></script>
<script src="<c:url value='/js/jquery.flot.resize.js' />"></script>

<script src="<c:url value='/js/charts/bar.js' />"></script>
<script src="<c:url value='/js/charts/area.js' />"></script>
<script src="<c:url value='/js/charts/line.js' />"></script>
<script src="<c:url value='/js/charts/pie.js' />"></script>


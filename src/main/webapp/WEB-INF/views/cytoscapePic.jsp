<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<script src="<c:url value='/js/jquery-1.7.2.min.js' />"></script>
<script src="<c:url value='/js/cytoscape.js' />"></script>
<script src="<c:url value='/js/custom/cytoscapePic.js' />"></script>
<h1 class="page-title">
	<i class="icon-signal"></i> Cytoscape Picture
</h1>

<div class="widget">

	<div class="widget-header">
		<i class="icon-star"></i>
		<h3>Cytoscape Picture</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">


		<div id="cy" class="chart-holder">
			<script type="text/javascript">
			drawCytoPic('${cytoElement}','cy');
			</script>
		</div>
		<!-- /donut-chart -->

	</div>
	<!-- /widget-content -->

</div>
<!-- /widget -->

<script type="text/javascript">
	$("#cytoscapePic").addClass("active");
</script>

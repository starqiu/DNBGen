<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page isELIgnored="false"%>

<h1 class="page-title">
	<i class="icon-home"></i> Dashboard
</h1>

<div class="widget">

	<div class="widget-header">
		<i class="icon-signal"></i>
		<h3>Input Patameters</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">
		<form id="form" role="form" action="genDNB.do" method="post">
			<div class="row">
				<div class="span4">
					<label for="basePath" class="control-label" >base path </label> <input id="basePath"
						name="basePath" type="text" class="form-control" value="~/gdm/" readonly />
				</div>
				<div class="span4">
					<label for="fileName" class="control-label" >file name</label> 
					<c:if test="${empty  fileNames}">
					no  files to generate DNB ,please <a href="dataManage.do" >upload file </a>
					</c:if>
					<c:if test="${!empty  fileNames}">
						<select  id="fileName"  name="fileName"    class="form-control" >
							<c:forEach items="${fileNames }" varStatus="s">
								<option name="${fileNames[s.index] }">${fileNames[s.index] }</option>
							</c:forEach>
						</select>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="span4">
					<label for="periodCount" class="control-label" >period count</label> <input id="periodCount"
						name="periodCount" type="text" value="5"    class="form-control"  />
				</div>
				<div class="span4">
					<label for="periodSampleCount" class="control-label" >period sample count</label> <input
						id="periodSampleCount" name="periodSampleCount" type="text"
						value="5"    class="form-control"  />
				</div>
			</div>
			<div class="row">
				<div class="span4">
					<label for="periodSampleSep" class="control-label" >period sample sep</label> <input
						id="periodSampleSep" name="periodSampleSep" type="text" value="10"    class="form-control"  />
				</div>
				<div class="span4">
					<label for="featuresSdThreshold" class="control-label" >features sd threshold </label> <input
						id="featuresSdThreshold" name="featuresSdThreshold" type="text"
						value="0.001"    class="form-control"  />
				</div>
			</div>
			<div class="row">
				<div class="span4">
					<label for="clusterHclustH" class="control-label" >cluster hclust h</label> <input
						id="clusterHclustH" name="clusterHclustH" type="text" value="0.75"    class="form-control"  />
				</div>
				<div class="span4">
					<label for="pccOutAmount" class="control-label" >pcc out amount</label> <input
						id="pccOutAmount" name="pccOutAmount" type="text" value="50"    class="form-control"  />
				</div>
			</div>
			<div class="row">
				<div class="span4">
					<label for="cores" class="control-label" >cores</label> <input id="cores" name="cores"
						type="text" value="6"    class="form-control"  />
				</div>
				<div class="span4"></div>
			</div>



			<br /> <input type="submit" value="submit" />
		</form>
	</div>
	<!-- /widget-content -->

</div>
<!-- /widget -->



<div class="widget widget-table">

	<div class="widget-header">
		<i class="icon-th-list"></i>
		<h3>Table</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">



	</div>
	<!-- /widget-content -->

</div>
<!-- /widget -->




<div class="row">

	<div class="span5">

		<div class="widget">

			<div class="widget-header">
				<h3>5 Column</h3>
			</div>
			<!-- /widget-header -->

			<div class="widget-content">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
					reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
					pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
					culpa qui officia deserunt mollit anim id est laborum.</p>
			</div>
			<!-- /widget-content -->

		</div>
		<!-- /widget -->

	</div>
	<!-- /span5 -->

	<div class="span4">

		<div class="widget">

			<div class="widget-header">
				<h3>4 Column</h3>
			</div>
			<!-- /widget-header -->

			<div class="widget-content">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
					reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
					pariatur.</p>
			</div>
			<!-- /widget-content -->

		</div>
		<!-- /widget -->
	</div>
	<!-- /span4 -->

</div>
<!-- /row -->
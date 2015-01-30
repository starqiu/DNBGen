<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1 class="page-title">
	<i class="icon-upload"></i> Data Manage
</h1>

<div class="widget">

	<div class="widget-header">
		<h3>Upload</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">
		<form action="upload.do" method="post" enctype="multipart/form-data">
			<input type="file" id="file" name="file" class="form-control" /> <input
				type="submit" value="Upload" />
		</form>

	</div>
	<!-- /widget-content -->

</div>
<!-- /widget -->

<div class="widget">

	<div class="widget-header">
		<h3>File List</h3>
	</div>
	<!-- /widget-header -->

	<div class="widget-content">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>File Name</th>
					<th>Size</th>
					<th>Last Modified</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:if test="${!empty  uploadedFiles}">
					<c:forEach items="${uploadedFiles }" varStatus="s">
						<c:choose>
							<c:when test="${s.index%2 ==1 }">
								<tr class="label-success">
									<td>${s.index }</td>
									<td>${uploadedFiles[s.index].fileName }</td>
									<td>${uploadedFiles[s.index].size } B</td>
									<td><fmt:formatDate
											value="${uploadedFiles[s.index].lastModifiedTime }"
											pattern="yyyy/MM/dd HH:mm:ss" />
									</td>
									<td><a href="rmFile.do?fileName=${uploadedFiles[s.index].fileName }">
											<i class="icon-remove"></i> </a>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr class="label-info">
									<td>${s.index }</td>
									<td>${uploadedFiles[s.index].fileName }</td>
									<td>${uploadedFiles[s.index].size } B</td>
									<td><fmt:formatDate
											value="${uploadedFiles[s.index].lastModifiedTime }"
											pattern="yyyy/MM/dd HH:mm:ss" />
									</td>
									<td><a href="rmFile.do?fileName=${uploadedFiles[s.index].fileName }">
											<i class="icon-remove"></i> </a>
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	<!-- /widget-content -->

</div>
<!-- /widget -->
	<script type="text/javascript">
		$("#dataManage").addClass("active");
	</script>

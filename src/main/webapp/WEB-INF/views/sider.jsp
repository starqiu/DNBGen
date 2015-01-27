<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="account-container">

	<div class="account-avatar">
		<img src="<c:url value='/img/headshot.png' />" alt=""
			class="thumbnail" />
	</div>
	<!-- /account-avatar -->

	<div class="account-details">

		<span class="account-name">Rod Howard</span> <span
			class="account-role">Administrator</span> <span
			class="account-actions"> <a href="javascript:;">Profile</a> |
			<a href="javascript:;">Edit Settings</a> </span>

	</div>
	<!-- /account-details -->

</div>
<!-- /account-container -->

<hr />

<ul id="main-nav" class="nav nav-tabs nav-stacked">

	<li  id="dataManage"><a href="dataManage.do"> <i class="icon-upload"></i>
			Data Manage </a></li>

	<li id="paramInput"><a href="paramInput.do"> <i class="icon-pencil"></i>
			Parameters Input </a></li>

	<li id="charts"><a href="charts.do"> <i class="icon-signal"></i> Charts </a></li><%--

	<li><a href="grid.do"> <i class="icon-th-large"></i> Grid
			Layout <span class="label label-warning pull-right">5</span> </a></li>
			
	<li><a href="account.do"> <i class="icon-user"></i> User
			Account </a></li>

	<li><a href="login.do"> <i class="icon-lock"></i> Login </a>
	</li>
	<li><a href="faq.do"> <i class="icon-pushpin"></i> FAQ </a>
	</li>

--%></ul>

<%--<hr />

<div class="sidebar-extra">
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
		eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
		minim veniam, quis nostrud.</p>
</div>
--%><!-- .sidebar-extra -->

<br />
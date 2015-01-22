<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navbar navbar-fixed-top">

	<div class="navbar-inner">

		<div class="container">

			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> </a> <a
				class="brand" href="./">Adminia Admin</a>

			<div class="nav-collapse">

				<ul class="nav pull-right">
					<li><a href="#"><span class="badge badge-warning">7</span>
					</a>
					</li>

					<li class="divider-vertical"></li>

					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle " href="#"> Rod Howard <b class="caret"></b>
					</a>

						<ul class="dropdown-menu">
							<li><a href="account.do"><i class="icon-user"></i>
									Account Setting </a>
							</li>

							<li><a href="change_password.do"><i class="icon-lock"></i>
									Change Password</a>
							</li>

							<li class="divider"></li>

							<li><a href="./"><i class="icon-off"></i> Logout</a>
							</li>
						</ul>
					</li>
				</ul>

			</div>
			<!-- /nav-collapse -->

		</div>
		<!-- /container -->

	</div>
	<!-- /navbar-inner -->

</div>
<!-- /navbar -->

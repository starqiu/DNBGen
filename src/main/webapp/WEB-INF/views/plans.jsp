<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Pricing Plans - Bootstrap Admin</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="<c:url value='/css/bootstrap.min.css' /> "  rel="stylesheet" />
    <link href="<c:url value='/css/bootstrap-responsive.min.css' />"  rel="stylesheet" />
    
    <link href="<c:url value='/css/font-awesome.css' />"  rel="stylesheet" />
    
    <link href="<c:url value='/css/adminia.css' />"  rel="stylesheet" /> 
    <link href="<c:url value='/css/adminia-responsive.css' />"  rel="stylesheet" /> 
    
    <link href="<c:url value='/css/pages/plans.css' />" rel="stylesheet" /> 

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body>
	
<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 				
			</a>
			
			<a class="brand" href="./">Adminia Admin</a>
			
			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					<li>
						<a href="#"><span class="badge badge-warning">7</span></a>
					</li>
					
					<li class="divider-vertical"></li>
					
					<li class="dropdown">
						
						<a data-toggle="dropdown" class="dropdown-toggle " href="#">
							Rod Howard <b class="caret"></b>							
						</a>
						
						<ul class="dropdown-menu">
							<li>
								<a href="account.do"><i class="icon-user"></i> Account Setting  </a>
							</li>
							
							<li>
								<a href="change_password.do"><i class="icon-lock"></i> Change Password</a>
							</li>
							
							<li class="divider"></li>
							
							<li>
								<a href="./"><i class="icon-off"></i> Logout</a>
							</li>
						</ul>
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->




<div id="content">
	
	<div class="container">
		
		<div class="row">
			
			<div class="span3">
				
				<div class="account-container">
				
					<div class="account-avatar">
						<img src="<c:url value='/img/headshot.png' />" alt="" class="thumbnail" />
					</div> <!-- /account-avatar -->
				
					<div class="account-details">
					
						<span class="account-name">Rod Howard</span>
						
						<span class="account-role">Administrator</span>
						
						<span class="account-actions">
							<a href="javascript:;">Profile</a> |
							
							<a href="javascript:;">Edit Settings</a>
						</span>
					
					</div> <!-- /account-details -->
				
				</div> <!-- /account-container -->
				
				<hr />
				
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					
					<li>
						<a href="./">
							<i class="icon-home"></i>
							Dashboard 			
						</a>
					</li>
					
					<li>
						<a href="faq.do">
							<i class="icon-pushpin"></i>
							FAQ	
						</a>
					</li>
					
					<li class="active">
						<a href="plans.do">
							<i class="icon-th-list"></i>
							Pricing Plans		
						</a>
					</li>
					
					<li>
						<a href="grid.do">
							<i class="icon-th-large"></i>
							Grid Layout	
							<span class="label label-warning pull-right">5</span>
						</a>
					</li>
					
					<li>
						<a href="charts.do">
							<i class="icon-signal"></i>
							Charts	
						</a>
					</li>
					
					<li>
						<a href="account.do">
							<i class="icon-user"></i>
							User Accout					
						</a>
					</li>
					
					<li>
						<a href="login.do">
							<i class="icon-lock"></i>
							Login	
						</a>
					</li>
					
				</ul>	
				
				
				
				<hr />
				
				<div class="sidebar-extra">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.</p>
				</div> <!-- .sidebar-extra -->
				
				<br />
		
			</div> <!-- /span3 -->
			
			
			
			<div class="span9">
				
				<h1 class="page-title">
					<i class="icon-th-list"></i>
					Pricing Plans					
				</h1>
				
				
				
				
				
				
				<div class="widget">
					
					<div class="widget-header">
						<h3>Available Plans</h3>
					</div> <!-- /widget-header -->
														
					<div class="widget-content">
						
						<div class="pricing-plans plans-3">
							
						<div class="plan-container">
					        <div class="plan">
						        <div class="plan-header">
					                
						        	<div class="plan-title">
						        		Micro	        		
					        		</div> <!-- /plan-title -->
					                
						            <div class="plan-price">
					                	<span class="note">$</span>15<span class="term">Per Month</span>
									</div> <!-- /plan-price -->
									
						        </div> <!-- /plan-header -->	        
						        
						        <div class="plan-features">
									<ul>
										<li><strong>Free</strong> setup</li>
										<li><strong>1</strong> Website</li>
										<li><strong>2</strong> Projects</li>
										<li><strong>1GB</strong> Storage</li>
										<li><strong>$0</strong> Google Adwords Credit</li>
									</ul>
								</div> <!-- /plan-features -->
								
								<div class="plan-actions">				
									<a href="javascript:;" class="btn">Purchase Now</a>				
								</div> <!-- /plan-actions -->
					
							</div> <!-- /plan -->
					    </div> <!-- /plan-container -->
					    
					    <div class="plan-container">
					        <div class="plan">
						        <div class="plan-header">
					                
						        	<div class="plan-title">
						        		Starter	        		
					        		</div> <!-- /plan-title -->
					                
						            <div class="plan-price">
					                	<span class="note">$</span>35<span class="term">Per Month</span>
									</div> <!-- /plan-price -->
									
						        </div> <!-- /plan-header -->       
						        
						        <div class="plan-features">
									<ul>
										<li><strong>Free</strong> setup</li>
										<li><strong>5</strong> Website</li>
										<li><strong>10</strong> Projects</li>
										<li><strong>5GB</strong> Storage</li>
										<li><strong>$25</strong> Google Adwords Credit</li>
									</ul>
								</div> <!-- /plan-features -->
								
								<div class="plan-actions">				
									<a href="javascript:;" class="btn">Purchase Now</a>				
								</div> <!-- /plan-actions -->
					
							</div> <!-- /plan -->
					    </div> <!-- /plan-container -->
					    
					    <div class="plan-container">
					        <div class="plan orange">
						        <div class="plan-header">
					                
						        	<div class="plan-title">
						        		Business	        		
					        		</div> <!-- /plan-title -->
					                
						            <div class="plan-price">
					                	<span class="note">$</span>75<span class="term">Per Month</span>
									</div> <!-- /plan-price -->
									
						        </div> <!-- /plan-header -->	          
						        
						        <div class="plan-features">
									<ul>					
										<li><strong>Free</strong> setup</li>
										<li><strong>20</strong> Website</li>
										<li><strong>35</strong> Projects</li>
										<li><strong>Unlimited</strong> Storage</li>
										<li><strong>$65</strong> Google Adwords Credit</li>
									</ul>
								</div> <!-- /plan-features -->
								
								<div class="plan-actions">				
									<a href="javascript:;" class="btn">Purchase Now</a>				
								</div> <!-- /plan-actions -->
					
							</div> <!-- /plan -->
					    </div> <!-- /plan-container -->
				
				
					</div> <!-- /pricing-plans -->
										
					</div> <!-- /widget-content -->
					
				</div> <!-- /widget -->
				
				
				
				
				<div class="widget">
					
					<div class="widget-header">
						<h3>Account Information</h3>
					</div> <!-- /widget-header -->
														
					<div class="widget-content">
						
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
						
						<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
					</div> <!-- /widget-content -->
					
				</div> <!-- /widget -->
				
				
				
			</div> <!-- /span9 -->
			
			
		</div> <!-- /row -->
		
	</div> <!-- /container -->
	
</div> <!-- /content -->
					
	
<div id="footer">
	
	<div class="container">				
		<hr />
		<p>&copy; 2012 Go Ideate.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="妯℃澘涔嬪">妯℃澘涔嬪</a> - Collect from <a href="http://www.cssmoban.com/" title="缃戦〉妯℃澘" target="_blank">缃戦〉妯℃澘</a></p>
	</div> <!-- /container -->
	
</div> <!-- /footer -->


    

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value='/js/jquery-1.7.2.min.js' />"></script>
<script src="<c:url value='/js/bootstrap.js' />"></script>

  </body>
</html>

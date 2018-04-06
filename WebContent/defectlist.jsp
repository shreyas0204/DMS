<!DOCTYPE html>
<html lang="en">
<%@ page import="java.sql.*"%>
<head>

<meta charset="utf-8">
<title>All Partner</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">

<!-- The styles -->
<link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

<link href="css/charisma-app.css" rel="stylesheet">
<link href='bower_components/fullcalendar/dist/fullcalendar.css'
	rel='stylesheet'>
<link href='bower_components/fullcalendar/dist/fullcalendar.print.css'
	rel='stylesheet' media='print'>
<link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
<link href='bower_components/colorbox/example3/colorbox.css'
	rel='stylesheet'>
<link href='bower_components/responsive-tables/responsive-tables.css'
	rel='stylesheet'>
<link
	href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
	rel='stylesheet'>
<link href='css/jquery.noty.css' rel='stylesheet'>
<link href='css/noty_theme_default.css' rel='stylesheet'>
<link href='css/elfinder.min.css' rel='stylesheet'>
<link href='css/elfinder.theme.css' rel='stylesheet'>
<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='css/uploadify.css' rel='stylesheet'>
<link href='css/animate.min.css' rel='stylesheet'>

<!-- jQuery -->
<script src="bower_components/jquery/jquery.min.js"></script>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>

	<%
		ResultSet rs = (ResultSet) request.getAttribute("defectList");
		rs.beforeFirst();
	%>
	<!-- topbar starts -->
	<div class="navbar navbar-default" role="navigation">

		<jsp:include page="admin-header.jsp"></jsp:include>
	</div>
	<!-- topbar ends -->


	<div class="ch-container">
		<div class="row">
			<!-- left menu starts -->
			<div class="col-sm-2 col-lg-2">
				<div class="sidebar-nav">
					<div class="nav-canvas">
						<jsp:include page="admin-menu.jsp"></jsp:include>
					</div>
				</div>
			</div>
			<!--/span-->
			<!-- left menu ends -->

			<noscript>
				<div class="alert alert-block col-md-12">
					<h4 class="alert-heading">Warning!</h4>

					<p>
						You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> enabled to use this site.
					</p>
				</div>
			</noscript>
			<div id="content" class="col-lg-10 col-sm-12">
				<!-- content starts -->

				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-user"></i> Partner List
								</h2>

								<div class="box-icon">
									<a href="#" class="btn btn-setting btn-round btn-default"><i
										class="glyphicon glyphicon-cog"></i></a> <a href="#"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i></a>
								</div>
							</div>
							<div class="box-content">
							
						              	
							
								<!-- 	<div class="alert alert-info"> -->
								<div align="right">
									<!-- <a class="btn btn-info" href='window.open("clientform.html",target="_blank")'> -->
									<button class="btn btn-success"
										onClick="window.open('partnerform.jsp', '_blank', 'height=500,width=500')"
										style="width: inherit;">Add Bug</button>
								</div>
								<!-- </div> -->
								<table
									class="table table-striped table-bordered bootstrap-datatable datatable responsive">
									<thead>
										<tr>
											<th>ID</th>
											<th>Bug</th>
											<th>Type</th>
											<th>Severity</th>
											<th>Status</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<%
											while (rs.next()) {
										%>

										<tr>
											<td><%=rs.getInt("id")%></td>
											<td class="center"><%=rs.getString("name")%></td>
											<td class="center"><%=rs.getString("bug_type")%></td>
											<td class="center"><%=rs.getString("severity")%></td>
											<td class="center"><%=rs.getString("status")%></td>
											<td class="center"><a class="btn btn-success" href="#"
												onClick="window.open('viewclient?orgid=<%=rs.getString("id")%>', '_blank', 'height=500,width=500')">
													<i class="glyphicon glyphicon-zoom-in icon-white"></i> View
											</a> <a class="btn btn-info" href="#"' onClick="window.open(editc?id=<%=rs.getInt("id")%>', '_blank', 'height=500,width=500')"> <i
													class="glyphicon glyphicon-edit icon-white"></i> Edit
											</a> <a class="btn btn-danger" href="#" onclick="deletes('<%=rs.getInt("id")%>')"> <i
													class="glyphicon glyphicon-trash icon-white"></i> Delete
											</a></td>
										</tr>

										<%
											}
										%>

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!--/span-->

				</div>
				<!--/row-->

				<div class="row">
					<!-- <div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title=""></div>
						</div>
					</div> -->
					<!--/span-->


					<footer class="row">
						<p class="col-md-9 col-sm-9 col-xs-12 copyright">
							&copy; <a href="http://usman.it" target="_blank">Username </a>
							2012 - 2015
						</p>

						<p class="col-md-3 col-sm-3 col-xs-12 powered-by">
							Powered by:Tindrilla <a
								href="http://usman.it/free-responsive-admin-template"></a>
						</p>
					</footer>

				</div>
			</div>
		</div>
	</div>

	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- library for cookie management -->
	<script src="js/jquery.cookie.js"></script>
	<!-- calender plugin -->
	<script src='bower_components/moment/min/moment.min.js'></script>
	<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='js/jquery.dataTables.min.js'></script>

	<!-- select or dropdown enhancer -->
	<script src="bower_components/chosen/chosen.jquery.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
	<!-- notification plugin -->
	<script src="js/jquery.noty.js"></script>
	<!-- library for making tables responsive -->
	<script src="bower_components/responsive-tables/responsive-tables.js"></script>
	<!-- tour plugin -->
	<script
		src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
	<!-- star rating plugin -->
	<script src="js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>

	<script type="text/javascript">
	
	function deletes(name,id){
	
		var cnf = confirm("Delete " + name + " ? ")
		if (cnf) {
			alert("Partner has been Deleted");
			window.location="deletePartner?id=" + id;
			
		}
	}
	
</script>
</body>
</html>

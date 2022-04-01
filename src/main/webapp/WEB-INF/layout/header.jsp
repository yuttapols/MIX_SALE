<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<style>
.dropbtn {
/*   background-color: #4CAF50; */
  color: black;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  margin-left: -60%;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

/* .dropdown:hover .dropbtn {background-color: #3e8e41;} */
</style>

<div id="wrapper">
	<nav class="navbar navbar-inverse top-bar navbar-fixed-top" style="background-color: #ee7600;">
		<div class="container-fluid">
			<div class="navbar-header">
<!-- 				<i class="fa fa-bullseye"></i> Offline -->
				<img src="images/CATTelecom_Logo.png"  alt=""/>
			</div>
			<div class="navbar-right">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</c:if>
				<h4>${pageContext.request.userPrincipal.name} | 
					<div class="dropdown">
					  <a class="dropbtn">ตัวเลือก<span class="pull-right hidden-xs glyphicon glyphicon-cog"></span></a>
					  <div class="dropdown-content">
					    <a href="${contextPath}/change-password">เปลี่ยนรหัสผ่าน</a>
					    <a href="#" onclick="document.forms['logoutForm'].submit()">Logout</a>
					  </div>
					</div>
				</h4>
				
			</div>
		</div>
	</nav>
</div>
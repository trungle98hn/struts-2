<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
  <li><a href="#home">Trang chủ</a></li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Các trang quản lí</a>
    <div class="dropdown-content">
      <s:a href="listSach.action" key="global.book">Quản lí sách</s:a>
      <a href="listCategory.action" >Chủ đề</a>
      <a href="listLanguage.action">Ngôn ngữ</a>
      <a href="listPubhouse.action">Nhà xuất bản</a>
    </div>
  </li>
  <li style="float: right;">Welcome <i style="color: white;">${sessionScope.userName}</i><a style="color: white;"> <s:property value="username"/></a> <a href="login.jsp">Đăng xuất</a></li>
	<li>
	<s:url id="indexEN" namespace="/" action="listSach.action">
	<s:param name="request_locale">en</s:param>
	</s:url>
	<s:url id="indexVI" namespace="/" action="listSach.action">
	<s:param name="request_locale">vi</s:param>
	</s:url>
	<s:a href="%{indexEN}">en</s:a>
	<s:a href="%{indexVI}">vi</s:a>
	
	</li>
</ul> 
</body>
</html>
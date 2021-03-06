<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Danh mục chủ đề</title>
<s:head />
<style type="text/css">
@import url(css/style.css);
@import url(css/css.css);
</style>
</head>
<body>
	<jsp:include page="header.jsp" /><br>
	<s:form cssClass="form" action="saveOrUpdateCate" validate="true" method="GET" acceptcharset="UTF-8">
		<s:push value="category">
			<s:hidden name="id" />
			<s:actionerror/>
			<s:textfield name="tenchude" label="Tên chủ đề" labelposition="top"/>
			<s:submit value="Xác nhận" />
		</s:push>
	</s:form>
<br>
	<s:if test="categoryList.size() > 0">
		<div class="content">
			<table class="userTable" cellpadding="10px">
				<tr class="even">
				<th>STT</th>
					<th><s:text name="global.ID"></s:text></th>
					<th><s:text name="global.Name"></s:text></th>
					<th><s:text name="global.edit"></s:text></th>
					<th><s:text name="global.delete"></s:text></th>
				</tr>
					<c:set var="stt" value="0" />
				<s:iterator value="categoryList" status="categoryStatus">
					<tr
						class="<s:if test="#categoryStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<c:set var="stt" value="${stt+1}" />
						<td>00${stt}</td>
						<td>CD<s:property value="id" /></td>
						<td><s:property value="tenchude" /></td>
						<td><s:url id="editURL" action="editCategory">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}"><img src="img/icon1.png" style="width: 28px;"></s:a></td>
						<td><s:url id="deleteURL" action="deleteCategory">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a onclick="return confirm('Bạn có muốn xóa')"
								href="%{deleteURL}"><img src="img/icon2.png" style="width: 28px;"></s:a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>
</body>
</html>
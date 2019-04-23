<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sd"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>sách</title>
<sd:head />
<style type="text/css">
@import url(css/style.css);

@import url(css/css.css);
</style>
</head>
<body>

	<jsp:include page="header.jsp" /><br>

	<s:form action="saveOrUpdateSach" method="GET" acceptcharset="UTF-8">
		<s:push value="sach">
			<div class="tong2le">
				<div class="letrai">
					<s:hidden name="id" />
					<s:textfield name="tieude" label="Tiêu Đề" labelposition="top" />
					<s:select name="chude.id" list="categoryList" listKey="id"
						listValue="tenchude" headerKey="" headerValue="Chọn"
						label="Chọn chủ đề" labelposition="top" />
					<s:textfield name="tacgia" label="Tác giả" labelposition="top" />
					<s:radio name="phienban"
						list="#{'true':'Bìa cứng','false':'Bìa mềm'}"
						label="Chọn phiên bản" labelposition="top" />
				</div>
				<div class="letrai2">
					<s:textfield name="namxuatban" label="Năm xuất bản"
						labelposition="top" />
					<s:select name="nhaxb.id" list="pubhouseList" listKey="id"
						listValue="tennhaxb" headerKey="" headerValue="Chọn"
						label="Chọn nhà xuât bản" labelposition="top" />
					<s:select name="ngonngu.id" list="languageList" listKey="id"
						listValue="tenngonngu" headerKey="" headerValue="Chọn"
						label="Chọn ngôn ngữ" labelposition="top" />
					<s:textfield name="sotrang" label="Số trang" labelposition="top" />
					<s:textfield name="gia" label="Giá tiền" labelposition="top" />
					<s:textfield name="sobanluu" label="Số bản lưu" labelposition="top" />
					<s:checkbox name="bandientu" label="Bản điện tử" />
					<s:checkbox name="duocmuon" label="Được mượn" />
				</div>
				<s:submit value="Xác nhận" />
			</div>
		</s:push>
	</s:form>
	<br>
	<s:if test="sachList.size() > 0">
		<div class="content">
			<table class="userTable" cellpadding="10px">
				<tr class="even">
					<th>STT</th>
					<th><s:text name="global.ID"></s:text></th>
					<th><s:text name="global.bookTitle"></s:text></th>
					<th><s:text name="global.bookCate"></s:text></th>
					<th><s:text name="global.bookAuthor"></s:text></th>
					<th><s:text name="global.bookYear"></s:text></th>
					<th><s:text name="global.bookVer"></s:text></th>
					<th><s:text name="global.bookPub"></s:text></th>
					<th><s:text name="global.bookLang"></s:text></th>
					<th><s:text name="global.bookNum"></s:text></th>
					<th><s:text name="global.bookPrice"></s:text></th>
					<th><s:text name="global.bookAmount"></s:text></th>
					<th><s:text name="global.bookEbook"></s:text></th>
					<th><s:text name="global.bookBook"></s:text></th>
					<th><s:text name="global.edit"></s:text></th>
					<th><s:text name="global.delete"></s:text></th>
				</tr>
				<s:set var="stt" value="0" />
				<s:iterator value="sachList" status="sachStatus">
					<tr
						class="<s:if test="#sachStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<c:set var="stt" value="${stt+1}" />
						<td>00${stt}</td>
						<td>BOOK<s:property value="id" /></td>
						<td><s:property value="tieude" /></td>
						<td><s:property value="chude.tenchude" /></td>
						<td><s:property value="tacgia" /></td>
						<td><s:property value="namxuatban" /></td>
						<td><s:property value="phienban?'Bìa cứng':'Bìa mềm'" /></td>
						<td><s:property value="nhaxb.tennhaxb" /></td>
						<td><s:property value="ngonngu.tenngonngu" /></td>
						<td><s:property value="sotrang" /></td>
						<td><s:property value="gia" /> VNĐ</td>
						<td><s:property value="sobanluu" /></td>
						<td><s:property value="bandientu?'Có':'Không'" /></td>
						<td><s:property value="duocmuon?'Có':'Không'" /></td>
						<td><s:url id="editURL" action="editSach">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">
								<img src="img/icon1.png" style="width: 28px;">
							</s:a></td>
						<td><s:url id="deleteURL" action="deleteSach">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a onclick="return confirm('Bạn có muốn xóa')"
								href="%{deleteURL}">
								<img src="img/icon2.png" style="width: 28px;">
							</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>
</body>
</html>
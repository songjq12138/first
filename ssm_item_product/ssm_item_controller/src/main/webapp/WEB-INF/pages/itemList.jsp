<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">

</script>

<title>查询商品列表</title>
</head>
<body> 

<form action="${pageContext.request.contextPath }/items/queryitem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td>商品名称: <input type="text" name="name"></td>
<td>商品价格: <input type="text" name="price"></td>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>商品图片</td>
	<td>上传时间</td>
	<td>商品详情</td>
	<td>操作</td>
</tr>
<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
		<c:forEach items="${list}" var="product">
	<tr>
			<td>${product.name}</td>
			<td>${product.price}</td>
			
			<td><img src="${product.pic}"/></td>
			<td>${product.createtime}</td>
			<td>${product.detail}</td>
			<td><a href="${pageContext.request.contextPath }/product/findById?id=${product.id}">修改</a></td>
	</tr>
		</c:forEach>


</table>
</form>
</body>

</html>
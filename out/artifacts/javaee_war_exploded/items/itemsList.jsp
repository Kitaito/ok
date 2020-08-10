<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>商品列表</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/index.js"></script>
	<script src="${pageContext.request.contextPath}/js/user.js"></script>
</head>
<body>
<div style="padding: 0 20px">
	<div class="row" style="margin-top: 10px">
		<div class="col-md-6 col-lg-6">
			<div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" onclick="viewAll('${pageContext.request.contextPath}/items?code=viewAll')">查找</button>
                    </span>
				<input type="text" class="form-control" placeholder="Search by name" id="searchName" value="${vo.query}"}>
			</div>
		</div>
		<div class="col-md-4 col-lg-4">
			<input class="btn btn-success" type="button" value="增加商品" onclick="">
			<input class="btn btn-danger" type="button" value="删除所有" onclick="">
		</div>
	</div>
	<div class="row" style="margin-top: 20px">
		<table class="table table-bordered">
			<tr align="center">
				<th style="text-align:center"><input type="checkbox" class="choose_all"></th>
				<th style="text-align:center">商品编号</th>
				<th style="text-align:center">商品名称</th>
				<th style="text-align:center">商品描述</th>
				<th style="text-align:center">商品价格</th>
				<th style="text-align:center">生产日期</th>
				<th style="text-align:center">商品图片</th>
				<th style="text-align:center">操作</th>
			</tr>
			<c:forEach items="${vo.list}" var="items">
				<tr class="data" align="center">
					<td class="datachoose"><input type="checkbox" class="single"></td>
					<td class="id">${items.id}</td>
					<td>${items.name}</td>
					<td>${items.detail}</td>
					<td>${items.price}</td>
					<td><fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd"/></td>
					<td>
						<c:if test="${items.pic!=null && items.pic!=''}">
							<img src="${items.pic}" width="64px" height="auto"/>
						</c:if>
					</td>
					<td>
						<a href="javascript:void(0)" class="btn btn-info" onclick="">修改</a>
						<a href="" class="btn btn-danger">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr align="center">
				<td colspan="8">
					<input class="btn btn-success" type="button" value="首页"
						   onclick="first('${pageContext.request.contextPath}/items?code=viewAll')"/>&nbsp;&nbsp;
					<input class="btn btn-success" type="button" id="pre" value="上一页"
						   onclick="pre('${pageContext.request.contextPath}/items?code=viewAll')"/>&nbsp;&nbsp;
					<!-- 当前页 -->
					<input type="text" id="pageNow" value="${vo.pageNow}" style="text-align:center"/>&nbsp;&nbsp;
					<input class="btn btn-success" type="button" value="跳转"
						   onclick="skip('${pageContext.request.contextPath}/items?code=viewAll',${vo.myPages})"/>&nbsp;&nbsp;
					<input class="btn btn-success" type="button" id="next" value="下一页"
						   onclick="next('${pageContext.request.contextPath}/items?code=viewAll',${vo.myPages})"/>&nbsp;&nbsp;
					<input class="btn btn-success" type="button" value="末页"
						   onclick="last('${pageContext.request.contextPath}/items?code=viewAll',${vo.myPages})"/>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</div>
</div>

</body>

</html>
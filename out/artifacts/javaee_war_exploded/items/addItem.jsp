<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改商品信息</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div style="padding: 0 20px;margin-top: 10px">
		<h2 class="form-group">添加商品</h2>
		<form id="f" action="" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">商品名称</label>
				<input type="text" class="form" id="name" placeholder="name" name="name" required="required"
					   value="${items.name}"
					   onblur="validateName('${pageContext.request.contextPath}/items?code=validate')">
				<span class="nameMsg"></span>
			</div>
			<div class="form-group">
				<label for="detail">商品描述</label>
				<input type="text" class="form" id="detail" placeholder="desc" name="detail"
					   value="${items.detail}">
			</div>
			<div class="form-group">
				<label for="price">商品价格</label>
				<input type="text" class="form" id="price" placeholder="price" name="price" required="required"
					   value="${items.price}">
			</div>
			<div class="form-group">
				<label for="pic">商品图片</label>
				<img id="pic" name="pic" src="${items.pic}" width="100px" height="auto"/>
				<input type="file" class="form" id="file" name="file" onchange="showPreview(this)">
			</div>
			<div class="form-group">
				<label for="createtime">生产日期</label>
				<input type="text" class="form Wdate" id="createtime" placeholder="createtime" name="createtime"
					   value="${items.createtime}"
					   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
			</div>
			<button type="button" class="btn btn-success" onclick="addServlet('${pageContext.request.contextPath}/items?code=add')">提交</button>
		</form>
	</div>
</body>
<script type="text/javascript">
	//将文件流以url形式读取，实现图片实时显示：
	function showPreview(source){
		var file = source.files[0];
		if(window.FileReader){
			var fr = new FileReader();
			fr.onloadend = function(e){
				document.getElementById("pic").src=e.target.result;
			}
			fr.readAsDataURL(file);
		}
	}
</script>
</html>
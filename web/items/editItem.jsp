<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改商品信息</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="margin-top: 100px">
	<h2 class="form-group">修改商品</h2>
	<form id="f" action="" method="post" enctype="multipart/form-data">
		<div class="form-group" hidden="hidden">
			<label for="id">商品id</label>
			<input type="text" class="form-control" id="id" placeholder="id" name="id">
		</div>
		<div class="form-group">
			<label for="name">商品名称</label>
			<input type="text" class="form-control" id="name" placeholder="name" name="name" required="required">
		</div>
		<div class="form-group">
			<label for="detail">商品描述</label>
			<input type="text" class="form-control" id="detail" placeholder="desc" name="detail">
		</div>
		<div class="form-group">
			<label for="price">商品价格</label>
			<input type="text" class="form-control" id="price" placeholder="price" name="price" required="required">
		</div>
		<div class="form-group">
			<label for="pic">商品图片</label>
			<img id="pic" name="pic" width="100" height="100" />
			<input type="file" class="form-control" id="file" placeholder="file" name="file" onchange="showPreview(this)">
		</div>
		<div class="form-group">
			<label for="createtime">生产日期</label>
			<input type="date" class="form-control" id="createtime" placeholder="createtime" name="createtime">
		</div>
		<button type="submit" class="btn btn-success">提交</button>
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
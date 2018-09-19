<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script type="text/JavaScript"
	src="static/js/jquery/jquery-3.3.1.min.js" /></script>
<script type="text/javascript">
	function exportData() {
		var arr = new Array();
		location.href = "hello/get?name=" + $("#name").val() + "&password="
				+ $("#password").val();
		//这里不能用ajax请求，ajax请求无法弹出下载保存对话框
	}
</script>
</head>
<body>
<form action="">
		姓名：<input type="text" id="username"><br> 密码：<input
			type="text" id="password"><br> <select id="status"
			value="${status} }">
			<option value="">请选择</option>
			<option value="">等待</option>
			<option value="">启动</option>
			<option value="">运行</option>
		</select>
		<button type="reset">重置1</button>
		<button type="button">重置2</button>
		<button type="submit">提交</button>
	</form>
	返回值
	<input type="text" value="${name}">
	<!-- 	<h2>Hello World!</h2> -->
	<!-- 	姓名:<input type="text" id="name"><br> -->
	<!-- 	密码:<input type="text" id="password"><br> -->
	<!-- 	<button id="export" type="button" class="btn btn-primary" -->
	<!-- 		onclick="exportData()">导出Excel</button> -->
</body>
</html>
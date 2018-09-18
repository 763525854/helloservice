<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script type="text/JavaScript" src="static/js/jquery/jquery-3.3.1.min.js" /></script>
<script type="text/javascript">
	function exportData() {
		var arr=new Array();
		location.href = "hello/get?name="+$("#name").val()+"&password="+$("#password").val();
		//这里不能用ajax请求，ajax请求无法弹出下载保存对话框
	}
</script>
</head>
<body>
	<h2>Hello World!</h2>
	姓名:<input type="text" id="name"><br>
	密码:<input type="text" id="password"><br>
	<button id="export" type="button" class="btn btn-primary"
		onclick="exportData()">导出Excel</button>
</body>
</html>

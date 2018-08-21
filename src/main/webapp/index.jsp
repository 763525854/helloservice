<html>
<head>
<title>Insert title here</title>
<script type="text/JavaScript" src="./thirdjs/jquery-3.3.1.min.js" /></script>
<script type="text/javascript">
	function exportData() {
		location.href = "report/export";
		//这里不能用ajax请求，ajax请求无法弹出下载保存对话框
	}
</script>
</head>
<body>
	<h2>Hello World!</h2>
	<button id="export" type="button" class="btn btn-primary"
		onclick="exportData()">导出Excel</button>
</body>
</html>

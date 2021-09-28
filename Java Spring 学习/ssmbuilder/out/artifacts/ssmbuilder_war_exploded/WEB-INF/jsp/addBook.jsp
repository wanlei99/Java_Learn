<%--
  Created by IntelliJ IDEA.
  User: 98710
  Date: 2021/9/24
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书本</title>
</head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        <div class="form-group">
            书籍名称：<input type="text" name="bookName"><br><br><br>
            书籍数量：<input type="text" name="bookCounts"><br><br><br>
            书籍详情：<input type="text" name="detail"><br><br><br>
            <input type="submit" value="添加">
        </div>
    </form>
</div>
</body>
</html>

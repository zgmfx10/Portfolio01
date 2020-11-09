<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>会員登録</title>
        <link rel = "stylesheet" href = "<c:url value = '/css/reset.css' />">
        <link rel = "stylesheet" href = "<c:url value = '/css/style.css' />">
    </head>
    <body>
        <div id = "wrapper">
            <div id = "header">
                <h1>目標会員数１０００人！！</h1>
            </div>
            <div id = "content">
                ${param.content}
            </div>
            <div id = "footer">
                　担当 000
            </div>
        </div>
    </body>
</html>
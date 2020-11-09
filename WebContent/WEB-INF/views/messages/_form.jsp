<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test = "${errors != null}">
    <div id = "flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var = "error" items = "${errors}">
            ・<c:out value = "${error}" /><br />
        </c:forEach>
    </div>
</c:if>

<label for="name">お名前</label><br />
<input type="text" name="name" value="${message.name}" />
<br /><br />

<label for="hurigana">ふりがな</label><br />
<input type="text" name="hurigana" value="${message.hurigana}" />
<br /><br />

<label for="hurigana">お電話番号</label><br />
<input type="tel" name="phone" value="${message.phone}" />
<br /><br />

<label for="mail">メールアドレス</label><br />
<input type="email" name="mail" value="${message.mail}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
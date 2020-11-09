<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<c:import url = "../layout/app.jsp">
    <c:param name = "content">
        <c:choose>
            <c:when test = "${message != null}">
                <h2>会員No : ${message.id}の詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>お名前</th>
                            <td><c:out value = "${message.name}" /></td>
                        </tr>
                        <tr>
                            <th>ふりがな</th>
                            <td><c:out value = "${message.hurigana}" /></td>
                        </tr>
                        <tr>
                            <th>お電話番号</th>
                            <td><c:out value = "${message.phone}" /></td>
                        </tr>
                        <tr>
                            <th>メールアドレス</th>
                            <td><c:out value = "${message.mail}" /></td>
                        </tr>
                        <tr>
                            <th>会員作成日時</th>
                            <td><fmt:formatDate value= "${message.created_at}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                        </tr>
                        <tr>
                            <th>会員更新日時</th>
                            <td><fmt:formatDate value= "${message.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                        </tr>
                    </tbody>
                </table>

                <p><a href = "${pageContext.request.contextPath}/index">一覧に戻る</a></p>
                <p><a href = "${pageContext.request.contextPath}/edit?id=${message.id}">編集する</a></p>

            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
    </c:param>
</c:import>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>test</title>
</head>
<body>
    <table>
        <c:forEach items="${userList}" var="userInfo">
            <tr>
                <td>姓名：</td>
                <td>${userInfo.userName}</td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td>${userInfo.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

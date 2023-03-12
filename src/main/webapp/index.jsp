<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<html>
<head>

<title>Файлы</title>
Today's date:
<%=(new java.util.Date()).toLocaleString()%>
</head>
<h1>${path}</h1>
<body>

    <table>
         <thead>
             <tr>
                <th>Файл</th>
                <th>Размер</th>
                <th>Дата</th>
                <th></th>
             </tr>
         </thead>

            <form method="get" action="/files">
            <button name="btn" type="submit" value=" "> Вверх </button>
            </form>
            <c:forEach var= "item" items= "${files}">
                <tr>
                    <td>
                        <form method="get" action="/files">
                        <button name="btn" type="submit" value="${item.getAbsolutePath()}">${item.getName()}</button>
                        </form>
                    </td>
                    <td>${item.length()}</td>
                    <td>${Date(item.lastModified())}</td>
                    <td>
                        <c:if test="${item.isFile()}">
                            <form method="post" action="/download">
                                <button name="btn" type="submit" value="${item.getAbsolutePath()}"> Скачать </button>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
    </table>
</body>
</html>
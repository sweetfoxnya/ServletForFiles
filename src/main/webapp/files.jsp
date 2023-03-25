<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<html>
<head>

<title>Файлы</title>
Today's date:
<%=(new java.util.Date()).toLocaleString()%>
</head>

<form name = "form1" method = "get" action = "/logout">
           <input type = "submit" value = "Logout">
</form>
<form method="post" action="/files">
            <button name="btnExit" type="submit" value=" "> Up </button>
            </form>
<h1>${path}</h1>
<body>

    <table>
         <thead>
             <tr>
                <th>Files</th>
                <th>Size</th>
                <th>Date</th>
                <th></th>
             </tr>
         </thead>

            <c:forEach var= "item" items= "${files}">
                <tr>
                    <td>
                        <form method="post" action="/files">
                        <button name="btnName" type="submit" value="${item.getAbsolutePath()}">${item.getName()}</button>
                        </form>
                    </td>
                    <td>${item.length()}</td>
                    <td>${Date(item.lastModified())}</td>
                    <td>
                        <c:if test="${item.isFile()}">
                            <form method="post" action="/download">
                                <button name="btnDown" type="submit" value="${item.getAbsolutePath()}"> Download </button>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
    </table>
</body>
</html>
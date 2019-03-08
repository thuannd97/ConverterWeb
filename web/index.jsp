<%--
    Document   : index
    Created on : Mar 3, 2019, 9:53:07 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body  bgcolor="white">
        <h1><b><center> Temperature Converter </center></b></h1>
        <hr>
        <p>Enter a degree to convert:</p>
        <form method="post" action="/ConverterWeb/convert">
            <input type="text" name="degree" size="35" required="enter degree">
            <br>
            <input type="submit" name="fToC" value="Fahrenheit to Centigrade">
            <input type="submit" name="cToF" value="Centigrade to Fahrenheit">
        </form>
        <c:if test="${not empty fToC}">
            <p>F to C:<c:out value="${fToC}"/></p>
        </c:if>
        <c:if test="${not empty cToF}">
            <p>C to F:<c:out value="${cToF}"/></p>
        </c:if>
    </body>
</html>

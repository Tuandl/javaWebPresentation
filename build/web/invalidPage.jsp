<%-- 
    Document   : invalidPage
    Created on : Jul 1, 2017, 12:03:08 PM
    Author     : TUANDASE62310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Page</title>
    </head>
    <body>
        <h1>ERROR!</h1>
        <p style="color: red;"><s:property value="%{#request.error}"/></p>
        <p>Click <a href="index.jsp">here</a> to try again</p>
    </body>
</html>

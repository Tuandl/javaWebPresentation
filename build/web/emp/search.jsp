<%-- 
    Document   : search
    Created on : Jul 1, 2017, 12:08:06 PM
    Author     : TUANDASE62310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h1>Search Surgery Record</h1>
        <s:url action="logoutAction" var="logout"></s:url>
        <h4>Welcome <s:property value="#session.name"/> <small><a href="${logout}">logout</a></small></h4>
        <%--<s:form action="searchSurgeryRecordAction" method="POST">--%>
        <%--<s:textfield name="searchValue" value="%{searchValue}" label="Patient Name"/>--%>
        <%--<s:submit value="Search" name="action"/>--%>
        <%--<s:submit value="Reset" name="action"/>--%>
        <%--</s:form>--%>
        <form action="/Presentation/searchSurgeryRecordAction.action" method="POST">
            Patient Name: <input type="text" name="searchValue" id="searchSurgeryRecordAction_searchValue"
                                 value="${param.searchValue}"/><br/>
            <input type="submit" name="action" value="Search"/>
            <input type="submit" name="action" value="Reset"/>
        </form>

        <a href="/Presentation/emp/insertPatient.jsp">Insert Patient</a><br/>
        <a href="/Presentation/emp/insertReport.jsp">Insert Surgery Information</a>
    </body>
</html>

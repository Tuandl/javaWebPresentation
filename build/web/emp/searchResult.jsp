<%-- 
    Document   : searchResult
    Created on : Jul 1, 2017, 4:09:09 PM
    Author     : TUANDASE62310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Surgery Records</title>
    </head>
    <body>
        <h1>Search Result</h1>
        <s:url action="logoutAction" var="logout"></s:url>
        <h4>Welcome <s:property value="#session.name"/> <small><a href="${logout}">logout</a></small></h4>
        <s:if test="%{result != null && result.size() > 0}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Patient ID</th>
                        <th>Patient Name</th>
                        <th>Surgery Name</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="%{result}" status="count">
                        <tr>
                            <td><s:property value="#count.count"/></td>
                            <td><s:property value="patient.username"/></td>
                            <td><s:property value="patient.name"/></td>
                            <td><s:property value="surgeryName"/></td>
                            <td>
                                <%--<s:property value="reportID"/>--%>
                                <s:url action="selectSurgeryToUpdateAction" var="url"/>
                                <form action="${url}" method="get">
                                    <input type="hidden" name="reportID" value="${reportID}"/>
                                    <input type="hidden" name="searchValue" value="${searchValue}"/>
                                    <input type="submit" value="Update"/>
                                </form>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:else>
            <h4 style="color: firebrick">Not Found!!</h4>
        </s:else>
        <p style="color: red;">${request.noti}</p>
        <a href="emp/search.jsp?searchValue=${searchValue}"><button>Back</button></a>
    </body>
</html>

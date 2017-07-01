<%-- 
    Document   : insertReport
    Created on : Jul 1, 2017, 6:54:31 PM
    Author     : TUANDASE62310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
    </head>
    <body>
        <h1>Insert Surgery Information</h1>
        <s:url action="logoutAction" var="logout"></s:url>
        <h4>Welcome <s:property value="#session.name"/> <small><a href="${logout}">logout</a></small></h4>
        <s:form action="insertReportAction" method="post">
            <s:textfield name="reportID" label="Surgery Record ID"/>
            <s:textfield name="processOfSurgery" label="Process Of Surgery"/>
            <s:date var="formatedTimeStart" format="yyyy-MM-dd'T'HH:mm" name="timeStart"/>
            <s:textfield type="datetime-local" name="timeStart" value="%{#formatedTimeStart}" label="Time Start"/>
            <s:date var="formatedTimeEnd" format="yyyy-MM-dd'T'HH:mm" name="timeEnd"/>
            <s:textfield type="datetime-local" name="timeEnd" value="%{#formatedTimeEnd}" label="Time End"/>
            <s:textfield name="status" label="Status"/>
            <s:textfield name="patientUsername" label="Patient ID"/>
            <s:textfield name="surgeryName" label="Surgery Name"/>
            <s:textfield name="operatedDoctor" label="Operated Doctor"/>
            <s:textfield name="anesthesiologist" label="Anesthesiologist"/>
            <s:submit value="Insert"/>
        </s:form>
        <a href="search.jsp"><button>Back</button></a>
        <p style="color: green">${success}</p>
        <p style="color: red">${fail}</p>
    </body>
</html>

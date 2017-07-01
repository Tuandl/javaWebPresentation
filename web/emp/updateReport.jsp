<%-- 
    Document   : updateReport
    Created on : Jul 1, 2017, 5:00:57 PM
    Author     : TUANDASE62310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Surgery Information</title>
    </head>
    <body>
        <h1>Update</h1>
        <s:url action="logoutAction" var="logout"></s:url>
        <h4>Welcome <s:property value="#session.name"/> <small><a href="${logout}">logout</a></small></h4>
        <s:form action="updateReportAction" method="post">
            <s:textfield name="patientID" value="%{report.patient.username}" label="Patient ID"/>
            <s:textfield name="patientName" value="%{report.patient.name}" label="Patient Name"/>
            <s:date var="formatedDOB" format="yyyy-MM-dd" name="report.patient.DOB"/>
            <s:textfield type="date" name="DOB" label="Date of birth" value="%{#formatedDOB}"/>
            <s:checkbox name="isMale" label="Is Male" value="%{report.patient.isMale}"/>
            <s:textfield name="surgeryName" label="Surgery Name" value="%{report.surgeryName}"/>
            <s:textfield name="operatedDoctor" label="Doctor Operated ID" value="%{report.operatedDoctor}"/>
            <s:textfield name="anesthesiologist" label="Anesthesiologist ID" value="%{report.anesthesiologist}"/>
            <s:date var="formatedTimeStart" format="yyyy-MM-dd'T'HH:mm" name="%{report.timeStart}"/>
            <s:textfield type="datetime-local" name="timeStart" value="%{#formatedTimeStart}" label="Time start"/>
            <s:date var="formatedTimeEnd" format="yyyy-MM-dd'T'HH:mm" name="%{report.timeEnd}"/>
            <s:textfield type="datetime-local" name="timeEnd" value="%{#formatedTimeEnd}" label="Time end"/>
            <s:textfield name="processOfSurgery" label="Process of Surgery" value="%{report.processOfSurgery}"/>
            <s:textfield type="hidden" name="searchValue" value="%{searchValue}"/>
            <s:textfield type="hidden" name="reportID" value="%{reportID}"/>
            <s:submit name="action" value="Update"/>
            <s:submit name="action" value="Back"/>
        </s:form>
        <p style="color: red;">${request.error}</p>
        <p style="color: green;">${request.noti}</p>
    </body>
</html>

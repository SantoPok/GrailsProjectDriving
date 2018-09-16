<%@ page import="owngrailsprj.Instructor; owngrailsprj.Trainee" %>
<html>
<html>
<head>
    <meta name="layout" content="ownLayout"/>
    <title>L Turn Driving School</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome to <b>"Learners' Turn Driving School (LTDS)"</b></h1>
        <hr/>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <hr/>
        <p> As of last update, there are ${traineeTotal} trainees and ${instructorTotal} instructor in the database.</p>
        <hr/>
        <h3><b>Trainee List</b></h3>
        <ul>
            <g:each in="${Trainee.list()}" var="trainee">
                <li>
                    <g:link controller="trainee" action="show" id="${trainee.id}">
                        ${trainee.name} - ${trainee.startDate} ${trainee.trainingType} ${trainee.timeOfTheDay}
                    </g:link>
                </li>
            </g:each>
        </ul>
        <hr/>
        <h3><b>Instructor List</b></h3>
        <ul>
            <g:each in="${Instructor.list()}" var="instructor">
                <li>
                    <g:link controller="instructor" action="show" id="${instructor.id}">
                        ${instructor.name} - ${instructor.jobType} Assigned Trianees: ${instructor.trainees}
                    </g:link>
                </li>
            </g:each>
        </ul>
        <hr/>
    </section>
</div>

</body>
</html>
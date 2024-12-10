<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
     	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>to do</title>
</head>
<body>

<!--For Page-->
<div class="page">
    <!--Card-->
    <div class="card">
        <!--Card Header-->
        <div class="card-header">
            <p> <i class="fa fa-bars"></i> <i class="fa fa-calendar ml-4" aria-hidden="true"></i> <i class="fa fa-star ml-4" aria-hidden="true"></i> <span class="float-right"> <span class="mr-4 navTask">Task</span> <span class="mr-4">Archive</span> <i class="fa fa-search" aria-hidden="true"></i> </span> </p>
        </div>
        <!--Card Body-->
        <div class="card-body">
            <p class="heading1"> <span class="today">Today</span> <span class="float-right headingright">7h 15min</span> </p>
            <p> <i class="fa fa-calendar mr-2" aria-hidden="true"></i> <span class="task mt-4">Take kids to school</span> <span class="time ml-2">8:00-8:30AM</span> <span class="float-right">30min</span> </p>
            <p><i class="	fa fa-circle-thin mr-2"></i> <span class="task">Process email</span> <i class="fa fa-thumb-tack ml-2" aria-hidden="true"></i> <span class="time ml-2">8:00-9:30AM</span><span class="float-right">1h</span> </p>
            <p><i class="fa fa-calendar mr-2" aria-hidden="true"></i> <span class="task">Daily Stand-Up meeting</span> <span class="time ml-2">9:00-10:00AM</span> <span class="float-right">30min</span> </p>
            <p><i class="	fa fa-circle-thin mr-2"></i><span class="task">Create new templates</span> <i class="fa fa-thumb-tack ml-2" aria-hidden="true"></i> <i class="fa fa-user ml-2"></i> <span class="time ml-2">10:00-11:45AM</span> <span class="float-right">1h 45min</span> </p>
            <p><i class="fa fa-calendar mr-2" aria-hidden="true"></i> <span class="task">Lunch with Anna</span> <span class="time ml-2">12:00-12:30PM</span> <span class="float-right">30min</span> </p>
            <p class="text-muted"><i class="fa fa-plus mr-1" aria-hidden="true"></i> Add Task for Today</p>
            <p class="heading2"><span class="tomorrow">Tomorrow</span> <span class="float-right headingright">6h 30min</span> </p>
            <p class="task2 mt-4"><i class="fa fa-calendar mr-2" aria-hidden="true"></i> <span class="task">Breakfast with the Marketing team</span> <span class="time ml-2">8:00-8:30AM</span> <span class="float-right">30min</span></p>
        </div>
    </div>
</div>



</body>
</html>
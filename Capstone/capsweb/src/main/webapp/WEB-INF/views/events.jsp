<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>

<c:if test="${empty loggedInUser}">
    <%response.sendRedirect("login");%>
</c:if>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Events</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <!-- css -->
    <link href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700" rel="stylesheet">
    <link href="static/css/bootstrap.css" rel="stylesheet" />
    <link href="static/css/bootstrap-responsive.css" rel="stylesheet" />
    <link href="static/css/fancybox/jquery.fancybox.css" rel="stylesheet">
    <link href="static/css/jcarousel.css" rel="stylesheet" />
    <link href="static/css/flexslider.css" rel="stylesheet" />
    <link href="static/css/style.css" rel="stylesheet" />
    <!-- Theme skin -->
    <link href="static/skins/blue.css" rel="stylesheet" />
    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png" />
    <link rel="shortcut icon" href="static/ico/favicon.png" />

    <style type="text/css">
        img {
            border-radius: 50%;
        }
    </style>
</head>


<!-- end toggle top area -->
<!-- start header -->
<jsp:include page="header.jsp"/>
<!-- end header -->
<section id="inner-headline">
    <div class="container">
        <div class="row">
            <div class="span4">
                <div class="inner-heading">
                    <h2>Events</h2>
                </div>
            </div>
            <div class="span8">
                <ul class="breadcrumb">
                    <li class="nav-item text-left">
                        <form class="form-search" action="searchevents" method="post">
                            <input name="street" placeholder="Type something" type="text" class="input-medium search-query">
                            <button type="submit" class="btn btn-square btn-theme">Search</button>
                        </form>
                    </li>
                    <li><a href="#"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
                    <li><a href="index">Home</a><i class="icon-angle-right"></i></li>
                    <li class="active">Events</li>
                </ul>
            </div>
        </div>
    </div>
</section>
<section id="content">
    <div class="container">
        <!-- Default table -->
        <div class="row">
            <div class="span12">
              <h1>
                  <button class="btn-blue btn-rounded" onclick='myFunction();'><h4>My Events</h4></button>
              ${good}
                  ${success}
                    ${lob}
                  <button class="btn-blue btn-rounded" onclick="myFunction2()"><h4>Joined Events (${userEvents.size()})</h4></button>
                ${good}
                ${lob}
                    ${atend}
                    ${aeo}
                <button class="btn-blue btn-rounded" onclick="myFunction3()"><h4>All Events</h4></button>
                    ${good}
                    ${lob}

                </h1>
                <table id="1" style="display: none"  class="table table-striped">
                    <thead>
                    <tr>

                        <th>#</th>
                        <th>Event</th>
                        <th>
                            <input type="text" id="searchnow"
                                   placeholder=" Filter Events (${events.size()}) "
                                   class="form-control"  >
                        </th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${events}" >
                        <c:if test="${loggedInUser.email == item.user_email}">
                        <tr>

                            <td>
                                    ${events.indexOf(item)+1}.
                            </td>

                            <td>
                               ${item.street}<br> ${item.state}<br>
                                 ${item.zipcode}<br>${item.time}

                            </td>
                            <td>
                                  Created by ${item.user_email}
                            </td>
                            <td>
                             <a href="http://maps.google.com/maps?q=${item.street},+${item.state},+${item.zipcode}" target="_blank">
                                Get directions</a>
                            </td>

                                <td><a href="deleteevent?id=${item.id}" onclick="confirmed(); return false;" ><i class="icon-trash">Delete</i></a></td>
                                <td><a href="updateevent?id=${item.id}" ><i class="icon-pencil">Update</i></a></td>


                        </tr>
                        </c:if>
                    </c:forEach>

                    </tbody>
                </table>

                <table id="2" style="display: none" class="table table-striped">
                    <thead>
                    <tr>

                        <th>#</th>
                        <th>Event</th>
                        <th>
                            <input type="text" id="searchnow"
                                   placeholder=" Filter Events (${events.size()}) "
                                   class="form-control"  >
                        </th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${userEvents}" >

                            <tr>

                                <td>
                                        ${userEvents.indexOf(item)+1}.
                                </td>

                                <td>
                                        ${item.street}<br> ${item.state}<br>
                                        ${item.zipcode}<br>${item.time}

                                </td>
                                <td>
                                    Created by ${item.user_email}
                                </td>
                                <td>
                                    <a href="http://maps.google.com/maps?q=${item.street},+${item.state},+${item.zipcode}" target="_blank">
                                        Get directions</a>
                                </td>
                                <c:if test="${userEvents.contains(item)}">
                                    <td><form action="removeUser" method="post" class="form-horizontal">


                                        <input type="hidden" name="event_id" value ="${item.id}"/>
                                        <button type="submit" >Leave the event</button>
                                    </form>
                                    </td>


                                </c:if>

                            </tr>

                    </c:forEach>

                    </tbody>
                </table>

                <table id="3" style="display: none" class="table table-striped">
                    <thead>
                    <tr>

                        <th>#</th>
                        <th>Event</th>
                        <th>Total Atendies</th>
                        <th>
                            <input type="text" id="searchnow"
                                   placeholder=" Filter Events (${events.size()}) "
                                   class="form-control"  >
                        </th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${events}" >
                        <c:if test="${loggedInUser.email != item.user_email&&!userEvents.contains(item)}">
                            <tr>

                                <td>
                                        ${events.indexOf(item)+1}.
                                </td>

                                <td>
                                        ${item.street}<br> ${item.state}<br>
                                        ${item.zipcode}<br>${item.time}

                                </td>
                        <td>
                            ${item.eventUsers.size()}
                        </td>
                                <td>
                                    Created by ${item.user_email}
                                </td>
                                <td>
                                    <a href="http://maps.google.com/maps?q=${item.street},+${item.state},+${item.zipcode}" target="_blank">
                                        Get directions</a>
                                </td>
                        <c:if test="${loggedInUser.email == item.user_email}">
                            <td><a href="deleteevent?id=${item.id}" onclick="confirmed(); return false;" ><i class="icon-trash">Delete</i></a></td>
                            <td><a href="updateevent?id=${item.id}" ><i class="icon-pencil">Update</i></a></td>

                            </tr>
                        </c:if>
                        <c:if test="${!userEvents.contains(item)&& loggedInUser.email!=item.user_email}">
                           <td><form action="addUser" method="post" class="form-horizontal">

                            <input type="hidden" name="event_id" value ="${item.id}"/>
                            <button type="submit" >Join Here</button>
                            </form>
                           </td>
                        </c:if>

                            <c:if test="${userEvents.contains(item)}">
                            <td><form action="removeUser" method="post" class="form-horizontal">


                                <input type="hidden" name="event_id" value ="${item.id}"/>
                                <button type="submit" >Leave the event</button>
                            </form>
                            </td>


                        </c:if>


                        </c:if>
                    </c:forEach>


                    </tbody>
                </table>

            </div>

        </div>

        <!-- divider -->
        <div class="row">
            <div class="span12">
                <div class="solidline">
                </div>
            </div>
        </div>


    </div>
</section>


</div>
<jsp:include page="footer.jsp"/>
<a href="#" class="scrollup"><i class="icon-chevron-up icon-square icon-32 active"></i></a>
<!-- javascript
  ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="static/js/jquery.js"></script>
<script src="static/js/jquery.easing.1.3.js"></script>
<script src="static/js/bootstrap.js"></script>
<script src="static/js/jcarousel/jquery.jcarousel.min.js"></script>
<script src="static/js/jquery.fancybox.pack.js"></script>
<script src="static/js/jquery.fancybox-media.js"></script>
<script src="static/js/google-code-prettify/prettify.js"></script>
<script src="static/js/portfolio/jquery.quicksand.js"></script>
<script src="static/js/portfolio/setting.js"></script>
<script src="static/js/jquery.flexslider.js"></script>
<script src="static/js/jquery.nivo.slider.js"></script>
<script src="static/js/modernizr.custom.js"></script>
<script src="static/js/jquery.ba-cond.min.js"></script>
<script src="static/js/jquery.slitslider.js"></script>
<script src="static/js/animate.js"></script>

<!-- Template Custom JavaScript File -->
<script src="static/js/custom.js"></script>

<script>
    function confirmed(){
        if (confirm('You are about to delete, Do you want to proceed?')) {
            document.getElementById("del").submit();
            return true;
        } else {
            return false;
        }
    }
    function myFunction() {
        var x = document.getElementById("1");

        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
    function myFunction2() {
        var x = document.getElementById("2");

        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
    function myFunction3() {
        var x = document.getElementById("3");

        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }


    $("#searchnow").keyup(function () {
        var value = this.value.toLowerCase().trim();

        $("table tr").each(function (index) {
            if (!index) return;
            $(this).find("td").each(function () {
                var id = $(this).text().toLowerCase().trim();
                var not_found = (id.indexOf(value) == -1);
                $(this).closest('tr').toggle(!not_found);
                return not_found;
            });
        });
    });
</script>

</body>

</html>

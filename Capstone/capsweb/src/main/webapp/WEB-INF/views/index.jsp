<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>RunningPal</title>
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
    <link href="static/css/overwrite.css" rel="stylesheet" />
  <!-- Theme skin -->
  <link href="static/skins/blue.css" rel="stylesheet" />
  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png" />
  <link rel="shortcut icon" href="ico/favicon.png" />


</head>

<body>

    <!-- end toggle top area -->
    <!-- start header -->
    <jsp:include page="header.jsp"/>
    <!-- end header -->
    <section id="featured">
      <!-- start slider -->
      <!-- Slider -->
      <div id="nivo-slider">
        <div class="nivo-slider">
          <!-- Slide #1 image -->
          <img src="static/img/slides/nivo/bg-1.jpg" style="height: 500px" alt="" title="#caption-1" />
          <!-- Slide #2 image -->
          <img src="static/img/slides/nivo/bg-2.jpg" style="height: 500px" alt="" title="#caption-2" />
<%--          <!-- Slide #3 image -->--%>
<%--          <img src="static/img/slides/nivo/bg-3.jpg" alt="" title="#caption-3" />--%>
        </div>
        <div class="container">
          <div class="row">
            <div class="span12">
              <!-- Slide #1 caption -->
              <div class="nivo-caption" id="caption-1">
                <div>
                  <h2>Awesome <strong>people</strong></h2>
                  <p>
                  Lots of interesting and fun people are posting there future work-outs in our platform
                  </p>
                  <a href="#" class="btn btn-theme">Join Here</a>
                </div>
              </div>
              <!-- Slide #2 caption -->
<%--              <div class="nivo-caption" id="caption-2">--%>
<%--                <div>--%>
<%--                  <h2>Easy <strong>to use</strong></h2>--%>
<%--                  <p>--%>
<%--                    Super easy to use platform but if you have any questions--%>
<%--                  </p>--%>
<%--                  <a href="#" class="btn btn-theme">Contact us Here</a>--%>
<%--                </div>--%>
<%--              </div>--%>

            </div>
          </div>
        </div>
      </div>
      <!-- end slider -->

    </section>

<%--    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d199412.48685355642!2d-90.38389012911428!3d38.65301650803532!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x87d8b4a9faed8ef9%3A0xbe39eaca22bbe05b!2sSt.%20Louis%2C%20MO!5e0!3m2!1sen!2sus!4v1580771396180!5m2!1sen!2sus" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe>--%>
<%--   --%>

    <section class="callaction">
      <div class="container">
        <div class="row">
          <div class="span12">
            <div class="big-cta">
              <div class="cta-text">
                <h3>We've worked-out <span class="highlight"><strong>83 times</strong></span> this year! Lets grow together!</h3>
              </div>
              <div class="cta floatright">

<a class="btn btn-large btn-blue btn-rounded" href="register">Sign Up here</a>


        <!-- divider -->
        <div class="row">
          <div class="span12">
            <div class="solidline">
            </div>
          </div>
      </div>
        <!-- end divider -->
        <!-- Portfolio Projects -->
        <div class="row">
          <div class="span12">
            <h4 class="heading">Some of our <strong>users</strong></h4>
            <div class="row">
              <section id="projects">
                <ul id="thumbs" class="portfolio">
                  <!-- Item Project and Filter Name -->
                  <li class="item-thumbs span3 design" data-id="id-0" data-type="web">
                    <!-- Fancybox - Gallery Enabled - Title - Full Image -->
<%--                    <img class="hover-wrap fancybox" data-fancybox-group="gallery"  href="img/works/full/image-01-full.jpg">--%>

                    <!-- Thumb Image and Description -->
                    <img src="static/img/works/thumbs/image-01.jpg">
                  </li>
                  <!-- End Item Project -->
                  <!-- Item Project and Filter Name -->
                  <li class="item-thumbs span3 design" data-id="id-1" data-type="icon">
                    <!-- Fancybox - Gallery Enabled - Title - Full Image -->

                    <!-- Thumb Image and Description -->
                    <img src="static/img/works/thumbs/image-02.jpg" >
                  </li>
                  <!-- End Item Project -->
                  <!-- Item Project and Filter Name -->
                  <li class="item-thumbs span3 photography" data-id="id-2" data-type="illustrator">
                    <!-- Fancybox - Gallery Enabled - Title - Full Image -->

                    <!-- Thumb Image and Description -->
                    <img src="static/img/works/thumbs/image-03.jpg" style="height: 405px" >
                  </li>

                  <!-- End Item Project -->
                  <!-- Item Project and Filter Name -->
                  <li class="item-thumbs span3 photography" data-id="id-1" data-type="illustrator">
                    <!-- Fancybox - Gallery Enabled - Title - Full Image -->

                    <!-- Thumb Image and Description -->
                    <img src="static/img/works/thumbs/image-04.jpg"  style="height: 405px">
                  </li>
                  <!-- End Item Project -->
                  <!-- Item Project and Filter Name -->

                  <!-- End Item Project -->
                  <!-- Item Project and Filter Name -->

                  <!-- End Item Project -->
                  <!-- Item Project and Filter Name -->

                  <!-- End Item Project -->
                  <!-- Item Project and Filter Name -->

                  <!-- End Item Project -->
                </ul>
              </section>
            </div>
          </div>
        </div>
        <!-- End Portfolio Projects -->
        <!-- divider -->
        <div class="row">
          <div class="span12">
            <div class="solidline">
            </div>
          </div>
        </div>
        <!-- end divider -->
        <div class="row">
          <div class="span12">
            <h4>Places of prior  <strong>events</strong></h4>
            <ul id="mycarousel" class="jcarousel-skin-tango recent-jcarousel clients">
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client1.png"  class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client2.png" class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client3.png" class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client4.png" class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client5.png" class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client6.png" class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client1.png" class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client2.png" class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client3.png" class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client4.png" class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client5.png" class="client-logo" alt="" />
					</a>
              </li>
              <li>
                <a href="#">
					<img src="static/img/dummies/clients/client6.png" class="client-logo" alt="" />
					</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    <section id="bottom">
      <div class="container">
        <div class="row">
          <div class="span12">
            <div class="aligncenter">
              <div id="twitter-wrapper">
                <div id="twitter">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <jsp:include page="footer.jsp"/>

  <a href="#" class="scrollup" style="color:green;"><i class="icon-chevron-up icon-square  icon-32 active"></i></a>
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

</body>
</html>

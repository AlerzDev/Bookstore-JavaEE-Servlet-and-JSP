<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="./assets/client/img/apple-icon.png">
  <link rel="icon" type="image/png" href="./assets/client/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Bookstore
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="${pageContext.request.contextPath}/client/assets/css/material-kit.css?v=2.0.4" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="${pageContext.request.contextPath}/client/assets/demo/demo.css" rel="stylesheet" />
</head>
<body class="index-page sidebar-collapse">
<nav class="navbar navbar-transparent navbar-color-on-scroll fixed-top navbar-expand-lg" color-on-scroll="100" id="sectionsNav">
  <div class="container">
    <div class="navbar-translate">
      <a class="navbar-brand" href="https://demos.creative-tim.com/material-kit/index.html">Bookstore</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="sr-only">Toggle navigation</span>
        <span class="navbar-toggler-icon"></span>
        <span class="navbar-toggler-icon"></span>
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav ml-auto">
        <li class="dropdown nav-item">
          <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
            <i class="material-icons">apps</i> Catalogo
          </a>
          <div class="dropdown-menu dropdown-with-icons">
            <a href="./index.html" class="dropdown-item">
              <i class="material-icons">book</i> Libros
            </a>
            <a href="https://demos.creative-tim.com/material-kit/docs/2.0/getting-started/introduction.html" class="dropdown-item">
              <i class="material-icons">chrome_reader_mode</i> Libros electronicos
            </a>
          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./views_client/login.jsp" >
            <i class="material-icons">account_box</i> Mi cuenta
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" rel="tooltip" title="" data-placement="bottom" href="https://twitter.com/CreativeTim" target="_blank" data-original-title="Follow us on Twitter">
            <i class="material-icons">shopping_cart</i>Mi Carrito
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="page-header header-filter clear-filter purple-filter" data-parallax="true" style="background-image: url('${pageContext.request.contextPath}/client/assets/img/books.jpg');">
  <div class="container">
    <div class="row">
      <div class="col-md-8 ml-auto mr-auto">
        <div class="brand">
          <h1>Bookstore</h1>
          <h3>No dejes para mañana lo que puedes leer hoy...</h3>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="main main-raised">
  <div class="section section-basic">
    <div class="container">
      <div class="title">
        <h2>Novedades</h2>
      </div>
      <div class="row">
        <c:forEach items="${booksNews}" var="current">
          <div class="col-md-4">
            <div class="card" style="width: 20rem;">
              <img class="card-img-top" src="https://images.unsplash.com/photo-1517303650219-83c8b1788c4c?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=bd4c162d27ea317ff8c67255e955e3c8&auto=format&fit=crop&w=2691&q=80" alt="Card image cap">
              <div class="card-body">
                <p class="card-text"><strong>Title: </strong>${current.getTitle()}</p>
                <p class="card-text"><strong>Price: </strong>${current.getPrice()}</p>
                <p class="card-text"><strong>Editorial: </strong>${current.getEditorial()}</p>
                <p class="card-text"><strong>ISBN: </strong>${current.getISBN()}</p>
                <div class="row align-content-center">
                  <div class="col-md-6"><button class="btn btn-info" data-toggle="modal" data-target="#myModal">View</button></div>
                  <div class="col-md-6"><button class="btn btn-success">Sale</button></div>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
  <div class="section section-basic">
    <div class="container">
      <div class="title">
        <h2>Promociones</h2>
      </div>
      <div class="row">
        <c:forEach items="${booksOffers}" var="current">
          <div class="col-md-4">
            <div class="card" style="width: 20rem;">
              <img class="card-img-top" src="https://images.unsplash.com/photo-1517303650219-83c8b1788c4c?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=bd4c162d27ea317ff8c67255e955e3c8&auto=format&fit=crop&w=2691&q=80" alt="Card image cap">
              <div class="card-body">
                <p class="card-text"><strong>Title: </strong>${current.getTitle()}</p>
                <p class="card-text"><strong>Price: </strong>${current.getPrice()}</p>
                <p class="card-text"><strong>Editorial: </strong>${current.getEditorial()}</p>
                <p class="card-text"><strong>ISBN: </strong>${current.getISBN()}</p>
                <div class="row align-content-center">
                  <div class="col-md-6"><button class="btn btn-info">View</button></div>
                  <div class="col-md-6"><button class="btn btn-success">Sale</button></div>
                </div>

              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
  <div class="section section-contacts">
    <div class="container">
      <div class="title">
        <h2>Contactanos</h2>
      </div>
      <div class="row">
        <div class="col-md-6">
          <h4 class="text-center description">Divide details about your product or agency work into parts. Write a few lines about each one and contact us about any further collaboration. We will responde get back to you in a couple of hours.</h4>
          <form class="contact-form">
            <div class="row">
              <div class="col-md-6">
                <div class="form-group bmd-form-group">
                  <label class="bmd-label-floating">Your Name</label>
                  <input type="email" class="form-control">
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group bmd-form-group">
                  <label class="bmd-label-floating">Your Email</label>
                  <input type="email" class="form-control">
                </div>
              </div>
            </div>
            <div class="form-group bmd-form-group">
              <label for="exampleMessage" class="bmd-label-floating">Your Message</label>
              <textarea type="email" class="form-control" rows="4" id="exampleMessage"></textarea>
            </div>
            <div class="row">
              <div class="col-md-4 ml-auto mr-auto text-center">
                <button class="btn btn-primary btn-raised">
                  Send Message
                </button>
              </div>
            </div>
          </form>
        </div>
        <div class="col-md-6">
          <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d14888.608696390007!2d-101.61485295321046!3d21.106498471798613!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x842bbe6f8e8cdbf7%3A0xff3c8cc2b5af98fc!2sInstituto+Tecnol%C3%B3gico+de+Le%C3%B3n!5e0!3m2!1ses-419!2smx!4v1537640033576" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
        </div>
      </div>
    </div>
  </div>
</div>
<footer class="footer" data-background-color="black">
  <div class="container">
    <nav class="float-left">
      <ul>

      </ul>
    </nav>
    <div class="copyright float-right">
      &copy;
      <script>
          document.write(new Date().getFullYear())
      </script>, made with <i class="material-icons">favorite</i> by
      <a href="https://www.creative-tim.com" target="_blank">Creative Tim</a> for a better web.
    </div>
  </div>
</footer>
<!--   Core JS Files   -->
<script src="${pageContext.request.contextPath}/client/assets/js/core/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/client/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/client/assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/client/assets/js/plugins/moment.min.js"></script>
<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
<script src="${pageContext.request.contextPath}/client/assets/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="${pageContext.request.contextPath}/client/assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
<!--	Plugin for Sharrre btn -->
<script src="${pageContext.request.contextPath}/client/assets/js/plugins/jquery.sharrre.js" type="text/javascript"></script>
<!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
<script src="${pageContext.request.contextPath}/client/assets/js/material-kit.js?v=2.0.4" type="text/javascript"></script>
<!-- Modal -->
<div class="modal " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        **<!-- Display values here-->**
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
<%@tag description="Layout Client" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="head" fragment="true" %>
<%@attribute name="content_body" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:useBean id="currentSession" class="beans.SessionBean" scope="session"/>
<%
    boolean isLogin;
    int countCar = 0;
    String username = "MI CUENTA";
    try{
        isLogin = currentSession.currentSession() != null;
        if(isLogin){
            username = currentSession.currentSession().getUsername();
            countCar = currentSession.getContents().size();
        }
    }
    catch(Exception ex)
    {
        isLogin = false;
    }
%>
<!doctype html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/client/assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/client/assets/img/apple-icon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
            <jsp:invoke fragment="title"/>
        </title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
        <!-- CSS Files -->
        <link href="${pageContext.request.contextPath}/client/assets/css/material-kit.css?v=2.0.4" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="${pageContext.request.contextPath}/client/assets/demo/demo.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.28.10/sweetalert2.min.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.28.10/sweetalert2.all.min.js"></script>
        <jsp:invoke fragment="head"/>
    </head>
    <body class="profile-page sidebar-collapse">
        <nav class="navbar navbar-transparent navbar-color-on-scroll fixed-top navbar-expand-lg" color-on-scroll="100" id="sectionsNav">
            <div class="container">
                <div class="navbar-translate">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/BookIndexPage">Bookstore</a>
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
                                <c:forEach items="${listFormat}" var="current">
                                    <form id="my_form" method="get" action="${pageContext.request.contextPath}/ListBookPage">
                                        <input type="hidden" name="format" value="${current.getId()}" />
                                        <input type="hidden" name="namePage" value="${current.getDescription()}" />
                                        <a href="javascript:{}" onclick="document.getElementById('my_form').submit();" class="dropdown-item" >
                                            <i class="material-icons">book</i> ${current.getDescription()}
                                        </a >
                                    </form>
                                </c:forEach>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a onclick="validateSession()" class="nav-link" href="#">
                                <i class="material-icons">account_box</i> <%=username%>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a onclick="validateSessionCar()" class="nav-link" rel="tooltip"  data-placement="bottom" href="#"  data-original-title="Ver carrito de compras">
                                <i class="material-icons">shopping_cart</i>Mi Carrito (<%=countCar%>)
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <jsp:invoke fragment="content_body"/>
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
                    <a href="https://www.creative-tim.com" target="_blank">AlexDev</a> for a better web.
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
        <script src="${pageContext.request.contextPath}/js/utils.js" type="text/javascript"></script>
        <script>
            var isLogin = false;
            <c:choose>
                <c:when test="<%=isLogin%>">
                    isLogin = true;
                </c:when>
                <c:otherwise>
                    isLogin = false;
                </c:otherwise>
            </c:choose>
            function validateSession() {
                if(isLogin){
                    window.location.href = "${pageContext.request.contextPath}/Profile";
                }else{
                    window.location.href = "${pageContext.request.contextPath}/LogInLogPageClient";
                }
            }
            function validateSessionCar() {
                if(isLogin){
                    window.location.href = "${pageContext.request.contextPath}/ShoppingCarPage";
                }else{
                    swal(
                        'Error',
                        'Debes iniciar sesion',
                        'error'
                    );
                }
            }
        </script>
        <jsp:invoke fragment="footer"/>
    </body>
</html>
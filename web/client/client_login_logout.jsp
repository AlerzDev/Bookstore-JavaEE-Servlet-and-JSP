<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:layout_client>
    <jsp:attribute name="title">BookStore LogIn</jsp:attribute>
    <jsp:attribute name="content_body">
        <div class="page-header header-filter clear-filter purple-filter" data-parallax="true" style="background-image: url('${pageContext.request.contextPath}/client/assets/img/books.jpg');">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 ml-auto mr-auto">
                        <div class="brand text-center">
                            <h1>Bookstore</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="main main-raised">
            <div class="section section-basic">
                <div class="profile-content">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-6 ml-auto mr-auto">
                                <div class="card card-login">
                                    <form class="form" id="new-session">
                                        <div class="card-header card-header-primary text-center">
                                            <h4 class="card-title">Iniciar sesion</h4>
                                        </div>
                                        <div class="card-body" style="margin-top: 100px">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                <span class="input-group-text">
                                                  <i class="material-icons">face</i>
                                                </span>
                                                </div>
                                                <input type="text" class="form-control" name="Username"  placeholder="Nombre de usuario">
                                            </div>

                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                <span class="input-group-text">
                                                  <i class="material-icons">lock_outline</i>
                                                </span>
                                                </div>
                                                <input type="password" class="form-control"  name="Password" placeholder="Contraseña">
                                            </div>
                                        </div>
                                        <div class="footer text-center">
                                            <BUTTON type="button"   class="btn btn-primary btn-link btn-wd btn-lg create-new-session">Ingresar</BUTTON>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-8 ml-auto mr-auto">
                                <div class="card card-login">
                                    <form class="form" id="new-account" >
                                        <div class="card-header card-header-primary text-center">
                                            <h4 class="card-title">Registrate</h4>
                                        </div>

                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                          <i class="material-icons">face</i>
                                                        </span>
                                                        </div>
                                                        <input type="text" class="form-control" id="Username" name="Username" placeholder="Nombre de usuario">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                          <i class="material-icons">mail</i>
                                                        </span>
                                                        </div>
                                                        <input type="email" class="form-control" id="Email" name="Email" placeholder="Correo electronico">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                          <i class="material-icons">lock_outline</i>
                                                        </span>
                                                        </div>
                                                        <input type="password" class="form-control" id="Password" name="Password" placeholder="Contraseña">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                          <i class="material-icons">mail</i>
                                                        </span>
                                                        </div>
                                                        <input type="text" class="form-control" name="Phone" placeholder="Numero de celular">
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                          <i class="material-icons">mail</i>
                                                        </span>
                                                        </div>
                                                        <input type="text" class="form-control" id="Street" name="Street" placeholder="Calle y numero">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                          <i class="material-icons">mail</i>
                                                        </span>
                                                        </div>
                                                        <input type="text" class="form-control" id="PostalCode" name="PotalCode" placeholder="Codigo postal">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                          <i class="material-icons">mail</i>
                                                        </span>
                                                        </div>
                                                        <select class="form-control selectpicker" data-style="btn btn-link" id="Country" name="Country">
                                                        <c:forEach items="${listCountry}" var="current">
                                                            <option value="${current.getId()}">${current.getDescription()}</option>
                                                        </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                          <i class="material-icons">mail</i>
                                                        </span>
                                                        </div>
                                                        <select class="form-control selectpicker" data-style="btn btn-link" id="State" name="State">
                                                        <c:forEach items="${listState}" var="current">
                                                            <option value="${current.getId()}">${current.getDescription()}</option>
                                                        </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                          <i class="material-icons">mail</i>
                                                        </span>
                                                        </div>
                                                        <select class="form-control selectpicker" data-style="btn btn-link" id="Municipality" name="Municipality">
                                                        <c:forEach items="${listMunicipality}" var="current">
                                                            <option value="${current.getId()}">${current.getDescription()}</option>
                                                        </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                          <i class="material-icons">mail</i>
                                                        </span>
                                                        </div>
                                                        <input type="text" class="form-control" id="Colony" name="Colony" placeholder="Colonia">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="footer text-center">
                                            <BUTTON type="button"   class="btn btn-primary btn-link btn-wd btn-lg create-account">Crear cuenta</BUTTON>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <script>

            $(".create-new-session").on('click', function(){
                var form = $("#new-session");
                var data = getJSON(form);
                swal({
                    title: 'Log In...',
                    onOpen: function () {
                        swal.showLoading()
                    }
                });
                $.ajax({
                    url: "SessionUserBookstore",
                    type : "POST",
                    contentType: "application/json",
                    data : JSON.stringify(data),
                    success : function(result) {
                        if(result['success']) {
                            swal(
                                'Success',
                                'Welcome!!!',
                                'success'
                            );
                            window.location.href = "${pageContext.request.contextPath}/BookIndexPage";
                        }else{
                            swal(
                                'Error',
                                'Log In Error',
                                'error'
                            );
                        }
                    },
                    error: function(xhr, resp, text) {
                        swal(
                            'Error',
                            'Log In Error',
                            'error'
                        );
                        console.log(xhr, resp, text);
                    }
                });
            });
            $(".create-account").on('click', function(){
                var form = $("#new-account");
                var data = getJSON(form);
                swal({
                    title: 'Create account...',
                    onOpen: function () {
                        swal.showLoading()
                    }
                });
                $.ajax({
                    url: "UserBookStore",
                    type : "POST",
                    contentType: "application/json",
                    data : JSON.stringify(data),
                    success : function(result) {
                        if(result['success']) {
                            swal(
                                'Success',
                                'you can now log in!!!',
                                'success'
                            );
                            location.reload();
                        }else{
                            swal(
                                'Error',
                                'Saving',
                                'error'
                            );
                        }
                    },
                    error: function(xhr, resp, text) {
                        swal(
                            'Error',
                            'Saving',
                            'error'
                        );
                        console.log(xhr, resp, text);
                    }
                });
            });
        </script>
    </jsp:attribute>
</layout:layout_client>
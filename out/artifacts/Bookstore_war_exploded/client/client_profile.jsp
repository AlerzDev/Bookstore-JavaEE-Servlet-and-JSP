<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="currentSession" class="beans.SessionBean" scope="session"/>

<layout:layout_client>
    <jsp:attribute name="title">BookStore LogIn</jsp:attribute>
    <jsp:attribute name="content_body">
        <div class="page-header header-filter" data-parallax="true" style="background-image: url('${pageContext.request.contextPath}/client/assets/img/city-profile.jpg'); transform: translate3d(0px, 0px, 0px);"></div>
        <div class="main main-raised">
            <div class="profile-content">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 ml-auto mr-auto">
                            <div class="profile">
                                <div class="avatar">
                                    <img src="${pageContext.request.contextPath}/client/assets/img/faces/christian.jpg" alt="Circle Image" class="img-raised rounded-circle img-fluid">
                                </div>
                                <div class="name">
                                    <h3>${currentSession.currentSession().username}</h3>
                                    <h3>${currentSession.currentSession().email}</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 ml-auto mr-auto">
                            <div class="profile-tabs">
                                <ul class="nav nav-pills nav-pills-icons justify-content-center" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" href="#studio" role="tab" data-toggle="tab">
                                            <i class="material-icons">camera</i> Metodos de pago
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#works" role="tab" data-toggle="tab">
                                            <i class="material-icons">palette</i> Mis compras
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="tab-content tab-space">
                        <div class="tab-pane active text-center gallery" id="studio">
                            <div class="row">
                                <div class="col-md-12 text-center">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addMethodModal">Agregar metodo de pago</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 text-center">
                                    <h4>Mis metodos de pago</h4>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-6 offset-md-3">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th class="text-center">Numero de tarjeta</th>
                                            <th>Fecha de expiration</th>
                                            <th>Banco</th>
                                            <th>Tipo de tarjeta</th>
                                            <th class="text-right">Compania</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listCards}" var="current">
                                            <tr>
                                                <td class="text-center">${current.getNumberCard()}</td>
                                                <td>${current.getDateExp()}</td>
                                                <c:forEach items="${listBank}" var="currentBank">
                                                    <c:if test="${currentBank.getId() == current.getBank()}">
                                                        <th>${currentBank.getDescription()}</th>
                                                    </c:if>
                                                </c:forEach>
                                                <c:forEach items="${listType}" var="currentType">
                                                    <c:if test="${currentType.getId() == current.getTypeCard()}">
                                                        <th>${currentType.getDescription()}</th>
                                                    </c:if>
                                                </c:forEach>
                                                <c:forEach items="${listCompany}" var="currentCompany">
                                                    <c:if test="${currentCompany.getId() == current.getCompanyCard()}">
                                                        <th>${currentCompany.getDescription()}</th>
                                                    </c:if>
                                                </c:forEach>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane text-center gallery" id="works">
                            <div class="row">
                                <div class="col-md-12 text-center">
                                    <h4>Mis compras</h4>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-6 offset-md-3">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th class="text-center">Titulo</th>
                                            <th>Precio</th>
                                            <th>Fecha de compra</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listSales}" var="current">
                                            <tr>
                                                <c:forEach items="${listBook}" var="currentBook">
                                                    <c:if test="${currentBook.getId() == current.getBook()}">
                                                        <td>${currentBook.getTitle()}</td>
                                                        <td>${currentBook.getPrice()}</td>
                                                        <td>${currentBook.getRegDate()}</td>
                                                    </c:if>
                                                </c:forEach>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- Modal -->
        <div class="modal fade" id="addMethodModal" tabindex="-1" role="dialog" aria-labelledby="addMethodModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar metodo de pago</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form id="add-card">
                    <div class="modal-body">

                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="NumberCard" placeholder="Numero de tarjeta">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="DateExp" placeholder="Fecha de expiracion">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="CCV" placeholder="CCV">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="Bank">Select Bank:</label>
                                    <select class="form-control" id="Bank" name="Bank">
                                        <c:forEach items="${listBank}" var="current">
                                            <option value="${current.getId()}">${current.getDescription()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="TypeCard">Select Type Card:</label>
                                    <select class="form-control" id="CompanyCard" name="CompanyCard">

                                        <c:forEach items="${listCompany}" var="current">
                                            <option value="${current.getId()}">${current.getDescription()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="CompanyCard">Select Company Card:</label>
                                    <select class="form-control" id="TypeCard" name="TypeCard">
                                        <c:forEach items="${listType}" var="current">
                                            <option value="${current.getId()}">${current.getDescription()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        <button type="button" onclick="addCardItem()" class="btn btn-primary">Agregar</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
        <script>
            function addCardItem() {
                var form = $("#add-card");
                var data = getJSON(form);
                console.log(data);
                $.ajax({
                    url: "Payment",
                    type : "POST",
                    contentType: "application/json",
                    data : JSON.stringify(data),
                    success : function(result) {
                        console.log(result);
                        if(result['success']) {
                            swal(
                                'Success',
                                'Saving',
                                'success'
                            );
                            location.reload(true);
                        }else{
                            swal(
                                'Error',
                                'Saving',
                                'error'
                            );
                        }
                        $("#"+nameModal).modal('hide');
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
            }
        </script>
    </jsp:attribute>

</layout:layout_client>

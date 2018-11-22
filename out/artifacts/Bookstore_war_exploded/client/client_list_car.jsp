<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="currentSession" class="beans.SessionBean" scope="session"/>
<layout:layout_client>
    <jsp:attribute name="title">BookStore Books</jsp:attribute>
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
                <div class="container">
                    <div class="title">
                        <h2>Carrito de compras</h2>
                    </div>
                    <div class="row">
                        <table class="table">
                            <thead>
                            <tr>
                                <th class="text-center">ISBN</th>
                                <th>Titulo</th>
                                <th>Edicion</th>
                                <th>EAN</th>
                                <th>Disponibilidad</th>
                                <th class="text-right">Precio</th>
                                <th class="text-right">Acciones</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${currentSession.getContents()}" var="current" varStatus="loop">
                                    <tr>
                                        <td class="text-center">${current.getIsbn()}</td>
                                        <td>${current.getTitle()}</td>
                                        <td>${current.getEdition()}</td>
                                        <td>${current.getEan()}</td>
                                        <td>
                                            <c:if test="${current.getStock() > 0}">
                                                <span class="badge badge-success">En existencia</span>
                                            </c:if>
                                            <c:if test="${current.getStock() == 0}">
                                                <span class="badge badge-danger">Sin existencia</span>
                                            </c:if>
                                        </td>
                                        <td class="text-right">${current.getPrice()}</td>
                                        <td class="td-actions text-right">
                                            <button onclick="deleteItemCar(${current.getId()})" type="button" rel="tooltip" class="btn btn-danger btn-round">
                                                <i class="material-icons">close</i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td class="text-center"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>Total</td>
                                    <td class="text-right">${currentSession.getTotal()}</td>
                                    <td class="td-actions text-right">
                                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#processPayModal">Proceder pago</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <script>
            function deleteItemCar(id) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/CarBook"+ '?' + $.param({"idBook":id}),
                    type : "DELETE",
                    success : function(data) {
                        swal(
                            'Success',
                            'Se elimino del carrito',
                            'success'
                        );
                        location.reload();
                    },
                    error: function(xhr, resp, text) {

                    }
                });
            }
        </script>
        <!-- Modal -->
        <div class="modal fade" id="processPayModal" tabindex="-1" role="dialog" aria-labelledby="processPayModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Finalizar compra</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <label>Direccion de envio</label>
                                <br>
                                    ${currentSession.currentSession().getStreet()},  ${currentSession.currentSession().getColony()}, CP ${currentSession.currentSession().getPostalCode()}
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label for="CustomerPayment">Metodo de pago</label>
                                <select class="form-control selectpicker" data-style="btn btn-link" id="CustomerPayment" name="Municipality">
                                    <c:forEach items="${listCards}" var="current">
                                        <option value="${current.getId()}">${current.getNumberCard()} ${current.getDateExp()}</option>
                                     </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-right">
                                <h5>Total</h5>
                                <h6>$ ${currentSession.getTotal()}</h6>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        <button onclick="paymentBooks(${currentSession.currentSession().getId()})" type="button" class="btn btn-primary">Pagar</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function paymentBooks(idUser) {
                var cardMethod = $("#CustomerPayment").val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/CarBook",
                    type : "POST",
                    data:{idUser:idUser,cardMethod:cardMethod},
                    success : function(data) {
                        swal(
                            'Success',
                            'Se efectuo la compra correctamente',
                            'success'
                        );
                        location.reload();
                    },
                    error: function(xhr, resp, text) {

                    }
                });
            }
        </script>
    </jsp:attribute>
</layout:layout_client>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <h2>${namePage}</h2>
                    </div>
                    <div class="row">
                    <c:forEach items="${books}" var="current" varStatus="loop">
                      <div class="col-md-4">
                          <div class="card" style="width: 20rem;">
                              <img class="card-img-top" src="https://images.unsplash.com/photo-1517303650219-83c8b1788c4c?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=bd4c162d27ea317ff8c67255e955e3c8&auto=format&fit=crop&w=2691&q=80" alt="Card image cap">
                              <div class="card-body">
                                  <p class="card-text"><strong>Title: </strong>${current.getTitle()}</p>
                                  <p class="card-text"><strong>Price: </strong>${current.getPrice()}</p>
                                  <p class="card-text"><strong>ISBN: </strong>${current.getIsbn()}</p>
                                  <div class="row">
                                      <div class="col-md-12 text-center"><button onclick="addBookCar(${current.getId()})" class="btn btn-success">Buy</button></div>
                                  </div>
                              </div>
                          </div>
                      </div>
                    </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <script>
            function addBookCar(id) {
                if(isLogin){
                    $.ajax({
                        url: "CarBook",
                        type : "GET",
                        data : {idBook:id},
                        success : function(data) {
                            swal(
                                'Success',
                                'Se agrego al carrito',
                                'success'
                            );
                            location.reload();
                        },
                        error: function(xhr, resp, text) {

                        }
                    });
                }else{
                    swal(
                        'Error',
                        'Debes iniciar sesion',
                        'error'
                    );
                }

            }
        </script>
    </jsp:attribute>
</layout:layout_client>
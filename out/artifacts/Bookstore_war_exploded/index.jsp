<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<layout:layout_client>
    <jsp:attribute name="title">BookStore Home</jsp:attribute>
    <jsp:attribute name="content_body">
    <div class="page-header header-filter clear-filter purple-filter" data-parallax="true"
         style="background-image: url('${pageContext.request.contextPath}/client/assets/img/books.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-md-8 ml-auto mr-auto">
                    <div class="brand text-center">
                        <h1>Bookstore</h1>
                        <h3>No dejes para ma&ntilde;ana lo que puedes leer hoy...</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main main-raised">
        <div class="section section-basic">
            <div class="container">
                <div class="title">
                    <h2>Nuevos</h2>
                </div>
                <div class="row">
                    <c:forEach items="${booksNews}" var="current">
                      <div class="col-md-4">
                          <div class="card" style="width: 20rem;">
                              <img width="300" height="300" class="card-img-top" src="${pageContext.request.contextPath}/GetImage?IdBook=${current.getId()}" alt="Card image cap">
                              <div class="card-body">
                                  <p class="card-text"><strong>Title: </strong>${current.getTitle()}</p>
                                  <p class="card-text"><strong>Price: </strong>${current.getPrice()}</p>
                                  <p class="card-text"><strong>ISBN: </strong>${current.getIsbn()}</p>
                                  <div class="row">
                                      <div class="col-md-12 text-center"><button class="btn btn-success" onclick="addBookCar(${current.getId()})">Comprar</button></div>
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
                    <h2>Precios bajos</h2>
                </div>
                <div class="row">
                    <c:forEach items="${booksOffers}" var="current">
                      <div class="col-md-4">
                          <div class="card" style="width: 20rem;">
                              <img class="card-img-top"
                              <img class="card-img-top" src="${pageContext.request.contextPath}/GetImage?IdBook=${current.getId()}" alt="Card image cap">
                                   alt="Card image cap">
                              <div class="card-body">
                                  <p class="card-text"><strong>Title: </strong>${current.getTitle()}</p>
                                  <p class="card-text"><strong>Price: </strong>${current.getPrice()}</p>
                                  <p class="card-text"><strong>ISBN: </strong>${current.getIsbn()}</p>
                                  <div class="row">
                                      <div class="col-md-12 text-center">
                                          <button class="btn btn-success" onclick="addBookCar(${current.getId()})">Comprar</button>
                                      </div>
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

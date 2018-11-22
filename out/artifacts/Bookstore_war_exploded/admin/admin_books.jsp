<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@taglib prefix="components" tagdir="/WEB-INF/tags/components" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<layout:admin>
    <jsp:attribute name="title">Books</jsp:attribute>
    <jsp:attribute name="header_body">

    </jsp:attribute>
    <jsp:attribute name="content_body">
        <div class="row">
            <div class="col-md-12">
                <components:table_light>
                    <jsp:attribute name="modal">NewBook</jsp:attribute>
                    <jsp:attribute name="title">List book</jsp:attribute>
                    <jsp:attribute name="head">
                        <th scope="col">Id</th>
                        <th scope="col">Editorial</th>
                        <th scope="col">Title</th>
                        <th scope="col">Year Create</th>
                        <th scope="col">Price</th>
                        <th scope="col">Stock</th>
                        <th scope="col">Status</th>
                        <th scope="col"></th>
                    </jsp:attribute>
                    <jsp:attribute name="body">
                        <c:forEach items="${list}" var="current">
                            <tr>
                                <th scope="row">${current.getId()}</th>
                                <th scope="row">${current.getEditorial()}</th>
                                <th scope="row">${current.getTitle()}</th>
                                <th scope="row">${current.getYear()}</th>
                                <th scope="row">${current.getPrice()}</th>
                                <th scope="row">${current.getStock()}</th>
                                <th scope="row">${current.getStatus()}</th>
                                <th scope="row">
                                    <div class="dropdown">
                                        <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-v"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                            <button class="dropdown-item" onclick="editItem('Book',${current.getId()},'EditBook','edit-book-form')">Edit</button>
                                            <button class="dropdown-item" onclick="deleteItem('Book',${current.getId()})">Delete</button>
                                        </div>
                                    </div>
                                </th>
                            </tr>
                        </c:forEach>
                    </jsp:attribute>
                </components:table_light>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <components:modal>
            <jsp:attribute name="tittle">Add Book</jsp:attribute>
            <jsp:attribute name="id">NewBook</jsp:attribute>
            <jsp:attribute name="servlet">Book</jsp:attribute>
            <jsp:attribute name="action">POST</jsp:attribute>
            <jsp:attribute name="formid">new-book-form</jsp:attribute>
            <jsp:attribute name="body">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Title" placeholder="Title">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="ReferenceNumber" placeholder="Reference Number">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Popularity" placeholder="Popularity">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="ISBN" placeholder="ISBN">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="EAN" placeholder="EAN">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="ni ni-calendar-grid-58"></i></span>
                                </div>
                                <input class="form-control datepicker" name="Year" placeholder="Year" type="text">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="NumberOfPages" placeholder="Number Of Pages">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Edition" placeholder="Edition">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Price" placeholder="Price">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Stock" placeholder="Stock">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Details" placeholder="Details">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Genre">Select Genre:</label>
                            <select class="form-control" id="Genre" name="Genre">
                                <c:forEach items="${listGenre}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Format">Select format:</label>
                            <select class="form-control" id="Format" name="Format">
                                <c:forEach items="${listFormat}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Editorial">Select editorial:</label>
                            <select class="form-control" id="Editorial" name="Editorial">
                                <c:forEach items="${listEditorial}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Language">Select Language:</label>
                            <select class="form-control" id="Language" name="Language">
                                <c:forEach items="${listLanguage}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Status">Select status:</label>
                            <select class="form-control" id="Status" name="Status">
                                <c:forEach items="${listStatus}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Author">Select author:</label>
                            <select class="form-control" id="Author" name="Author">
                                <c:forEach items="${listAuthor}" var="current">
                                    <option value="${current.getId()}">${current.getFullName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="file" class="form-control" name="Image" placeholder="Image">
                        </div>
                    </div>
                </div>

            </jsp:attribute>
        </components:modal>
        <components:update_modal>
            <jsp:attribute name="tittle">Edit Book</jsp:attribute>
            <jsp:attribute name="id">EditBook</jsp:attribute>
            <jsp:attribute name="servlet">Book</jsp:attribute>
            <jsp:attribute name="action">PUT</jsp:attribute>
            <jsp:attribute name="formid">edit-book-form</jsp:attribute>
            <jsp:attribute name="body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Id" placeholder="Id">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Title" placeholder="Title">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="ReferenceNumber" placeholder="Reference Number">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Popularity" placeholder="Popularity">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="ISBN" placeholder="ISBN">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="EAN" placeholder="EAN">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="ni ni-calendar-grid-58"></i></span>
                                </div>
                                <input class="form-control datepicker" name="Year" placeholder="Year" type="text">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="NumberOfPages" placeholder="Number Of Pages">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Edition" placeholder="Edition">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Price" placeholder="Price">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Stock" placeholder="Stock">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Details" placeholder="Details">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Genre">Select Genre:</label>
                            <select class="form-control" id="Genre" name="Genre">
                                <c:forEach items="${listGenre}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Format">Select format:</label>
                            <select class="form-control" id="Format" name="Format">
                                <c:forEach items="${listFormat}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Editorial">Select editorial:</label>
                            <select class="form-control" id="Editorial" name="Editorial">
                                <c:forEach items="${listEditorial}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Language">Select Language:</label>
                            <select class="form-control" id="Language" name="Language">
                                <c:forEach items="${listLanguage}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Status">Select status:</label>
                            <select class="form-control" id="Status" name="Status">
                                <c:forEach items="${listStatus}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Author">Select author:</label>
                            <select class="form-control" id="Author" name="Author">
                                <c:forEach items="${listAuthor}" var="current">
                                    <option value="${current.getId()}">${current.getFullName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </jsp:attribute>
        </components:update_modal>
    </jsp:attribute>
</layout:admin>
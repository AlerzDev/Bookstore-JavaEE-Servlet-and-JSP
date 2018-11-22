<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@taglib prefix="components" tagdir="/WEB-INF/tags/components" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<layout:admin>
    <jsp:attribute name="title">Authors</jsp:attribute>
    <jsp:attribute name="header_body">

    </jsp:attribute>
    <jsp:attribute name="content_body">
        <components:table_light>
            <jsp:attribute name="modal">NewAuthor</jsp:attribute>
            <jsp:attribute name="title">List author</jsp:attribute>
            <jsp:attribute name="head">
                <th scope="col">Id</th>
                <th scope="col">Full Name</th>
                <th scope="col">Year Of Birth</th>
                <th scope="col">Register Date</th>
                <th scope="col">Municipality</th>
                <th scope="col">State</th>
                <th scope="col">Country</th>
                <th scope="col">Status</th>
                <th scope="col"></th>
            </jsp:attribute>
            <jsp:attribute name="body">
                <c:forEach items="${listAuthor}" var="current">
                    <tr>
                    <th scope="row">${current.getId()}</th>
                    <th scope="row">${current.getFullName()}</th>
                    <th scope="row">${current.getYearOfBirth()}</th>
                    <th scope="row">${current.getRegDate()}</th>
                    <c:forEach items="${listMunicipality}" var="currentMunicipality">
                        <c:if test="${currentMunicipality.getId() == current.getMunicipality()}">
                            <th scope="row">${currentMunicipality.getDescription()}</th>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${listState}" var="currentState">
                        <c:if test="${currentState.getId() == current.getState()}">
                            <th scope="row">${currentState.getDescription()}</th>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${listCountry}" var="currentCountry">
                        <c:if test="${currentCountry.getId() == current.getCountry()}">
                            <th scope="row">${currentCountry.getDescription()}</th>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${listStatus}" var="currentStatus">
                        <c:if test="${currentStatus.getId() == current.getStatus()}">
                            <th scope="row">${currentStatus.getDescription()}</th>
                        </c:if>
                    </c:forEach>
                    <th scope="row">
                        <div class="dropdown">
                            <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-ellipsis-v"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                <button class="dropdown-item" onclick="editItem('Author',${current.getId()},'EditAuthor','edit-author-form')">Edit</button>
                                <button class="dropdown-item" onclick="deleteItem('Author',${current.getId()})">Delete</button>
                            </div>
                        </div>
                    </th>
                    <tr>
                </c:forEach>
            </jsp:attribute>
        </components:table_light>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <components:modal>
            <jsp:attribute name="tittle">Add Author</jsp:attribute>
            <jsp:attribute name="id">NewAuthor</jsp:attribute>
            <jsp:attribute name="servlet">Author</jsp:attribute>
            <jsp:attribute name="action">POST</jsp:attribute>
            <jsp:attribute name="formid">new-author-form</jsp:attribute>
            <jsp:attribute name="body">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" name="FullName" placeholder="Full Name">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="ni ni-calendar-grid-58"></i></span>
                                </div>
                                <input class="form-control datepicker" name="YearOfBirth" placeholder="Year of birth" type="text">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Country">Select Country:</label>
                            <select class="form-control" id="Country" name="Country">
                                <c:forEach items="${listCountry}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="State">Select state:</label>
                            <select class="form-control" id="State" name="State">
                                <c:forEach items="${listState}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Municipality">Select municipality:</label>
                            <select class="form-control" id="Municipality" name="Municipality">
                                <c:forEach items="${listMunicipality}" var="current">
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
            </jsp:attribute>
        </components:modal>
        <components:update_modal>
            <jsp:attribute name="tittle">Edit Author</jsp:attribute>
            <jsp:attribute name="id">EditAuthor</jsp:attribute>
            <jsp:attribute name="servlet">Author</jsp:attribute>
            <jsp:attribute name="action">PUT</jsp:attribute>
            <jsp:attribute name="formid">edit-author-form</jsp:attribute>
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
                            <input type="text" class="form-control" name="FullName" placeholder="Full Name">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="ni ni-calendar-grid-58"></i></span>
                                </div>
                                <input class="form-control datepicker" name="YearOfBirth" placeholder="Year of birth" type="text">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Country">Select Country:</label>
                            <select class="form-control" id="Country" name="Country">
                                <c:forEach items="${listCountry}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="State">Select state:</label>
                            <select class="form-control" id="State" name="State">
                                <c:forEach items="${listState}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="Municipality">Select municipality:</label>
                            <select class="form-control" id="Municipality" name="Municipality">
                                <c:forEach items="${listMunicipality}" var="current">
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
            </jsp:attribute>
        </components:update_modal>
    </jsp:attribute>
</layout:admin>

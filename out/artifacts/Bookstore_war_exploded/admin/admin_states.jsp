<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@taglib prefix="components" tagdir="/WEB-INF/tags/components" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<layout:admin>
    <jsp:attribute name="title">States</jsp:attribute>
    <jsp:attribute name="header_body">

    </jsp:attribute>
    <jsp:attribute name="content_body">
        <components:table_light>
            <jsp:attribute name="modal">NewState</jsp:attribute>
            <jsp:attribute name="title">List state</jsp:attribute>
            <jsp:attribute name="head">
                <th scope="col">Id</th>
                <th scope="col">Description</th>
                <th scope="col">Country</th>
                <th scope="col">Register Date</th>
                <th scope="col"></th>
            </jsp:attribute>
            <jsp:attribute name="body">
                <c:forEach items="${listState}" var="current">
                    <tr>
                        <th scope="row">${current.getId()}</th>
                        <th scope="row">${current.getDescription()}</th>
                        <c:forEach items="${listCountry}" var="currentCountry">
                            <c:if test="${currentCountry.getId() == current.getCountry()}">
                                <th scope="row">${currentCountry.getDescription()}</th>
                            </c:if>
                        </c:forEach>
                        <th scope="row">${current.getRegDate()}</th>
                        <th scope="row">
                            <div class="dropdown">
                                <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-ellipsis-v"></i>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                    <button class="dropdown-item" onclick="editItem('State',${current.getId()},'EditState','edit-state-form')">Edit</button>
                                    <button class="dropdown-item" onclick="deleteItem('State',${current.getId()})">Delete</button>
                                </div>
                            </div>
                        </th>
                    </tr>
                </c:forEach>
            </jsp:attribute>
        </components:table_light>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <components:modal>
            <jsp:attribute name="tittle">Add State</jsp:attribute>
            <jsp:attribute name="id">NewState</jsp:attribute>
            <jsp:attribute name="servlet">State</jsp:attribute>
            <jsp:attribute name="action">POST</jsp:attribute>
            <jsp:attribute name="formid">new-state-form</jsp:attribute>
            <jsp:attribute name="body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Description" placeholder="Description">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="Country">Select country:</label>
                            <select class="form-control" id="Country" name="Country">
                                <c:forEach items="${listCountry}" var="current">
                                    <option value="${current.getId()}">${current.getDescription()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </jsp:attribute>
        </components:modal>
        <components:update_modal>
            <jsp:attribute name="tittle">Edit State</jsp:attribute>
            <jsp:attribute name="id">EditState</jsp:attribute>
            <jsp:attribute name="servlet">State</jsp:attribute>
            <jsp:attribute name="action">PUT</jsp:attribute>
            <jsp:attribute name="formid">edit-state-form</jsp:attribute>
            <jsp:attribute name="body">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Id" placeholder="Id">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <input type="text" class="form-control" name="Description" placeholder="Description">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="CountryUpdate">Select country:</label>
                            <select class="form-control" name="Country" id="CountryUpdate">
                                <c:forEach items="${listCountry}" var="current">
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

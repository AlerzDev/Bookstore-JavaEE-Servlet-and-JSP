<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@taglib prefix="components" tagdir="/WEB-INF/tags/components" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<layout:admin>
    <jsp:attribute name="title">Editorials</jsp:attribute>
    <jsp:attribute name="header_body">

    </jsp:attribute>
    <jsp:attribute name="content_body">
        <components:table_light>
            <jsp:attribute name="modal">NewEditorial</jsp:attribute>
            <jsp:attribute name="title">List editorial</jsp:attribute>
            <jsp:attribute name="head">
                <th scope="col">Id</th>
                <th scope="col">Description</th>
                <th scope="col">Phone</th>
                <th scope="col">Register Date</th>
                <th scope="col"></th>
            </jsp:attribute>
            <jsp:attribute name="body">
                <c:forEach items="${list}" var="current">
                    <tr>
                        <th scope="row">${current.getId()}</th>
                        <th scope="row">${current.getDescription()}</th>
                        <th scope="row">${current.getPhone()}</th>
                        <th scope="row">${current.getRegDate()}</th>
                        <th scope="row">
                            <div class="dropdown">
                                <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-ellipsis-v"></i>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                    <button class="dropdown-item" onclick="editItem('Editorial',${current.getId()},'EditEditorial','edit-editorial-form')">Edit</button>
                                    <button class="dropdown-item" onclick="deleteItem('Editorial',${current.getId()})">Delete</button>
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
            <jsp:attribute name="tittle">Add Editorial</jsp:attribute>
            <jsp:attribute name="id">NewEditorial</jsp:attribute>
            <jsp:attribute name="servlet">Editorial</jsp:attribute>
            <jsp:attribute name="action">POST</jsp:attribute>
            <jsp:attribute name="formid">new-editorial-form</jsp:attribute>
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
                            <input type="text" class="form-control" name="Phone" placeholder="Phone">
                        </div>
                    </div>
                </div>
            </jsp:attribute>
        </components:modal>
        <components:update_modal>
            <jsp:attribute name="tittle">Edit Editorial</jsp:attribute>
            <jsp:attribute name="id">EditEditorial</jsp:attribute>
            <jsp:attribute name="servlet">Editorial</jsp:attribute>
            <jsp:attribute name="action">PUT</jsp:attribute>
            <jsp:attribute name="formid">edit-editorial-form</jsp:attribute>
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
                            <input type="text" class="form-control" name="Phone" placeholder="Phone">
                        </div>
                    </div>
                </div>
            </jsp:attribute>
        </components:update_modal>
    </jsp:attribute>
</layout:admin>

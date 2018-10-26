<%@tag description="Table Light" pageEncoding="UTF-8"%>
<%@attribute name="head" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="modal" fragment="true" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="paginator" fragment="true" %>
<div class="row">
    <div class="col">
        <div class="card shadow">
            <div class="card-header border-0">
                <div class="row">
                    <div class="col-md-6">
                        <h3 class="mb-0"><jsp:invoke fragment="title"/></h3>
                    </div>
                    <div class="col-md-6">
                        <button type="button" class="btn btn-outline-primary pull-right" data-toggle="modal" data-target="#<jsp:invoke fragment="modal"/>">Add</button>
                    </div>
                </div>
            </div>
            <div class="table-responsive">
                <table class="table align-items-center table-flush">
                    <thead class="thead-light">
                    <tr>
                        <jsp:invoke fragment="head"/>
                    </tr>
                    </thead>
                    <tbody>
                    <jsp:invoke fragment="body"/>
                    </tbody>
                </table>
            </div>
            <div class="card-footer py-4">
                <nav aria-label="...">
                    <ul class="pagination justify-content-end mb-0">
                        <jsp:invoke fragment="paginator"/>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>

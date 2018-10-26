<%@tag description="Modal" pageEncoding="UTF-8"%>
<%@attribute name="tittle" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<%@attribute name="action" fragment="true" %>
<%@attribute name="id" fragment="true" %>
<%@attribute name="servlet" fragment="true" %>
<%@attribute name="formid" fragment="true" %>
<div class="modal fade" id="<jsp:invoke fragment="id"/>" tabindex="-1" role="dialog" aria-labelledby="<jsp:invoke fragment="id"/>" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"><jsp:invoke fragment="tittle"/></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="<jsp:invoke fragment="formid"/>" name="<jsp:invoke fragment="id"/>">
                    <jsp:invoke fragment="body"/>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary update-modal" form="<jsp:invoke fragment="formid"/>" value="<jsp:invoke fragment="servlet"/>" name="<jsp:invoke fragment="action"/>">Save</button>
            </div>
        </div>
    </div>
</div>
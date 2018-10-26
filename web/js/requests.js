$(document).ready(function(){
    // click on button submit
    $(".save-modal").on('click', function(){
        // send ajax
        var button = $(".save-modal");
        var nameForm = button.attr("form");
        var $form = $("#"+nameForm);
        var nameModal = $form.attr("name");
        var action = button.attr("name");
        var servlet = button.attr("value");
        var data = getJSON($form);
        swal({
            title: 'Saving...',
            onOpen: function () {
                swal.showLoading()
            }
        });
        $.ajax({
            url: servlet,
            type : action,
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
    });
    $(".update-modal").on('click', function(){
        // send ajax
        var button = $(".update-modal");
        var nameForm = button.attr("form");
        var $form = $("#"+nameForm);
        var nameModal = $form.attr("name");
        var action = button.attr("name");
        var servlet = button.attr("value");
        var data = getJSON($form);
        console.log(data);
        debugger;
        swal({
            title: 'Saving...',
            onOpen: function () {
                swal.showLoading()
            }
        });
        $.ajax({
            url: servlet,
            type : action,
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
    });
});
function editItem(servlet,id,modal,form) {
    $.ajax({
        url: servlet,
        type : 'GET',
        contentType: "application/json",
        data : "id="+id,
        success : function(result) {
            var values = JSON.parse(result['item']);
            var oForm = document.forms[form];
            for(var i in values){
                if(oForm.elements[i] !== undefined)
                {
                    if(values[i] === true)
                    {
                        oForm.elements[i].checked = true;
                        oForm.elements[i].value = true;
                    }else if(values[i] === false)
                    {
                        oForm.elements[i].checked = false;
                        oForm.elements[i].value = false;
                    }else {
                        oForm.elements[i].value = values[i];
                    }
                }
            }
            $("#"+modal).modal('show');

        },
        error: function(xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    });
}
function deleteItem(servlet,id) {
    swal({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then(function(result){
        if (result.value) {
            $.ajax({
                url: servlet,
                type : 'DELETE',
                contentType: "application/json",
                data : JSON.stringify({id:id,success:false}),
                success : function(result) {
                    console.log(result);
                    if(result['success']) {
                        swal(
                            'Success',
                            'Delete',
                            'success'
                        );
                        location.reload(true);
                    }else{
                        swal(
                            'Error',
                            'Delete',
                            'error'
                        );
                    }
                },
                error: function(xhr, resp, text) {
                    swal(
                        'Error',
                        'Delete',
                        'error'
                    );
                    console.log(xhr, resp, text);
                }
            });
        }
    });
}
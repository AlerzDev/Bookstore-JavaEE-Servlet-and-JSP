
function getJSON($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};
    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });
    $.each($form.find('input[type="file"]'), function(i, tag) {
        var file = $(tag)[0].files[0];

        var reader = new FileReader();
        reader.onload = function(){
            var arrayBuffer = this.result;
            console.log(arrayBuffer);
            var bytes = new Uint8Array(arrayBuffer);
            var array = Array.from(bytes);
            console.log(array);
            indexed_array["Image"] = array;
        }
        reader.readAsArrayBuffer(file);

    });
    return indexed_array;
}


$(document).ready(function(){
    $('.datepicker').datepicker({
        format: 'yyyy-mm-dd'
    });
});
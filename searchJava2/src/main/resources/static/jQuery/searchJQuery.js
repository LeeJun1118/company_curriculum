$(document).ready(function () {


    $("#jQuery").click(function () {
        var search_id = $("#searchID").val();
        var node = $("#searchNode").val();
        var att_name = $("#attName").val();
        var att_value = $("#attValue").val();

        //===================id 로 찾기===================
        if (search_id != '' && node == '' && att_name == '' && att_value == '') {
            $("#inJQuery").val($('[id' + '='+ search_id + ']').length);
        }
        //===================node명으로 찾기===================
        if (search_id == '' && node != '' && att_name == '' && att_value == '') {
            $("#inJQuery").val($(node).length);
        }

    })
});
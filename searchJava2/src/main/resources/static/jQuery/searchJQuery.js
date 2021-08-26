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
        //===================id + node명으로 찾기===================
        if (search_id != '' && node != '' && att_name == '' && att_value == '') {
            //출력
            $("#inJQuery").val($(node).filter('[id' + '='+ search_id + ']').length);
        }
        //=================== 속성명 + 속성값으로 찾기 ===================
        if (att_name != '' && att_value == '') {
            // alert("속성값을 입력해주세요")
            $("#inJQuery").val("속성값을 입력해주세요");
        } else if (att_name == '' && att_value != '' ) {
            // alert("속성명을 입력해주세요")
            $("#inJQuery").val("속성명을 입력해주세요");
          } else if (att_name != '' && att_value != '' && search_id == '' && node == '') {
            if (att_name == "class")
            {
                $("#inJQuery").val($('.'+ att_value).length);
            }
            else{
            $("#inJQuery").val($('['+att_name + '='+ att_value + ']').length);

            }
        }

        //========================id + 속성명 + 속성값 으로 찾기========================
        if (search_id != '' && node == '' && att_name != '' && att_value != '') {
            //특정 id 인 속성 값들을 분리시켜야함

            var array = $('[id' + '='+ search_id + ']').eq(0);
            /*array.attr('['+att_name + '='+ att_value + ']');
            array.hasClass('['+att_name + '='+ att_value + ']');
*/
            console.log(array)
            // console.log(array.hasClass('['+att_name + '='+ att_value + ']'))
            // console.log($("input[class=aa]").length)
            $("#inJQuery").val($('['+att_name + '='+ att_value + ']').filter('[id' + '='+ search_id + ']').length);
        }

        //========================노드명 + 속성명 + 속성값 으로 찾기=====================
        if (search_id == '' && node != '' && att_name != '' && att_value != '') {
            $("#inJQuery").val($(node).filter('['+att_name + '='+ att_value + ']').length);
        }

    })
});
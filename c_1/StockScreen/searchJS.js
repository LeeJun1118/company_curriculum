// id : id
// 노드 : div, head, body 
// 속성 : id class type style onclick 
// 속성값 : text yellow 


function nodeSearch() {
    const searchID = document.getElementById('searchID').value;
    const searchNode = document.getElementById('searchNode').value;
    const attName = document.getElementById('attName').value;
    const attValue = document.getElementById("attValue").value;

    let myHTML = ['html','head','div','ul','li'
                     ,'input','button','select','option','table'
                     ,'thead','tr','th','tbody','td'
                     ,'span','svg','meta','link','script'];
    
    
    //===================id 로 찾기===================
    if (searchID != '') {
        const id_list = document.querySelectorAll('#'+ searchID);
        const id_list_length = id_list.length;
        if (id_list_length == 0) {
            alert("없는 id 입니다.")
        }
        else{
            alert(searchID + " : "+ id_list_length);
         }
    }
        
    //===================노드명으로 찾기===================
    if (searchNode != '') {
        const node_list = document.querySelectorAll(searchNode);
        const node_list_length = node_list.length;
        if (node_list_length == 0) {
            alert("없는 노드 입니다.")
        }
        else{
            alert(searchNode + " : "+ node_list_length);
        }
    }

    //===================속성으로 찾기===================
    // hasAttribute 함수 사용
    if (attName != '') {
        var count = 0;
        let nodeElements = [];
        for(var i = 0; i < myHTML.length; i++){
            // nodeElements[i] =  [id , class, onclick, ....]
            nodeElements[i] = document.querySelector(myHTML[i]).getAttributeNames();
            for(var j = 0; j < nodeElements[i].length; j++){
                // x = id, class, onclick
                var x = nodeElements[i];

                //x[j]= 'class'   attName = 'class'
                if (x[j] == attName) {
                    count = count + document.querySelector(myHTML[i]).getAttribute(attName).length;
                }
            }
        }

        alert(count);
    }

    // //===================속성값으로 찾기===================
    // if (attValue != '') {
    //     var countValue = 0;
    //     for(var i = 0; i < myHTML.length; i++){
    //         if (document.querySelector(myHTML[i])) {
    //             if (document.querySelector(myHTML[i]).getAttribute(attValue)) {
    //                 lengthHTML[i] = document.querySelector(myHTML[i]).getAttribute(attValue).length;
    //                 countValue = countValue + lengthHTML[i];
    //             }               
    //         }
    //     }
    //     alert(count);
    // }


}

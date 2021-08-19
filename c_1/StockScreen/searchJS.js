// id : id
// 노드 : div, head, body 
// 속성 : id class type style onclick 
// 속성값 : text yellow 

// To-Do-List
// 1. id + 노드명 + 속성명 + 속성값 으로 찾기

function nodeSearch() {
    const searchID = document.getElementById('searchID').value;
    const searchNode = document.getElementById('searchNode').value;
    const attName = document.getElementById('attName').value;
    const attValue = document.getElementById('attValue').value;

    let myHTML = ['html','head','div','ul','li'
                     ,'input','button','select','option','table'
                     ,'thead','tr','th','tbody','td'
                     ,'span','svg','meta','link','script'];
    
    
    //===================id 로 찾기===================
    if (searchID != '' && searchNode == '' && attName == '' && attValue == '') {
        const id_list = document.querySelectorAll('#'+ searchID);
        const id_list_length = id_list.length;
        alert(searchID + " : "+ id_list_length);
       }
    
    //===================노드명으로 찾기===================
    if (searchNode != '' && searchID == '' && attName == '' && attValue == '') {
        const node_list = document.querySelectorAll(searchNode);
        const node_list_length = node_list.length;
        alert(searchNode + " : "+ node_list_length);
    }


    //===================id + 노드명으로 찾기===================
    if (searchNode != '' && searchID != '' && attName == '' && attValue == '') {
        var tagList = document.querySelectorAll(searchNode);
        var countNodeId = 0;
        for(var i = 0; i < tagList.length; i++){
            if (tagList[i].getAttribute('id') != null && tagList[i].getAttribute('id') == searchID) {
                countNodeId++;
            }
        }
        alert(countNodeId);
    }

    // //===================속성으로 찾기===================
    // if (attName != '') {
    //     var count = 0;
    //     let nodeElements = [];
    //     for(var i = 0; i < myHTML.length; i++){
    //         // nodeElements[i] =  [id , class, onclick, ....]
    //         nodeElements[i] = document.querySelector(myHTML[i]).getAttributeNames();
    //         for(var j = 0; j < nodeElements[i].length; j++){
    //             // x = id, class, onclick
    //             var x = nodeElements[i];

    //             //x[j]= 'class'   attName = 'class'
    //             if (x[j] == attName) {
    //                 count = count + document.querySelector(myHTML[i]).getAttribute(attName).length;
    //             }
    //         }
    //     }
    //     alert(attName + " : " + count);
    // }

    // //===================속성값으로만 찾기===================
    // if (attValue != '') {
    //     var countValue = 0;
    //     for(var i = 0; i < myHTML.length; i++){
    //         var tagList = document.querySelectorAll(myHTML[i]);
    //         // id class onclick .........
    //         for(var j = 0; j < tagList.length; j++){
    //             var className = tagList[j].getAttributeNames();
    //                 for(var k = 0; k < className.length; k++){
    //                     var confirm = tagList[j].getAttributeNode(className[k]).value.split(' ');
    //                     for(var h = 0; h < confirm.length; h++){
    //                         if (confirm[h] == attValue) {
    //                             countValue++;
    //                         }
    //                     }
                        
    //                 }
    //         }
    //     }
    //     alert(attValue + " : " + countValue);
    // }



    //=================== 속성명 + 속성값으로 찾기 ===================
    // 속성명, 속성값 같이 입력하게
    // 속성명 빠졌을 때 속성명을 입력해주세요 
    // 속성값 빠졌을 때도 동일
    if (attName != '' && attValue == ''  /*&& searchNode == '' && searchID == '' */) {
        alert("속성값을 입력해주세요")
    }
    else if(attName == '' && attValue != '' /*&& searchNode == '' && searchID == '' */){
        alert("속성명을 입력해주세요")
    }
    else if(attName != '' && attValue != '' && searchNode == '' && searchID == '' ){
        var countAtt = 0;
        for(var i = 0; i < myHTML.length; i++){
            var tagList = document.querySelectorAll(myHTML[i]);
            for(var j = 0; j < tagList.length; j++){
                if (tagList[j].getAttributeNode(attName) != null) {
                    var confirm = tagList[j].getAttributeNode(attName).value.split(' ');
                    for(var h = 0; h < confirm.length; h++){
                        if (confirm[h] == attValue) {
                            countAtt++;
                        }
                    }
                }  
            }
        }
        alert(attName+", " + attValue + " : " + countAtt)
    }


    //===================id + 노드명 + 속성명 + 속성값 으로 찾기===================
    if (searchNode != '' && searchID != '' && attName != '' && attValue != '') {
        // th 사용한 부분들 list
        var tagList = document.querySelectorAll(searchNode);
        var countAllCondition = 0;
        for(var i = 0; i < tagList.length; i++){
            // div li 등등 list 중에서 각 list에서  class id type의 값이 null 이 아니면
            if (tagList[i].getAttribute('id') != null && tagList[i].getAttribute(attName) != null) {
                //console.log('searchID:' + searchID + '  ||  attName:' + attName);
                if (tagList[i].getAttribute('id') == searchID && tagList[i].getAttribute(attName) == attValue) {
                    //console.log('attName:' + attName + "  ||  attValue:" + attValue + "  ||  count:" + countAllCondition);
                    countAllCondition++;
                }
            }
        }
        alert(countAllCondition);
    }
}

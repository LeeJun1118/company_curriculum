// id : id
// 노드 : div, head, body 
// 속성 : id class type style onclick 
// 속성값 : text yellow 


function nodeSearch() {
    const searchID = document.getElementById('searchID').value;
    const searchNode = document.getElementById('searchNode').value;
    const attName = document.getElementById('attName').value;
    const attValue = document.getElementById("attValue").value;
    document.getElementsByTagName
    
    
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
        console.log(attName)
        var x = document.querySelector('input').hasAttribute(attName);
        console.log(x)
    }

    // if (searchNode != '') {
    //     var atts = document.querySelector('div').attributes;
    //     console.log(atts);
    //     for(var i = 0; i < atts.length; i++){
    //         console.log(atts[i].nodeName + " = " + atts.nodeValue);
    //     }
    // }
    
}

function nodeSearch() {
    const searchID = document.getElementById('searchID').value;
    // const searchNode = document.getElementsByClassName('searchNode');
    // const attName = document.getElementById('attName');
    // const attValue = document.getElementById("attValue");



    //===================id 로 찾기===================
    const id_list = document.querySelectorAll('#'+ searchID);
    const id_list_length = id_list.length;
    if (id_list_length == 0) {
        alert("없는 id 입니다.")
    }
    else{
        alert(id_list_length);
    }
        
    
    
    
    
    // serchID
    // if (searchID == '') {
    //     //console.log('공백입니다.')
    // }
    // else{
    //     console.log('searchID : ' + searchID);

    //     var id_length = searchID.length;

    //     console.log('id_length : ' + id_length);
    //     alert(id_length);
    // }

    // if (searchNode == '') {
    //     console.log('공백입니다.')
    // }
    // else{
    //     const node_list = searchNode.length;
    //     console.log(node_list)
    //     alert(searchNode.length)
    // }
}

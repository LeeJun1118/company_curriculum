function nodeSearch() {
    const searchID = document.getElementById('searchID').value;
    // const searchNode = document.getElementsByClassName('searchNode');
    // const attName = document.getElementById('attName');
    // const attValue = document.getElementById("attValue");



    //===================id 로 찾기===================
    if (searchID == "") {
        alert("없는 id 입니다.");
    }
    else{
        const div_list = document.querySelectorAll('#'+ searchID);
        const div_list_length = div_list.length;
        alert(div_list_length);
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

function nodeSearch() {
    const searchID = document.getElementById('searchID').value;
    const searchNode = document.getElementById('searchNode').value;
    const attName = document.getElementById('attName').value;
    const attValue = document.getElementById('attValue').value;

    let myHTML = ['html', 'head', 'div', 'ul', 'li'
        , 'input', 'button', 'select', 'option', 'table'
        , 'thead', 'tr', 'th', 'tbody', 'td'
        , 'span', 'svg', 'meta', 'link', 'script'];


    //===================id 로 찾기===================
    if (searchID != '' && searchNode == '' && attName == '' && attValue == '') {
        document.getElementById("inJs").value = document.querySelectorAll('#' + searchID).length;
    }

    //===================노드명으로 찾기===================
    if (searchNode != '' && searchID == '' && attName == '' && attValue == '') {
        document.getElementById("inJs").value = document.querySelectorAll(searchNode).length;
    }


    //===================id + 노드명으로 찾기===================
    if (searchNode != '' && searchID != '' && attName == '' && attValue == '') {
        var tagList = document.querySelectorAll(searchNode);
        var countNodeId = 0;
        for (var i = 0; i < tagList.length; i++) {
            if (tagList[i].getAttribute('id') != null && tagList[i].getAttribute('id') == searchID) {
                countNodeId++;
            }
        }
        document.getElementById("inJs").value = countNodeId;
    }

    //=================== 속성명 + 속성값으로 찾기 ===================
    if (attName != '' && attValue == '') {
        // alert("속성값을 입력해주세요")
        document.getElementById("inJs").value = "속성값을 입력해주세요";
    } else if (attName == '' && attValue != '' ) {
        // alert("속성명을 입력해주세요")
        document.getElementById("inJs").value = "속성명을 입력해주세요";
    } else if (attName != '' && attValue != '' && searchNode == '' && searchID == '') {
        var countAtt = 0;
        if (attName == "class")
            countAtt = document.getElementsByClassName(attValue).length;
        else
            countAtt = document.querySelectorAll('['+attName+'='+attValue+']').length;

        /*for (var i = 0; i < myHTML.length; i++) {
            for (var j = 0; j < tagList.length; j++) {
                if (tagList[j].getAttributeNode(attName) != null) {
                    var confirm = tagList[j].getAttributeNode(attName).value.split(' ');
                    for (var h = 0; h < confirm.length; h++) {
                        if (confirm[h] == attValue) {
                            countAtt++;
                        }
                    }
                }
            }
        }*/

        document.getElementById("inJs").value = countAtt;
    }

    //========================id + 속성명 + 속성값 으로 찾기========================
    if (searchID != '' && searchNode == '' && attName != '' && attValue != '') {
        var countValue = 0;
        var values = document.getElementById(searchID).getAttribute(attName).split(" ");
        for (let i = 0; i < values.length; i++) {
            if (values[i] == attValue)
                countValue++;
        }
        // th
       /* for (var i = 0; i < myHTML.length; i++) {
            var tagList = document.querySelectorAll(myHTML[i]);
            // class
            for (var j = 0; j < tagList.length; j++) {
                // id가 SearchID 이고 attName이 even 이라면
                if (tagList[j].getAttribute('id') == searchID && tagList[j].getAttribute(attName) != null) {
                    // class의 value가 여러개일 수 있으므로 split
                    var confirm = tagList[j].getAttributeNode(attName).value.split(' ');
                    for (var h = 0; h < confirm.length; h++) {
                        //class의 값들 중 attValue 와 같은게 있으면
                        if (confirm[h] == attValue) {
                            countValue++;
                        }
                    }
                }
            }
        }*/
        document.getElementById("inJs").value = countValue;
    }


    //========================노드명 + 속성명 + 속성값 으로 찾기=====================
    if (searchID == '' && searchNode != '' && attName != '' && attValue != '') {
        var countValue = 0;
        // th list
        var tagList = document.querySelectorAll(searchNode);
        // class
        for (var j = 0; j < tagList.length; j++) {
            //attName이 even 이라면
            if (tagList[j].getAttribute(attName) != null) {
                // class의 value가 여러개일 수 있으므로 split
                var confirm = tagList[j].getAttributeNode(attName).value.split(' ');
                for (var h = 0; h < confirm.length; h++) {
                    //class의 값들 중 attValue 와 같은게 있으면
                    if (confirm[h] == attValue) {
                        countValue++;
                    }
                }
            }
        }
        document.getElementById("inJs").value = countValue ;
    }


    //===================id + 노드명 + 속성명 + 속성값 으로 찾기===================
    if (searchID !== '' && searchNode != '' && attName != '' && attValue != '') {
        // th 사용한 부분들 list
        var tagList = document.querySelectorAll(searchNode);
        var countAllCondition = 0;
        for (var i = 0; i < tagList.length; i++) {
            // div li 등등 list 중에서 각 list에서  class id type의 값이 null 이 아니면
            //if (tagList[i].getAttribute('id') != null) {
            // id가 searchID 라면
            if (tagList[i].getAttribute('id') == searchID) {
                // class 의 value 가 여러개일 수 있으니 나눔
                var confirm = tagList[i].getAttributeNode(attName).value.split(' ');
                for (var h = 0; h < confirm.length; h++) {
                    //class의 값들 중 attValue 와 같은게 있으면
                    if (confirm[h] == attValue) {
                        countAllCondition++;
                    }
                }
            }
        }
        document.getElementById("inJs").value = countAllCondition;
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
}


/*function recursive(len,tag,count,index) {
    if (index == tagList.length)
        return count;
    else{
        if (tag.getAttributeNode(attName) != null) {
            console.log(tag.getAttributeNode(attName).length)
            var confirm = tag.getAttributeNode(attName).value.split(' ');
            for (var h = 0; h < confirm.length; h++) {
                if (confirm[h] == attValue) {
                    count++;
                }
            }
        }
        return recursive(tagList,tagList[index],count,index++);
    }
}*/
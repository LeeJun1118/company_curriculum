function nodeSearch() {
    const searchID = document.getElementById('searchID').value;
    const searchNode = document.getElementById('searchNode').value;
    const attName = document.getElementById('attName').value;
    const attValue = document.getElementById('attValue').value;

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
        // var countNodeId = 0;
        var countNodeId = 0, index = 0;
        //재귀
        var countNodeId = recursiveIdNode(tagList, countNodeId, index, searchID);
        /*
        //반복
        for (var i = 0; i < tagList.length; i++) {
            if (tagList[i].getAttribute('id') != null && tagList[i].getAttribute('id') == searchID) {
                countNodeId++;
            }
        }*/
        document.getElementById("inJs").value = countNodeId;
    }
    //===================재귀: id + 노드명으로 찾기===================
    function recursiveIdNode(tagList, count, index, searchID) {
        if (index >= tagList.length)
            return count;
        else
            return (tagList[index].getAttribute('id') != null && tagList[index].getAttribute('id') == searchID)
                ? recursiveIdNode(tagList, count + 1, index + 1, searchID) : recursiveIdNode(tagList, count, index + 1, searchID);
    }




    //=================== 속성명 + 속성값으로 찾기 ===================
    if (attName != '' && attValue == '') {
        // alert("속성값을 입력해주세요")
        document.getElementById("inJs").value = "속성값을 입력해주세요";
    } else if (attName == '' && attValue != '') {
        // alert("속성명을 입력해주세요")
        document.getElementById("inJs").value = "속성명을 입력해주세요";
    } else if (attName != '' && attValue != '' && searchNode == '' && searchID == '') {
        var countAtt = 0;
        if (attName == "class")
            countAtt = document.getElementsByClassName(attValue).length;
        else
            countAtt = document.querySelectorAll('[' + attName + '=' + attValue + ']').length;

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
        var countValue = 0, index = 0;
        var values = document.getElementById(searchID).getAttribute(attName).split(" ");
        countValue = recursiveIdAtt(values,attValue,countValue,index);

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
    //========================재귀 : id + 속성명 + 속성값 으로 찾기========================
    function recursiveIdAtt(values, attValue, count, index) {
        if (index >= values.length)
            return count;
        else
            return values[index] == attValue ?
                recursiveIdAtt(values, attValue, count+1, index+1) :
                recursiveIdAtt(values, attValue, count, index+1);
    }




    //========================노드명 + 속성명 + 속성값 으로 찾기=====================
    if (searchID == '' && searchNode != '' && attName != '' && attValue != '') {
        var countValue = 0;
        var tagList = [];
        if (attName == "class")
            tagList = document.getElementsByClassName(attValue);
        else
            tagList = document.querySelectorAll('[' + attName + '=' + attValue + ']');

        for (let i = 0; i < tagList.length; i++) {
            if (tagList.item(i).nodeName.toUpperCase() == searchNode.toUpperCase())
                countValue++;
        }

        /*
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
        */
        document.getElementById("inJs").value = countValue;
    }


    //===================id + 노드명 + 속성명 + 속성값 으로 찾기===================
    if (searchID !== '' && searchNode != '' && attName != '' && attValue != '') {
        var countAllCondition = 0;
        var tagList = [];
        if (attName == "class")
            tagList = document.getElementsByClassName(attValue);
        else
            tagList = document.querySelectorAll('[' + attName + '=' + attValue + ']');

        for (let i = 0; i < tagList.length; i++) {
            if (tagList.item(i).nodeName.toUpperCase() == searchNode.toUpperCase() && tagList.item(i).getAttribute("id") == searchID)
                countAllCondition++;
        }

        /*// th 사용한 부분들 list
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
        }*/
        document.getElementById("inJs").value = countAllCondition;
    }
}
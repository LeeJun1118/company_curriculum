function create_getFocus(num) {
    var btn_class = [];

    for(var i = 1; i < 9; i++){
        btn_class[i] = document.getElementById("btn"+i);
        btn_class[i].classList.add('nav_btn');
        btn_class[i].classList.remove('getFocus');
    }
    btn_class[num].classList.remove('nav_btn');
    btn_class[num].classList.add('getFocus');
}


function create_getFocus2(num) {
    var btn_class = [];

    for(var i = 1; i < 9; i++){
        btn_class[i] = document.getElementById("btn_2_"+i);
        btn_class[i].classList.add('nav_btn');
        btn_class[i].classList.remove('getFocus');
    }
    btn_class[num].classList.remove('nav_btn');
    btn_class[num].classList.add('getFocus');
}


function create_getFocus3(num) {
    var btn_class = [];

    for(var i = 1; i < 5; i++){
        btn_class[i] = document.getElementById("btn_3_"+i);
        btn_class[i].classList.add('nav_btn');
        btn_class[i].classList.remove('getFocus');
    }
    btn_class[num].classList.remove('nav_btn');
    btn_class[num].classList.add('getFocus');
}

function create_getFocus4(num) {
    var btn_class = [];

    for(var i = 1; i < 5; i++){
        btn_class[i] = document.getElementById("btn_4_"+i);
        btn_class[i].classList.add('nav_blue_line');
        btn_class[i].classList.remove('getFocus_blue');
    }
    btn_class[num].classList.remove('nav_blue_line');
    btn_class[num].classList.add('getFocus_blue');
}

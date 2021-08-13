
function create_getFocus(num) {
    var btn_class = [];

    for(var i = 1; i < 9; i++){
        btn_class[i] = document.getElementById("btn"+i);
    }

    for(var i=1; i<9; i++){
        btn_class[i].classList.add('nav_btn');
    }

    for(var i=1; i<9; i++){
        btn_class[i].classList.remove('getFocus');
    }

    btn_class[num].classList.remove('nav_btn');
    btn_class[num].classList.add('getFocus');
}

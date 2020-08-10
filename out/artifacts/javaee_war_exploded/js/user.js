//显示用户的登录界面
function login(){
    $.ajax({
        type:"get",
        url:"login.jsp",
        success:function(data){
            $(".main").html(data);
        }
    });
}


//实现登录功能
function loginServlet(url) {
    var data = $(".loginForm").serialize();
    $.ajax({
        type:"post",
        url:url,
        data:data,
        success:function (content) {
            $(".main").html(content);
        }
    });
}

//实现退出功能
function logout(url) {
    $.ajax({
        type:"get",
        url:url,
        success:function(content){
            $(".main").html(content);
        }
    });
}


//显示用户的注册界面
function regist() {
    $.ajax({
        type:"get",
        url:"regist.jsp",
        success:function(data){
            $(".main").html(data);
        }
    });
}


//显示查看所有页面
function viewAll(url){
    var query = $("#searchName").val();
    var pageNow = $("#pageNow").val();

    // 默认查询所有
    if(query==undefined){
        query = "";
    }
    //默认查询第一页
    if(pageNow==undefined){
        pageNow = 1;
    }

    $.ajax({
        type:"get",
        url:url+"&pageNow="+pageNow+"&query="+query,
        success:function (content) {
            $(".main").html(content);
        }
    });
}


//实现分页
//首页
function first(url){
    var query = $("#searchName").val();
    var pageNow = $("#pageNow").val();

    pageNow = 1;
    $.ajax({
        type:"get",
        url:url+"&pageNow="+pageNow+"&query="+query,
        success:function (content) {
            $(".main").html(content);
        }
    });
}

//末页
function last(url,myPages){
    var query = $("#searchName").val();
    var pageNow = $("#pageNow").val();
}

//上一页
function pre(url){
    var query = $("#searchName").val();
    var pageNow = $("#pageNow").val();
}

//下一页
function next(url,myPages) {
    var query = $("#searchName").val();
    var pageNow = $("#pageNow").val();
}

//跳转
function skip(url,myPages) {
    var query = $("#searchName").val();
    var pageNow = $("#pageNow").val();
}
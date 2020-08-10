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


//显示查看所有页面
function viewAll(url){
    var query = $("#searchName").val();

    // 默认查询所有
    if(query==undefined){
        query = "";
    }

    $.ajax({
        type:"get",
        url:url+"&query="+query,
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
    pageNow = myPages;
    $.ajax({
        type:"post",
        url:url,
        data:{"pageNow":pageNow , "query":query},
        success:function (content) {
            $(".main").html(content);
        }
    });
    
}

//上一页
function pre(url){
    var query = $("#searchName").val();
    var pageNow = $("#pageNow").val();
    if(pageNow==1){
        alert("已至首页");
    }else{
        pageNow = pageNow - 1;
    }
    $.ajax({
        type:"get",
        url:url+"&pageNow="+pageNow+"&query="+query,
        success:function (content) {
            $(".main").html(content);
        }
    });
}

//下一页
function next(url,myPages) {
    var query = $("#searchName").val();
    var pageNow = $("#pageNow").val();
    if(pageNow == myPages){
        alert("已至末页");
    }else{
        pageNow = pageNow - (-1);
    }
    $.ajax({
        type:"get",
        url:url+"&pageNow="+pageNow+"&query="+query,
        success:function (content) {
            $(".main").html(content);
        }
    });
}

//跳转
function skip(url,myPages) {
    var query = $("#searchName").val();
    var pageNow = $("#pageNow").val();
    if(pageNow<1 || pageNow>myPages){
        alert("超出页码范围");
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

//显示商品添加页面
function add(){
    $.ajax({
        type:"get",
        url:"addItem.jsp",
        success:function(content){
            $(".main").html(content);
        }
    });
}

//商品名称的校验
function validateName(url) {
    var name = $("#name").val();
    if(name!=null && name.trim()!=""){
        $.ajax({
            type:"get",
            url:url+"&name="+name,
            dataType:"json",
            success:function(content){
                var flag = content.flag;
                var message = content.nameMsg;
                if(flag=="true"){
                    $(".nameMsg").html("<font color='green'>"+message+"</font>");
                }else if(flag=="false"){
                    $(".nameMsg").html("<font color='red'>"+message+"</font>");
                }
            }
        });
    }else{
        $(".nameMsg").html("<font color='red'>商品名称不能为空</font>");
    }
}

//添加商品
function addServlet(url) {
    //表单收集二进制数据
    var formData = new FormData($("#f")[0]);
    alert(formData)
    $.ajax({
        type:"post",
        url:url,
        data:formData,
        contentType:false,
        processData:false,
        success:function (content) {
            $(".main").html(content);
        }
    });
}
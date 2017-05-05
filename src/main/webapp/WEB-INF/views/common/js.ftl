<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.js"></script>
<script src="${base}/res/js/dialog/layer.js"></script>
<script src="${base}/res/js/dialog/dialog.js"></script>
<script>
    var loadUrl = function (url) {
        layer.open({
            type: 2,
            title: '法律人',
            shadeClose: true,
            shade: 0.8,
            area: ['1150px', '90%'],
            content: url
        });
    }
    var loginLoad = function () {
        layer.open({
            type: 1,
            title: '用户登录',
            skin: 'layui-layer-rim', //加上边框
            area: ['600px', '380px'], //宽高
            content: '<div style="padding: 50px; line-height: 22px; font-weight: 300;"><form class="form-horizontal" role="form" method="post"><div class="form-group"><label for="inputEmail3" class="col-sm-2 control-label">邮箱:</label> <div class="col-sm-8"> <input type="email" class="form-control" id="loginEmail" name="loginEmail" placeholder="邮箱地址" /> </div></div><div class="form-group"><label for="inputPassword3" class="col-sm-2 control-label">密码:</label> <div class="col-sm-8"><input type="password" class="form-control" id="loginPassword" name="loginPassword" placeholder="密码"/></div></div><div class="form-group"><div class="col-sm-offset-2 col-sm-8"><button class="btn btn-default layui-layer-btn" type="button" onclick="login()">登录</button></div></div></form></div>'
        });
    }
    var registerLoad = function () {
        layer.open({
            type: 1,
            title: '用户注册',
            skin: 'layui-layer-rim', //加上边框
            area: ['800px', '600px'], //宽高
            content: '<div style="padding: 50px; line-height: 22px; font-weight: 300;"><form class="form-horizontal" role="form" method="post"> <div class="form-group"> <label for="inputEmail3" class="col-sm-2 control-label">邮箱:</label> <div class="col-sm-8"> <input type="email" class="form-control" name="registerEmail" placeholder="邮箱地址" /> </div> </div> <div class="form-group"> <label for="inputEmail3" class="col-sm-2 control-label">姓名:</label> <div class="col-sm-8"> <input type="email" class="form-control" name="name" placeholder="姓名" /> </div> </div> <div class="form-group"> <label for="inputEmail3" class="col-sm-2 control-label">地址:</label> <div class="col-sm-8"> <input type="text" class="form-control" name="address" placeholder="地址" /> </div> </div> <div class="form-group"> <div class="radio"> <label> <input type="radio" name="gender" value="男" checked> 男 </label> </div> <div class="radio"> <label> <input type="radio" name="gender" value="女"> 女 </label> </div> </div> <div class="form-group"> <label for="inputEmail3" class="col-sm-2 control-label">职业:</label> <div class="col-sm-8"> <input type="text" class="form-control" name="profession" placeholder="职业" /> </div> </div> <div class="form-group"> <label for="inputPassword3" class="col-sm-2 control-label">密码:</label> <div class="col-sm-8"> <input type="password" class="form-control" name="password" placeholder="密码" /> </div> </div> <div class="form-group"> <label for="inputPassword3" class="col-sm-2 control-label">重复密码:</label> <div class="col-sm-8"> <input type="password" class="form-control" name="confirmPassword" placeholder="重复密码" /> </div> </div> <div class="form-group"> <div class="col-sm-offset-2 col-sm-8"> <button type="button" class="btn btn-default" onclick="register()">注册</button> </div> </div></form></div>'
        });
    }

    var login = function() {
        var email = $('input[name="loginEmail"]').val();
        var password = $('input[name="loginPassword"]').val();
        var url = '${base}/admin/doLogin';
        var data = {'email':email, 'password':password};
        dialog.post(url, data);
    }

    var register =  function() {
        var email = $('input[name="registerEmail"]').val();
        var name = $('input[name="name"]').val();
        var gender = $('input[name="gender"]').val();
        var address = $('input[name="address"]').val();
        var password = $('input[name="password"]').val();
        var profession = $('input[name="profession"]').val();
        var confirmPassword = $('input[name="confirmPassword"]').val();

        var data = {
            'email' : email,
            'name' : name,
            'gender' : gender,
            'address' : address,
            'profession' : profession,
            'password' : password,
            'confirmPassword' : confirmPassword
        };
        var url = '${base}/admin/doRegister';
        dialog.post(url, data);
    }
</script>
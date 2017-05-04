<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>${SITE_NAME}</title>
<#include "/common/css.ftl"/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                法律人平台登录注册
            </h3>
            <div class="tabbable" id="tabs-700133">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#panel-555555" data-toggle="tab">登录</a>
                    </li>
                    <li>
                        <a href="#panel-466221" data-toggle="tab">注册</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="panel-555555">
                        <form class="form-horizontal" role="form" method="post">
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">邮箱:</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="loginEmail" name="loginEmail" placeholder="邮箱地址" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="loginPassword" name="loginPassword" placeholder="密码"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button class="btn btn-default" onclick="login()" type="button">登录</button>
                                <#--<button class="btn btn-lg btn-primary btn-block" type="button" onclick="login.check()">登录</button>-->
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane" id="panel-466221">
                        <form class="form-horizontal" role="form" method="post">
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">邮箱:</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" name="registerEmail" placeholder="邮箱地址" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">姓名:</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" name="name" placeholder="姓名" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">地址:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="address"  placeholder="地址" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="gender" value="男" checked>
                                        男
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="gender" value="女">
                                        女
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">职业:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="profession" placeholder="职业" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" name="password" placeholder="密码" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-2 control-label">重复密码:</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" name="confirmPassword" placeholder="重复密码" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="button" class="btn btn-default" onclick="register()">注册</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/common/js.ftl"/>
<script src="${base}/res/js/dialog/layer.js"></script>
<script src="${base}/res/js/dialog/dialog.js"></script>
<script>
    //前端
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
</body>
</html>
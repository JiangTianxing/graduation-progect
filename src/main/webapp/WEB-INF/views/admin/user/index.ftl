<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/css.ftl"/>
</head>
<body>
<div class="container">
    <div class="row">
        <h3 class="text-center">
            法律人信息交流平台
        </h3>
        <div class="col-md-12">
        <#include "/admin/common/nav.ftl"/>
            <div class="span12">
                <div class="span12">
                    <div class="tabbable" id="tabs-520072">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#panel-734248" data-toggle="tab">显示</a>
                            </li>
                            <li>
                                <a href="#panel-397699" data-toggle="tab">更改</a>
                            </li>
                        </ul>

                        <div class="tab-content">
                            <div class="tab-pane" id="panel-397699">
                            <#include "/admin/user/update.ftl"/>
                            </div>
                            <div class="tab-pane active" id="panel-734248">
                            <#include "/admin/user/display.ftl"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/common/js.ftl"/>
<script>
    var update = function () {
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
        var url = '${base}/admin/user/update';
        dialog.post(url, data);
    }
</script>
</body>
</html>
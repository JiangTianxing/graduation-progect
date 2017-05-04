<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>${SITE_NAME}</title>
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
<#include "/common/js.ftl"/>
<script src="${base}/res/js/dialog/layer.js"></script>
<script src="${base}/res/js/dialog/dialog.js"></script>
<script>
    //前端
    var user = {
        update:function () {
            var name = $('input[name="name"]').val();
            var email = $('input[name="registerEmail"]').val();
            var address = $('input[name="address"]').val();
            var gender = $('input[name="gender"]:checked').val();
            var profession = $('input[name="profession"]').val();
            var confirmPassword = $('input[name="confirmPassword"]').val();
            var password = $('input[name="password"]').val();
            var data = {'name' : name, 'email' : email, 'address' : address, 'gender': gender, 'profession' : profession, 'confirmPassword' : confirmPassword, 'password' : password};
            console.log(data);
            var url =  '${base}/admin/user/update/';
            $.post(url, data, function (result) {
                if (result.status == 200) {
                    dialog.success(result.message, result.data.url);
                } else {
                    dialog.error(result.message);
                }
            })
        }
    }
</script>
</body>
</html>
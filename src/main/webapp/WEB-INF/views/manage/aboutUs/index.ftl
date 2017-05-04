<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/css.ftl"/>

</head>
<body>
<div class="container">
    <div class="row">
        <h3 class="text-center">法律人信息交流平台</h3>
        <div class="col-md-12">
        <#include "/manage/common/nav.ftl"/>
        </div>
        <div class="span12">
            <div class="tabbable" id="tabs-520072">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#panel-734248" data-toggle="tab">显示</a>
                    </li>
                    <li>
                        <a href="#panel-397699" data-toggle="tab">添加</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane" id="panel-397699">
                    <#include "/manage/aboutUs/update.ftl"/>
                    </div>
                    <div class="tab-pane active" id="panel-734248">
                    <#include "/manage/aboutUs/display.ftl"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/common/js.ftl"/>
<script>
    var update = function () {
        var phone = $('input[name="phone"]').val();
        var address = $('input[name="address"]').val();
        var code = $('input[name="code"]').val();
        var copyright = $('input[name="copyright"]').val();
        var thought = $('textarea[name="thought"]').val();

        var data = {
            'phone': phone,
            'address': address,
            'code': code,
            'copyright': copyright,
            'thought': thought
        };
        var url = '${base}/manage/aboutUs/update';
        dialog.post(url, data);
    }
</script>
</body>
</html>
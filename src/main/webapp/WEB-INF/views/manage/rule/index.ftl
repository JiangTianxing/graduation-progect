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
                    <#include "/manage/rule/add.ftl"/>
                    </div>
                    <div class="tab-pane active" id="panel-734248">
                    <#include "/manage/rule/display.ftl"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/common/js.ftl"/>
<script>
    var add = function () {
        var url = '${base}/manage/rule/save';
        var data = new FormData(document.getElementById("add-rule"));
        $.ajax({
            url: url,
            type: 'POST',
            data: data,
            cache: false,
            processData: false,
            contentType: false,
            success: function (result) {
                if (result.status != 200) {
                    dialog.error(result.message);
                } else {
                    dialog.success(result.message, result.data.url);
                }
            },
            error : function () {
                dialog.error("无法提交信息");
            }
        });
    }
    var load = function (id, title, description) {
        $('#hidden-window-id').val(id);
        $('#hidden-window-title').val(title);
        $('#hidden-window-description').val(description);
    }
    var update = function (id) {
        var url = '${base}/manage/rule/update';
        var data = new FormData(document.getElementById("hidden-update-rule" + id));
        $.ajax({
            url: url,
            type: 'POST',
            data: data,
            cache: false,
            processData: false,
            contentType: false,
            success: function (result) {
                if (result.status != 200) {
                    dialog.error(result.message);
                } else {
                    dialog.success(result.message, result.data.url);
                }
            },
            error : function () {
                dialog.error("无法提交信息");
            }
        })
    }
</script>
</body>
</html>
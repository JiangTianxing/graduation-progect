<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>${SITE_NAME}</title>
    <#include "/common/css.ftl"/>
    <link rel="stylesheet" href="${base}/res/js/kindeditor/themes/default/default.css" />
    <link rel="stylesheet" href="${base}/res/js/kindeditor/plugins/code/prettify.css" />
    <script charset="utf-8" src="${base}/res/js/kindeditor/kindeditor.js"></script>
    <script charset="utf-8" src="${base}/res/js/kindeditor/lang/zh_CN.js"></script>
    <script charset="utf-8" src="${base}/res/js/kindeditor/plugins/code/prettify.js"></script>
    <script>
        KindEditor.ready(function(K) {
            window.editor = K.create('#editor-content',{
                uploadJson : '${base}/common/kindeditor/upload',
                afterBlur : function(){this.sync();}
            });
        });
    </script>
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
                            <a href="#panel-397699" data-toggle="tab">添加</a>
                        </li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane" id="panel-397699">
                            <#include "/admin/message/add.ftl"/>
                        </div>
                        <div class="tab-pane active" id="panel-734248">
                            <#include "/admin/message/display.ftl"/>
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
    var update = {
        post: function () {
            var url = '${base}/admin/message/save';
            var title = $('input[name="title"]').val();
            var content = $('textarea[name="content"]').val();
            var data = {'title' : title, 'content' : content};
            $.post(url, data, function (result) {
                if (result.status != 200) {
                    dialog.error(result.message);
                } else {
                    dialog.success(result.message, result.data.url);
                }
            }, 'json');
        },
        update : function () {
            var url = '${base}/manage/news/update';
            var data = new FormData(document.getElementById("hidden-update-news"));
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
        },
        load : function (id, title, description) {
            $('#hidden-window-id').val(id);
            $('#hidden-window-title').val(title);
            $('#hidden-window-description').val(description);
        }
    };
</script>
</body>
</html>
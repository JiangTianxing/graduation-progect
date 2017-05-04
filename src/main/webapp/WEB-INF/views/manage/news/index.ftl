<!DOCTYPE html>
<html lang="zh-cn">
<head>
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
                    <#include "/manage/news/add.ftl"/>
                    </div>
                    <div class="tab-pane active" id="panel-734248">
                    <#include "/manage/news/display.ftl"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "/common/js.ftl"/>
<script>
    var add = function () {
        var title = $('input[name="title"]').val();
        var type = $('input[name="type"]').val();
        var content = $('textarea[name="content"]').val();

        var url = '${base}/manage/news/save';
        var data = {'title' : title, 'type' : type, 'content' : content};
        dialog.post(url, data);
    }
</script>
</body>
</html>
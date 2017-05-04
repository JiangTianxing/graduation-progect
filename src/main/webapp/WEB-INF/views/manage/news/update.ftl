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
        <div class="span12">

            <form method="post" id="news-upload" name="news-upload">
                <input type="hidden" name="id" value="${news.id}">
                <div class="form-group">
                    <label>标题</label>
                    <input type="text" class="form-control" name="title" placeholder="标题" value="${news.title}">
                </div>
                <div class="form-group">
                    <label>类型</label>
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" value="4" <#if news.type=4>checked</#if>>民法
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" value="3" <#if news.type=3>checked</#if>>行政
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" value="2" <#if news.type=2>checked</#if>>刑法
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" value="1" <#if news.type=1>checked</#if>>法史
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputFile">内容</label>
                        <textarea name="content" id="editor-content" class="form-control" style="width:1000px;height:570px;visibility:hidden;">${news.content}</textarea>
                    </div>
                </div>
                <button type="button" class="btn btn-default" onclick="post()">提交</button>
            </form>

        </div>
    </div>
</div>
<#include "/common/js.ftl"/>
<script>
    var post = function () {
        var url = '${base}/manage/news/update';
        var id = $('input[name="id"]').val();
        var title = $('input[name="title"]').val();
        var type = $('input[name="type"]:checked').val();
        var content = $('textarea[name="content"]').val();
        var data = {'id' : id, 'title' : title, 'type' : type, 'content' : content};
        $.post(url, data, function (result) {
            if (result.status != 200) {
                dialog.error(result.message);
            } else {
                layer.open({
                    content:result.message,
                    icon:1,
                    title:'修改成功'
                });
            }
        }, 'json');
    }
</script>
</body>
</html>
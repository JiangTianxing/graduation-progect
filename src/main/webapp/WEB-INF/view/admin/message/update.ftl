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
                <form method="post" name="example">
                    <input type="hidden" name="id" value="${message.id}">
                    <input type="hidden" name="contentId" value="${message.contentId}">
                    <div class="form-group">
                        <label>标题</label>
                        <input type="text" class="form-control" name="title" placeholder="标题" value="${message.title}">
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <label for="exampleInputFile">内容</label>
                            <textarea name="content" id="editor-content" class="form-control" style="width:1000px;height:600px;visibility:hidden;">${message.content}</textarea>
                        </div>
                    </div>
                    <button type="button" class="btn btn-default" onclick="update.post()">更新</button>
                </form>
            </div>
        </div>
    </div>
</div>
<#include "/common/js.ftl"/>
<script src="${base}/res/js/dialog/layer.js"></script>
<script src="${base}/res/js/dialog/dialog.js"></script>
<script>
    var update = {
        post : function () {
            var url = '${base}/admin/message/update';
            var id = $('input[name="id"]').val();
            var title = $('input[name="title"]').val();
            var content = $('textarea[name="content"]').val();
            var contentId = $('input[name="contentId"]').val();
            var data = {'id' : id, 'title' : title, 'content' : content, 'contentId': contentId};
            $.post(url, data, function (result) {
                if (result.status != 200) {
                    dialog.error(result.message);
                } else {
                    dialog.success(result.message, result.data.url);
                }
            }, 'json');
        }
    }
</script>
</body>
</html>
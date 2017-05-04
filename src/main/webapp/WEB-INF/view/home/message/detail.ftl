<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>${SITE_NAME}</title>
<#include "/common/css.ftl"/>
    <link href="${base}/res/css/comment.css" rel="stylesheet">
    <script src="${base}/res/js/comment.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
        <#include "/home/common/nav.ftl"/>
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <h3>
                        ${message.title}
                        </h3>
                        <dl>
                            <dt>
                                发布人:${message.name}
                            </dt>
                            <dt>
                                邮箱:${message.email}
                            </dt>
                            <dt>
                            ${message.content}
                            </dt>
                        </dl>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#include "/home/message/comment.ftl"/>
<#include "/home/common/copyright.ftl"/>
</div>
<#include "/common/js.ftl"/>
</body>
</html>
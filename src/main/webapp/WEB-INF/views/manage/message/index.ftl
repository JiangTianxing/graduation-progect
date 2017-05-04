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
        <#include "/manage/common/nav.ftl"/>
            <div class="span12">
            <#include "/manage/message/display.ftl"/>
            </div>
        </div>
    </div>
</div>
<#include "/common/js.ftl"/>
</body>
</html>
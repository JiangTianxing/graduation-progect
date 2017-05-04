<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/css.ftl"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h3>${news.title}</h3>
            <dl>
                <dt>${news.content}</dt>
            </dl>
        </div>
    </div>
<#include "/home/common/copyright.ftl"/>

</div>
<#include "/common/js.ftl"/>
</body>
</html>
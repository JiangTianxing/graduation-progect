<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>${SITE_NAME}</title>
    <#include "/common/css.ftl"/>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <#include "/home/common/nav.ftl"/>

            <div class="jumbotron">
                <h1>
                    法律人信息交流平台
                </h1>
                <p>
                    这是一个开放的平台，任何对法律感兴趣的人都可以享受平台分享的资源
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">了解更多</a>
                </p>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <#include "/home/index/rule.ftl"/>
        <#include "/home/index/message.ftl"/>
    </div>


    <div class="row clearfix">
        <#include "/home/index/news.ftl"/>
    </div>

    <#include "/home/common/copyright.ftl"/>

</div>
<#include "/common/js.ftl"/>
</body>
</html>
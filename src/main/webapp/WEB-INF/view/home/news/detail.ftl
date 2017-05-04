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
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <h3>
                            ${news.title}
                        </h3>
                        <dl>
                            <dt>
                                ${news.content}
                            </dt>
                        </dl>
                    </div>
                </div>
            </div>
        </div>
    </div>

<#include "/home/common/copyright.ftl"/>

</div>
<#include "/common/js.ftl"/>
</body>
</html>
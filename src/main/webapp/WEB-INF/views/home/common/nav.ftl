<ul class="nav nav-tabs">
    <li <#if type='index'>class="active"</#if>>
        <a href="${base}">首页</a>
    </li>
    <li <#if type='rule'>class="active"</#if>>
        <a href="${base}/rule/1">法言法语</a>
    </li>
    <li <#if type='message'>class="active"</#if>>
        <a href="${base}/message/1">律政沙龙</a>
    </li>
    <li <#if type='news'>class="active"</#if>>
        <a href="${base}/news/1">今日说法</a>
    </li>
    <li <#if type='aboutUs'>class="active"</#if>>
        <a href="${base}/aboutUs">关于我们</a>
    </li>
    <li class="dropdown pull-right">
    <#if userSessionData != null>
        <a href="#" data-toggle="dropdown" class="dropdown-toggle">${userSessionData.name}<strong class="caret"></strong></a>
        <ul class="dropdown-menu">
            <li><a href="${base}/admin/">个人中心</a></li>
            <li><a href="${base}/admin/logout">退出</a></li>
        </ul>
    <#elseif managerSessionData != null>
        <a href="#" data-toggle="dropdown" class="dropdown-toggle">后台管理<strong class="caret"></strong></a>
        <ul class="dropdown-menu">
            <li><a href="${base}/manage/">管理页</a></li>
            <li><a href="${base}/manage/logout">退出</a></li>
        </ul>
    <#else>
        <a href="#" data-toggle="dropdown" class="dropdown-toggle">用户中心<strong class="caret"></strong></a>
        <ul class="dropdown-menu">
            <li><a href="#" role="button" onclick="loginLoad()">登录</a></li>
            <li><a href="#" role="button" onclick="registerLoad()">注册</a></li>
        </ul>
    </#if>
    </li>
</ul>
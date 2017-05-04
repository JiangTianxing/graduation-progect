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
        <a href="#" data-toggle="dropdown" class="dropdown-toggle">后台管理<strong class="caret"></strong></a>
        <ul class="dropdown-menu">

        <#if userSessionData != null>
            <li>
                <a href="${base}/admin/">个人中心</a>
            </li>
            <li>
                <a href="${base}/">前台首页</a>
            </li>
            <li class="divider">
            </li>
            <li>
                <a href="${base}/manage/login">管理员登录</a>
            </li>

        <#elseif managerSessionData != null>
            <li>
                <a href="${base}/manage/">后台首页</a>
            </li>
            <li>
                <a href="${base}/manage/aboutUs">关于我们</a>
            </li>
            <li>
                <a href="${base}/manage/logout">退出</a>
            </li>
        <#else>
            <li>
                <a href="#" role="button" onclick="loadUrl('${base}/admin/login')">用户登录</a>
            </li>
            <li>
                <a href="#" role="button" onclick="loadUrl('${base}/manage/login')">管理员登录</a>
            </li>
        </#if>
        </ul>
    </li>
</ul>
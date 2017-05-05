<ul class="nav nav-tabs">
    <li <#if type='index'>class="active"</#if>>
        <a href="${base}/admin/">首页</a>
    </li>
    <li <#if type='message'>class="active"</#if>>
        <a href="${base}/admin/message/">律政沙龙</a>
    </li>
    <li <#if type='user'> class="active" </#if>>
        <a href="${base}/admin/user/">个人信息</a>
    </li>

    <li class="dropdown pull-right">
        <a href="#" data-toggle="dropdown" class="dropdown-toggle">${userSessionData.name}<strong class="caret"></strong></a>
        <ul class="dropdown-menu">
            <li><a href="${base}/">前台首页</a></li>
            <li><a href="${base}/admin/logout">退出</a></li>
        </ul>
    </li>
</ul>
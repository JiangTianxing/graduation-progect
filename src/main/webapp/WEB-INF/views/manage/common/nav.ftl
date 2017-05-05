<ul class="nav nav-tabs">
    <li <#if type='index'>class="active"</#if>>
        <a href="${base}/manage/">首页</a>
    </li>
    <li <#if type='rule'>class="active"</#if>>
        <a href="${base}/manage/rule/">法律法规</a>
    </li>
    <li <#if type='news'>class="active"</#if>>
        <a href="${base}/manage/news/">今日说法</a>
    </li>
    <li <#if type='message'>class="active"</#if>>
        <a href="${base}/manage/message/">律政沙龙</a>
    </li>
    <li <#if type='user'> class="active" </#if>>
        <a href="${base}/manage/user/1">用户管理</a>
    </li>
    <li <#if type='aboutUs'>class="active"</#if>>
        <a href="${base}/manage/aboutUs/">关于我们</a>
    </li>

    <li class="dropdown pull-right">
        <a href="#" data-toggle="dropdown" class="dropdown-toggle">个人中心<strong class="caret"></strong></a>
        <ul class="dropdown-menu">
            <li>
                <a href="${base}/">前台首页</a>
            </li>
            <li>
                <a href="${base}/manage/logout">退出</a>
            </li>
        </ul>
    </li>
</ul>
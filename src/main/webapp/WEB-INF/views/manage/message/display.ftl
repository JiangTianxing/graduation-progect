<table class="table">
    <thead>
    <tr>
        <th>标题</th>
        <th>发布人</th>
        <th>邮箱</th>
        <th>发布时间</th>
        <th>当前状态</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <#list page.items as msg>
    <tr>
        <td><a href="#" role="button" onclick="loadUrl('${base}/message/detail/${msg.id}')">${msg.title}</a></td>
        <td>${msg.name}</td>
        <td>${msg.email}</td>
        <td>${msg.savetime?string("yyyy年MM月dd日 HH:mm:ss")}</td>
        <td>
            <a href="${base}/manage/message/change/${msg.id}">
                <#if msg.status=2>正常</#if>
                <#if msg.status=0>删除</#if>
            </a>
        </td>
        <td>
            <a href="${base}/manage/message/delete/${msg.id}"><span class="glyphicon glyphicon-remove"></span></a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
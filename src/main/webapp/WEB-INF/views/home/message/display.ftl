<table class="table">
    <thead>
    <tr>
        <th>标题</th>
        <th>发布时间</th>
        <th>发布人</th>
        <th>邮箱</th>
    </tr>
    </thead>
    <tbody>
    <#list messages.items as msg>
    <tr>
        <td><a href="#" role="button" onclick="loadUrl('${base}/message/detail/${msg.id}')">${msg.title}</a></td>
        <td>${msg.savetime?string("yyyy年MM月dd日 HH:mm:ss")}</td>
        <td>${msg.name}</td>
        <td>${msg.email}</td>
    </tr>
    </#list>
    </tbody>
</table>
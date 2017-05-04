<table class="table">
    <thead>
    <tr>
        <th>用户名</th>
        <th>邮箱</th>
        <th>性别</th>
        <th>职业</th>
        <th>地址</th>
        <th>当前状态</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <#list page.items as user>
    <tr>
        <td>
        ${user.name}
        </td>
        <td>
        ${user.email}
        </td>
        <td>
            <#if user.gender=0>男
            <#else>女</#if>
        </td>
        <td>${user.profession}</td>
        <td>${user.address}</td>
        <td>
            <a href="${base}/manage/user/change/${user.id}">
                <#if user.status=2>正常
                <#elseif user.status=0>删除
                <#else>审核</#if>
            </a>
        </td>
        <td>
            <a href="${base}/manage/user/delete/${user.id}"><span class="glyphicon glyphicon-remove"></span></a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
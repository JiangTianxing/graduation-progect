<table class="table">
    <thead>
    <tr>
        <th>
            标题
        </th>
        <th>
            发布时间
        </th>
        <th>
            当前状态
        </th>
        <th>
            编辑
        </th>
        <th>
            删除
        </th>
    </tr>
    </thead>
    <tbody>
        <#list page.items as message>
            <tr>
                <td>
                    ${message.title}
                </td>
                <td>
                    ${message.savetime?string("yyyy年MM月dd日 HH:mm:ss")}
                </td>
                <td>
                    <a href="${base}/admin/message/change/${message.id}">
                        <#if message.status=2>
                            正常
                        <#elseif message.status=0>
                            删除
                        <#else>
                            审核
                        </#if>
                    </a>
                </td>
                <td>
                    <a href="${base}/admin/message/update/${message.id}">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </a>
                </td>
                <td>
                    <a href="${base}/admin/message/delete/${message.id}">
                        <span class="glyphicon glyphicon-remove"></span>
                    </a>
                </td>
            </tr>
        </#list>
    </tbody>
</table>
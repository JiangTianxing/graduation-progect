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
            更新时间
        </th>
    </tr>
    </thead>
    <tbody>
    <#list news.items as new>
    <tr>
        <td>
            <a href="${base}/news/detail/${new.id}">
            ${new.title}
            </a>
        </td>
        <td>
            ${new.savetime?string("yyyy年MM月dd日 HH:mm:ss")}
        </td>
        <td>
            ${new.updatetime?string("yyyy年MM月dd日 HH:mm:ss")}
        </td>
    </tr>
    </#list>
    </tbody>
</table>
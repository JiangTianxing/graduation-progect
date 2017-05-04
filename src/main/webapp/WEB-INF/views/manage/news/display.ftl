<table class="table">
    <thead>
    <tr>
        <th>
            标题
        </th>
        <th>
            类型
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
    <#list page.items as news>
    <tr>
        <td><a href="#" role="button" onclick="loadUrl('${base}/news/detail/${news.id}')">${news.title}</a></td>
        <td><#if news.title="4">民法<#elseif news.title="3">行政<#elseif news.title="2">刑法<#else>法史</#if></td>
        <td>${news.savetime?string("yyyy年MM月dd日 HH:mm:ss")}</td>
        <td>
            <a href="${base}/manage/news/change/${news.id}">
                <#if news.status=2>正常<#elseif news.status=0>删除<#else>审核</#if>
            </a>
        </td>
        <td>
            <a href="#" role="button" onclick="loadUrl('${base}/manage/news/update/${news.id}')">
                <span class="glyphicon glyphicon-pencil"></span>
            </a>
        </td>
        <td>
            <a href="${base}/manage/news/delete/${news.id}">
                <span class="glyphicon glyphicon-remove"></span>
            </a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
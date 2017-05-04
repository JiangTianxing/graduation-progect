<#include "/manage/rule/hidden.ftl"/>
<table class="table">
    <thead>
    <tr>
        <th>标题</th>
        <th>发布时间</th>
        <th>当前状态</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <#list page.items as rule>
    <tr>
        <td>${rule.title}</td>
        <td>${rule.savetime?string("yyyy年MM月dd日 HH:mm:ss")}</td>
        <td>
            <a href="${base}/manage/rule/change/${rule.id}">
                <#if rule.status=2>正常</#if>
                <#if rule.status=0>删除</#if>
            </a>
        </td>
        <td>
            <a id="modal-1" href="#modal-container" role="button" class="btn" data-toggle="modal" onclick="load('${rule.id}', '${rule.title}', '${rule.description}')">
                <span class="glyphicon glyphicon-pencil"></span>
            </a>
        </td>
        <td>
            <a href="${base}/manage/rule/delete/${rule.id}">
                <span class="glyphicon glyphicon-remove"></span>
            </a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
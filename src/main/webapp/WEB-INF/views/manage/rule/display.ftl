
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
        <td><a id="modal-1" href="#modal-container-${rule.id}" role="button" class="btn" data-toggle="modal">${rule.title}</a></td>
        <td>${rule.savetime?string("yyyy年MM月dd日 HH:mm:ss")}</td>
        <td>
            <a href="${base}/manage/rule/change/${rule.id}">
                <#if rule.status=2>正常</#if>
                <#if rule.status=0>删除</#if>
            </a>
        </td>
        <td>
            <#include "/manage/rule/hidden.ftl"/>
        </td>
        <td>
            <a href="${base}/manage/rule/delete/${rule.id}">
                <span class="glyphicon glyphicon-remove"></span>
            </a>
        </td>
        <div class="modal fade" id="modal-container-${rule.id}" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="hidden-window-title">${rule.title}</h4>
                    </div>
                    <div class="modal-body">
                        <p id="hidden-window-description">${rule.description}</p>
                    </div>
                    <div class="modal-footer">
                        <a href="${base}/rule/download/${rule.md5}" id="hidden-window-md5">
                            <button type="button" class="btn btn-primary">下载</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </tr>
    </#list>
    </tbody>
</table>
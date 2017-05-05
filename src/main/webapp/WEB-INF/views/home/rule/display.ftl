<table class="table">
    <thead>
    <tr>
        <th>标题</th>
        <th>发布时间</th>
        <th>最近更新</th>
    </tr>
    </thead>
    <tbody>
    <#list page.items as rule>
    <tr>
        <td><a id="modal-1" href="#modal-container-${rule.id}" role="button" class="btn" data-toggle="modal">${rule.title}</a></td>
        <td>${rule.savetime?string("yyyy年MM月dd日 HH:mm:ss")}</td>
        <td>${rule.updatetime?string("yyyy年MM月dd日 HH:mm:ss")}</td>
    </tr>
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
                    <#if userSessionData != null || managerSessionData != null>
                        <a href="${base}/rule/download/${rule.md5}" id="hidden-window-md5">
                            <button type="button" class="btn btn-primary">下载</button>
                        </a>
                    <#else>
                        <button type="button" class="btn btn-primary close" data-dismiss="modal" aria-label="Close">
                            登陆后下载
                        </button>
                    </#if>
                </div>
            </div>
        </div>
    </div>
    </#list>
    </tbody>
</table>
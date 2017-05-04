<div class="col-md-6 column">
    <h3 class="text-center">法言法语</h3>
    <div class="panel panel-default">
    <#list rules as rule>
        <div class="panel-body">
            <a id="modal-1" href="#modal-container-${rule.id}" role="button" class="btn" data-toggle="modal">
                ${rule.title}
            </a>
            <span>${rule.savetime?string("yyyy年MM月dd日 HH:mm:ss")}</span>
        </div>

        <div class="modal fade" id="modal-container-${rule.id}" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="hidden-title">${rule.title}</h4>
                    </div>
                    <div class="modal-body">
                        <p id="hidden-description">${rule.description}</p>
                    </div>
                    <div class="modal-footer">
                        <#if userSessionData != null || managerSessionData != null>
                            <a href="${base}/rule/download/${rule.md5}" id="hidden-md5">
                                <button type="button" class="btn btn-primary">下载</button>
                            </a>
                        <#else>
                            <a href="${base}/admin/login">
                                <button type="button" class="btn btn-primary">
                                    登陆后下载
                                </button>
                            </a>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </#list>
    </div>
</div>
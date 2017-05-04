<div class="col-md-6 column">
    <h3 class="text-center">律政沙龙</h3>
    <div class="panel panel-default">
        <#list message as msg>
            <div class="panel-body">
                <a href="${base}/message/detail/${msg.id}">${msg.title}</a>
                <span>${msg.name}</span>
                发表于<span>${msg.savetime?string("yyyy年MM月dd日 HH:mm:ss")}</span>
            </div>
        </#list>
    </div>
</div>
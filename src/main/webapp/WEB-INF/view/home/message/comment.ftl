<div id="list">
    <div class="box clearfix">
    <#macro listComment children>
        <#list children as child>

            <div class="comment-list">
                <div class="comment-box clearfix" user="self">
                    <div class="comment-content">
                        <p class="comment-text"><span class="user">${child.name}：</span>${child.content}</p>
                        <p class="comment-time">${child.savetime?string("yyyy年MM月dd日 HH:mm:ss")}</p>
                    </div>
                </div>
            </div>
            <#if child.reply?? && child.reply?size gt 0>
                <@listComment children=child.reply></@listComment>
            </#if>
        </#list>
    </#macro>
    <@listComment children=comments></@listComment>
    </div>
</div>
<div id="list">
<#if userSessionData != null>
    <div class="box clearfix">
        <#macro listComment children>
            <#list children as child>
                <div class="comment-list" id="comment-${child.id}">
                    <div class="comment-box clearfix" user="self">
                        <div class="comment-content">
                            <p class="comment-text"><span class="user" id="comment-user-${child.id}">${child.name} <span class="reply-to" id="${child.pid}"></span>：</span>${child.content}</p>
                            <p class="comment-time">
                            ${child.savetime?string("yyyy年MM月dd日 HH:mm:ss")}
                                <#if message.userId == userSessionData.id>
                                    <#if child.email != userSessionData.email>
                                        <a href="javascript:;" class="comment-comment" type="button" onclick="loadComment('${child.id}', '${userSessionData.name}', '${userSessionData.email}')">回复</a>
                                    </#if>
                                    <a href="javascript:;" class="comment-operate" onclick="deleteComment('${child.id}')">删除</a>
                                </#if>
                            </p>
                        </div>
                    </div>
                </div>
                <#if child.reply?? && child.reply?size gt 0>
                    <@listComment children=child.reply></@listComment>
                </#if>
            </#list>
        </#macro>
        <#if comments?? && comments?size gt 0 >
            <@listComment children=comments></@listComment>
        </#if>
        <div id="comment-list"></div>
        <div class="text-box">
            <input type="hidden" name="comment-pid" value="0">
            <input type="hidden" name="comment-name" value="${userSessionData.name}">
            <input type="hidden" name="comment-email" value="${userSessionData.email}">
            <textarea class="comment" autocomplete="off" name="comment-content">评论…</textarea>
            <button class="btn btn-primary" type="button" onclick="addComment('${message.id}')">评价</button>
            <span class="word"><span class="length">0</span>/140</span>
        </div>
    </div>
<#else>
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
        <#if comments?? && comments?size gt 0 >
            <@listComment children=comments></@listComment>
        </#if>

    </div>
</#if>
</div>
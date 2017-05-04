<div class="span12">
    <dl class="dl-horizontal">
        <dt>
            邮箱:
        </dt>
        <dd>
        ${user.email}
        </dd>
        <dt>
            姓名:
        </dt>
        <dd>
        ${user.name}
        </dd>
        <dt>
            地址:
        </dt>
        <dd>
        ${user.address}
        </dd>
        <dt>
            性别:
        </dt>
        <dd>
            <#if user.gender = 1>男<#else>女</#if>
        </dd>
        <dt>
            职业:
        </dt>
        <dd>
            ${user.profession}
        </dd>
    </dl>
</div>
<div class="col-md-12 column">
    <h3 class="text-center">今日说法</h3>
    <div class="panel panel-default">
        <#list news as new>
        <div class="panel-body">
            <a href="#" role="button" onclick="loadUrl('${base}/news/detail/${new.id}')">${new.title}</a>
            <span>${new.savetime?string("yyyy年MM月dd日 HH:mm:ss")}</span>
        </div>
        </#list>
    </div>
</div>
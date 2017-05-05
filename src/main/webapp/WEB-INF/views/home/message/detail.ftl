<!DOCTYPE html>
<html lang="zh-cn">
<head>
<#include "/common/css.ftl"/>
    <link href="${base}/res/css/comment.css" rel="stylesheet">
    <script src="${base}/res/js/comment.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="span12">
                <h3>${message.title}</h3>
                <dl>
                    <dt>发布人:${message.name}</dt>
                    <dt>邮箱:${message.email}</dt>
                    <dt>${message.content}</dt>
                </dl>
            </div>
        </div>
    </div>
<#include "/home/message/comment.ftl"/>
<#include "/home/common/copyright.ftl"/>
</div>
<#include "/common/js.ftl">

<script>
    var deleteComment = function (id) {
        var url = '${base}/admin/message/comment/delete/' + id;
        $.post(url, null, function (result) {
            if(result.status == 200) {
                $('#comment-' + id).remove();
            }
        }, 'json');
    }
    var addComment = function (id) {
        var pid = $("input[name='comment-pid']").val();
        var content = $("textarea[name='comment-content']").val();
        var name = $("input[name='comment-name']").val();
        var email = $("input[name='comment-email']").val();
        var data = {'pid':pid, 'content':content, 'name':name, 'email':email};
        var url = '${base}/admin/message/comment/' + id;
        postComment(url, data);
    }
    var postComment = function (url, data) {
        $.post(url, data, function (result) {
            if (result.status == 200) {
                var comment = result.data.data;
                var time = getTime();
                if (comment.pid == '0') {
                    var html = '<div class="comment-list" id="comment-' + comment.id + '"><div class="comment-box clearfix" user="self"><div class="comment-content"><p class="comment-text"><span class="user">' + comment.name + '：</span>' + comment.content + '</p><p class="comment-time">' + time + '<a href="javascript:;" class="comment-operate" onclick="deleteComment(' + comment.id + ')">删除</a></p></div></div></div>'
                    $('#comment-list').append(html);
                } else{
                    var pname = $('#comment-user-' + comment.pid).text();
                    var html = '<div class="comment-list" id="comment-' + comment.id + '"><div class="comment-box clearfix" user="self"><div class="comment-content"><p class="comment-text"><span class="user">' + comment.name + ' 回复 '+pname+'：</span>' + comment.content + '</p><p class="comment-time">' + time + '<a href="javascript:;" class="comment-operate" onclick="deleteComment(' + comment.id + ')">删除</a></p></div></div></div>'
                    $('#comment-'+comment.pid).append(html);
                }
            }
        }, 'json');
    }
    var getTime = function () {
        var date = new Date();
        var year = date.getFullYear();
        var month = (date.getMonth() > 9 ? '' : '0') + date.getMonth();
        var day = (date.getDay() > 9 ? '' : '0') + date.getDay();
        var hour = (date.getHours() > 9 ? '' : '0') + date.getHours();
        var minute = (date.getMinutes() > 9 ? '' : '0') + date.getMinutes();
        var second = (date.getSeconds() > 9 ? '' : '0') + date.getSeconds();
        return year + '年'+ month + '月'+ day + '日 '+ hour + ':'+ minute+ ':'+ second;
    }
    var loadComment = function (id, name, email) {
            layer.prompt({title: '评论', formType: 2}, function(content, index){
                layer.close(index);
                var url = '${base}/admin/message/comment/' + id;
                var data = {'pid':id, 'name':name, 'email':email, 'content':content};
                postComment(url, data);
            });
    }
</script>
</body>
</html>
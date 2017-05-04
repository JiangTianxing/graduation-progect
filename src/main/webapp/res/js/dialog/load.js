var loadUrl = function (url) {
    layer.open({
        type: 2,
        title: '法律人',
        shadeClose: true,
        shade: 0.8,
        area: ['1150px', '90%'],
        content: url,
        closeBtn : 0
    });
}
var loadHtml = function (content) {
    layer.open({
        type: 1,
        skin: 'layui-layer-rim', //加上边框
        area: ['420px', '240px'], //宽高
        content: content
    });
}
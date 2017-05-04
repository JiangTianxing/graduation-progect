<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>UploadiFive Test</title>
    <script src="${base}/js/jquery.js" type="text/javascript"></script>
    <script src="${base}/js/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${base}/js/uploadify/uploadify.css">
    <style type="text/css">
        body {
            font: 13px Arial, Helvetica, Sans-serif;
        }
    </style>
</head>

<body>
<h1>Uploadify Demo</h1>
<form class="form-horizontal">
    <div class="form-group">
        <label for="inputname" class="col-sm-2 control-label">缩图:</label>
        <div class="col-sm-5">
            <input id="file_upload"  type="file" multiple="true" >
            <img style="display: none" id="upload_org_code_img" src="" width="150" height="150">
            <input id="file_upload_image" name="thumb" type="hidden" multiple="true" value="">
        </div>
    </div>
</form>
<script type="text/javascript">
    $(function() {
        $('#file_upload').uploadify({
            'swf'      : SCOPE.ajax_upload_swf,
            'uploader' : SCOPE.ajax_upload_image_url,
            'buttonText': '上传图片',
            'fileTypeDesc': 'Image Files',
            'fileObjName' : 'file',
            //允许上传的文件后缀
            'fileTypeExts': '*.gif; *.jpg; *.png',
            'onUploadSuccess' : function(file,data,response) {
                // response true ,false
                if(response) {
                    var obj = JSON.parse(data); //由JSON字符串转换为JSON对象

                    console.log(data);
                    $('#' + file.id).find('.data').html(' 上传完毕');

                    $("#upload_org_code_img").attr("src",obj.data);
                    $("#file_upload_image").attr('value',obj.data);
                    $("#upload_org_code_img").show();
                }else{
                    alert('上传失败');
                }
            },
        });
    });
</script>
</body>
</html>
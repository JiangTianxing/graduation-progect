<form method="post" id="add-rule">
    <div class="form-group">
        <label>标题</label>
        <input type="text" class="form-control" name="title" placeholder="标题"">
    </div>
    <div class="form-group">
        <label>相关描述</label>
        <textarea class="form-control" type="text" name="description" rows="3" placeholder="相关描述"></textarea>
    </div>
    <div class="form-group">
        <label for="exampleInputFile">文件上传</label>
        <input type="file" id="exampleInputFile" name="file">
    </div>
    <button type="button" class="btn btn-default" onclick="add()">提交</button>
</form>
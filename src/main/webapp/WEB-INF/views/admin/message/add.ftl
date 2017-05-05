<form method="post" id="addRule" name="example">
    <div class="form-group">
        <label>标题</label>
        <input type="text" class="form-control" name="title" placeholder="标题"">
    </div>
    <div class="form-group">
        <label for="exampleInputFile">内容</label>
        <textarea name="content" id="editor-content" class="form-control" style="width:1000px;height:600px;visibility:hidden;"></textarea>
    </div>
    <button type="button" class="btn btn-default" onclick="update.post()">提交</button>
</form>
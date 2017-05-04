<form method="post" id="addRule" name="example">
    <div class="form-group">
        <label>标题</label>
        <input type="text" class="form-control" name="title" placeholder="标题"">
    </div>
    <div class="form-group">
        <label>类型</label>
        <div class="radio">
            <label>
                <input type="radio" name="type" value="4" checked>民法
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="type" value="3" checked>行政
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="type" value="2" checked>刑法
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="type" value="1" checked>法史
            </label>
        </div>
    </div>
    <div class="form-group">
        <label for="exampleInputFile">内容</label>
        <textarea name="content" id="editor-content" class="form-control" style="width:1000px;height:600px;visibility:hidden;"></textarea>
    </div>
    <button type="button" class="btn btn-default" onclick="add()">提交</button>
</form>
<a id="modal-1" href="#modal-container-update-${rule.id}" role="button" class="btn" data-toggle="modal">
    <span class="glyphicon glyphicon-pencil"></span>
</a>
<div id="hidden-window">
    <div class="modal fade" id="modal-container-update-${rule.id}" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">
                        法律法规编辑:
                    </h4>
                </div>
                <form method="post" id="hidden-update-rule${rule.id}">
                    <div class="modal-body">
                        <input type="hidden" name="id" id="hidden-window-id" value="${rule.id}">
                        <div class="form-group">
                            <label>标题</label>
                            <textarea type="text" class="form-control" name="title" placeholder="标题" id="hidden-window-title" rows="1">${rule.title}</textarea>
                        </div>
                        <div class="form-group">
                            <label>相关描述</label>
                            <textarea type="text" class="form-control" name="description" placeholder="相关描述" id="hidden-window-description">${rule.description}</textarea>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputFile">文件上传</label>
                            <input type="file" id="exampleInputFile" name="file">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" onclick="update('${rule.id}')">保存</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
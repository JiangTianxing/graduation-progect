<form method="post">
    <div class="form-group">
        <label>电话号码</label>
        <input type="text" class="form-control" name="phone" placeholder="电话号码" value="${web.phone}">
    </div>
    <div class="form-group">
        <label>地址</label>
        <input type="text" class="form-control" name="address" placeholder="地址" value="${web.address}">
    </div>
    <div class="form-group">
        <label>邮政编码</label>
        <input type="text" class="form-control" name="code" placeholder="邮政编码" value="${web.code}">
    </div>
    <div class="form-group">
        <label>版权所有</label>
        <input type="text" class="form-control" name="copyright" placeholder="版权所有" value="${web.copyright}">
    </div>
    <div class="form-group">
        <label>设计初衷</label>
        <textarea class="form-control" id="textarea" name="thought" rows="5">${web.thought}</textarea>
    </div>
    <button type="button" class="btn btn-default" onclick="update()">提交</button>
</form>
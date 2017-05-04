<form class="form-horizontal" role="form" method="post">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">邮箱:</label>
        <div class="col-sm-10">
            <input type="email" class="form-control" name="registerEmail" placeholder="邮箱地址" />
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">姓名:</label>
        <div class="col-sm-10">
            <input type="email" class="form-control" name="name" placeholder="姓名" />
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">地址:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="address"  placeholder="地址" />
        </div>
    </div>
    <div class="form-group">
        <div class="radio">
            <label>
                <input type="radio" name="gender" value="男" checked>
                男
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="gender" value="女">
                女
            </label>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">职业:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="profession" placeholder="职业" />
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" name="password" placeholder="密码" />
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">重复密码:</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" name="confirmPassword" placeholder="重复密码" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-default" onclick="register()">注册</button>
        </div>
    </div>
</form>
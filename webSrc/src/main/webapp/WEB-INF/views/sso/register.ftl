<#include "/layout/layout.ftl"  encoding='utf-8'>

<@htmlHead title="欢迎注册你的日记" >

</@htmlHead>
<@htmlBody>
<form action="/sso/register.do" method="post" class="form-horizontal" role="form">
    <div class="form-group">
        <legend>欢迎注册你的日记</legend>
    </div>
    <#list errors as error>
        <div class="alert alert-danger">
        	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        	<strong>Error:</strong> ${error}
        </div>
    </#list>

    <div class="form-group">
        <label for="nickName" class="col-sm-2 control-label">昵称</label>
        <div class="col-sm-10">
            <input type="text" name="nickName" class="form-control" id="nickName" placeholder="昵称">
        </div>
    </div>

    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
            <input type="text" name="email" class="form-control" id="email" placeholder="Email">
        </div>
    </div>

    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" name="password" class="form-control" id="password" placeholder="Password">
        </div>
    </div>

    <div class="form-group">
        <label for="rePassword" class="col-sm-2 control-label">重复密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="rePassword" placeholder="再输一次密码">
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-10 col-sm-offset-2">
            <button type="submit" class="btn btn-primary">注册</button>
        </div>
    </div>
</form>
</@htmlBody>
<#include "/layout/layout.ftl"  encoding='utf-8'>
<@htmlHead title="登录 " >

</@htmlHead>
<h1>hello login</h1>
<@htmlBody>
<div class="alert alert-success">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <strong>注册成功</strong> ${model.nickname!""} 恭喜你注册成功,请尽快去邮箱验证吧.
</div>
</@htmlBody>
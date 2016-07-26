
<#macro htmlHead title charset="utf-8" lang="zh-CN">
<!DOCTYPE html>
<html>
<head>
    <meta charset="${charset}" >
    <title>${title}</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/bootstrap.css">
    <#nested>
</head>
</#macro>

<#macro htmlBody>
<body>
<div class="container">
    <#nested>
</div>

<script src="/resources/js/lib/jquery.js"></script>
<script src="/resources/js/lib/bootstrap.js"></script>
</body>
</html>
</#macro>
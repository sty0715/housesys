<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/6/25
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/house.js"></script>
</head>
<body>
<table id="dg"></table>
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:update()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:deletemany()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">批量删除</a>
    </div>
    <div>
        标题:<input type="text" name="title" id="stitle">
        面积:<input type="text" name="min_floorage" id="minf">
        &nbsp;<input type="text" name="max_floorage" id="maxf">
        <a href="javascript:search()" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">查询</a>
    </div>
</div>
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 400px; height: 400px; padding: 10px 20px;" closed="true">
    <form id="addForm" method="post">
        <table>
            <tr>
                <td>姓名:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name"  /></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="telephone"  /></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="password"   /></td>
            </tr>


        </table>
    </form>
</div>
<div id="AddDialogButtons">
    <a href="javascript:addDialog()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:Close('AddDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>


<div id="updateDialog" class="easyui-dialog" buttons="#updateDialogButtons"
     style="width: 400px; height: 400px; padding: 10px 20px;" closed="true">
    <form id="updateForm" method="post">
        <table>
            <tr>
                <td>编号:</td>
                <td><input type="text" readonly style="border: none" class="easyui-validatebox" required
                           name="id"   /></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name"   /></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="telephone"   /></td>
            </tr>


        </table>
    </form>
</div>
<div id="updateDialogButtons">
    <a href="javascript:updateDialog()" class="easyui-linkbutton" iconCls="icon-ok">更新</a>
    <a href="javascript:Close('updateDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>


</body>
</html>

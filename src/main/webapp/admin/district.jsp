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
    <script language="JavaScript" src="js/district.js">

    </script>
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
</div>
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 400px; height: 400px; padding: 10px 20px;" closed="true">
    <form id="addForm" method="post">
        <table>
            <tr>
                <td>区域名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name"  id="name" /></td>
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
                           name="id"  id="name2" /></td>
            </tr>
            <tr>
                <td>区域名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name"  id="name1" /></td>
            </tr>

        </table>
    </form>
</div>
<div id="updateDialogButtons">
    <a href="javascript:updateDialog()" class="easyui-linkbutton" iconCls="icon-ok">更新</a>
    <a href="javascript:Close('updateDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>


<div id="StreetDialog" class="easyui-dialog"
     style="width: 500px; height: 350px; padding: 10px 20px;" closed="true">
    <table id="streetdg"></table>
    <hr/>
    <form id="StreetDialogForm"  method="post">
            <tr>
                <td>街道名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" id="bname" /></td>
                <a href="javascript:addStreet()"
                   class="easyui-linkbutton" iconCls="icon-add">添加</a>
            </tr>

    </form>
</div>


</body>
</html>

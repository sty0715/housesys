$(function () {
    $('#dg').datagrid({
        title:"区域信息",
        url:'getDistrictList',
        toolbar:"#ToolBar",
        pagination:true,
        rownumbers:true,
        pageList:[1,2,3,4,5,6],
        pageSize:3,
        columns:[[
            {field:'ck',checkbox:true,title:'编号',width:100},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'街区名',width:100},
            {field:'opt',title:'操作',width:100,formatter:function (value,row,index) {
                    return "<a href=\"javascript:DelDirstrict("+row.id+")\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">删除</a> <a href=\"javascript:showStreetDialog("+row.id+");\">查看街道</a>";                }}

        ]]
    });
})
function Add() {
    $("#AddDialog").dialog("open").dialog("setTitle",">>>>添加区域");
}
function Close(id) {
    $("#"+id).dialog("close");
}
function addDialog() {
    $("#addForm").form('submit', {
        url:"addDistrict",
        success:function(data){
            data=$.parseJSON(data)
            if (data.result==1) {
                Close("AddDialog");
            }else {
                $.messager.alert('提示框','添加失败','info');
            }
        }
    });
}
function update() {
    var rows=$("#dg").datagrid("getSelections");
    if (rows.length!=1) {
        $.messager.alert("提示框","你没有选中或选中多行","info");
        return;
    }
    $("#updateDialog").dialog("open").dialog("setTitle",">>>>更新区域");
    var row=rows[0];
    $.post("getSingleDistrict",{"id":row.id},function (data) {
        $("#updateForm").form('load',data);
    },"json");

}
function updateDialog() {
    $("#updateForm").form('submit', {
        url:"updateDistrict",
        success:function(data){
            data=$.parseJSON(data);
            if (data.result==1) {
                Close("updateDialog");
                $("#dg").datagrid("reload");
            }else {
                $.messager.alert('提示框','修改失败','info');
            }
        }
    });
}
function DelDirstrict(id) {
    $.messager.confirm("提示框","真的要删除吗",function (flag) {
        if (flag) {
            $.post("delDistrict",{"id":id},function (data) {
                if (data.result==1){
                    $("#dg").datagrid("reload");
                }
            },"json");
        }else {
            $.messager.alert("提示框","别瞎××乱点","info");
        }

    });
}
function deletemany() {
    var rows=$("#dg").datagrid("getSelections");
    if (rows.length==0){
        $.messager.alert("提示框","你还没有选中","info");
        return;
    }
    $.messager.confirm('提示框', '你真的想把我删除掉吗？',function(flag){
        if(flag){
            var value="";
            for(var i=0;i<rows.length;i++){
                value=value+rows[i].id+",";
            }
            value=value.substring(0,value.length-1);


            $.post("delDistricts",{"id":value},function(data){
                if(data.result>0){

                    $('#dg').datagrid('reload');
                }else{
                    $.messager.alert('提示框','删除失败！^_^','info');
                }
            },"json");
        }
    });

}

function showStreetDialog(id) {
    $("#StreetDialog").dialog("open").dialog("setTitle",">>>>查看街道");

    $('#streetdg').datagrid({
        title:"街道信息",
        url:'getStreetByDid?id='+id,
        pagination:true,
        rownumbers:true,
        pageList:[1,2,3,4,5],
        pageSize:3,
        columns:[[
            {field:'ck',checkbox:true,width:100,align:'left'},
            {field:'id',title:'编号',width:100,align:'left'},
            {field:'name',title:'街道名称',width:100,align:'left'},
            {field:'opt',title:'操作',width:100,align:'left',
                formatter:function(value,row,index){
                    return "<a href=\"javascript:DelDirstrict("+row.id+")\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">删除</a>";
                }}
        ]]
    });
}


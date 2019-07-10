$(function () {
    $('#dg').datagrid({
        title:"未审核信息",
        url:'getNoPassHouse',
        toolbar:"#ToolBar",
        pagination:true,
        rownumbers:true,
        pageList:[1,2,3,4,5,6],
        pageSize:3,
        columns:[[
            {field:'ck',checkbox:true,title:'编号',width:100},
            {field:'id',title:'编号',width:100},
            {field:'title',title:'标题',width:100},
            {field:'price',title:'价格',width:100},
            {field:'tname',title:'类型',width:100},
            {field:'floorage',title:'面积',width:100,align:'left'},
            {field:'pubdate',title:'发布日期',width:100,formatter: function(value,row,index){
                    var date=new Date(value);
                    var year=date.getFullYear();
                    var month=date.getMonth()+1;
                    var day=date.getDay();
                    return year+"年"+month+"月"+day+"日";
                }},
            {field:'dname',title:'区域',width:100},
            {field:'sname',title:'街道名',width:100},
            {field:'opt',title:'操作',width:100,formatter:function (value,row,index) {
                    return "<a href=\"javascript:pass("+row.id+")\" >审核</a>";
                }}

        ]]
    });
})

function search() {
    var stitle=$("#stitle").val();
    var minf=$("#minf").val();
    var maxf=$("#maxf").val();
    $("#dg").datagrid("load",{"title":stitle,"min_floorage":minf,"max_floorage":maxf});

}
function pass(id) {
    $.post("HouseYes",{"id":id},function(data){
        if(data.result>0)
        {
            $("#dg").datagrid("reload"); //刷新
        }else{
            $.messager.alert('提示框','审核失败！^_^','info');
        }
    },"json");
}




function Add() {
    $("#AddDialog").dialog("open").dialog("setTitle",">>>>添加区域");
}
function Close(id) {
    $("#"+id).dialog("close");
}
function addDialog() {
    $("#addForm").form('submit', {
        url:"addUser",
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
    $.post("getSingleUser",{"id":row.id},function (data) {
        $("#updateForm").form('load',data);
    },"json");

}
function updateDialog() {
    $("#updateForm").form('submit', {
        url:"updateUser",
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
function DelType(id) {
    $.messager.confirm("提示框","真的要删除吗",function (flag) {
        if (flag) {
            $.post("delUser",{"id":id},function (data) {
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


            $.post("delUsers",{"id":value},function(data){
                if(data.result>0){

                    $('#dg').datagrid('reload');
                }else{
                    $.messager.alert('提示框','删除失败！^_^','info');
                }
            },"json");
        }
    });

}
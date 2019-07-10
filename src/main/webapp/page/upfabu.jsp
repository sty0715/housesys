<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
<script language="JavaScript">
  $(function () {
      $.post("getTypes",null,function (data) {
          for (var i=0;i<data.length;i++){
              var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
              $("#typeId").append(node);
          }
          $("#typeId").val(${house.typeId});
      },"json")

      $.post("getDistricts",null,function (data) {
          for (var i=0;i<data.length;i++){
              var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
              $("#district_id").append(node);
              $("#district_id").val(${house.did});
              loadstreet($("#district_id").val());
          }
      },"json");


      $("#district_id").change(function () {
          loadstreet($("#district_id").val());
      });
  });

  function loadstreet(did){
            $.post("getStreetByDid",{"id":did},function (data) {
                $("#street_id>option:gt(0)").remove();
                for (var i=0;i<data.length;i++){
                    var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
                    $("#street_id").append(node);
                }
                $("#street_id").val(${house.streetId});
            },"json");

        }
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post name=add.action action=updateHouse enctype="multipart/form-data">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text value="${house.title}" type=text name=title> </TD></TR>
  <input type="hidden" name="id" value="${house.id}">
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text id="typeId" name=typeId><OPTION selected
        value="">请选择</OPTION>


    </SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage value="${house.floorage}" class=text type=text
name=floorage></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text value="${house.price}" type=text name=price> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    <TD><INPUT class=text type=date name=pubdate value="<fmt:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"></fmt:formatDate>"></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=district_id id="district_id">
      <OPTION value="">请选择</OPTION>

    </SELECT>
      街：<SELECT class=text name=streetId id="street_id">
        <OPTION  value="">请选择</OPTION></SELECT> </TD></TR>

  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact value="${house.contact}" class=text type=text name=contact> </TD></TR>
  <TR>
  <TR>
    <TD class=field>图片：<img width="100" height="100" src="http://localhost:81/${house.path}"></TD>
    <TD><INPUT  class=text type="file" name=pfile> <input type="hidden" value="${house.path}" name="oldPath"> </TD>
  </TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description>${house.description}</TEXTAREA></TD></TR></TBODY></TABLE>
<DIV class=buttons><INPUT  value=更新 type=submit>
</DIV></DIV></FORM>
</DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>

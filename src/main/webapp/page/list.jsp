<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" src="../admin/js/jquery-1.8.3.js"></script>
<script language="JavaScript">
    $(function () {
        $.post("getTypes",null,function (data) {
            for (var i=0;i<data.length;i++){
                var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
                $("#typeId").append(node);
            }
            $("#typeId").val(${searchHouse.title});
        },"json")

        $.post("getDistricts",null,function (data) {
            for (var i=0;i<data.length;i++){
                var node=$("<option value="+data[i].id+">"+data[i].name+"</option>");
                $("#district_id").append(node);
                $("#district_id").val(${searchHouse.districtid});
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
            $("#street_id").val(${searchHouse.streetid});
        },"json");

    }
    function gopage(page) {
        $("#savepage").val(page);
        $("#sform").submit();
    }
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM   id=sform method=post action=getBroswerHouse>
    <input type="hidden" name="page" id="savepage" value="1">
    <div>
      标题：<INPUT class=text type=text name=title value="${searchHouse.title}">
      类型:<SELECT id="typeId" name=typeid>
      <OPTION selected value="">不限</OPTION>
    </SELECT>
      区域:<SELECT id="district_id" name=districtid>
      <OPTION selected value="">不限</OPTION>
    </SELECT>
      街道:<SELECT name=streetid id="street_id">
      <OPTION selected value="">不限</OPTION>
    </SELECT>
      价格:<INPUT style="width: 50px" class=text type=text name=minprice value="${searchHouse.minprice}">-<INPUT  style="width: 50px" class=text value="${searchHouse.maxprice}" type=text name=maxprice>元
      <LABEL class=ui-blue><INPUT value=搜索房屋 type=submit name=search></LABEL>
    </div>
  </FORM></DL></DIV>
<DIV class="main wrap">
    <c:if test="${!empty pageInfo.list}">
<TABLE class=house-list>
  <TBODY>
  <c:forEach items="${pageInfo.list}" var="h">
    <TR>
      <TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="http://localhost:81/${h.path}" width="100" height="75" alt=""></a></span></TD>
      <TD>
        <DL>
          <DT><A href="details.jsp" target="_blank">${h.title}</A></DT>
          <DD>${h.dname}--${h.sname},${h.floorage}平米<BR>联系方式：${h.contact} </DD></DL></TD>
      <TD class=house-type>${h.tname}</TD>
      <TD class=house-price><SPAN>${h.price}</SPAN>元/月</TD></TR>
  </c:forEach>

  </TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:gopage(1)">首页</A></LI>
  <LI><A href="javascript:gopage(${pageInfo.prePage==0?1:pageInfo.prePage})">上一页</A></LI>
  <LI><A href="javascript:gopage(${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage})">下一页</A></LI>
  <LI><A href="javascript:gopage(${pageInfo.pages})">末页</A></LI></UL><SPAN
class=total>${pageInfo.pageNum}/${pageInfo.pages}页</SPAN> </DIV>
    </c:if></DIV>
<c:if test="${empty pageInfo.list}">
    <center style="color: red;font-size: 30px">
        暂无信息
    </center>
</c:if>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>

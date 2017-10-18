<#escape x as (x)!"">
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="#" type="image/png">
    <title>所有管理员</title>
    <!--common-->
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="sticky-header">
  <section>
      <#include "left.ftl" />
      <!-- main content start-->
      <div class="main-content" >
        <!-- header section start-->
        <#include "mainhead.ftl" />
        <!-- header section end-->
        <!--body wrapper start-->
        <div class="wrapper">
          <div class="row">
            <div class="col-sm-12">
              <section class="panel">
                <div class="panel-body">
                  <section>
                    <table class=" table table-bordered table-striped table-condensed masteres">
                      <thead>
                        <tr>
                          <th>ID</th>
                          <th>账号</th>
                          <th>姓名</th>
                          <th>性别</th>
                          <th>手机号</th>
                          <th>QQ号</th>
                          <th>创建时间</th>
                          <th>状态</th>
                          <th>操作  <a href="/master?add">添加管理员</a></th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (masterlist?? && masterlist?size>0)>
                        <#list masterlist as mt>
                        <tr>
                          <td>${mt.m_id}</td>
                          <td>${mt.m_name}</td>
                          <td>${mt.m_cname}</td>
                          <td><#if mt.m_sex=1>男<#else>女</#if></td>
                          <td>${mt.m_mobile}</td>
                          <td>${mt.m_qq}</td>
                          <td>${mt.m_ctime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td><#if mt.m_status=0>正常<#else>异常</#if></td>
                          <td>
                            <a class="freeze" href="javascript: void(0)" data-id="${mt.m_id}" data-status="${mt.m_status}"><#if mt.m_status=0>冻结<#else>解冻</#if></a> | 
                            <a class="delete" href="javascript: void(0)" data-id="${mt.m_id}">删除</a> | 
                            <a class="update" href="/master?revise&m_id=${mt.m_id}">修改资料</a> | 
                            <a href="/master?ungrantfunclist&mid=${mt.m_id}">授权</a> | 
                            <a href="/master?grantfunclist&mid=${mt.m_id}">回收</a>
                          </td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                  </section>
                </div>
              </section>
            </div>
          </div>
        </div>
        <!--body wrapper end-->
      </div>
      <!-- main content end-->
  </section>
  <!-- Placed js at the end of the document so the pages load faster -->
  <script src="js/jquery-1.10.2.min.js"></script>
  <script src="js/jquery-ui-1.9.2.custom.min.js"></script>
  <script src="js/jquery-migrate-1.2.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/modernizr.min.js"></script>
  <script src="js/jquery.nicescroll.js"></script>
  <!--common scripts for all pages-->

  <script src="js/scripts.js"></script>
  <script type="text/javascript">
    !function(){
      $('.masteres').delegate('.freeze', 'click', function(e){
        var id = $(this).data('id');
        var status = $(this).data('status');
        if (status == 0) {
          status = 1;
        } else {
          status = 0;
        }
        $.ajax({
          url: '/master?statusopt',
          type: 'POST',
          data: {id:id, status:status},
          dataType: 'json',
          error: function(xhr, errortext, errorstatus) {
            alert(errortext);
          },
          success: function(data, status) {
            if (data.status == 0) {
              location.reload();
            } else {
              alert(data.msg);
            }
          }
        });
      });
      $('.masteres').delegate('.delete', 'click', function(e){
        var id = $(this).data('id');
        if (confirm('确定删除')) {
          $.ajax({
            url: '/master?del',
            type: 'POST',
            data: {id:id},
            dataType: 'json',
            error: function(xhr, errortext, errorstatus) {
              alert(errortext);
            },
            success: function(data, status) {
              if (data.status == 0) {
                location.reload();
              } else {
                alert(data.msg);
              }
            }
          });
        }
      });
    }();
  </script>
</body>
</html>
</#escape>

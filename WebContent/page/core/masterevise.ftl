<#escape x as (x)!"">
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="#" type="image/png">
    <title>管理员资料修改</title>
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
        <#include "mainhead.ftl" />
        <!--body wrapper start-->
        <section class="wrapper">
        <!-- page start-->
          <div class="row">
            <div class="col-lg-10 center">
                <section class="panel">
                  <header class="panel-heading">
                      资料修改
                      <span class="pull-right">
                        <a href="javascript: void(0);" class="fa fa-mail-reply go-back" title="返回"></a>
                      </span>
                  </header>
                  <div class="panel-body">
                    <form id="form">
                      <div class="form-group">
                          <label for="uname">用户名</label>
                          <input type="text" class="form-control" id="uname" name="uname" placeholder="用户名" value="${muser.m_name}">
                      </div>
                      <div class="form-group">
                          <label for="pwd">密码</label>
                          <input type="password" class="form-control" id="pwd" name="pwd" placeholder="密码" >
                      </div>
                      <div class="form-group">
                          <label for="surepwd">确认密码</label>
                          <input type="password" class="form-control" id="surepwd" name="surepwd" placeholder="确认密码">
                      </div>
                      <div class="form-group">
                          <label for="cname">姓名</label>
                          <input type="text" class="form-control" id="cname" name="cname" placeholder="姓名" value="${muser.m_cname}">
                      </div>
                      <div class="form-group">
                          <label for="sex">性别</label>
                          <select id="sex" name="sex" class="form-control">
                              <option value="1" <#if muser.m_sex=1>selected</#if>>男</option>
                              <option value="2" <#if muser.m_sex=2>selected</#if>>女</option>
                          </select>
                      </div>
                      <div class="form-group">
                          <label for="mobile">电话</label>
                          <input type="text" class="form-control" id="mobile" name="mobile" placeholder="电话" value="${muser.m_mobile}">
                      </div>
                      <div class="form-group">
                          <label for="qq">QQ</label>
                          <input type="text" class="form-control" id="qq" name="qq" placeholder="qq号码" value="${muser.m_qq}">
                      </div>
                      <div class="form-group">
                          <label for="email">Email</label>
                          <input type="email" class="form-control" id="email" name="email" placeholder="邮箱" value="${muser.m_mail}">
                      </div>
                      <div class="form-group">
                        <label for="remark">备注</label>
                        <textarea name="remark" class="form-control" id="remark" cols="30" rows="6">${muser.m_remark}</textarea>
                      </div>
                      <input type="hidden" name="id" value="${muser.m_id}">
                      <button class="btn btn-primary" id="sure">提交</button>
                    </form>
                  </div>
                </section>
            </div>
          </div>
        <!-- page end-->
        </section>
        <!--body wrapper end-->
      </div>
    <!-- main content end-->
    </section>
    <!-- Placed js at the end of the document so the pages load faster -->
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/modernizr.min.js"></script>
    <script src="/js/jquery.nicescroll.js"></script>
    <!--common scripts for all pages-->
    <script src="/js/scripts.js"></script>
    <script type="text/javascript">
      !function(){
          $('#sure').on('click', function(e){
              e.preventDefault();
              var param = $('#form').serialize();
              $.ajax({
                url: '/master/revise',
                type: 'POST',
                data: param,
                dataType: 'json',
                error: function(xhr, errortext, errorstatus) {
                  alert(errortext);
                },
                success: function(data, status) {
                  if (data.status == 0) {
                    location = "/master";
                  } else {
                    alert(data.msg);
                  }
                }
              });
          });
      }();
    </script>
  </body>
</html>
</#escape>
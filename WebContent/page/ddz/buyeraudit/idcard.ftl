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
    <title>身份证审核</title>
    <!--common-->
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <script type="text/javascript" src="/js/pager.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="sticky-header">
    <div class="ui-dialog" id="refuse-reason-dialog">
      <div class="panel panel-primary">
        <div class="panel-heading">拒绝原因选择
          <span class="tools pull-right">
            <a href="javascript: void(0);" class="fa fa-times"></a>
          </span>
        </div>
        <div class="panel-body">
          <p>原因选择：</p>
          <ul class="list-group reason-list">
            <li class="list-group-item"><input type="checkbox" value="头像不真实"> 头像不真实</li>
            <li class="list-group-item"><input type="checkbox" value="身份证图片不清晰"> 身份证图片不清晰</li>
            <li class="list-group-item"><input type="checkbox" value="身份证姓名不匹配"> 身份证姓名不匹配</li>
            <li class="list-group-item"><input type="checkbox" value="身份证重复"> 身份证重复</li>
            <li class="list-group-item"><input type="checkbox" value="请上传清晰完整的实拍身份证正面照片"> 请上传清晰完整的实拍身份证正面照片</li>
            <li class="list-group-item"><input type="checkbox" value="未满19周岁"> 未满19周岁</li>
            <li class="list-group-item"><input type="checkbox" value="买手多次不按要求上传，视为恶意注册，账号暂时冻结"> 买手多次不按要求上传，视为恶意注册，账号暂时冻结</li>
            <li class="list-group-item"><input type="checkbox" value="1960及1960年前不符合注册要求"> 1960及1960年前不符合注册要求</li>
            <li class="list-group-item"><input type="checkbox" value="身份证姓名与绑定银行卡姓名不一致"> 身份证姓名与绑定银行卡姓名不一致</li>
            <li class="list-group-item"><input type="checkbox" value="非本人"> 非本人</li>
          </ul>
          <textarea name="reason" class="form-control reason" cols="60" rows="5"></textarea>
          <br>
          <div class="opt">
            <button class="btn btn-primary pull-right sure">确定</button>
          </div>
        </div>
      </div>
    </div>
    <section>
    <#include "../left.ftl" />
    <!-- main content start-->
    <div class="main-content" >
        <#include "../mainhead.ftl" />
        <!--body wrapper start-->
        <div class="wrapper">
          <div class="row">
            <div class="col-xs-12">
              <section class="panel">
                <header class="panel-heading">
                  身份证审核
                </header>
                <div class="panel-body">
                  <form class="form-inline" action="/buyeraudit/idcardlst" method="POST">
                    <div class="form-group">
                      <label for="userid">用户ID：</label>
                      <input type="text" class="form-control" name="userid" id="userid" value="${userid}">
                    </div>
                    <div class="form-group">
                        <label for="cname">姓名：</label>
                        <input type="text" class="form-control" name="cname" id="cname" value="${cname}">
                    </div>
                    <div class="form-group">
                      <label for="">身份证号码：</label>
                      <input type="text" class="form-control" name="cardno" id="cardno" value="${cardno}">
                    </div>
                    <div class="form-group">
                      <label for="status">状态：</label>
                      <select name="status" class="form-control" id="status">
                        <option value="-1" <#if (status?? && status='-1')>selected</#if>>全部</option>
                        <option value="0" <#if (status?? && status='0')>selected</#if>>待审核</option>
                        <option value="1" <#if (status?? && status='1')>selected</#if>>通过</option>
                        <option value="2" <#if (status?? && status='2')>selected</#if>>不通过</option>
                      </select>
                    </div>
                    <button type="submit" class="btn btn-primary">确认</button>
                  </form>
                </div>
              </section>
            </div>
          </div>
          <div class="row">
            <div class="col-xs-12">
              <section class="panel">
                <div class="panel-body">
                  <section>
                    <table class="table table-bordered table-striped table-condensed idcardlist">
                      <thead>
                        <tr>
                          <th>用户ID</th>
                          <th>姓名</th>
                          <th>身份证号码</th>
                          <th>身份证图片</th>
                          <th>绑定时间</th>
                          <th>状态</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as item>
                        <tr>
                          <td><a href="/user?userid=${item.userid}" target="_blank">${item.userid}</a></td>
                          <td>${item.cname}</td>
                          <td>${item.cardno}</td>
                          <td><img src="${item.cardpic}" alt="" width="360" height="230"></td>
                          <td>${item.bdtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td><#if item.status=0>待审核<#elseif item.status=1>审核通过<#elseif item.status=2>审核不过</#if></td>
                          <td>
                            <#if item.status=0>  <a class="pass" href="javascript: void(0)" data-userid="${item.userid}">通过</a>　<a class="refuse" href="javascript: void(0)" data-userid="${item.userid}">拒绝</a>
                            <#elseif item.status=1>
                              ${item.auditadmin}<br>
                              ${item.audittime?string('yyyy-MM-dd HH:mm:ss')}
                            <#elseif item.status=2>
                              ${item.reason} <br>
                              ${item.auditadmin}<br>
                              ${item.audittime?string('yyyy-MM-dd HH:mm:ss')}
                            </#if>
                          </td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber}, ${page.pageSize}, ${page.pageIndex}, ${page.total}, 'goPager', 5, "/buyeraudit/idcard?<#if userid??>userid=${userid}&</#if><#if cname??>cname=${cname}&</#if><#if cardno??>cardno=${cardno}&</#if><#if status??>status=${status}</#if>");
                      document.write(pageStr);
                    </script>
                    </#if>
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

        $('.idcardlist').delegate('.pass', 'click', function(e){
          var userid = $(this).data('userid');
          if (confirm('确定通过')) {
            $.showMask();
            $.ajax({
              url: '/buyeraudit/idcardaudit',
              type: 'POST',
              data: {userid:userid, status:1},
              dataType: 'json',
              error: function(xhr, errortext, errorstatus) {
                $.hideMask();
                alert(errortext);
              },
              success: function(data, status) {
                if (data.status == 0) {
                  location.reload();
                } else {
                  $.hideMask();
                  alert(data.msg);
                }
              }
            });
          }
        });

        var $dialog = $('#refuse-reason-dialog');

        $('.idcardlist').delegate('.refuse', 'click', function(e){
          var userid = $(this).data('userid');
          $dialog.data('userid', userid);
          $.showMask();
          $dialog.trigger('open');
        });

        $dialog.find('.sure').on('click', function(){
          var userid = $dialog.data('userid');
          var reason = $dialog.find('.reason').val();
          if (!reason) {
            $.prompt('请选择或输入拒绝原因');
            return false;
          }
          $dialog.hide();
          $.showBuffer();
          $.ajax({
            url: '/buyeraudit/idcardaudit',
            type: 'POST',
            data: {userid:userid, status:2, reason:reason},
            dataType: 'json',
            error: function(xhr, errortext, errorstatus) {
              alert(errortext);
              $.hideBuffer();
              $.hideMask();
            },
            success: function(data, status) {
              if (data.status == 0) {
                location.reload();
              } else {
                $.hideBuffer();
                $.prompt(data.msg);
                $.hideMask();
              }
            }
          });
        });
      }();
    </script>
  </body>
</html>
</#escape>
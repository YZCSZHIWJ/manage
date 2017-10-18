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
    <title>短信查询</title>
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
                  短信查询
                </header>
                <div class="panel-body">
                  <form class="form-inline" action="/user/smsend" method="GET">
                    <div class="form-group">
                      <label for="userid">用户ID：</label>
                      <input type="text" class="form-control" name="userid" id="userid" value="${userid}">
                    </div>
                    <div class="form-group">
                        <label for="mobile">手机号码：</label>
                        <input type="text" class="form-control" name="mobile" id="mobile" value="${mobile}">
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
                    <table class="table table-bordered table-striped table-condensed">
                      <thead>
                        <tr>
                          <th>用户ID</th>
                          <th>手机号码</th>
                          <th>验证码</th>
                          <th>发送内容</th>
                          <th>添加时间</th>
                          <th>到期时间</th>
                          <th>发送状态</th>
                          <th>发送时间</th>
                          <th>出错次数</th>
                          <th>发送类别</th>
                          <th>使用标记</th>
                          <th>发送结果</th>
                          <th>发送渠道</th>
                          <th>验证时间</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as sms>
                        <tr>
                          <td>${sms.userid}</td>
                          <td>${sms.mobile}</td>
                          <td>${sms.code}</td>
                          <td>${sms.message}</td>
                          <td>${sms.itime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${sms.endtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td><#if sms.status=0>待发送<#elseif sms.status=1>已发送<#elseif sms.status=2>发送失败<#elseif sms.status=3>发送异常</#if></td>
                          <td>${sms.sendtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${sms.errorcount}</td>
                          <td><#if sms.type=0>注册<#else>其他</#if></td>
                          <td><#if sms.sign=0>未使用<#elseif sms.sign=1>已使用<#elseif sms.sign=2>失效</#if></td>
                          <td>${sms.retmessage}</td>
                          <td>${sms.channel}</td>
                          <td>${sms.usetime?string('yyyy-MM-dd HH:mm:ss')}</td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber}, ${page.pageSize}, ${page.pageIndex}, ${page.total}, 'goPager', 5, "/user/smsend");
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
  </body>
</html>
</#escape>
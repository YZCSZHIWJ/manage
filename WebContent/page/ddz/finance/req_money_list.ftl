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
    <title>提现审核</title>
    <!--common-->
    <link rel="stylesheet" type="text/css" href="/js/fancybox/source/jquery.fancybox.css?v=2.1.5" media="screen" />
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/js/bootstrap-datepicker/css/datepicker-custom.css" />
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
                  提现审核
                </header>
                <div class="panel-body">
                  <form class="form-inline" action="/finance/auditgetmoney" method="POST">
                    <div class="form-group">
                        <label for="userid">用户ID：</label>
                        <input type="text" class="form-control" name="userid" value="${userid}">　
                    </div>
                    <div class="form-group">
                        <label for="last4">账户后四位：</label>
                        <input type="text" class="form-control" name="last4" value="${last4}">　
                    </div>
                    <div class="form-group">
                      <label for="status">审核状态：</label>
                      <select name="status" class="form-control">
                        <option value="0" <#if (status?? && status=0)>selected</#if>>待审核</option>
                        <option value="1" <#if (status?? && status=1)>selected</#if>>通过</option>
                        <option value="2" <#if status?? && status==2>selected</#if>>不通过</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="isout">导出状态：</label>
                      <select name="isout" class="form-control">
                        <option value="-1">全部</option>
                        <option value="0" <#if isout?? && isout=0>selected</#if>>未导出</option>
                        <option value="1" <#if isout?? && isout=1>selected</#if>>已导出</option>
                        <option value="2" <#if isout?? && isout=2>selected</#if>>已完成</option>
                      </select>　
                    </div>
                    <div class="form-group">
                      <label for="">发起时间：</label>
                      <input size="16" type="text" value="${starttime}" readonly name="starttime" class="form_date form-control">
                       到 
                      <input size="16" type="text" value="${endtime}" readonly name="endtime" class="form_date form-control">
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
                    <table class="table table-bordered table-striped table-condensed appealst">
                      <thead>
                        <tr>
                          <th>提现编号</th>
                          <th>用户ID</th>
                          <th>提现类别</th>
                          <th>扣除金额</th>
                          <th>到账金额</th>
                          <th>账户剩余</th>
                          <th>提交时间</th>
                          <th>姓名</th>
                          <th>银行名称</th>
                          <th>账号</th>
                          <th>开户所在地</th>
                          <th>是否导出</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as item>
                        <tr>
                          <td><a>${item.id}</a></td>
                          <td><a href="/user?userid=${item.userid}" target="_blank">${item.userid}</a></td>
                          <td><#if item.type=0>本金<#elseif item.type=2>佣金</#if></td>
                          <td>${item.price}</td>
                          <td>${item.money}</td>
                          <td>${item.restmoney}</td>
                          <td>${item.itime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${item.cname}</td>
                          <td>${item.bankname}</td>
                          <td>${item.bankaccount}</td>
                          <td>${item.province}${item.city}</td>
                          <td>
                            <#if item.isout=0>
                            <span style="color: red;">否</span>
                            <#elseif item.isout=1>
                            <span>已导出</span>
                            <#elseif item.isout=2>
                            <span>已完成</span>
                            </#if>
                          </td>
                          <td>
                            <button class="btn btn-primary">通过</button>　<button class="btn btn-primary">不通过</button>
                          </td>                          
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber}, ${page.pageSize}, ${page.pageIndex}, ${page.total}, 'goPager', 5, "/finance/auditgetmoney?status=${status}&isout=${isout}&userid=${userid}&last4=${last4}&starttime=${starttime}&endtime=${endtime}");
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
    <script type="text/javascript" src="/js/fancybox/lib/jquery.mousewheel-3.0.6.pack.js"></script>
    <!-- Add fancyBox main JS and CSS files -->
    <script type="text/javascript" src="/js/fancybox/source/jquery.fancybox.js?v=2.1.5"></script>  
    <script type="text/javascript" src="/js/fancybox/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
    <!--common scripts for all pages-->
    <script type="text/javascript" src="/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datepicker/js/bootstrap-datepicker.zh-CN.js"></script>
    <script src="/js/scripts.js"></script>
    <script type="text/javascript">
      $(function(){
        $('.form_date').datepicker({
            format: 'yyyy-mm-dd',
            language: "zh-CN",
            autoclose: true,
            clearBtn: true
        });
      }());
    </script>
  </body>
</html>
</#escape>
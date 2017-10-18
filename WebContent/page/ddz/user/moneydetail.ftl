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
    <title>${detailtype}</title>
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
                  ${detailtype}
                </header>
                <div class="panel-body">
                  <form class="form-inline" action="/user/moneydetail">
                    <div class="form-group">
                      <label for="userid">用户ID：</label>
                      <input type="text" class="form-control" name="userid" id="userid" value="${userid}">
                    </div>
                    <div class="form-group">
                        <label for="search">任务或订单编号：</label>
                        <input type="text" class="form-control" name="search" value="${search}">
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
                          <th>流水类型</th>
                          <th>备注</th>
                          <th>流动金额</th>
                          <th>剩余金额</th>
                          <th>产生时间</th>
                          <th>添加者</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as item>
                        <tr>
                          <td><#switch item.type><#case 0>默认<#break><#case 1>任务相关<#break><#case 2>提现相关<#break><#case 3>奖励<#break></#switch></td>
                          <td>${item.remark}</td>
                          <td>${item.money}</td>
                          <td>${item.restmoney}</td>
                          <td>${item.itime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${item.opuser}</td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber}, ${page.pageSize}, ${page.pageIndex}, ${page.total}, 'goPager', 5, "/user/moneydetail?<#if userid??>userid=${userid}&</#if><#if search??>search=${search}&</#if>");
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
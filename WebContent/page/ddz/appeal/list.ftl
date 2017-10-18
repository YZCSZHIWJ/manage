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
    <title>申诉处理</title>
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
                  申诉处理
                </header>
                <div class="panel-body">
                  <form class="form-inline" action="/appeal/list" method="POST">
                    <div class="form-group">
                        <label for="orderid">订单编号：</label>
                        <input type="text" class="form-control" name="orderid" value="${orderid}">　
                    </div>
                    <div class="form-group">
                        <label for="userid">申诉者ID：</label>
                        <input type="text" class="form-control" name="userid" value="${userid}">　
                    </div>
                    <div class="form-group">
                      <label for="beuserid">被申诉者ID：</label>
                      <input type="text" class="form-control" name="beuserid" value="${beuserid}">　
                    </div>
                    <div class="form-group">
                      <label for="appeal_type">申诉原因：</label>
                      <select name="appeal_type" class="form-control">
                        <option value="-1" >全部</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="status">申诉状态：</label>
                      <select name="status" class="form-control">
                        <option value="1" <#if (status?? && status<2)>selected</#if>>进行中</option>
                        <option value="2" <#if status?? && status==2>selected</#if>>已完成</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="plat_join_status">平台介入：</label>
                      <select name="plat_join_status" class="form-control">
                        <option value="-1">全部</option>
                        <option value="0" <#if plat_join_status?? && plat_join_status=0>selected</#if>>未介入</option>
                        <option value="1" <#if plat_join_status?? && plat_join_status=1>selected</#if>>已介入</option>
                      </select>　
                    </div>
                    <div class="form-group">
                      <label for="">发起时间：</label>
                      <input size="16" type="text" value="${startdate}" readonly name="startdate" class="form_date form-control">
                       到 
                      <input size="16" type="text" value="${enddate}" readonly name="enddate" class="form_date form-control">
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
                          <th>订单ID</th>
                          <th>任务ID</th>
                          <th>申诉人ID</th>
                          <th>发起时间与介入时间</th>
                          <th>申诉类别</th>
                          <th>申诉原因</th>
                          <th>申诉图片</th>
                          <th>被申诉人ID</th>
                          <th>已查看</th>
                          <th>最后回复</th>
                          <th>处理进程</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as item>
                        <tr>
                          <td><a href="/order/flowlist/detail?id=${item.orderid}" target="_blank">${item.orderid}</a></td>
                          <td><a href="/task/flowlist/detail?id=${item.tid}" target="_blank">${item.tid}</a></td>
                          <td><a href="/user?userid=${item.userid}" target="_blank">${item.userid}</a></td>
                          <td>${item.itime?string('yyyy-MM-dd HH:mm:ss')} <br> ${item.apply_join_time?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${item.appeal_type}</td>
                          <td>${item.appeal_reason}</td>
                          <td>
                            <#if item.appeal_imges??> 
                              <#if item.appeal_imges?index_of(",") = -1> 
                                <#if item.appeal_imges!=''>
                                <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${item.appeal_imges}">
                                  <img src="${item.appeal_imges}" width="60" height="60">
                                </a> 
                                </#if> 
                              <#else> 
                                <#list item.appeal_imges?split(",") as img> 
                                  <#if img?? && img!=''>
                                  <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${img}">
                                    <img src="${img}" width="60" height="60">
                                  </a> 
                                  </#if> 
                                </#list> 
                                </#if> 
                            </#if>
                          </td>
                          <td><a href="/user?userid=${item.beuserid}" target="_blank">${item.beuserid}</a></td>
                          <td>
                            <#if item.admin_read_status=1>
                            <span style="color: red;">否</span>
                            <#else>
                            --
                            </#if>
                          </td>
                          <td>
                            ${item.last_admin_back_content} <br>
                            ${item.last_back_admin}　${item.last_admin_back_time?string('yyyy-MM-dd HH:mm:ss')}
                          </td>
                          <td> <a class="seepro" href="/appeal/list/detail?orderid=${item.orderid}&isflow=${item.isflow}" target="_blank">查看</a> </td>
                          <td>
                            <#if (item.status<2)>
                              <button class="btn btn-primary over" data-orderid="${item.orderid}" data-isflow="${item.isflow}">完结</button>
                            </#if>
                          </td>                          
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber}, ${page.pageSize}, ${page.pageIndex}, ${page.total}, 'goPager', 5, "/appeal/index?<#if orderid??>orderid=${orderid}&</#if><#if tid??>tid=${tid}&</#if><#if userid??>userid=${userid}&</#if><#if beuserid??>beuserid=${beuserid}&</#if><#if status??>status=${status}&</#if><#if appeal_type??>appeal_type=${appeal_type}&</#if><#if plat_join_status??>plat_join_status=${plat_join_status}&</#if><#if startdate??>startdate=${startdate}&</#if><#if enddate??>enddate=${enddate}&</#if>");
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
    <script type="text/javascript">
      !function(){
        $('.appealst').delegate('.over', 'click', function(e){
          var orderid = $(this).data('orderid');
          var isflow = $(this).data('isflow');
          if (confirm('确认完结')) {
            $.showMask();
            $.ajax({
              url:'/appeal/over',
              type:'POST',
              data:{orderid:orderid, isflow:isflow},
              dataType:'json',
              error: function(xhr, errortext, errorthrow) {
                $.prompt(errortext);
                $.hideMask();
              },
              success: function(data, status) {
                if (data.status == 0) {
                  location.reload();
                } else {
                  $.prompt(data.msg);
                  $.hideMask();
                }
              }
            });
          }
        });
      }();
    </script>
    <script type="text/javascript">
      $(".fancybox-effects-d").fancybox({
        padding: 0,
        openEffect : 'elastic',
        openSpeed  : 150,
        closeEffect : 'elastic',
        closeSpeed  : 150,
        closeClick : true,
        helpers : {
          overlay : null
        }
      });
    </script>
  </body>
</html>
</#escape>
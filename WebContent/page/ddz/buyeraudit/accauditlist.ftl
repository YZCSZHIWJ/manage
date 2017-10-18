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
    <title>${platname}审核</title>
    <!--common-->
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/js/fancybox/source/jquery.fancybox.css?v=2.1.5" media="screen" />
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
            <#if plat=1>
            <li class="list-group-item"><input type="checkbox" value="必须绑定和身份证相同的实名认证淘宝号，或者是该身份证下的关联账号"> 必须绑定和身份证相同的实名认证淘宝号，或者是该身份证下的关联账号</li>
            <li class="list-group-item"><input type="checkbox" value="收货地址不完整（小区精确到几幢，路精确到几号，不可出现附近等相关词，在一定区域内不能再精确的可在后面加上电话联系）"> 收货地址不完整（小区精确到几幢，路精确到几号，不可出现附近等相关词，在一定区域内不能再精确的可在后面加上电话联系）</li>
            <li class="list-group-item"><input type="checkbox" value="请核对淘宝用户名（包括符号及字母大小写）"> 请核对淘宝用户名（包括符号及字母大小写）</li>
            <li class="list-group-item"><input type="checkbox" value="淘宝用户名不符合要求"> 淘宝用户名不符合要求</li>
            <li class="list-group-item"><input type="checkbox" value="要求注册六个月以上的买号"> 要求注册六个月以上的买号</li>
            <li class="list-group-item"><input type="checkbox" value="帐号异常"> 帐号异常</li>
            <li class="list-group-item"><input type="checkbox" value="信誉达不到要求，要求信誉达到3星"> 信誉达不到要求，要求信誉达到3星</li>
            <li class="list-group-item"><input type="checkbox" value="收货人姓名不真实"> 收货人姓名不真实</li>
            <li class="list-group-item"><input type="checkbox" value="图片模糊请重新上传"> 图片模糊请重新上传</li>
            <li class="list-group-item"><input type="checkbox" value="实名认证图片错误(模糊)，请重新上传"> 实名认证图片错误(模糊)，请重新上传</li>
            <li class="list-group-item"><input type="checkbox" value="请按要求上传账号截图"> 请按要求上传账号截图</li>
            <li class="list-group-item"><input type="checkbox" value="已有相同收货人姓名、地址或手机的绑定买号"> 已有相同收货人姓名、地址或手机的绑定买号</li>
            <li class="list-group-item"><input type="checkbox" value="相似买号"> 相似买号</li>
            <li class="list-group-item"><input type="checkbox" value="信誉图片错误(模糊)，请重新上传"> 信誉图片错误(模糊)，请重新上传</li>
            <li class="list-group-item"><input type="checkbox" value="不支持绑定卖家号"> 不支持绑定卖家号</li>
            <li class="list-group-item"><input type="checkbox" value="身份证未审核通过"> 身份证未审核通过</li>
            <#elseif plat=2>
            <li class="list-group-item"><input type="checkbox" value="请核对京东用户名（包括符号及字母大小写）"> 请核对京东用户名（包括符号及字母大小写）</li>
            <li class="list-group-item"><input type="checkbox" value="请输入京东用户名（非手机号码、非邮箱地址、非昵称；）后重新上传"> 请输入京东用户名（非手机号码、非邮箱地址、非昵称；）后重新上传</li>
            <li class="list-group-item"><input type="checkbox" value="收货地址不完整（小区精确到几幢，路精确到几号，不可出现附近等相关词，在一定区域内不能再精确的可在后面加上电话联系）"> 收货地址不完整（小区精确到几幢，路精确到几号，不可出现附近等相关词，在一定区域内不能再精确的可在后面加上电话联系）</li>
            <li class="list-group-item"><input type="checkbox" value="已有相同收货人姓名、地址或手机的绑定买号"> 已有相同收货人姓名、地址或手机的绑定买号</li>
            <li class="list-group-item"><input type="checkbox" value="请按要求上传账号截图"> 请按要求上传账号截图</li>
            <li class="list-group-item"><input type="checkbox" value="图片模糊请重新上传"> 图片模糊请重新上传</li>
            </#if>
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
                  ${platname}审核
                </header>
                <div class="panel-body">
                  <form class="form-inline" action="/buyeraudit/accauditlst/${plat}/" method="GET">
                    <input type="hidden" name="plat" value="${plat}">
                    <div class="form-group">
                      <label for="userid">用户ID：</label>
                      <input type="text" class="form-control" name="userid" id="userid" value="${userid}">
                    </div>
                    <div class="form-group">
                      <label for="status">状态：</label>
                      <select class="form-control" name="status">
                        <option value="0" <#if status?? && status='0'>selected</#if>>待审核</option>
                        <option value="1" <#if status?? && status='1'>selected</#if>>审核通过</option>
                        <option value="2" <#if status?? && status='2'>selected</#if>>拒绝</option>
                        <option value="3" <#if status?? && status='3'>selected</#if>>禁用</option>
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
                    <table class="table table-bordered table-striped table-condensed bindlist">
                      <thead>
                        <tr>
                          <th>编号</th>
                          <th>绑定信息</th>
                          <th>账号及等级</th>
                          <th>绑定时间</th>
                          <th>收货人姓名及地址</th>
                          <th>账号截图</th>
                          <th>收货手机</th>
                          <th>操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      <#if (page?? && page.elements?size>0)>
                        <#list page.elements as item>
                        <tr>
                          <td>${item.id}</td>
                          <td>
                            用户ID：<a href="/user?userid=${item.userid}" target="_blank">${item.userid}</a> <br>
                            性别：<#if item.sex=1>男<#else>女</#if> <br>
                            出生日期：${item.birthday?string('yyyy-MM-dd')} <br>
                          </td>
                          <td>${item.account} <#if item.plat=1><br><br><#switch item.creditlevel><#case 1>三心<#break><#case 2>四心<#break><#case 3>五心<#break><#case 4>一钻<#break><#case 5>二钻<#break><#case 6>三钻及以上<#break><#default>未提交<#break></#switch></#if></td>
                          <td>${item.bdtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                          <td>${item.receiver}<br>${item.province} ${item.city} ${item.county} ${item.address}</td>
                          <td>
                            <#if item.audit_img??> 
                              <#if item.audit_img?index_of(",") = -1> 
                                <#if item.audit_img!=''>
                                <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${item.audit_img}">
                                  <img src="${item.audit_img}" width="210" height="210">
                                </a> 
                                </#if>
                              <#else> 
                                <#list item.audit_img?split(",") as img> 
                                  <#if img?? && img!=''>
                                  <a class="fancybox-effects-d" data-fancybox-group="gallery" href="${img}">
                                    <img src="${img}" width="210" height="210">
                                  </a> 
                                  </#if> 
                                </#list> 
                                </#if> 
                            </#if> 
                          </td>
                          <td>${item.mobile}</td>
                          <td>
                            <#if item.status=0>
                            <button class="btn btn-danger refuse" data-id="${item.id}" data-userid="${item.userid}">拒绝</button>
                            <button class="btn btn-success pass" data-id="${item.id}" data-userid="${item.userid}">通过</button>
                            <#elseif item.status=1>
                              通过 <br>
                              ${item.audittime?string('yyyy-MM-dd HH:mm:ss')} <br>
                              ${item.auditadmin}
                            <#elseif item.status=2>
                              拒绝原因：${item.refuse_reason} <br>
                              ${item.audittime?string('yyyy-MM-dd HH:mm:ss')} <br> 
                              ${item.auditadmin}
                            </#if>
                          </td>
                        </tr>
                        </#list>
                      </#if> 
                      </tbody>
                    </table>
                    <#if page??>
                    <script type="text/javascript">
                      var pageStr = createPageBar2(${page.pageNumber}, ${page.pageSize}, ${page.pageIndex}, ${page.total}, 'goPager', 5, "/buyeraudit/accauditlst?userid=${userid}&status=${status}");
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
    <!-- Add mousewheel plugin (this is optional) -->
    <script type="text/javascript" src="/js/fancybox/lib/jquery.mousewheel-3.0.6.pack.js"></script>
    <!-- Add fancyBox main JS and CSS files -->
    <script type="text/javascript" src="/js/fancybox/source/jquery.fancybox.js?v=2.1.5"></script>  
    <script type="text/javascript" src="/js/fancybox/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
    <!--common scripts for all pages-->
    <script src="/js/scripts.js"></script>
    <script type="text/javascript">

      $(function(){
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
      });

      !function(){

        var $dialog = $('#refuse-reason-dialog');

        $dialog.find('.sure').on('click', function(e){
          var id = $dialog.data('id');
          var userid = $dialog.data('userid');
          var reason = $dialog.find('.reason').val();
          if (!reason) {
            $.prompt('请选择或输入拒绝原因');
            return false;
          }
          $dialog.hide();
          $.showBuffer();
          $.ajax({
            url: '/buyeraudit/auditacc',
            type: 'POST',
            data: {id:id, userid:userid, status:2, reason:reason},
            dataType: 'json',
            error: function(xhr, errortext, errorstatus) {
              $.hideBuffer();
              $.hideMask();
              $.prompt(errortext);
            },
            success: function(data, status) {
              if (data.status == 0) {
                location.reload();
              } else {
                $.hideBuffer();
                $.hideMask();
                $.prompt(data.msg);
              }
            }
          });
        });

        $('.bindlist').delegate('.refuse', 'click', function(e){
          var id = $(this).data('id');
          var userid = $(this).data('userid');
          $dialog.data('id', id);
          $dialog.data('userid', userid);
          $.showMask();
          $dialog.trigger('open');
        });

        $('.bindlist').delegate('.pass', 'click', function(e) {
          var id = $(this).data('id');
          var userid = $(this).data('userid');
          if (confirm('确定通过')) {
            $.showMask();
            $.ajax({
              url: '/buyeraudit/auditacc',
              type: 'POST',
              data: {id:id, userid:userid, status:1},
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

      }();
    </script>
  </body>
</html>
</#escape>
<#escape x as (x)!"">
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="#" type="image/png">
    <title>添加新分组</title>
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
        <!-- page heading start-->
        <div class="page-heading">
          <h3>
            添加新分组
          </h3>
        </div>
        <!-- page heading end-->
        <!--body wrapper start-->
        <section class="wrapper">
        <!-- page start-->
          <div class="row">
            <div class="col-lg-10 center">
              <section class="panel">
                <header class="panel-heading">
                  分组信息
                </header>
                <div class="panel-body">
                  <form id="form">
                    <div class="form-group">
                      <label for="g_name">组名</label>
                      <input type="text" class="form-control" id="g_name" name="g_name" placeholder="组名">
                    </div>
                    <div class="form-group">
                      <label for="g_remark">描述</label>
                      <textarea name="g_remark" id="g_remark" cols="30" rows="10" class="form-control"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="">组标识</label>
                        <div class="row">
                          <div class="col-sm-12">
                            <section class="panel">
                              <div class="panel-body">
                                <table class="table table-bordered">
                                  <tbody style="font-size: 20px;">
                                    <tr>
                                      <td><i class="fa fa-glass"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-glass"></td>
                                      <td><i class="fa fa-music"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-music"></td>
                                      <td><i class="fa fa-search"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-search"></td>
                                      <td><i class="fa fa-heart"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-heart"></td>
                                      <td><i class="fa fa-star"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-star"></td>
                                      <td><i class="fa fa-star-o"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-star"></td>
                                      <td><i class="fa fa-user"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-user"></td>
                                      <td><i class="fa fa-film"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-film"></td>
                                      <td><i class="fa fa-th"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-th"></td>
                                      <td><i class="fa fa-th-list"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-th"></td>
                                      <td><i class="fa fa-check"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-check"></td>
                                      <td><i class="fa fa-times"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-times"></td>
                                      <td><i class="fa fa-signal"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-signal"></td>
                                      <td><i class="fa fa-gear"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-gear"></td>
                                      <td><i class="fa fa-home"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-home"></td>
                                      <td><i class="fa fa-file-o"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-file-o"></td>
                                      <td><i class="fa fa-clock-o"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-clock-o"></td>
                                      <td><i class="fa fa-road"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-road"></td>
                                      <td><i class="fa fa-download"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-download"></td>
                                      <td><i class="fa fa-arrow-circle-o-down"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-arrow-circle-o-down"></td>
                                      <td><i class="fa fa-inbox"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-inbox"></td>
                                      <td><i class="fa fa-play-circle-o"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-play-circle-o"></td>
                                      <td><i class="fa fa-rotate-right"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-rotate-right"></td>
                                      <td><i class="fa fa-refresh"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-refresh"></td>
                                    </tr>
                                    <tr>
                                      <td><i class="fa fa-lock"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-lock"></td>
                                      <td><i class="fa fa-flag"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-flag"></td>
                                      <td><i class="fa fa-headphones"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-headphones"></td>
                                      <td><i class="fa fa-qrcode"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-qrcode"></td>
                                      <td><i class="fa fa-barcode"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-barcode"></td>
                                      <td><i class="fa fa-tag"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-tag"></td>
                                      <td><i class="fa fa-tags"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-tags"></td>
                                      <td><i class="fa fa-book"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-book"></td>
                                      <td><i class="fa fa-bookmark"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-bookmark"></td>
                                      <td><i class="fa fa-print"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-print"></td>
                                      <td><i class="fa fa-camera"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-camera"></td>
                                      <td><i class="fa fa-font"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-font"></td>
                                      <td><i class="fa fa-bold"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-bold"></td>
                                      <td><i class="fa fa-italic"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-italic"></td>
                                      <td><i class="fa fa-text-height"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-text-height"></td>
                                      <td><i class="fa fa-text-width"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-text-width"></td>
                                      <td><i class="fa fa-align-left"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-align-left"></td>
                                      <td><i class="fa fa-list"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-list"></td>
                                      <td><i class="fa fa-dedent"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-dedent"></td>
                                      <td><i class="fa fa-indent"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-indent"></td>
                                      <td><i class="fa fa-pencil"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-pencil"></td>
                                      <td><i class="fa fa-adjust"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-adjust"></td>
                                      <td><i class="fa fa-tint"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-tint"></td>
                                      <td><i class="fa fa-edit"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-edit"></td>
                                    </tr>
                                    <tr>
                                      <td><i class="fa fa-arrows"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-arrows"></td>
                                      <td><i class="fa fa-backward"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-backward"></td>
                                      <td><i class="fa fa-forward"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-forward"></td>
                                      <td><i class="fa fa-crosshairs"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-crosshairs"></td>
                                      <td><i class="fa fa-ban"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-ban"></td>
                                      <td><i class="fa fa-share"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-share"></td>
                                      <td><i class="fa fa-expand"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-expand"></td>
                                      <td><i class="fa fa-compress"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-compress"></td>
                                      <td><i class="fa fa-plus"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-plus"></td>
                                      <td><i class="fa fa-minus"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-minus"></td>
                                      <td><i class="fa fa-asterisk"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-asterisk"></td>
                                      <td><i class="fa fa-gift"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-gift"></td>
                                      <td><i class="fa fa-leaf"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-leaf"></td>
                                      <td><i class="fa fa-fire"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-fire"></td>
                                      <td><i class="fa fa-eye"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-eye"></td>
                                      <td><i class="fa fa-warning"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-warning"></td>
                                      <td><i class="fa fa-plane"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-plane"></td>
                                      <td><i class="fa fa-calendar"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-calendar"></td>
                                      <td><i class="fa fa-random"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-random"></td>
                                      <td><i class="fa fa-comment"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-comment"></td>
                                      <td><i class="fa fa-magnet"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-magnet"></td>
                                      <td><i class="fa fa-retweet"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-retweet"></td>
                                      <td><i class="fa fa-key"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-key"></td>
                                      <td><i class="fa fa-trophy"></i> <input type="radio" name="g_tag" id="g_tag" value="fa-trophy"></td>
                                    </tr>
                                    <tr>
                                      <td><i class="fa fa-bitbucket-square"></i> <input type="radio" name="g_tag" value="fa-bitbucket-square" id="g_tag"></td>
                                      <td><i class="fa fa-heart-o"></i> <input type="radio" name="g_tag" value="fa-heart-o" id="g_tag"></td>
                                      <td><i class="fa fa-sign-out"></i> <input type="radio" name="g_tag" value="fa-sign-out" id="g_tag"></td>
                                      <td><i class="fa fa-linkedin-square"></i> <input type="radio" name="g_tag" value="fa-linkedin-square" id="g_tag"></td>
                                      <td><i class="fa fa-thumb-tack"></i> <input type="radio" name="g_tag" value="fa-thumb-tack" id="g_tag"></td>
                                      <td><i class="fa fa-external-link"></i> <input type="radio" name="g_tag" value="fa-external-link" id="g_tag"></td>
                                      <td><i class="fa fa-sign-in"></i> <input type="radio" name="g_tag" value="fa-sign-in" id="g_tag"></td>
                                      <td><i class="fa fa-github-square"></i> <input type="radio" name="g_tag" value="fa-github-square" id="g_tag"></td>
                                      <td><i class="fa fa-lemon-o"></i> <input type="radio" name="g_tag" value="fa-lemon-o" id="g_tag"></td>
                                      <td><i class="fa fa-square-o"></i> <input type="radio" name="g_tag" value="fa-square-o" id="g_tag"></td>
                                      <td><i class="fa fa-bookmark-o"></i> <input type="radio" name="g_tag" value="fa-bookmark-o" id="g_tag"></td>
                                      <td><i class="fa fa-phone-square"></i> <input type="radio" name="g_tag" value="fa-phone-square" id="g_tag"></td>
                                      <td><i class="fa fa-credit-card"></i> <input type="radio" name="g_tag" value="fa-credit-card" id="g_tag"></td>
                                      <td><i class="fa fa-hdd-o"></i> <input type="radio" name="g_tag" value="fa-hdd-o" id="g_tag"></td>
                                      <td><i class="fa fa-list-ul"></i> <input type="radio" name="g_tag" value="fa-list-ul" id="g_tag"></td>
                                      <td><i class="fa fa-pinterest-square"></i> <input type="radio" name="g_tag" value="fa-pinterest-square" id="g_tag"></td>
                                      <td><i class="fa fa-google-plus"></i> <input type="radio" name="g_tag" value="fa-google-plus" id="g_tag"></td>
                                      <td><i class="fa fa-cloud-download"></i> <input type="radio" name="g_tag" value="fa-cloud-download" id="g_tag"></td>
                                      <td><i class="fa fa-cloud-upload"></i> <input type="radio" name="g_tag" value="fa-cloud-upload" id="g_tag"></td>
                                      <td><i class="fa fa-user-md"></i> <input type="radio" name="g_tag" value="fa-user-md" id="g_tag"></td>
                                      <td><i class="fa fa-fighter-jet"></i> <input type="radio" name="g_tag" value="fa-fighter-jet" id="g_tag"></td>
                                      <td><i class="fa fa-h-square"></i> <input type="radio" name="g_tag" value="fa-h-square" id="g_tag"></td>
                                      <td><i class="fa fa-mail-reply"></i> <input type="radio" name="g_tag" value="fa-mail-reply" id="g_tag"></td>
                                      <td><i class="fa fa-comment-o"></i> <input type="radio" name="g_tag" value="fa-comment-o" id="g_tag"></td>
                                    </tr>
                                  </tbody>
                                </table>
                              </div>
                            </section>
                          </div>
                        </div>
                    </div>
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
                  url: '/function/addgroup',
                  type: 'POST',
                  data: param,
                  dataType: 'json',
                  error: function(xhr, errortext, errorstatus) {
                    alert(errortext);
                  },
                  success: function(data, status) {
                    if (data.status == 0) {
                      location = "/function";
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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>登录</title>

    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-body">

<div class="container">

    <form class="form-signin" action="#">
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">登 录</h1>
            <img src="images/login-logo.png" alt=""/>
        </div>
        <div class="login-wrap">
            <input type="text" class="form-control" id="uname" placeholder="用户名" autofocus>
            <input type="password" class="form-control" id="upwd" placeholder="密码">

            <button class="btn btn-lg btn-login btn-block" id="sure">
                <i class="fa fa-check"></i>
            </button>
        </div>
    </form>

</div>

<!-- Placed js at the end of the document so the pages load faster -->
<!-- Placed js at the end of the document so the pages load faster -->
<script src="/js/jquery-1.10.2.min.js"></script>
<script src="/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/modernizr.min.js"></script>
<script src="/js/jquery.nicescroll.js"></script>
<script src="/js/scripts.js"></script>
<script type="text/javascript">
    !function(){
        $('#sure').on('click', function(e){
            e.preventDefault();
            var uname = $('#uname').val();
            var upwd = $('#upwd').val();
            if (!uname) {
                alert('请输入用户名');
                return false;
            }
            if (!upwd) {
                alert('请输入密码');
                return false;
            }
            $.showMask();
            $.ajax({
                url: '/logindo',
                type: 'POST',
                data: {name:uname, pwd:upwd},
                dataType: 'json',
                error: function(xhr, errortext, errorstatus) {
                    $.hideMask();
                    alert(errortext);
                },
                success: function(data, status) {
                    if (data.status==0) {
                        location = "/dashboard";
                    } else {
                        $.hideMask();
                        alert(data.msg);
                    }
                }
            })
        });
    }()
</script>
</body>
</html>

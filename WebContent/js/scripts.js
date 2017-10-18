
(function() {

    // custom scrollbar

    $("html").niceScroll({styler:"fb",cursorcolor:"#65cea7", cursorwidth: '6', cursorborderradius: '0px', background: '#424f63', spacebarenabled:false, cursorborder: '0',  zindex: '1000'});

    $(".left-side").niceScroll({styler:"fb",cursorcolor:"#65cea7", cursorwidth: '3', cursorborderradius: '0px', background: '#424f63', spacebarenabled:false, cursorborder: '0'});


    $(".left-side").getNiceScroll();
    if ($('body').hasClass('left-side-collapsed')) {
        $(".left-side").getNiceScroll().hide();
    }



    // Toggle Left Menu
   jQuery('.menu-list > a').click(function() {
      
      var parent = jQuery(this).parent();
      var sub = parent.find('> ul');
      
      if(!jQuery('body').hasClass('left-side-collapsed')) {
         if(sub.is(':visible')) {
            sub.slideUp(200, function(){
               parent.removeClass('nav-active');
               jQuery('.main-content').css({height: ''});
               mainContentHeightAdjust();
            });
         } else {
            visibleSubMenuClose();
            parent.addClass('nav-active');
            sub.slideDown(200, function(){
                mainContentHeightAdjust();
            });
         }
      }
      return false;
   });

   function visibleSubMenuClose() {
      jQuery('.menu-list').each(function() {
         var t = jQuery(this);
         if(t.hasClass('nav-active')) {
            t.find('> ul').slideUp(200, function(){
               t.removeClass('nav-active');
            });
         }
      });
   }

   function mainContentHeightAdjust() {
      // Adjust main content height
      var docHeight = jQuery(document).height();
      if(docHeight > jQuery('.main-content').height())
         jQuery('.main-content').height(docHeight);
   }

   //  class add mouse hover
   jQuery('.custom-nav > li').hover(function(){
      jQuery(this).addClass('nav-hover');
   }, function(){
      jQuery(this).removeClass('nav-hover');
   });


   // Menu Toggle
   jQuery('.toggle-btn').click(function(){
       $(".left-side").getNiceScroll().hide();
       
       if ($('body').hasClass('left-side-collapsed')) {
           $(".left-side").getNiceScroll().hide();
       }
      var body = jQuery('body');
      var bodyposition = body.css('position');

      if(bodyposition != 'relative') {

         if(!body.hasClass('left-side-collapsed')) {
            body.addClass('left-side-collapsed');
            jQuery('.custom-nav ul').attr('style','');

            jQuery(this).addClass('menu-collapsed');

         } else {
            body.removeClass('left-side-collapsed chat-view');
            jQuery('.custom-nav li.active ul').css({display: 'block'});

            jQuery(this).removeClass('menu-collapsed');

         }
      } else {

         if(body.hasClass('left-side-show'))
            body.removeClass('left-side-show');
         else
            body.addClass('left-side-show');

         mainContentHeightAdjust();
      }

   });
   

   searchform_reposition();

   jQuery(window).resize(function(){

      if(jQuery('body').css('position') == 'relative') {

         jQuery('body').removeClass('left-side-collapsed');

      } else {

         jQuery('body').css({left: '', marginRight: ''});
      }

      searchform_reposition();

   });

   function searchform_reposition() {
      if(jQuery('.searchform').css('position') == 'relative') {
         jQuery('.searchform').insertBefore('.left-side-inner .logged-user');
      } else {
         jQuery('.searchform').insertBefore('.menu-right');
      }
   }

    // panel collapsible
/*    $('.panel .tools .fa').click(function () {
        var el = $(this).parents(".panel").children(".panel-body");
        if ($(this).hasClass("fa-chevron-down")) {
            $(this).removeClass("fa-chevron-down").addClass("fa-chevron-up");
            el.slideUp(200);
        } else {
            $(this).removeClass("fa-chevron-up").addClass("fa-chevron-down");
            el.slideDown(200); }
    });*/

    $('.todo-check label').click(function () {
        $(this).parents('li').children('.todo-title').toggleClass('line-through');
    });

    $(document).on('click', '.todo-remove', function () {
        $(this).closest("li").remove();
        return false;
    });

    $("#sortable-todo").sortable();


    // panel close
    $('.panel .tools .fa-times').click(function () {
        $(this).parents(".panel").parent().hide();
        $('#mask-trans').hide();
    });



    // tool tips

    $('.tooltips').tooltip();

    // popovers

    $('.popovers').popover();


    $('.go-back').on('click', function(e){
      history.go(-1);
    });

    /*遮尘罩, 缓冲图*/
    $(function(){
        var $mask  = $('#mask-trans');
        var $buffer= $('#buffer');

        if(!$mask.length){
            $mask = $('<div id="mask-trans"></div>');
            $('body').prepend($mask);
        }
        if(!$buffer.length){
            $buffer = $('<img id="buffer" src="/images/input-spinner.gif">');
            $('body').prepend($buffer);
            var b_w = 66;
            var b_h = 66;
            $buffer.css({'top': ($(window).height()-b_h)/2, 'left': ($(window).width()-b_w)/2});
        }

        $buffer.on('load', function(){
            $(this).bind('ajaxSend', function(){
                $(this).show();
            }).ajaxComplete(function(){
                $(this).hide();
            });
        });

        $.extend({
            showMask: function(arg){
                $mask.show();
                arg&&arg.callback&&arg.callback();
                return this;
            },
            hideMask: function(arg){
                $mask.hide();
                $buffer.hide();
                arg&&arg.callback&&arg.callback();
                return this;
            },
            showBuffer: function(arg){
                $buffer.show();
                arg&&arg.callback&&arg.callback();
                return this;
            },
            hideBuffer: function(arg){
                $buffer.hide();
                arg&&arg.callback&&arg.callback();
                return this;
            },
            showUploadProgress: function(precent){
                var $bar = $('#uprocbar');
                if(!$bar.length){
                    $bar = $(''
                    +    '<div class="uprocbar f-cb ui-dialog" id="uprocbar">'
                    +       ' <div class="already"></div>'
                    +    '</div>'
                    +'');
                    $('body').prepend($bar);
                    var b_w = parseInt($bar.css('width'));
                    var b_h = parseInt($bar.css('height'));
                    var w_w = $(window).width();
                    var w_h = $(window).height();
                    $bar.css({'top': (w_h-b_h)/2, 'left': (w_w-b_w)/2});
                    $bar.find('.already').css('width', '0%');
                }
                if(precent<100){
                    $bar.show().find('.already').css('width', precent+'%');
                }else{
                    $bar.hide().find('.already').css('width', '0%');
                }
            }
        });
    });

    /*全局通用提示信息对话*/
    $(function(){
        var $prompt = $('#global-prompt');
        if(!$prompt.length){
            $prompt = $('<div class="global-prompt" id="global-prompt"></div>');
            $('body').prepend($prompt);
        }

        var clearid;

        $.extend({'prompt': function(msg, disappeartime, callback){
            $prompt.text(msg);
            $prompt.trigger('open');
            var time = disappeartime || 2000;
            if(typeof clearid === 'number'){
                clearTimeout(clearid);
            }
            clearid  = setTimeout(function(){
                $prompt.hide();
                callback&&callback();
            }, time);
        }});
    });


    /*所有ui-dialog弹出层居中显示, 在所有对话添加之后调用*/
    $(function(){
        var w_w = $(window).width();
        var w_h = $(window).height();

        $('.ui-dialog').bind('open', function(){
            var d_w = parseInt($(this).css('width'));
            var d_h = parseInt($(this).css('height'));
            $(this).css({'left':(w_w-d_w)/2+'px', 'top':(w_h-d_h)*2/5+'px'});
            $(this).show();
        }); 
        $('#global-prompt').bind('open', function(){
            var d_w = parseInt($(this).css('width'));
            var d_h = parseInt($(this).css('height'));
            $(this).css({'left':(w_w-d_w)/2+'px', 'top':(w_h-d_h)*2/5+'px'});
            $(this).show();
        }); 
        $('.ui-dialog').bind('show', function(){
            var d_w = parseInt($(this).css('width'));
            var d_h = parseInt($(this).css('height'));
            $(this).css({'left':(w_w-d_w)/2+'px', 'top':(w_h-d_h)*2/5+'px'});
            $(this).show();
        });
        $('.ui-dialog').bind('close', function(){
            $(this).hide();
            $.hideMask && $.hideMask();
        });
        $('.ui-dialog').find('.close, .cancel').on('click', function(){
            $('.ui-dialog').trigger('close');
        });

        var timeoutid;
        $(window).on('resize', function(){
            clearTimeout(timeoutid);
            timeoutid = setTimeout(resetWHP, 50);
        });
        function resetWHP(){
            w_w = $(window).width();
            w_h = $(window).height();
            $('.ui-dialog').each(function(index, val){
                if($(this).css('display')!='none'){
                    $(this).trigger('open');
                }
            });
        }
    });

    

})(jQuery);

$(function(){
  var $reason = $('.ui-dialog .reason');
  $('.ui-dialog .reason-list').delegate('li', 'click', function(e){
    var $checkbox = $(this).find('input[type=checkbox]');
    var ckval = $checkbox.val();
    var oldrea = $reason.val();
    if ($checkbox.is(':checked')) {
      $checkbox.removeAttr('checked');
      $reason.val(oldrea.replace('，' + ckval, '').replace(ckval, ''));
    } else {
      $checkbox.attr('checked', 'true');
      if (!!oldrea) {
        $reason.val($reason.val() + '，' + ckval);
      } else {
        $reason.val($reason.val() + ckval);
      }
    }
  });
});
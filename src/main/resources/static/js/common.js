$(function () {
    $(window).scroll(function () {
        if ($(this).scrollTop() != 0) {
            $('#buttonTop').fadeIn();
        } else {
            $('#buttonTop').fadeOut();
        }
    });
    $('#buttonTop').click(function () {
        $('body,html').animate({scrollTop: 0}, 700);
    });
});

$(document).ready(function(){
    $('.menu-toggle').on('click',function(){
        $('.menu-toggle').toggleClass('active');

        if ($('.header-right').is(':hidden')) {
            $('.header-right').show();
        } else {
            $('.header-right').hide();

        }
    });
});
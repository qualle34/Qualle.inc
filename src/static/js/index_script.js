


var menuButton = document.getElementById('header-menu');
var slideIndex = 2;

window.onload = currentSlide;

function currentSlide() {
    showSlides(2);
}

function plusSlides(n) {
    showSlides(slideIndex += n);
}

function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    if (n > slides.length) {
        slideIndex = 1
    }
    if (n < 1) {
        slideIndex = slides.length
    }
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    slides[slideIndex - 1].style.display = "block";
}







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

















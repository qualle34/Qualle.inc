var slideIndex = 2;

window.onload = currentSlide;

function currentSlide() {
    showSlides(2);
}

function plusSlides(n) {
    showSlides(slideIndex += n);
}

function showSlides(n) {

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


// showAds = setInterval(function () {
//     openPopup()
// }, 5000);
//
// function openPopup() {
//     var popup = document.getElementById("ads-popup");
//     popup.style.display = "block";
// }
//
// function closePopup() {
//     var popup = document.getElementById("ads-popup");
//     popup.style.display = "none";
// }
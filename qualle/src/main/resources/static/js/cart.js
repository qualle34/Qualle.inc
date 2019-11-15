window.onload = calculate;

function calculate() {
    var prices = document.getElementsByClassName("numPrice");
    var fullPrice = document.getElementById("fullPrice");

    var counter = 0;

    for (var i = 0; i < prices.length; i++) {
        counter += +prices.item(i).innerText;
    }

    if (counter === 0) {
        hideAmount();
    } else {
        hideNull();
    }
    fullPrice.innerHTML = counter;
}

function hideNull() {
    document.getElementById("nullText").style.display = "none";
}

function hideAmount() {
    document.getElementById("amountText").style.display = "none";
}
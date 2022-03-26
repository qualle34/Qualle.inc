window.onload = startTimer;

function countDownTimer(dt, id) {
    var end = new Date(dt);

    var _second = 1000;
    var _minute = _second * 60;
    var _hour = _minute * 60;
    var _day = _hour * 24;
    var timer;

    function showRemaining() {
        var now = new Date();
        var distance = end - now;

        if (distance < 0) {
            clearInterval(timer);
            document.getElementById(id).innerHTML = "0";
            return;
        }

        var days = Math.floor(distance / _day);
        var hours = Math.floor((distance % _day) / _hour);
        var minutes = Math.floor((distance % _hour) / _minute);
        var seconds = Math.floor((distance % _minute) / _second);

        document.getElementById(id).innerHTML = "До выхода ANTHEM - " + days + ' дней ' + hours + ' часов ' + minutes + ' минут ' + seconds + ' секунд';
    }

    timer = setInterval(showRemaining, 1000);
}

function startTimer() {
    countDownTimer('07/15/2022 10:1 AM', 'innerTimeTitle');
}
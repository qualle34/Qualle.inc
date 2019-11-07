const releaseDate = new Date(1575244800 * 1000);
const oneDay = 24 * 60 * 60 * 1000;

$(document).ready(function () {
    $('#innerTimeTitle').text(function (i, oldText) {
        return oldText + Math.round(new Date(releaseDate - $.now()) / oneDay) + ' Дней';
    });
});

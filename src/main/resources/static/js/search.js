GET: $(document).ready(
    function () {

        $("#find").click(function (event) {
            event.preventDefault();
            ajaxGet($("#search").val());
        });

        function ajaxGet(search) {
            $.ajax({
                type: "GET",
                url: "games/search",
                data : "search=" + search,
                success: function (result) {
                    $('#result').empty();
                    $.each(result,
                        function (i, game) {
                            $('#result').append("<a class=\"name\" href=\"/game/" + game.id + "\">" + game.name + "</a><div class=\"line\"></div>");
                        });
                },
                error: function (e) {
                    $("#result").html("<strong>Не найдено(</strong>");
                }
            });
        }
    });
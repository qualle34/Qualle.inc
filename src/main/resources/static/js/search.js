GET: $(document).ready(
    function () {

        $("#find").click(function (event) {
            event.preventDefault();
            ajaxGet($("#search").val());
        });

        function ajaxGet(search) {
            $.ajax({
                type: "GET",
                url: "product/search",
                data : "title=" + search,
                success: function (result) {
                    $('#result').empty();
                    $.each(result,
                        function (i, product) {
                            $('#result').append("<a class=\"name\" href=\"/product/" + product.id + "\">" + product.title + "</a><div class=\"line\"></div>");
                        });
                },
                error: function (e) {
                    $("#result").html("<strong>Не найдено(</strong>");
                }
            });
        }
    });
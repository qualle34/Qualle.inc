GET: $(document).ready(
    function () {

        $("#find").click(function (event) {
            event.preventDefault();
            ajaxGet($("#search").val());
        });

        function ajaxGet(search) {
            $.ajax({
                type: "GET",
                url: "products/search",
                data : "search=" + search,
                success: function (result) {
                    $('#result').empty();
                    $.each(result,
                        function (i, product) {
                            $('#result').append("<a class=\"name\" href=\"/product/" + product.id + "\">" + product.name + "</a><div class=\"line\"></div>");
                        });
                },
                error: function (e) {
                    $("#result").html("<strong>Не найдено(</strong>");
                }
            });
        }
    });
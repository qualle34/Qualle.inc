GET: $(document).ready(
    function () {

        $("#find").click(function (event) {
            event.preventDefault();

            var categories = $("div.category-switch-box input:checkbox:checked").map(function(){
                return $(this).val();
            }).get();

            var genres = $("div.genre-switch-box input:checkbox:checked").map(function(){
                return $(this).val();
            }).get();


            ajaxGet($("#search").val(), categories, genres);
        });

        function ajaxGet(search, categories, genres) {
            $.ajax({
                type: "GET",
                url: "product/search",
                data : "title=" + search + "&categories=" + categories.join(",") + "&genres=" + genres.join(","),
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
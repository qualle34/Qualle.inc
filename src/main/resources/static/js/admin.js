GET: $(document).ready(
    function () {

        $("#products").click(function (event) {
            event.preventDefault();
            getProducts();
        });

        $("#categories").click(function (event) {
            event.preventDefault();
            getCategories();
        });

        $("#genres").click(function (event) {
            event.preventDefault();
            getGenres();
        });

        $("#developers").click(function (event) {
            event.preventDefault();
            getDevelopers();
        });

        $("#feedbacks").click(function (event) {
            event.preventDefault();
            getFeedbacks();
        });

        $("#vacancies").click(function (event) {
            event.preventDefault();
            getVacancies();
        });

        $("#images").click(function (event) {
            event.preventDefault();
            getImages();
        });

        $("#users").click(function (event) {
            event.preventDefault();
            getUsers();
        });

        function getProducts() {
            $.ajax({
                type: "GET",
                url: "/admin/product",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, product) {
                            $('#table').append("<tr> <td> <a href=\"/admin/product/" + product.id + "\">" + product.id + "</a> </td> <td> <a href=\"/admin/product/" + product.id + "\">" + product.title + "</a> </td> </tr>");
                        });
                },
                error: function (e) {
                    $("#table").html("<strong>Не найдено(</strong>");
                }
            });
        }

        function getCategories() {
            $.ajax({
                type: "GET",
                url: "/admin/category",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, category) {
                            $('#table').append("<tr> <td> <a href=\"/admin/category/" + category.id + "\">" + category.id + "</a> </td> <td> <a href=\"/admin/category/" + category.id + "\">" + category.value + "</a> </td> </tr>");
                        });
                },
                error: function (e) {
                    $("#table").html("<strong>Не найдено(</strong>");
                }
            });
        }

        function getGenres() {
            $.ajax({
                type: "GET",
                url: "/admin/genre",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, genre) {
                            $('#table').append("<tr> <td> <a href=\"/admin/genre/" + genre.id + "\">" + genre.id + "</a> </td> <td> <a href=\"/admin/genre/" + genre.id + "\">" + genre.value + "</a> </td> </tr>");
                        });
                },
                error: function (e) {
                    $("#table").html("<strong>Не найдено(</strong>");
                }
            });
        }

        function getDevelopers() {
            $.ajax({
                type: "GET",
                url: "/admin/developer",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, developer) {
                            $('#table').append("<tr> <td> <a href=\"/admin/developer/" + developer.id + "\">" + developer.id + "</a> </td> <td> <a href=\"/admin/developer/" + developer.id + "\">" + developer.title + "</a> </td> </tr>");
                        });
                },
                error: function (e) {
                    $("#table").html("<strong>Не найдено(</strong>");
                }
            });
        }

        function getFeedbacks() {
            $.ajax({
                type: "GET",
                url: "/admin/feedback",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, feedback) {
                            $('#table').append("<tr> <td> <a href=\"/admin/feedback/" + feedback.id + "\">" + feedback.id + "</a> </td> <td> <a href=\"/admin/feedback/" + feedback.id + "\">" + feedback.title + "</a> </td> </tr>");
                        });
                },
                error: function (e) {
                    $("#table").html("<strong>Не найдено(</strong>");
                }
            });
        }

        function getVacancies() {
            $.ajax({
                type: "GET",
                url: "/admin/vacancy",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, vacancy) {
                            $('#table').append("<tr> <td> <a href=\"/admin/vacancy/" + vacancy.id + "\">" + vacancy.id + "</a> </td> <td> <a href=\"/admin/category/" + vacancy.id + "\">" + vacancy.title + "</a> </td> </tr>");
                        });
                },
                error: function (e) {
                    $("#table").html("<strong>Не найдено(</strong>");
                }
            });
        }

        function getImages() {
            $.ajax({
                type: "GET",
                url: "/admin/image",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, image) {
                            $('#table').append("<tr> <td> <a href=\"/admin/image/" + image.id + "\">" + image.id + "</a> </td> <td> <a href=\"/admin/image/" + image.id + "\">" + image.link + "</a> </td> </tr>");
                        });
                },
                error: function (e) {
                    $("#table").html("<strong>Не найдено(</strong>");
                }
            });
        }

        function getUsers() {
            $.ajax({
                type: "GET",
                url: "/admin/user",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, user) {
                            $('#table').append("<tr> <td> <a href=\"/admin/user/" + user.id + "\">" + user.id + "</a> </td> <td> <a href=\"/admin/user/" + user.id + "\">" + user.name + ' ' + user.lastname + "</a> </td> </tr>");
                        });
                },
                error: function (e) {
                    $("#table").html("<strong>Не найдено(</strong>");
                }
            });
        }
    });
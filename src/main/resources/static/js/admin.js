GET: $(document).ready(
    function () {

        $("#main").click(function (event) {
            event.preventDefault();
            reset();
            $('#add-menu').css('display', 'block');
        });

        $("#products").click(function (event) {
            event.preventDefault();
            reset();
            $('#sorting-box').css('display', 'block');
            getProducts();
        });

        $("#categories").click(function (event) {
            event.preventDefault();
            reset();
            getCategories();
        });

        $("#genres").click(function (event) {
            event.preventDefault();
            reset();
            getGenres();
        });

        $("#developers").click(function (event) {
            event.preventDefault();
            reset();
            getDevelopers();
        });

        $("#feedbacks").click(function (event) {
            event.preventDefault();
            reset();
            getFeedbacks();
        });

        $("#vacancies").click(function (event) {
            event.preventDefault();
            reset();
            getVacancies();
        });

        $("#images").click(function (event) {
            event.preventDefault();
            reset();
            getImages();
        });

        $("#users").click(function (event) {
            event.preventDefault();
            reset();
            getUsers();
        });

        $("#db_functions_btn").click(function (event) {
            event.preventDefault();
            reset();
            $('#db_functions').css('display', 'block');
        });

        $("#sort-btn").click(function (event) {
            event.preventDefault();
            reset();
            getSorted($("#sorting").children("option:selected").val());
        });

        function reset() {
            $('#table').empty();
            $('#db_functions').css('display', 'none');
            $('#add-menu').css('display', 'none');
            $('#sorting-box').css('display', 'none');
        }


        function getSorted(sort) {
            $.ajax({
                type: "GET",
                url: "/product/search?sort=" + sort,
                success: function (result) {
                    $('#table').append("<tr><th>Идентификатор</th><th>Название</th> </tr>");
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


        function getProducts() {
            $.ajax({
                type: "GET",
                url: "/admin/product",
                success: function (result) {
                    $('#table').append("<tr><th>Идентификатор</th><th>Название</th> </tr>");
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
                    $('#table').append("<tr><th>Идентификатор</th><th>Название</th> </tr>");
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
                    $('#table').append("<tr><th>Идентификатор</th><th>Название</th> </tr>");
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
                    $('#table').append("<tr><th>Идентификатор</th><th>Название</th> </tr>");
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
                    $('#table').append("<tr><th>Идентификатор</th><th>Название</th> </tr>");
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
                    $('#table').append("<tr><th>Идентификатор</th><th>Название</th> </tr>");
                    $.each(result,
                        function (i, vacancy) {
                            $('#table').append("<tr> <td> <a href=\"/admin/vacancy/" + vacancy.id + "\">" + vacancy.id + "</a> </td> <td> <a href=\"/admin/vacancy/" + vacancy.id + "\">" + vacancy.title + "</a> </td> </tr>");
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
                    $('#table').append("<tr><th>Идентификатор</th><th>Название</th> </tr>");
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
                    $('#table').append("<tr><th>Идентификатор</th><th>Название</th> </tr>");
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
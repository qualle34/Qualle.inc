GET: $(document).ready(
    function () {

        $("#games").click(function (event) {
            event.preventDefault();
            getGames();
        });

        $("#categories").click(function (event) {
            event.preventDefault();
            getCategories();
        });

        $("#developers").click(function (event) {
            event.preventDefault();
            getDevelopers();
        });

        $("#users").click(function (event) {
            event.preventDefault();
            getUsers();
        });

        $("#summaries").click(function (event) {
            event.preventDefault();
            getSummaries();
        });

        function getGames() {
            $.ajax({
                type: "GET",
                url: "/admin/games",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, game) {
                            $('#table').append("<tr> <td> <a href=\"/admin/game/" + game.id + "\">" + game.id + "</a> </td> <td> <a href=\"/admin/game/" + game.id + "\">" + game.name + "</a> </td> </tr>");
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
                url: "/admin/categories",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, category) {
                            $('#table').append("<tr> <td> <a href=\"/admin/category/" + category.id + "\">" + category.id + "</a> </td> <td> <a href=\"/admin/category/" + category.id + "\">" + category.title + "</a> </td> </tr>");
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
                url: "/admin/developers",
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

        function getUsers() {
            $.ajax({
                type: "GET",
                url: "/admin/users",
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

        function getSummaries() {
            $.ajax({
                type: "GET",
                url: "/admin/summaries",
                success: function (result) {
                    $('#table').empty().append("<tr><th>id</th><th>name</th> </tr>");
                    $.each(result,
                        function (i, summary) {
                            $('#table').append("<tr> <td> <a href=\"/admin/summary/" + summary.id + "\">" + summary.id + "</a> </td> <td> <a href=\"/admin/summary/" + summary.id + "\">" + summary.name + ' - ' + summary.email + "</a> </td> </tr>");
                        });
                },
                error: function (e) {
                    $("#table").html("<strong>Не найдено(</strong>");
                }
            });
        }
    });
$(document).ready(function () {
    $('a[href=catalogue]').on('click', function (event) {
        event.preventDefault();

        if ($('body').children().length<6) {
            $.ajax({
                url: "/rest/work",
                success: function (result) {
                    var catalog='';
                    result.forEach(function(nextWork){
                        catalog=catalog.concat(nextWork.title+" ("+nextWork.annee+")<BR/>");
                    });

                    $("a[href=catalogue]").after('<br>'+catalog);
                }
            });
        }
    });

    $('input').last().on('click', function (event) {
        event.preventDefault();
        $.ajax({
                method: "POST",
                url: "rest/work/",
                data: $("form").serialize(),
                success: function(result) {
                }
            });
    });

});


$(document).ready(function () {
    $('#submitbtn').click(function (event) {
        $.ajax({
            url: 'http://localhost:8080/SimonBorgstromIn1JavaBackend/myservlet',
            type: 'post',
            // dataType: 'json',
            data: $('#form').serialize(),
            success: function (data)
            {
                console.log("test");
                updateList();

            }
        });
        event.preventDefault();
    });
});

function updateList() {
    $("#table tbody").empty();
    $.getJSON("http://localhost:8080/SimonBorgstromIn1JavaBackend/myservlet", function (data) {
        $.each(data, function (i, fromservlet) {
            $("#table tbody").append("<tr><td>" + fromservlet.Description +
                    "</td><td id=\"editdate\">" + fromservlet.Duedate + "</td><td>" + "<input type=\"checkbox\" id=\"inlineCheckbox1\" value=\"option1\" name=\"done\"> Klart" + "</td></tr>");
        });
    });
}

$(document).ready(function () {
    $("#table").delegate('#editdate', 'click', function (e) {
        e.preventDefault();
        var text = prompt("prompt", "textbox's intial text");
      //  $(this).html(text);
        $.ajax({
            url: 'http://localhost:8080/SimonBorgstromIn1JavaBackend/myservlet',
            type: 'post',
            // dataType: 'json',
            data:{'key': $(this).parent().index()
                , 'duedate':text},
            success: function (data)
            {
                updateList();
            }
        });

    });
});




$(document).ready(function(){
  $('#submitbtn').click( function(event) {
    $.ajax({
      url: 'http://localhost:12683/SimonBorgstromIn1JavaBackend/myservlet',
      type: 'post',
     // dataType: 'json',
      data: $('#form').serialize(),
      success: function(data)
      {
      //   alert("in success");
       
     //       $("#table tbody").append("<tr><td>" + data.Description + 
      //"</td><td>" + data.Duedate + "</td> <td> <input type=\"checkbox\" id=\"inlineCheckbox1\" value=\"option1\" name=\"done\"> Klart</td></tr>");
      console.log("test");
          updateList();
       
      }
    });
  event.preventDefault();});
});

function updateList() {
 // $("#table tbody").clear();
$.getJSON("http://localhost:12683/SimonBorgstromIn1JavaBackend/myservlet", function(data){
  $.each(data, function(i, fromservlet){
    $("#table tbody").append("<tr><td>" + fromservlet.Description + 
      "</td><td>" + fromservlet.Duedate + "</td></tr>");
  });
});
}

//must run on server side, don't run from local file

$(document).ready(function()
{
  request_navigator();
});

function request_navigator()
{
  $.ajax(
  {
    cache: false,
    url: 'navigator.html',
    type: 'GET',
    dataType : 'text',//response data type
    success : function(data, status, xhr)
    {
      var navigator_obj = document.getElementById("navigator");
      navigator_obj.innerHTML = data;
    },
    error : function(xhr, status, error)
    {
      alert("Fail - " + xhr.statusText + " - " + xhr.status + " - " + error);
    }
  });
}
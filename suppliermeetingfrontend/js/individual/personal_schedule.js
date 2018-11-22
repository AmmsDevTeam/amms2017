$(document).ready(function(){
	$('#select_enrollment_btn').click(function(){
		var cellPhoneNum = $('#cell_phone_num_txt').val();		
		if (cellPhoneNum.length > 0){
			$.get(one_enrollment_url+"/"+cellPhoneNum, function(data){
				var info = $(data).find("enrollment");
				if (info.length > 0){
					$('#cell_phone_num_label').text(info.children("cellPhoneNum").text());
					$('#full_name_label').text(info.children("fullName").text());
					$('#supplier_name_label').text(info.children("supplierName").text());
					$('#title_label').text(info.children("title").text());
					$('#meeting_seat_num_label').text(info.children("meetingSeatNum").text());
					$('#dinner_seat_num_label').text(info.children("dinnerSeatNum").text());
					var dinnerSeatNum = info.children("dinnerSeatNum").text();
					var dinnerResult = "";
					
					$.get(select_dinner_partner_url+"/"+dinnerSeatNum, function(data){
						$(data).find("enrollment").each(function(){
						    var fullName = $(this).children("fullName").text();
						    var title = $(this).children("title").text();
						    var supplierName = $(this).children("supplierName").text();		
						    dinnerResult += "<tr>"
						  		   +"<td>"+fullName+"</td>"   
						  		   +"<td>"+title+"</td>"
						           +"<td>"
							       +"<button onclick=\"alert('"+supplierName+"')\">查看</button>"
							       +"</td></tr>";
						});
						
						var resultpanel = document.getElementById("dinner_partner");
						resultpanel.innerHTML = dinnerResult;
					});
				}
			});
			
			$.get(select_schedule_url+"/"+cellPhoneNum, function(data){
				var result = "";
				$(data).find("schedule").each(function(){
				    var timeArrange = $(this).children("timeArrange").text();
				    var activationPlace = $(this).children("activationPlace").text();
				    var activationTitle = $(this).children("activationTitle").text();		
				  	result += "<tr>"
				  		   +"<td>"+timeArrange+"</td>"   
				  		   +"<td>"+activationPlace+"</td>"
				           +"<td>"+activationTitle+"</td></tr>";
				});
				
				var resultpanel = document.getElementById("activity");
				resultpanel.innerHTML = result;
			});
		}
	});	
});
function doSomething(s)
{
	var str = s;
	alert(str);
}
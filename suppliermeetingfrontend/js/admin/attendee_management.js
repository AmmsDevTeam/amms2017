$(document).ready(function(){	
	bind_attendee();
});

function bind_attendee()
{
	$.ajax(
	{
		async : false,
		cache : false,
		url : all_enrollment_url,
		type : 'GET',
		success : function(data, status, xhr)
		{
			var result = "";
			var number = 0;
		    $(data).find("enrollment").each(function()
		    {
		    	number = number + 1;
			    var cellPhoneNum = $(this).children("cellPhoneNum").text();
			    var fullName = $(this).children("fullName").text();
			    var title = $(this).children("title").text();
			    var gender = $(this).children("gender").text();
			    var isDinner = $(this).children("supplierCode").text();
			    var supplierName = $(this).children("supplierName").text();
			    var estimateArriveTime = $(this).children("estimateArriveTime").text();
			    var isVisited = $(this).children("isVisited").text();
			    var isSelfDrive = $(this).children("isSelfDrive").text();
			    var shuttleDestination = $(this).children("shuttleDestination").text();
			    var meetingSeatNum = $(this).children("meetingSeatNum").text();
			    var dinnerSeatNum = $(this).children("dinnerSeatNum").text();
			    var checkIn = $(this).children("comment").text();		
			  	result += "<tr>"
			  		   +"<td>"+number+"</td>"   
			  		   +"<td>"+cellPhoneNum+"</td>"
			           +"<td>"+fullName+"</td>"
			           +"<td>"+title+"</td>"
			           +"<td>"+gender+"</td>"
			           +"<td>"+isDinner+"</td>"
			           +"<td>"+supplierName+"</td>"
			           +"<td>"+estimateArriveTime+"</td>"
			           +"<td>"+isVisited+"</td>"
			           +"<td>"+isSelfDrive+"</td>"
			           +"<td>"+shuttleDestination+"</td>"
			           +"<td>"+meetingSeatNum+"</td>"
			           +"<td>"+dinnerSeatNum+"</td>"
			           +"<td>"+checkIn+"</td>"
			           +"<td><button class=\"btn btn-primary btn-sm active\" onclick=\"open_edit_attendee(this)\">编辑</button></td>"
			});

			var resultpanel = document.getElementById("resultpanel");
			resultpanel.innerHTML = result;
		},
		error : function(xhr, status, error)
		{
			alert("Fail - " + xhr.statusText + " - " + xhr.status + " - " + error);
		}
	});
}

function open_edit_attendee(row)
{
	var row_number = row.parentNode.parentNode.rowIndex;
	var cell_phone_num = $("#attendee_table tr:eq(" + row_number + ") td:eq(1)").html();
	open_edit_dialog();	
	get_edit_attendee(cell_phone_num);
}

function get_edit_attendee(cellPhoneNum)
{
	$.get(one_enrollment_url+"/"+cellPhoneNum, function(data)
	{
		var info = $(data).find("enrollment");
		if (info.length > 0)
		{
			$('#cell_phone_txt').val(info.children("cellPhoneNum").text());
			$('#attendee_name_txt').val(info.children("fullName").text());
			$('#title_txt').val(info.children("title").text());
			$('#gender_opt').val(info.children("gender").text());
			$('#is_dinner_opt').val(info.children("supplierCode").text());
			$('#supplier_name_txt').val(info.children("supplierName").text());
			$('#estimate_arrive_time_txt').val(info.children("estimateArriveTime").text());
			$('#is_visited_opt').val(info.children("isVisited").text());
			$('#is_self_drive_opt').val(info.children("isSelfDrive").text());
			$('#shuttle_opt').val(info.children("shuttleDestination").text());
			$('#meeting_seat_num_txt').val(info.children("meetingSeatNum").text());				
			$("#dinner_seat_num_opt").val(info.children("dinnerSeatNum").text());
			$('#checkin_opt').val(info.children("comment").text());
		}
	});
}

function save_edit_attendee()
{
	var cell_phone_num = $('#cell_phone_txt').val();
	var attendeeName = $('#attendee_name_txt').val();
	var title = $('#title_txt').val();
	var gender = $("#gender_opt option:selected").val();
	var isDinner = $("#is_dinner_opt option:selected").val();
	var supplierName = $('#supplier_name_txt').val();
	var arriveTime = $('#estimate_arrive_time_txt').val();			
	var isVisited = $("#is_visited_opt option:selected").val();
	var isSelfDrive = $("#is_self_drive_opt option:selected").val();
	var shuttle = $("#shuttle_opt option:selected").val();
	var meetingSeatNum = $('#meeting_seat_num_txt').val();
	var dinnerSeatNum = $("#dinner_seat_num_opt option:selected").val();
	var checkin = $("#checkin_opt option:selected").val();
	var content = "{'cellPhoneNum':'"+cell_phone_num+"','fullName':'"+attendeeName+"','title':'"+title+"','gender':'"+gender+"','supplierCode':'"+isDinner+"','supplierName':'"+supplierName+"','estimateArriveTime':'"+arriveTime+"','isVisited':'"+isVisited+"','isSelfDrive':'"+isSelfDrive+"','shuttleDestination':'"+shuttle+"','meetingSeatNum':'"+meetingSeatNum+"','dinnerSeatNum':'"+dinnerSeatNum+"','comment':'"+checkin+"'}";

	$.ajax(
	{
		url: update_enrollment_url,
		type: 'POST',
		data: "content="+content,
		success: function(data)
		{
		}
	});

	close_edit_dialog();
	bind_attendee();
}

function open_schedule(row)
{
	var row_number = row.parentNode.parentNode.rowIndex;
	var cell_phone_num = $("#attendee_table tr:eq(" + row_number + ") td:eq(1)").html();
	open_schedule_dialog();
}

function open_edit_dialog()
{
	document.getElementById('edit_light').style.display='block';
	document.getElementById('edit_fade').style.display='block';
}

function close_edit_dialog()
{
    document.getElementById('edit_light').style.display='none';
    document.getElementById('edit_fade').style.display='none';
}

function open_schedule_dialog()
{
	document.getElementById('schedule_light').style.display='block';
	document.getElementById('schedule_fade').style.display='block';
}

function close_schedule_dialog()
{
    document.getElementById('schedule_light').style.display='none';
    document.getElementById('schedule_fade').style.display='none';
}
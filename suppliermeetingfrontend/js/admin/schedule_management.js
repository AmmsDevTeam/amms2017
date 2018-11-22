$(document).ready(function()
{
	var cellPhoneNum = 0;

	$('#search_btn').click(function()
	{
		cellPhoneNum = $('#cell_phone_txt').val();
		bind_schedule(cellPhoneNum);

	});
	
	$('#save_add_schedule_btn').click(function()
	{
		add_schedule(cellPhoneNum);
		close_add_schedule_dialog();
	});
	
	$('#delete_schedule_btn').click(function()
	{
		$.ajax(
		{
			async : false,
			cache : false,
			url: delete_schedule_url+"/"+cellPhoneNum,
			type: 'GET',
			data: "",
			success: function(data)
			{
				bind_schedule(cellPhoneNum);
			}
		});
	});

	$('#open_add_schedule_btn').click(function()
	{
		open_add_schedule_dialog();
	});

	$('#close_add_schedule_btn').click(function()
	{
		close_add_schedule_dialog();
	});
});

function bind_schedule(cellPhoneNum)
{
	$.ajax(
	{
		async : false,
		cache : false,
		url : select_schedule_url+"/"+cellPhoneNum,
		type : 'GET',
		success : function(data, status, xhr)
		{
			var result = "";
			var number = 0;
		    $(data).find("schedule").each(function()
		    {
		    	number = number + 1;
			    var cellPhoneNum1 = $(this).children("cellPhoneNum").text();
			    var timeArrange = $(this).children("timeArrange").text();			    
			    var activationPlace = $(this).children("activationPlace").text();
			    var activationTitle = $(this).children("activationTitle").text();		
			  	result += "<tr>"
			  		   +"<td>"+number+"</td>"   
			  		   +"<td>"+cellPhoneNum1+"</td>"
			           +"<td>"+timeArrange+"</td>"
			           +"<td>"+activationPlace+"</td>"
			           +"<td>"+activationTitle+"</td></tr>";
		    });
			var resultpanel = document.getElementById("resultpanel");
			resultpanel.innerHTML = result;
		}
	});
}

function add_schedule(cellPhoneNum)
{
	var timeArrangeOne = $('#time_arrange_txt_one').text();
	var activationPlaceOne = $('#activation_place_txt_one').val();
	var activationTitleOne = $('#activation_title_txt_one').val();

	var timeArrangeTwo = $('#time_arrange_txt_two').text();
	var activationPlaceTwo = $('#activation_place_txt_two').val();
	var activationTitleTwo = $('#activation_title_txt_two').val();
	
	var timeArrangeThree = $('#time_arrange_txt_three').text();
	var activationPlaceThree = $('#activation_place_txt_three').val();
	var activationTitleThree = $('#activation_title_txt_three').val();
	
	var timeArrangeFour = $('#time_arrange_txt_four').text();
	var activationPlaceFour = $('#activation_place_txt_four').val();
	var activationTitleFour = $('#activation_title_txt_four').val();
	
	var timeArrangeFive = $('#time_arrange_txt_five').text();
	var activationPlaceFive = $('#activation_place_txt_five').val();
	var activationTitleFive = $('#activation_title_txt_five').val();
	
	var contentOne = "{'cellPhoneNum':'"+cellPhoneNum+"','fullName':'','timeArrange':'"+timeArrangeOne+"','activationPlace':'"+activationPlaceOne+"','activationTitle':'"+activationTitleOne+"'}";
	var contentTwo = "{'cellPhoneNum':'"+cellPhoneNum+"','fullName':'','timeArrange':'"+timeArrangeTwo+"','activationPlace':'"+activationPlaceTwo+"','activationTitle':'"+activationTitleTwo+"'}";
	var contentThree = "{'cellPhoneNum':'"+cellPhoneNum+"','fullName':'','timeArrange':'"+timeArrangeThree+"','activationPlace':'"+activationPlaceThree+"','activationTitle':'"+activationTitleThree+"'}";
	var contentFour = "{'cellPhoneNum':'"+cellPhoneNum+"','fullName':'','timeArrange':'"+timeArrangeFour+"','activationPlace':'"+activationPlaceFour+"','activationTitle':'"+activationTitleFour+"'}";
	var contentFive = "{'cellPhoneNum':'"+cellPhoneNum+"','fullName':'','timeArrange':'"+timeArrangeFive+"','activationPlace':'"+activationPlaceFive+"','activationTitle':'"+activationTitleFive+"'}";

	$.ajax(
	{
		async : false,
		cache : false,
		url: insert_schedule_url,
		type: 'PUT',
		data: "content="+contentOne,
		success: function(data)
		{
		}
	});
	
	$.ajax(
			{
				async : false,
				cache : false,
				url: insert_schedule_url,
				type: 'PUT',
				data: "content="+contentTwo,
				success: function(data)
				{
				}
			});
	
	$.ajax(
			{
				async : false,
				cache : false,
				url: insert_schedule_url,
				type: 'PUT',
				data: "content="+contentThree,
				success: function(data)
				{
				}
			});
	
	$.ajax(
			{
				async : false,
				cache : false,
				url: insert_schedule_url,
				type: 'PUT',
				data: "content="+contentFour,
				success: function(data)
				{
				}
			});
	
	$.ajax(
			{
				async : false,
				cache : false,
				url: insert_schedule_url,
				type: 'PUT',
				data: "content="+contentFive,
				success: function(data)
				{
				}
			});
		
	bind_schedule(cellPhoneNum);
}

function open_add_schedule_dialog()
{
	document.getElementById('add_schedule_light').style.display='block';
	document.getElementById('add_schedule_fade').style.display='block';
}

function close_add_schedule_dialog()
{
    document.getElementById('add_schedule_light').style.display='none';
    document.getElementById('add_schedule_fade').style.display='none';
}
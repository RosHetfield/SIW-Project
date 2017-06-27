var PT = 0, DT = 0, CT = 0, AT = 0;
var PP = 0, DP = 0, CP = 0, AP = 0;
var PM = 1, DM = 0, CM = 0, AM = 0;

var startMoving = function(event, ui) {
	$(ui.item).addClass("moving-color");
};

var stopMoving = function(event, ui) {
	$(ui.item).removeClass("moving-color");
};

var fixHelper = function(e, ui) {
	ui.children().each(function() {
		$(this).width($(this).width());
	});
	return ui;
};

var receivePT = function(event, ui) {

	if ($(ui.item).hasClass('role-1') && PT < PM) {
		PT++;
		if (ui.sender.attr("id") == "tbody3") {
			PP--;
		}
		console.log("PortieriT " + PT);
	} else if ($(ui.item).hasClass('role-2') && DT < DM) {
		DT++;
		if (ui.sender.attr("id") == "tbody3") {
			DP--;
		}
		console.log("DifensoriT " + DT);
	} else if ($(ui.item).hasClass('role-3') && CT < CM) {
		CT++;
		if (ui.sender.attr("id") == "tbody3") {
			CP--;
		}
		console.log("CentrocampistiT " + CT);
	} else if ($(ui.item).hasClass('role-4') && AT < AM) {
		AT++;
		if (ui.sender.attr("id") == "tbody3") {
			AP--;
		}
		console.log("AttaccantiT " + AT);
	} else {
		$(ui.sender).sortable('cancel');

	}
}

var receivePP = function(event, ui) {

	if ($(ui.item).hasClass('role-1') && PP < 1) {
		PP++;
		if (ui.sender.attr("id") == "tbody2") {
			PT--;
		}
		console.log("PortieriP " + PP);
	} else if ($(ui.item).hasClass('role-2') && DP < 2) {
		DP++;
		if (ui.sender.attr("id") == "tbody2") {
			DT--;
		}
		console.log("DifensoriP " + DP);
	} else if ($(ui.item).hasClass('role-3') && CP < 2) {
		CP++;
		if (ui.sender.attr("id") == "tbody2") {
			CT--;
		}
		console.log("CentrocampistiP " + CP);
	} else if ($(ui.item).hasClass('role-4') && AP < 2) {
		AP++;
		if (ui.sender.attr("id") == "tbody2") {
			AT--;
		}
		console.log("AttaccantiP " + AP);
	} else {
		$(ui.sender).sortable('cancel');

	}
}

function setModulo(modulo) {
	if (modulo == 1) {
		DM = 4;
		CM = 4;
		AM = 2;
	} else if (modulo == 2) {
		DM = 4;
		CM = 3;
		AM = 3;
	} else if (modulo == 3) {
		DM = 3;
		CM = 5;
		AM = 1;
	} else if (modulo == 4) {
		DM = 3;
		CM = 4;
		AM = 3;
	}
}

var receiveAll = function(event, ui) {
	if ($(ui.sender).attr('id') == "tbody2") {
		if ($(ui.item).hasClass('role-1')) {
			PT--;
			console.log("Portieri T" + PT)
		} else if ($(ui.item).hasClass('role-2')) {
			DT--;
		} else if ($(ui.item).hasClass('role-3')) {
			CT--;
		} else if ($(ui.item).hasClass('role-4')) {
			AT--;
		}
	} else if ($(ui.sender).attr('id') == "tbody3") {
		if ($(ui.item).hasClass('role-1')) {
			PP--;
			console.log("Portieri P" + PP)
		} else if ($(ui.item).hasClass('role-2')) {
			DP--;
		} else if ($(ui.item).hasClass('role-3')) {
			CP--;
		} else if ($(ui.item).hasClass('role-4')) {
			AP--;
		}
	}
}

function init() {

	$( "#myselect" )
	  .change(function() {
	   
	    $( "#myselect option:selected" ).each(function() {
	      setModulo( $( this ).val() );
	    });
	  })
	  .trigger( "change" );

	$("#tbody1").sortable({
		helper : fixHelper,
		connectWith : ".connectedSortable",
		items : "tr",
		start : startMoving,
		stop : stopMoving,
		receive : receiveAll
	}).disableSelection();

	$("#tbody2").sortable({
		helper : fixHelper,
		connectWith : ".connectedSortable",
		items : "tr",
		start : startMoving,
		stop : stopMoving,
		receive : receivePT
	}).disableSelection();

	$("#tbody3").sortable({
		helper : fixHelper,
		connectWith : ".connectedSortable",
		items : "tr",
		start : startMoving,
		stop : stopMoving,
		receive : receivePP
	}).disableSelection();
}

$(document).ready(init);

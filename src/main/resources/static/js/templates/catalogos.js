$( document ).ready(function() {
    $("#desc").focus();
});

function showModal(id, desc){
    $('#updateDescCatalogoLongTitle').text('Actualizar a: ' + desc);
    $('#updateDescCatalogo').modal('toggle');
    $('#idItem').val(id);
    $('#updateDescCatalogo #descripcion').val(desc);

    setTimeout(function(){
      $('#updateDescCatalogo #descripcion').select();
    }, 500);
}

function fechaFormato(){
    var d = new Date(),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

        console.log(month);
        console.log(day);
        console.log(year);

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}

(function() {
	'use strict';
  	window.addEventListener('load', function() {
    	// Fetch all the forms we want to apply custom Bootstrap validation styles to
    	var forms = document.getElementsByClassName('needs-validation');

    	// Loop over them and prevent submission
    	var validation = Array.prototype.filter.call(forms, function(form) {

      		form.addEventListener('submit', function(event) {
      		    event.preventDefault();
                event.stopPropagation();

        		if (!(form.checkValidity() === false)) {
                    const actionType = $(form).find("#action-type").val().trim();
                    const url = "/service/" + $("#url-type").val().trim() + "/";
                    var type;
                    var fJson;
                    var json;

                    if(actionType === "insert"){
                        type = "post";
                        fJson = {
                            "descripcion": $(form).find('#descripcion').val().trim()
                        };
                    }

                    else if(actionType === "update"){
                        type = "put";
                        fJson = {
                            "id": $(form).find('#idItem').val().trim(),
                            "descripcion": $(form).find('#descripcion').val().trim()
                        };
                    }

                    json = JSON.stringify(fJson);

        			$.ajax({
						type: type,
				    	url: contextRoot+url,
                        data: json,
                        contentType: "application/json",
				    	context: this,
				   	 	cache : false,
				   	 	async: false,
				    	success: function(result){
				    	    //console.log(result);

                            if(actionType === "insert"){
                                var table = document.getElementById("tablaCatalogo");

                                var row = table.insertRow(table.rows.length);
                                var cell0 = row.insertCell(0);
                                var cell1 = row.insertCell(1);
                                var cell2 = row.insertCell(2);
                                $(cell1).attr('id', 'tdDesc'+result.id);
                                $(cell2).attr('id', 'tdBtn'+result.id);
                                $(cell2).addClass('text-right');
                                cell0.innerHTML = result.id;
                                cell1.innerHTML = result.descripcion;
                                cell2.innerHTML = `<button type="button" class="btn btn-primary btn-icon btn-sm" data-toggle="modal"
                                                        onclick="showModal('` + result.id + `', '` + result.descripcion + `')"
                                                        rel="tooltip" title="Actualizar la descripción">
                                                        <i class="fa fa-pencil"></i>
                                                   </button>`;

                                if(parseInt(document.getElementById("cantList").value) === 0){
                                    table.deleteRow(1);
                                    document.getElementById("cantList").value = table.rows.length;
                                }

                                $(form).find('#descripcion').select();
                            }

                            else if(actionType === "update"){
                                $("#tdDesc"+result.id).text(result.descripcion);
                                $('#updateDescCatalogo').modal('toggle');
                                $("#tdBtn"+result.id).html(
                                        `<button type="button" class="btn btn-primary btn-icon btn-sm" data-toggle="modal"
                                            onclick="showModal('` + result.id + `', '` + result.descripcion + `')"
                                            rel="tooltip" title="Actualizar la descripción">
                                            <i class="fa fa-pencil"></i>
                                        </button>`);
                            }
			         	},
			         	error: function(result) {
				     		$.notify({
                            	// options
                            	message: result.responseJSON.mensage
                            },{
                            	// settings
                            	type: 'danger'
                            });
					    }
					});
        		}
        		form.classList.add('was-validated');
      		}, false);
    	});
 	}, false);
})();
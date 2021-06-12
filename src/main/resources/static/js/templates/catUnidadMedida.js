$( document ).ready(function() {
    $("#desc").focus();
});

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
                    const actionType = $(form).find("#action-type").attr("action-type").trim();
                    var desc;
                    var id;
                    var type;
                    var fJson;
                    var json;

                    if(actionType === "insert"){
                        desc = $(form).find('#desc').val().trim();
                        type = "post";
                        fJson = {desc: desc};
                    }

                    else if(actionType === "update"){
                        desc = $(form).find('#desc').val().trim();
                        id = $(form).find('#idItem').val().trim();
                        type = "put";
                        fJson = {desc: desc, id: id};
                    }

                    json = JSON.stringify(fJson);

        			$.ajax({
						type: type,
				    	url: contextRoot+"/service/unidadMedida/",
                        data: json,
                        contentType: "application/json",
				    	context: this,
				   	 	cache : false,
				   	 	async: false,
				    	success: function(result){
				    	    //console.log(result);

                            if(actionType === "insert"){
                                var table = document.getElementById("tablaUnidadesMedida");
                                if(parseInt(document.getElementById("cantList").value) === 0){
                                    table.deleteRow(1);
                                    document.getElementById("cantList").value = table.rows.length;
                                }
                                var row = table.insertRow(table.rows.length);
                                var cell0 = row.insertCell(0);
                                var cell1 = row.insertCell(1);
                                var cell2 = row.insertCell(2);
                                var cell3 = row.insertCell(3);
                                $(cell1).attr('id', 'tdDesc'+result.id);
                                $(cell3).addClass('text-right');
                                cell0.innerHTML = result.id;
                                cell1.innerHTML = result.desc;
                                cell2.innerHTML = "fecha";
                                cell3.innerHTML =  `<button type="button" class="btn btn-primary btn-icon btn-sm" data-toggle="modal"
                                                        onclick="$('#updateDescCatalogo').modal('toggle'); $('#idItem').val('` + result.id + `');"
                                                        rel="tooltip" title="Actualizar la descripción">
                                                        <i class="fa fa-pencil"></i>
                                                    </button>`;
                            }

                            else if(actionType === "update"){
                                $("#tdDesc"+id).text(desc);
                                $('#updateDescCatalogo').modal('toggle');
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
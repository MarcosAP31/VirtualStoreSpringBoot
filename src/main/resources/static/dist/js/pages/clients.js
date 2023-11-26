/* global Chart:false */
$(document).ready(function() {
	var deleteclientid;
	var clientid = 0;
	var formData;
	var imageName = "";

	//Llamar a la funcion showData()
	showData();

	//Click para abrir mostrar el formulario de registro
	/*$("#btnNew").click(function() {
		$("#myModal").modal('show');
	});*/

	//Click para mostrar información del registro
	$('#tbClients tbody').on('click', '#btn-edit', function() {
		//$("#myModal").modal("show");
		clientid = $(this).data('client-id'); // Obtener el código del cliente del atributo de datos
		$.getJSON('/client/' + clientid, function(client) {
			// Asigna los valores de los datos a los campos del formulario
			imageName = client.Image;
			

		});
		// Llama a la función 'edit' pasando el código del cliente
		view(clientid);
	});

	// Capturar el evento click en los botones de eliminar
	$('#tbClients tbody').on('click', '#btn-delete', function() {
		//$("#deleteModal").modal("show");
		deleteclientid = $(this).data('client-id'); // Obtener el código del cliento del atributo de datos
		$.getJSON('/client/' + deleteclientid, function(client) {
			// Asigna los valores de los datos a los campos del formulario
			imageName = client.Image;
		});
		Swal.fire({
			title: 'Confirmación',
			text: '¿Seguro de eliminar el registro?',
			showDenyButton: true,
			showCancelButton: false,
			confirmButtonText: `Eliminar`,
			denyButtonText: `Cancelar`,
			allowOutsideClick: false,
			icon: 'info'
		}).then((result) => {

			if (result.isConfirmed) {
				Swal.fire({
					allowOutsideClick: false,
					icon: 'info',
					title: 'Eliminando registro',
					text: 'Cargando...',
				});
				Swal.showLoading();
				// Realizar la eliminación del registro utilizando AJAX
				$.ajax({
					url: '/client/delete/' + deleteclientid,
					type: 'DELETE',
					success: function(response) {
						// Manejar la respuesta exitosa de la API
						console.log('Registro eliminado exitosamente');

						// Aquí puedes realizar alguna acción adicional, como actualizar la tabla o mostrar un mensaje de éxito

						// Luego de eliminar el registro, puedes cerrar el modal
						//$('#deleteModal').modal('hide');
					},
					error: function(xhr, status, error) {
						// Manejar el error en caso de que la API no responda correctamente
						console.log('Error al eliminar el registro:', error);

						// Aquí puedes mostrar un mensaje de error al usuario o realizar alguna otra acción según tus necesidades
					}
				});
				$.ajax({
					url: "/images/delete/" + imageName,
					type: "DELETE",
					success: function(response) {
						// Manejar la respuesta del servidor
						console.log(response);
					},
					error: function(xhr, status, error) {
						// Manejar el error
						console.error("Error uploading image");
					}
				});
				Swal.fire({
					allowOutsideClick: false,
					icon: 'success',
					title: 'Éxito',
					text: '¡Se ha eliminado correctamente!',
				}).then((result) => {
					window.location.reload();
				});
			}
		});
	});

	//Visualizar Imagen
	$("#fileInput").change(function() {
		var fileInput = document.getElementById("fileInput");
		var imagePreview = document.getElementById("imagePreview");

		if (fileInput.files && fileInput.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				imagePreview.src = e.target.result;
				imagePreview.style.display = "block";
			};

			reader.readAsDataURL(fileInput.files[0]);
		} else {
			imagePreview.style.display = "none";
		}
		var fileInput = document.getElementById("fileInput");
		var file = fileInput.files[0];

		formData = new FormData($("#formClient")[0]);
		formData.append("file", file);
		console.log(fileInput.files[0].name);
		console.log(formData);
	});

	//Click boton guardar
	$('#btn-submit').click(function() {
		event.preventDefault(); // Evita que el formulario se envíe por defecto
		var fileInput = document.getElementById("fileInput");
		var file = fileInput.files[0];
		var formData = new FormData($("#formProduct")[0]);
		formData.append("file", file);
		console.log(fileInput.files[0]);
		console.log(formData);
		// Obtener los valores del formulario
		var Name = $('#txtName').val();
		var LastName = $('#txtLastName').val();
		var Birthday = $('#txtBirthday').val();
		var Sex = $('#cboSex').val();
		var Department = $('#txtDepartment').val();
		var Province = $('#txtProvince').val();
		var District = $('#txtDistrict').val();
		var Direction = $('#txtDirection').val();
		var Phone = $('#txtPhone').val();
		var Email = $('#txtEmail').val();
		var Image="";
		if(fileInput.files.length > 0){
			Image=fileInput.files[0].name;
		}else{
			Image=imageName;
		}
		// Crear el objeto de datos a enviar
		var dataform = {
			Name: Name,
			LastName: LastName,
			Birthday: Birthday,
			Sex: Sex,
			Department: Department,
			Province: Province,
			District: District,
			Direction: Direction,
			Phone: Phone,
			Email: Email,
			Image: Image
		};
		Swal.fire({
			title: 'Confirmación',
			text: '¿Seguro de guardar el registro?',
			showDenyButton: true,
			showCancelButton: false,
			confirmButtonText: `Guardar`,
			denyButtonText: `Cancelar`,
			allowOutsideClick: false,
			icon: 'info'
		}).then((result) => {
			if (result.isConfirmed) {
				Swal.fire({
					allowOutsideClick: false,
					icon: 'info',
					title: 'Guardando registro',
					text: 'Cargando...',
				});
				Swal.showLoading();
				if (clientid == 0) {
					// Configurar la solicitud AJAX
					$.ajax({
						url: "/images/upload",
						type: "POST",
						data: formData,
						cache: false,
						contentType: false,
						processData: false,
						success: function(response) {
							// Manejar la respuesta del servidor
							console.log(response);
						},
						error: function(xhr, status, error) {
							// Manejar el error
							console.error("Error uploading image");
						}
					});
					$.ajax({
						url: '/client/save',
						type: 'POST',
						contentType: "application/json",
						data: JSON.stringify(dataform),
						success: function(response) {
							// Manejar la respuesta del servidor
							console.log(response);
						},
						error: function(xhr, status, error) {
							// Manejar el error de la solicitud
							console.log(error);
						}
					});

				} else {
					// Configurar la solicitud AJAX
					if (fileInput.files.length > 0) {
						$.ajax({
							url: "/images/delete/" + imageName,
							type: "DELETE",
							success: function(response) {
								// Manejar la respuesta del servidor
								console.log(response);
							},
							error: function(xhr, status, error) {
								// Manejar el error
								console.error("Error uploading image");
							}
						});
						$.ajax({
							url: "/images/upload",
							type: "POST",
							data: formData,
							cache: false,
							contentType: false,
							processData: false,
							success: function(response) {
								// Manejar la respuesta del servidor
								console.log(response);
							},
							error: function(xhr, status, error) {
								// Manejar el error
								console.error("Error uploading image");
							}
						});
					}
					$.ajax({
						url: '/client/save/' + clientid,
						type: 'PUT',
						contentType: "application/json",
						data: JSON.stringify(dataform),
						success: function(response) {
							// Manejar la respuesta del servidor
							console.log(response);
						},
						error: function(xhr, status, error) {
							// Manejar el error de la solicitud
							console.log(error);
						}
					});
				}
				Swal.fire({
					allowOutsideClick: false,
					icon: 'success',
					title: 'Éxito',
					text: '¡Se ha guardado correctamente!',
				}).then((result) => {
					window.location.reload();
				});
			}
		});
	});

	// Adjunta un controlador de eventos 'click' al botón de edición
	$('#btn-edit').click(function() {
		var clientid = $(this).data('client-id'); // Obtiene el valor de 'product-code' del botón
		// Llama a la función 'edit' pasando el valor de 'productCode'
		view(clientid);
	});

	// Agregar un oyente de evento al modal para detectar cuando se oculta
	$('#myModal').on('hidden.bs.modal', function(e) {
		// Limpiar todos los campos del formulario
		$('#txtName').val('');
		$('#txtLastName').val('');
		$('#txtBirthday').val('');
		$('#txtDepartment').val('');
		$('#txtProvince').val('');
		$('#txtDistrict').val('');
		$('#txtDirection').val('');
		$('#txtPhone').val('');
		$('#txtEmail').val('');
	});

});

//Función para visualizar información del registro
function view(clientid) {
	console.log(clientid)
	$.getJSON('/client/' + clientid, function(client) {
		// Asigna los valores de los datos a los campos del formulario
		$('#txtName').val(client.Name);
		$('#txtLastName').val(client.LastName);
		$('#txtBirthday').val(client.Birthday);
		$('#txtDepartment').val(client.Department);
		$('#txtProvince').val(client.Province);
		$('#txtDistrict').val(client.District);
		$('#txtDirection').val(client.Direction);
		$('#txtPhone').val(client.Phone);
		$('#txtEmail').val(client.Email);
	});
}

/*Función para limpiar la tabla
function clearData() {
	$("#tbClients tbody").empty();
}*/

//Función para listar todos los registros
function showData() {
	// Realiza la petición AJAX para obtener los elementos de la API
	$.getJSON('/client/list', function(data) {
		console.log(data);
		// Limpia cualquier contenido existente en la tabla DataTable
		$('#tbClients').DataTable().clear().destroy();

		// Itera sobre los elementos y crea las filas de la tabla
		$.each(data, function(index, client) {
			console.log(client.ClientId);
			var fila = [
				client.ClientId,
				client.Name,
				client.LastName,
				client.Birthday,
				client.Sex,
				client.Direction,
				client.Phone,
				client.Email,
				'<img src="/images/' + client.Image + '" alt="Imagen 1" style="width: 100px;">',
				'<button type="button" id="btn-edit" class="btn btn-warning" data-toggle="modal" data-target="#myModal" data-client-id="' + client.ClientId + '"><i class="fas fa-edit"></i></button>' +
				'<button type="button" id="btn-delete" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" data-client-id="' + client.ClientId + '"><i class="fas fa-trash"></i></button>'
			];

			// Agrega la fila a la tabla DataTable
			$('#tbClients').DataTable().row.add(fila);
		});

		// Dibuja la tabla nuevamente con los datos actualizados
		$('#tbClients').DataTable().draw();
	});
}


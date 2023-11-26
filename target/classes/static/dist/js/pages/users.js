/* global Chart:false */
$(document).ready(function() {
	var modal = $("#myModal");
	var deleteModal = $("#deleteModal");
	var deleteuserid;
	var userid = 0;
	//Llamar a la funcion showData()
	showData();

	//Click para mostrar información del registro
	$('#tbUsers tbody').on('click', '#btn-edit', function() {
		userid = $(this).data('user-id'); // Obtener el código del usero del atributo de datos
		$.getJSON('/user/' + userid, function(user) {
			// Asigna los valores de los datos a los campos del formulario
			imageName = user.Image;

		});
		// Llama a la función 'edit' pasando el código del usere
		view(userid);
	});

	// Capturar el evento click en los botones de eliminar
	$('#tbUsers tbody').on('click', '#btn-delete', function() {
		deleteuserid = $(this).data('user-id'); // Obtener el código del usero del atributo de datos
		$.getJSON('/user/' + deleteuserid, function(user) {
			// Asigna los valores de los datos a los campos del formulario
			imageName = user.Image;
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
					url: '/user/delete/' + deleteuserid,
					type: 'DELETE',
					success: function(response) {
						// Manejar la respuesta exitosa de la API
						console.log('Registro eliminado exitosamente');

						// Aquí puedes realizar alguna acción adicional, como actualizar la tabla o mostrar un mensaje de éxito

						// Luego de eliminar el registro, puedes cerrar el modal
						$('#deleteModal').modal('hide');
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
		})
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

		var formData = new FormData($("#formProduct")[0]);
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
		var UserName = $('#txtUserName').val();
		var Email = $('#txtEmail').val();
		var Password = $('#txtPassword').val();
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
			UserName: UserName,
			Email: Email,
			Password: Password
			//Image: fileInput.files[0].name
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
				if (userid == 0) {
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
						url: '/user/save',
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
						url: '/user/save/' + userid,
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
		})
	});

	// Adjunta un controlador de eventos 'click' al botón de edición
	$('#btn-edit').click(function() {
		var userid = $(this).data('user-id'); // Obtiene el valor de 'product-userid' del botón
		// Llama a la función 'edit' pasando el valor de 'productCode'
		view(userid);
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
		$('#txtUserName').val('');
		$('#txtEmail').val('');
		$('#txtPassword').val('');
	});
});

//Función para visualizar información del registro
function view(userid) {
	console.log(userid)
	$.getJSON('/user/' + userid, function(user) {
		// Asigna los valores de los datos a los campos del formulario
		$('#txtName').val(user.Name);
		$('#txtLastName').val(user.LastName);
		$('#txtBirthday').val(user.Birthday);
		$('#txtDepartment').val(user.Department);
		$('#txtProvince').val(user.Province);
		$('#txtDistrict').val(user.District);
		$('#txtDirection').val(user.Direction);
		$('#txtPhone').val(user.Phone);
		$('#txtUserName').val(user.UserName);
		$('#txtEmail').val(user.Email);
		$('#txtPassword').val(user.Password);
	});
}

//Función para limpiar la tabla
function clearData() {
	$("#tbUsers tbody").empty();
}

//Función para listar todos los registros
function showData() {
	// Realiza la petición AJAX para obtener los elementos de la API
	$.getJSON('/user/list', function(data) {
		// Itera sobre los elementos y crea las filas de la tabla
		$.each(data, function(index, user) {
			console.log(user.UserId)
			var fila = '<tr>' +
				'<td>' + user.UserId + '</td>' +
				'<td>' + user.Name + '</td>' +
				'<td>' + user.LastName + '</td>' +
				'<td>' + user.Birthday + '</td>' +
				'<td>' + user.Sex + '</td>' +
				'<td>' + user.Direction + '</td>' +
				'<td>' + user.Phone + '</td>' +
				'<td>' + user.Email + '</td>' +
				'<td><img src="/images/' + user.Image + '" alt="Imagen 1" style="width: 100px;"></td>' +
				'<td class="text-center">' +
				'<button type="button" id="btn-edit" class="btn btn-warning" data-toggle="modal" data-target="#myModal" data-user-id="' + user.UserId + '">' +
				'<i class="fas fa-edit"></i>' +
				'</button>' +
				'<button type="button" id="btn-delete" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" data-user-id="' + user.UserId + '">' +
				'<i class="fas fa-trash"></i>' +
				'</button>' +
				'</td>' +
				'</tr>';

			// Agrega la fila a la tabla
			$('#tbUsers tbody').append(fila);
		});

	});
}

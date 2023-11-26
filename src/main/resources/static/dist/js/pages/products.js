$(document).ready(function() {
	var deleteproductid;
	var productid = 0;
	var imageName = "";
	//Llamar a la funcion showData()
	showData();

	//Click para mostrar información del registro
	$('#tbProducts tbody').on('click', '#btn-edit', function() {
		productid = $(this).data('product-id'); // Obtener el código del producto del atributo de datos
		$.getJSON('/product/' + productid, function(product) {
			// Asigna los valores de los datos a los campos del formulario
			imageName = product.Image;

		});
		// Llama a la función 'edit' pasando el código del producte
		view(productid);
	});

	// Capturar el evento click en los botones de eliminar
	$('#tbProducts tbody').on('click', '#btn-delete', function() {
		//$("#deleteModal").modal("show");
		deleteproductid = $(this).data('product-id'); // Obtener el código del producto del atributo de datos
		$.getJSON('/product/' + deleteproductid, function(product) {
			// Asigna los valores de los datos a los campos del formulario
			imageName = product.Image;

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
					url: '/product/delete/' + deleteproductid,
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

	// Realiza la petición AJAX a la API
	$.getJSON('/supplier/list', function(data) {
		// Recorre los datos recibidos
		$.each(data, function(key, supplier) {
			// Crea la opción del select con los datos necesarios
			var option = $('<option>').val(supplier.SupplierId).text(supplier.BusinessName);
			// Agrega la opción al select
			$('#cboSuppliers').append(option);
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
		var Description = $('#txtDescription').val();
		var Category = $('#txtCategory').val();
		var Amount = $('#txtAmount').val();
		var PurchasePrice = $('#txtPurchasePrice').val();
		var SalePrice = $('#txtSalePrice').val();
		var SupplierId = $('#cboSuppliers').val();
		// Crear el objeto de datos a enviar
		var dataform = {
			Description: Description,
			Category: Category,
			Amount: Amount,
			PurchasePrice: PurchasePrice,
			SalePrice: SalePrice,
			SupplierId: SupplierId
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
				if (productid == 0) {
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
						url: '/product/save',
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
						url: '/product/save/' + productid,
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
		var productid = $(this).data('product-id'); // Obtiene el valor de 'product-id' del botón
		// Llama a la función 'edit' pasando el valor de 'productCode'
		view(productid);
	});

	// Agregar un oyente de evento al modal para detectar cuando se oculta
	$('#myModal').on('hidden.bs.modal', function(e) {
		// Limpiar todos los campos del formulario
		$('#txtDescription').val('');
		$('#txtCategory').val('');
		$('#txtAmount').val('');
		$('#txtPurchasePrice').val('');
		$('#txtSalePrice').val('');
	});
});

//Función para visualizar información del registro
function view(productid) {
	console.log(productid)
	$.getJSON('/product/' + productid, function(product) {
		// Asigna los valores de los datos a los campos del formulario
		$('#txtDescription').val(product.Description);
		$('#txtCategory').val(product.Category);
		$('#txtAmount').val(product.Amount);
		$('#txtPurchasePrice').val(product.PurchasePrice);
		$('#txtSalePrice').val(product.SalePrice);
	});
}

//Función para listar todos los registros
function showData() {
	// Realiza la petición AJAX para obtener los elementos de la API
	$.getJSON('/product/list', function(data) {
		console.log(data);
		// Limpia cualquier contenido existente en la tabla DataTable
		$('#tbProducts').DataTable().clear().destroy();
		// Itera sobre los elementos y crea las filas de la tabla
		$.each(data, function(index, product) {
			console.log(product.ProductId)
			var fila = [
				product[0],
				product[1],
				product[2],
				product[3],
				product[4],
				product[5],
				product[6],
				'<img src="/images/' + product[7] + '" alt="Imagen 1" style="width: 100px;">',
				'<button type="button" id="btn-edit" class="btn btn-warning" data-toggle="modal" data-target="#myModal" data-product-id="' + product[0] + '"><i class="fas fa-edit"></i></button>' +
				'<button type="button" id="btn-delete" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal" data-product-id="' + product[0] + '"><i class="fas fa-trash"></i></button>'
			];
			// Agrega la fila a la tabla DataTable
			$('#tbProducts').DataTable().row.add(fila);
		});
		// Dibuja la tabla nuevamente con los datos actualizados
		$('#tbProducts').DataTable().draw();
	});
}
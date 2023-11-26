package com.virtualstore.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.virtualstore.demo.interfaceService.IClientService;
import com.virtualstore.demo.interfaceService.ISupplierService;
import com.virtualstore.demo.interfaceService.IProductService;
import com.virtualstore.demo.interfaceService.IBusinessService;
import com.virtualstore.demo.interfaceService.IConversationService;
import com.virtualstore.demo.interfaceService.IEntryService;
import com.virtualstore.demo.interfaceService.IMessageService;
import com.virtualstore.demo.interfaceService.IOperationService;
import com.virtualstore.demo.interfaceService.IOutputService;
import com.virtualstore.demo.interfaceService.ISaleService;
import com.virtualstore.demo.interfaceService.ISaleXProductService;
import com.virtualstore.demo.interfaceService.ISessionService;
import com.virtualstore.demo.interfaceService.IUserService;
import com.virtualstore.demo.model.Client;
import com.virtualstore.demo.model.Supplier;
import com.virtualstore.demo.model.Product;
import com.virtualstore.demo.model.Business;
import com.virtualstore.demo.model.Conversation;
import com.virtualstore.demo.model.Entry;
import com.virtualstore.demo.model.Message;
import com.virtualstore.demo.model.Operation;
import com.virtualstore.demo.model.Output;
import com.virtualstore.demo.model.Sale;
import com.virtualstore.demo.model.SaleXProduct;
import com.virtualstore.demo.model.Session;
import com.virtualstore.demo.model.User;
import jakarta.annotation.Resource;
@Controller
@RequestMapping
public class Controler {
	@Autowired
	private IClientService clientService;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IBusinessService businessService;
	@Autowired
	private IConversationService conversationService;
	@Autowired
	private IEntryService entryService;
	@Autowired
	private IMessageService messageService;
	@Autowired
	private IOperationService operationService;
	@Autowired
	private IOutputService outputService;
	@Autowired
	private ISaleService saleService;
	@Autowired
	private ISaleXProductService salexproductService;
	@Autowired
	private ISessionService sessionService;
	@Autowired
	private IUserService userService;

	// Client
	@GetMapping("/clients")
	public String showClients() {
		return "clients";
	}

	@GetMapping("/client/list")
	@ResponseBody
	public List<Client> listClients() {
		return clientService.list();
	}

	@PostMapping("/client/save")
	// @ResponseBody
	public ResponseEntity<Client> createClient(@RequestBody Client newClient) {
		clientService.save(newClient);
		return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
	}

	@PutMapping("/client/save/{id}")
	// @ResponseBody
	public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client client) {
		Optional<Client> oldClient = clientService.listClientId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldClient.get().setName(client.getName());
		oldClient.get().setLastName(client.getLastName());
		oldClient.get().setBirthday(client.getBirthday());
		oldClient.get().setSex(client.getSex());
		oldClient.get().setDepartment(client.getDepartment());
		oldClient.get().setProvince(client.getProvince());
		oldClient.get().setDistrict(client.getDistrict());
		oldClient.get().setDirection(client.getDirection());
		oldClient.get().setPhone(client.getPhone());
		oldClient.get().setEmail(client.getEmail());
		oldClient.get().setImage(client.getImage());
		// Guarda los cambios en la base de datos
		clientService.save(oldClient.get());
		return ResponseEntity.ok(oldClient.get());
	}

	@GetMapping("/client/{id}")
	// @ResponseBody
	public ResponseEntity<Client> getClientById(@PathVariable int id) {
		Optional<Client> client = clientService.listClientId(id);

		if (client.isPresent()) {
			return ResponseEntity.ok(client.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/client/delete/{id}")
	// @ResponseBody
	public String deleteClient(@PathVariable int id) {
		clientService.delete(id);
		return "Client eliminado con éxito";
	}

	// Supplier
	@GetMapping("/suppliers")
	public String showSuppliers() {
		return "suppliers";
	}

	@GetMapping("/supplier/list")
	@ResponseBody
	public List<Supplier> listSuppliers() {
		return supplierService.list();
	}

	@PostMapping("/supplier/save")
	// @ResponseBody
	public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier newSupplier) {
		supplierService.save(newSupplier);
		return ResponseEntity.status(HttpStatus.CREATED).body(newSupplier);
	}

	@PutMapping("/supplier/save/{id}")
	// @ResponseBody
	public ResponseEntity<Supplier> updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {
		Optional<Supplier> oldSupplier = supplierService.listSupplierId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldSupplier.get().setRUC(supplier.getRUC());
		oldSupplier.get().setBusinessName(supplier.getBusinessName());
		oldSupplier.get().setTradeName(supplier.getTradeName());
		oldSupplier.get().setKind(supplier.getKind());
		oldSupplier.get().setDepartment(supplier.getDepartment());
		oldSupplier.get().setProvince(supplier.getProvince());
		oldSupplier.get().setDistrict(supplier.getDistrict());
		oldSupplier.get().setDirection(supplier.getDirection());
		oldSupplier.get().setPhone(supplier.getPhone());
		oldSupplier.get().setEmail(supplier.getEmail());
		// Guarda los cambios en la base de datos
		supplierService.save(oldSupplier.get());
		return ResponseEntity.ok(oldSupplier.get());
	}

	@GetMapping("/supplier/{id}")
	// @ResponseBody
	public ResponseEntity<Supplier> getSupplierById(@PathVariable int id) {
		Optional<Supplier> supplier = supplierService.listSupplierId(id);

		if (supplier.isPresent()) {
			return ResponseEntity.ok(supplier.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/supplier/delete/{id}")
	// @ResponseBody
	public String deleteSupplier(@PathVariable int id) {
		supplierService.delete(id);
		return "Supplier eliminado con éxito";
	}

	// Product
	@GetMapping("/products")
	public String showProducts() {
		return "products";
	}

	/*
	 * @GetMapping("/product/list")
	 * 
	 * @ResponseBody public List<Product> listProducts() { return
	 * productService.list(); }
	 */
	@GetMapping("/product/list")
	@ResponseBody
	public Object[] listProductsArray() {
		List<Product> productList = productService.list();
		Object[] productArray = new Object[productList.size()];

		for (int i = 0; i < productList.size(); i++) {
			Product product = productList.get(i);
			Supplier supplier = supplierService.listSupplierId(product.SupplierId).get();
			Object[] data = new Object[8];
			data[0] = product.ProductId;
			data[1] = product.Description;
			data[2] = product.Category;
			data[3] = product.Amount;
			data[4] = product.PurchasePrice;
			data[5] = product.SalePrice;
			data[6] = supplier.BusinessName;
			data[7] = product.Image;
			productArray[i] = data;
		}
		return productArray;
	}

	@PostMapping("/product/save")
	// @ResponseBody
	public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
		productService.save(newProduct);
		return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
	}

	@PutMapping("/product/save/{id}")
	// @ResponseBody
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
		Optional<Product> oldProduct = productService.listProductId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldProduct.get().setDescription(product.getDescription());
		oldProduct.get().setCategory(product.getCategory());
		oldProduct.get().setAmount(product.getAmount());
		oldProduct.get().setPurchasePrice(product.getPurchasePrice());
		oldProduct.get().setSalePrice(product.getSalePrice());
		oldProduct.get().setSupplierId(product.getSupplierId());
		oldProduct.get().setImage(product.getImage());
		// Guarda los cambios en la base de datos
		productService.save(oldProduct.get());
		return ResponseEntity.ok(oldProduct.get());
	}

	@GetMapping("/product/{id}")
	// @ResponseBody
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Optional<Product> product = productService.listProductId(id);

		if (product.isPresent()) {
			return ResponseEntity.ok(product.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/product/delete/{id}")
	// @ResponseBody
	public String deleteProdutc(@PathVariable int id) {
		productService.delete(id);
		return "Producto eliminado con éxito";
	}

	@RestController
	@RequestMapping("/images")
	public class ImageController {
		private final String uploadPath = "src/main/resources/static/images/";

		@GetMapping("/{imageName:.+}")
		public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
			Path imagePath = Path.of(uploadPath, imageName);
			byte[] imageBytes = Files.readAllBytes(imagePath);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
		}

		@DeleteMapping("/delete/{imageName:.+}")
		public ResponseEntity<String> deleteImage(@PathVariable String imageName) {
			try {
				Path imagePath = Path.of(uploadPath, imageName);
				Files.delete(imagePath);
				return ResponseEntity.ok("Image deleted: " + imageName);
			} catch (IOException e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting image");
			}
		}

		@PostMapping("/upload")
		public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body("File is empty");
			}

			try {
				// String fileName = UUID.randomUUID().toString() + "_" +
				// file.getOriginalFilename();
				/*
				 * LocalDateTime date = LocalDateTime.now(); DateTimeFormatter formatter =
				 * DateTimeFormatter.ofPattern("yyyy-MM-ddHHmmss"); String
				 * dateformatter=date.format(formatter);
				 */
				String fileName = file.getOriginalFilename();
				Path filePath = Path.of(uploadPath, fileName);

				Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

				String imageUrl = "/images/" + fileName;
				return ResponseEntity.ok("Image uploaded at: " + imageUrl);
			} catch (IOException e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
			}
		}
	}

	// Business
	@GetMapping("/businesss")
	public String showBusinesss() {
		return "index";
	}

	@GetMapping("/business/list")
	@ResponseBody
	public List<Business> listBusinesss() {
		return businessService.list();
	}

	@PostMapping("/business/save")
	// @ResponseBody
	public ResponseEntity<Business> createBusiness(@RequestBody Business newBusiness) {
		businessService.save(newBusiness);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBusiness);
	}

	@PutMapping("/business/save/{id}")
	// @ResponseBody
	public ResponseEntity<Business> updateBusiness(@PathVariable int id, @RequestBody Business business) {
		Optional<Business> oldBusiness = businessService.listBusinessId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldBusiness.get().setDescription(business.getDescription());
		oldBusiness.get().setValue(business.getValue());
		oldBusiness.get().setReference(business.getReference());
		oldBusiness.get().setState(business.getState());
		oldBusiness.get().setCreationDate(business.getCreationDate());
		oldBusiness.get().setClosingDate(business.getClosingDate());
		oldBusiness.get().setCommentary(business.getCommentary());
		oldBusiness.get().setActivity(business.getActivity());
		oldBusiness.get().setNextActivity(business.getNextActivity());
		// Guarda los cambios en la base de datos
		businessService.save(oldBusiness.get());
		return ResponseEntity.ok(oldBusiness.get());
	}

	@GetMapping("/business/{id}")
	// @ResponseBody
	public ResponseEntity<Business> getBusinessById(@PathVariable int id) {
		Optional<Business> business = businessService.listBusinessId(id);

		if (business.isPresent()) {
			return ResponseEntity.ok(business.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/business/delete/{id}")
	// @ResponseBody
	public String deleteBusiness(@PathVariable int id) {
		businessService.delete(id);
		return "Business eliminado con éxito";
	}

	// Conversation
	@GetMapping("/conversations")
	public String showConversations() {
		return "index";
	}

	@GetMapping("/conversation/list")
	@ResponseBody
	public List<Conversation> listConversations() {
		return conversationService.list();
	}

	@PostMapping("/conversation/save")
	// @ResponseBody
	public ResponseEntity<Conversation> createConversation(@RequestBody Conversation newConversation) {
		conversationService.save(newConversation);
		return ResponseEntity.status(HttpStatus.CREATED).body(newConversation);
	}

	@PutMapping("/conversation/save/{id}")
	// @ResponseBody
	public ResponseEntity<Conversation> updateConversation(@PathVariable int id,
			@RequestBody Conversation conversation) {
		Optional<Conversation> oldConversation = conversationService.listConversationId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldConversation.get().setName(conversation.getName());
		oldConversation.get().setCreationDate(conversation.getCreationDate());
		// Guarda los cambios en la base de datos
		conversationService.save(oldConversation.get());
		return ResponseEntity.ok(oldConversation.get());
	}

	@GetMapping("/conversation/{id}")
	// @ResponseBody
	public ResponseEntity<Conversation> getConversationById(@PathVariable int id) {
		Optional<Conversation> conversation = conversationService.listConversationId(id);

		if (conversation.isPresent()) {
			return ResponseEntity.ok(conversation.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/conversation/delete/{id}")
	// @ResponseBody
	public String deleteConversation(@PathVariable int id) {
		conversationService.delete(id);
		return "Conversation eliminado con éxito";
	}

	// Entry
	@GetMapping("/entrys")
	public String showEntrys() {
		return "index";
	}

	@GetMapping("/entry/list")
	@ResponseBody
	public List<Entry> listEntrys() {
		return entryService.list();
	}

	@PostMapping("/entry/save")
	// @ResponseBody
	public ResponseEntity<Entry> createEntry(@RequestBody Entry newEntry) {
		entryService.save(newEntry);
		return ResponseEntity.status(HttpStatus.CREATED).body(newEntry);
	}

	@PutMapping("/entry/save/{id}")
	// @ResponseBody
	public ResponseEntity<Entry> updateEntry(@PathVariable int id, @RequestBody Entry entry) {
		Optional<Entry> oldEntry = entryService.listEntryId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldEntry.get().setDate(entry.getDate());
		oldEntry.get().setAmount(entry.getAmount());
		oldEntry.get().setProductId(entry.getProductId());
		oldEntry.get().setUserId(entry.getUserId());
		// Guarda los cambios en la base de datos
		entryService.save(oldEntry.get());
		return ResponseEntity.ok(oldEntry.get());
	}

	@GetMapping("/entry/{id}")
	// @ResponseBody
	public ResponseEntity<Entry> getEntryById(@PathVariable int id) {
		Optional<Entry> entry = entryService.listEntryId(id);

		if (entry.isPresent()) {
			return ResponseEntity.ok(entry.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/entry/delete/{id}")
	// @ResponseBody
	public String deleteEntry(@PathVariable int id) {
		entryService.delete(id);
		return "Entry eliminado con éxito";
	}

	// Message
	@GetMapping("/messages")
	public String showMessages() {
		return "index";
	}

	@GetMapping("/message/list")
	@ResponseBody
	public List<Message> listMessages() {
		return messageService.list();
	}

	@PostMapping("/message/save")
	// @ResponseBody
	public ResponseEntity<Message> createMessage(@RequestBody Message newMessage) {
		messageService.save(newMessage);
		return ResponseEntity.status(HttpStatus.CREATED).body(newMessage);
	}

	@PutMapping("/message/save/{id}")
	// @ResponseBody
	public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
		Optional<Message> oldMessage = messageService.listMessageId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldMessage.get().setContent(message.getContent());
		oldMessage.get().setShippingDate(message.getShippingDate());
		oldMessage.get().setUserId(message.getUserId());
		oldMessage.get().setState(message.getState());
		oldMessage.get().setConversationId(message.getConversationId());
		// Guarda los cambios en la base de datos
		messageService.save(oldMessage.get());
		return ResponseEntity.ok(oldMessage.get());
	}

	@GetMapping("/message/{id}")
	// @ResponseBody
	public ResponseEntity<Message> getMessageById(@PathVariable int id) {
		Optional<Message> message = messageService.listMessageId(id);

		if (message.isPresent()) {
			return ResponseEntity.ok(message.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/message/delete/{id}")
	// @ResponseBody
	public String deleteMessage(@PathVariable int id) {
		messageService.delete(id);
		return "Message eliminado con éxito";
	}

	// Operation
	@GetMapping("/operations")
	public String showOperations() {
		return "index";
	}

	@GetMapping("/operation/list")
	@ResponseBody
	public List<Operation> listOperations() {
		return operationService.list();
	}

	@PostMapping("/operation/save")
	// @ResponseBody
	public ResponseEntity<Operation> createOperation(@RequestBody Operation newOperation) {
		operationService.save(newOperation);
		return ResponseEntity.status(HttpStatus.CREATED).body(newOperation);
	}

	@PutMapping("/operation/save/{id}")
	// @ResponseBody
	public ResponseEntity<Operation> updateOperation(@PathVariable int id, @RequestBody Operation operation) {
		Optional<Operation> oldOperation = operationService.listOperationId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldOperation.get().setDate(operation.getDate());
		oldOperation.get().setDescription(operation.getDescription());
		oldOperation.get().setProductId(operation.getProductId());
		// Guarda los cambios en la base de datos
		operationService.save(oldOperation.get());
		return ResponseEntity.ok(oldOperation.get());
	}

	@GetMapping("/operation/{id}")
	// @ResponseBody
	public ResponseEntity<Operation> getOperationById(@PathVariable int id) {
		Optional<Operation> operation = operationService.listOperationId(id);

		if (operation.isPresent()) {
			return ResponseEntity.ok(operation.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/operation/delete/{id}")
	// @ResponseBody
	public String deleteOperation(@PathVariable int id) {
		operationService.delete(id);
		return "Operation eliminado con éxito";
	}

	// Output
	@GetMapping("/outputs")
	public String showOutputs() {
		return "index";
	}

	@GetMapping("/output/list")
	@ResponseBody
	public List<Output> listOutputs() {
		return outputService.list();
	}

	@PostMapping("/output/save")
	// @ResponseBody
	public ResponseEntity<Output> createOutput(@RequestBody Output newOutput) {
		outputService.save(newOutput);
		return ResponseEntity.status(HttpStatus.CREATED).body(newOutput);
	}

	@PutMapping("/output/save/{id}")
	// @ResponseBody
	public ResponseEntity<Output> updateOutput(@PathVariable int id, @RequestBody Output output) {
		Optional<Output> oldOutput = outputService.listOutputId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldOutput.get().setDate(output.getDate());
		oldOutput.get().setAmount(output.getAmount());
		oldOutput.get().setProductId(output.getProductId());
		oldOutput.get().setClientId(output.getClientId());
		oldOutput.get().setUserId(output.getUserId());
		// Guarda los cambios en la base de datos
		outputService.save(oldOutput.get());
		return ResponseEntity.ok(oldOutput.get());
	}

	@GetMapping("/output/{id}")
	// @ResponseBody
	public ResponseEntity<Output> getOutputById(@PathVariable int id) {
		Optional<Output> output = outputService.listOutputId(id);

		if (output.isPresent()) {
			return ResponseEntity.ok(output.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/output/delete/{id}")
	// @ResponseBody
	public String deleteOutput(@PathVariable int id) {
		outputService.delete(id);
		return "Output eliminado con éxito";
	}

	// Sale
	@GetMapping("/sales")
	public String showSales() {
		return "index";
	}

	@GetMapping("/sale/list")
	@ResponseBody
	public List<Sale> listSales() {
		return saleService.list();
	}

	@PostMapping("/sale/save")
	// @ResponseBody
	public ResponseEntity<Sale> createSale(@RequestBody Sale newSale) {
		saleService.save(newSale);
		return ResponseEntity.status(HttpStatus.CREATED).body(newSale);
	}

	@PutMapping("/sale/save/{id}")
	// @ResponseBody
	public ResponseEntity<Sale> updateSale(@PathVariable int id, @RequestBody Sale sale) {
		Optional<Sale> oldSale = saleService.listSaleId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldSale.get().setPrice(sale.getPrice());
		oldSale.get().setDate(sale.getDate());
		oldSale.get().setState(sale.getState());
		oldSale.get().setClientId(sale.getClientId());
		oldSale.get().setUserId(sale.getUserId());
		// Guarda los cambios en la base de datos
		saleService.save(oldSale.get());
		return ResponseEntity.ok(oldSale.get());
	}

	@GetMapping("/sale/{id}")
	// @ResponseBody
	public ResponseEntity<Sale> getSaleById(@PathVariable int id) {
		Optional<Sale> sale = saleService.listSaleId(id);

		if (sale.isPresent()) {
			return ResponseEntity.ok(sale.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/sale/delete/{id}")
	// @ResponseBody
	public String deleteSale(@PathVariable int id) {
		saleService.delete(id);
		return "Sale eliminado con éxito";
	}

	// SaleXProduct
	@GetMapping("/salexproducts")
	public String showSaleXProducts() {
		return "index";
	}

	@GetMapping("/salexproduct/list")
	@ResponseBody
	public List<SaleXProduct> listSaleXProducts() {
		return salexproductService.list();
	}

	@PostMapping("/salexproduct/save")
	// @ResponseBody
	public ResponseEntity<SaleXProduct> createSaleXProduct(@RequestBody SaleXProduct newSaleXProduct) {
		salexproductService.save(newSaleXProduct);
		return ResponseEntity.status(HttpStatus.CREATED).body(newSaleXProduct);
	}

	@PutMapping("/salexproduct/save/{id}")
	// @ResponseBody
	public ResponseEntity<SaleXProduct> updateSaleXProduct(@PathVariable int id,
			@RequestBody SaleXProduct salexproduct) {
		Optional<SaleXProduct> oldSaleXProduct = salexproductService.listSaleXProductId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldSaleXProduct.get().setAmount(salexproduct.getAmount());
		oldSaleXProduct.get().setSaleId(salexproduct.getSaleId());
		oldSaleXProduct.get().setProductId(salexproduct.getProductId());
		// Guarda los cambios en la base de datos
		salexproductService.save(oldSaleXProduct.get());
		return ResponseEntity.ok(oldSaleXProduct.get());
	}

	@GetMapping("/salexproduct/{id}")
	// @ResponseBody
	public ResponseEntity<SaleXProduct> getSaleXProductById(@PathVariable int id) {
		Optional<SaleXProduct> salexproduct = salexproductService.listSaleXProductId(id);

		if (salexproduct.isPresent()) {
			return ResponseEntity.ok(salexproduct.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/salexproduct/delete/{id}")
	// @ResponseBody
	public String deleteSaleXProduct(@PathVariable int id) {
		salexproductService.delete(id);
		return "SaleXProduct eliminado con éxito";
	}

	// Session
	@GetMapping("/sessions")
	public String showSessions() {
		return "index";
	}

	@GetMapping("/session/list")
	@ResponseBody
	public List<Session> listSessions() {
		return sessionService.list();
	}

	@PostMapping("/session/save")
	// @ResponseBody
	public ResponseEntity<Session> createSession(@RequestBody Session newSession) {
		sessionService.save(newSession);
		return ResponseEntity.status(HttpStatus.CREATED).body(newSession);
	}

	@PutMapping("/session/save/{id}")
	// @ResponseBody
	public ResponseEntity<Session> updateSession(@PathVariable int id, @RequestBody Session session) {
		Optional<Session> oldSession = sessionService.listSessionId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldSession.get().setLoginTime(session.getLoginTime());
		oldSession.get().setLogoutTime(session.getLogoutTime());
		oldSession.get().setUserId(session.getUserId());
		// Guarda los cambios en la base de datos
		sessionService.save(oldSession.get());
		return ResponseEntity.ok(oldSession.get());
	}

	@GetMapping("/session/{id}")
	// @ResponseBody
	public ResponseEntity<Session> getSessionById(@PathVariable int id) {
		Optional<Session> session = sessionService.listSessionId(id);

		if (session.isPresent()) {
			return ResponseEntity.ok(session.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/session/delete/{id}")
	// @ResponseBody
	public String deleteSession(@PathVariable int id) {
		sessionService.delete(id);
		return "Session eliminado con éxito";
	}

	// User
	@GetMapping("/users")
	public String showUsers() {
		return "users";
	}

	@GetMapping("/user/list")
	@ResponseBody
	public List<User> listUsers() {
		return userService.list();
	}

	@PostMapping("/user/save")
	// @ResponseBody
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
		userService.save(newUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}

	@PutMapping("/user/save/{id}")
	// @ResponseBody
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
		Optional<User> oldUser = userService.listUserId(id);

		// Actualiza los campos del producto existente con los valores del producto
		// actualizado
		oldUser.get().setName(user.getName());
		oldUser.get().setLastName(user.getLastName());
		oldUser.get().setBirthday(user.getBirthday());
		oldUser.get().setSex(user.getSex());
		oldUser.get().setDepartment(user.getDepartment());
		oldUser.get().setProvince(user.getProvince());
		oldUser.get().setDistrict(user.getDistrict());
		oldUser.get().setDirection(user.getDirection());
		oldUser.get().setPhone(user.getPhone());
		oldUser.get().setUserName(user.getUserName());
		oldUser.get().setEmail(user.getEmail());
		oldUser.get().setPassword(user.getPassword());
		oldUser.get().setStatus(user.getStatus());
		oldUser.get().setImage(user.getImage());
		// Guarda los cambios en la base de datos
		userService.save(oldUser.get());
		return ResponseEntity.ok(oldUser.get());
	}

	@GetMapping("/user/{id}")
	// @ResponseBody
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		Optional<User> user = userService.listUserId(id);

		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/user/delete/{id}")
	// @ResponseBody
	public String deleteUser(@PathVariable int id) {
		userService.delete(id);
		return "User eliminado con éxito";
	}
}

@Mock
@InjectMocks //setups up controller, and injects mock objects into it.

MockitoAnnotations.initMocks(this);
mockMvc = MockMvcBuilders.standaloneSetup(productController_InstanceOfInjectedMock).build();

`` when(productService.listAllProducts()).thenReturn((List) products); //need to strip generics to keep Mockito happy.
mockMvc.perform(get("/product/list"))
    .andExpect(status().isOk())
    .andExpect(view().name("product/list"))
    .andExpect(model().attribute("products", hasSize(2)));   }``

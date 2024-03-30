### Spring boot Annotations
new ClassPathResource("fileInResourceFolder.txt").getFile() 
Annotation | Description
---|---
@RunWith(SpringRunner.class) | Run test with spring context
@SpringBootTest |
@TestConfiguration |
@MockBean | injects mockito mock
@SpyBean | injects mockito spy
@JsonTest | Creates a Jackson  or Gson object mapper via Spring boot
@WebMvcTest | test web context without a full http server
--|
@DataJpaTest | test data layer with embedded db
@JdbcTest |  like previous but does not configure entity manager
@DataMongoTest | Configures an embedded MongoDB for testing
--|
@RestClientTest | Creates a mock server for testing rest client
@AutoConfigureRestDocks |
@BootStrapWith |
@ContextHierarchy |
@ActiveProfiles |
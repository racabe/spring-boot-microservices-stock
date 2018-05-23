package org.stock.eureka.edge.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.stock.eureka.edge.client.ProductClient;
import org.stock.eureka.edge.model.Product;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class ProductControllerTest.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductApiAdapterRestController.class, secure = false)
public class ProductControllerTest {

  /** The mock mvc. */
  @Autowired
  private MockMvc mockMvc;

  /** The product client. */
  @MockBean
  private ProductClient productClient;

  /** The mock product. */
  Product mockProduct = new Product(6L, "Samsung9", 9L);

  /**
   * Find by id test.
   *
   * @throws Exception the exception
   */
  @Test
  public void findByIdTest() throws Exception {

    Mockito.when(productClient.findById(Mockito.anyLong())).thenReturn(mockProduct);

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/products/6").accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse().getContentAsString());
    String expected = "{id:6,name:Samsung9,amount:9}";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
  }

  /**
   * Adds the new product.
   *
   * @throws Exception the exception
   */
  @Test
  public void addNewProduct() throws Exception {
    Product productExample = new Product(1L, "IPhoneX", 3L);
    ResponseEntity<Product> mockProduct = new ResponseEntity<Product>(productExample, HttpStatus.OK);

    // productClient.updateProduct to respond back with mockProduct
    Mockito.when(productClient.findById(productExample.getId())).thenReturn(productExample);
    Mockito.when(productClient.updateProduct(Mockito.anyLong(), Mockito.any(Product.class)))
        .thenReturn(mockProduct);

    // Send course as body to /products/1
    RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/products/{id}", productExample.getId())
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(productExample));

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    MockHttpServletResponse response = result.getResponse();

    assertEquals(HttpStatus.OK.value(), response.getStatus());

  }

  /**
   * As json string.
   *
   * @param obj the obj
   * @return the string
   */
  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

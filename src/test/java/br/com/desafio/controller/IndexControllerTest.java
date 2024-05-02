package br.com.desafio.controller;

import br.com.desafio.enums.RedirectEnum;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class IndexControllerTest {

    @Test
    void testHome() throws Exception {
        // Arrange
        IndexController indexController = new IndexController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        // Act
        MvcResult mvcResult = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name(RedirectEnum.REDIRECT_INDEX.getValor()))
                .andReturn();

        // Assert
        String viewName = mvcResult.getModelAndView().getViewName();
        assertEquals(RedirectEnum.REDIRECT_INDEX.getValor(), viewName);
    }
}
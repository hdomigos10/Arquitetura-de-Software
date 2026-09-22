package br.com.mvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class HomeControllerTests {

    @Test
    void homeReturnsHomeView() {
        HomeController controller = new HomeController();

        String viewName = controller.home(mock(Model.class));

        assertEquals("home", viewName);
    }
}
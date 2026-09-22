package br.com.mvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ErrorControllerTests {

    @Test
    void handleErrorAddsExceptionMessageAndReturnsErrorView() {
        ErrorController controller = new ErrorController();
        Model model = mock(Model.class);
        Exception exception = new Exception("request failed");

        String viewName = controller.handleError(exception, model);

        verify(model).addAttribute("mensagem", "request failed");
        assertEquals("Error", viewName);
    }
}
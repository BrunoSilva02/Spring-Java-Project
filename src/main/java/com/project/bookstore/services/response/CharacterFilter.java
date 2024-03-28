package com.project.bookstore.services.response;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * A character filter to set the character encoding in HTTP response headers to UTF-8.
 */
@Component
@WebFilter("/*")
@Order(1)
public class CharacterFilter implements Filter {

    /**
     * Sets the character encoding in the HTTP response headers to UTF-8.
     *
     * @param request  The servlet request.
     * @param response The servlet response.
     * @param chain    The filter chain.
     * @throws IOException      If an I/O error occurs.
     * @throws ServletException If a servlet-related error occurs.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, @NotNull FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Content-Type", "text/html; charset=UTF-8");
        chain.doFilter(request, response);
    }
}

package fr.lernejo.todo;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements Filter {


    private final String uuid = UUID.randomUUID().toString();
    //String uuidAsString = uuid.toString();

    //UUID sameUuid = UUID.fromString(uuidAsString);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Instance-Id", uuid);
        chain.doFilter(request, response);
    }


}

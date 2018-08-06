package com.alevel.webapp;

import com.google.common.io.CharStreams;
import com.google.common.net.MediaType;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/ask")
public class MyServlet extends HttpServlet {

    private static final String CONTENT_TYPE = "Content-Type";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        BufferedReader reader = req.getReader();
        String unSortedArray = CharStreams.toString(reader);

        response.setHeader(CONTENT_TYPE, MediaType.PLAIN_TEXT_UTF_8.type());
        response.getWriter().write(unSortedArray);
    }
}

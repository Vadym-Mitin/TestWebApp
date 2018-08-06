package com.alevel.webapp;

import com.google.common.io.CharStreams;
import com.google.common.net.MediaType;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/ask")
public class MyServlet extends HttpServlet {

    private static final String CONTENT_TYPE = "Content-Type";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        BufferedReader reader = req.getReader();

        String requestString = CharStreams.toString(reader);

        // in request first and last char is ", and we clip it
        requestString = requestString.substring(1, requestString.length() - 1);

        String[] stringArray = requestString.split(" ");

        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        Arrays.sort(intArray);

        StringBuilder sb = new StringBuilder();

        sb.append("\"");
        for (int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i]);
            if (i == intArray.length) {
                break;
            } else sb.append(" ");
        }
        sb.append("\"");

        String responseString = sb.toString();

        response.setHeader(CONTENT_TYPE, MediaType.PLAIN_TEXT_UTF_8.type());
        response.getWriter().write(responseString);
    }
}

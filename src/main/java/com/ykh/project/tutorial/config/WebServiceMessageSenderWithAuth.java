package com.ykh.project.tutorial.config;

import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

import java.io.IOException;
import java.net.HttpURLConnection;

public class WebServiceMessageSenderWithAuth extends HttpUrlConnectionMessageSender {
    @Override
    protected void prepareConnection(HttpURLConnection connection) throws IOException {
        connection.setRequestProperty("Authorization", "Basic tesst???");

        super.prepareConnection(connection);
    }
}

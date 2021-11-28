package ajax;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpRequest {

    // one instance, reuse
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws Exception {

        try {
            System.out.println("Testing 1 - Send Http GET request");
            sendGet();

            System.out.println("Testing 2 - Send Http POST request");
            sendPost();
        } finally {
            close();
        }
    }

    private static void close() throws IOException {
        httpClient.close();
    }

    private static void sendGet() throws Exception {

        HttpGet request = new HttpGet("http://localhost:8080/api/products/");

        // add request headers
        request.addHeader("custom-key", "programming");

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        }

    }

    private static void sendPost() throws Exception {

        HttpPost post = new HttpPost("http://localhost:8080/api/product/");

        String json = "{\"name\": \"Kaszanka\",\n" +
                "        \"price\": 12.5,\n" +
                "        \"bestBeforeDate\": \"2020-12-19T11:07:49.589Z\"}";
        StringEntity entity = new StringEntity(json);
        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity rEntity = response.getEntity();

            if (rEntity != null) {
                // return it as a String
                String result = EntityUtils.toString(rEntity);
                System.out.println(result);
            }
        }
    }
}

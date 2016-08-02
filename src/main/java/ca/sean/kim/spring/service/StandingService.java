package ca.sean.kim.spring.service;

import ca.sean.kim.spring.converters.StandingPopulator;
//import ca.sean.kim.spring.dao.StandingDao;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URI;

/**
 * Created by 37264 on 5/20/16.
 */
@Service("standingService")
@Transactional
public class StandingService {

    @Autowired
    private StandingPopulator standingPopulator;
//
//    @Autowired
//    private StandingDao standingDao;

    public String executeGet(String url) throws Exception {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();;

        try {
            // Create request
            URIBuilder builder = new URIBuilder(url);
//            builder.addParameters(bodyParameters);
            URI uri = builder.build();
            HttpGet method = new HttpGet(uri);
//            HttpPost postMethod = new HttpPost(uri);
            HttpDelete deleteMethod = new HttpDelete(uri);


            // Parse and check response
            HttpResponse response = httpClient.execute(method);
            ResponseHandler<String> handler = new BasicResponseHandler();
            String body = handler.handleResponse(response);

            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(body);

            JSONArray standings = (JSONArray) jsonObject.get("standing");
            persistStanding(standings);


            return body;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {
            // Close the connection
            try {
                httpClient.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Transactional
    private void persistStanding(final JSONArray standings) {

        for (Object standing : standings) {

            JSONObject jsonStanding = (JSONObject) standing;

//            standingDao.saveStanding(standingPopulator.populateStandingFromJson(jsonStanding));
        }
    }
}

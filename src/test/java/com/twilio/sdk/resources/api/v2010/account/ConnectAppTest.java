package com.twilio.sdk.resources.api.v2010.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.sdk.Twilio;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.MarshalConverter;
import com.twilio.sdk.exceptions.TwilioException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.sdk.TwilioTest.serialize;
import static org.junit.Assert.*;

public class ConnectAppTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          TwilioRestClient.Domains.API,
                                          "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps/CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json",
                                          "AC123");
            
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            ConnectApp.fetch("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"authorize_redirect_url\": \"http://example.com/redirect\",\"company_name\": \"Twilio\",\"deauthorize_callback_method\": \"GET\",\"deauthorize_callback_url\": \"http://example.com/deauth\",\"description\": null,\"friendly_name\": \"Connect app for deletion\",\"homepage_url\": \"http://example.com/home\",\"permissions\": [],\"sid\": \"CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps/CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(ConnectApp.fetch("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          TwilioRestClient.Domains.API,
                                          "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps/CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json",
                                          "AC123");
            
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            ConnectApp.update("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"authorize_redirect_url\": \"http://example.com/redirect\",\"company_name\": \"Twilio\",\"deauthorize_callback_method\": \"GET\",\"deauthorize_callback_url\": \"http://example.com/deauth\",\"description\": null,\"friendly_name\": \"Connect app for deletion\",\"homepage_url\": \"http://example.com/home\",\"permissions\": [],\"sid\": \"CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps/CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        ConnectApp.update("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          TwilioRestClient.Domains.API,
                                          "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps.json",
                                          "AC123");
            
            request.addQueryParam("PageSize", "50");
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            ConnectApp.read("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"connect_apps\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"authorize_redirect_url\": \"http://example.com/redirect\",\"company_name\": \"Twilio\",\"deauthorize_callback_method\": \"GET\",\"deauthorize_callback_url\": \"http://example.com/deauth\",\"description\": null,\"friendly_name\": \"Connect app for deletion\",\"homepage_url\": \"http://example.com/home\",\"permissions\": [],\"sid\": \"CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps/CNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json\"}],\"end\": 0,\"first_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps.json?Page=0&PageSize=50\",\"last_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps.json?Page=0&PageSize=50\",\"next_page_uri\": null,\"num_pages\": 1,\"page\": 0,\"page_size\": 50,\"previous_page_uri\": null,\"start\": 0,\"total\": 1,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps.json\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(ConnectApp.read("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute());
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"connect_apps\": [],\"end\": 0,\"first_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps.json?Page=0&PageSize=50\",\"last_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps.json?Page=0&PageSize=50\",\"next_page_uri\": null,\"num_pages\": 1,\"page\": 0,\"page_size\": 50,\"previous_page_uri\": null,\"start\": 0,\"total\": 1,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ConnectApps.json\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(ConnectApp.read("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute());
    }
}
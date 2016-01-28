package com.twilio.sdk.resources.api.v2010.account.usage;

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

public class TriggerTest {
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
                                          "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers/UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json",
                                          "AC123");
            
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Trigger.fetch("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"api_version\": \"2010-04-01\",\"callback_method\": \"GET\",\"callback_url\": \"http://cap.com/streetfight\",\"current_value\": \"0\",\"date_created\": \"Sun, 06 Sep 2015 12:58:45 +0000\",\"date_fired\": null,\"date_updated\": \"Sun, 06 Sep 2015 12:58:45 +0000\",\"friendly_name\": \"raphael-cluster-1441544325.86\",\"recurring\": \"yearly\",\"sid\": \"UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"trigger_by\": \"price\",\"trigger_value\": \"50\",\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers/UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"usage_category\": \"totalprice\",\"usage_record_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Records?Category=totalprice\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(Trigger.fetch("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          TwilioRestClient.Domains.API,
                                          "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers/UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json",
                                          "AC123");
            
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Trigger.update("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"api_version\": \"2010-04-01\",\"callback_method\": \"GET\",\"callback_url\": \"http://cap.com/streetfight\",\"current_value\": \"0\",\"date_created\": \"Sun, 06 Sep 2015 12:58:45 +0000\",\"date_fired\": null,\"date_updated\": \"Sun, 06 Sep 2015 12:58:45 +0000\",\"friendly_name\": \"raphael-cluster-1441544325.86\",\"recurring\": \"yearly\",\"sid\": \"UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"trigger_by\": \"price\",\"trigger_value\": \"50\",\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers/UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"usage_category\": \"totalprice\",\"usage_record_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Records?Category=totalprice\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        Trigger.update("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
    }

    @Test
    public void testDeleteRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.DELETE,
                                          TwilioRestClient.Domains.API,
                                          "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers/UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.json",
                                          "AC123");
            
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Trigger.delete("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testDeleteResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("null", TwilioRestClient.HTTP_STATUS_CODE_NO_CONTENT);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        Trigger.delete("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
    }

    @Test
    public void testCreateRequest() {
                    new NonStrictExpectations() {{
                        Request request = new Request(HttpMethod.POST,
                                                      TwilioRestClient.Domains.API,
                                                      "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers.json",
                                                      "AC123");
                        request.addPostParam("CallbackUrl", serialize(URI.create("https://example.com")));
        request.addPostParam("TriggerValue", serialize("triggerValue"));
        request.addPostParam("UsageCategory", serialize(Trigger.UsageCategory.CALLERIDLOOKUPS));
                        
                        twilioRestClient.request(request);
                        times = 1;
                        result = new Response("", 500);
                        twilioRestClient.getAccountSid();
                        result = "AC123";
                    }};
        
        try {
            Trigger.create("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", URI.create("https://example.com"), "triggerValue", Trigger.UsageCategory.CALLERIDLOOKUPS).execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"api_version\": \"2010-04-01\",\"callback_method\": \"GET\",\"callback_url\": \"http://cap.com/streetfight\",\"current_value\": \"0\",\"date_created\": \"Sun, 06 Sep 2015 12:58:45 +0000\",\"date_fired\": null,\"date_updated\": \"Sun, 06 Sep 2015 12:58:45 +0000\",\"friendly_name\": \"raphael-cluster-1441544325.86\",\"recurring\": \"yearly\",\"sid\": \"UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"trigger_by\": \"price\",\"trigger_value\": \"50\",\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers/UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"usage_category\": \"totalprice\",\"usage_record_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Records?Category=totalprice\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        Trigger.create("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", URI.create("https://example.com"), "triggerValue", Trigger.UsageCategory.CALLERIDLOOKUPS).execute();
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          TwilioRestClient.Domains.API,
                                          "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers.json",
                                          "AC123");
            
            request.addQueryParam("PageSize", "50");
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Trigger.read("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"end\": 0,\"first_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers?PageSize=1&Page=0\",\"last_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers?PageSize=1&Page=626\",\"next_page_uri\": null,\"num_pages\": 627,\"page\": 0,\"page_size\": 1,\"previous_page_uri\": null,\"start\": 0,\"total\": 627,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers\",\"usage_triggers\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"api_version\": \"2010-04-01\",\"callback_method\": \"GET\",\"callback_url\": \"http://cap.com/streetfight\",\"current_value\": \"0\",\"date_created\": \"Sun, 06 Sep 2015 12:58:45 +0000\",\"date_fired\": null,\"date_updated\": \"Sun, 06 Sep 2015 12:58:45 +0000\",\"friendly_name\": \"raphael-cluster-1441544325.86\",\"recurring\": \"yearly\",\"sid\": \"UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"trigger_by\": \"price\",\"trigger_value\": \"50\",\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers/UTaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"usage_category\": \"totalprice\",\"usage_record_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Records?Category=totalprice\"}]}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(Trigger.read("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute());
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"end\": 0,\"first_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers?PageSize=1&Page=0\",\"last_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers?PageSize=1&Page=626\",\"next_page_uri\": null,\"num_pages\": 627,\"page\": 0,\"page_size\": 1,\"previous_page_uri\": null,\"start\": 0,\"total\": 627,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Usage/Triggers\",\"usage_triggers\": []}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(Trigger.read("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute());
    }
}
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

public class TokenTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          TwilioRestClient.Domains.API,
                                          "/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Tokens.json",
                                          "AC123");
            
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Token.create("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"Fri, 24 Jul 2015 18:43:58 +0000\",\"date_updated\": \"Fri, 24 Jul 2015 18:43:58 +0000\",\"ice_servers\": [{\"url\": \"stun:global.stun:3478?transport=udp\"},{\"credential\": \"5SR2x8mZK1lTFJW3NVgLGw6UM9C0dja4jI/Hdw3xr+w=\",\"url\": \"turn:global.turn:3478?transport=udp\",\"username\": \"cda92e5006c7810494639fc466ecc80182cef8183fdf400f84c4126f3b59d0bb\"}],\"password\": \"5SR2x8mZK1lTFJW3NVgLGw6UM9C0dja4jI/Hdw3xr+w=\",\"ttl\": \"86400\",\"username\": \"cda92e5006c7810494639fc466ecc80182cef8183fdf400f84c4126f3b59d0bb\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        Token.create("ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").execute();
    }
}
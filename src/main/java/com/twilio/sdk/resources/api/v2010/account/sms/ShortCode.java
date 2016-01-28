package com.twilio.sdk.resources.api.v2010.account.sms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.MarshalConverter;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.api.v2010.account.sms.ShortCodeFetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.readers.api.v2010.account.sms.ShortCodeReader;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.SidResource;
import com.twilio.sdk.updaters.api.v2010.account.sms.ShortCodeUpdater;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortCode extends SidResource {
    private static final long serialVersionUID = 186171326966142L;

    /**
     * Fetch an instance of a short code
     * 
     * @param accountSid The account_sid
     * @param sid Fetch by unique short-code Sid
     * @return ShortCodeFetcher capable of executing the fetch
     */
    public static ShortCodeFetcher fetch(final String accountSid, final String sid) {
        return new ShortCodeFetcher(accountSid, sid);
    }

    /**
     * Update a short code with the following parameters
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     * @return ShortCodeUpdater capable of executing the update
     */
    public static ShortCodeUpdater update(final String accountSid, final String sid) {
        return new ShortCodeUpdater(accountSid, sid);
    }

    /**
     * Retrieve a list of short-codes belonging to the account used to make the
     * request
     * 
     * @param accountSid The account_sid
     * @return ShortCodeReader capable of executing the read
     */
    public static ShortCodeReader read(final String accountSid) {
        return new ShortCodeReader(accountSid);
    }

    /**
     * Converts a JSON String into a ShortCode object using the provided
     * ObjectMapper
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ShortCode object represented by the provided JSON
     */
    public static ShortCode fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ShortCode.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ShortCode object using the provided
     * ObjectMapper
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ShortCode object represented by the provided JSON
     */
    public static ShortCode fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ShortCode.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final String shortCode;
    private final String sid;
    private final HttpMethod smsFallbackMethod;
    private final URI smsFallbackUrl;
    private final HttpMethod smsMethod;
    private final URI smsUrl;
    private final String uri;

    @JsonCreator
    private ShortCode(@JsonProperty("account_sid")
                      final String accountSid, 
                      @JsonProperty("api_version")
                      final String apiVersion, 
                      @JsonProperty("date_created")
                      final String dateCreated, 
                      @JsonProperty("date_updated")
                      final String dateUpdated, 
                      @JsonProperty("friendly_name")
                      final String friendlyName, 
                      @JsonProperty("short_code")
                      final String shortCode, 
                      @JsonProperty("sid")
                      final String sid, 
                      @JsonProperty("sms_fallback_method")
                      final HttpMethod smsFallbackMethod, 
                      @JsonProperty("sms_fallback_url")
                      final URI smsFallbackUrl, 
                      @JsonProperty("sms_method")
                      final HttpMethod smsMethod, 
                      @JsonProperty("sms_url")
                      final URI smsUrl, 
                      @JsonProperty("uri")
                      final String uri) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.dateCreated = MarshalConverter.dateTimeFromString(dateCreated);
        this.dateUpdated = MarshalConverter.dateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.shortCode = shortCode;
        this.sid = sid;
        this.smsFallbackMethod = smsFallbackMethod;
        this.smsFallbackUrl = smsFallbackUrl;
        this.smsMethod = smsMethod;
        this.smsUrl = smsUrl;
        this.uri = uri;
    }

    /**
     * @return The unique sid that identifies this account
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * @return The API version to use
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * @return The date this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * @return The date this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * @return A human readable description of this resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * @return The short code. e.g., 894546.
     */
    public final String getShortCode() {
        return this.shortCode;
    }

    /**
     * @return A string that uniquely identifies this short-codes
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * @return HTTP method Twilio will use with sms fallback url
     */
    public final HttpMethod getSmsFallbackMethod() {
        return this.smsFallbackMethod;
    }

    /**
     * @return URL Twilio will request if an error occurs in executing TwiML
     */
    public final URI getSmsFallbackUrl() {
        return this.smsFallbackUrl;
    }

    /**
     * @return HTTP method to use when requesting the sms url
     */
    public final HttpMethod getSmsMethod() {
        return this.smsMethod;
    }

    /**
     * @return URL Twilio will request when receiving an SMS
     */
    public final URI getSmsUrl() {
        return this.smsUrl;
    }

    /**
     * @return The URI for this resource
     */
    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        ShortCode other = (ShortCode) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(shortCode, other.shortCode) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(smsFallbackMethod, other.smsFallbackMethod) && 
               Objects.equals(smsFallbackUrl, other.smsFallbackUrl) && 
               Objects.equals(smsMethod, other.smsMethod) && 
               Objects.equals(smsUrl, other.smsUrl) && 
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            apiVersion,
                            dateCreated,
                            dateUpdated,
                            friendlyName,
                            shortCode,
                            sid,
                            smsFallbackMethod,
                            smsFallbackUrl,
                            smsMethod,
                            smsUrl,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("apiVersion", apiVersion)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("shortCode", shortCode)
                          .add("sid", sid)
                          .add("smsFallbackMethod", smsFallbackMethod)
                          .add("smsFallbackUrl", smsFallbackUrl)
                          .add("smsMethod", smsMethod)
                          .add("smsUrl", smsUrl)
                          .add("uri", uri)
                          .toString();
    }
}
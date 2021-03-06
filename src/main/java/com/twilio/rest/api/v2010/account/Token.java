/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.type.IceServer;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Token extends Resource {
    private static final long serialVersionUID = 281090396283982L;

    /**
     * Create a TokenCreator to execute create.
     * 
     * @param pathAccountSid The account_sid
     * @return TokenCreator capable of executing the create
     */
    public static TokenCreator creator(final String pathAccountSid) {
        return new TokenCreator(pathAccountSid);
    }

    /**
     * Create a TokenCreator to execute create.
     * 
     * @return TokenCreator capable of executing the create
     */
    public static TokenCreator creator() {
        return new TokenCreator();
    }

    /**
     * Converts a JSON String into a Token object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Token object represented by the provided JSON
     */
    public static Token fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Token.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Token object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Token object represented by the provided JSON
     */
    public static Token fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Token.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final List<IceServer> iceServers;
    private final String password;
    private final String ttl;
    private final String username;

    @JsonCreator
    private Token(@JsonProperty("account_sid")
                  final String accountSid, 
                  @JsonProperty("date_created")
                  final String dateCreated, 
                  @JsonProperty("date_updated")
                  final String dateUpdated, 
                  @JsonProperty("ice_servers")
                  final List<IceServer> iceServers, 
                  @JsonProperty("password")
                  final String password, 
                  @JsonProperty("ttl")
                  final String ttl, 
                  @JsonProperty("username")
                  final String username) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.iceServers = iceServers;
        this.password = password;
        this.ttl = ttl;
        this.username = username;
    }

    /**
     * Returns The The unique sid that identifies this account.
     * 
     * @return The unique sid that identifies this account
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The date this resource was created.
     * 
     * @return The date this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date this resource was last updated.
     * 
     * @return The date this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The An array representing the ephemeral credentials.
     * 
     * @return An array representing the ephemeral credentials
     */
    public final List<IceServer> getIceServers() {
        return this.iceServers;
    }

    /**
     * Returns The The temporary password used for authenticating.
     * 
     * @return The temporary password used for authenticating
     */
    public final String getPassword() {
        return this.password;
    }

    /**
     * Returns The The duration in seconds the credentials are valid.
     * 
     * @return The duration in seconds the credentials are valid
     */
    public final String getTtl() {
        return this.ttl;
    }

    /**
     * Returns The The temporary username that uniquely identifies a Token..
     * 
     * @return The temporary username that uniquely identifies a Token.
     */
    public final String getUsername() {
        return this.username;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Token other = (Token) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(iceServers, other.iceServers) && 
               Objects.equals(password, other.password) && 
               Objects.equals(ttl, other.ttl) && 
               Objects.equals(username, other.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            dateCreated,
                            dateUpdated,
                            iceServers,
                            password,
                            ttl,
                            username);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("iceServers", iceServers)
                          .add("password", password)
                          .add("ttl", ttl)
                          .add("username", username)
                          .toString();
    }
}
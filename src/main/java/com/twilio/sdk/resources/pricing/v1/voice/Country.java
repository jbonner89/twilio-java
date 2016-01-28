package com.twilio.sdk.resources.pricing.v1.voice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.pricing.v1.voice.CountryFetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.readers.pricing.v1.voice.CountryReader;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.SidResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country extends SidResource {
    private static final long serialVersionUID = 270847470775437L;

    /**
     * read
     * 
     * @return CountryReader capable of executing the read
     */
    public static CountryReader read() {
        return new CountryReader();
    }

    /**
     * fetch
     * 
     * @param isoCountry The iso_country
     * @return CountryFetcher capable of executing the fetch
     */
    public static CountryFetcher fetch(final String isoCountry) {
        return new CountryFetcher(isoCountry);
    }

    /**
     * Converts a JSON String into a Country object using the provided ObjectMapper
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Country object represented by the provided JSON
     */
    public static Country fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Country.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Country object using the provided
     * ObjectMapper
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Country object represented by the provided JSON
     */
    public static Country fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Country.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String country;
    private final String isoCountry;
    private final List<String> outboundPrefixPrices;
    private final List<String> inboundCallPrices;
    private final Currency priceUnit;
    private final URI url;

    @JsonCreator
    private Country(@JsonProperty("country")
                    final String country, 
                    @JsonProperty("iso_country")
                    final String isoCountry, 
                    @JsonProperty("outbound_prefix_prices")
                    final List<String> outboundPrefixPrices, 
                    @JsonProperty("inbound_call_prices")
                    final List<String> inboundCallPrices, 
                    @JsonProperty("price_unit")
                    @JsonDeserialize(using = com.twilio.sdk.converters.CurrencyDeserializer.class)
                    final Currency priceUnit, 
                    @JsonProperty("url")
                    final URI url) {
        this.country = country;
        this.isoCountry = isoCountry;
        this.outboundPrefixPrices = outboundPrefixPrices;
        this.inboundCallPrices = inboundCallPrices;
        this.priceUnit = priceUnit;
        this.url = url;
    }

    /**
     * @return The iso_country
     */
    public final String getSid() {
        return this.getIsoCountry();
    }

    /**
     * @return The country
     */
    public final String getCountry() {
        return this.country;
    }

    /**
     * @return The iso_country
     */
    public final String getIsoCountry() {
        return this.isoCountry;
    }

    /**
     * @return The outbound_prefix_prices
     */
    public final List<String> getOutboundPrefixPrices() {
        return this.outboundPrefixPrices;
    }

    /**
     * @return The inbound_call_prices
     */
    public final List<String> getInboundCallPrices() {
        return this.inboundCallPrices;
    }

    /**
     * @return The price_unit
     */
    public final Currency getPriceUnit() {
        return this.priceUnit;
    }

    /**
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Country other = (Country) o;
        
        return Objects.equals(country, other.country) && 
               Objects.equals(isoCountry, other.isoCountry) && 
               Objects.equals(outboundPrefixPrices, other.outboundPrefixPrices) && 
               Objects.equals(inboundCallPrices, other.inboundCallPrices) && 
               Objects.equals(priceUnit, other.priceUnit) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country,
                            isoCountry,
                            outboundPrefixPrices,
                            inboundCallPrices,
                            priceUnit,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("country", country)
                          .add("isoCountry", isoCountry)
                          .add("outboundPrefixPrices", outboundPrefixPrices)
                          .add("inboundCallPrices", inboundCallPrices)
                          .add("priceUnit", priceUnit)
                          .add("url", url)
                          .toString();
    }
}
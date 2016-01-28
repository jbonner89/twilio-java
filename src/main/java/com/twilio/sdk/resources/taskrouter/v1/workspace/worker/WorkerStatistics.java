package com.twilio.sdk.resources.taskrouter.v1.workspace.worker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.taskrouter.v1.workspace.worker.WorkerStatisticsFetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resources.Resource;
import com.twilio.sdk.resources.RestException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkerStatistics extends Resource {
    private static final long serialVersionUID = 174071152398170L;

    /**
     * fetch
     * 
     * @param workspaceSid The workspace_sid
     * @param workerSid The worker_sid
     * @return WorkerStatisticsFetcher capable of executing the fetch
     */
    public static WorkerStatisticsFetcher fetch(final String workspaceSid, final String workerSid) {
        return new WorkerStatisticsFetcher(workspaceSid, workerSid);
    }

    /**
     * Converts a JSON String into a WorkerStatistics object using the provided
     * ObjectMapper
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return WorkerStatistics object represented by the provided JSON
     */
    public static WorkerStatistics fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkerStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a WorkerStatistics object using the provided
     * ObjectMapper
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return WorkerStatistics object represented by the provided JSON
     */
    public static WorkerStatistics fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkerStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String cumulative;
    private final String workerSid;
    private final String workspaceSid;

    @JsonCreator
    private WorkerStatistics(@JsonProperty("account_sid")
                             final String accountSid, 
                             @JsonProperty("cumulative")
                             final String cumulative, 
                             @JsonProperty("worker_sid")
                             final String workerSid, 
                             @JsonProperty("workspace_sid")
                             final String workspaceSid) {
        this.accountSid = accountSid;
        this.cumulative = cumulative;
        this.workerSid = workerSid;
        this.workspaceSid = workspaceSid;
    }

    /**
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * @return The cumulative
     */
    public final String getCumulative() {
        return this.cumulative;
    }

    /**
     * @return The worker_sid
     */
    public final String getWorkerSid() {
        return this.workerSid;
    }

    /**
     * @return The workspace_sid
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        WorkerStatistics other = (WorkerStatistics) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(cumulative, other.cumulative) && 
               Objects.equals(workerSid, other.workerSid) && 
               Objects.equals(workspaceSid, other.workspaceSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            cumulative,
                            workerSid,
                            workspaceSid);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("cumulative", cumulative)
                          .add("workerSid", workerSid)
                          .add("workspaceSid", workspaceSid)
                          .toString();
    }
}
package com.twilio.sdk.resources.taskrouter.v1.workspace.task_queue;

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
import com.twilio.sdk.fetchers.taskrouter.v1.workspace.task_queue.TaskQueueStatisticsFetcher;
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
public class TaskQueueStatistics extends Resource {
    private static final long serialVersionUID = 270967847861151L;

    /**
     * fetch
     * 
     * @param workspaceSid The workspace_sid
     * @param taskQueueSid The task_queue_sid
     * @return TaskQueueStatisticsFetcher capable of executing the fetch
     */
    public static TaskQueueStatisticsFetcher fetch(final String workspaceSid, final String taskQueueSid) {
        return new TaskQueueStatisticsFetcher(workspaceSid, taskQueueSid);
    }

    /**
     * Converts a JSON String into a TaskQueueStatistics object using the provided
     * ObjectMapper
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return TaskQueueStatistics object represented by the provided JSON
     */
    public static TaskQueueStatistics fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskQueueStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a TaskQueueStatistics object using the
     * provided ObjectMapper
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return TaskQueueStatistics object represented by the provided JSON
     */
    public static TaskQueueStatistics fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskQueueStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Map<String, String> cumulative;
    private final Map<String, String> realtime;
    private final String taskQueueSid;
    private final String workspaceSid;

    @JsonCreator
    private TaskQueueStatistics(@JsonProperty("account_sid")
                                final String accountSid, 
                                @JsonProperty("cumulative")
                                final Map<String, String> cumulative, 
                                @JsonProperty("realtime")
                                final Map<String, String> realtime, 
                                @JsonProperty("task_queue_sid")
                                final String taskQueueSid, 
                                @JsonProperty("workspace_sid")
                                final String workspaceSid) {
        this.accountSid = accountSid;
        this.cumulative = cumulative;
        this.realtime = realtime;
        this.taskQueueSid = taskQueueSid;
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
    public final Map<String, String> getCumulative() {
        return this.cumulative;
    }

    /**
     * @return The realtime
     */
    public final Map<String, String> getRealtime() {
        return this.realtime;
    }

    /**
     * @return The task_queue_sid
     */
    public final String getTaskQueueSid() {
        return this.taskQueueSid;
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
        
        TaskQueueStatistics other = (TaskQueueStatistics) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(cumulative, other.cumulative) && 
               Objects.equals(realtime, other.realtime) && 
               Objects.equals(taskQueueSid, other.taskQueueSid) && 
               Objects.equals(workspaceSid, other.workspaceSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            cumulative,
                            realtime,
                            taskQueueSid,
                            workspaceSid);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("cumulative", cumulative)
                          .add("realtime", realtime)
                          .add("taskQueueSid", taskQueueSid)
                          .add("workspaceSid", workspaceSid)
                          .toString();
    }
}
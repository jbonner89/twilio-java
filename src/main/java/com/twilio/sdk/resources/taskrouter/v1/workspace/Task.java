package com.twilio.sdk.resources.taskrouter.v1.workspace;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.MarshalConverter;
import com.twilio.sdk.creators.taskrouter.v1.workspace.TaskCreator;
import com.twilio.sdk.deleters.taskrouter.v1.workspace.TaskDeleter;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.taskrouter.v1.workspace.TaskFetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.readers.taskrouter.v1.workspace.TaskReader;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.SidResource;
import com.twilio.sdk.updaters.taskrouter.v1.workspace.TaskUpdater;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task extends SidResource {
    private static final long serialVersionUID = 85239715418365L;

    public enum Status {
        PENDING("pending"),
        RESERVED("reserved"),
        ASSIGNED("assigned"),
        CANCELED("canceled");
    
        private final String value;
        
        private Status(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        @JsonCreator
        public static Status forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            return Status.valueOf(normalized);
        }
    }

    /**
     * fetch
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return TaskFetcher capable of executing the fetch
     */
    public static TaskFetcher fetch(final String workspaceSid, final String sid) {
        return new TaskFetcher(workspaceSid, sid);
    }

    /**
     * update
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return TaskUpdater capable of executing the update
     */
    public static TaskUpdater update(final String workspaceSid, final String sid) {
        return new TaskUpdater(workspaceSid, sid);
    }

    /**
     * delete
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return TaskDeleter capable of executing the delete
     */
    public static TaskDeleter delete(final String workspaceSid, final String sid) {
        return new TaskDeleter(workspaceSid, sid);
    }

    /**
     * read
     * 
     * @param workspaceSid The workspace_sid
     * @return TaskReader capable of executing the read
     */
    public static TaskReader read(final String workspaceSid) {
        return new TaskReader(workspaceSid);
    }

    /**
     * create
     * 
     * @param workspaceSid The workspace_sid
     * @param attributes The attributes
     * @param workflowSid The workflow_sid
     * @return TaskCreator capable of executing the create
     */
    public static TaskCreator create(final String workspaceSid, final String attributes, final String workflowSid) {
        return new TaskCreator(workspaceSid, attributes, workflowSid);
    }

    /**
     * Converts a JSON String into a Task object using the provided ObjectMapper
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Task object represented by the provided JSON
     */
    public static Task fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Task.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Task object using the provided
     * ObjectMapper
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Task object represented by the provided JSON
     */
    public static Task fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Task.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Integer age;
    private final Task.Status assignmentStatus;
    private final String attributes;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final Integer priority;
    private final String reason;
    private final String sid;
    private final String taskQueueSid;
    private final Integer timeout;
    private final String workflowSid;
    private final String workspaceSid;

    @JsonCreator
    private Task(@JsonProperty("account_sid")
                 final String accountSid, 
                 @JsonProperty("age")
                 final Integer age, 
                 @JsonProperty("assignment_status")
                 final Task.Status assignmentStatus, 
                 @JsonProperty("attributes")
                 final String attributes, 
                 @JsonProperty("date_created")
                 final String dateCreated, 
                 @JsonProperty("date_updated")
                 final String dateUpdated, 
                 @JsonProperty("priority")
                 final Integer priority, 
                 @JsonProperty("reason")
                 final String reason, 
                 @JsonProperty("sid")
                 final String sid, 
                 @JsonProperty("task_queue_sid")
                 final String taskQueueSid, 
                 @JsonProperty("timeout")
                 final Integer timeout, 
                 @JsonProperty("workflow_sid")
                 final String workflowSid, 
                 @JsonProperty("workspace_sid")
                 final String workspaceSid) {
        this.accountSid = accountSid;
        this.age = age;
        this.assignmentStatus = assignmentStatus;
        this.attributes = attributes;
        this.dateCreated = MarshalConverter.dateTimeFromString(dateCreated);
        this.dateUpdated = MarshalConverter.dateTimeFromString(dateUpdated);
        this.priority = priority;
        this.reason = reason;
        this.sid = sid;
        this.taskQueueSid = taskQueueSid;
        this.timeout = timeout;
        this.workflowSid = workflowSid;
        this.workspaceSid = workspaceSid;
    }

    /**
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * @return The age
     */
    public final Integer getAge() {
        return this.age;
    }

    /**
     * @return The assignment_status
     */
    public final Task.Status getAssignmentStatus() {
        return this.assignmentStatus;
    }

    /**
     * @return The attributes
     */
    public final String getAttributes() {
        return this.attributes;
    }

    /**
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * @return The priority
     */
    public final Integer getPriority() {
        return this.priority;
    }

    /**
     * @return The reason
     */
    public final String getReason() {
        return this.reason;
    }

    /**
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * @return The task_queue_sid
     */
    public final String getTaskQueueSid() {
        return this.taskQueueSid;
    }

    /**
     * @return The timeout
     */
    public final Integer getTimeout() {
        return this.timeout;
    }

    /**
     * @return The workflow_sid
     */
    public final String getWorkflowSid() {
        return this.workflowSid;
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
        
        Task other = (Task) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(age, other.age) && 
               Objects.equals(assignmentStatus, other.assignmentStatus) && 
               Objects.equals(attributes, other.attributes) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(priority, other.priority) && 
               Objects.equals(reason, other.reason) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(taskQueueSid, other.taskQueueSid) && 
               Objects.equals(timeout, other.timeout) && 
               Objects.equals(workflowSid, other.workflowSid) && 
               Objects.equals(workspaceSid, other.workspaceSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            age,
                            assignmentStatus,
                            attributes,
                            dateCreated,
                            dateUpdated,
                            priority,
                            reason,
                            sid,
                            taskQueueSid,
                            timeout,
                            workflowSid,
                            workspaceSid);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("age", age)
                          .add("assignmentStatus", assignmentStatus)
                          .add("attributes", attributes)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("priority", priority)
                          .add("reason", reason)
                          .add("sid", sid)
                          .add("taskQueueSid", taskQueueSid)
                          .add("timeout", timeout)
                          .add("workflowSid", workflowSid)
                          .add("workspaceSid", workspaceSid)
                          .toString();
    }
}
package com.twilio.sdk.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;

public class PhoneNumberCapabilities {
    private final boolean mms;
    private final boolean sms;
    private final boolean voice;

    @JsonCreator
    public PhoneNumberCapabilities(@JsonProperty("mms") final boolean mms,
                                   @JsonProperty("sms") final boolean sms,
                                   @JsonProperty("voice") final boolean voice) {
        this.mms = mms;
        this.sms = sms;
        this.voice = voice;
    }

    public boolean getMms() {
        return this.mms;
    }

    public boolean getSms() {
        return this.sms;
    }

    public boolean getVoice() {
        return this.voice;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PhoneNumberCapabilities other = (PhoneNumberCapabilities) o;

        return (this.getMms() == other.getMms() &&
                this.getSms() == other.getSms() &&
                this.getVoice() == other.getVoice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.mms, this.sms, this.voice);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mms", mms)
                .add("sms", sms)
                .add("voice", voice)
                .toString();
    }
}

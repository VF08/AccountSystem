package za.ac.nwu.ac.domain.service;

import org.springframework.context.support.DefaultLifecycleProcessor;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse<T> implements Serializable{
    private static final long serialVersUID = -3300948392647393049L;
    private final boolean successful;
    private final transient T payload;

    public GeneralResponse(boolean successful, T payload)
    {
        this.successful = successful;
        this.payload = payload;
    }

    public boolean isSuccessful()
    {
        return successful;
    }

    public T getPayload()
    {
        return payload;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        GeneralResponse<?> that = (GeneralResponse<?>) obj;

        return successful == that.successful && Objects.equals(payload, that.payload);
    }

    public int hashCode()
    {
        return Objects.hash(successful, payload);
    }

    public String toString()
    {
        return "GeneralResponse{ successful = " + successful + ", payload = " + "}";
    }
}

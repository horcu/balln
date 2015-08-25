package com.horcu.apps.balln.utilities;

/**
 * Created by hacz on 8/18/2015.
 */
public class AsyncTaskResult<T> {
    private T result;
    private Exception error;
    private String blank;

    public T getResult() {
        return result;
    }

    public Exception getError() {
        return error;
    }

    public AsyncTaskResult(T result) {
        super();
        this.result = result;
    }

    public AsyncTaskResult(Exception error) {
        super();
        this.error = error;
    }

    public AsyncTaskResult(String nothing) {
        super();
        this.blank = nothing;
    }
}

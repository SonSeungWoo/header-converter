package me.seungwoo;

import lombok.Data;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 15:15
 */
@Data
public class ExResponse<T> {
    private Boolean isSucceed;
    private Boolean isWarning;
    private String error;
    private String warning;
    private T result;

    public ExResponse() {

    }

    private ExResponse(ExResponse.Builder<T> builder) {
        this.isSucceed = builder.isSucceed;
        this.isWarning = builder.isWarning;
        this.error = builder.error;
        this.warning = builder.warning;
        this.result = builder.result;
    }

    public static class Builder<T> {
        private Boolean isSucceed;
        private Boolean isWarning;
        private String error;
        private String warning;
        private T result;

        public Builder(T result) {
            this.result = result;
        }

        public Builder(T result, String error, String warning) {
            this.result = result;
            this.error = error;
            this.warning = warning;
        }

        public ExResponse.Builder setIsSucceed(Boolean isSucceed) {
            this.isSucceed = isSucceed;
            return this;
        }

        public ExResponse.Builder setIsWarning(Boolean isWarning) {
            this.isWarning = isWarning;
            return this;
        }

        public ExResponse build() {
            return new ExResponse<>(this);
        }
    }
}

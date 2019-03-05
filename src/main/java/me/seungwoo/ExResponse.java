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
    private T response;

    public ExResponse() {

    }

    private ExResponse(ExResponse.Builder<T> builder) {
        this.response = builder.response;
    }

    public static class Builder<T> {
        private T response;

        public Builder(T response) {
            this.response = response;
        }

        public ExResponse build() {
            return new ExResponse<>(this);
        }
    }
}

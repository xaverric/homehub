package cz.homehub.rest.api;

public class Response<T> {

    private T response;
    private ResponseStatus responseStatus;
    private String message;

    public static class Builder<T> {

        private T response;
        private ResponseStatus responseStatus;
        private String message;

        public Builder<T> setResponse(T response){
            this.response = response;
            return this;
        }

        public Builder<T> setResponseStatus(ResponseStatus responseStatus){
            this.responseStatus = responseStatus;
            return this;
        }

        public Builder<T> setMessage(String message){
            this.message = message;
            return this;
        }

        public Response build(){
            Response response = new Response<>();
            response.setResponse(this.response);
            response.setMessage(this.message);
            response.setResponseStatus(this.responseStatus);
            return response;
        }
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public String getMessage() {
        return message;
    }

    private Response() {
    }
}

package cz.homehub.rest.api;


public interface ExceptionResponseHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = javax.persistence.EntityNotFoundException.class)
    default Response handleEntityNotFoundException(javax.persistence.EntityNotFoundException ex){
        return new Response.Builder<String>()
                .setResponseStatus(ResponseStatus.ERROR)
                .setMessage(ex.getMessage())
                .build();
    }

}

package com.nishant.ctplbackend.errorhandler;


import com.nishant.ctplbackend.model.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex , HttpHeaders headers, HttpStatusCode statusCode, WebRequest request){

        Response res = new Response(statusCode.toString(), ex.getBindingResult().toString());

        return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler({ProductCreationException.class})
    public ResponseEntity<Response> handleProductCreation(ProductCreationException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("400", ex.getMessage()));
    }


    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Response> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("404" , ex.getMessage()));
    }


    @ExceptionHandler({Exception.class})
    public ResponseEntity<Response> globalErrorHandler(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("500",e.getMessage()));
    }

}

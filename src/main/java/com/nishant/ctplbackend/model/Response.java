package com.nishant.ctplbackend.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private String statusCode;

    private String message;

}

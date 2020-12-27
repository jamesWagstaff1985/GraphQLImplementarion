package com.graphql.postgres.controllers;

import lombok.RequiredArgsConstructor;
import org.graphqlize.java.GraphQLResolver;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GraphQLController {

    private final GraphQLResolver resolver;

    @PostMapping("graphql")
    ResponseEntity handle(@RequestBody GraphQLRequest graphQLRequest) {
        String result =
                resolver.resolve(
                        graphQLRequest.getQuery(),
                        graphQLRequest.getVariables());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .body(result);
    }

}

package com.fatih.basketball.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import jakarta.validation.ConstraintViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
    if (ex instanceof MaxPlayerSizeException) {
      return GraphqlErrorBuilder.newError()
                                .errorType(ErrorType.FORBIDDEN)
                                .message(ex.getMessage())
                                .path(env.getExecutionStepInfo().getPath())
                                .location(env.getField().getSourceLocation())
                                .build();
    } else if (ex instanceof BindException) {
      return GraphqlErrorBuilder.newError()
                                .errorType(ErrorType.BAD_REQUEST)
                                .message(ex.getMessage())
                                .path(env.getExecutionStepInfo().getPath())
                                .location(env.getField().getSourceLocation())
                                .build();
    } else if (ex instanceof ConstraintViolationException) {
      return GraphqlErrorBuilder.newError()
                                .errorType(ErrorType.BAD_REQUEST)
                                .message(ex.getMessage())
                                .path(env.getExecutionStepInfo().getPath())
                                .location(env.getField().getSourceLocation())
                                .build();
    } else if (ex instanceof PlayerNotFoundException) {
      return GraphqlErrorBuilder.newError()
                                .errorType(ErrorType.NOT_FOUND)
                                .message(ex.getMessage())
                                .path(env.getExecutionStepInfo().getPath())
                                .location(env.getField().getSourceLocation())
                                .build();
    } else {
      System.out.println(ex.getMessage());
      return GraphqlErrorBuilder.newError()
                                .errorType(ErrorType.BAD_REQUEST)
                                .message("Unknown Error. Please check your request")
                                .path(env.getExecutionStepInfo().getPath())
                                .location(env.getField().getSourceLocation())
                                .build();
    }
  }


}

package com.fatih.basketball.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.List;
import org.springframework.graphql.execution.ErrorType;

public class MaxPlayerSizeException extends RuntimeException implements GraphQLError, IBasketballRegisterAppException {

  private static final String ERROR_MESSAGE = "Maximum capacity is 12, you can not add more player!!";

  public MaxPlayerSizeException() {
    super(ERROR_MESSAGE);
  }

  @Override
  public List<SourceLocation> getLocations() {
    return new ArrayList<>();
  }

  @Override
  public ErrorClassification getErrorType() {
    return ErrorType.FORBIDDEN;
  }

  @Override
  public GraphQLError throwException(Throwable ex, DataFetchingEnvironment env) {
    return GraphqlErrorBuilder.newError()
                              .errorType(ErrorType.FORBIDDEN)
                              .message(ex.getMessage())
                              .path(env.getExecutionStepInfo().getPath())
                              .location(env.getField().getSourceLocation())
                              .build();
  }
}

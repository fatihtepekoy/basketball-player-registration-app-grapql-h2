package com.fatih.basketball.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import org.springframework.graphql.execution.ErrorType;

public class PlayerNotFoundException extends RuntimeException implements GraphQLError, IBasketballRegisterAppException {

  private static final String errorMessage = "Player does not exist. ID : ";

  public PlayerNotFoundException(String id) {
    super(errorMessage + id);
  }

  @Override
  public String getMessage() {
    return super.getMessage();
  }

  @Override
  public List<Object> getPath() {
    return null;
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public ErrorClassification getErrorType() {
    return ErrorType.NOT_FOUND;
  }

  @Override
  public GraphQLError throwException(Throwable ex, DataFetchingEnvironment env) {
    return GraphqlErrorBuilder.newError()
                              .errorType(ErrorType.NOT_FOUND)
                              .message(ex.getMessage())
                              .path(env.getExecutionStepInfo().getPath())
                              .location(env.getField().getSourceLocation())
                              .build();
  }
}
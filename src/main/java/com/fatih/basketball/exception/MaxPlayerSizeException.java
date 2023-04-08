package com.fatih.basketball.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import java.util.List;
import java.util.Map;
import org.springframework.graphql.execution.ErrorType;

public class MaxPlayerSizeException extends RuntimeException implements GraphQLError {

  private static final String errorMessage = "Maximum capacity is 12, you can not add more player!!";

  public MaxPlayerSizeException() {
    super(errorMessage);
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public ErrorClassification getErrorType() {
    return ErrorType.FORBIDDEN;
  }

  @Override
  public List<Object> getPath() {
    return GraphQLError.super.getPath();
  }

  @Override
  public Map<String, Object> toSpecification() {
    return GraphQLError.super.toSpecification();
  }

  @Override
  public Map<String, Object> getExtensions() {
    return GraphQLError.super.getExtensions();
  }
}

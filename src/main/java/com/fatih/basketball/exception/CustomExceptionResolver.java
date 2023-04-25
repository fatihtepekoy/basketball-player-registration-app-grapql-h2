package com.fatih.basketball.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {

    if (ex instanceof IBasketballRegisterAppException basketballRegisterAppException) {
      return basketballRegisterAppException.throwException(ex, env);
    } else {
      return GraphqlErrorBuilder.newError()
                                .errorType(ErrorType.BAD_REQUEST)
                                .message(ex.getMessage())
                                .path(env.getExecutionStepInfo().getPath())
                                .location(env.getField().getSourceLocation())
                                .build();
    }

  }


}

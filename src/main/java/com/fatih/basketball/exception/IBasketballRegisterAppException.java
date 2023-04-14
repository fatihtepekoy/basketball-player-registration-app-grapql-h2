package com.fatih.basketball.exception;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;

public interface IBasketballRegisterAppException {

  GraphQLError throwException(Throwable ex, DataFetchingEnvironment env);

}

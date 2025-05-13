package com.itacademy.aqa;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTableType;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeRegistryConfiguration implements ParameterByTypeTransformer, TypeRegistryConfigurer {
  @Override
  public void configureTypeRegistry(TypeRegistry typeRegistry) {
    typeRegistry.defineParameterType(new ParameterType<>("stringList", ".+",
        List.class,
        this::transformListString));

    typeRegistry.defineDataTableType(new DataTableType(Boolean.class, Boolean::parseBoolean));

  }

  private List<String> transformListString(String strings) {
    List<String> stringList = Arrays.asList(strings.split(","));
    return stringList.stream().map(String::trim).collect(Collectors.toList());
  }

  @Override
  public Object transform(String s, Type type) throws Throwable {
    return new Object();
  }
}

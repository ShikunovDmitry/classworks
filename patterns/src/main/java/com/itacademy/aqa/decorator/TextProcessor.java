package com.itacademy.aqa.decorator;

interface TextProcessor {
  String process(String text);
}

class SimpleTextProcessor implements TextProcessor{
  @Override
  public String process(String text) {
    return text;
  }
}



abstract class TextDecorator implements TextProcessor{

  protected TextProcessor wrapper;

  public TextDecorator(TextProcessor wrapper){
    this.wrapper = wrapper;
  }

  @Override
  public String process(String text){
    return wrapper.process(text);
  }
}

class UpperCaseDecorator extends TextDecorator {
  public UpperCaseDecorator(TextProcessor wrapper) {
    super(wrapper);
  }

  @Override
  public String process(String text) {
    return super.process(text).toUpperCase();
  }
}

class SurroundWithQuotesDecorator extends TextDecorator {
  public SurroundWithQuotesDecorator(TextProcessor wrapper) {
    super(wrapper);
  }
  @Override
  public String process(String text){
    return "\"" + super.process(text) + "\"";
  }
}

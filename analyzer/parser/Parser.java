package parser;

import token.Token;

import java.text.ParsePosition;

public interface Parser {
    Token parse(String text, ParsePosition pos);
}

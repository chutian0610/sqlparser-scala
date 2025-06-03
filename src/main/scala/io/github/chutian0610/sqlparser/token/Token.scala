package io.github.chutian0610.sqlparser.token

/** SQL Token enumeration
  */
sealed trait Token {
  override def toString(): String = this match
    case EOF                      => "EOF"
    case KeyWord(value)           => value.toString()
    case Identifier(value, quote) => if (quote.isDefined) s"$quote$value$quote" else value
    case Literal(value)           => value.toString()
    case Symbol(value)            => value.toString()
    case IllegalToken(text)       => text
}

/* An end-of-file marker, not a real token */
case object EOF extends Token

/* keyword */
case class KeyWord(value: KeyWordEnum) extends Token

/* optionally quoted identifier */
case class Identifier(value: String, quote: Option[String]) extends Token

/* Literal */
case class Literal(value: LiteralEnum) extends Token

/* Punctuation & Operator */
case class Symbol(value: SymbolEnum) extends Token

/* IllegalToken */
case class IllegalToken(text: String) extends Token

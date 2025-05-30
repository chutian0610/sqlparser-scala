package io.github.chutian0610.sqlparser.token

/** SQL Token enumeration
  */
sealed trait Token

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

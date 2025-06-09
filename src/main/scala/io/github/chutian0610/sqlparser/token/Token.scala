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
  override def equals(that: Any): Boolean = that match
    case TokenWithLocation(token, section) => this.equals(token)
    case token: Token                      => this.equals(token)
    case _                                 => false
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

case class TokenWithLocation(
    token: Token,
    section: Section
) {
  override def equals(that: Any): Boolean = that match
    case TokenWithLocation(token, section) => token.equals(this.token)
    case token: Token                      => token.equals(this.token)
    case _                                 => false

  override def hashCode(): Int    = token.hashCode()
  override def toString(): String = token.toString()
}
object TokenWithLocation {
  def wrap(token: Token): TokenWithLocation = TokenWithLocation(token, Section.empty())
  def at(token: Token, start: Location, end: Location) = {
    TokenWithLocation(token, Section(start, end))
  }
  def eof() = TokenWithLocation(EOF, Section.empty())
}

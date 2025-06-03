package io.github.chutian0610.sqlparser.token

sealed trait LiteralEnum(value: String) {
  override def toString(): String = this match
    case LongLiteral(value)                  => value
    case DoubleLiteral(value)                => value
    case StringLiteral(value, quote)         => s"$quote$value$quote"
    case ByteStringLiteral(value, quote)     => s"$quote$value$quote"
    case NationalStringLiteral(value)        => s"N'$value'"
    case EscapedStringLiteral(value)         => s"E'$value'"
    case UnicodeStringLiteral(value, escape) => s"U&'$value' ESCAPE '$escape'"
    case HexStringLiteral(value)             => s"X'$value'"
}
/* Long Number Literal */
case class LongLiteral(value: String) extends LiteralEnum(value: String)

/* Double Number Literal */
case class DoubleLiteral(value: String) extends LiteralEnum(value: String)

/* String Literal, i.e: 'string',"string", '''string''' */
case class StringLiteral(value: String, quote: String) extends LiteralEnum(value: String)

/* Byte String Literal, i.e: b'string', b"string", b'''string''' */
case class ByteStringLiteral(value: String, quote: String) extends LiteralEnum(value: String)

/* "National" string literal: i.e: N'string' */
case class NationalStringLiteral(value: String) extends LiteralEnum(value: String)

/* "escaped" string literal, which are an extension to the SQL standard: i.e: e'first \n second' or E 'first \n second' */
case class EscapedStringLiteral(value: String) extends LiteralEnum(value: String)

/* Unicode string with escape character */
case class UnicodeStringLiteral(value: String, escape: String) extends LiteralEnum(value: String)

/* Hexadecimal string literal: i.e.: X'deadbeef' */
case class HexStringLiteral(value: String) extends LiteralEnum(value: String)

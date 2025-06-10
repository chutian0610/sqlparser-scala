package io.github.chutian0610.sqlparser.token

import io.github.chutian0610.sqlparser.dialect.Dialect
import scala.compiletime.ops.boolean
import quest._
import scala.collection.mutable.Stack

case class TokenizerError(location: Location, message: String)

class TokenizerContext(
    private var line: Int = 1,
    private var column: Int = 1,
    private var input: String = "",
    private var pos: Int = 0,
    private var buffer: Stack[TokenWithLocation] = Stack()
) {
  def setInput(str: String, start: Int = 0): Unit = {
    input = str
    pos = start
    line = 1
    column = 1
    buffer.clear()
  }

  def peekChar(): Option[Char] = {
    if (pos < input.length) Some(input(pos))
    else None
  }

  def peekNChar(n: Int): Option[String] = {
    val targetPos = pos + n
    if (targetPos < input.length) Some(input.substring(pos, targetPos))
    else None
  }

  def advanceChar(): Unit = {
    if (pos < input.length) {
      if (input(pos) == '\n') {
        line += 1
        column = 1
      } else {
        column += 1
      }
      pos += 1
    }
  }
  def currentLocation: Location = Location(line, column)

  def isEOF: Boolean = pos >= input.length

  def pushToken(token: TokenWithLocation): Unit = {
    buffer.push(token)
  }

  def popToken(): Option[TokenWithLocation] = {
    if (buffer.isEmpty) None else Some(buffer.pop())
  }

  def peekToken(): Option[TokenWithLocation] = {
    if (buffer.isEmpty) None else Some(buffer.top)
  }
}

class Tokenizer(
    // The dialect of the SQL to tokenize
    dialect: Dialect,
    // If true (the default), the tokenizer will un-escape literal SQL strings
    unescape: Boolean = true
) {
  def tokenize(context: TokenizerContext): Either[TokenizerError, List[Token]] = quest {
    val tokens = tokenizeWithLocation(context).?
    Right(tokens.map(_.token))
  }

  def tokenizeWithLocation(context: TokenizerContext): Either[TokenizerError, List[TokenWithLocation]] = {
    Right(List())
  }
}

object Tokenizer {
  def apply(dialect: Dialect, unescape: Boolean = true): Tokenizer =
    new Tokenizer(dialect, unescape)
}

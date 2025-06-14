package io.github.chutian0610.sqlparser.token

sealed trait SymbolEnum(val text: String) {
  override def toString(): String = this.text
}
case object Comma        extends SymbolEnum(",")
case object DoubleEq     extends SymbolEnum("==")
case object Spaceship    extends SymbolEnum("<=>")
case object Eq           extends SymbolEnum("=")
case object NEq          extends SymbolEnum("!=")
case object Lt           extends SymbolEnum("<")
case object Gt           extends SymbolEnum(">")
case object LtEq         extends SymbolEnum("<=")
case object GtEq         extends SymbolEnum(">=")
case object Plus         extends SymbolEnum("+")
case object Minus        extends SymbolEnum("-")
case object Mul          extends SymbolEnum("*")
case object Div          extends SymbolEnum("/")
case object Mod          extends SymbolEnum("%")
case object StringConcat extends SymbolEnum("||")
case object LParen       extends SymbolEnum("(")
case object RParen       extends SymbolEnum(")")
case object LBracket     extends SymbolEnum("[")
case object RBracket     extends SymbolEnum("]")
case object LBrace       extends SymbolEnum("{")
case object RBrace       extends SymbolEnum("}")
case object Period       extends SymbolEnum(".")
case object Colon        extends SymbolEnum(":")
case object DoubleColon  extends SymbolEnum("::")
case object Semicolon    extends SymbolEnum(";")
case object Assignment   extends SymbolEnum(":=")
case object Backslash    extends SymbolEnum("\\")
case object Ampersand    extends SymbolEnum("&")
case object Caret        extends SymbolEnum("^")
case object Pipe         extends SymbolEnum("|")
case object RArrow       extends SymbolEnum("=>")
case object Sharp        extends SymbolEnum("#")
case object DoubleSharp  extends SymbolEnum("##")
case object AtSign       extends SymbolEnum("@")
case object CaretAt      extends SymbolEnum("^@")
case object ShiftLeft    extends SymbolEnum("<<")
case object ShiftRight   extends SymbolEnum(">>")
case object Arrow        extends SymbolEnum("->")
case object Question     extends SymbolEnum("?")

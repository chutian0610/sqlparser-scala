package io.github.chutian0610.sqlparser.token

sealed trait SymbolEnum(val text: String)
case object Comma extends SymbolEnum(",")

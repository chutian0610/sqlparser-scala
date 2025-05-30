package io.github.chutian0610.sqlparser.token

sealed trait WhiteSpaceEnum(val text: String)
case object Space                                                            extends WhiteSpaceEnum(" ")

case object NewLine                                                          extends WhiteSpaceEnum("\n")
case object Tab                                                              extends WhiteSpaceEnum("\t")
case class SingleLineComment(prefix: String, comment: String)                extends WhiteSpaceEnum(comment)
case class MultiLineComment(prefix: String, comment: String, suffix: String) extends WhiteSpaceEnum(comment)

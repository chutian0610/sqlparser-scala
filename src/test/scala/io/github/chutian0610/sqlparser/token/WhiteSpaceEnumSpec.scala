package io.github.chutian0610.sqlparser.token

import org.scalatest._
import flatspec._
import matchers._
import io.github.chutian0610.sqlparser.token.WhiteSpaceEnum

class WhiteSpaceEnumSpec extends AnyFlatSpec with should.Matchers {
  "Space" should "print ' ' when call toString method" in {
    val item = Space
    item.toString() should be(" ")
  }
  "NewLine" should "print '\n' when call toString method" in {
    val item = NewLine
    item.toString() should be("\n")
  }
  "Tab" should "print '\t' when call toString method" in {
    val item = Tab
    item.toString() should be("\t")
  }
  "SingleLineComment(//,hello)" should "print '// hello' when call toString method" in {
    val item = SingleLineComment("//", "hello")
    item.toString() should be("// hello")
  }
  "MultiLineComment(/*,hello,*/)" should "print '/* hello */' when call toString method" in {
    val item = MultiLineComment("/*", "hello", "*/")
    item.toString() should be("/* hello */")
  }
}

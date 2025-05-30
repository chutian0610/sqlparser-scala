package io.github.chutian0610.sqlparser.token

case class Location(
    /** Line number, starting from 1
      */
    line: Long,
    /** Line column, starting from 1.
      */
    column: Long
) {
  override def toString: String         = s"Position($line,$column)"
  def toSection(end: Location): Section = Section(this, `end`)
}

object Location {
  def empty(): Location = Location(0, 0)
}

case class Section(
    /** inclusive
      */
    start: Location,
    /** inclusive
      */
    end: Location
) {
  override def toString: String = s"Section($start...$end)"
}

object Section {
  val EMPTY: Section   = Section.empty()
  def empty(): Section = Section(Location(0, 0), Location(0, 0))
}

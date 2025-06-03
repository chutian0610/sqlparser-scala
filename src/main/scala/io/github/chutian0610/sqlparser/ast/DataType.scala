package io.github.chutian0610.sqlparser.ast

/** Represents all possible SQL data types */
enum DataType:
  case Boolean
  case TinyInt
  case SmallInt
  case Integer
  case BigInt
  case Float
  case Double
  case Decimal(precision: Option[Int], scale: Option[Int])
  case Varchar(length: Option[Int])
  case Char(length: Int)
  case Text
  case Binary(length: Option[Int])
  case Date
  case Time
  case Timestamp
  case Interval
  case Array(elementType: DataType)
  case Map(keyType: DataType, valueType: DataType)
  case Struct(fields: List[(String, DataType)])
  case Custom(name: String)

  override def toString: String = this match
    case Boolean => "BOOLEAN"
    case TinyInt => "TINYINT"
    case SmallInt => "SMALLINT"
    case Integer => "INTEGER"
    case BigInt => "BIGINT"
    case Float => "FLOAT"
    case Double => "DOUBLE"
    case Decimal(p, s) => 
      (p, s) match
        case (Some(p), Some(s)) => s"DECIMAL($p, $s)"
        case (Some(p), None) => s"DECIMAL($p)"
        case _ => "DECIMAL"
    case Varchar(Some(n)) => s"VARCHAR($n)"
    case Varchar(None) => "VARCHAR"
    case Char(n) => s"CHAR($n)"
    case Text => "TEXT"
    case Binary(Some(n)) => s"BINARY($n)"
    case Binary(None) => "BINARY"
    case Date => "DATE"
    case Time => "TIME"
    case Timestamp => "TIMESTAMP"
    case Interval => "INTERVAL"
    case Array(t) => s"ARRAY<${t.toString}>"
    case Map(k, v) => s"MAP<${k.toString}, ${v.toString}>"
    case Struct(fields) => 
      val fieldStr = fields.map((name, typ) => s"$name ${typ.toString}").mkString(", ")
      s"STRUCT<$fieldStr>"
    case Custom(name) => name 
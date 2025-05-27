import SqlParserDependencies._
import SqlParserResolvers._

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "io.github.chutian0610"
ThisBuild / scalaVersion := "3.7.0"
ThisBuild / semanticdbEnabled:= true

// ================================ projects structure ==============================================

lazy val root = (project in file("."))
  .settings(
    name := "sqlparser-scala",
    commonSettings,
    libraryDependencies ++= Seq (
      scalatest
      ,guava
      ,scalaLogging
      ,slf4jSimple
      ,quest
    )
  )
// ===================================== common setting ======================================================

lazy val commonSettings = Seq(
  scalacOptions ++= compilerOptions,
  resolvers := allResolver
)

/*
 * @see https://docs.scala-lang.org/overviews/compiler-options/index.html
 */
lazy val compilerOptions = Seq(
  "-encoding", "utf8",
  "-feature",
  "-language:existentials",
  "-language:implicitConversions",
  "-unchecked",
  "-explain"
)
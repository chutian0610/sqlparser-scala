# SQL Parser in Scala

This project is a Scala implementation of SQL parser, inspired by Apache DataFusion's SQL parser (datafusion-sqlparser-rs).

## Features

- ANSI SQL compliant parser
- Support for various SQL statements (SELECT, INSERT, UPDATE, DELETE, etc.)
- Extensible architecture for custom SQL dialects
- Built with Scala 3.7.0

## Project Structure

```

```

## Usage

Add the dependency to your `build.sbt`:

```scala
libraryDependencies += "io.github.chutian0610" %% "sqlparser-scala" % "0.1.0-SNAPSHOT"
```

## Development

This project uses SBT as the build tool. To build the project:

```bash
sbt compile
```

To run tests:

```bash
sbt test
```

## License

Apache License 2.0

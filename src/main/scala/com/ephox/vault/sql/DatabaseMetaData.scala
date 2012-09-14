package com.ephox
package vault
package sql

import SqlT._
import java.sql.{ DatabaseMetaData => D, Connection => C }

sealed trait DatabaseMetaData {
  private[sql] val x: D

  import DatabaseMetaData._

  def allProceduresAreCallable: Sql[Boolean] =
    Try(x.allProceduresAreCallable)

  def allTablesAreSelectable: Sql[Boolean] =
    Try(x.allTablesAreSelectable)

  def dataDefinitionCausesTransactionCommit: Sql[Boolean] =
    Try(x.dataDefinitionCausesTransactionCommit)

  def dataDefinitionIgnoredInTransactions: Sql[Boolean] =
    Try(x.dataDefinitionIgnoredInTransactions)

  def deletesAreDetectable(t: ResultSetType): Sql[Boolean] =
    Try(x.deletesAreDetected(t.int))

  def doesMaxRowSizeIncludeBlobs: Sql[Boolean] =
    Try(x.doesMaxRowSizeIncludeBlobs)

  def attributes(catalog: Option[String], schemaPattern: Option[String], typeNamePattern: String, attributeNamePattern: String): Sql[ResultSet] =
    Try(ResultSet(x.getAttributes(catalog.orNull, schemaPattern.orNull, typeNamePattern, attributeNamePattern)))

  def bestRowIdentifier(catalog: Option[String], schema: Option[String], table: String, scope: BestRow, nullable: Boolean): Sql[ResultSet] =
    Try(ResultSet(x.getBestRowIdentifier(catalog.orNull, schema.orNull, table, scope.int, nullable)))

  def catalogs: Sql[ResultSet] =
    Try(ResultSet(x.getCatalogs))

  def catalogSeparator: Sql[String] =
    Try(x.getCatalogSeparator)

  def catalogTerm: Sql[String] =
    Try(x.getCatalogTerm)

  def columnPrivileges(catalog: Option[String], schemaPattern: Option[String], typeNamePattern: String, columnNamePattern: String): Sql[ResultSet] =
    Try(ResultSet(x.getColumnPrivileges(catalog.orNull, schemaPattern.orNull, typeNamePattern, columnNamePattern)))

  def columns(catalog: Option[String], schemaPattern: Option[String], typeNamePattern: String, columnNamePattern: String): Sql[ResultSet] =
    Try(ResultSet(x.getColumns(catalog.orNull, schemaPattern.orNull, typeNamePattern, columnNamePattern)))

  def connection: Sql[Connection] =
    Try(Connection(x.getConnection))

  def crossReference(primaryCatalog: Option[String], primarySchema: Option[String], primaryTable: String, foreignCatalog: Option[String], foreignSchema: Option[String], foreignTable: String): Sql[ResultSet] =
    Try(ResultSet(x.getCrossReference(primaryCatalog.orNull, primarySchema.orNull, primaryTable, foreignCatalog.orNull, foreignSchema.orNull, foreignTable)))

  def databaseMajorVersion: Sql[Int] =
    Try(x.getDatabaseMajorVersion)

  def databaseMinorVersion: Sql[Int] =
    Try(x.getDatabaseMinorVersion)

  def databaseProductName: Sql[String] =
    Try(x.getDatabaseProductName)

  def databaseProductVersion: Sql[String] =
    Try(x.getDatabaseProductVersion)

  def defaultTransactionIsolation: Sql[TransactionIsolation] =
    Try(x.getDefaultTransactionIsolation) map (c =>
      if(c == C.TRANSACTION_READ_UNCOMMITTED)
        TransactionIsolation.ReadUncommitted
      else if(c == C.TRANSACTION_READ_COMMITTED)
        TransactionIsolation.ReadCommitted
      else if(c == C.TRANSACTION_REPEATABLE_READ)
        TransactionIsolation.RepeatableRead
      else if(c == C.TRANSACTION_SERIALIZABLE)
        TransactionIsolation.Serializable
      else if(c == C.TRANSACTION_NONE)
        TransactionIsolation.None
      else
        sys.error("[" + c + """] http://docs.oracle.com/javase/1.5.0/docs/api/java/sql/DatabaseMetaData.html#getDefaultTransactionIsolation%28%29 Retrieves this database's default transaction isolation level. The possible values are defined in java.sql.Connection. """))

  def driverMajorVersion: Sql[Int] =
    Try(x.getDriverMajorVersion)

  def driverMinorVersion: Sql[Int] =
    Try(x.getDriverMinorVersion)

  def driverName: Sql[String] =
    Try(x.getDriverName)

  def driverVersion: Sql[String] =
    Try(x.getDriverVersion)

  def exportedKeys(catalog: Option[String], schema: Option[String], table: String): Sql[ResultSet] =
    Try(ResultSet(x.getExportedKeys(catalog.orNull, schema.orNull, table)))

  def extraNameCharacters: Sql[String] =
    Try(x.getExtraNameCharacters)

  def identifierQuoteString: Sql[String] =
    Try(x.getIdentifierQuoteString)

  def importedKeys(catalog: Option[String], schema: Option[String], table: String): Sql[ResultSet] =
    Try(ResultSet(x.getImportedKeys(catalog.orNull, schema.orNull, table)))

  def indexInfo(catalog: Option[String], schema: Option[String], table: String, unique: Boolean, approximate: Boolean): Sql[ResultSet] =
    Try(ResultSet(x.getIndexInfo(catalog.orNull, schema.orNull, table, unique, approximate)))

  def jdbcMajorVersion: Sql[Int] =
    Try(x.getJDBCMajorVersion)

  def jdbcMinorVersion: Sql[Int] =
    Try(x.getJDBCMinorVersion)

  def maxBinaryLiteralLength: Sql[Int] =
    Try(x.getMaxBinaryLiteralLength)

  def maxCatalogNameLength: Sql[Int] =
    Try(x.getMaxCatalogNameLength)

  def maxCharLiteralLength: Sql[Int] =
    Try(x.getMaxCharLiteralLength)

  def maxColumnNameLength: Sql[Int] =
    Try(x.getMaxColumnNameLength)

  def maxColumnsInGroupBy: Sql[Int] =
    Try(x.getMaxColumnsInGroupBy)

  def maxColumnsInIndex: Sql[Int] =
    Try(x.getMaxColumnsInIndex)

  def maxColumnsInOrderBy: Sql[Int] =
    Try(x.getMaxColumnsInOrderBy)

  def maxColumnsInSelect: Sql[Int] =
    Try(x.getMaxColumnsInSelect)

  def maxColumnsInTable: Sql[Int] =
    Try(x.getMaxColumnsInTable)

  def maxConnections: Sql[Int] =
    Try(x.getMaxConnections)

  def maxCursorNameLength: Sql[Int] =
    Try(x.getMaxCursorNameLength)

  def maxIndexLength: Sql[Int] =
    Try(x.getMaxIndexLength)

  def maxProcedureNameLength: Sql[Int] =
    Try(x.getMaxProcedureNameLength)

  def maxRowSize: Sql[Int] =
    Try(x.getMaxRowSize)

  def maxSchemaNameLength: Sql[Int] =
    Try(x.getMaxSchemaNameLength)

  def maxStatementLength: Sql[Int] =
    Try(x.getMaxStatementLength)

  def maxStatements: Sql[Int] =
    Try(x.getMaxStatements)

  def maxTableNameLength: Sql[Int] =
    Try(x.getMaxTableNameLength)

  def maxTablesInSelect: Sql[Int] =
    Try(x.getMaxTablesInSelect)

  def maxUserNameLength: Sql[Int] =
    Try(x.getMaxUserNameLength)

}

object DatabaseMetaData {
  def apply(xx: D): DatabaseMetaData =
    new DatabaseMetaData {
      val x = xx
    }

  sealed trait BestRow {
    def int: Int =
      this match {
        case BestRow.Unknown => D.bestRowUnknown
        case BestRow.NotPseudo => D.bestRowNotPseudo
        case BestRow.Pseudo => D.bestRowPseudo
      }
  }

  object BestRow {
    case object Unknown extends BestRow
    case object NotPseudo extends BestRow
    case object Pseudo extends BestRow
  }

}

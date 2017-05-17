package models.db.common
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  import scala.slick.collection.heterogenous._
  import scala.slick.collection.heterogenous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Alerts.ddl ++ CellIdentities.ddl ++ Cells.ddl ++ CellStateHistory.ddl ++ CellUptime.ddl ++ CustomerConfig.ddl ++ CustomerConfigStaging.ddl ++ Events.ddl ++ Groups.ddl ++ ImportedCells.ddl ++ ImportedNodes.ddl ++ ImportedSites.ddl ++ Majoralerts.ddl ++ MCellDowntime.ddl ++ MCellState.ddl ++ MeasurementRepeats.ddl ++ MSiteOperatorHour.ddl ++ MSiteServiceCounters.ddl ++ MSiteServiceDowntime.ddl ++ MSiteServiceState.ddl ++ NewCells.ddl ++ NewSites.ddl ++ Nodes.ddl ++ Notes.ddl ++ Roles.ddl ++ SectorIdentities.ddl ++ ServiceCounterHistory.ddl ++ SiteCounters.ddl ++ SiteCountersNew.ddl ++ SiteOperatorCounterHistory.ddl ++ SiteOperatorPerformanceHistory.ddl ++ Sites.ddl ++ SiteServiceCounterHistory.ddl ++ SiteServiceStateHistory.ddl ++ States.ddl ++ StatesTemp.ddl ++ Tickets.ddl ++ Token.ddl ++ User.ddl ++ VAllCells.ddl ++ VAllSites.ddl ++ VCellDowntime.ddl ++ VCellGenerationNo.ddl ++ VCellNo.ddl ++ VCellState.ddl ++ VCellUptime.ddl ++ VCurrentCounters.ddl ++ VCurrentFileTimes.ddl ++ VCurrentKpi.ddl ++ VCurrentMeasurementTime.ddl ++ VCurrentMeasurementTime2.ddl ++ VCurrentPerformance.ddl ++ VDashboardAlert.ddl ++ VDashboardCell.ddl ++ VDashboardCellHistory.ddl ++ VDashboardCellIdentity.ddl ++ VDashboardCellOutageHistory.ddl ++ VDashboardCurrentMeasurementTime.ddl ++ VDashboardCurrentPerformance.ddl ++ VDashboardDailyPerformanceHistory.ddl ++ VDashboardDailyVendorPerformanceHistory.ddl ++ VDashboardEvent.ddl ++ VDashboardGroup.ddl ++ VDashboardHourlyPerformanceHistory.ddl ++ VDashboardHourlySiteOperatorPerformanceHistory.ddl ++ VDashboardHourlyVendorPerformanceHistory.ddl ++ VDashboardMonthlyOperatorPerformanceHistory.ddl ++ VDashboardMonthlyPerformanceHistory.ddl ++ VDashboardMonthlyVendorPerformanceHistory.ddl ++ VDashboardNode.ddl ++ VDashboardNote.ddl ++ VDashboardPerformanceAlertMessage.ddl ++ VDashboardPerformanceAlertStatus.ddl ++ VDashboardPerformanceHistory.ddl ++ VDashboardQualityAlertMessage.ddl ++ VDashboardQualityAlertStatus.ddl ++ VDashboardSectorHistory.ddl ++ VDashboardSectorIdentity.ddl ++ VDashboardSectorOutageHistory.ddl ++ VDashboardSite.ddl ++ VDashboardSiteOperatorPerformanceHistory.ddl ++ VDashboardTicket.ddl ++ VDashboardVendor.ddl ++ VDashboardVendorPerformanceHistory.ddl ++ VDashboardWeeklyPerformanceHistory.ddl ++ VDashboardWeeklyVendorPerformanceHistory.ddl ++ VendorPerformanceHistory.ddl ++ Vendors.ddl ++ VGenerationNo.ddl ++ VHourlySiteOperatorPerformanceHistory.ddl ++ VKpiHistory.ddl ++ VKpiThreshold.ddl ++ VLastCellUptime.ddl ++ VNewCellUptime.ddl ++ VPerformanceAlertEvents.ddl ++ VPerformanceHistory.ddl ++ VPerformanceHistory2.ddl ++ VPerformanceSiteOperatorHistory.ddl ++ VReportStickyCell.ddl ++ VReportStickySite.ddl ++ VServiceCounters.ddl ++ VSiteCounters.ddl ++ VSiteNote.ddl ++ VSiteOperatorCounters.ddl ++ VSiteOperatorPerformanceHistory.ddl ++ VSiteServiceCounters.ddl ++ VSiteServiceDowntime.ddl ++ VSiteServiceOperatorCounterHistory.ddl ++ VSiteServiceState.ddl ++ VSiteServiceStateHistory.ddl ++ VSiteTicket.ddl ++ VStates.ddl ++ VStatesDowntime.ddl ++ VVendorPerformanceHistory.ddl
  
  /** Entity class storing rows of table Alerts
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param measure Database column measure DBType(VARCHAR), Length(256,true)
   *  @param period Database column period DBType(BIGINT)
   *  @param threshold Database column threshold DBType(INT)
   *  @param priority Database column priority DBType(INT), Default(99)
   *  @param effectiveFrom Database column effective_from DBType(TIMESTAMP)
   *  @param effectiveTo Database column effective_to DBType(TIMESTAMP) */
  case class AlertsRow(groupId: String, measure: String, period: Option[Long], threshold: Int, priority: Int = 99, effectiveFrom: java.sql.Timestamp, effectiveTo: java.sql.Timestamp)
  /** GetResult implicit for fetching AlertsRow objects using plain SQL queries */
  implicit def GetResultAlertsRow(implicit e0: GR[String], e1: GR[Option[Long]], e2: GR[Int], e3: GR[java.sql.Timestamp]): GR[AlertsRow] = GR{
    prs => import prs._
    AlertsRow.tupled((<<[String], <<[String], <<?[Long], <<[Int], <<[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table alerts. Objects of this class serve as prototypes for rows in queries. */
  class Alerts(_tableTag: Tag) extends Table[AlertsRow](_tableTag, "alerts") {
    def * = (groupId, measure, period, threshold, priority, effectiveFrom, effectiveTo) <> (AlertsRow.tupled, AlertsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, measure.?, period, threshold.?, priority.?, effectiveFrom.?, effectiveTo.?).shaped.<>({r=>import r._; _1.map(_=> AlertsRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column measure DBType(VARCHAR), Length(256,true) */
    val measure: Column[String] = column[String]("measure", O.Length(256,varying=true))
    /** Database column period DBType(BIGINT) */
    val period: Column[Option[Long]] = column[Option[Long]]("period")
    /** Database column threshold DBType(INT) */
    val threshold: Column[Int] = column[Int]("threshold")
    /** Database column priority DBType(INT), Default(99) */
    val priority: Column[Int] = column[Int]("priority", O.Default(99))
    /** Database column effective_from DBType(TIMESTAMP) */
    val effectiveFrom: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_from")
    /** Database column effective_to DBType(TIMESTAMP) */
    val effectiveTo: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_to")
  }
  /** Collection-like TableQuery object for table Alerts */
  lazy val Alerts = new TableQuery(tag => new Alerts(tag))
  
  /** Entity class storing rows of table CellIdentities
   *  @param cellId Database column cell_id DBType(VARCHAR), Length(20,true)
   *  @param generation Database column generation DBType(INT)
   *  @param stateNo Database column state_no DBType(INT)
   *  @param sectorNo Database column sector_no DBType(INT)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param exist Database column exist DBType(BIT) */
  case class CellIdentitiesRow(cellId: Option[String], generation: Int, stateNo: Int, sectorNo: Int, cellNo: Int, exist: Boolean)
  /** GetResult implicit for fetching CellIdentitiesRow objects using plain SQL queries */
  implicit def GetResultCellIdentitiesRow(implicit e0: GR[Option[String]], e1: GR[Int], e2: GR[Boolean]): GR[CellIdentitiesRow] = GR{
    prs => import prs._
    CellIdentitiesRow.tupled((<<?[String], <<[Int], <<[Int], <<[Int], <<[Int], <<[Boolean]))
  }
  /** Table description of table cell_identities. Objects of this class serve as prototypes for rows in queries. */
  class CellIdentities(_tableTag: Tag) extends Table[CellIdentitiesRow](_tableTag, "cell_identities") {
    def * = (cellId, generation, stateNo, sectorNo, cellNo, exist) <> (CellIdentitiesRow.tupled, CellIdentitiesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (cellId, generation.?, stateNo.?, sectorNo.?, cellNo.?, exist.?).shaped.<>({r=>import r._; _2.map(_=> CellIdentitiesRow.tupled((_1, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column cell_id DBType(VARCHAR), Length(20,true) */
    val cellId: Column[Option[String]] = column[Option[String]]("cell_id", O.Length(20,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column state_no DBType(INT) */
    val stateNo: Column[Int] = column[Int]("state_no")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Int] = column[Int]("sector_no")
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Int] = column[Int]("cell_no")
    /** Database column exist DBType(BIT) */
    val exist: Column[Boolean] = column[Boolean]("exist")
    
    /** Index over (cellNo) (database name ranmateFemto_cellIdentities_cellNo) */
    val index1 = index("ranmateFemto_cellIdentities_cellNo", cellNo)
    /** Index over (exist) (database name ranmateFemto_cellIdentities_exist) */
    val index2 = index("ranmateFemto_cellIdentities_exist", exist)
    /** Index over (generation) (database name ranmateFemto_cellIdentities_generation) */
    val index3 = index("ranmateFemto_cellIdentities_generation", generation)
    /** Index over (sectorNo) (database name ranmateFemto_cellIdentities_sectorNo) */
    val index4 = index("ranmateFemto_cellIdentities_sectorNo", sectorNo)
    /** Index over (stateNo) (database name ranmateFemto_cellIdentities_stateNo) */
    val index5 = index("ranmateFemto_cellIdentities_stateNo", stateNo)
  }
  /** Collection-like TableQuery object for table CellIdentities */
  lazy val CellIdentities = new TableQuery(tag => new CellIdentities(tag))
  
  /** Entity class storing rows of table Cells
   *  @param cellNo Database column cell_no DBType(INT), Default(0)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param generation Database column generation DBType(INT)
   *  @param exist Database column exist DBType(BIT)
   *  @param exclude Database column exclude DBType(BIT)
   *  @param sticky Database column sticky DBType(BIT)
   *  @param effectiveFrom Database column effective_from DBType(TIMESTAMP)
   *  @param effectiveTo Database column effective_to DBType(TIMESTAMP) */
  case class CellsRow(cellNo: Int = 0, siteId: String, groupId: String, generation: Int, exist: Boolean, exclude: Boolean, sticky: Boolean, effectiveFrom: java.sql.Timestamp, effectiveTo: java.sql.Timestamp)
  /** GetResult implicit for fetching CellsRow objects using plain SQL queries */
  implicit def GetResultCellsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean], e3: GR[java.sql.Timestamp]): GR[CellsRow] = GR{
    prs => import prs._
    CellsRow.tupled((<<[Int], <<[String], <<[String], <<[Int], <<[Boolean], <<[Boolean], <<[Boolean], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table cells. Objects of this class serve as prototypes for rows in queries. */
  class Cells(_tableTag: Tag) extends Table[CellsRow](_tableTag, "cells") {
    def * = (cellNo, siteId, groupId, generation, exist, exclude, sticky, effectiveFrom, effectiveTo) <> (CellsRow.tupled, CellsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (cellNo.?, siteId.?, groupId.?, generation.?, exist.?, exclude.?, sticky.?, effectiveFrom.?, effectiveTo.?).shaped.<>({r=>import r._; _1.map(_=> CellsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column cell_no DBType(INT), Default(0) */
    val cellNo: Column[Int] = column[Int]("cell_no", O.Default(0))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column exist DBType(BIT) */
    val exist: Column[Boolean] = column[Boolean]("exist")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Boolean] = column[Boolean]("exclude")
    /** Database column sticky DBType(BIT) */
    val sticky: Column[Boolean] = column[Boolean]("sticky")
    /** Database column effective_from DBType(TIMESTAMP) */
    val effectiveFrom: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_from")
    /** Database column effective_to DBType(TIMESTAMP) */
    val effectiveTo: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_to")
    
    /** Index over (cellNo) (database name ranmateFemto_cells_cellNo) */
    val index1 = index("ranmateFemto_cells_cellNo", cellNo)
    /** Index over (effectiveTo) (database name ranmateFemto_cells_effectiveTo) */
    val index2 = index("ranmateFemto_cells_effectiveTo", effectiveTo)
    /** Index over (exclude) (database name ranmateFemto_cells_exclude) */
    val index3 = index("ranmateFemto_cells_exclude", exclude)
    /** Index over (exist) (database name ranmateFemto_cells_exist) */
    val index4 = index("ranmateFemto_cells_exist", exist)
    /** Index over (exist,exclude) (database name ranmateFemto_cells_existExclude) */
    val index5 = index("ranmateFemto_cells_existExclude", (exist, exclude))
    /** Index over (generation) (database name ranmateFemto_cells_generation) */
    val index6 = index("ranmateFemto_cells_generation", generation)
    /** Index over (groupId) (database name ranmateFemto_cells_groupId) */
    val index7 = index("ranmateFemto_cells_groupId", groupId)
    /** Index over (siteId) (database name ranmateFemto_cells_siteId) */
    val index8 = index("ranmateFemto_cells_siteId", siteId)
    /** Index over (sticky) (database name ranmateFemto_cells_sticky) */
    val index9 = index("ranmateFemto_cells_sticky", sticky)
  }
  /** Collection-like TableQuery object for table Cells */
  lazy val Cells = new TableQuery(tag => new Cells(tag))
  
  /** Entity class storing rows of table CellStateHistory
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param priority Database column priority DBType(INT)
   *  @param siteExclude Database column site_exclude DBType(BIT)
   *  @param siteSticky Database column site_sticky DBType(BIT)
   *  @param sectorNo Database column sector_no DBType(INT)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param cellExist Database column cell_exist DBType(BIT)
   *  @param cellExclude Database column cell_exclude DBType(BIT)
   *  @param cellSticky Database column cell_sticky DBType(BIT)
   *  @param cellState Database column cell_state DBType(INT) */
  case class CellStateHistoryRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], nodeId: Option[String], siteId: Option[String], vendorId: Option[String], priority: Option[Int], siteExclude: Option[Boolean], siteSticky: Option[Boolean], sectorNo: Option[Int], cellNo: Option[Int], cellExist: Option[Boolean], cellExclude: Option[Boolean], cellSticky: Option[Boolean], cellState: Option[Int])
  /** GetResult implicit for fetching CellStateHistoryRow objects using plain SQL queries */
  implicit def GetResultCellStateHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]]): GR[CellStateHistoryRow] = GR{
    prs => import prs._
    CellStateHistoryRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Boolean], <<?[Boolean], <<?[Int], <<?[Int], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Int]))
  }
  /** Table description of table cell_state_history. Objects of this class serve as prototypes for rows in queries. */
  class CellStateHistory(_tableTag: Tag) extends Table[CellStateHistoryRow](_tableTag, "cell_state_history") {
    def * = (measurementTime, generation, groupId, nodeId, siteId, vendorId, priority, siteExclude, siteSticky, sectorNo, cellNo, cellExist, cellExclude, cellSticky, cellState) <> (CellStateHistoryRow.tupled, CellStateHistoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, nodeId, siteId, vendorId, priority, siteExclude, siteSticky, sectorNo, cellNo, cellExist, cellExclude, cellSticky, cellState).shaped.<>({r=>import r._; _1.map(_=> CellStateHistoryRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column priority DBType(INT) */
    val priority: Column[Option[Int]] = column[Option[Int]]("priority")
    /** Database column site_exclude DBType(BIT) */
    val siteExclude: Column[Option[Boolean]] = column[Option[Boolean]]("site_exclude")
    /** Database column site_sticky DBType(BIT) */
    val siteSticky: Column[Option[Boolean]] = column[Option[Boolean]]("site_sticky")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column cell_exist DBType(BIT) */
    val cellExist: Column[Option[Boolean]] = column[Option[Boolean]]("cell_exist")
    /** Database column cell_exclude DBType(BIT) */
    val cellExclude: Column[Option[Boolean]] = column[Option[Boolean]]("cell_exclude")
    /** Database column cell_sticky DBType(BIT) */
    val cellSticky: Column[Option[Boolean]] = column[Option[Boolean]]("cell_sticky")
    /** Database column cell_state DBType(INT) */
    val cellState: Column[Option[Int]] = column[Option[Int]]("cell_state")
    
    /** Index over (measurementTime,groupId,siteId) (database name ranmateFemto_cellStateHistory_Composite) */
    val index1 = index("ranmateFemto_cellStateHistory_Composite", (measurementTime, groupId, siteId))
    /** Index over (groupId) (database name ranmateFemto_cellStateHistory_groupId) */
    val index2 = index("ranmateFemto_cellStateHistory_groupId", groupId)
    /** Index over (measurementTime) (database name ranmateFemto_cellStateHistory_measurementTime) */
    val index3 = index("ranmateFemto_cellStateHistory_measurementTime", measurementTime)
    /** Index over (siteId) (database name ranmateFemto_cellStateHistory_siteId) */
    val index4 = index("ranmateFemto_cellStateHistory_siteId", siteId)
  }
  /** Collection-like TableQuery object for table CellStateHistory */
  lazy val CellStateHistory = new TableQuery(tag => new CellStateHistory(tag))
  
  /** Entity class storing rows of table CellUptime
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param cellState Database column cell_state DBType(INT) */
  case class CellUptimeRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], cellNo: Option[Int], cellState: Option[Int])
  /** GetResult implicit for fetching CellUptimeRow objects using plain SQL queries */
  implicit def GetResultCellUptimeRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[CellUptimeRow] = GR{
    prs => import prs._
    CellUptimeRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table cell_uptime. Objects of this class serve as prototypes for rows in queries. */
  class CellUptime(_tableTag: Tag) extends Table[CellUptimeRow](_tableTag, "cell_uptime") {
    def * = (measurementTime, generation, groupId, siteId, cellNo, cellState) <> (CellUptimeRow.tupled, CellUptimeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, cellNo, cellState).shaped.<>({r=>import r._; _1.map(_=> CellUptimeRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column cell_state DBType(INT) */
    val cellState: Column[Option[Int]] = column[Option[Int]]("cell_state")
    
    /** Index over (cellNo) (database name ranmateFemto_cellUptime_cellNo) */
    val index1 = index("ranmateFemto_cellUptime_cellNo", cellNo)
    /** Index over (cellState) (database name ranmateFemto_cellUptime_cellState) */
    val index2 = index("ranmateFemto_cellUptime_cellState", cellState)
    /** Index over (generation) (database name ranmateFemto_cellUptime_generation) */
    val index3 = index("ranmateFemto_cellUptime_generation", generation)
    /** Index over (groupId) (database name ranmateFemto_cellUptime_groupId) */
    val index4 = index("ranmateFemto_cellUptime_groupId", groupId)
    /** Index over (measurementTime) (database name ranmateFemto_cellUptime_measurementTime) */
    val index5 = index("ranmateFemto_cellUptime_measurementTime", measurementTime)
    /** Index over (siteId) (database name ranmateFemto_cellUptime_siteId) */
    val index6 = index("ranmateFemto_cellUptime_siteId", siteId)
  }
  /** Collection-like TableQuery object for table CellUptime */
  lazy val CellUptime = new TableQuery(tag => new CellUptime(tag))
  
  /** Entity class storing rows of table CustomerConfig
   *  @param sitefapno Database column SiteFAPNo DBType(INT)
   *  @param floorno Database column FloorNo DBType(VARCHAR), Length(20,true)
   *  @param fapmodel Database column FAPModel DBType(VARCHAR), Length(20,true)
   *  @param imei Database column IMEI DBType(VARCHAR), Length(20,true)
   *  @param sn Database column SN DBType(VARCHAR), Length(20,true)
   *  @param fapmac Database column FAPMAC DBType(VARCHAR), Length(20,true)
   *  @param operator Database column Operator DBType(VARCHAR), Length(20,true)
   *  @param customer Database column Customer DBType(VARCHAR), Length(20,true)
   *  @param site Database column Site DBType(VARCHAR), Length(20,true)
   *  @param siteref Database column SiteRef DBType(VARCHAR), Length(20,true)
   *  @param router Database column Router DBType(VARCHAR), Length(20,true)
   *  @param routerip Database column RouterIP DBType(VARCHAR), Length(16,true)
   *  @param routersn Database column RouterSN DBType(VARCHAR), Length(20,true)
   *  @param switch Database column Switch DBType(VARCHAR), Length(20,true)
   *  @param switchmac Database column SwitchMAC DBType(VARCHAR), Length(20,true)
   *  @param switchip Database column SwitchIP DBType(VARCHAR), Length(16,true)
   *  @param switchportno Database column SwitchPortNo DBType(VARCHAR), Length(10,true) */
  case class CustomerConfigRow(sitefapno: Option[Int], floorno: Option[String], fapmodel: Option[String], imei: Option[String], sn: Option[String], fapmac: Option[String], operator: Option[String], customer: Option[String], site: Option[String], siteref: Option[String], router: Option[String], routerip: Option[String], routersn: Option[String], switch: Option[String], switchmac: Option[String], switchip: Option[String], switchportno: Option[String])
  /** GetResult implicit for fetching CustomerConfigRow objects using plain SQL queries */
  implicit def GetResultCustomerConfigRow(implicit e0: GR[Option[Int]], e1: GR[Option[String]]): GR[CustomerConfigRow] = GR{
    prs => import prs._
    CustomerConfigRow.tupled((<<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table customer_config. Objects of this class serve as prototypes for rows in queries. */
  class CustomerConfig(_tableTag: Tag) extends Table[CustomerConfigRow](_tableTag, "customer_config") {
    def * = (sitefapno, floorno, fapmodel, imei, sn, fapmac, operator, customer, site, siteref, router, routerip, routersn, switch, switchmac, switchip, switchportno) <> (CustomerConfigRow.tupled, CustomerConfigRow.unapply)
    
    /** Database column SiteFAPNo DBType(INT) */
    val sitefapno: Column[Option[Int]] = column[Option[Int]]("SiteFAPNo")
    /** Database column FloorNo DBType(VARCHAR), Length(20,true) */
    val floorno: Column[Option[String]] = column[Option[String]]("FloorNo", O.Length(20,varying=true))
    /** Database column FAPModel DBType(VARCHAR), Length(20,true) */
    val fapmodel: Column[Option[String]] = column[Option[String]]("FAPModel", O.Length(20,varying=true))
    /** Database column IMEI DBType(VARCHAR), Length(20,true) */
    val imei: Column[Option[String]] = column[Option[String]]("IMEI", O.Length(20,varying=true))
    /** Database column SN DBType(VARCHAR), Length(20,true) */
    val sn: Column[Option[String]] = column[Option[String]]("SN", O.Length(20,varying=true))
    /** Database column FAPMAC DBType(VARCHAR), Length(20,true) */
    val fapmac: Column[Option[String]] = column[Option[String]]("FAPMAC", O.Length(20,varying=true))
    /** Database column Operator DBType(VARCHAR), Length(20,true) */
    val operator: Column[Option[String]] = column[Option[String]]("Operator", O.Length(20,varying=true))
    /** Database column Customer DBType(VARCHAR), Length(20,true) */
    val customer: Column[Option[String]] = column[Option[String]]("Customer", O.Length(20,varying=true))
    /** Database column Site DBType(VARCHAR), Length(20,true) */
    val site: Column[Option[String]] = column[Option[String]]("Site", O.Length(20,varying=true))
    /** Database column SiteRef DBType(VARCHAR), Length(20,true) */
    val siteref: Column[Option[String]] = column[Option[String]]("SiteRef", O.Length(20,varying=true))
    /** Database column Router DBType(VARCHAR), Length(20,true) */
    val router: Column[Option[String]] = column[Option[String]]("Router", O.Length(20,varying=true))
    /** Database column RouterIP DBType(VARCHAR), Length(16,true) */
    val routerip: Column[Option[String]] = column[Option[String]]("RouterIP", O.Length(16,varying=true))
    /** Database column RouterSN DBType(VARCHAR), Length(20,true) */
    val routersn: Column[Option[String]] = column[Option[String]]("RouterSN", O.Length(20,varying=true))
    /** Database column Switch DBType(VARCHAR), Length(20,true) */
    val switch: Column[Option[String]] = column[Option[String]]("Switch", O.Length(20,varying=true))
    /** Database column SwitchMAC DBType(VARCHAR), Length(20,true) */
    val switchmac: Column[Option[String]] = column[Option[String]]("SwitchMAC", O.Length(20,varying=true))
    /** Database column SwitchIP DBType(VARCHAR), Length(16,true) */
    val switchip: Column[Option[String]] = column[Option[String]]("SwitchIP", O.Length(16,varying=true))
    /** Database column SwitchPortNo DBType(VARCHAR), Length(10,true) */
    val switchportno: Column[Option[String]] = column[Option[String]]("SwitchPortNo", O.Length(10,varying=true))
  }
  /** Collection-like TableQuery object for table CustomerConfig */
  lazy val CustomerConfig = new TableQuery(tag => new CustomerConfig(tag))
  
  /** Entity class storing rows of table CustomerConfigStaging
   *  @param sitefapno Database column SiteFAPNo DBType(INT)
   *  @param floorno Database column FloorNo DBType(VARCHAR), Length(20,true)
   *  @param fapmodel Database column FAPModel DBType(VARCHAR), Length(20,true)
   *  @param imei Database column IMEI DBType(VARCHAR), Length(20,true)
   *  @param sn Database column SN DBType(VARCHAR), Length(20,true)
   *  @param fapmac Database column FAPMAC DBType(VARCHAR), Length(20,true)
   *  @param operator Database column Operator DBType(VARCHAR), Length(20,true)
   *  @param customer Database column Customer DBType(VARCHAR), Length(20,true)
   *  @param site Database column Site DBType(VARCHAR), Length(20,true)
   *  @param siteref Database column SiteRef DBType(VARCHAR), Length(20,true)
   *  @param router Database column Router DBType(VARCHAR), Length(20,true)
   *  @param routerip Database column RouterIP DBType(VARCHAR), Length(16,true)
   *  @param routersn Database column RouterSN DBType(VARCHAR), Length(20,true)
   *  @param switch Database column Switch DBType(VARCHAR), Length(20,true)
   *  @param switchmac Database column SwitchMAC DBType(VARCHAR), Length(20,true)
   *  @param switchip Database column SwitchIP DBType(VARCHAR), Length(16,true)
   *  @param switchportno Database column SwitchPortNo DBType(VARCHAR), Length(10,true) */
  case class CustomerConfigStagingRow(sitefapno: Option[Int], floorno: Option[String], fapmodel: Option[String], imei: Option[String], sn: Option[String], fapmac: Option[String], operator: Option[String], customer: Option[String], site: Option[String], siteref: Option[String], router: Option[String], routerip: Option[String], routersn: Option[String], switch: Option[String], switchmac: Option[String], switchip: Option[String], switchportno: Option[String])
  /** GetResult implicit for fetching CustomerConfigStagingRow objects using plain SQL queries */
  implicit def GetResultCustomerConfigStagingRow(implicit e0: GR[Option[Int]], e1: GR[Option[String]]): GR[CustomerConfigStagingRow] = GR{
    prs => import prs._
    CustomerConfigStagingRow.tupled((<<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table customer_config_staging. Objects of this class serve as prototypes for rows in queries. */
  class CustomerConfigStaging(_tableTag: Tag) extends Table[CustomerConfigStagingRow](_tableTag, "customer_config_staging") {
    def * = (sitefapno, floorno, fapmodel, imei, sn, fapmac, operator, customer, site, siteref, router, routerip, routersn, switch, switchmac, switchip, switchportno) <> (CustomerConfigStagingRow.tupled, CustomerConfigStagingRow.unapply)
    
    /** Database column SiteFAPNo DBType(INT) */
    val sitefapno: Column[Option[Int]] = column[Option[Int]]("SiteFAPNo")
    /** Database column FloorNo DBType(VARCHAR), Length(20,true) */
    val floorno: Column[Option[String]] = column[Option[String]]("FloorNo", O.Length(20,varying=true))
    /** Database column FAPModel DBType(VARCHAR), Length(20,true) */
    val fapmodel: Column[Option[String]] = column[Option[String]]("FAPModel", O.Length(20,varying=true))
    /** Database column IMEI DBType(VARCHAR), Length(20,true) */
    val imei: Column[Option[String]] = column[Option[String]]("IMEI", O.Length(20,varying=true))
    /** Database column SN DBType(VARCHAR), Length(20,true) */
    val sn: Column[Option[String]] = column[Option[String]]("SN", O.Length(20,varying=true))
    /** Database column FAPMAC DBType(VARCHAR), Length(20,true) */
    val fapmac: Column[Option[String]] = column[Option[String]]("FAPMAC", O.Length(20,varying=true))
    /** Database column Operator DBType(VARCHAR), Length(20,true) */
    val operator: Column[Option[String]] = column[Option[String]]("Operator", O.Length(20,varying=true))
    /** Database column Customer DBType(VARCHAR), Length(20,true) */
    val customer: Column[Option[String]] = column[Option[String]]("Customer", O.Length(20,varying=true))
    /** Database column Site DBType(VARCHAR), Length(20,true) */
    val site: Column[Option[String]] = column[Option[String]]("Site", O.Length(20,varying=true))
    /** Database column SiteRef DBType(VARCHAR), Length(20,true) */
    val siteref: Column[Option[String]] = column[Option[String]]("SiteRef", O.Length(20,varying=true))
    /** Database column Router DBType(VARCHAR), Length(20,true) */
    val router: Column[Option[String]] = column[Option[String]]("Router", O.Length(20,varying=true))
    /** Database column RouterIP DBType(VARCHAR), Length(16,true) */
    val routerip: Column[Option[String]] = column[Option[String]]("RouterIP", O.Length(16,varying=true))
    /** Database column RouterSN DBType(VARCHAR), Length(20,true) */
    val routersn: Column[Option[String]] = column[Option[String]]("RouterSN", O.Length(20,varying=true))
    /** Database column Switch DBType(VARCHAR), Length(20,true) */
    val switch: Column[Option[String]] = column[Option[String]]("Switch", O.Length(20,varying=true))
    /** Database column SwitchMAC DBType(VARCHAR), Length(20,true) */
    val switchmac: Column[Option[String]] = column[Option[String]]("SwitchMAC", O.Length(20,varying=true))
    /** Database column SwitchIP DBType(VARCHAR), Length(16,true) */
    val switchip: Column[Option[String]] = column[Option[String]]("SwitchIP", O.Length(16,varying=true))
    /** Database column SwitchPortNo DBType(VARCHAR), Length(10,true) */
    val switchportno: Column[Option[String]] = column[Option[String]]("SwitchPortNo", O.Length(10,varying=true))
  }
  /** Collection-like TableQuery object for table CustomerConfigStaging */
  lazy val CustomerConfigStaging = new TableQuery(tag => new CustomerConfigStaging(tag))
  
  /** Entity class storing rows of table Events
   *  @param eventId Database column event_id DBType(INT), AutoInc, PrimaryKey
   *  @param eventTimestamp Database column event_timestamp DBType(TIMESTAMP)
   *  @param username Database column username DBType(VARCHAR), Length(256,true)
   *  @param entity Database column entity DBType(VARCHAR), Length(256,true)
   *  @param action Database column action DBType(VARCHAR), Length(256,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param generation Database column generation DBType(INT)
   *  @param information Database column information DBType(VARCHAR), Length(256,true) */
  case class EventsRow(eventId: Int, eventTimestamp: java.sql.Timestamp, username: Option[String], entity: String, action: String, groupId: Option[String], siteId: Option[String], cellNo: Option[Int], generation: Option[Int], information: Option[String])
  /** GetResult implicit for fetching EventsRow objects using plain SQL queries */
  implicit def GetResultEventsRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp], e2: GR[Option[String]], e3: GR[String], e4: GR[Option[Int]]): GR[EventsRow] = GR{
    prs => import prs._
    EventsRow.tupled((<<[Int], <<[java.sql.Timestamp], <<?[String], <<[String], <<[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table events. Objects of this class serve as prototypes for rows in queries. */
  class Events(_tableTag: Tag) extends Table[EventsRow](_tableTag, "events") {
    def * = (eventId, eventTimestamp, username, entity, action, groupId, siteId, cellNo, generation, information) <> (EventsRow.tupled, EventsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (eventId.?, eventTimestamp.?, username, entity.?, action.?, groupId, siteId, cellNo, generation, information).shaped.<>({r=>import r._; _1.map(_=> EventsRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column event_id DBType(INT), AutoInc, PrimaryKey */
    val eventId: Column[Int] = column[Int]("event_id", O.AutoInc, O.PrimaryKey)
    /** Database column event_timestamp DBType(TIMESTAMP) */
    val eventTimestamp: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("event_timestamp")
    /** Database column username DBType(VARCHAR), Length(256,true) */
    val username: Column[Option[String]] = column[Option[String]]("username", O.Length(256,varying=true))
    /** Database column entity DBType(VARCHAR), Length(256,true) */
    val entity: Column[String] = column[String]("entity", O.Length(256,varying=true))
    /** Database column action DBType(VARCHAR), Length(256,true) */
    val action: Column[String] = column[String]("action", O.Length(256,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column information DBType(VARCHAR), Length(256,true) */
    val information: Column[Option[String]] = column[Option[String]]("information", O.Length(256,varying=true))
  }
  /** Collection-like TableQuery object for table Events */
  lazy val Events = new TableQuery(tag => new Events(tag))
  
  /** Entity class storing rows of table Groups
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param groupName Database column group_name DBType(VARCHAR), Length(256,true)
   *  @param enabled Database column enabled DBType(BIT) */
  case class GroupsRow(groupId: String, groupName: String, enabled: Boolean)
  /** GetResult implicit for fetching GroupsRow objects using plain SQL queries */
  implicit def GetResultGroupsRow(implicit e0: GR[String], e1: GR[Boolean]): GR[GroupsRow] = GR{
    prs => import prs._
    GroupsRow.tupled((<<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table groups. Objects of this class serve as prototypes for rows in queries. */
  class Groups(_tableTag: Tag) extends Table[GroupsRow](_tableTag, "groups") {
    def * = (groupId, groupName, enabled) <> (GroupsRow.tupled, GroupsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, groupName.?, enabled.?).shaped.<>({r=>import r._; _1.map(_=> GroupsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column group_name DBType(VARCHAR), Length(256,true) */
    val groupName: Column[String] = column[String]("group_name", O.Length(256,varying=true))
    /** Database column enabled DBType(BIT) */
    val enabled: Column[Boolean] = column[Boolean]("enabled")
  }
  /** Collection-like TableQuery object for table Groups */
  lazy val Groups = new TableQuery(tag => new Groups(tag))
  
  /** Entity class storing rows of table ImportedCells
   *  @param cellId Database column cell_id DBType(VARCHAR), Length(20,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param generation Database column generation DBType(INT)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param exist Database column exist DBType(BIT)
   *  @param exclude Database column exclude DBType(BIT) */
  case class ImportedCellsRow(cellId: String, siteId: String, groupId: String, generation: Option[Int], cellNo: Option[Int], exist: Option[Boolean], exclude: Option[Boolean])
  /** GetResult implicit for fetching ImportedCellsRow objects using plain SQL queries */
  implicit def GetResultImportedCellsRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[Boolean]]): GR[ImportedCellsRow] = GR{
    prs => import prs._
    ImportedCellsRow.tupled((<<[String], <<[String], <<[String], <<?[Int], <<?[Int], <<?[Boolean], <<?[Boolean]))
  }
  /** Table description of table imported_cells. Objects of this class serve as prototypes for rows in queries. */
  class ImportedCells(_tableTag: Tag) extends Table[ImportedCellsRow](_tableTag, "imported_cells") {
    def * = (cellId, siteId, groupId, generation, cellNo, exist, exclude) <> (ImportedCellsRow.tupled, ImportedCellsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (cellId.?, siteId.?, groupId.?, generation, cellNo, exist, exclude).shaped.<>({r=>import r._; _1.map(_=> ImportedCellsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column cell_id DBType(VARCHAR), Length(20,true) */
    val cellId: Column[String] = column[String]("cell_id", O.Length(20,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column exist DBType(BIT) */
    val exist: Column[Option[Boolean]] = column[Option[Boolean]]("exist")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Option[Boolean]] = column[Option[Boolean]]("exclude")
  }
  /** Collection-like TableQuery object for table ImportedCells */
  lazy val ImportedCells = new TableQuery(tag => new ImportedCells(tag))
  
  /** Entity class storing rows of table ImportedNodes
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param generation Database column generation DBType(INT) */
  case class ImportedNodesRow(nodeId: Option[String], generation: Int)
  /** GetResult implicit for fetching ImportedNodesRow objects using plain SQL queries */
  implicit def GetResultImportedNodesRow(implicit e0: GR[Option[String]], e1: GR[Int]): GR[ImportedNodesRow] = GR{
    prs => import prs._
    ImportedNodesRow.tupled((<<?[String], <<[Int]))
  }
  /** Table description of table imported_nodes. Objects of this class serve as prototypes for rows in queries. */
  class ImportedNodes(_tableTag: Tag) extends Table[ImportedNodesRow](_tableTag, "imported_nodes") {
    def * = (nodeId, generation) <> (ImportedNodesRow.tupled, ImportedNodesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (nodeId, generation.?).shaped.<>({r=>import r._; _2.map(_=> ImportedNodesRow.tupled((_1, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
  }
  /** Collection-like TableQuery object for table ImportedNodes */
  lazy val ImportedNodes = new TableQuery(tag => new ImportedNodes(tag))
  
  /** Entity class storing rows of table ImportedSites
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param generation Database column generation DBType(INT)
   *  @param exclude Database column exclude DBType(BIT)
   *  @param priority Database column priority DBType(INT)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true) */
  case class ImportedSitesRow(siteId: String, nodeId: Option[String], groupId: Option[String], generation: Int, exclude: Option[Boolean], priority: Option[Int], vendorId: Option[String])
  /** GetResult implicit for fetching ImportedSitesRow objects using plain SQL queries */
  implicit def GetResultImportedSitesRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Int], e3: GR[Option[Boolean]], e4: GR[Option[Int]]): GR[ImportedSitesRow] = GR{
    prs => import prs._
    ImportedSitesRow.tupled((<<[String], <<?[String], <<?[String], <<[Int], <<?[Boolean], <<?[Int], <<?[String]))
  }
  /** Table description of table imported_sites. Objects of this class serve as prototypes for rows in queries. */
  class ImportedSites(_tableTag: Tag) extends Table[ImportedSitesRow](_tableTag, "imported_sites") {
    def * = (siteId, nodeId, groupId, generation, exclude, priority, vendorId) <> (ImportedSitesRow.tupled, ImportedSitesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (siteId.?, nodeId, groupId, generation.?, exclude, priority, vendorId).shaped.<>({r=>import r._; _1.map(_=> ImportedSitesRow.tupled((_1.get, _2, _3, _4.get, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Option[Boolean]] = column[Option[Boolean]]("exclude")
    /** Database column priority DBType(INT) */
    val priority: Column[Option[Int]] = column[Option[Int]]("priority")
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
  }
  /** Collection-like TableQuery object for table ImportedSites */
  lazy val ImportedSites = new TableQuery(tag => new ImportedSites(tag))
  
  /** Entity class storing rows of table Majoralerts
   *  @param eventTimestamp Database column event_timestamp DBType(TIMESTAMP)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param generation Database column generation DBType(SMALLINT) */
  case class MajoralertsRow(eventTimestamp: java.sql.Timestamp, groupId: Option[String], generation: Option[Short])
  /** GetResult implicit for fetching MajoralertsRow objects using plain SQL queries */
  implicit def GetResultMajoralertsRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Short]]): GR[MajoralertsRow] = GR{
    prs => import prs._
    MajoralertsRow.tupled((<<[java.sql.Timestamp], <<?[String], <<?[Short]))
  }
  /** Table description of table MajorAlerts. Objects of this class serve as prototypes for rows in queries. */
  class Majoralerts(_tableTag: Tag) extends Table[MajoralertsRow](_tableTag, "MajorAlerts") {
    def * = (eventTimestamp, groupId, generation) <> (MajoralertsRow.tupled, MajoralertsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (eventTimestamp.?, groupId, generation).shaped.<>({r=>import r._; _1.map(_=> MajoralertsRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column event_timestamp DBType(TIMESTAMP) */
    val eventTimestamp: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("event_timestamp")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column generation DBType(SMALLINT) */
    val generation: Column[Option[Short]] = column[Option[Short]]("generation")
  }
  /** Collection-like TableQuery object for table Majoralerts */
  lazy val Majoralerts = new TableQuery(tag => new Majoralerts(tag))
  
  /** Entity class storing rows of table MCellDowntime
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param downtime Database column downtime DBType(TIME) */
  case class MCellDowntimeRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], cellNo: Option[Int], downtime: Option[java.sql.Time])
  /** GetResult implicit for fetching MCellDowntimeRow objects using plain SQL queries */
  implicit def GetResultMCellDowntimeRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[java.sql.Time]]): GR[MCellDowntimeRow] = GR{
    prs => import prs._
    MCellDowntimeRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[java.sql.Time]))
  }
  /** Table description of table m_cell_downtime. Objects of this class serve as prototypes for rows in queries. */
  class MCellDowntime(_tableTag: Tag) extends Table[MCellDowntimeRow](_tableTag, "m_cell_downtime") {
    def * = (measurementTime, generation, groupId, siteId, cellNo, downtime) <> (MCellDowntimeRow.tupled, MCellDowntimeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, cellNo, downtime).shaped.<>({r=>import r._; _1.map(_=> MCellDowntimeRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column downtime DBType(TIME) */
    val downtime: Column[Option[java.sql.Time]] = column[Option[java.sql.Time]]("downtime")
    
    /** Index over (cellNo) (database name ranmateFemto_mCellDowntime_cellNo) */
    val index1 = index("ranmateFemto_mCellDowntime_cellNo", cellNo)
    /** Index over (downtime) (database name ranmateFemto_mCellDowntime_downtime) */
    val index2 = index("ranmateFemto_mCellDowntime_downtime", downtime)
    /** Index over (generation) (database name ranmateFemto_mCellDowntime_generation) */
    val index3 = index("ranmateFemto_mCellDowntime_generation", generation)
    /** Index over (groupId) (database name ranmateFemto_mCellDowntime_groupId) */
    val index4 = index("ranmateFemto_mCellDowntime_groupId", groupId)
    /** Index over (measurementTime) (database name ranmateFemto_mCellDowntime_measurementTime) */
    val index5 = index("ranmateFemto_mCellDowntime_measurementTime", measurementTime)
    /** Index over (siteId) (database name ranmateFemto_mCellDowntime_siteId) */
    val index6 = index("ranmateFemto_mCellDowntime_siteId", siteId)
  }
  /** Collection-like TableQuery object for table MCellDowntime */
  lazy val MCellDowntime = new TableQuery(tag => new MCellDowntime(tag))
  
  /** Entity class storing rows of table MCellState
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param priority Database column priority DBType(INT)
   *  @param siteExclude Database column site_exclude DBType(BIT)
   *  @param siteSticky Database column site_sticky DBType(BIT)
   *  @param sectorNo Database column sector_no DBType(INT)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param cellExist Database column cell_exist DBType(BIT)
   *  @param cellExclude Database column cell_exclude DBType(BIT)
   *  @param cellSticky Database column cell_sticky DBType(BIT)
   *  @param cellState Database column cell_state DBType(INT) */
  case class MCellStateRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], nodeId: Option[String], siteId: Option[String], vendorId: Option[String], priority: Option[Int], siteExclude: Option[Boolean], siteSticky: Option[Boolean], sectorNo: Option[Int], cellNo: Option[Int], cellExist: Option[Boolean], cellExclude: Option[Boolean], cellSticky: Option[Boolean], cellState: Option[Int])
  /** GetResult implicit for fetching MCellStateRow objects using plain SQL queries */
  implicit def GetResultMCellStateRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]]): GR[MCellStateRow] = GR{
    prs => import prs._
    MCellStateRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Boolean], <<?[Boolean], <<?[Int], <<?[Int], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Int]))
  }
  /** Table description of table m_cell_state. Objects of this class serve as prototypes for rows in queries. */
  class MCellState(_tableTag: Tag) extends Table[MCellStateRow](_tableTag, "m_cell_state") {
    def * = (measurementTime, generation, groupId, nodeId, siteId, vendorId, priority, siteExclude, siteSticky, sectorNo, cellNo, cellExist, cellExclude, cellSticky, cellState) <> (MCellStateRow.tupled, MCellStateRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, nodeId, siteId, vendorId, priority, siteExclude, siteSticky, sectorNo, cellNo, cellExist, cellExclude, cellSticky, cellState).shaped.<>({r=>import r._; _1.map(_=> MCellStateRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column priority DBType(INT) */
    val priority: Column[Option[Int]] = column[Option[Int]]("priority")
    /** Database column site_exclude DBType(BIT) */
    val siteExclude: Column[Option[Boolean]] = column[Option[Boolean]]("site_exclude")
    /** Database column site_sticky DBType(BIT) */
    val siteSticky: Column[Option[Boolean]] = column[Option[Boolean]]("site_sticky")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column cell_exist DBType(BIT) */
    val cellExist: Column[Option[Boolean]] = column[Option[Boolean]]("cell_exist")
    /** Database column cell_exclude DBType(BIT) */
    val cellExclude: Column[Option[Boolean]] = column[Option[Boolean]]("cell_exclude")
    /** Database column cell_sticky DBType(BIT) */
    val cellSticky: Column[Option[Boolean]] = column[Option[Boolean]]("cell_sticky")
    /** Database column cell_state DBType(INT) */
    val cellState: Column[Option[Int]] = column[Option[Int]]("cell_state")
    
    /** Index over (cellExclude) (database name ranmateFemto_mCellState_cellExclude) */
    val index1 = index("ranmateFemto_mCellState_cellExclude", cellExclude)
    /** Index over (cellExist) (database name ranmateFemto_mCellState_cellExist) */
    val index2 = index("ranmateFemto_mCellState_cellExist", cellExist)
    /** Index over (cellNo) (database name ranmateFemto_mCellState_cellNo) */
    val index3 = index("ranmateFemto_mCellState_cellNo", cellNo)
    /** Index over (cellState) (database name ranmateFemto_mCellState_cellState) */
    val index4 = index("ranmateFemto_mCellState_cellState", cellState)
    /** Index over (generation) (database name ranmateFemto_mCellState_generation) */
    val index5 = index("ranmateFemto_mCellState_generation", generation)
    /** Index over (groupId) (database name ranmateFemto_mCellState_groupId) */
    val index6 = index("ranmateFemto_mCellState_groupId", groupId)
    /** Index over (measurementTime) (database name ranmateFemto_mCellState_measurementTime) */
    val index7 = index("ranmateFemto_mCellState_measurementTime", measurementTime)
    /** Index over (sectorNo) (database name ranmateFemto_mCellState_sectorNo) */
    val index8 = index("ranmateFemto_mCellState_sectorNo", sectorNo)
    /** Index over (siteId) (database name ranmateFemto_mCellState_siteId) */
    val index9 = index("ranmateFemto_mCellState_siteId", siteId)
  }
  /** Collection-like TableQuery object for table MCellState */
  lazy val MCellState = new TableQuery(tag => new MCellState(tag))
  
  /** Entity class storing rows of table MeasurementRepeats
   *  @param measurementPeriod Database column measurement_period DBType(INT)
   *  @param timeOffset Database column time_offset DBType(INT) */
  case class MeasurementRepeatsRow(measurementPeriod: Int, timeOffset: Int)
  /** GetResult implicit for fetching MeasurementRepeatsRow objects using plain SQL queries */
  implicit def GetResultMeasurementRepeatsRow(implicit e0: GR[Int]): GR[MeasurementRepeatsRow] = GR{
    prs => import prs._
    MeasurementRepeatsRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table measurement_repeats. Objects of this class serve as prototypes for rows in queries. */
  class MeasurementRepeats(_tableTag: Tag) extends Table[MeasurementRepeatsRow](_tableTag, "measurement_repeats") {
    def * = (measurementPeriod, timeOffset) <> (MeasurementRepeatsRow.tupled, MeasurementRepeatsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementPeriod.?, timeOffset.?).shaped.<>({r=>import r._; _1.map(_=> MeasurementRepeatsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_period DBType(INT) */
    val measurementPeriod: Column[Int] = column[Int]("measurement_period")
    /** Database column time_offset DBType(INT) */
    val timeOffset: Column[Int] = column[Int]("time_offset")
  }
  /** Collection-like TableQuery object for table MeasurementRepeats */
  lazy val MeasurementRepeats = new TableQuery(tag => new MeasurementRepeats(tag))
  
  /** Row type of table MSiteOperatorHour */
  type MSiteOperatorHourRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for MSiteOperatorHourRow providing default values if available in the database schema. */
  def MSiteOperatorHourRow(measurementTime: java.sql.Timestamp, groupId: Option[String], siteId: Option[String], unknownCellsAll: Option[Long], knownCellsAll: Option[Long], blockedCellsAll: Option[Long], downCellsAll: Option[Long], upCellsAll: Option[Long], cisKpiAll: Option[scala.math.BigDecimal], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long], cisKpi4g: Option[scala.math.BigDecimal], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], cisKpi3g: Option[scala.math.BigDecimal], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], cisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): MSiteOperatorHourRow = {
    measurementTime :: groupId :: siteId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching MSiteOperatorHourRow objects using plain SQL queries */
  implicit def GetResultMSiteOperatorHourRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[MSiteOperatorHourRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table m_site_operator_hour. Objects of this class serve as prototypes for rows in queries. */
  class MSiteOperatorHour(_tableTag: Tag) extends Table[MSiteOperatorHourRow](_tableTag, "m_site_operator_hour") {
    def * = measurementTime :: groupId :: siteId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column unknown_cells_all DBType(BIGINT) */
    val unknownCellsAll: Column[Option[Long]] = column[Option[Long]]("unknown_cells_all")
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column up_cells_all DBType(BIGINT) */
    val upCellsAll: Column[Option[Long]] = column[Option[Long]]("up_cells_all")
    /** Database column cis_kpi_all DBType(DECIMAL) */
    val cisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_all")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table MSiteOperatorHour */
  lazy val MSiteOperatorHour = new TableQuery(tag => new MSiteOperatorHour(tag))
  
  /** Entity class storing rows of table MSiteServiceCounters
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param excludeSite Database column exclude_site DBType(BIT)
   *  @param existCells Database column exist_cells DBType(INT)
   *  @param excludeCells Database column exclude_cells DBType(INT)
   *  @param includeCells Database column include_cells DBType(INT)
   *  @param unknownCells Database column unknown_cells DBType(INT)
   *  @param knownCells Database column known_cells DBType(INT)
   *  @param blockedCells Database column blocked_cells DBType(INT)
   *  @param downCells Database column down_cells DBType(INT)
   *  @param upCells Database column up_cells DBType(INT) */
  case class MSiteServiceCountersRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], vendorId: Option[String], excludeSite: Option[Boolean], existCells: Option[Int], excludeCells: Option[Int], includeCells: Option[Int], unknownCells: Option[Int], knownCells: Option[Int], blockedCells: Option[Int], downCells: Option[Int], upCells: Option[Int])
  /** GetResult implicit for fetching MSiteServiceCountersRow objects using plain SQL queries */
  implicit def GetResultMSiteServiceCountersRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]]): GR[MSiteServiceCountersRow] = GR{
    prs => import prs._
    MSiteServiceCountersRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Boolean], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table m_site_service_counters. Objects of this class serve as prototypes for rows in queries. */
  class MSiteServiceCounters(_tableTag: Tag) extends Table[MSiteServiceCountersRow](_tableTag, "m_site_service_counters") {
    def * = (measurementTime, generation, groupId, siteId, vendorId, excludeSite, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells) <> (MSiteServiceCountersRow.tupled, MSiteServiceCountersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, vendorId, excludeSite, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells).shaped.<>({r=>import r._; _1.map(_=> MSiteServiceCountersRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column exclude_site DBType(BIT) */
    val excludeSite: Column[Option[Boolean]] = column[Option[Boolean]]("exclude_site")
    /** Database column exist_cells DBType(INT) */
    val existCells: Column[Option[Int]] = column[Option[Int]]("exist_cells")
    /** Database column exclude_cells DBType(INT) */
    val excludeCells: Column[Option[Int]] = column[Option[Int]]("exclude_cells")
    /** Database column include_cells DBType(INT) */
    val includeCells: Column[Option[Int]] = column[Option[Int]]("include_cells")
    /** Database column unknown_cells DBType(INT) */
    val unknownCells: Column[Option[Int]] = column[Option[Int]]("unknown_cells")
    /** Database column known_cells DBType(INT) */
    val knownCells: Column[Option[Int]] = column[Option[Int]]("known_cells")
    /** Database column blocked_cells DBType(INT) */
    val blockedCells: Column[Option[Int]] = column[Option[Int]]("blocked_cells")
    /** Database column down_cells DBType(INT) */
    val downCells: Column[Option[Int]] = column[Option[Int]]("down_cells")
    /** Database column up_cells DBType(INT) */
    val upCells: Column[Option[Int]] = column[Option[Int]]("up_cells")
    
    /** Index over (excludeCells) (database name ranmateFemto_mSiteServiceCounters_excludeCells) */
    val index1 = index("ranmateFemto_mSiteServiceCounters_excludeCells", excludeCells)
    /** Index over (excludeSite) (database name ranmateFemto_mSiteServiceCounters_excludeSite) */
    val index2 = index("ranmateFemto_mSiteServiceCounters_excludeSite", excludeSite)
    /** Index over (generation) (database name ranmateFemto_mSiteServiceCounters_generation) */
    val index3 = index("ranmateFemto_mSiteServiceCounters_generation", generation)
    /** Index over (groupId) (database name ranmateFemto_mSiteServiceCounters_groupId) */
    val index4 = index("ranmateFemto_mSiteServiceCounters_groupId", groupId)
    /** Index over (measurementTime) (database name ranmateFemto_mSiteServiceCounters_measurementTime) */
    val index5 = index("ranmateFemto_mSiteServiceCounters_measurementTime", measurementTime)
    /** Index over (siteId) (database name ranmateFemto_mSiteServiceCounters_siteId) */
    val index6 = index("ranmateFemto_mSiteServiceCounters_siteId", siteId)
  }
  /** Collection-like TableQuery object for table MSiteServiceCounters */
  lazy val MSiteServiceCounters = new TableQuery(tag => new MSiteServiceCounters(tag))
  
  /** Entity class storing rows of table MSiteServiceDowntime
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param downtime Database column downtime DBType(TIME) */
  case class MSiteServiceDowntimeRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], downtime: Option[java.sql.Time])
  /** GetResult implicit for fetching MSiteServiceDowntimeRow objects using plain SQL queries */
  implicit def GetResultMSiteServiceDowntimeRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[java.sql.Time]]): GR[MSiteServiceDowntimeRow] = GR{
    prs => import prs._
    MSiteServiceDowntimeRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[java.sql.Time]))
  }
  /** Table description of table m_site_service_downtime. Objects of this class serve as prototypes for rows in queries. */
  class MSiteServiceDowntime(_tableTag: Tag) extends Table[MSiteServiceDowntimeRow](_tableTag, "m_site_service_downtime") {
    def * = (measurementTime, generation, groupId, siteId, downtime) <> (MSiteServiceDowntimeRow.tupled, MSiteServiceDowntimeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, downtime).shaped.<>({r=>import r._; _1.map(_=> MSiteServiceDowntimeRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column downtime DBType(TIME) */
    val downtime: Column[Option[java.sql.Time]] = column[Option[java.sql.Time]]("downtime")
    
    /** Index over (downtime) (database name ranmateFemto_mSiteServiceDowntime_downtime) */
    val index1 = index("ranmateFemto_mSiteServiceDowntime_downtime", downtime)
    /** Index over (generation) (database name ranmateFemto_mSiteServiceDowntime_generation) */
    val index2 = index("ranmateFemto_mSiteServiceDowntime_generation", generation)
    /** Index over (groupId) (database name ranmateFemto_mSiteServiceDowntime_groupId) */
    val index3 = index("ranmateFemto_mSiteServiceDowntime_groupId", groupId)
    /** Index over (siteId) (database name ranmateFemto_mSiteServiceDowntime_siteId) */
    val index4 = index("ranmateFemto_mSiteServiceDowntime_siteId", siteId)
    /** Index over (measurementTime) (database name ranmateFemto_mSiteServiceState_measurementTime) */
    val index5 = index("ranmateFemto_mSiteServiceState_measurementTime", measurementTime)
  }
  /** Collection-like TableQuery object for table MSiteServiceDowntime */
  lazy val MSiteServiceDowntime = new TableQuery(tag => new MSiteServiceDowntime(tag))
  
  /** Row type of table MSiteServiceState */
  type MSiteServiceStateRow = HCons[java.sql.Timestamp,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for MSiteServiceStateRow providing default values if available in the database schema. */
  def MSiteServiceStateRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], nodeId: Option[String], siteId: Option[String], vendorId: Option[String], priority: Option[Int], exclude: Option[Boolean], siteSticky: Option[Boolean], cellSticky: Option[Boolean], minSector0State: Option[Int], minSector1State: Option[Int], minSector2State: Option[Int], minSector3State: Option[Int], maxSector0State: Option[Int], maxSector1State: Option[Int], maxSector2State: Option[Int], maxSector3State: Option[Int], cell0State: Option[Int], cell1State: Option[Int], cell2State: Option[Int], cell3State: Option[Int], cell4State: Option[Int], cell5State: Option[Int], cell6State: Option[Int], cell7State: Option[Int], cell8State: Option[Int], cell9State: Option[Int], cell10State: Option[Int], cell11State: Option[Int], cell12State: Option[Int], cell13State: Option[Int], cell14State: Option[Int], cell15State: Option[Int], cell16State: Option[Int], cell17State: Option[Int], cell18State: Option[Int], cell19State: Option[Int], cell20State: Option[Int], cell21State: Option[Int], cell22State: Option[Int], cell23State: Option[Int], cell24State: Option[Int], cell25State: Option[Int], cell26State: Option[Int], cell27State: Option[Int], cell28State: Option[Int], cell29State: Option[Int], cell30State: Option[Int], cell31State: Option[Int], existCells: Option[Int], excludeCells: Option[Int], includeCells: Option[Int], unknownCells: Option[Int], knownCells: Option[Int], blockedCells: Option[Int], downCells: Option[Int], upCells: Option[Int]): MSiteServiceStateRow = {
    measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: priority :: exclude :: siteSticky :: cellSticky :: minSector0State :: minSector1State :: minSector2State :: minSector3State :: maxSector0State :: maxSector1State :: maxSector2State :: maxSector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: existCells :: excludeCells :: includeCells :: unknownCells :: knownCells :: blockedCells :: downCells :: upCells :: HNil
  }
  /** GetResult implicit for fetching MSiteServiceStateRow objects using plain SQL queries */
  implicit def GetResultMSiteServiceStateRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]]): GR[MSiteServiceStateRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: HNil
  }
  /** Table description of table m_site_service_state. Objects of this class serve as prototypes for rows in queries. */
  class MSiteServiceState(_tableTag: Tag) extends Table[MSiteServiceStateRow](_tableTag, "m_site_service_state") {
    def * = measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: priority :: exclude :: siteSticky :: cellSticky :: minSector0State :: minSector1State :: minSector2State :: minSector3State :: maxSector0State :: maxSector1State :: maxSector2State :: maxSector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: existCells :: excludeCells :: includeCells :: unknownCells :: knownCells :: blockedCells :: downCells :: upCells :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column priority DBType(INT) */
    val priority: Column[Option[Int]] = column[Option[Int]]("priority")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Option[Boolean]] = column[Option[Boolean]]("exclude")
    /** Database column site_sticky DBType(BIT) */
    val siteSticky: Column[Option[Boolean]] = column[Option[Boolean]]("site_sticky")
    /** Database column cell_sticky DBType(BIT) */
    val cellSticky: Column[Option[Boolean]] = column[Option[Boolean]]("cell_sticky")
    /** Database column min_sector_0_state DBType(INT) */
    val minSector0State: Column[Option[Int]] = column[Option[Int]]("min_sector_0_state")
    /** Database column min_sector_1_state DBType(INT) */
    val minSector1State: Column[Option[Int]] = column[Option[Int]]("min_sector_1_state")
    /** Database column min_sector_2_state DBType(INT) */
    val minSector2State: Column[Option[Int]] = column[Option[Int]]("min_sector_2_state")
    /** Database column min_sector_3_state DBType(INT) */
    val minSector3State: Column[Option[Int]] = column[Option[Int]]("min_sector_3_state")
    /** Database column max_sector_0_state DBType(INT) */
    val maxSector0State: Column[Option[Int]] = column[Option[Int]]("max_sector_0_state")
    /** Database column max_sector_1_state DBType(INT) */
    val maxSector1State: Column[Option[Int]] = column[Option[Int]]("max_sector_1_state")
    /** Database column max_sector_2_state DBType(INT) */
    val maxSector2State: Column[Option[Int]] = column[Option[Int]]("max_sector_2_state")
    /** Database column max_sector_3_state DBType(INT) */
    val maxSector3State: Column[Option[Int]] = column[Option[Int]]("max_sector_3_state")
    /** Database column cell_0_state DBType(INT) */
    val cell0State: Column[Option[Int]] = column[Option[Int]]("cell_0_state")
    /** Database column cell_1_state DBType(INT) */
    val cell1State: Column[Option[Int]] = column[Option[Int]]("cell_1_state")
    /** Database column cell_2_state DBType(INT) */
    val cell2State: Column[Option[Int]] = column[Option[Int]]("cell_2_state")
    /** Database column cell_3_state DBType(INT) */
    val cell3State: Column[Option[Int]] = column[Option[Int]]("cell_3_state")
    /** Database column cell_4_state DBType(INT) */
    val cell4State: Column[Option[Int]] = column[Option[Int]]("cell_4_state")
    /** Database column cell_5_state DBType(INT) */
    val cell5State: Column[Option[Int]] = column[Option[Int]]("cell_5_state")
    /** Database column cell_6_state DBType(INT) */
    val cell6State: Column[Option[Int]] = column[Option[Int]]("cell_6_state")
    /** Database column cell_7_state DBType(INT) */
    val cell7State: Column[Option[Int]] = column[Option[Int]]("cell_7_state")
    /** Database column cell_8_state DBType(INT) */
    val cell8State: Column[Option[Int]] = column[Option[Int]]("cell_8_state")
    /** Database column cell_9_state DBType(INT) */
    val cell9State: Column[Option[Int]] = column[Option[Int]]("cell_9_state")
    /** Database column cell_10_state DBType(INT) */
    val cell10State: Column[Option[Int]] = column[Option[Int]]("cell_10_state")
    /** Database column cell_11_state DBType(INT) */
    val cell11State: Column[Option[Int]] = column[Option[Int]]("cell_11_state")
    /** Database column cell_12_state DBType(INT) */
    val cell12State: Column[Option[Int]] = column[Option[Int]]("cell_12_state")
    /** Database column cell_13_state DBType(INT) */
    val cell13State: Column[Option[Int]] = column[Option[Int]]("cell_13_state")
    /** Database column cell_14_state DBType(INT) */
    val cell14State: Column[Option[Int]] = column[Option[Int]]("cell_14_state")
    /** Database column cell_15_state DBType(INT) */
    val cell15State: Column[Option[Int]] = column[Option[Int]]("cell_15_state")
    /** Database column cell_16_state DBType(INT) */
    val cell16State: Column[Option[Int]] = column[Option[Int]]("cell_16_state")
    /** Database column cell_17_state DBType(INT) */
    val cell17State: Column[Option[Int]] = column[Option[Int]]("cell_17_state")
    /** Database column cell_18_state DBType(INT) */
    val cell18State: Column[Option[Int]] = column[Option[Int]]("cell_18_state")
    /** Database column cell_19_state DBType(INT) */
    val cell19State: Column[Option[Int]] = column[Option[Int]]("cell_19_state")
    /** Database column cell_20_state DBType(INT) */
    val cell20State: Column[Option[Int]] = column[Option[Int]]("cell_20_state")
    /** Database column cell_21_state DBType(INT) */
    val cell21State: Column[Option[Int]] = column[Option[Int]]("cell_21_state")
    /** Database column cell_22_state DBType(INT) */
    val cell22State: Column[Option[Int]] = column[Option[Int]]("cell_22_state")
    /** Database column cell_23_state DBType(INT) */
    val cell23State: Column[Option[Int]] = column[Option[Int]]("cell_23_state")
    /** Database column cell_24_state DBType(INT) */
    val cell24State: Column[Option[Int]] = column[Option[Int]]("cell_24_state")
    /** Database column cell_25_state DBType(INT) */
    val cell25State: Column[Option[Int]] = column[Option[Int]]("cell_25_state")
    /** Database column cell_26_state DBType(INT) */
    val cell26State: Column[Option[Int]] = column[Option[Int]]("cell_26_state")
    /** Database column cell_27_state DBType(INT) */
    val cell27State: Column[Option[Int]] = column[Option[Int]]("cell_27_state")
    /** Database column cell_28_state DBType(INT) */
    val cell28State: Column[Option[Int]] = column[Option[Int]]("cell_28_state")
    /** Database column cell_29_state DBType(INT) */
    val cell29State: Column[Option[Int]] = column[Option[Int]]("cell_29_state")
    /** Database column cell_30_state DBType(INT) */
    val cell30State: Column[Option[Int]] = column[Option[Int]]("cell_30_state")
    /** Database column cell_31_state DBType(INT) */
    val cell31State: Column[Option[Int]] = column[Option[Int]]("cell_31_state")
    /** Database column exist_cells DBType(INT) */
    val existCells: Column[Option[Int]] = column[Option[Int]]("exist_cells")
    /** Database column exclude_cells DBType(INT) */
    val excludeCells: Column[Option[Int]] = column[Option[Int]]("exclude_cells")
    /** Database column include_cells DBType(INT) */
    val includeCells: Column[Option[Int]] = column[Option[Int]]("include_cells")
    /** Database column unknown_cells DBType(INT) */
    val unknownCells: Column[Option[Int]] = column[Option[Int]]("unknown_cells")
    /** Database column known_cells DBType(INT) */
    val knownCells: Column[Option[Int]] = column[Option[Int]]("known_cells")
    /** Database column blocked_cells DBType(INT) */
    val blockedCells: Column[Option[Int]] = column[Option[Int]]("blocked_cells")
    /** Database column down_cells DBType(INT) */
    val downCells: Column[Option[Int]] = column[Option[Int]]("down_cells")
    /** Database column up_cells DBType(INT) */
    val upCells: Column[Option[Int]] = column[Option[Int]]("up_cells")
    
    /** Index over (generation) (database name ranmateFemto_mSiteServiceState_generation) */
    val index1 = index("ranmateFemto_mSiteServiceState_generation", generation :: HNil)
    /** Index over (groupId) (database name ranmateFemto_mSiteServiceState_groupId) */
    val index2 = index("ranmateFemto_mSiteServiceState_groupId", groupId :: HNil)
    /** Index over (measurementTime) (database name ranmateFemto_mSiteServiceState_measurementTime) */
    val index3 = index("ranmateFemto_mSiteServiceState_measurementTime", measurementTime :: HNil)
    /** Index over (siteId) (database name ranmateFemto_mSiteServiceState_siteId) */
    val index4 = index("ranmateFemto_mSiteServiceState_siteId", siteId :: HNil)
  }
  /** Collection-like TableQuery object for table MSiteServiceState */
  lazy val MSiteServiceState = new TableQuery(tag => new MSiteServiceState(tag))
  
  /** Entity class storing rows of table NewCells
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param generation Database column generation DBType(INT)
   *  @param stateNo Database column state_no DBType(INT)
   *  @param cellNo Database column cell_no DBType(INT) */
  case class NewCellsRow(measurementTime: java.sql.Timestamp, siteId: String, groupId: String, generation: Int, stateNo: Int, cellNo: Option[Int])
  /** GetResult implicit for fetching NewCellsRow objects using plain SQL queries */
  implicit def GetResultNewCellsRow(implicit e0: GR[java.sql.Timestamp], e1: GR[String], e2: GR[Int], e3: GR[Option[Int]]): GR[NewCellsRow] = GR{
    prs => import prs._
    NewCellsRow.tupled((<<[java.sql.Timestamp], <<[String], <<[String], <<[Int], <<[Int], <<?[Int]))
  }
  /** Table description of table new_cells. Objects of this class serve as prototypes for rows in queries. */
  class NewCells(_tableTag: Tag) extends Table[NewCellsRow](_tableTag, "new_cells") {
    def * = (measurementTime, siteId, groupId, generation, stateNo, cellNo) <> (NewCellsRow.tupled, NewCellsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, siteId.?, groupId.?, generation.?, stateNo.?, cellNo).shaped.<>({r=>import r._; _1.map(_=> NewCellsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column state_no DBType(INT) */
    val stateNo: Column[Int] = column[Int]("state_no")
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
  }
  /** Collection-like TableQuery object for table NewCells */
  lazy val NewCells = new TableQuery(tag => new NewCells(tag))
  
  /** Entity class storing rows of table NewSites
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param generation Database column generation DBType(INT)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true) */
  case class NewSitesRow(measurementTime: java.sql.Timestamp, siteId: String, groupId: Option[String], generation: Int, vendorId: Option[String])
  /** GetResult implicit for fetching NewSitesRow objects using plain SQL queries */
  implicit def GetResultNewSitesRow(implicit e0: GR[java.sql.Timestamp], e1: GR[String], e2: GR[Option[String]], e3: GR[Int]): GR[NewSitesRow] = GR{
    prs => import prs._
    NewSitesRow.tupled((<<[java.sql.Timestamp], <<[String], <<?[String], <<[Int], <<?[String]))
  }
  /** Table description of table new_sites. Objects of this class serve as prototypes for rows in queries. */
  class NewSites(_tableTag: Tag) extends Table[NewSitesRow](_tableTag, "new_sites") {
    def * = (measurementTime, siteId, groupId, generation, vendorId) <> (NewSitesRow.tupled, NewSitesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, siteId.?, groupId, generation.?, vendorId).shaped.<>({r=>import r._; _1.map(_=> NewSitesRow.tupled((_1.get, _2.get, _3, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
  }
  /** Collection-like TableQuery object for table NewSites */
  lazy val NewSites = new TableQuery(tag => new NewSites(tag))
  
  /** Entity class storing rows of table Nodes
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param generation Database column generation DBType(INT)
   *  @param enabled Database column enabled DBType(BIT) */
  case class NodesRow(nodeId: String, generation: Int, enabled: Option[Boolean])
  /** GetResult implicit for fetching NodesRow objects using plain SQL queries */
  implicit def GetResultNodesRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[Boolean]]): GR[NodesRow] = GR{
    prs => import prs._
    NodesRow.tupled((<<[String], <<[Int], <<?[Boolean]))
  }
  /** Table description of table nodes. Objects of this class serve as prototypes for rows in queries. */
  class Nodes(_tableTag: Tag) extends Table[NodesRow](_tableTag, "nodes") {
    def * = (nodeId, generation, enabled) <> (NodesRow.tupled, NodesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (nodeId.?, generation.?, enabled).shaped.<>({r=>import r._; _1.map(_=> NodesRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[String] = column[String]("node_id", O.Length(50,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column enabled DBType(BIT) */
    val enabled: Column[Option[Boolean]] = column[Option[Boolean]]("enabled")
  }
  /** Collection-like TableQuery object for table Nodes */
  lazy val Nodes = new TableQuery(tag => new Nodes(tag))
  
  /** Entity class storing rows of table Notes
   *  @param noteId Database column note_id DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param username Database column username DBType(VARCHAR), Length(256,true)
   *  @param noteTimestamp Database column note_timestamp DBType(DATETIME)
   *  @param note Database column note DBType(VARCHAR), Length(4096,true) */
  case class NotesRow(noteId: Int, groupId: String, siteId: String, username: Option[String], noteTimestamp: java.sql.Timestamp, note: String)
  /** GetResult implicit for fetching NotesRow objects using plain SQL queries */
  implicit def GetResultNotesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[NotesRow] = GR{
    prs => import prs._
    NotesRow.tupled((<<[Int], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp], <<[String]))
  }
  /** Table description of table notes. Objects of this class serve as prototypes for rows in queries. */
  class Notes(_tableTag: Tag) extends Table[NotesRow](_tableTag, "notes") {
    def * = (noteId, groupId, siteId, username, noteTimestamp, note) <> (NotesRow.tupled, NotesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (noteId.?, groupId.?, siteId.?, username, noteTimestamp.?, note.?).shaped.<>({r=>import r._; _1.map(_=> NotesRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column note_id DBType(INT) */
    val noteId: Column[Int] = column[Int]("note_id")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column username DBType(VARCHAR), Length(256,true) */
    val username: Column[Option[String]] = column[Option[String]]("username", O.Length(256,varying=true))
    /** Database column note_timestamp DBType(DATETIME) */
    val noteTimestamp: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("note_timestamp")
    /** Database column note DBType(VARCHAR), Length(4096,true) */
    val note: Column[String] = column[String]("note", O.Length(4096,varying=true))
    
    /** Index over (siteId) (database name ranmateFemto_notes_siteId) */
    val index1 = index("ranmateFemto_notes_siteId", siteId)
  }
  /** Collection-like TableQuery object for table Notes */
  lazy val Notes = new TableQuery(tag => new Notes(tag))
  
  /** Entity class storing rows of table Roles
   *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
   *  @param name Database column name DBType(VARCHAR), Length(255,true)
   *  @param shortName Database column short_name DBType(VARCHAR), Length(255,true)
   *  @param dateCreation Database column date_creation DBType(TIMESTAMP)
   *  @param createdBy Database column created_by DBType(INT) */
  case class RolesRow(id: Int, name: String, shortName: String, dateCreation: java.sql.Timestamp, createdBy: Option[Int])
  /** GetResult implicit for fetching RolesRow objects using plain SQL queries */
  implicit def GetResultRolesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[Int]]): GR[RolesRow] = GR{
    prs => import prs._
    RolesRow.tupled((<<[Int], <<[String], <<[String], <<[java.sql.Timestamp], <<?[Int]))
  }
  /** Table description of table roles. Objects of this class serve as prototypes for rows in queries. */
  class Roles(_tableTag: Tag) extends Table[RolesRow](_tableTag, "roles") {
    def * = (id, name, shortName, dateCreation, createdBy) <> (RolesRow.tupled, RolesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?, shortName.?, dateCreation.?, createdBy).shaped.<>({r=>import r._; _1.map(_=> RolesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name DBType(VARCHAR), Length(255,true) */
    val name: Column[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column short_name DBType(VARCHAR), Length(255,true) */
    val shortName: Column[String] = column[String]("short_name", O.Length(255,varying=true))
    /** Database column date_creation DBType(TIMESTAMP) */
    val dateCreation: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("date_creation")
    /** Database column created_by DBType(INT) */
    val createdBy: Column[Option[Int]] = column[Option[Int]]("created_by")
    
    /** Foreign key referencing User (database name roles_created_by_fkey) */
    lazy val userFk = foreignKey("roles_created_by_fkey", createdBy, User)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Roles */
  lazy val Roles = new TableQuery(tag => new Roles(tag))
  
  /** Entity class storing rows of table SectorIdentities
   *  @param sectorId Database column sector_id DBType(VARCHAR), Length(50,true)
   *  @param generation Database column generation DBType(INT)
   *  @param sectorNo Database column sector_no DBType(INT) */
  case class SectorIdentitiesRow(sectorId: String, generation: Int, sectorNo: Int)
  /** GetResult implicit for fetching SectorIdentitiesRow objects using plain SQL queries */
  implicit def GetResultSectorIdentitiesRow(implicit e0: GR[String], e1: GR[Int]): GR[SectorIdentitiesRow] = GR{
    prs => import prs._
    SectorIdentitiesRow.tupled((<<[String], <<[Int], <<[Int]))
  }
  /** Table description of table sector_identities. Objects of this class serve as prototypes for rows in queries. */
  class SectorIdentities(_tableTag: Tag) extends Table[SectorIdentitiesRow](_tableTag, "sector_identities") {
    def * = (sectorId, generation, sectorNo) <> (SectorIdentitiesRow.tupled, SectorIdentitiesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (sectorId.?, generation.?, sectorNo.?).shaped.<>({r=>import r._; _1.map(_=> SectorIdentitiesRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column sector_id DBType(VARCHAR), Length(50,true) */
    val sectorId: Column[String] = column[String]("sector_id", O.Length(50,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Int] = column[Int]("sector_no")
    
    /** Index over (generation) (database name ranmateFemto_sectorIdentities_generation) */
    val index1 = index("ranmateFemto_sectorIdentities_generation", generation)
    /** Index over (sectorId) (database name ranmateFemto_sectorIdentities_sectorId) */
    val index2 = index("ranmateFemto_sectorIdentities_sectorId", sectorId)
    /** Index over (sectorNo) (database name ranmateFemto_sectorIdentities_sectorNo) */
    val index3 = index("ranmateFemto_sectorIdentities_sectorNo", sectorNo)
  }
  /** Collection-like TableQuery object for table SectorIdentities */
  lazy val SectorIdentities = new TableQuery(tag => new SectorIdentities(tag))
  
  /** Entity class storing rows of table ServiceCounterHistory
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param existCells Database column exist_cells DBType(INT)
   *  @param excludeCells Database column exclude_cells DBType(INT)
   *  @param includeCells Database column include_cells DBType(INT)
   *  @param unknownCells Database column unknown_cells DBType(INT)
   *  @param knownCells Database column known_cells DBType(INT)
   *  @param blockedCells Database column blocked_cells DBType(INT)
   *  @param downCells Database column down_cells DBType(INT)
   *  @param upCells Database column up_cells DBType(INT)
   *  @param sectorNo Database column sector_no DBType(INT) */
  case class ServiceCounterHistoryRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], vendorId: Option[String], existCells: Option[Int], excludeCells: Option[Int], includeCells: Option[Int], unknownCells: Option[Int], knownCells: Option[Int], blockedCells: Option[Int], downCells: Option[Int], upCells: Option[Int], sectorNo: Option[Int])
  /** GetResult implicit for fetching ServiceCounterHistoryRow objects using plain SQL queries */
  implicit def GetResultServiceCounterHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[ServiceCounterHistoryRow] = GR{
    prs => import prs._
    ServiceCounterHistoryRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table service_counter_history. Objects of this class serve as prototypes for rows in queries. */
  class ServiceCounterHistory(_tableTag: Tag) extends Table[ServiceCounterHistoryRow](_tableTag, "service_counter_history") {
    def * = (measurementTime, generation, groupId, vendorId, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo) <> (ServiceCounterHistoryRow.tupled, ServiceCounterHistoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, vendorId, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo).shaped.<>({r=>import r._; _1.map(_=> ServiceCounterHistoryRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column exist_cells DBType(INT) */
    val existCells: Column[Option[Int]] = column[Option[Int]]("exist_cells")
    /** Database column exclude_cells DBType(INT) */
    val excludeCells: Column[Option[Int]] = column[Option[Int]]("exclude_cells")
    /** Database column include_cells DBType(INT) */
    val includeCells: Column[Option[Int]] = column[Option[Int]]("include_cells")
    /** Database column unknown_cells DBType(INT) */
    val unknownCells: Column[Option[Int]] = column[Option[Int]]("unknown_cells")
    /** Database column known_cells DBType(INT) */
    val knownCells: Column[Option[Int]] = column[Option[Int]]("known_cells")
    /** Database column blocked_cells DBType(INT) */
    val blockedCells: Column[Option[Int]] = column[Option[Int]]("blocked_cells")
    /** Database column down_cells DBType(INT) */
    val downCells: Column[Option[Int]] = column[Option[Int]]("down_cells")
    /** Database column up_cells DBType(INT) */
    val upCells: Column[Option[Int]] = column[Option[Int]]("up_cells")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
    
    /** Index over (generation) (database name ranmateFemto_serviceCounterHistory_generation) */
    val index1 = index("ranmateFemto_serviceCounterHistory_generation", generation)
    /** Index over (groupId) (database name ranmateFemto_serviceCounterHistory_groupId) */
    val index2 = index("ranmateFemto_serviceCounterHistory_groupId", groupId)
    /** Index over (measurementTime) (database name ranmateFemto_serviceCounterHistory_measurementTime) */
    val index3 = index("ranmateFemto_serviceCounterHistory_measurementTime", measurementTime)
    /** Index over (vendorId) (database name ranmateFemto_serviceCounterHistory_vendorId) */
    val index4 = index("ranmateFemto_serviceCounterHistory_vendorId", vendorId)
  }
  /** Collection-like TableQuery object for table ServiceCounterHistory */
  lazy val ServiceCounterHistory = new TableQuery(tag => new ServiceCounterHistory(tag))
  
  /** Row type of table SiteCounters */
  type SiteCountersRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for SiteCountersRow providing default values if available in the database schema. */
  def SiteCountersRow(measurementTime: java.sql.Timestamp, groupId: Option[String], siteId: Option[String], exclude2g: Option[Int], exclude3g: Option[Int], exclude4g: Option[Int], vendorId2g: Option[String], existCells2g: Option[Long], excludeCells2g: Option[Long], includeCells2g: Option[Long], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], vendorId3g: Option[String], existCells3g: Option[Long], excludeCells3g: Option[Long], includeCells3g: Option[Long], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], vendorId4g: Option[String], existCells4g: Option[Long], excludeCells4g: Option[Long], includeCells4g: Option[Long], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long]): SiteCountersRow = {
    measurementTime :: groupId :: siteId :: exclude2g :: exclude3g :: exclude4g :: vendorId2g :: existCells2g :: excludeCells2g :: includeCells2g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: vendorId3g :: existCells3g :: excludeCells3g :: includeCells3g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: vendorId4g :: existCells4g :: excludeCells4g :: includeCells4g :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: HNil
  }
  /** GetResult implicit for fetching SiteCountersRow objects using plain SQL queries */
  implicit def GetResultSiteCountersRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Long]]): GR[SiteCountersRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: HNil
  }
  /** Table description of table site_counters. Objects of this class serve as prototypes for rows in queries. */
  class SiteCounters(_tableTag: Tag) extends Table[SiteCountersRow](_tableTag, "site_counters") {
    def * = measurementTime :: groupId :: siteId :: exclude2g :: exclude3g :: exclude4g :: vendorId2g :: existCells2g :: excludeCells2g :: includeCells2g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: vendorId3g :: existCells3g :: excludeCells3g :: includeCells3g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: vendorId4g :: existCells4g :: excludeCells4g :: includeCells4g :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column exclude_2g DBType(INT) */
    val exclude2g: Column[Option[Int]] = column[Option[Int]]("exclude_2g")
    /** Database column exclude_3g DBType(INT) */
    val exclude3g: Column[Option[Int]] = column[Option[Int]]("exclude_3g")
    /** Database column exclude_4g DBType(INT) */
    val exclude4g: Column[Option[Int]] = column[Option[Int]]("exclude_4g")
    /** Database column vendor_id_2g DBType(VARCHAR), Length(50,true) */
    val vendorId2g: Column[Option[String]] = column[Option[String]]("vendor_id_2g", O.Length(50,varying=true))
    /** Database column exist_cells_2g DBType(BIGINT) */
    val existCells2g: Column[Option[Long]] = column[Option[Long]]("exist_cells_2g")
    /** Database column exclude_cells_2g DBType(BIGINT) */
    val excludeCells2g: Column[Option[Long]] = column[Option[Long]]("exclude_cells_2g")
    /** Database column include_cells_2g DBType(BIGINT) */
    val includeCells2g: Column[Option[Long]] = column[Option[Long]]("include_cells_2g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column vendor_id_3g DBType(VARCHAR), Length(50,true) */
    val vendorId3g: Column[Option[String]] = column[Option[String]]("vendor_id_3g", O.Length(50,varying=true))
    /** Database column exist_cells_3g DBType(BIGINT) */
    val existCells3g: Column[Option[Long]] = column[Option[Long]]("exist_cells_3g")
    /** Database column exclude_cells_3g DBType(BIGINT) */
    val excludeCells3g: Column[Option[Long]] = column[Option[Long]]("exclude_cells_3g")
    /** Database column include_cells_3g DBType(BIGINT) */
    val includeCells3g: Column[Option[Long]] = column[Option[Long]]("include_cells_3g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column vendor_id_4g DBType(VARCHAR), Length(50,true) */
    val vendorId4g: Column[Option[String]] = column[Option[String]]("vendor_id_4g", O.Length(50,varying=true))
    /** Database column exist_cells_4g DBType(BIGINT) */
    val existCells4g: Column[Option[Long]] = column[Option[Long]]("exist_cells_4g")
    /** Database column exclude_cells_4g DBType(BIGINT) */
    val excludeCells4g: Column[Option[Long]] = column[Option[Long]]("exclude_cells_4g")
    /** Database column include_cells_4g DBType(BIGINT) */
    val includeCells4g: Column[Option[Long]] = column[Option[Long]]("include_cells_4g")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
  }
  /** Collection-like TableQuery object for table SiteCounters */
  lazy val SiteCounters = new TableQuery(tag => new SiteCounters(tag))
  
  /** Row type of table SiteCountersNew */
  type SiteCountersNewRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for SiteCountersNewRow providing default values if available in the database schema. */
  def SiteCountersNewRow(measurementTime: java.sql.Timestamp, groupId: Option[String], siteId: Option[String], exclude2g: Option[Int], exclude3g: Option[Int], exclude4g: Option[Int], vendorId2g: Option[String], existCells2g: Option[Long], excludeCells2g: Option[Long], includeCells2g: Option[Long], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], vendorId3g: Option[String], existCells3g: Option[Long], excludeCells3g: Option[Long], includeCells3g: Option[Long], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], vendorId4g: Option[String], existCells4g: Option[Long], excludeCells4g: Option[Long], includeCells4g: Option[Long], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long]): SiteCountersNewRow = {
    measurementTime :: groupId :: siteId :: exclude2g :: exclude3g :: exclude4g :: vendorId2g :: existCells2g :: excludeCells2g :: includeCells2g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: vendorId3g :: existCells3g :: excludeCells3g :: includeCells3g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: vendorId4g :: existCells4g :: excludeCells4g :: includeCells4g :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: HNil
  }
  /** GetResult implicit for fetching SiteCountersNewRow objects using plain SQL queries */
  implicit def GetResultSiteCountersNewRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Long]]): GR[SiteCountersNewRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: HNil
  }
  /** Table description of table site_counters_new. Objects of this class serve as prototypes for rows in queries. */
  class SiteCountersNew(_tableTag: Tag) extends Table[SiteCountersNewRow](_tableTag, "site_counters_new") {
    def * = measurementTime :: groupId :: siteId :: exclude2g :: exclude3g :: exclude4g :: vendorId2g :: existCells2g :: excludeCells2g :: includeCells2g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: vendorId3g :: existCells3g :: excludeCells3g :: includeCells3g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: vendorId4g :: existCells4g :: excludeCells4g :: includeCells4g :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column exclude_2g DBType(INT) */
    val exclude2g: Column[Option[Int]] = column[Option[Int]]("exclude_2g")
    /** Database column exclude_3g DBType(INT) */
    val exclude3g: Column[Option[Int]] = column[Option[Int]]("exclude_3g")
    /** Database column exclude_4g DBType(INT) */
    val exclude4g: Column[Option[Int]] = column[Option[Int]]("exclude_4g")
    /** Database column vendor_id_2g DBType(VARCHAR), Length(50,true) */
    val vendorId2g: Column[Option[String]] = column[Option[String]]("vendor_id_2g", O.Length(50,varying=true))
    /** Database column exist_cells_2g DBType(BIGINT) */
    val existCells2g: Column[Option[Long]] = column[Option[Long]]("exist_cells_2g")
    /** Database column exclude_cells_2g DBType(BIGINT) */
    val excludeCells2g: Column[Option[Long]] = column[Option[Long]]("exclude_cells_2g")
    /** Database column include_cells_2g DBType(BIGINT) */
    val includeCells2g: Column[Option[Long]] = column[Option[Long]]("include_cells_2g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column vendor_id_3g DBType(VARCHAR), Length(50,true) */
    val vendorId3g: Column[Option[String]] = column[Option[String]]("vendor_id_3g", O.Length(50,varying=true))
    /** Database column exist_cells_3g DBType(BIGINT) */
    val existCells3g: Column[Option[Long]] = column[Option[Long]]("exist_cells_3g")
    /** Database column exclude_cells_3g DBType(BIGINT) */
    val excludeCells3g: Column[Option[Long]] = column[Option[Long]]("exclude_cells_3g")
    /** Database column include_cells_3g DBType(BIGINT) */
    val includeCells3g: Column[Option[Long]] = column[Option[Long]]("include_cells_3g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column vendor_id_4g DBType(VARCHAR), Length(50,true) */
    val vendorId4g: Column[Option[String]] = column[Option[String]]("vendor_id_4g", O.Length(50,varying=true))
    /** Database column exist_cells_4g DBType(BIGINT) */
    val existCells4g: Column[Option[Long]] = column[Option[Long]]("exist_cells_4g")
    /** Database column exclude_cells_4g DBType(BIGINT) */
    val excludeCells4g: Column[Option[Long]] = column[Option[Long]]("exclude_cells_4g")
    /** Database column include_cells_4g DBType(BIGINT) */
    val includeCells4g: Column[Option[Long]] = column[Option[Long]]("include_cells_4g")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
  }
  /** Collection-like TableQuery object for table SiteCountersNew */
  lazy val SiteCountersNew = new TableQuery(tag => new SiteCountersNew(tag))
  
  /** Entity class storing rows of table SiteOperatorCounterHistory
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT), Default(0)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param existCells Database column exist_cells DBType(BIGINT)
   *  @param excludeCells Database column exclude_cells DBType(BIGINT)
   *  @param includeCells Database column include_cells DBType(BIGINT)
   *  @param unknownCells Database column unknown_cells DBType(BIGINT)
   *  @param knownCells Database column known_cells DBType(BIGINT)
   *  @param blockedCells Database column blocked_cells DBType(BIGINT)
   *  @param downCells Database column down_cells DBType(BIGINT)
   *  @param upCells Database column up_cells DBType(BIGINT)
   *  @param sectorNo Database column sector_no DBType(INT) */
  case class SiteOperatorCounterHistoryRow(measurementTime: java.sql.Timestamp, generation: Int = 0, groupId: Option[String], siteId: Option[String], existCells: Option[Long], excludeCells: Option[Long], includeCells: Option[Long], unknownCells: Option[Long], knownCells: Option[Long], blockedCells: Option[Long], downCells: Option[Long], upCells: Option[Long], sectorNo: Option[Int])
  /** GetResult implicit for fetching SiteOperatorCounterHistoryRow objects using plain SQL queries */
  implicit def GetResultSiteOperatorCounterHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Int], e2: GR[Option[String]], e3: GR[Option[Long]], e4: GR[Option[Int]]): GR[SiteOperatorCounterHistoryRow] = GR{
    prs => import prs._
    SiteOperatorCounterHistoryRow.tupled((<<[java.sql.Timestamp], <<[Int], <<?[String], <<?[String], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Int]))
  }
  /** Table description of table site_operator_counter_history. Objects of this class serve as prototypes for rows in queries. */
  class SiteOperatorCounterHistory(_tableTag: Tag) extends Table[SiteOperatorCounterHistoryRow](_tableTag, "site_operator_counter_history") {
    def * = (measurementTime, generation, groupId, siteId, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo) <> (SiteOperatorCounterHistoryRow.tupled, SiteOperatorCounterHistoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation.?, groupId, siteId, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo).shaped.<>({r=>import r._; _1.map(_=> SiteOperatorCounterHistoryRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT), Default(0) */
    val generation: Column[Int] = column[Int]("generation", O.Default(0))
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column exist_cells DBType(BIGINT) */
    val existCells: Column[Option[Long]] = column[Option[Long]]("exist_cells")
    /** Database column exclude_cells DBType(BIGINT) */
    val excludeCells: Column[Option[Long]] = column[Option[Long]]("exclude_cells")
    /** Database column include_cells DBType(BIGINT) */
    val includeCells: Column[Option[Long]] = column[Option[Long]]("include_cells")
    /** Database column unknown_cells DBType(BIGINT) */
    val unknownCells: Column[Option[Long]] = column[Option[Long]]("unknown_cells")
    /** Database column known_cells DBType(BIGINT) */
    val knownCells: Column[Option[Long]] = column[Option[Long]]("known_cells")
    /** Database column blocked_cells DBType(BIGINT) */
    val blockedCells: Column[Option[Long]] = column[Option[Long]]("blocked_cells")
    /** Database column down_cells DBType(BIGINT) */
    val downCells: Column[Option[Long]] = column[Option[Long]]("down_cells")
    /** Database column up_cells DBType(BIGINT) */
    val upCells: Column[Option[Long]] = column[Option[Long]]("up_cells")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
    
    /** Index over (groupId) (database name ranmateFemto_siteOperatorCounterHistory_groupId) */
    val index1 = index("ranmateFemto_siteOperatorCounterHistory_groupId", groupId)
    /** Index over (measurementTime) (database name ranmateFemto_siteOperatorCounterHistory_measurementTime) */
    val index2 = index("ranmateFemto_siteOperatorCounterHistory_measurementTime", measurementTime)
    /** Index over (sectorNo) (database name ranmateFemto_siteOperatorCounterHistory_sectorNo) */
    val index3 = index("ranmateFemto_siteOperatorCounterHistory_sectorNo", sectorNo)
    /** Index over (siteId) (database name ranmateFemto_siteOperatorCounterHistory_siteId) */
    val index4 = index("ranmateFemto_siteOperatorCounterHistory_siteId", siteId)
  }
  /** Collection-like TableQuery object for table SiteOperatorCounterHistory */
  lazy val SiteOperatorCounterHistory = new TableQuery(tag => new SiteOperatorCounterHistory(tag))
  
  /** Row type of table SiteOperatorPerformanceHistory */
  type SiteOperatorPerformanceHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for SiteOperatorPerformanceHistoryRow providing default values if available in the database schema. */
  def SiteOperatorPerformanceHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], siteId: Option[String], unknownCellsAll: Option[Long], knownCellsAll: Option[Long], blockedCellsAll: Option[Long], downCellsAll: Option[Long], upCellsAll: Option[Long], cisKpiAll: Option[scala.math.BigDecimal], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long], cisKpi4g: Option[scala.math.BigDecimal], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], cisKpi3g: Option[scala.math.BigDecimal], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], cisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): SiteOperatorPerformanceHistoryRow = {
    measurementTime :: groupId :: siteId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching SiteOperatorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultSiteOperatorPerformanceHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[SiteOperatorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table site_operator_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class SiteOperatorPerformanceHistory(_tableTag: Tag) extends Table[SiteOperatorPerformanceHistoryRow](_tableTag, "site_operator_performance_history") {
    def * = measurementTime :: groupId :: siteId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column unknown_cells_all DBType(BIGINT) */
    val unknownCellsAll: Column[Option[Long]] = column[Option[Long]]("unknown_cells_all")
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column up_cells_all DBType(BIGINT) */
    val upCellsAll: Column[Option[Long]] = column[Option[Long]]("up_cells_all")
    /** Database column cis_kpi_all DBType(DECIMAL) */
    val cisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_all")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
    
    /** Index over (groupId) (database name ranmateFemto_siteOperatorPerformanceHistory_groupId) */
    val index1 = index("ranmateFemto_siteOperatorPerformanceHistory_groupId", groupId :: HNil)
    /** Index over (measurementTime) (database name ranmateFemto_siteOperatorPerformanceHistory_measurementTime) */
    val index2 = index("ranmateFemto_siteOperatorPerformanceHistory_measurementTime", measurementTime :: HNil)
    /** Index over (sectorNo) (database name ranmateFemto_siteOperatorPerformanceHistory_sectorNo) */
    val index3 = index("ranmateFemto_siteOperatorPerformanceHistory_sectorNo", sectorNo :: HNil)
    /** Index over (siteId) (database name ranmateFemto_siteOperatorPerformanceHistory_siteId) */
    val index4 = index("ranmateFemto_siteOperatorPerformanceHistory_siteId", siteId :: HNil)
  }
  /** Collection-like TableQuery object for table SiteOperatorPerformanceHistory */
  lazy val SiteOperatorPerformanceHistory = new TableQuery(tag => new SiteOperatorPerformanceHistory(tag))
  
  /** Entity class storing rows of table Sites
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param generation Database column generation DBType(INT)
   *  @param exclude Database column exclude DBType(BIT)
   *  @param sticky Database column sticky DBType(BIT)
   *  @param priority Database column priority DBType(INT), Default(99)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param effectiveFrom Database column effective_from DBType(TIMESTAMP)
   *  @param effectiveTo Database column effective_to DBType(TIMESTAMP) */
  case class SitesRow(siteId: String, nodeId: Option[String], groupId: String, generation: Int, exclude: Boolean, sticky: Boolean, priority: Int = 99, vendorId: String, effectiveFrom: java.sql.Timestamp, effectiveTo: java.sql.Timestamp)
  /** GetResult implicit for fetching SitesRow objects using plain SQL queries */
  implicit def GetResultSitesRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Int], e3: GR[Boolean], e4: GR[java.sql.Timestamp]): GR[SitesRow] = GR{
    prs => import prs._
    SitesRow.tupled((<<[String], <<?[String], <<[String], <<[Int], <<[Boolean], <<[Boolean], <<[Int], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table sites. Objects of this class serve as prototypes for rows in queries. */
  class Sites(_tableTag: Tag) extends Table[SitesRow](_tableTag, "sites") {
    def * = (siteId, nodeId, groupId, generation, exclude, sticky, priority, vendorId, effectiveFrom, effectiveTo) <> (SitesRow.tupled, SitesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (siteId.?, nodeId, groupId.?, generation.?, exclude.?, sticky.?, priority.?, vendorId.?, effectiveFrom.?, effectiveTo.?).shaped.<>({r=>import r._; _1.map(_=> SitesRow.tupled((_1.get, _2, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Boolean] = column[Boolean]("exclude")
    /** Database column sticky DBType(BIT) */
    val sticky: Column[Boolean] = column[Boolean]("sticky")
    /** Database column priority DBType(INT), Default(99) */
    val priority: Column[Int] = column[Int]("priority", O.Default(99))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[String] = column[String]("vendor_id", O.Length(50,varying=true))
    /** Database column effective_from DBType(TIMESTAMP) */
    val effectiveFrom: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_from")
    /** Database column effective_to DBType(TIMESTAMP) */
    val effectiveTo: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_to")
    
    /** Index over (generation) (database name ranmateFemto_sites_generation) */
    val index1 = index("ranmateFemto_sites_generation", generation)
    /** Index over (groupId) (database name ranmateFemto_sites_groupId) */
    val index2 = index("ranmateFemto_sites_groupId", groupId)
    /** Index over (siteId) (database name ranmateFemto_sites_siteId) */
    val index3 = index("ranmateFemto_sites_siteId", siteId)
  }
  /** Collection-like TableQuery object for table Sites */
  lazy val Sites = new TableQuery(tag => new Sites(tag))
  
  /** Entity class storing rows of table SiteServiceCounterHistory
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param excludeSite Database column exclude_site DBType(BIT)
   *  @param existCells Database column exist_cells DBType(INT)
   *  @param excludeCells Database column exclude_cells DBType(INT)
   *  @param includeCells Database column include_cells DBType(INT)
   *  @param unknownCells Database column unknown_cells DBType(INT)
   *  @param knownCells Database column known_cells DBType(INT)
   *  @param blockedCells Database column blocked_cells DBType(INT)
   *  @param downCells Database column down_cells DBType(INT)
   *  @param upCells Database column up_cells DBType(INT) */
  case class SiteServiceCounterHistoryRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], vendorId: Option[String], excludeSite: Option[Boolean], existCells: Option[Int], excludeCells: Option[Int], includeCells: Option[Int], unknownCells: Option[Int], knownCells: Option[Int], blockedCells: Option[Int], downCells: Option[Int], upCells: Option[Int])
  /** GetResult implicit for fetching SiteServiceCounterHistoryRow objects using plain SQL queries */
  implicit def GetResultSiteServiceCounterHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]]): GR[SiteServiceCounterHistoryRow] = GR{
    prs => import prs._
    SiteServiceCounterHistoryRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Boolean], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table site_service_counter_history. Objects of this class serve as prototypes for rows in queries. */
  class SiteServiceCounterHistory(_tableTag: Tag) extends Table[SiteServiceCounterHistoryRow](_tableTag, "site_service_counter_history") {
    def * = (measurementTime, generation, groupId, siteId, vendorId, excludeSite, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells) <> (SiteServiceCounterHistoryRow.tupled, SiteServiceCounterHistoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, vendorId, excludeSite, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells).shaped.<>({r=>import r._; _1.map(_=> SiteServiceCounterHistoryRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column exclude_site DBType(BIT) */
    val excludeSite: Column[Option[Boolean]] = column[Option[Boolean]]("exclude_site")
    /** Database column exist_cells DBType(INT) */
    val existCells: Column[Option[Int]] = column[Option[Int]]("exist_cells")
    /** Database column exclude_cells DBType(INT) */
    val excludeCells: Column[Option[Int]] = column[Option[Int]]("exclude_cells")
    /** Database column include_cells DBType(INT) */
    val includeCells: Column[Option[Int]] = column[Option[Int]]("include_cells")
    /** Database column unknown_cells DBType(INT) */
    val unknownCells: Column[Option[Int]] = column[Option[Int]]("unknown_cells")
    /** Database column known_cells DBType(INT) */
    val knownCells: Column[Option[Int]] = column[Option[Int]]("known_cells")
    /** Database column blocked_cells DBType(INT) */
    val blockedCells: Column[Option[Int]] = column[Option[Int]]("blocked_cells")
    /** Database column down_cells DBType(INT) */
    val downCells: Column[Option[Int]] = column[Option[Int]]("down_cells")
    /** Database column up_cells DBType(INT) */
    val upCells: Column[Option[Int]] = column[Option[Int]]("up_cells")
    
    /** Index over (siteId,groupId,measurementTime) (database name ranmateFemto_siteServiceCounterHistory_Composite) */
    val index1 = index("ranmateFemto_siteServiceCounterHistory_Composite", (siteId, groupId, measurementTime))
    /** Index over (generation) (database name ranmateFemto_siteServiceCounterHistory_generation) */
    val index2 = index("ranmateFemto_siteServiceCounterHistory_generation", generation)
    /** Index over (groupId) (database name ranmateFemto_siteServiceCounterHistory_groupId) */
    val index3 = index("ranmateFemto_siteServiceCounterHistory_groupId", groupId)
    /** Index over (measurementTime) (database name ranmateFemto_siteServiceCounterHistory_measurementTime) */
    val index4 = index("ranmateFemto_siteServiceCounterHistory_measurementTime", measurementTime)
    /** Index over (siteId) (database name ranmateFemto_siteServiceCounterHistory_siteId) */
    val index5 = index("ranmateFemto_siteServiceCounterHistory_siteId", siteId)
  }
  /** Collection-like TableQuery object for table SiteServiceCounterHistory */
  lazy val SiteServiceCounterHistory = new TableQuery(tag => new SiteServiceCounterHistory(tag))
  
  /** Row type of table SiteServiceStateHistory */
  type SiteServiceStateHistoryRow = HCons[java.sql.Timestamp,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[java.sql.Time],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for SiteServiceStateHistoryRow providing default values if available in the database schema. */
  def SiteServiceStateHistoryRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], nodeId: Option[String], siteId: Option[String], vendorId: Option[String], priority: Option[Int], exclude: Option[Boolean], sticky: Option[Boolean], sector0State: Option[Int], sector1State: Option[Int], sector2State: Option[Int], sector3State: Option[Int], cell0State: Option[Int], cell1State: Option[Int], cell2State: Option[Int], cell3State: Option[Int], cell4State: Option[Int], cell5State: Option[Int], cell6State: Option[Int], cell7State: Option[Int], cell8State: Option[Int], cell9State: Option[Int], cell10State: Option[Int], cell11State: Option[Int], cell12State: Option[Int], cell13State: Option[Int], cell14State: Option[Int], cell15State: Option[Int], cell16State: Option[Int], cell17State: Option[Int], cell18State: Option[Int], cell19State: Option[Int], cell20State: Option[Int], cell21State: Option[Int], cell22State: Option[Int], cell23State: Option[Int], cell24State: Option[Int], cell25State: Option[Int], cell26State: Option[Int], cell27State: Option[Int], cell28State: Option[Int], cell29State: Option[Int], cell30State: Option[Int], cell31State: Option[Int], existCells: Option[Int], excludeCells: Option[Int], includeCells: Option[Int], unknownCells: Option[Int], knownCells: Option[Int], blockedCells: Option[Int], downCells: Option[Int], upCells: Option[Int], downtime: Option[java.sql.Time]): SiteServiceStateHistoryRow = {
    measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: priority :: exclude :: sticky :: sector0State :: sector1State :: sector2State :: sector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: existCells :: excludeCells :: includeCells :: unknownCells :: knownCells :: blockedCells :: downCells :: upCells :: downtime :: HNil
  }
  /** GetResult implicit for fetching SiteServiceStateHistoryRow objects using plain SQL queries */
  implicit def GetResultSiteServiceStateHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]], e4: GR[Option[java.sql.Time]]): GR[SiteServiceStateHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[java.sql.Time] :: HNil
  }
  /** Table description of table site_service_state_history. Objects of this class serve as prototypes for rows in queries. */
  class SiteServiceStateHistory(_tableTag: Tag) extends Table[SiteServiceStateHistoryRow](_tableTag, "site_service_state_history") {
    def * = measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: priority :: exclude :: sticky :: sector0State :: sector1State :: sector2State :: sector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: existCells :: excludeCells :: includeCells :: unknownCells :: knownCells :: blockedCells :: downCells :: upCells :: downtime :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column priority DBType(INT) */
    val priority: Column[Option[Int]] = column[Option[Int]]("priority")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Option[Boolean]] = column[Option[Boolean]]("exclude")
    /** Database column sticky DBType(BIT) */
    val sticky: Column[Option[Boolean]] = column[Option[Boolean]]("sticky")
    /** Database column sector_0_state DBType(INT) */
    val sector0State: Column[Option[Int]] = column[Option[Int]]("sector_0_state")
    /** Database column sector_1_state DBType(INT) */
    val sector1State: Column[Option[Int]] = column[Option[Int]]("sector_1_state")
    /** Database column sector_2_state DBType(INT) */
    val sector2State: Column[Option[Int]] = column[Option[Int]]("sector_2_state")
    /** Database column sector_3_state DBType(INT) */
    val sector3State: Column[Option[Int]] = column[Option[Int]]("sector_3_state")
    /** Database column cell_0_state DBType(INT) */
    val cell0State: Column[Option[Int]] = column[Option[Int]]("cell_0_state")
    /** Database column cell_1_state DBType(INT) */
    val cell1State: Column[Option[Int]] = column[Option[Int]]("cell_1_state")
    /** Database column cell_2_state DBType(INT) */
    val cell2State: Column[Option[Int]] = column[Option[Int]]("cell_2_state")
    /** Database column cell_3_state DBType(INT) */
    val cell3State: Column[Option[Int]] = column[Option[Int]]("cell_3_state")
    /** Database column cell_4_state DBType(INT) */
    val cell4State: Column[Option[Int]] = column[Option[Int]]("cell_4_state")
    /** Database column cell_5_state DBType(INT) */
    val cell5State: Column[Option[Int]] = column[Option[Int]]("cell_5_state")
    /** Database column cell_6_state DBType(INT) */
    val cell6State: Column[Option[Int]] = column[Option[Int]]("cell_6_state")
    /** Database column cell_7_state DBType(INT) */
    val cell7State: Column[Option[Int]] = column[Option[Int]]("cell_7_state")
    /** Database column cell_8_state DBType(INT) */
    val cell8State: Column[Option[Int]] = column[Option[Int]]("cell_8_state")
    /** Database column cell_9_state DBType(INT) */
    val cell9State: Column[Option[Int]] = column[Option[Int]]("cell_9_state")
    /** Database column cell_10_state DBType(INT) */
    val cell10State: Column[Option[Int]] = column[Option[Int]]("cell_10_state")
    /** Database column cell_11_state DBType(INT) */
    val cell11State: Column[Option[Int]] = column[Option[Int]]("cell_11_state")
    /** Database column cell_12_state DBType(INT) */
    val cell12State: Column[Option[Int]] = column[Option[Int]]("cell_12_state")
    /** Database column cell_13_state DBType(INT) */
    val cell13State: Column[Option[Int]] = column[Option[Int]]("cell_13_state")
    /** Database column cell_14_state DBType(INT) */
    val cell14State: Column[Option[Int]] = column[Option[Int]]("cell_14_state")
    /** Database column cell_15_state DBType(INT) */
    val cell15State: Column[Option[Int]] = column[Option[Int]]("cell_15_state")
    /** Database column cell_16_state DBType(INT) */
    val cell16State: Column[Option[Int]] = column[Option[Int]]("cell_16_state")
    /** Database column cell_17_state DBType(INT) */
    val cell17State: Column[Option[Int]] = column[Option[Int]]("cell_17_state")
    /** Database column cell_18_state DBType(INT) */
    val cell18State: Column[Option[Int]] = column[Option[Int]]("cell_18_state")
    /** Database column cell_19_state DBType(INT) */
    val cell19State: Column[Option[Int]] = column[Option[Int]]("cell_19_state")
    /** Database column cell_20_state DBType(INT) */
    val cell20State: Column[Option[Int]] = column[Option[Int]]("cell_20_state")
    /** Database column cell_21_state DBType(INT) */
    val cell21State: Column[Option[Int]] = column[Option[Int]]("cell_21_state")
    /** Database column cell_22_state DBType(INT) */
    val cell22State: Column[Option[Int]] = column[Option[Int]]("cell_22_state")
    /** Database column cell_23_state DBType(INT) */
    val cell23State: Column[Option[Int]] = column[Option[Int]]("cell_23_state")
    /** Database column cell_24_state DBType(INT) */
    val cell24State: Column[Option[Int]] = column[Option[Int]]("cell_24_state")
    /** Database column cell_25_state DBType(INT) */
    val cell25State: Column[Option[Int]] = column[Option[Int]]("cell_25_state")
    /** Database column cell_26_state DBType(INT) */
    val cell26State: Column[Option[Int]] = column[Option[Int]]("cell_26_state")
    /** Database column cell_27_state DBType(INT) */
    val cell27State: Column[Option[Int]] = column[Option[Int]]("cell_27_state")
    /** Database column cell_28_state DBType(INT) */
    val cell28State: Column[Option[Int]] = column[Option[Int]]("cell_28_state")
    /** Database column cell_29_state DBType(INT) */
    val cell29State: Column[Option[Int]] = column[Option[Int]]("cell_29_state")
    /** Database column cell_30_state DBType(INT) */
    val cell30State: Column[Option[Int]] = column[Option[Int]]("cell_30_state")
    /** Database column cell_31_state DBType(INT) */
    val cell31State: Column[Option[Int]] = column[Option[Int]]("cell_31_state")
    /** Database column exist_cells DBType(INT) */
    val existCells: Column[Option[Int]] = column[Option[Int]]("exist_cells")
    /** Database column exclude_cells DBType(INT) */
    val excludeCells: Column[Option[Int]] = column[Option[Int]]("exclude_cells")
    /** Database column include_cells DBType(INT) */
    val includeCells: Column[Option[Int]] = column[Option[Int]]("include_cells")
    /** Database column unknown_cells DBType(INT) */
    val unknownCells: Column[Option[Int]] = column[Option[Int]]("unknown_cells")
    /** Database column known_cells DBType(INT) */
    val knownCells: Column[Option[Int]] = column[Option[Int]]("known_cells")
    /** Database column blocked_cells DBType(INT) */
    val blockedCells: Column[Option[Int]] = column[Option[Int]]("blocked_cells")
    /** Database column down_cells DBType(INT) */
    val downCells: Column[Option[Int]] = column[Option[Int]]("down_cells")
    /** Database column up_cells DBType(INT) */
    val upCells: Column[Option[Int]] = column[Option[Int]]("up_cells")
    /** Database column downtime DBType(TIME) */
    val downtime: Column[Option[java.sql.Time]] = column[Option[java.sql.Time]]("downtime")
    
    /** Index over (siteId,groupId,measurementTime) (database name ranmateFemto_siteServiceStateHistory_Composite) */
    val index1 = index("ranmateFemto_siteServiceStateHistory_Composite", siteId :: groupId :: measurementTime :: HNil)
    /** Index over (blockedCells) (database name ranmateFemto_siteServiceStateHistory_blockedCells) */
    val index2 = index("ranmateFemto_siteServiceStateHistory_blockedCells", blockedCells :: HNil)
    /** Index over (downCells) (database name ranmateFemto_siteServiceStateHistory_downCells) */
    val index3 = index("ranmateFemto_siteServiceStateHistory_downCells", downCells :: HNil)
    /** Index over (generation) (database name ranmateFemto_siteServiceStateHistory_generation) */
    val index4 = index("ranmateFemto_siteServiceStateHistory_generation", generation :: HNil)
    /** Index over (groupId) (database name ranmateFemto_siteServiceStateHistory_groupId) */
    val index5 = index("ranmateFemto_siteServiceStateHistory_groupId", groupId :: HNil)
    /** Index over (measurementTime) (database name ranmateFemto_siteServiceStateHistory_measurementTime) */
    val index6 = index("ranmateFemto_siteServiceStateHistory_measurementTime", measurementTime :: HNil)
    /** Index over (siteId) (database name ranmateFemto_siteServiceStateHistory_siteId) */
    val index7 = index("ranmateFemto_siteServiceStateHistory_siteId", siteId :: HNil)
  }
  /** Collection-like TableQuery object for table SiteServiceStateHistory */
  lazy val SiteServiceStateHistory = new TableQuery(tag => new SiteServiceStateHistory(tag))
  
  /** Row type of table States */
  type StatesRow = HCons[java.sql.Timestamp,HCons[Int,HCons[Int,HCons[Option[String],HCons[java.sql.Timestamp,HCons[String,HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for StatesRow providing default values if available in the database schema. */
  def StatesRow(measurementTime: java.sql.Timestamp, measurementPeriod: Int, generation: Int, source: Option[String], stateTime: java.sql.Timestamp, siteId: String, groupId: Option[String], siteState: Option[String], information: Option[String], cell0State: Option[String], cell1State: Option[String], cell2State: Option[String], cell3State: Option[String], cell4State: Option[String], cell5State: Option[String], cell6State: Option[String], cell7State: Option[String], cell8State: Option[String], cell9State: Option[String], cell10State: Option[String], cell11State: Option[String], cell12State: Option[String], cell13State: Option[String], cell14State: Option[String], cell15State: Option[String], cell16State: Option[String], cell17State: Option[String], cell18State: Option[String], cell19State: Option[String], cell20State: Option[String], cell21State: Option[String], cell22State: Option[String], cell23State: Option[String], cell24State: Option[String], cell25State: Option[String], cell26State: Option[String], cell27State: Option[String], cell28State: Option[String], cell29State: Option[String], cell30State: Option[String], cell31State: Option[String]): StatesRow = {
    measurementTime :: measurementPeriod :: generation :: source :: stateTime :: siteId :: groupId :: siteState :: information :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: HNil
  }
  /** GetResult implicit for fetching StatesRow objects using plain SQL queries */
  implicit def GetResultStatesRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Int], e2: GR[Option[String]], e3: GR[String]): GR[StatesRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<[Int] :: <<[Int] :: <<?[String] :: <<[java.sql.Timestamp] :: <<[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: HNil
  }
  /** Table description of table states. Objects of this class serve as prototypes for rows in queries. */
  class States(_tableTag: Tag) extends Table[StatesRow](_tableTag, "states") {
    def * = measurementTime :: measurementPeriod :: generation :: source :: stateTime :: siteId :: groupId :: siteState :: information :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column measurement_period DBType(INT) */
    val measurementPeriod: Column[Int] = column[Int]("measurement_period")
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column source DBType(VARCHAR), Length(50,true) */
    val source: Column[Option[String]] = column[Option[String]]("source", O.Length(50,varying=true))
    /** Database column state_time DBType(TIMESTAMP) */
    val stateTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("state_time")
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_state DBType(VARCHAR), Length(15,true) */
    val siteState: Column[Option[String]] = column[Option[String]]("site_state", O.Length(15,varying=true))
    /** Database column information DBType(VARCHAR), Length(256,true) */
    val information: Column[Option[String]] = column[Option[String]]("information", O.Length(256,varying=true))
    /** Database column cell_0_state DBType(VARCHAR), Length(15,true) */
    val cell0State: Column[Option[String]] = column[Option[String]]("cell_0_state", O.Length(15,varying=true))
    /** Database column cell_1_state DBType(VARCHAR), Length(15,true) */
    val cell1State: Column[Option[String]] = column[Option[String]]("cell_1_state", O.Length(15,varying=true))
    /** Database column cell_2_state DBType(VARCHAR), Length(15,true) */
    val cell2State: Column[Option[String]] = column[Option[String]]("cell_2_state", O.Length(15,varying=true))
    /** Database column cell_3_state DBType(VARCHAR), Length(15,true) */
    val cell3State: Column[Option[String]] = column[Option[String]]("cell_3_state", O.Length(15,varying=true))
    /** Database column cell_4_state DBType(VARCHAR), Length(15,true) */
    val cell4State: Column[Option[String]] = column[Option[String]]("cell_4_state", O.Length(15,varying=true))
    /** Database column cell_5_state DBType(VARCHAR), Length(15,true) */
    val cell5State: Column[Option[String]] = column[Option[String]]("cell_5_state", O.Length(15,varying=true))
    /** Database column cell_6_state DBType(VARCHAR), Length(15,true) */
    val cell6State: Column[Option[String]] = column[Option[String]]("cell_6_state", O.Length(15,varying=true))
    /** Database column cell_7_state DBType(VARCHAR), Length(15,true) */
    val cell7State: Column[Option[String]] = column[Option[String]]("cell_7_state", O.Length(15,varying=true))
    /** Database column cell_8_state DBType(VARCHAR), Length(15,true) */
    val cell8State: Column[Option[String]] = column[Option[String]]("cell_8_state", O.Length(15,varying=true))
    /** Database column cell_9_state DBType(VARCHAR), Length(15,true) */
    val cell9State: Column[Option[String]] = column[Option[String]]("cell_9_state", O.Length(15,varying=true))
    /** Database column cell_10_state DBType(VARCHAR), Length(15,true) */
    val cell10State: Column[Option[String]] = column[Option[String]]("cell_10_state", O.Length(15,varying=true))
    /** Database column cell_11_state DBType(VARCHAR), Length(15,true) */
    val cell11State: Column[Option[String]] = column[Option[String]]("cell_11_state", O.Length(15,varying=true))
    /** Database column cell_12_state DBType(VARCHAR), Length(15,true) */
    val cell12State: Column[Option[String]] = column[Option[String]]("cell_12_state", O.Length(15,varying=true))
    /** Database column cell_13_state DBType(VARCHAR), Length(15,true) */
    val cell13State: Column[Option[String]] = column[Option[String]]("cell_13_state", O.Length(15,varying=true))
    /** Database column cell_14_state DBType(VARCHAR), Length(15,true) */
    val cell14State: Column[Option[String]] = column[Option[String]]("cell_14_state", O.Length(15,varying=true))
    /** Database column cell_15_state DBType(VARCHAR), Length(15,true) */
    val cell15State: Column[Option[String]] = column[Option[String]]("cell_15_state", O.Length(15,varying=true))
    /** Database column cell_16_state DBType(VARCHAR), Length(15,true) */
    val cell16State: Column[Option[String]] = column[Option[String]]("cell_16_state", O.Length(15,varying=true))
    /** Database column cell_17_state DBType(VARCHAR), Length(15,true) */
    val cell17State: Column[Option[String]] = column[Option[String]]("cell_17_state", O.Length(15,varying=true))
    /** Database column cell_18_state DBType(VARCHAR), Length(15,true) */
    val cell18State: Column[Option[String]] = column[Option[String]]("cell_18_state", O.Length(15,varying=true))
    /** Database column cell_19_state DBType(VARCHAR), Length(15,true) */
    val cell19State: Column[Option[String]] = column[Option[String]]("cell_19_state", O.Length(15,varying=true))
    /** Database column cell_20_state DBType(VARCHAR), Length(15,true) */
    val cell20State: Column[Option[String]] = column[Option[String]]("cell_20_state", O.Length(15,varying=true))
    /** Database column cell_21_state DBType(VARCHAR), Length(15,true) */
    val cell21State: Column[Option[String]] = column[Option[String]]("cell_21_state", O.Length(15,varying=true))
    /** Database column cell_22_state DBType(VARCHAR), Length(15,true) */
    val cell22State: Column[Option[String]] = column[Option[String]]("cell_22_state", O.Length(15,varying=true))
    /** Database column cell_23_state DBType(VARCHAR), Length(15,true) */
    val cell23State: Column[Option[String]] = column[Option[String]]("cell_23_state", O.Length(15,varying=true))
    /** Database column cell_24_state DBType(VARCHAR), Length(15,true) */
    val cell24State: Column[Option[String]] = column[Option[String]]("cell_24_state", O.Length(15,varying=true))
    /** Database column cell_25_state DBType(VARCHAR), Length(15,true) */
    val cell25State: Column[Option[String]] = column[Option[String]]("cell_25_state", O.Length(15,varying=true))
    /** Database column cell_26_state DBType(VARCHAR), Length(15,true) */
    val cell26State: Column[Option[String]] = column[Option[String]]("cell_26_state", O.Length(15,varying=true))
    /** Database column cell_27_state DBType(VARCHAR), Length(15,true) */
    val cell27State: Column[Option[String]] = column[Option[String]]("cell_27_state", O.Length(15,varying=true))
    /** Database column cell_28_state DBType(VARCHAR), Length(15,true) */
    val cell28State: Column[Option[String]] = column[Option[String]]("cell_28_state", O.Length(15,varying=true))
    /** Database column cell_29_state DBType(VARCHAR), Length(15,true) */
    val cell29State: Column[Option[String]] = column[Option[String]]("cell_29_state", O.Length(15,varying=true))
    /** Database column cell_30_state DBType(VARCHAR), Length(15,true) */
    val cell30State: Column[Option[String]] = column[Option[String]]("cell_30_state", O.Length(15,varying=true))
    /** Database column cell_31_state DBType(VARCHAR), Length(15,true) */
    val cell31State: Column[Option[String]] = column[Option[String]]("cell_31_state", O.Length(15,varying=true))
    
    /** Index over (generation) (database name ranmateFemto_states_generation) */
    val index1 = index("ranmateFemto_states_generation", generation :: HNil)
    /** Index over (groupId) (database name ranmateFemto_states_groupId) */
    val index2 = index("ranmateFemto_states_groupId", groupId :: HNil)
    /** Index over (measurementTime) (database name ranmateFemto_states_measurementTime) */
    val index3 = index("ranmateFemto_states_measurementTime", measurementTime :: HNil)
    /** Index over (siteId) (database name ranmateFemto_states_siteId) */
    val index4 = index("ranmateFemto_states_siteId", siteId :: HNil)
    /** Index over (siteState) (database name ranmateFemto_states_siteState) */
    val index5 = index("ranmateFemto_states_siteState", siteState :: HNil)
  }
  /** Collection-like TableQuery object for table States */
  lazy val States = new TableQuery(tag => new States(tag))
  
  /** Row type of table StatesTemp */
  type StatesTempRow = HCons[java.sql.Timestamp,HCons[Int,HCons[Int,HCons[Option[String],HCons[java.sql.Timestamp,HCons[String,HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for StatesTempRow providing default values if available in the database schema. */
  def StatesTempRow(measurementTime: java.sql.Timestamp, measurementPeriod: Int, generation: Int, source: Option[String], stateTime: java.sql.Timestamp, siteId: String, groupId: Option[String], siteState: Option[String], information: Option[String], cell0State: Option[String], cell1State: Option[String], cell2State: Option[String], cell3State: Option[String], cell4State: Option[String], cell5State: Option[String], cell6State: Option[String], cell7State: Option[String], cell8State: Option[String], cell9State: Option[String], cell10State: Option[String], cell11State: Option[String], cell12State: Option[String], cell13State: Option[String], cell14State: Option[String], cell15State: Option[String], cell16State: Option[String], cell17State: Option[String], cell18State: Option[String], cell19State: Option[String], cell20State: Option[String], cell21State: Option[String], cell22State: Option[String], cell23State: Option[String], cell24State: Option[String], cell25State: Option[String], cell26State: Option[String], cell27State: Option[String], cell28State: Option[String], cell29State: Option[String], cell30State: Option[String], cell31State: Option[String]): StatesTempRow = {
    measurementTime :: measurementPeriod :: generation :: source :: stateTime :: siteId :: groupId :: siteState :: information :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: HNil
  }
  /** GetResult implicit for fetching StatesTempRow objects using plain SQL queries */
  implicit def GetResultStatesTempRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Int], e2: GR[Option[String]], e3: GR[String]): GR[StatesTempRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<[Int] :: <<[Int] :: <<?[String] :: <<[java.sql.Timestamp] :: <<[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: HNil
  }
  /** Table description of table states_temp. Objects of this class serve as prototypes for rows in queries. */
  class StatesTemp(_tableTag: Tag) extends Table[StatesTempRow](_tableTag, "states_temp") {
    def * = measurementTime :: measurementPeriod :: generation :: source :: stateTime :: siteId :: groupId :: siteState :: information :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column measurement_period DBType(INT) */
    val measurementPeriod: Column[Int] = column[Int]("measurement_period")
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column source DBType(VARCHAR), Length(50,true) */
    val source: Column[Option[String]] = column[Option[String]]("source", O.Length(50,varying=true))
    /** Database column state_time DBType(TIMESTAMP) */
    val stateTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("state_time")
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_state DBType(VARCHAR), Length(15,true) */
    val siteState: Column[Option[String]] = column[Option[String]]("site_state", O.Length(15,varying=true))
    /** Database column information DBType(VARCHAR), Length(256,true) */
    val information: Column[Option[String]] = column[Option[String]]("information", O.Length(256,varying=true))
    /** Database column cell_0_state DBType(VARCHAR), Length(15,true) */
    val cell0State: Column[Option[String]] = column[Option[String]]("cell_0_state", O.Length(15,varying=true))
    /** Database column cell_1_state DBType(VARCHAR), Length(15,true) */
    val cell1State: Column[Option[String]] = column[Option[String]]("cell_1_state", O.Length(15,varying=true))
    /** Database column cell_2_state DBType(VARCHAR), Length(15,true) */
    val cell2State: Column[Option[String]] = column[Option[String]]("cell_2_state", O.Length(15,varying=true))
    /** Database column cell_3_state DBType(VARCHAR), Length(15,true) */
    val cell3State: Column[Option[String]] = column[Option[String]]("cell_3_state", O.Length(15,varying=true))
    /** Database column cell_4_state DBType(VARCHAR), Length(15,true) */
    val cell4State: Column[Option[String]] = column[Option[String]]("cell_4_state", O.Length(15,varying=true))
    /** Database column cell_5_state DBType(VARCHAR), Length(15,true) */
    val cell5State: Column[Option[String]] = column[Option[String]]("cell_5_state", O.Length(15,varying=true))
    /** Database column cell_6_state DBType(VARCHAR), Length(15,true) */
    val cell6State: Column[Option[String]] = column[Option[String]]("cell_6_state", O.Length(15,varying=true))
    /** Database column cell_7_state DBType(VARCHAR), Length(15,true) */
    val cell7State: Column[Option[String]] = column[Option[String]]("cell_7_state", O.Length(15,varying=true))
    /** Database column cell_8_state DBType(VARCHAR), Length(15,true) */
    val cell8State: Column[Option[String]] = column[Option[String]]("cell_8_state", O.Length(15,varying=true))
    /** Database column cell_9_state DBType(VARCHAR), Length(15,true) */
    val cell9State: Column[Option[String]] = column[Option[String]]("cell_9_state", O.Length(15,varying=true))
    /** Database column cell_10_state DBType(VARCHAR), Length(15,true) */
    val cell10State: Column[Option[String]] = column[Option[String]]("cell_10_state", O.Length(15,varying=true))
    /** Database column cell_11_state DBType(VARCHAR), Length(15,true) */
    val cell11State: Column[Option[String]] = column[Option[String]]("cell_11_state", O.Length(15,varying=true))
    /** Database column cell_12_state DBType(VARCHAR), Length(15,true) */
    val cell12State: Column[Option[String]] = column[Option[String]]("cell_12_state", O.Length(15,varying=true))
    /** Database column cell_13_state DBType(VARCHAR), Length(15,true) */
    val cell13State: Column[Option[String]] = column[Option[String]]("cell_13_state", O.Length(15,varying=true))
    /** Database column cell_14_state DBType(VARCHAR), Length(15,true) */
    val cell14State: Column[Option[String]] = column[Option[String]]("cell_14_state", O.Length(15,varying=true))
    /** Database column cell_15_state DBType(VARCHAR), Length(15,true) */
    val cell15State: Column[Option[String]] = column[Option[String]]("cell_15_state", O.Length(15,varying=true))
    /** Database column cell_16_state DBType(VARCHAR), Length(15,true) */
    val cell16State: Column[Option[String]] = column[Option[String]]("cell_16_state", O.Length(15,varying=true))
    /** Database column cell_17_state DBType(VARCHAR), Length(15,true) */
    val cell17State: Column[Option[String]] = column[Option[String]]("cell_17_state", O.Length(15,varying=true))
    /** Database column cell_18_state DBType(VARCHAR), Length(15,true) */
    val cell18State: Column[Option[String]] = column[Option[String]]("cell_18_state", O.Length(15,varying=true))
    /** Database column cell_19_state DBType(VARCHAR), Length(15,true) */
    val cell19State: Column[Option[String]] = column[Option[String]]("cell_19_state", O.Length(15,varying=true))
    /** Database column cell_20_state DBType(VARCHAR), Length(15,true) */
    val cell20State: Column[Option[String]] = column[Option[String]]("cell_20_state", O.Length(15,varying=true))
    /** Database column cell_21_state DBType(VARCHAR), Length(15,true) */
    val cell21State: Column[Option[String]] = column[Option[String]]("cell_21_state", O.Length(15,varying=true))
    /** Database column cell_22_state DBType(VARCHAR), Length(15,true) */
    val cell22State: Column[Option[String]] = column[Option[String]]("cell_22_state", O.Length(15,varying=true))
    /** Database column cell_23_state DBType(VARCHAR), Length(15,true) */
    val cell23State: Column[Option[String]] = column[Option[String]]("cell_23_state", O.Length(15,varying=true))
    /** Database column cell_24_state DBType(VARCHAR), Length(15,true) */
    val cell24State: Column[Option[String]] = column[Option[String]]("cell_24_state", O.Length(15,varying=true))
    /** Database column cell_25_state DBType(VARCHAR), Length(15,true) */
    val cell25State: Column[Option[String]] = column[Option[String]]("cell_25_state", O.Length(15,varying=true))
    /** Database column cell_26_state DBType(VARCHAR), Length(15,true) */
    val cell26State: Column[Option[String]] = column[Option[String]]("cell_26_state", O.Length(15,varying=true))
    /** Database column cell_27_state DBType(VARCHAR), Length(15,true) */
    val cell27State: Column[Option[String]] = column[Option[String]]("cell_27_state", O.Length(15,varying=true))
    /** Database column cell_28_state DBType(VARCHAR), Length(15,true) */
    val cell28State: Column[Option[String]] = column[Option[String]]("cell_28_state", O.Length(15,varying=true))
    /** Database column cell_29_state DBType(VARCHAR), Length(15,true) */
    val cell29State: Column[Option[String]] = column[Option[String]]("cell_29_state", O.Length(15,varying=true))
    /** Database column cell_30_state DBType(VARCHAR), Length(15,true) */
    val cell30State: Column[Option[String]] = column[Option[String]]("cell_30_state", O.Length(15,varying=true))
    /** Database column cell_31_state DBType(VARCHAR), Length(15,true) */
    val cell31State: Column[Option[String]] = column[Option[String]]("cell_31_state", O.Length(15,varying=true))
  }
  /** Collection-like TableQuery object for table StatesTemp */
  lazy val StatesTemp = new TableQuery(tag => new StatesTemp(tag))
  
  /** Entity class storing rows of table Tickets
   *  @param ticketId Database column ticket_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellId Database column cell_id DBType(VARCHAR), Length(20,true)
   *  @param priority Database column priority DBType(VARCHAR), Length(20,true)
   *  @param status Database column status DBType(VARCHAR), Length(50,true)
   *  @param statusTimestamp Database column status_timestamp DBType(TIMESTAMP)
   *  @param openTimestamp Database column open_timestamp DBType(TIMESTAMP)
   *  @param closeTimestamp Database column close_timestamp DBType(TIMESTAMP)
   *  @param department Database column department DBType(VARCHAR), Length(256,true)
   *  @param owner Database column owner DBType(VARCHAR), Length(256,true)
   *  @param source Database column source DBType(VARCHAR), Length(50,true)
   *  @param notes Database column notes DBType(VARCHAR), Length(4096,true) */
  case class TicketsRow(ticketId: String, groupId: String, siteId: String, cellId: Option[String], priority: String, status: String, statusTimestamp: java.sql.Timestamp, openTimestamp: java.sql.Timestamp, closeTimestamp: java.sql.Timestamp, department: Option[String], owner: Option[String], source: Option[String], notes: String)
  /** GetResult implicit for fetching TicketsRow objects using plain SQL queries */
  implicit def GetResultTicketsRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[TicketsRow] = GR{
    prs => import prs._
    TicketsRow.tupled((<<[String], <<[String], <<[String], <<?[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<[String]))
  }
  /** Table description of table tickets. Objects of this class serve as prototypes for rows in queries. */
  class Tickets(_tableTag: Tag) extends Table[TicketsRow](_tableTag, "tickets") {
    def * = (ticketId, groupId, siteId, cellId, priority, status, statusTimestamp, openTimestamp, closeTimestamp, department, owner, source, notes) <> (TicketsRow.tupled, TicketsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (ticketId.?, groupId.?, siteId.?, cellId, priority.?, status.?, statusTimestamp.?, openTimestamp.?, closeTimestamp.?, department, owner, source, notes.?).shaped.<>({r=>import r._; _1.map(_=> TicketsRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get, _7.get, _8.get, _9.get, _10, _11, _12, _13.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column ticket_id DBType(VARCHAR), Length(50,true) */
    val ticketId: Column[String] = column[String]("ticket_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column cell_id DBType(VARCHAR), Length(20,true) */
    val cellId: Column[Option[String]] = column[Option[String]]("cell_id", O.Length(20,varying=true))
    /** Database column priority DBType(VARCHAR), Length(20,true) */
    val priority: Column[String] = column[String]("priority", O.Length(20,varying=true))
    /** Database column status DBType(VARCHAR), Length(50,true) */
    val status: Column[String] = column[String]("status", O.Length(50,varying=true))
    /** Database column status_timestamp DBType(TIMESTAMP) */
    val statusTimestamp: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("status_timestamp")
    /** Database column open_timestamp DBType(TIMESTAMP) */
    val openTimestamp: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("open_timestamp")
    /** Database column close_timestamp DBType(TIMESTAMP) */
    val closeTimestamp: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("close_timestamp")
    /** Database column department DBType(VARCHAR), Length(256,true) */
    val department: Column[Option[String]] = column[Option[String]]("department", O.Length(256,varying=true))
    /** Database column owner DBType(VARCHAR), Length(256,true) */
    val owner: Column[Option[String]] = column[Option[String]]("owner", O.Length(256,varying=true))
    /** Database column source DBType(VARCHAR), Length(50,true) */
    val source: Column[Option[String]] = column[Option[String]]("source", O.Length(50,varying=true))
    /** Database column notes DBType(VARCHAR), Length(4096,true) */
    val notes: Column[String] = column[String]("notes", O.Length(4096,varying=true))
    
    /** Index over (siteId) (database name ranmateFemto_tickets_siteId) */
    val index1 = index("ranmateFemto_tickets_siteId", siteId)
  }
  /** Collection-like TableQuery object for table Tickets */
  lazy val Tickets = new TableQuery(tag => new Tickets(tag))
  
  /** Entity class storing rows of table Token
   *  @param token Database column token DBType(VARCHAR), PrimaryKey, Length(255,true)
   *  @param userId Database column user_id DBType(INT)
   *  @param tokenType Database column token_type DBType(VARCHAR), Length(255,true)
   *  @param dateCreation Database column date_creation DBType(TIMESTAMP)
   *  @param email Database column email DBType(VARCHAR), Length(255,true) */
  case class TokenRow(token: String, userId: Option[Int], tokenType: Option[String], dateCreation: java.sql.Timestamp, email: Option[String])
  /** GetResult implicit for fetching TokenRow objects using plain SQL queries */
  implicit def GetResultTokenRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[TokenRow] = GR{
    prs => import prs._
    TokenRow.tupled((<<[String], <<?[Int], <<?[String], <<[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table token. Objects of this class serve as prototypes for rows in queries. */
  class Token(_tableTag: Tag) extends Table[TokenRow](_tableTag, "token") {
    def * = (token, userId, tokenType, dateCreation, email) <> (TokenRow.tupled, TokenRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (token.?, userId, tokenType, dateCreation.?, email).shaped.<>({r=>import r._; _1.map(_=> TokenRow.tupled((_1.get, _2, _3, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column token DBType(VARCHAR), PrimaryKey, Length(255,true) */
    val token: Column[String] = column[String]("token", O.PrimaryKey, O.Length(255,varying=true))
    /** Database column user_id DBType(INT) */
    val userId: Column[Option[Int]] = column[Option[Int]]("user_id")
    /** Database column token_type DBType(VARCHAR), Length(255,true) */
    val tokenType: Column[Option[String]] = column[Option[String]]("token_type", O.Length(255,varying=true))
    /** Database column date_creation DBType(TIMESTAMP) */
    val dateCreation: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("date_creation")
    /** Database column email DBType(VARCHAR), Length(255,true) */
    val email: Column[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true))
  }
  /** Collection-like TableQuery object for table Token */
  lazy val Token = new TableQuery(tag => new Token(tag))
  
  /** Entity class storing rows of table User
   *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
   *  @param email Database column email DBType(VARCHAR), Length(255,true)
   *  @param fullname Database column fullname DBType(VARCHAR), Length(255,true)
   *  @param confirmationToken Database column confirmation_token DBType(VARCHAR), Length(255,true)
   *  @param passwordHash Database column password_hash DBType(VARCHAR), Length(255,true)
   *  @param dateCreation Database column date_creation DBType(TIMESTAMP)
   *  @param validated Database column validated DBType(BIT)
   *  @param role Database column role DBType(VARCHAR), Length(255,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(255,true) */
  case class UserRow(id: Int, email: Option[String], fullname: Option[String], confirmationToken: Option[String], passwordHash: Option[String], dateCreation: java.sql.Timestamp, validated: Option[Boolean], role: Option[String], groupId: Option[String])
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[java.sql.Timestamp], e3: GR[Option[Boolean]]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<[java.sql.Timestamp], <<?[Boolean], <<?[String], <<?[String]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends Table[UserRow](_tableTag, "user") {
    def * = (id, email, fullname, confirmationToken, passwordHash, dateCreation, validated, role, groupId) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, email, fullname, confirmationToken, passwordHash, dateCreation.?, validated, role, groupId).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2, _3, _4, _5, _6.get, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column email DBType(VARCHAR), Length(255,true) */
    val email: Column[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true))
    /** Database column fullname DBType(VARCHAR), Length(255,true) */
    val fullname: Column[Option[String]] = column[Option[String]]("fullname", O.Length(255,varying=true))
    /** Database column confirmation_token DBType(VARCHAR), Length(255,true) */
    val confirmationToken: Column[Option[String]] = column[Option[String]]("confirmation_token", O.Length(255,varying=true))
    /** Database column password_hash DBType(VARCHAR), Length(255,true) */
    val passwordHash: Column[Option[String]] = column[Option[String]]("password_hash", O.Length(255,varying=true))
    /** Database column date_creation DBType(TIMESTAMP) */
    val dateCreation: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("date_creation")
    /** Database column validated DBType(BIT) */
    val validated: Column[Option[Boolean]] = column[Option[Boolean]]("validated")
    /** Database column role DBType(VARCHAR), Length(255,true) */
    val role: Column[Option[String]] = column[Option[String]]("role", O.Length(255,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(255,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(255,varying=true))
    
    /** Uniqueness Index over (email) (database name uq_user_email) */
    val index1 = index("uq_user_email", email, unique=true)
    /** Uniqueness Index over (fullname) (database name uq_user_fullname) */
    val index2 = index("uq_user_fullname", fullname, unique=true)
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
  
  /** Entity class storing rows of table VAllCells
   *  @param cellNo Database column cell_no DBType(INT), Default(0)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param generation Database column generation DBType(INT)
   *  @param exist Database column exist DBType(BIT)
   *  @param exclude Database column exclude DBType(BIT)
   *  @param sticky Database column sticky DBType(BIT)
   *  @param effectiveFrom Database column effective_from DBType(TIMESTAMP)
   *  @param effectiveTo Database column effective_to DBType(TIMESTAMP) */
  case class VAllCellsRow(cellNo: Int = 0, siteId: String, groupId: String, generation: Int, exist: Boolean, exclude: Boolean, sticky: Boolean, effectiveFrom: java.sql.Timestamp, effectiveTo: java.sql.Timestamp)
  /** GetResult implicit for fetching VAllCellsRow objects using plain SQL queries */
  implicit def GetResultVAllCellsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean], e3: GR[java.sql.Timestamp]): GR[VAllCellsRow] = GR{
    prs => import prs._
    VAllCellsRow.tupled((<<[Int], <<[String], <<[String], <<[Int], <<[Boolean], <<[Boolean], <<[Boolean], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table v_all_cells. Objects of this class serve as prototypes for rows in queries. */
  class VAllCells(_tableTag: Tag) extends Table[VAllCellsRow](_tableTag, "v_all_cells") {
    def * = (cellNo, siteId, groupId, generation, exist, exclude, sticky, effectiveFrom, effectiveTo) <> (VAllCellsRow.tupled, VAllCellsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (cellNo.?, siteId.?, groupId.?, generation.?, exist.?, exclude.?, sticky.?, effectiveFrom.?, effectiveTo.?).shaped.<>({r=>import r._; _1.map(_=> VAllCellsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column cell_no DBType(INT), Default(0) */
    val cellNo: Column[Int] = column[Int]("cell_no", O.Default(0))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column exist DBType(BIT) */
    val exist: Column[Boolean] = column[Boolean]("exist")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Boolean] = column[Boolean]("exclude")
    /** Database column sticky DBType(BIT) */
    val sticky: Column[Boolean] = column[Boolean]("sticky")
    /** Database column effective_from DBType(TIMESTAMP) */
    val effectiveFrom: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_from")
    /** Database column effective_to DBType(TIMESTAMP) */
    val effectiveTo: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_to")
  }
  /** Collection-like TableQuery object for table VAllCells */
  lazy val VAllCells = new TableQuery(tag => new VAllCells(tag))
  
  /** Entity class storing rows of table VAllSites
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param generation Database column generation DBType(INT)
   *  @param exclude Database column exclude DBType(BIT)
   *  @param sticky Database column sticky DBType(BIT)
   *  @param priority Database column priority DBType(INT), Default(99)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param effectiveFrom Database column effective_from DBType(TIMESTAMP)
   *  @param effectiveTo Database column effective_to DBType(TIMESTAMP) */
  case class VAllSitesRow(siteId: String, nodeId: Option[String], groupId: String, generation: Int, exclude: Boolean, sticky: Boolean, priority: Int = 99, vendorId: String, effectiveFrom: java.sql.Timestamp, effectiveTo: java.sql.Timestamp)
  /** GetResult implicit for fetching VAllSitesRow objects using plain SQL queries */
  implicit def GetResultVAllSitesRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Int], e3: GR[Boolean], e4: GR[java.sql.Timestamp]): GR[VAllSitesRow] = GR{
    prs => import prs._
    VAllSitesRow.tupled((<<[String], <<?[String], <<[String], <<[Int], <<[Boolean], <<[Boolean], <<[Int], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table v_all_sites. Objects of this class serve as prototypes for rows in queries. */
  class VAllSites(_tableTag: Tag) extends Table[VAllSitesRow](_tableTag, "v_all_sites") {
    def * = (siteId, nodeId, groupId, generation, exclude, sticky, priority, vendorId, effectiveFrom, effectiveTo) <> (VAllSitesRow.tupled, VAllSitesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (siteId.?, nodeId, groupId.?, generation.?, exclude.?, sticky.?, priority.?, vendorId.?, effectiveFrom.?, effectiveTo.?).shaped.<>({r=>import r._; _1.map(_=> VAllSitesRow.tupled((_1.get, _2, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Boolean] = column[Boolean]("exclude")
    /** Database column sticky DBType(BIT) */
    val sticky: Column[Boolean] = column[Boolean]("sticky")
    /** Database column priority DBType(INT), Default(99) */
    val priority: Column[Int] = column[Int]("priority", O.Default(99))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[String] = column[String]("vendor_id", O.Length(50,varying=true))
    /** Database column effective_from DBType(TIMESTAMP) */
    val effectiveFrom: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_from")
    /** Database column effective_to DBType(TIMESTAMP) */
    val effectiveTo: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_to")
  }
  /** Collection-like TableQuery object for table VAllSites */
  lazy val VAllSites = new TableQuery(tag => new VAllSites(tag))
  
  /** Entity class storing rows of table VCellDowntime
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param downtime Database column downtime DBType(VARCHAR), Length(10,true) */
  case class VCellDowntimeRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], cellNo: Option[Int], downtime: Option[String])
  /** GetResult implicit for fetching VCellDowntimeRow objects using plain SQL queries */
  implicit def GetResultVCellDowntimeRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[VCellDowntimeRow] = GR{
    prs => import prs._
    VCellDowntimeRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table v_cell_downtime. Objects of this class serve as prototypes for rows in queries. */
  class VCellDowntime(_tableTag: Tag) extends Table[VCellDowntimeRow](_tableTag, "v_cell_downtime") {
    def * = (measurementTime, generation, groupId, siteId, cellNo, downtime) <> (VCellDowntimeRow.tupled, VCellDowntimeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, cellNo, downtime).shaped.<>({r=>import r._; _1.map(_=> VCellDowntimeRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column downtime DBType(VARCHAR), Length(10,true) */
    val downtime: Column[Option[String]] = column[Option[String]]("downtime", O.Length(10,varying=true))
  }
  /** Collection-like TableQuery object for table VCellDowntime */
  lazy val VCellDowntime = new TableQuery(tag => new VCellDowntime(tag))
  
  /** Entity class storing rows of table VCellGenerationNo
   *  @param generation Database column generation DBType(BIGINT), Default(0)
   *  @param cellNo Database column cell_no DBType(BIGINT), Default(0)
   *  @param sectorNo Database column sector_no DBType(BIGINT)
   *  @param cellId Database column cell_id DBType(BINARY) */
  case class VCellGenerationNoRow(generation: Long = 0L, cellNo: Long = 0L, sectorNo: Option[Long], cellId: Option[java.sql.Blob])
  /** GetResult implicit for fetching VCellGenerationNoRow objects using plain SQL queries */
  implicit def GetResultVCellGenerationNoRow(implicit e0: GR[Long], e1: GR[Option[Long]], e2: GR[Option[java.sql.Blob]]): GR[VCellGenerationNoRow] = GR{
    prs => import prs._
    VCellGenerationNoRow.tupled((<<[Long], <<[Long], <<?[Long], <<?[java.sql.Blob]))
  }
  /** Table description of table v_cell_generation_no. Objects of this class serve as prototypes for rows in queries. */
  class VCellGenerationNo(_tableTag: Tag) extends Table[VCellGenerationNoRow](_tableTag, "v_cell_generation_no") {
    def * = (generation, cellNo, sectorNo, cellId) <> (VCellGenerationNoRow.tupled, VCellGenerationNoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (generation.?, cellNo.?, sectorNo, cellId).shaped.<>({r=>import r._; _1.map(_=> VCellGenerationNoRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column generation DBType(BIGINT), Default(0) */
    val generation: Column[Long] = column[Long]("generation", O.Default(0L))
    /** Database column cell_no DBType(BIGINT), Default(0) */
    val cellNo: Column[Long] = column[Long]("cell_no", O.Default(0L))
    /** Database column sector_no DBType(BIGINT) */
    val sectorNo: Column[Option[Long]] = column[Option[Long]]("sector_no")
    /** Database column cell_id DBType(BINARY) */
    val cellId: Column[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("cell_id")
  }
  /** Collection-like TableQuery object for table VCellGenerationNo */
  lazy val VCellGenerationNo = new TableQuery(tag => new VCellGenerationNo(tag))
  
  /** Entity class storing rows of table VCellNo
   *  @param cellNo Database column cell_no DBType(BIGINT), Default(0) */
  case class VCellNoRow(cellNo: Long = 0L)
  /** GetResult implicit for fetching VCellNoRow objects using plain SQL queries */
  implicit def GetResultVCellNoRow(implicit e0: GR[Long]): GR[VCellNoRow] = GR{
    prs => import prs._
    VCellNoRow(<<[Long])
  }
  /** Table description of table v_cell_no. Objects of this class serve as prototypes for rows in queries. */
  class VCellNo(_tableTag: Tag) extends Table[VCellNoRow](_tableTag, "v_cell_no") {
    def * = cellNo <> (VCellNoRow, VCellNoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = cellNo.?.shaped.<>(r => r.map(_=> VCellNoRow(r.get)), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column cell_no DBType(BIGINT), Default(0) */
    val cellNo: Column[Long] = column[Long]("cell_no", O.Default(0L))
  }
  /** Collection-like TableQuery object for table VCellNo */
  lazy val VCellNo = new TableQuery(tag => new VCellNo(tag))
  
  /** Entity class storing rows of table VCellState
   *  @param measurementTime Database column measurement_time DBType(DATETIME)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param priority Database column priority DBType(BIGINT), Default(0)
   *  @param siteExclude Database column site_exclude DBType(INT), Default(0)
   *  @param siteSticky Database column site_sticky DBType(INT), Default(0)
   *  @param sectorNo Database column sector_no DBType(INT)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param cellExist Database column cell_exist DBType(INT), Default(0)
   *  @param cellExclude Database column cell_exclude DBType(INT), Default(0)
   *  @param cellSticky Database column cell_sticky DBType(INT), Default(0)
   *  @param cellState Database column cell_state DBType(INT) */
  case class VCellStateRow(measurementTime: Option[java.sql.Timestamp], generation: Int, groupId: String, nodeId: Option[String], siteId: String, vendorId: String, priority: Long = 0L, siteExclude: Int = 0, siteSticky: Int = 0, sectorNo: Int, cellNo: Int, cellExist: Int = 0, cellExclude: Int = 0, cellSticky: Int = 0, cellState: Option[Int])
  /** GetResult implicit for fetching VCellStateRow objects using plain SQL queries */
  implicit def GetResultVCellStateRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Int], e2: GR[String], e3: GR[Option[String]], e4: GR[Long], e5: GR[Option[Int]]): GR[VCellStateRow] = GR{
    prs => import prs._
    VCellStateRow.tupled((<<?[java.sql.Timestamp], <<[Int], <<[String], <<?[String], <<[String], <<[String], <<[Long], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<?[Int]))
  }
  /** Table description of table v_cell_state. Objects of this class serve as prototypes for rows in queries. */
  class VCellState(_tableTag: Tag) extends Table[VCellStateRow](_tableTag, "v_cell_state") {
    def * = (measurementTime, generation, groupId, nodeId, siteId, vendorId, priority, siteExclude, siteSticky, sectorNo, cellNo, cellExist, cellExclude, cellSticky, cellState) <> (VCellStateRow.tupled, VCellStateRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime, generation.?, groupId.?, nodeId, siteId.?, vendorId.?, priority.?, siteExclude.?, siteSticky.?, sectorNo.?, cellNo.?, cellExist.?, cellExclude.?, cellSticky.?, cellState).shaped.<>({r=>import r._; _2.map(_=> VCellStateRow.tupled((_1, _2.get, _3.get, _4, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(DATETIME) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[String] = column[String]("vendor_id", O.Length(50,varying=true))
    /** Database column priority DBType(BIGINT), Default(0) */
    val priority: Column[Long] = column[Long]("priority", O.Default(0L))
    /** Database column site_exclude DBType(INT), Default(0) */
    val siteExclude: Column[Int] = column[Int]("site_exclude", O.Default(0))
    /** Database column site_sticky DBType(INT), Default(0) */
    val siteSticky: Column[Int] = column[Int]("site_sticky", O.Default(0))
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Int] = column[Int]("sector_no")
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Int] = column[Int]("cell_no")
    /** Database column cell_exist DBType(INT), Default(0) */
    val cellExist: Column[Int] = column[Int]("cell_exist", O.Default(0))
    /** Database column cell_exclude DBType(INT), Default(0) */
    val cellExclude: Column[Int] = column[Int]("cell_exclude", O.Default(0))
    /** Database column cell_sticky DBType(INT), Default(0) */
    val cellSticky: Column[Int] = column[Int]("cell_sticky", O.Default(0))
    /** Database column cell_state DBType(INT) */
    val cellState: Column[Option[Int]] = column[Option[Int]]("cell_state")
  }
  /** Collection-like TableQuery object for table VCellState */
  lazy val VCellState = new TableQuery(tag => new VCellState(tag))
  
  /** Entity class storing rows of table VCellUptime
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param cellState Database column cell_state DBType(INT) */
  case class VCellUptimeRow(measurementTime: Option[java.sql.Timestamp], generation: Option[Int], groupId: Option[String], siteId: Option[String], cellNo: Option[Int], cellState: Option[Int])
  /** GetResult implicit for fetching VCellUptimeRow objects using plain SQL queries */
  implicit def GetResultVCellUptimeRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[VCellUptimeRow] = GR{
    prs => import prs._
    VCellUptimeRow.tupled((<<?[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table v_cell_uptime. Objects of this class serve as prototypes for rows in queries. */
  class VCellUptime(_tableTag: Tag) extends Table[VCellUptimeRow](_tableTag, "v_cell_uptime") {
    def * = (measurementTime, generation, groupId, siteId, cellNo, cellState) <> (VCellUptimeRow.tupled, VCellUptimeRow.unapply)
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column cell_state DBType(INT) */
    val cellState: Column[Option[Int]] = column[Option[Int]]("cell_state")
  }
  /** Collection-like TableQuery object for table VCellUptime */
  lazy val VCellUptime = new TableQuery(tag => new VCellUptime(tag))
  
  /** Entity class storing rows of table VCurrentCounters
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param generation Database column generation DBType(INT)
   *  @param unknownCells Database column unknown_cells DBType(BIGINT)
   *  @param knownCells Database column known_cells DBType(BIGINT)
   *  @param blockedCells Database column blocked_cells DBType(BIGINT)
   *  @param downCells Database column down_cells DBType(BIGINT)
   *  @param upCells Database column up_cells DBType(BIGINT)
   *  @param sectorNo Database column sector_no DBType(INT) */
  case class VCurrentCountersRow(measurementTime: java.sql.Timestamp, groupId: Option[String], generation: Option[Int], unknownCells: Option[Long], knownCells: Option[Long], blockedCells: Option[Long], downCells: Option[Long], upCells: Option[Long], sectorNo: Option[Int])
  /** GetResult implicit for fetching VCurrentCountersRow objects using plain SQL queries */
  implicit def GetResultVCurrentCountersRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Long]]): GR[VCurrentCountersRow] = GR{
    prs => import prs._
    VCurrentCountersRow.tupled((<<[java.sql.Timestamp], <<?[String], <<?[Int], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Int]))
  }
  /** Table description of table v_current_counters. Objects of this class serve as prototypes for rows in queries. */
  class VCurrentCounters(_tableTag: Tag) extends Table[VCurrentCountersRow](_tableTag, "v_current_counters") {
    def * = (measurementTime, groupId, generation, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo) <> (VCurrentCountersRow.tupled, VCurrentCountersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, groupId, generation, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo).shaped.<>({r=>import r._; _1.map(_=> VCurrentCountersRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column unknown_cells DBType(BIGINT) */
    val unknownCells: Column[Option[Long]] = column[Option[Long]]("unknown_cells")
    /** Database column known_cells DBType(BIGINT) */
    val knownCells: Column[Option[Long]] = column[Option[Long]]("known_cells")
    /** Database column blocked_cells DBType(BIGINT) */
    val blockedCells: Column[Option[Long]] = column[Option[Long]]("blocked_cells")
    /** Database column down_cells DBType(BIGINT) */
    val downCells: Column[Option[Long]] = column[Option[Long]]("down_cells")
    /** Database column up_cells DBType(BIGINT) */
    val upCells: Column[Option[Long]] = column[Option[Long]]("up_cells")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VCurrentCounters */
  lazy val VCurrentCounters = new TableQuery(tag => new VCurrentCounters(tag))
  
  /** Entity class storing rows of table VCurrentFileTimes
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param ticketTime Database column ticket_time DBType(DATETIME)
   *  @param inventoryTime Database column inventory_time DBType(DATETIME) */
  case class VCurrentFileTimesRow(groupId: Option[String], ticketTime: Option[java.sql.Timestamp], inventoryTime: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching VCurrentFileTimesRow objects using plain SQL queries */
  implicit def GetResultVCurrentFileTimesRow(implicit e0: GR[Option[String]], e1: GR[Option[java.sql.Timestamp]]): GR[VCurrentFileTimesRow] = GR{
    prs => import prs._
    VCurrentFileTimesRow.tupled((<<?[String], <<?[java.sql.Timestamp], <<?[java.sql.Timestamp]))
  }
  /** Table description of table v_current_file_times. Objects of this class serve as prototypes for rows in queries. */
  class VCurrentFileTimes(_tableTag: Tag) extends Table[VCurrentFileTimesRow](_tableTag, "v_current_file_times") {
    def * = (groupId, ticketTime, inventoryTime) <> (VCurrentFileTimesRow.tupled, VCurrentFileTimesRow.unapply)
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column ticket_time DBType(DATETIME) */
    val ticketTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("ticket_time")
    /** Database column inventory_time DBType(DATETIME) */
    val inventoryTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("inventory_time")
  }
  /** Collection-like TableQuery object for table VCurrentFileTimes */
  lazy val VCurrentFileTimes = new TableQuery(tag => new VCurrentFileTimes(tag))
  
  /** Entity class storing rows of table VCurrentKpi
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param cisKpi Database column cis_kpi DBType(DECIMAL) */
  case class VCurrentKpiRow(measurementTime: Option[java.sql.Timestamp], generation: Option[Int], groupId: Option[String], cisKpi: Option[scala.math.BigDecimal])
  /** GetResult implicit for fetching VCurrentKpiRow objects using plain SQL queries */
  implicit def GetResultVCurrentKpiRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[scala.math.BigDecimal]]): GR[VCurrentKpiRow] = GR{
    prs => import prs._
    VCurrentKpiRow.tupled((<<?[java.sql.Timestamp], <<?[Int], <<?[String], <<?[scala.math.BigDecimal]))
  }
  /** Table description of table v_current_kpi. Objects of this class serve as prototypes for rows in queries. */
  class VCurrentKpi(_tableTag: Tag) extends Table[VCurrentKpiRow](_tableTag, "v_current_kpi") {
    def * = (measurementTime, generation, groupId, cisKpi) <> (VCurrentKpiRow.tupled, VCurrentKpiRow.unapply)
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column cis_kpi DBType(DECIMAL) */
    val cisKpi: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi")
  }
  /** Collection-like TableQuery object for table VCurrentKpi */
  lazy val VCurrentKpi = new TableQuery(tag => new VCurrentKpi(tag))
  
  /** Entity class storing rows of table VCurrentMeasurementTime
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(BIGINT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param sectorNo Database column sector_no DBType(INT) */
  case class VCurrentMeasurementTimeRow(measurementTime: Option[java.sql.Timestamp], generation: Option[Long], groupId: Option[String], sectorNo: Option[Int])
  /** GetResult implicit for fetching VCurrentMeasurementTimeRow objects using plain SQL queries */
  implicit def GetResultVCurrentMeasurementTimeRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[Long]], e2: GR[Option[String]], e3: GR[Option[Int]]): GR[VCurrentMeasurementTimeRow] = GR{
    prs => import prs._
    VCurrentMeasurementTimeRow.tupled((<<?[java.sql.Timestamp], <<?[Long], <<?[String], <<?[Int]))
  }
  /** Table description of table v_current_measurement_time. Objects of this class serve as prototypes for rows in queries. */
  class VCurrentMeasurementTime(_tableTag: Tag) extends Table[VCurrentMeasurementTimeRow](_tableTag, "v_current_measurement_time") {
    def * = (measurementTime, generation, groupId, sectorNo) <> (VCurrentMeasurementTimeRow.tupled, VCurrentMeasurementTimeRow.unapply)
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column generation DBType(BIGINT) */
    val generation: Column[Option[Long]] = column[Option[Long]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VCurrentMeasurementTime */
  lazy val VCurrentMeasurementTime = new TableQuery(tag => new VCurrentMeasurementTime(tag))
  
  /** Entity class storing rows of table VCurrentMeasurementTime2
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true) */
  case class VCurrentMeasurementTime2Row(measurementTime: Option[java.sql.Timestamp], generation: Option[Int], groupId: Option[String])
  /** GetResult implicit for fetching VCurrentMeasurementTime2Row objects using plain SQL queries */
  implicit def GetResultVCurrentMeasurementTime2Row(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[VCurrentMeasurementTime2Row] = GR{
    prs => import prs._
    VCurrentMeasurementTime2Row.tupled((<<?[java.sql.Timestamp], <<?[Int], <<?[String]))
  }
  /** Table description of table v_current_measurement_time2. Objects of this class serve as prototypes for rows in queries. */
  class VCurrentMeasurementTime2(_tableTag: Tag) extends Table[VCurrentMeasurementTime2Row](_tableTag, "v_current_measurement_time2") {
    def * = (measurementTime, generation, groupId) <> (VCurrentMeasurementTime2Row.tupled, VCurrentMeasurementTime2Row.unapply)
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
  }
  /** Collection-like TableQuery object for table VCurrentMeasurementTime2 */
  lazy val VCurrentMeasurementTime2 = new TableQuery(tag => new VCurrentMeasurementTime2(tag))
  
  /** Row type of table VCurrentPerformance */
  type VCurrentPerformanceRow = HCons[Option[String],HCons[Option[java.sql.Timestamp],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[java.sql.Timestamp],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[java.sql.Timestamp],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[java.sql.Timestamp],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[java.sql.Timestamp],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VCurrentPerformanceRow providing default values if available in the database schema. */
  def VCurrentPerformanceRow(groupId: Option[String], measurementTimeAll: Option[java.sql.Timestamp], unknownCellsAll: Option[Long], knownCellsAll: Option[Long], blockedCellsAll: Option[Long], downCellsAll: Option[Long], upCellsAll: Option[Long], cisKpiAll: Option[scala.math.BigDecimal], measurementTime4g: Option[java.sql.Timestamp], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long], cisKpi4g: Option[scala.math.BigDecimal], measurementTime3g: Option[java.sql.Timestamp], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], cisKpi3g: Option[scala.math.BigDecimal], measurementTime2g: Option[java.sql.Timestamp], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], cisKpi2g: Option[scala.math.BigDecimal], measurementTime1g: Option[java.sql.Timestamp], unknownCells1g: Option[Long], knownCells1g: Option[Long], blockedCells1g: Option[Long], downCells1g: Option[Long], upCells1g: Option[Long], cisKpi1g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VCurrentPerformanceRow = {
    groupId :: measurementTimeAll :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: measurementTime4g :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: measurementTime3g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: measurementTime2g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: measurementTime1g :: unknownCells1g :: knownCells1g :: blockedCells1g :: downCells1g :: upCells1g :: cisKpi1g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VCurrentPerformanceRow objects using plain SQL queries */
  implicit def GetResultVCurrentPerformanceRow(implicit e0: GR[Option[String]], e1: GR[Option[java.sql.Timestamp]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VCurrentPerformanceRow] = GR{
    prs => import prs._
    <<?[String] :: <<?[java.sql.Timestamp] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[java.sql.Timestamp] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[java.sql.Timestamp] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[java.sql.Timestamp] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[java.sql.Timestamp] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table v_current_performance. Objects of this class serve as prototypes for rows in queries. */
  class VCurrentPerformance(_tableTag: Tag) extends Table[VCurrentPerformanceRow](_tableTag, "v_current_performance") {
    def * = groupId :: measurementTimeAll :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: measurementTime4g :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: measurementTime3g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: measurementTime2g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: measurementTime1g :: unknownCells1g :: knownCells1g :: blockedCells1g :: downCells1g :: upCells1g :: cisKpi1g :: sectorNo :: HNil
    
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column measurement_time_all DBType(TIMESTAMP) */
    val measurementTimeAll: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time_all")
    /** Database column unknown_cells_all DBType(BIGINT) */
    val unknownCellsAll: Column[Option[Long]] = column[Option[Long]]("unknown_cells_all")
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column up_cells_all DBType(BIGINT) */
    val upCellsAll: Column[Option[Long]] = column[Option[Long]]("up_cells_all")
    /** Database column cis_kpi_all DBType(DECIMAL) */
    val cisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_all")
    /** Database column measurement_time_4g DBType(DATETIME) */
    val measurementTime4g: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time_4g")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column measurement_time_3g DBType(DATETIME) */
    val measurementTime3g: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time_3g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column measurement_time_2g DBType(DATETIME) */
    val measurementTime2g: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time_2g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column measurement_time_1g DBType(DATETIME) */
    val measurementTime1g: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time_1g")
    /** Database column unknown_cells_1g DBType(BIGINT) */
    val unknownCells1g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_1g")
    /** Database column known_cells_1g DBType(BIGINT) */
    val knownCells1g: Column[Option[Long]] = column[Option[Long]]("known_cells_1g")
    /** Database column blocked_cells_1g DBType(BIGINT) */
    val blockedCells1g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_1g")
    /** Database column down_cells_1g DBType(BIGINT) */
    val downCells1g: Column[Option[Long]] = column[Option[Long]]("down_cells_1g")
    /** Database column up_cells_1g DBType(BIGINT) */
    val upCells1g: Column[Option[Long]] = column[Option[Long]]("up_cells_1g")
    /** Database column cis_kpi_1g DBType(DECIMAL) */
    val cisKpi1g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_1g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VCurrentPerformance */
  lazy val VCurrentPerformance = new TableQuery(tag => new VCurrentPerformance(tag))
  
  /** Entity class storing rows of table VDashboardAlert
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param minorThreshold Database column minor_threshold DBType(BIGINT)
   *  @param majorThreshold Database column major_threshold DBType(BIGINT)
   *  @param dayDeviation Database column day_deviation DBType(BIGINT)
   *  @param weekDeviation Database column week_deviation DBType(BIGINT)
   *  @param monthDeviation Database column month_deviation DBType(BIGINT)
   *  @param stateDelay Database column state_delay DBType(BIGINT)
   *  @param ticketDelay Database column ticket_delay DBType(BIGINT)
   *  @param configurationDelay Database column configuration_delay DBType(BIGINT) */
  case class VDashboardAlertRow(groupId: String, minorThreshold: Option[Long], majorThreshold: Option[Long], dayDeviation: Option[Long], weekDeviation: Option[Long], monthDeviation: Option[Long], stateDelay: Option[Long], ticketDelay: Option[Long], configurationDelay: Option[Long])
  /** GetResult implicit for fetching VDashboardAlertRow objects using plain SQL queries */
  implicit def GetResultVDashboardAlertRow(implicit e0: GR[String], e1: GR[Option[Long]]): GR[VDashboardAlertRow] = GR{
    prs => import prs._
    VDashboardAlertRow.tupled((<<[String], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long]))
  }
  /** Table description of table v_dashboard_alert. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardAlert(_tableTag: Tag) extends Table[VDashboardAlertRow](_tableTag, "v_dashboard_alert") {
    def * = (groupId, minorThreshold, majorThreshold, dayDeviation, weekDeviation, monthDeviation, stateDelay, ticketDelay, configurationDelay) <> (VDashboardAlertRow.tupled, VDashboardAlertRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, minorThreshold, majorThreshold, dayDeviation, weekDeviation, monthDeviation, stateDelay, ticketDelay, configurationDelay).shaped.<>({r=>import r._; _1.map(_=> VDashboardAlertRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column minor_threshold DBType(BIGINT) */
    val minorThreshold: Column[Option[Long]] = column[Option[Long]]("minor_threshold")
    /** Database column major_threshold DBType(BIGINT) */
    val majorThreshold: Column[Option[Long]] = column[Option[Long]]("major_threshold")
    /** Database column day_deviation DBType(BIGINT) */
    val dayDeviation: Column[Option[Long]] = column[Option[Long]]("day_deviation")
    /** Database column week_deviation DBType(BIGINT) */
    val weekDeviation: Column[Option[Long]] = column[Option[Long]]("week_deviation")
    /** Database column month_deviation DBType(BIGINT) */
    val monthDeviation: Column[Option[Long]] = column[Option[Long]]("month_deviation")
    /** Database column state_delay DBType(BIGINT) */
    val stateDelay: Column[Option[Long]] = column[Option[Long]]("state_delay")
    /** Database column ticket_delay DBType(BIGINT) */
    val ticketDelay: Column[Option[Long]] = column[Option[Long]]("ticket_delay")
    /** Database column configuration_delay DBType(BIGINT) */
    val configurationDelay: Column[Option[Long]] = column[Option[Long]]("configuration_delay")
  }
  /** Collection-like TableQuery object for table VDashboardAlert */
  lazy val VDashboardAlert = new TableQuery(tag => new VDashboardAlert(tag))
  
  /** Entity class storing rows of table VDashboardCell
   *  @param cellId Database column cell_id DBType(VARCHAR), Length(20,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param generation Database column generation DBType(INT)
   *  @param exclude Database column exclude DBType(BIT)
   *  @param sticky Database column sticky DBType(BIT) */
  case class VDashboardCellRow(cellId: Option[String], siteId: String, groupId: String, generation: Int, exclude: Boolean, sticky: Boolean)
  /** GetResult implicit for fetching VDashboardCellRow objects using plain SQL queries */
  implicit def GetResultVDashboardCellRow(implicit e0: GR[Option[String]], e1: GR[String], e2: GR[Int], e3: GR[Boolean]): GR[VDashboardCellRow] = GR{
    prs => import prs._
    VDashboardCellRow.tupled((<<?[String], <<[String], <<[String], <<[Int], <<[Boolean], <<[Boolean]))
  }
  /** Table description of table v_dashboard_cell. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardCell(_tableTag: Tag) extends Table[VDashboardCellRow](_tableTag, "v_dashboard_cell") {
    def * = (cellId, siteId, groupId, generation, exclude, sticky) <> (VDashboardCellRow.tupled, VDashboardCellRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (cellId, siteId.?, groupId.?, generation.?, exclude.?, sticky.?).shaped.<>({r=>import r._; _2.map(_=> VDashboardCellRow.tupled((_1, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column cell_id DBType(VARCHAR), Length(20,true) */
    val cellId: Column[Option[String]] = column[Option[String]]("cell_id", O.Length(20,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Boolean] = column[Boolean]("exclude")
    /** Database column sticky DBType(BIT) */
    val sticky: Column[Boolean] = column[Boolean]("sticky")
  }
  /** Collection-like TableQuery object for table VDashboardCell */
  lazy val VDashboardCell = new TableQuery(tag => new VDashboardCell(tag))
  
  /** Row type of table VDashboardCellHistory */
  type VDashboardCellHistoryRow = HCons[java.sql.Timestamp,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Int,HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardCellHistoryRow providing default values if available in the database schema. */
  def VDashboardCellHistoryRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], nodeId: Option[String], siteId: Option[String], vendorId: Option[String], sitePriority: Option[Int], siteExclude: Option[Boolean], exclude2g: Option[Int], exclude3g: Option[Int], exclude4g: Option[Int], siteSticky: Option[Boolean], coos2g: Option[Long], coos3g: Option[Long], coos4g: Option[Long], coosAll: Option[Long], up: Int = 0, downtime: Option[String], sector0State: Option[Int], sector1State: Option[Int], sector2State: Option[Int], sector3State: Option[Int], cell0State: Option[Int], cell1State: Option[Int], cell2State: Option[Int], cell3State: Option[Int], cell4State: Option[Int], cell5State: Option[Int], cell6State: Option[Int], cell7State: Option[Int], cell8State: Option[Int], cell9State: Option[Int], cell10State: Option[Int], cell11State: Option[Int], cell12State: Option[Int], cell13State: Option[Int], cell14State: Option[Int], cell15State: Option[Int], cell16State: Option[Int], cell17State: Option[Int], cell18State: Option[Int], cell19State: Option[Int], cell20State: Option[Int], cell21State: Option[Int], cell22State: Option[Int], cell23State: Option[Int], cell24State: Option[Int], cell25State: Option[Int], cell26State: Option[Int], cell27State: Option[Int], cell28State: Option[Int], cell29State: Option[Int], cell30State: Option[Int], cell31State: Option[Int]): VDashboardCellHistoryRow = {
    measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: sitePriority :: siteExclude :: exclude2g :: exclude3g :: exclude4g :: siteSticky :: coos2g :: coos3g :: coos4g :: coosAll :: up :: downtime :: sector0State :: sector1State :: sector2State :: sector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: HNil
  }
  /** GetResult implicit for fetching VDashboardCellHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardCellHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]], e4: GR[Option[Long]], e5: GR[Int]): GR[VDashboardCellHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Boolean] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Boolean] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<[Int] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: HNil
  }
  /** Table description of table v_dashboard_cell_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardCellHistory(_tableTag: Tag) extends Table[VDashboardCellHistoryRow](_tableTag, "v_dashboard_cell_history") {
    def * = measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: sitePriority :: siteExclude :: exclude2g :: exclude3g :: exclude4g :: siteSticky :: coos2g :: coos3g :: coos4g :: coosAll :: up :: downtime :: sector0State :: sector1State :: sector2State :: sector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column site_priority DBType(INT) */
    val sitePriority: Column[Option[Int]] = column[Option[Int]]("site_priority")
    /** Database column site_exclude DBType(BIT) */
    val siteExclude: Column[Option[Boolean]] = column[Option[Boolean]]("site_exclude")
    /** Database column exclude_2g DBType(INT) */
    val exclude2g: Column[Option[Int]] = column[Option[Int]]("exclude_2g")
    /** Database column exclude_3g DBType(INT) */
    val exclude3g: Column[Option[Int]] = column[Option[Int]]("exclude_3g")
    /** Database column exclude_4g DBType(INT) */
    val exclude4g: Column[Option[Int]] = column[Option[Int]]("exclude_4g")
    /** Database column site_sticky DBType(BIT) */
    val siteSticky: Column[Option[Boolean]] = column[Option[Boolean]]("site_sticky")
    /** Database column coos_2g DBType(BIGINT) */
    val coos2g: Column[Option[Long]] = column[Option[Long]]("coos_2g")
    /** Database column coos_3g DBType(BIGINT) */
    val coos3g: Column[Option[Long]] = column[Option[Long]]("coos_3g")
    /** Database column coos_4g DBType(BIGINT) */
    val coos4g: Column[Option[Long]] = column[Option[Long]]("coos_4g")
    /** Database column coos_all DBType(BIGINT) */
    val coosAll: Column[Option[Long]] = column[Option[Long]]("coos_all")
    /** Database column up DBType(INT), Default(0) */
    val up: Column[Int] = column[Int]("up", O.Default(0))
    /** Database column downtime DBType(VARCHAR), Length(10,true) */
    val downtime: Column[Option[String]] = column[Option[String]]("downtime", O.Length(10,varying=true))
    /** Database column sector_0_state DBType(INT) */
    val sector0State: Column[Option[Int]] = column[Option[Int]]("sector_0_state")
    /** Database column sector_1_state DBType(INT) */
    val sector1State: Column[Option[Int]] = column[Option[Int]]("sector_1_state")
    /** Database column sector_2_state DBType(INT) */
    val sector2State: Column[Option[Int]] = column[Option[Int]]("sector_2_state")
    /** Database column sector_3_state DBType(INT) */
    val sector3State: Column[Option[Int]] = column[Option[Int]]("sector_3_state")
    /** Database column cell_0_state DBType(INT) */
    val cell0State: Column[Option[Int]] = column[Option[Int]]("cell_0_state")
    /** Database column cell_1_state DBType(INT) */
    val cell1State: Column[Option[Int]] = column[Option[Int]]("cell_1_state")
    /** Database column cell_2_state DBType(INT) */
    val cell2State: Column[Option[Int]] = column[Option[Int]]("cell_2_state")
    /** Database column cell_3_state DBType(INT) */
    val cell3State: Column[Option[Int]] = column[Option[Int]]("cell_3_state")
    /** Database column cell_4_state DBType(INT) */
    val cell4State: Column[Option[Int]] = column[Option[Int]]("cell_4_state")
    /** Database column cell_5_state DBType(INT) */
    val cell5State: Column[Option[Int]] = column[Option[Int]]("cell_5_state")
    /** Database column cell_6_state DBType(INT) */
    val cell6State: Column[Option[Int]] = column[Option[Int]]("cell_6_state")
    /** Database column cell_7_state DBType(INT) */
    val cell7State: Column[Option[Int]] = column[Option[Int]]("cell_7_state")
    /** Database column cell_8_state DBType(INT) */
    val cell8State: Column[Option[Int]] = column[Option[Int]]("cell_8_state")
    /** Database column cell_9_state DBType(INT) */
    val cell9State: Column[Option[Int]] = column[Option[Int]]("cell_9_state")
    /** Database column cell_10_state DBType(INT) */
    val cell10State: Column[Option[Int]] = column[Option[Int]]("cell_10_state")
    /** Database column cell_11_state DBType(INT) */
    val cell11State: Column[Option[Int]] = column[Option[Int]]("cell_11_state")
    /** Database column cell_12_state DBType(INT) */
    val cell12State: Column[Option[Int]] = column[Option[Int]]("cell_12_state")
    /** Database column cell_13_state DBType(INT) */
    val cell13State: Column[Option[Int]] = column[Option[Int]]("cell_13_state")
    /** Database column cell_14_state DBType(INT) */
    val cell14State: Column[Option[Int]] = column[Option[Int]]("cell_14_state")
    /** Database column cell_15_state DBType(INT) */
    val cell15State: Column[Option[Int]] = column[Option[Int]]("cell_15_state")
    /** Database column cell_16_state DBType(INT) */
    val cell16State: Column[Option[Int]] = column[Option[Int]]("cell_16_state")
    /** Database column cell_17_state DBType(INT) */
    val cell17State: Column[Option[Int]] = column[Option[Int]]("cell_17_state")
    /** Database column cell_18_state DBType(INT) */
    val cell18State: Column[Option[Int]] = column[Option[Int]]("cell_18_state")
    /** Database column cell_19_state DBType(INT) */
    val cell19State: Column[Option[Int]] = column[Option[Int]]("cell_19_state")
    /** Database column cell_20_state DBType(INT) */
    val cell20State: Column[Option[Int]] = column[Option[Int]]("cell_20_state")
    /** Database column cell_21_state DBType(INT) */
    val cell21State: Column[Option[Int]] = column[Option[Int]]("cell_21_state")
    /** Database column cell_22_state DBType(INT) */
    val cell22State: Column[Option[Int]] = column[Option[Int]]("cell_22_state")
    /** Database column cell_23_state DBType(INT) */
    val cell23State: Column[Option[Int]] = column[Option[Int]]("cell_23_state")
    /** Database column cell_24_state DBType(INT) */
    val cell24State: Column[Option[Int]] = column[Option[Int]]("cell_24_state")
    /** Database column cell_25_state DBType(INT) */
    val cell25State: Column[Option[Int]] = column[Option[Int]]("cell_25_state")
    /** Database column cell_26_state DBType(INT) */
    val cell26State: Column[Option[Int]] = column[Option[Int]]("cell_26_state")
    /** Database column cell_27_state DBType(INT) */
    val cell27State: Column[Option[Int]] = column[Option[Int]]("cell_27_state")
    /** Database column cell_28_state DBType(INT) */
    val cell28State: Column[Option[Int]] = column[Option[Int]]("cell_28_state")
    /** Database column cell_29_state DBType(INT) */
    val cell29State: Column[Option[Int]] = column[Option[Int]]("cell_29_state")
    /** Database column cell_30_state DBType(INT) */
    val cell30State: Column[Option[Int]] = column[Option[Int]]("cell_30_state")
    /** Database column cell_31_state DBType(INT) */
    val cell31State: Column[Option[Int]] = column[Option[Int]]("cell_31_state")
  }
  /** Collection-like TableQuery object for table VDashboardCellHistory */
  lazy val VDashboardCellHistory = new TableQuery(tag => new VDashboardCellHistory(tag))
  
  /** Entity class storing rows of table VDashboardCellIdentity
   *  @param generation Database column generation DBType(BIGINT), Default(0)
   *  @param cellNo Database column cell_no DBType(BIGINT), Default(0)
   *  @param sectorNo Database column sector_no DBType(BIGINT)
   *  @param cellId Database column cell_id DBType(VARCHAR), Length(20,true) */
  case class VDashboardCellIdentityRow(generation: Long = 0L, cellNo: Long = 0L, sectorNo: Option[Long], cellId: Option[String])
  /** GetResult implicit for fetching VDashboardCellIdentityRow objects using plain SQL queries */
  implicit def GetResultVDashboardCellIdentityRow(implicit e0: GR[Long], e1: GR[Option[Long]], e2: GR[Option[String]]): GR[VDashboardCellIdentityRow] = GR{
    prs => import prs._
    VDashboardCellIdentityRow.tupled((<<[Long], <<[Long], <<?[Long], <<?[String]))
  }
  /** Table description of table v_dashboard_cell_identity. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardCellIdentity(_tableTag: Tag) extends Table[VDashboardCellIdentityRow](_tableTag, "v_dashboard_cell_identity") {
    def * = (generation, cellNo, sectorNo, cellId) <> (VDashboardCellIdentityRow.tupled, VDashboardCellIdentityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (generation.?, cellNo.?, sectorNo, cellId).shaped.<>({r=>import r._; _1.map(_=> VDashboardCellIdentityRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column generation DBType(BIGINT), Default(0) */
    val generation: Column[Long] = column[Long]("generation", O.Default(0L))
    /** Database column cell_no DBType(BIGINT), Default(0) */
    val cellNo: Column[Long] = column[Long]("cell_no", O.Default(0L))
    /** Database column sector_no DBType(BIGINT) */
    val sectorNo: Column[Option[Long]] = column[Option[Long]]("sector_no")
    /** Database column cell_id DBType(VARCHAR), Length(20,true) */
    val cellId: Column[Option[String]] = column[Option[String]]("cell_id", O.Length(20,varying=true))
  }
  /** Collection-like TableQuery object for table VDashboardCellIdentity */
  lazy val VDashboardCellIdentity = new TableQuery(tag => new VDashboardCellIdentity(tag))
  
  /** Row type of table VDashboardCellOutageHistory */
  type VDashboardCellOutageHistoryRow = HCons[java.sql.Timestamp,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardCellOutageHistoryRow providing default values if available in the database schema. */
  def VDashboardCellOutageHistoryRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], nodeId: Option[String], siteId: Option[String], vendorId: Option[String], sitePriority: Option[Int], siteExclude: Option[Boolean], exclude2g: Option[Int], exclude3g: Option[Int], exclude4g: Option[Int], siteSticky: Option[Boolean], coos2g: Option[Long], coos3g: Option[Long], coos4g: Option[Long], coosAll: Option[Long], downtime: Option[String], ticketPriority: Option[String], noteCount: Option[Long] = Some(0L), sector0State: Option[Int], sector1State: Option[Int], sector2State: Option[Int], sector3State: Option[Int], cell0State: Option[Int], cell1State: Option[Int], cell2State: Option[Int], cell3State: Option[Int], cell4State: Option[Int], cell5State: Option[Int], cell6State: Option[Int], cell7State: Option[Int], cell8State: Option[Int], cell9State: Option[Int], cell10State: Option[Int], cell11State: Option[Int], cell12State: Option[Int], cell13State: Option[Int], cell14State: Option[Int], cell15State: Option[Int], cell16State: Option[Int], cell17State: Option[Int], cell18State: Option[Int], cell19State: Option[Int], cell20State: Option[Int], cell21State: Option[Int], cell22State: Option[Int], cell23State: Option[Int], cell24State: Option[Int], cell25State: Option[Int], cell26State: Option[Int], cell27State: Option[Int], cell28State: Option[Int], cell29State: Option[Int], cell30State: Option[Int], cell31State: Option[Int]): VDashboardCellOutageHistoryRow = {
    measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: sitePriority :: siteExclude :: exclude2g :: exclude3g :: exclude4g :: siteSticky :: coos2g :: coos3g :: coos4g :: coosAll :: downtime :: ticketPriority :: noteCount :: sector0State :: sector1State :: sector2State :: sector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: HNil
  }
  /** GetResult implicit for fetching VDashboardCellOutageHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardCellOutageHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]], e4: GR[Option[Long]]): GR[VDashboardCellOutageHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Boolean] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Boolean] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: HNil
  }
  /** Table description of table v_dashboard_cell_outage_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardCellOutageHistory(_tableTag: Tag) extends Table[VDashboardCellOutageHistoryRow](_tableTag, "v_dashboard_cell_outage_history") {
    def * = measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: sitePriority :: siteExclude :: exclude2g :: exclude3g :: exclude4g :: siteSticky :: coos2g :: coos3g :: coos4g :: coosAll :: downtime :: ticketPriority :: noteCount :: sector0State :: sector1State :: sector2State :: sector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column site_priority DBType(INT) */
    val sitePriority: Column[Option[Int]] = column[Option[Int]]("site_priority")
    /** Database column site_exclude DBType(BIT) */
    val siteExclude: Column[Option[Boolean]] = column[Option[Boolean]]("site_exclude")
    /** Database column exclude_2g DBType(INT) */
    val exclude2g: Column[Option[Int]] = column[Option[Int]]("exclude_2g")
    /** Database column exclude_3g DBType(INT) */
    val exclude3g: Column[Option[Int]] = column[Option[Int]]("exclude_3g")
    /** Database column exclude_4g DBType(INT) */
    val exclude4g: Column[Option[Int]] = column[Option[Int]]("exclude_4g")
    /** Database column site_sticky DBType(BIT) */
    val siteSticky: Column[Option[Boolean]] = column[Option[Boolean]]("site_sticky")
    /** Database column coos_2g DBType(BIGINT) */
    val coos2g: Column[Option[Long]] = column[Option[Long]]("coos_2g")
    /** Database column coos_3g DBType(BIGINT) */
    val coos3g: Column[Option[Long]] = column[Option[Long]]("coos_3g")
    /** Database column coos_4g DBType(BIGINT) */
    val coos4g: Column[Option[Long]] = column[Option[Long]]("coos_4g")
    /** Database column coos_all DBType(BIGINT) */
    val coosAll: Column[Option[Long]] = column[Option[Long]]("coos_all")
    /** Database column downtime DBType(VARCHAR), Length(10,true) */
    val downtime: Column[Option[String]] = column[Option[String]]("downtime", O.Length(10,varying=true))
    /** Database column ticket_priority DBType(VARCHAR), Length(20,true) */
    val ticketPriority: Column[Option[String]] = column[Option[String]]("ticket_priority", O.Length(20,varying=true))
    /** Database column note_count DBType(BIGINT), Default(Some(0)) */
    val noteCount: Column[Option[Long]] = column[Option[Long]]("note_count", O.Default(Some(0L)))
    /** Database column sector_0_state DBType(INT) */
    val sector0State: Column[Option[Int]] = column[Option[Int]]("sector_0_state")
    /** Database column sector_1_state DBType(INT) */
    val sector1State: Column[Option[Int]] = column[Option[Int]]("sector_1_state")
    /** Database column sector_2_state DBType(INT) */
    val sector2State: Column[Option[Int]] = column[Option[Int]]("sector_2_state")
    /** Database column sector_3_state DBType(INT) */
    val sector3State: Column[Option[Int]] = column[Option[Int]]("sector_3_state")
    /** Database column cell_0_state DBType(INT) */
    val cell0State: Column[Option[Int]] = column[Option[Int]]("cell_0_state")
    /** Database column cell_1_state DBType(INT) */
    val cell1State: Column[Option[Int]] = column[Option[Int]]("cell_1_state")
    /** Database column cell_2_state DBType(INT) */
    val cell2State: Column[Option[Int]] = column[Option[Int]]("cell_2_state")
    /** Database column cell_3_state DBType(INT) */
    val cell3State: Column[Option[Int]] = column[Option[Int]]("cell_3_state")
    /** Database column cell_4_state DBType(INT) */
    val cell4State: Column[Option[Int]] = column[Option[Int]]("cell_4_state")
    /** Database column cell_5_state DBType(INT) */
    val cell5State: Column[Option[Int]] = column[Option[Int]]("cell_5_state")
    /** Database column cell_6_state DBType(INT) */
    val cell6State: Column[Option[Int]] = column[Option[Int]]("cell_6_state")
    /** Database column cell_7_state DBType(INT) */
    val cell7State: Column[Option[Int]] = column[Option[Int]]("cell_7_state")
    /** Database column cell_8_state DBType(INT) */
    val cell8State: Column[Option[Int]] = column[Option[Int]]("cell_8_state")
    /** Database column cell_9_state DBType(INT) */
    val cell9State: Column[Option[Int]] = column[Option[Int]]("cell_9_state")
    /** Database column cell_10_state DBType(INT) */
    val cell10State: Column[Option[Int]] = column[Option[Int]]("cell_10_state")
    /** Database column cell_11_state DBType(INT) */
    val cell11State: Column[Option[Int]] = column[Option[Int]]("cell_11_state")
    /** Database column cell_12_state DBType(INT) */
    val cell12State: Column[Option[Int]] = column[Option[Int]]("cell_12_state")
    /** Database column cell_13_state DBType(INT) */
    val cell13State: Column[Option[Int]] = column[Option[Int]]("cell_13_state")
    /** Database column cell_14_state DBType(INT) */
    val cell14State: Column[Option[Int]] = column[Option[Int]]("cell_14_state")
    /** Database column cell_15_state DBType(INT) */
    val cell15State: Column[Option[Int]] = column[Option[Int]]("cell_15_state")
    /** Database column cell_16_state DBType(INT) */
    val cell16State: Column[Option[Int]] = column[Option[Int]]("cell_16_state")
    /** Database column cell_17_state DBType(INT) */
    val cell17State: Column[Option[Int]] = column[Option[Int]]("cell_17_state")
    /** Database column cell_18_state DBType(INT) */
    val cell18State: Column[Option[Int]] = column[Option[Int]]("cell_18_state")
    /** Database column cell_19_state DBType(INT) */
    val cell19State: Column[Option[Int]] = column[Option[Int]]("cell_19_state")
    /** Database column cell_20_state DBType(INT) */
    val cell20State: Column[Option[Int]] = column[Option[Int]]("cell_20_state")
    /** Database column cell_21_state DBType(INT) */
    val cell21State: Column[Option[Int]] = column[Option[Int]]("cell_21_state")
    /** Database column cell_22_state DBType(INT) */
    val cell22State: Column[Option[Int]] = column[Option[Int]]("cell_22_state")
    /** Database column cell_23_state DBType(INT) */
    val cell23State: Column[Option[Int]] = column[Option[Int]]("cell_23_state")
    /** Database column cell_24_state DBType(INT) */
    val cell24State: Column[Option[Int]] = column[Option[Int]]("cell_24_state")
    /** Database column cell_25_state DBType(INT) */
    val cell25State: Column[Option[Int]] = column[Option[Int]]("cell_25_state")
    /** Database column cell_26_state DBType(INT) */
    val cell26State: Column[Option[Int]] = column[Option[Int]]("cell_26_state")
    /** Database column cell_27_state DBType(INT) */
    val cell27State: Column[Option[Int]] = column[Option[Int]]("cell_27_state")
    /** Database column cell_28_state DBType(INT) */
    val cell28State: Column[Option[Int]] = column[Option[Int]]("cell_28_state")
    /** Database column cell_29_state DBType(INT) */
    val cell29State: Column[Option[Int]] = column[Option[Int]]("cell_29_state")
    /** Database column cell_30_state DBType(INT) */
    val cell30State: Column[Option[Int]] = column[Option[Int]]("cell_30_state")
    /** Database column cell_31_state DBType(INT) */
    val cell31State: Column[Option[Int]] = column[Option[Int]]("cell_31_state")
  }
  /** Collection-like TableQuery object for table VDashboardCellOutageHistory */
  lazy val VDashboardCellOutageHistory = new TableQuery(tag => new VDashboardCellOutageHistory(tag))
  
  /** Entity class storing rows of table VDashboardCurrentMeasurementTime
   *  @param generation Database column generation DBType(BIGINT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP) */
  case class VDashboardCurrentMeasurementTimeRow(generation: Option[Long], groupId: Option[String], measurementTime: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching VDashboardCurrentMeasurementTimeRow objects using plain SQL queries */
  implicit def GetResultVDashboardCurrentMeasurementTimeRow(implicit e0: GR[Option[Long]], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[VDashboardCurrentMeasurementTimeRow] = GR{
    prs => import prs._
    VDashboardCurrentMeasurementTimeRow.tupled((<<?[Long], <<?[String], <<?[java.sql.Timestamp]))
  }
  /** Table description of table v_dashboard_current_measurement_time. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardCurrentMeasurementTime(_tableTag: Tag) extends Table[VDashboardCurrentMeasurementTimeRow](_tableTag, "v_dashboard_current_measurement_time") {
    def * = (generation, groupId, measurementTime) <> (VDashboardCurrentMeasurementTimeRow.tupled, VDashboardCurrentMeasurementTimeRow.unapply)
    
    /** Database column generation DBType(BIGINT) */
    val generation: Column[Option[Long]] = column[Option[Long]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
  }
  /** Collection-like TableQuery object for table VDashboardCurrentMeasurementTime */
  lazy val VDashboardCurrentMeasurementTime = new TableQuery(tag => new VDashboardCurrentMeasurementTime(tag))
  
  /** Row type of table VDashboardCurrentPerformance */
  type VDashboardCurrentPerformanceRow = HCons[Option[String],HCons[Option[Int],HCons[Option[java.sql.Timestamp],HCons[Option[java.sql.Timestamp],HCons[Option[java.sql.Timestamp],HCons[Option[java.sql.Timestamp],HCons[Option[java.sql.Timestamp],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Long],HCons[Option[Long],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardCurrentPerformanceRow providing default values if available in the database schema. */
  def VDashboardCurrentPerformanceRow(groupId: Option[String], sectorNo: Option[Int], measurementTime: Option[java.sql.Timestamp], measurementTime4g: Option[java.sql.Timestamp], measurementTime3g: Option[java.sql.Timestamp], measurementTime2g: Option[java.sql.Timestamp], measurementTime1g: Option[java.sql.Timestamp], cisKpiAll: Option[scala.math.BigDecimal], cisKpi4g: Option[scala.math.BigDecimal], cisKpi3g: Option[scala.math.BigDecimal], cisKpi2g: Option[scala.math.BigDecimal], cisKpi1g: Option[scala.math.BigDecimal], knownCellsAll: Option[Long], knownCells4g: Option[Long], knownCells3g: Option[Long], knownCells2g: Option[Long], knownCells1g: Option[Long], downCellsAll: Option[Long], downCells4g: Option[Long], downCells3g: Option[Long], downCells2g: Option[Long], downCells1g: Option[Long], blockedCellsAll: Option[Long], blockedCells4g: Option[Long], blockedCells3g: Option[Long], blockedCells2g: Option[Long], blockedCells1g: Option[Long], cisKpiSeverityAll: Option[Int], cisKpiSeverity4g: Option[Int], cisKpiSeverity3g: Option[Int], cisKpiSeverity2g: Option[Int], cisKpiSeverity1g: Option[Int], openPerformanceAlerts: Option[Long], openQualityAlerts: Option[Long]): VDashboardCurrentPerformanceRow = {
    groupId :: sectorNo :: measurementTime :: measurementTime4g :: measurementTime3g :: measurementTime2g :: measurementTime1g :: cisKpiAll :: cisKpi4g :: cisKpi3g :: cisKpi2g :: cisKpi1g :: knownCellsAll :: knownCells4g :: knownCells3g :: knownCells2g :: knownCells1g :: downCellsAll :: downCells4g :: downCells3g :: downCells2g :: downCells1g :: blockedCellsAll :: blockedCells4g :: blockedCells3g :: blockedCells2g :: blockedCells1g :: cisKpiSeverityAll :: cisKpiSeverity4g :: cisKpiSeverity3g :: cisKpiSeverity2g :: cisKpiSeverity1g :: openPerformanceAlerts :: openQualityAlerts :: HNil
  }
  /** GetResult implicit for fetching VDashboardCurrentPerformanceRow objects using plain SQL queries */
  implicit def GetResultVDashboardCurrentPerformanceRow(implicit e0: GR[Option[String]], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Long]]): GR[VDashboardCurrentPerformanceRow] = GR{
    prs => import prs._
    <<?[String] :: <<?[Int] :: <<?[java.sql.Timestamp] :: <<?[java.sql.Timestamp] :: <<?[java.sql.Timestamp] :: <<?[java.sql.Timestamp] :: <<?[java.sql.Timestamp] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Long] :: <<?[Long] :: HNil
  }
  /** Table description of table v_dashboard_current_performance. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardCurrentPerformance(_tableTag: Tag) extends Table[VDashboardCurrentPerformanceRow](_tableTag, "v_dashboard_current_performance") {
    def * = groupId :: sectorNo :: measurementTime :: measurementTime4g :: measurementTime3g :: measurementTime2g :: measurementTime1g :: cisKpiAll :: cisKpi4g :: cisKpi3g :: cisKpi2g :: cisKpi1g :: knownCellsAll :: knownCells4g :: knownCells3g :: knownCells2g :: knownCells1g :: downCellsAll :: downCells4g :: downCells3g :: downCells2g :: downCells1g :: blockedCellsAll :: blockedCells4g :: blockedCells3g :: blockedCells2g :: blockedCells1g :: cisKpiSeverityAll :: cisKpiSeverity4g :: cisKpiSeverity3g :: cisKpiSeverity2g :: cisKpiSeverity1g :: openPerformanceAlerts :: openQualityAlerts :: HNil
    
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column measurement_time_4g DBType(DATETIME) */
    val measurementTime4g: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time_4g")
    /** Database column measurement_time_3g DBType(DATETIME) */
    val measurementTime3g: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time_3g")
    /** Database column measurement_time_2g DBType(DATETIME) */
    val measurementTime2g: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time_2g")
    /** Database column measurement_time_1g DBType(DATETIME) */
    val measurementTime1g: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time_1g")
    /** Database column cis_kpi_all DBType(DECIMAL) */
    val cisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_all")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column cis_kpi_1g DBType(DECIMAL) */
    val cisKpi1g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_1g")
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column known_cells_1g DBType(BIGINT) */
    val knownCells1g: Column[Option[Long]] = column[Option[Long]]("known_cells_1g")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column down_cells_1g DBType(BIGINT) */
    val downCells1g: Column[Option[Long]] = column[Option[Long]]("down_cells_1g")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column blocked_cells_1g DBType(BIGINT) */
    val blockedCells1g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_1g")
    /** Database column cis_kpi_severity_all DBType(INT) */
    val cisKpiSeverityAll: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_all")
    /** Database column cis_kpi_severity_4g DBType(INT) */
    val cisKpiSeverity4g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_4g")
    /** Database column cis_kpi_severity_3g DBType(INT) */
    val cisKpiSeverity3g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_3g")
    /** Database column cis_kpi_severity_2g DBType(INT) */
    val cisKpiSeverity2g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_2g")
    /** Database column cis_kpi_severity_1g DBType(INT) */
    val cisKpiSeverity1g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_1g")
    /** Database column open_performance_alerts DBType(BIGINT) */
    val openPerformanceAlerts: Column[Option[Long]] = column[Option[Long]]("open_performance_alerts")
    /** Database column open_quality_alerts DBType(BIGINT) */
    val openQualityAlerts: Column[Option[Long]] = column[Option[Long]]("open_quality_alerts")
  }
  /** Collection-like TableQuery object for table VDashboardCurrentPerformance */
  lazy val VDashboardCurrentPerformance = new TableQuery(tag => new VDashboardCurrentPerformance(tag))
  
  /** Row type of table VDashboardDailyPerformanceHistory */
  type VDashboardDailyPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardDailyPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardDailyPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], minKnownCellsAll: Option[Long], minKnownCells4g: Option[Long], minKnownCells3g: Option[Long], minKnownCells2g: Option[Long], maxKnownCellsAll: Option[Long], maxKnownCells4g: Option[Long], maxKnownCells3g: Option[Long], maxKnownCells2g: Option[Long], avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Option[scala.math.BigDecimal], avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Option[scala.math.BigDecimal], minCisKpiAll: Option[Long], minCisKpi4g: Option[scala.math.BigDecimal], minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Option[scala.math.BigDecimal], maxCisKpiAll: Option[Long], maxCisKpi4g: Option[scala.math.BigDecimal], maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Option[scala.math.BigDecimal], avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Option[scala.math.BigDecimal], avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Option[scala.math.BigDecimal]): VDashboardDailyPerformanceHistoryRow = {
    measurementTime :: groupId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: HNil
  }
  /** GetResult implicit for fetching VDashboardDailyPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardDailyPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]]): GR[VDashboardDailyPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: HNil
  }
  /** Table description of table v_dashboard_daily_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardDailyPerformanceHistory(_tableTag: Tag) extends Table[VDashboardDailyPerformanceHistoryRow](_tableTag, "v_dashboard_daily_performance_history") {
    def * = measurementTime :: groupId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(BIGINT) */
    val minKnownCells4g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_4g")
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(BIGINT) */
    val minKnownCells2g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_2g")
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(BIGINT) */
    val maxKnownCells4g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_4g")
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(BIGINT) */
    val maxKnownCells2g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_2g")
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(DECIMAL) */
    val avgKnownCells4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_4g")
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(DECIMAL) */
    val avgKnownCells2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_2g")
    /** Database column min_cis_kpi_all DBType(BIGINT) */
    val minCisKpiAll: Column[Option[Long]] = column[Option[Long]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(DECIMAL) */
    val minCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_4g")
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(DECIMAL) */
    val minCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_2g")
    /** Database column max_cis_kpi_all DBType(BIGINT) */
    val maxCisKpiAll: Column[Option[Long]] = column[Option[Long]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(DECIMAL) */
    val maxCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_4g")
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(DECIMAL) */
    val maxCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_2g")
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(DECIMAL) */
    val avgCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_4g")
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(DECIMAL) */
    val avgCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_2g")
  }
  /** Collection-like TableQuery object for table VDashboardDailyPerformanceHistory */
  lazy val VDashboardDailyPerformanceHistory = new TableQuery(tag => new VDashboardDailyPerformanceHistory(tag))
  
  /** Row type of table VDashboardDailyVendorPerformanceHistory */
  type VDashboardDailyVendorPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardDailyVendorPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardDailyVendorPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], vendorId: Option[String], minKnownCellsAll: Option[Long], minKnownCells4g: Option[Long], minKnownCells3g: Option[Long], minKnownCells2g: Option[Long], maxKnownCellsAll: Option[Long], maxKnownCells4g: Option[Long], maxKnownCells3g: Option[Long], maxKnownCells2g: Option[Long], avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Option[scala.math.BigDecimal], avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Option[scala.math.BigDecimal], minCisKpiAll: Option[scala.math.BigDecimal], minCisKpi4g: Option[scala.math.BigDecimal], minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Option[scala.math.BigDecimal], maxCisKpiAll: Option[scala.math.BigDecimal], maxCisKpi4g: Option[scala.math.BigDecimal], maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Option[scala.math.BigDecimal], avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Option[scala.math.BigDecimal], avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VDashboardDailyVendorPerformanceHistoryRow = {
    measurementTime :: groupId :: vendorId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VDashboardDailyVendorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardDailyVendorPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VDashboardDailyVendorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table v_dashboard_daily_vendor_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardDailyVendorPerformanceHistory(_tableTag: Tag) extends Table[VDashboardDailyVendorPerformanceHistoryRow](_tableTag, "v_dashboard_daily_vendor_performance_history") {
    def * = measurementTime :: groupId :: vendorId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(BIGINT) */
    val minKnownCells4g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_4g")
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(BIGINT) */
    val minKnownCells2g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_2g")
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(BIGINT) */
    val maxKnownCells4g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_4g")
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(BIGINT) */
    val maxKnownCells2g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_2g")
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(DECIMAL) */
    val avgKnownCells4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_4g")
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(DECIMAL) */
    val avgKnownCells2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_2g")
    /** Database column min_cis_kpi_all DBType(DECIMAL) */
    val minCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(DECIMAL) */
    val minCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_4g")
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(DECIMAL) */
    val minCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_2g")
    /** Database column max_cis_kpi_all DBType(DECIMAL) */
    val maxCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(DECIMAL) */
    val maxCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_4g")
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(DECIMAL) */
    val maxCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_2g")
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(DECIMAL) */
    val avgCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_4g")
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(DECIMAL) */
    val avgCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VDashboardDailyVendorPerformanceHistory */
  lazy val VDashboardDailyVendorPerformanceHistory = new TableQuery(tag => new VDashboardDailyVendorPerformanceHistory(tag))
  
  /** Entity class storing rows of table VDashboardEvent
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param eventTimestamp Database column event_timestamp DBType(TIMESTAMP)
   *  @param username Database column username DBType(VARCHAR), Length(256,true)
   *  @param entity Database column entity DBType(VARCHAR), Length(256,true)
   *  @param action Database column action DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellId Database column cell_id DBType(VARCHAR), Length(20,true)
   *  @param generation Database column generation DBType(INT)
   *  @param information Database column information DBType(VARCHAR), Length(256,true) */
  case class VDashboardEventRow(groupId: Option[String], eventTimestamp: java.sql.Timestamp, username: Option[String], entity: String, action: String, siteId: Option[String], cellId: Option[String], generation: Option[Int], information: Option[String])
  /** GetResult implicit for fetching VDashboardEventRow objects using plain SQL queries */
  implicit def GetResultVDashboardEventRow(implicit e0: GR[Option[String]], e1: GR[java.sql.Timestamp], e2: GR[String], e3: GR[Option[Int]]): GR[VDashboardEventRow] = GR{
    prs => import prs._
    VDashboardEventRow.tupled((<<?[String], <<[java.sql.Timestamp], <<?[String], <<[String], <<[String], <<?[String], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table v_dashboard_event. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardEvent(_tableTag: Tag) extends Table[VDashboardEventRow](_tableTag, "v_dashboard_event") {
    def * = (groupId, eventTimestamp, username, entity, action, siteId, cellId, generation, information) <> (VDashboardEventRow.tupled, VDashboardEventRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId, eventTimestamp.?, username, entity.?, action.?, siteId, cellId, generation, information).shaped.<>({r=>import r._; _2.map(_=> VDashboardEventRow.tupled((_1, _2.get, _3, _4.get, _5.get, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column event_timestamp DBType(TIMESTAMP) */
    val eventTimestamp: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("event_timestamp")
    /** Database column username DBType(VARCHAR), Length(256,true) */
    val username: Column[Option[String]] = column[Option[String]]("username", O.Length(256,varying=true))
    /** Database column entity DBType(VARCHAR), Length(256,true) */
    val entity: Column[String] = column[String]("entity", O.Length(256,varying=true))
    /** Database column action DBType(VARCHAR), Length(256,true) */
    val action: Column[String] = column[String]("action", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column cell_id DBType(VARCHAR), Length(20,true) */
    val cellId: Column[Option[String]] = column[Option[String]]("cell_id", O.Length(20,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column information DBType(VARCHAR), Length(256,true) */
    val information: Column[Option[String]] = column[Option[String]]("information", O.Length(256,varying=true))
  }
  /** Collection-like TableQuery object for table VDashboardEvent */
  lazy val VDashboardEvent = new TableQuery(tag => new VDashboardEvent(tag))
  
  /** Entity class storing rows of table VDashboardGroup
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param groupName Database column group_name DBType(VARCHAR), Length(256,true)
   *  @param enabled Database column enabled DBType(BIT) */
  case class VDashboardGroupRow(groupId: String, groupName: String, enabled: Boolean)
  /** GetResult implicit for fetching VDashboardGroupRow objects using plain SQL queries */
  implicit def GetResultVDashboardGroupRow(implicit e0: GR[String], e1: GR[Boolean]): GR[VDashboardGroupRow] = GR{
    prs => import prs._
    VDashboardGroupRow.tupled((<<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table v_dashboard_group. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardGroup(_tableTag: Tag) extends Table[VDashboardGroupRow](_tableTag, "v_dashboard_group") {
    def * = (groupId, groupName, enabled) <> (VDashboardGroupRow.tupled, VDashboardGroupRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, groupName.?, enabled.?).shaped.<>({r=>import r._; _1.map(_=> VDashboardGroupRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column group_name DBType(VARCHAR), Length(256,true) */
    val groupName: Column[String] = column[String]("group_name", O.Length(256,varying=true))
    /** Database column enabled DBType(BIT) */
    val enabled: Column[Boolean] = column[Boolean]("enabled")
  }
  /** Collection-like TableQuery object for table VDashboardGroup */
  lazy val VDashboardGroup = new TableQuery(tag => new VDashboardGroup(tag))
  
  /** Row type of table VDashboardHourlyPerformanceHistory */
  type VDashboardHourlyPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardHourlyPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardHourlyPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], minKnownCellsAll: Option[Long], minKnownCells4g: Option[Long], minKnownCells3g: Option[Long], minKnownCells2g: Option[Long], maxKnownCellsAll: Option[Long], maxKnownCells4g: Option[Long], maxKnownCells3g: Option[Long], maxKnownCells2g: Option[Long], avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Option[scala.math.BigDecimal], avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Option[scala.math.BigDecimal], minCisKpiAll: Option[Long], minCisKpi4g: Option[scala.math.BigDecimal], minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Option[scala.math.BigDecimal], maxCisKpiAll: Option[Long], maxCisKpi4g: Option[scala.math.BigDecimal], maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Option[scala.math.BigDecimal], avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Option[scala.math.BigDecimal], avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Option[scala.math.BigDecimal]): VDashboardHourlyPerformanceHistoryRow = {
    measurementTime :: groupId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: HNil
  }
  /** GetResult implicit for fetching VDashboardHourlyPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardHourlyPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]]): GR[VDashboardHourlyPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: HNil
  }
  /** Table description of table v_dashboard_hourly_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardHourlyPerformanceHistory(_tableTag: Tag) extends Table[VDashboardHourlyPerformanceHistoryRow](_tableTag, "v_dashboard_hourly_performance_history") {
    def * = measurementTime :: groupId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(BIGINT) */
    val minKnownCells4g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_4g")
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(BIGINT) */
    val minKnownCells2g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_2g")
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(BIGINT) */
    val maxKnownCells4g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_4g")
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(BIGINT) */
    val maxKnownCells2g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_2g")
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(DECIMAL) */
    val avgKnownCells4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_4g")
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(DECIMAL) */
    val avgKnownCells2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_2g")
    /** Database column min_cis_kpi_all DBType(BIGINT) */
    val minCisKpiAll: Column[Option[Long]] = column[Option[Long]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(DECIMAL) */
    val minCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_4g")
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(DECIMAL) */
    val minCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_2g")
    /** Database column max_cis_kpi_all DBType(BIGINT) */
    val maxCisKpiAll: Column[Option[Long]] = column[Option[Long]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(DECIMAL) */
    val maxCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_4g")
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(DECIMAL) */
    val maxCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_2g")
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(DECIMAL) */
    val avgCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_4g")
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(DECIMAL) */
    val avgCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_2g")
  }
  /** Collection-like TableQuery object for table VDashboardHourlyPerformanceHistory */
  lazy val VDashboardHourlyPerformanceHistory = new TableQuery(tag => new VDashboardHourlyPerformanceHistory(tag))
  
  /** Row type of table VDashboardHourlySiteOperatorPerformanceHistory */
  type VDashboardHourlySiteOperatorPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Int,HCons[Option[Long],HCons[Int,HCons[Option[Long],HCons[Int,HCons[Option[Long],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardHourlySiteOperatorPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardHourlySiteOperatorPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], siteId: Option[String], minKnownCellsAll: Option[Long], minKnownCells4g: Int = 0, minKnownCells3g: Option[Long], minKnownCells2g: Int = 0, maxKnownCellsAll: Option[Long], maxKnownCells4g: Int = 0, maxKnownCells3g: Option[Long], maxKnownCells2g: Int = 0, avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Int = 0, avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Int = 0, minCisKpiAll: Option[scala.math.BigDecimal], minCisKpi4g: Int = 0, minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Int = 0, maxCisKpiAll: Option[scala.math.BigDecimal], maxCisKpi4g: Int = 0, maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Int = 0, avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Int = 0, avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Int = 0, sectorNo: Option[Int]): VDashboardHourlySiteOperatorPerformanceHistoryRow = {
    measurementTime :: groupId :: siteId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VDashboardHourlySiteOperatorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardHourlySiteOperatorPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Int], e4: GR[Option[scala.math.BigDecimal]], e5: GR[Option[Int]]): GR[VDashboardHourlySiteOperatorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<[Int] :: <<?[Long] :: <<[Int] :: <<?[Long] :: <<[Int] :: <<?[Long] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[Int] :: HNil
  }
  /** Table description of table v_dashboard_hourly_site_operator_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardHourlySiteOperatorPerformanceHistory(_tableTag: Tag) extends Table[VDashboardHourlySiteOperatorPerformanceHistoryRow](_tableTag, "v_dashboard_hourly_site_operator_performance_history") {
    def * = measurementTime :: groupId :: siteId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(INT), Default(0) */
    val minKnownCells4g: Column[Int] = column[Int]("min_known_cells_4g", O.Default(0))
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(INT), Default(0) */
    val minKnownCells2g: Column[Int] = column[Int]("min_known_cells_2g", O.Default(0))
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(INT), Default(0) */
    val maxKnownCells4g: Column[Int] = column[Int]("max_known_cells_4g", O.Default(0))
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(INT), Default(0) */
    val maxKnownCells2g: Column[Int] = column[Int]("max_known_cells_2g", O.Default(0))
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(INT), Default(0) */
    val avgKnownCells4g: Column[Int] = column[Int]("avg_known_cells_4g", O.Default(0))
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(INT), Default(0) */
    val avgKnownCells2g: Column[Int] = column[Int]("avg_known_cells_2g", O.Default(0))
    /** Database column min_cis_kpi_all DBType(DECIMAL) */
    val minCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(INT), Default(0) */
    val minCisKpi4g: Column[Int] = column[Int]("min_cis_kpi_4g", O.Default(0))
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(INT), Default(0) */
    val minCisKpi2g: Column[Int] = column[Int]("min_cis_kpi_2g", O.Default(0))
    /** Database column max_cis_kpi_all DBType(DECIMAL) */
    val maxCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(INT), Default(0) */
    val maxCisKpi4g: Column[Int] = column[Int]("max_cis_kpi_4g", O.Default(0))
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(INT), Default(0) */
    val maxCisKpi2g: Column[Int] = column[Int]("max_cis_kpi_2g", O.Default(0))
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(INT), Default(0) */
    val avgCisKpi4g: Column[Int] = column[Int]("avg_cis_kpi_4g", O.Default(0))
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(INT), Default(0) */
    val avgCisKpi2g: Column[Int] = column[Int]("avg_cis_kpi_2g", O.Default(0))
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
    
    /** Index over (groupId) (database name ranmateFemto_vDashboardHourlySiteOperator_groupId) */
    val index1 = index("ranmateFemto_vDashboardHourlySiteOperator_groupId", groupId :: HNil)
    /** Index over (measurementTime) (database name ranmateFemto_vDashboardHourlySiteOperator_measurementTime) */
    val index2 = index("ranmateFemto_vDashboardHourlySiteOperator_measurementTime", measurementTime :: HNil)
    /** Index over (sectorNo) (database name ranmateFemto_vDashboardHourlySiteOperator_sectorNo) */
    val index3 = index("ranmateFemto_vDashboardHourlySiteOperator_sectorNo", sectorNo :: HNil)
    /** Index over (siteId) (database name ranmateFemto_vDashboardHourlySiteOperator_siteId) */
    val index4 = index("ranmateFemto_vDashboardHourlySiteOperator_siteId", siteId :: HNil)
  }
  /** Collection-like TableQuery object for table VDashboardHourlySiteOperatorPerformanceHistory */
  lazy val VDashboardHourlySiteOperatorPerformanceHistory = new TableQuery(tag => new VDashboardHourlySiteOperatorPerformanceHistory(tag))
  
  /** Row type of table VDashboardHourlyVendorPerformanceHistory */
  type VDashboardHourlyVendorPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardHourlyVendorPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardHourlyVendorPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], vendorId: Option[String], minKnownCellsAll: Option[Long], minKnownCells4g: Option[Long], minKnownCells3g: Option[Long], minKnownCells2g: Option[Long], maxKnownCellsAll: Option[Long], maxKnownCells4g: Option[Long], maxKnownCells3g: Option[Long], maxKnownCells2g: Option[Long], avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Option[scala.math.BigDecimal], avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Option[scala.math.BigDecimal], minCisKpiAll: Option[scala.math.BigDecimal], minCisKpi4g: Option[scala.math.BigDecimal], minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Option[scala.math.BigDecimal], maxCisKpiAll: Option[scala.math.BigDecimal], maxCisKpi4g: Option[scala.math.BigDecimal], maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Option[scala.math.BigDecimal], avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Option[scala.math.BigDecimal], avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VDashboardHourlyVendorPerformanceHistoryRow = {
    measurementTime :: groupId :: vendorId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VDashboardHourlyVendorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardHourlyVendorPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VDashboardHourlyVendorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table v_dashboard_hourly_vendor_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardHourlyVendorPerformanceHistory(_tableTag: Tag) extends Table[VDashboardHourlyVendorPerformanceHistoryRow](_tableTag, "v_dashboard_hourly_vendor_performance_history") {
    def * = measurementTime :: groupId :: vendorId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(BIGINT) */
    val minKnownCells4g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_4g")
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(BIGINT) */
    val minKnownCells2g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_2g")
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(BIGINT) */
    val maxKnownCells4g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_4g")
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(BIGINT) */
    val maxKnownCells2g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_2g")
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(DECIMAL) */
    val avgKnownCells4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_4g")
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(DECIMAL) */
    val avgKnownCells2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_2g")
    /** Database column min_cis_kpi_all DBType(DECIMAL) */
    val minCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(DECIMAL) */
    val minCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_4g")
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(DECIMAL) */
    val minCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_2g")
    /** Database column max_cis_kpi_all DBType(DECIMAL) */
    val maxCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(DECIMAL) */
    val maxCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_4g")
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(DECIMAL) */
    val maxCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_2g")
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(DECIMAL) */
    val avgCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_4g")
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(DECIMAL) */
    val avgCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VDashboardHourlyVendorPerformanceHistory */
  lazy val VDashboardHourlyVendorPerformanceHistory = new TableQuery(tag => new VDashboardHourlyVendorPerformanceHistory(tag))
  
  /** Row type of table VDashboardMonthlyOperatorPerformanceHistory */
  type VDashboardMonthlyOperatorPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardMonthlyOperatorPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardMonthlyOperatorPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], siteId: Option[String], sectorNo: Option[Int], minKnownCellsAll: Option[Long], minKnownCells4g: Option[Long], minKnownCells3g: Option[Long], minKnownCells2g: Option[Long], maxKnownCellsAll: Option[Long], maxKnownCells4g: Option[Long], maxKnownCells3g: Option[Long], maxKnownCells2g: Option[Long], avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Option[scala.math.BigDecimal], avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Option[scala.math.BigDecimal], minCisKpiAll: Option[Long], minCisKpi4g: Option[scala.math.BigDecimal], minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Option[scala.math.BigDecimal], maxCisKpiAll: Option[Long], maxCisKpi4g: Option[scala.math.BigDecimal], maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Option[scala.math.BigDecimal], avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Option[scala.math.BigDecimal], avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Option[scala.math.BigDecimal]): VDashboardMonthlyOperatorPerformanceHistoryRow = {
    measurementTime :: groupId :: siteId :: sectorNo :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: HNil
  }
  /** GetResult implicit for fetching VDashboardMonthlyOperatorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardMonthlyOperatorPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Long]], e4: GR[Option[scala.math.BigDecimal]]): GR[VDashboardMonthlyOperatorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: HNil
  }
  /** Table description of table v_dashboard_monthly_operator_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardMonthlyOperatorPerformanceHistory(_tableTag: Tag) extends Table[VDashboardMonthlyOperatorPerformanceHistoryRow](_tableTag, "v_dashboard_monthly_operator_performance_history") {
    def * = measurementTime :: groupId :: siteId :: sectorNo :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(BIGINT) */
    val minKnownCells4g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_4g")
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(BIGINT) */
    val minKnownCells2g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_2g")
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(BIGINT) */
    val maxKnownCells4g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_4g")
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(BIGINT) */
    val maxKnownCells2g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_2g")
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(DECIMAL) */
    val avgKnownCells4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_4g")
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(DECIMAL) */
    val avgKnownCells2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_2g")
    /** Database column min_cis_kpi_all DBType(BIGINT) */
    val minCisKpiAll: Column[Option[Long]] = column[Option[Long]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(DECIMAL) */
    val minCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_4g")
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(DECIMAL) */
    val minCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_2g")
    /** Database column max_cis_kpi_all DBType(BIGINT) */
    val maxCisKpiAll: Column[Option[Long]] = column[Option[Long]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(DECIMAL) */
    val maxCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_4g")
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(DECIMAL) */
    val maxCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_2g")
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(DECIMAL) */
    val avgCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_4g")
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(DECIMAL) */
    val avgCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_2g")
  }
  /** Collection-like TableQuery object for table VDashboardMonthlyOperatorPerformanceHistory */
  lazy val VDashboardMonthlyOperatorPerformanceHistory = new TableQuery(tag => new VDashboardMonthlyOperatorPerformanceHistory(tag))
  
  /** Row type of table VDashboardMonthlyPerformanceHistory */
  type VDashboardMonthlyPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardMonthlyPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardMonthlyPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], minKnownCellsAll: Option[Long], minKnownCells4g: Option[Long], minKnownCells3g: Option[Long], minKnownCells2g: Option[Long], maxKnownCellsAll: Option[Long], maxKnownCells4g: Option[Long], maxKnownCells3g: Option[Long], maxKnownCells2g: Option[Long], avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Option[scala.math.BigDecimal], avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Option[scala.math.BigDecimal], minCisKpiAll: Option[Long], minCisKpi4g: Option[scala.math.BigDecimal], minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Option[scala.math.BigDecimal], maxCisKpiAll: Option[Long], maxCisKpi4g: Option[scala.math.BigDecimal], maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Option[scala.math.BigDecimal], avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Option[scala.math.BigDecimal], avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Option[scala.math.BigDecimal]): VDashboardMonthlyPerformanceHistoryRow = {
    measurementTime :: groupId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: HNil
  }
  /** GetResult implicit for fetching VDashboardMonthlyPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardMonthlyPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]]): GR[VDashboardMonthlyPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: HNil
  }
  /** Table description of table v_dashboard_monthly_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardMonthlyPerformanceHistory(_tableTag: Tag) extends Table[VDashboardMonthlyPerformanceHistoryRow](_tableTag, "v_dashboard_monthly_performance_history") {
    def * = measurementTime :: groupId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(BIGINT) */
    val minKnownCells4g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_4g")
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(BIGINT) */
    val minKnownCells2g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_2g")
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(BIGINT) */
    val maxKnownCells4g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_4g")
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(BIGINT) */
    val maxKnownCells2g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_2g")
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(DECIMAL) */
    val avgKnownCells4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_4g")
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(DECIMAL) */
    val avgKnownCells2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_2g")
    /** Database column min_cis_kpi_all DBType(BIGINT) */
    val minCisKpiAll: Column[Option[Long]] = column[Option[Long]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(DECIMAL) */
    val minCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_4g")
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(DECIMAL) */
    val minCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_2g")
    /** Database column max_cis_kpi_all DBType(BIGINT) */
    val maxCisKpiAll: Column[Option[Long]] = column[Option[Long]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(DECIMAL) */
    val maxCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_4g")
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(DECIMAL) */
    val maxCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_2g")
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(DECIMAL) */
    val avgCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_4g")
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(DECIMAL) */
    val avgCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_2g")
  }
  /** Collection-like TableQuery object for table VDashboardMonthlyPerformanceHistory */
  lazy val VDashboardMonthlyPerformanceHistory = new TableQuery(tag => new VDashboardMonthlyPerformanceHistory(tag))
  
  /** Row type of table VDashboardMonthlyVendorPerformanceHistory */
  type VDashboardMonthlyVendorPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardMonthlyVendorPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardMonthlyVendorPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], vendorId: Option[String], minKnownCellsAll: Option[Long], minKnownCells4g: Option[Long], minKnownCells3g: Option[Long], minKnownCells2g: Option[Long], maxKnownCellsAll: Option[Long], maxKnownCells4g: Option[Long], maxKnownCells3g: Option[Long], maxKnownCells2g: Option[Long], avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Option[scala.math.BigDecimal], avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Option[scala.math.BigDecimal], minCisKpiAll: Option[scala.math.BigDecimal], minCisKpi4g: Option[scala.math.BigDecimal], minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Option[scala.math.BigDecimal], maxCisKpiAll: Option[scala.math.BigDecimal], maxCisKpi4g: Option[scala.math.BigDecimal], maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Option[scala.math.BigDecimal], avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Option[scala.math.BigDecimal], avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VDashboardMonthlyVendorPerformanceHistoryRow = {
    measurementTime :: groupId :: vendorId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VDashboardMonthlyVendorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardMonthlyVendorPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VDashboardMonthlyVendorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table v_dashboard_monthly_vendor_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardMonthlyVendorPerformanceHistory(_tableTag: Tag) extends Table[VDashboardMonthlyVendorPerformanceHistoryRow](_tableTag, "v_dashboard_monthly_vendor_performance_history") {
    def * = measurementTime :: groupId :: vendorId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(BIGINT) */
    val minKnownCells4g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_4g")
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(BIGINT) */
    val minKnownCells2g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_2g")
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(BIGINT) */
    val maxKnownCells4g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_4g")
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(BIGINT) */
    val maxKnownCells2g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_2g")
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(DECIMAL) */
    val avgKnownCells4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_4g")
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(DECIMAL) */
    val avgKnownCells2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_2g")
    /** Database column min_cis_kpi_all DBType(DECIMAL) */
    val minCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(DECIMAL) */
    val minCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_4g")
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(DECIMAL) */
    val minCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_2g")
    /** Database column max_cis_kpi_all DBType(DECIMAL) */
    val maxCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(DECIMAL) */
    val maxCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_4g")
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(DECIMAL) */
    val maxCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_2g")
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(DECIMAL) */
    val avgCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_4g")
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(DECIMAL) */
    val avgCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VDashboardMonthlyVendorPerformanceHistory */
  lazy val VDashboardMonthlyVendorPerformanceHistory = new TableQuery(tag => new VDashboardMonthlyVendorPerformanceHistory(tag))
  
  /** Entity class storing rows of table VDashboardNode
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param generation Database column generation DBType(INT)
   *  @param enabled Database column enabled DBType(BIT) */
  case class VDashboardNodeRow(nodeId: String, generation: Int, enabled: Option[Boolean])
  /** GetResult implicit for fetching VDashboardNodeRow objects using plain SQL queries */
  implicit def GetResultVDashboardNodeRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[Boolean]]): GR[VDashboardNodeRow] = GR{
    prs => import prs._
    VDashboardNodeRow.tupled((<<[String], <<[Int], <<?[Boolean]))
  }
  /** Table description of table v_dashboard_node. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardNode(_tableTag: Tag) extends Table[VDashboardNodeRow](_tableTag, "v_dashboard_node") {
    def * = (nodeId, generation, enabled) <> (VDashboardNodeRow.tupled, VDashboardNodeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (nodeId.?, generation.?, enabled).shaped.<>({r=>import r._; _1.map(_=> VDashboardNodeRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[String] = column[String]("node_id", O.Length(50,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column enabled DBType(BIT) */
    val enabled: Column[Option[Boolean]] = column[Option[Boolean]]("enabled")
  }
  /** Collection-like TableQuery object for table VDashboardNode */
  lazy val VDashboardNode = new TableQuery(tag => new VDashboardNode(tag))
  
  /** Entity class storing rows of table VDashboardNote
   *  @param groupId Database column group_id DBType(VARCHAR), Length(3,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param noteTimestamp Database column note_timestamp DBType(DATETIME)
   *  @param username Database column username DBType(VARCHAR), Length(256,true)
   *  @param note Database column note DBType(VARCHAR), Length(4096,true) */
  case class VDashboardNoteRow(groupId: String, siteId: String, noteTimestamp: java.sql.Timestamp, username: Option[String], note: String)
  /** GetResult implicit for fetching VDashboardNoteRow objects using plain SQL queries */
  implicit def GetResultVDashboardNoteRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp], e2: GR[Option[String]]): GR[VDashboardNoteRow] = GR{
    prs => import prs._
    VDashboardNoteRow.tupled((<<[String], <<[String], <<[java.sql.Timestamp], <<?[String], <<[String]))
  }
  /** Table description of table v_dashboard_note. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardNote(_tableTag: Tag) extends Table[VDashboardNoteRow](_tableTag, "v_dashboard_note") {
    def * = (groupId, siteId, noteTimestamp, username, note) <> (VDashboardNoteRow.tupled, VDashboardNoteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, siteId.?, noteTimestamp.?, username, note.?).shaped.<>({r=>import r._; _1.map(_=> VDashboardNoteRow.tupled((_1.get, _2.get, _3.get, _4, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(3,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(3,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column note_timestamp DBType(DATETIME) */
    val noteTimestamp: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("note_timestamp")
    /** Database column username DBType(VARCHAR), Length(256,true) */
    val username: Column[Option[String]] = column[Option[String]]("username", O.Length(256,varying=true))
    /** Database column note DBType(VARCHAR), Length(4096,true) */
    val note: Column[String] = column[String]("note", O.Length(4096,varying=true))
  }
  /** Collection-like TableQuery object for table VDashboardNote */
  lazy val VDashboardNote = new TableQuery(tag => new VDashboardNote(tag))
  
  /** Entity class storing rows of table VDashboardPerformanceAlertMessage
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param message Database column message DBType(VARCHAR), Length(256,true) */
  case class VDashboardPerformanceAlertMessageRow(groupId: Option[String], message: Option[String])
  /** GetResult implicit for fetching VDashboardPerformanceAlertMessageRow objects using plain SQL queries */
  implicit def GetResultVDashboardPerformanceAlertMessageRow(implicit e0: GR[Option[String]]): GR[VDashboardPerformanceAlertMessageRow] = GR{
    prs => import prs._
    VDashboardPerformanceAlertMessageRow.tupled((<<?[String], <<?[String]))
  }
  /** Table description of table v_dashboard_performance_alert_message. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardPerformanceAlertMessage(_tableTag: Tag) extends Table[VDashboardPerformanceAlertMessageRow](_tableTag, "v_dashboard_performance_alert_message") {
    def * = (groupId, message) <> (VDashboardPerformanceAlertMessageRow.tupled, VDashboardPerformanceAlertMessageRow.unapply)
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column message DBType(VARCHAR), Length(256,true) */
    val message: Column[Option[String]] = column[Option[String]]("message", O.Length(256,varying=true))
  }
  /** Collection-like TableQuery object for table VDashboardPerformanceAlertMessage */
  lazy val VDashboardPerformanceAlertMessage = new TableQuery(tag => new VDashboardPerformanceAlertMessage(tag))
  
  /** Entity class storing rows of table VDashboardPerformanceAlertStatus
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param alertCount Database column alert_count DBType(BIGINT), Default(0) */
  case class VDashboardPerformanceAlertStatusRow(groupId: Option[String], alertCount: Long = 0L)
  /** GetResult implicit for fetching VDashboardPerformanceAlertStatusRow objects using plain SQL queries */
  implicit def GetResultVDashboardPerformanceAlertStatusRow(implicit e0: GR[Option[String]], e1: GR[Long]): GR[VDashboardPerformanceAlertStatusRow] = GR{
    prs => import prs._
    VDashboardPerformanceAlertStatusRow.tupled((<<?[String], <<[Long]))
  }
  /** Table description of table v_dashboard_performance_alert_status. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardPerformanceAlertStatus(_tableTag: Tag) extends Table[VDashboardPerformanceAlertStatusRow](_tableTag, "v_dashboard_performance_alert_status") {
    def * = (groupId, alertCount) <> (VDashboardPerformanceAlertStatusRow.tupled, VDashboardPerformanceAlertStatusRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId, alertCount.?).shaped.<>({r=>import r._; _2.map(_=> VDashboardPerformanceAlertStatusRow.tupled((_1, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column alert_count DBType(BIGINT), Default(0) */
    val alertCount: Column[Long] = column[Long]("alert_count", O.Default(0L))
  }
  /** Collection-like TableQuery object for table VDashboardPerformanceAlertStatus */
  lazy val VDashboardPerformanceAlertStatus = new TableQuery(tag => new VDashboardPerformanceAlertStatus(tag))
  
  /** Row type of table VDashboardPerformanceHistory */
  type VDashboardPerformanceHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardPerformanceHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], knownCellsAll: Option[Long], knownCells4g: Option[Long], knownCells3g: Option[Long], knownCells2g: Option[Long], downCellsAll: Option[Long], downCells4g: Option[Long], downCells3g: Option[Long], downCells2g: Option[Long], blockedCellsAll: Option[Long], blockedCells4g: Option[Long], blockedCells3g: Option[Long], blockedCells2g: Option[Long], cisKpiAll: Option[Long], cisKpi4g: Option[scala.math.BigDecimal], cisKpi3g: Option[scala.math.BigDecimal], cisKpi2g: Option[scala.math.BigDecimal], cisKpiSeverityAll: Option[Int], cisKpiSeverity4g: Option[Int], cisKpiSeverity3g: Option[Int], cisKpiSeverity2g: Option[Int], sectorNo: Option[Int]): VDashboardPerformanceHistoryRow = {
    measurementTime :: groupId :: knownCellsAll :: knownCells4g :: knownCells3g :: knownCells2g :: downCellsAll :: downCells4g :: downCells3g :: downCells2g :: blockedCellsAll :: blockedCells4g :: blockedCells3g :: blockedCells2g :: cisKpiAll :: cisKpi4g :: cisKpi3g :: cisKpi2g :: cisKpiSeverityAll :: cisKpiSeverity4g :: cisKpiSeverity3g :: cisKpiSeverity2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VDashboardPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardPerformanceHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VDashboardPerformanceHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: HNil
  }
  /** Table description of table v_dashboard_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardPerformanceHistory(_tableTag: Tag) extends Table[VDashboardPerformanceHistoryRow](_tableTag, "v_dashboard_performance_history") {
    def * = measurementTime :: groupId :: knownCellsAll :: knownCells4g :: knownCells3g :: knownCells2g :: downCellsAll :: downCells4g :: downCells3g :: downCells2g :: blockedCellsAll :: blockedCells4g :: blockedCells3g :: blockedCells2g :: cisKpiAll :: cisKpi4g :: cisKpi3g :: cisKpi2g :: cisKpiSeverityAll :: cisKpiSeverity4g :: cisKpiSeverity3g :: cisKpiSeverity2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column cis_kpi_all DBType(BIGINT) */
    val cisKpiAll: Column[Option[Long]] = column[Option[Long]]("cis_kpi_all")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column cis_kpi_severity_all DBType(INT) */
    val cisKpiSeverityAll: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_all")
    /** Database column cis_kpi_severity_4g DBType(INT) */
    val cisKpiSeverity4g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_4g")
    /** Database column cis_kpi_severity_3g DBType(INT) */
    val cisKpiSeverity3g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_3g")
    /** Database column cis_kpi_severity_2g DBType(INT) */
    val cisKpiSeverity2g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VDashboardPerformanceHistory */
  lazy val VDashboardPerformanceHistory = new TableQuery(tag => new VDashboardPerformanceHistory(tag))
  
  /** Entity class storing rows of table VDashboardQualityAlertMessage
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param message Database column message DBType(VARCHAR), Length(73,true) */
  case class VDashboardQualityAlertMessageRow(groupId: Option[String], message: Option[String])
  /** GetResult implicit for fetching VDashboardQualityAlertMessageRow objects using plain SQL queries */
  implicit def GetResultVDashboardQualityAlertMessageRow(implicit e0: GR[Option[String]]): GR[VDashboardQualityAlertMessageRow] = GR{
    prs => import prs._
    VDashboardQualityAlertMessageRow.tupled((<<?[String], <<?[String]))
  }
  /** Table description of table v_dashboard_quality_alert_message. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardQualityAlertMessage(_tableTag: Tag) extends Table[VDashboardQualityAlertMessageRow](_tableTag, "v_dashboard_quality_alert_message") {
    def * = (groupId, message) <> (VDashboardQualityAlertMessageRow.tupled, VDashboardQualityAlertMessageRow.unapply)
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column message DBType(VARCHAR), Length(73,true) */
    val message: Column[Option[String]] = column[Option[String]]("message", O.Length(73,varying=true))
  }
  /** Collection-like TableQuery object for table VDashboardQualityAlertMessage */
  lazy val VDashboardQualityAlertMessage = new TableQuery(tag => new VDashboardQualityAlertMessage(tag))
  
  /** Entity class storing rows of table VDashboardQualityAlertStatus
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param alertCount Database column alert_count DBType(BIGINT), Default(0) */
  case class VDashboardQualityAlertStatusRow(groupId: Option[String], alertCount: Long = 0L)
  /** GetResult implicit for fetching VDashboardQualityAlertStatusRow objects using plain SQL queries */
  implicit def GetResultVDashboardQualityAlertStatusRow(implicit e0: GR[Option[String]], e1: GR[Long]): GR[VDashboardQualityAlertStatusRow] = GR{
    prs => import prs._
    VDashboardQualityAlertStatusRow.tupled((<<?[String], <<[Long]))
  }
  /** Table description of table v_dashboard_quality_alert_status. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardQualityAlertStatus(_tableTag: Tag) extends Table[VDashboardQualityAlertStatusRow](_tableTag, "v_dashboard_quality_alert_status") {
    def * = (groupId, alertCount) <> (VDashboardQualityAlertStatusRow.tupled, VDashboardQualityAlertStatusRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId, alertCount.?).shaped.<>({r=>import r._; _2.map(_=> VDashboardQualityAlertStatusRow.tupled((_1, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column alert_count DBType(BIGINT), Default(0) */
    val alertCount: Column[Long] = column[Long]("alert_count", O.Default(0L))
  }
  /** Collection-like TableQuery object for table VDashboardQualityAlertStatus */
  lazy val VDashboardQualityAlertStatus = new TableQuery(tag => new VDashboardQualityAlertStatus(tag))
  
  /** Row type of table VDashboardSectorHistory */
  type VDashboardSectorHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Int,HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Int,HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Int,HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardSectorHistoryRow providing default values if available in the database schema. */
  def VDashboardSectorHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], siteId: Option[String], sitePriority: Option[Int], siteExclude: Int = 0, exclude2g: Option[Int], exclude3g: Option[Int], exclude4g: Option[Int], siteSticky: Int = 0, coos2g: Option[Long], coos3g: Option[Long], coos4g: Option[Long], coosAll: Option[Long], up: Int = 0, downtime: Option[String], vendorId2g: Option[String], sector0State2g: Option[Long], sector1State2g: Option[Long], sector2State2g: Option[Long], sector3State2g: Option[Long], vendorId3g: Option[String], sector0State3g: Option[Long], sector1State3g: Option[Long], sector2State3g: Option[Long], sector3State3g: Option[Long], vendorId4g: Option[String], sector0State4g: Option[Long], sector1State4g: Option[Long], sector2State4g: Option[Long], sector3State4g: Option[Long]): VDashboardSectorHistoryRow = {
    measurementTime :: groupId :: siteId :: sitePriority :: siteExclude :: exclude2g :: exclude3g :: exclude4g :: siteSticky :: coos2g :: coos3g :: coos4g :: coosAll :: up :: downtime :: vendorId2g :: sector0State2g :: sector1State2g :: sector2State2g :: sector3State2g :: vendorId3g :: sector0State3g :: sector1State3g :: sector2State3g :: sector3State3g :: vendorId4g :: sector0State4g :: sector1State4g :: sector2State4g :: sector3State4g :: HNil
  }
  /** GetResult implicit for fetching VDashboardSectorHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardSectorHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Int], e4: GR[Option[Long]]): GR[VDashboardSectorHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<[Int] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<[Int] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: HNil
  }
  /** Table description of table v_dashboard_sector_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardSectorHistory(_tableTag: Tag) extends Table[VDashboardSectorHistoryRow](_tableTag, "v_dashboard_sector_history") {
    def * = measurementTime :: groupId :: siteId :: sitePriority :: siteExclude :: exclude2g :: exclude3g :: exclude4g :: siteSticky :: coos2g :: coos3g :: coos4g :: coosAll :: up :: downtime :: vendorId2g :: sector0State2g :: sector1State2g :: sector2State2g :: sector3State2g :: vendorId3g :: sector0State3g :: sector1State3g :: sector2State3g :: sector3State3g :: vendorId4g :: sector0State4g :: sector1State4g :: sector2State4g :: sector3State4g :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column site_priority DBType(INT) */
    val sitePriority: Column[Option[Int]] = column[Option[Int]]("site_priority")
    /** Database column site_exclude DBType(INT), Default(0) */
    val siteExclude: Column[Int] = column[Int]("site_exclude", O.Default(0))
    /** Database column exclude_2g DBType(INT) */
    val exclude2g: Column[Option[Int]] = column[Option[Int]]("exclude_2g")
    /** Database column exclude_3g DBType(INT) */
    val exclude3g: Column[Option[Int]] = column[Option[Int]]("exclude_3g")
    /** Database column exclude_4g DBType(INT) */
    val exclude4g: Column[Option[Int]] = column[Option[Int]]("exclude_4g")
    /** Database column site_sticky DBType(INT), Default(0) */
    val siteSticky: Column[Int] = column[Int]("site_sticky", O.Default(0))
    /** Database column coos_2g DBType(BIGINT) */
    val coos2g: Column[Option[Long]] = column[Option[Long]]("coos_2g")
    /** Database column coos_3g DBType(BIGINT) */
    val coos3g: Column[Option[Long]] = column[Option[Long]]("coos_3g")
    /** Database column coos_4g DBType(BIGINT) */
    val coos4g: Column[Option[Long]] = column[Option[Long]]("coos_4g")
    /** Database column coos_all DBType(BIGINT) */
    val coosAll: Column[Option[Long]] = column[Option[Long]]("coos_all")
    /** Database column up DBType(INT), Default(0) */
    val up: Column[Int] = column[Int]("up", O.Default(0))
    /** Database column downtime DBType(VARCHAR), Length(10,true) */
    val downtime: Column[Option[String]] = column[Option[String]]("downtime", O.Length(10,varying=true))
    /** Database column vendor_id_2g DBType(VARCHAR), Length(50,true) */
    val vendorId2g: Column[Option[String]] = column[Option[String]]("vendor_id_2g", O.Length(50,varying=true))
    /** Database column sector_0_state_2g DBType(BIGINT) */
    val sector0State2g: Column[Option[Long]] = column[Option[Long]]("sector_0_state_2g")
    /** Database column sector_1_state_2g DBType(BIGINT) */
    val sector1State2g: Column[Option[Long]] = column[Option[Long]]("sector_1_state_2g")
    /** Database column sector_2_state_2g DBType(BIGINT) */
    val sector2State2g: Column[Option[Long]] = column[Option[Long]]("sector_2_state_2g")
    /** Database column sector_3_state_2g DBType(BIGINT) */
    val sector3State2g: Column[Option[Long]] = column[Option[Long]]("sector_3_state_2g")
    /** Database column vendor_id_3g DBType(VARCHAR), Length(50,true) */
    val vendorId3g: Column[Option[String]] = column[Option[String]]("vendor_id_3g", O.Length(50,varying=true))
    /** Database column sector_0_state_3g DBType(BIGINT) */
    val sector0State3g: Column[Option[Long]] = column[Option[Long]]("sector_0_state_3g")
    /** Database column sector_1_state_3g DBType(BIGINT) */
    val sector1State3g: Column[Option[Long]] = column[Option[Long]]("sector_1_state_3g")
    /** Database column sector_2_state_3g DBType(BIGINT) */
    val sector2State3g: Column[Option[Long]] = column[Option[Long]]("sector_2_state_3g")
    /** Database column sector_3_state_3g DBType(BIGINT) */
    val sector3State3g: Column[Option[Long]] = column[Option[Long]]("sector_3_state_3g")
    /** Database column vendor_id_4g DBType(VARCHAR), Length(50,true) */
    val vendorId4g: Column[Option[String]] = column[Option[String]]("vendor_id_4g", O.Length(50,varying=true))
    /** Database column sector_0_state_4g DBType(BIGINT) */
    val sector0State4g: Column[Option[Long]] = column[Option[Long]]("sector_0_state_4g")
    /** Database column sector_1_state_4g DBType(BIGINT) */
    val sector1State4g: Column[Option[Long]] = column[Option[Long]]("sector_1_state_4g")
    /** Database column sector_2_state_4g DBType(BIGINT) */
    val sector2State4g: Column[Option[Long]] = column[Option[Long]]("sector_2_state_4g")
    /** Database column sector_3_state_4g DBType(BIGINT) */
    val sector3State4g: Column[Option[Long]] = column[Option[Long]]("sector_3_state_4g")
  }
  /** Collection-like TableQuery object for table VDashboardSectorHistory */
  lazy val VDashboardSectorHistory = new TableQuery(tag => new VDashboardSectorHistory(tag))
  
  /** Entity class storing rows of table VDashboardSectorIdentity
   *  @param sectorId Database column sector_id DBType(VARCHAR), Length(50,true)
   *  @param generation Database column generation DBType(INT)
   *  @param sectorNo Database column sector_no DBType(INT) */
  case class VDashboardSectorIdentityRow(sectorId: String, generation: Int, sectorNo: Int)
  /** GetResult implicit for fetching VDashboardSectorIdentityRow objects using plain SQL queries */
  implicit def GetResultVDashboardSectorIdentityRow(implicit e0: GR[String], e1: GR[Int]): GR[VDashboardSectorIdentityRow] = GR{
    prs => import prs._
    VDashboardSectorIdentityRow.tupled((<<[String], <<[Int], <<[Int]))
  }
  /** Table description of table v_dashboard_sector_identity. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardSectorIdentity(_tableTag: Tag) extends Table[VDashboardSectorIdentityRow](_tableTag, "v_dashboard_sector_identity") {
    def * = (sectorId, generation, sectorNo) <> (VDashboardSectorIdentityRow.tupled, VDashboardSectorIdentityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (sectorId.?, generation.?, sectorNo.?).shaped.<>({r=>import r._; _1.map(_=> VDashboardSectorIdentityRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column sector_id DBType(VARCHAR), Length(50,true) */
    val sectorId: Column[String] = column[String]("sector_id", O.Length(50,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Int] = column[Int]("sector_no")
  }
  /** Collection-like TableQuery object for table VDashboardSectorIdentity */
  lazy val VDashboardSectorIdentity = new TableQuery(tag => new VDashboardSectorIdentity(tag))
  
  /** Row type of table VDashboardSectorOutageHistory */
  type VDashboardSectorOutageHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Int,HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Int,HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardSectorOutageHistoryRow providing default values if available in the database schema. */
  def VDashboardSectorOutageHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], siteId: Option[String], sitePriority: Option[Int], siteExclude: Int = 0, exclude2g: Option[Int], exclude3g: Option[Int], exclude4g: Option[Int], siteSticky: Int = 0, coos2g: Option[Long], coos3g: Option[Long], coos4g: Option[Long], coosAll: Option[Long], downtime: Option[String], ticketPriority: Option[String], noteCount: Option[Long] = Some(0L), vendorId2g: Option[String], sector0State2g: Option[Long], sector1State2g: Option[Long], sector2State2g: Option[Long], sector3State2g: Option[Long], vendorId3g: Option[String], sector0State3g: Option[Long], sector1State3g: Option[Long], sector2State3g: Option[Long], sector3State3g: Option[Long], vendorId4g: Option[String], sector0State4g: Option[Long], sector1State4g: Option[Long], sector2State4g: Option[Long], sector3State4g: Option[Long]): VDashboardSectorOutageHistoryRow = {
    measurementTime :: groupId :: siteId :: sitePriority :: siteExclude :: exclude2g :: exclude3g :: exclude4g :: siteSticky :: coos2g :: coos3g :: coos4g :: coosAll :: downtime :: ticketPriority :: noteCount :: vendorId2g :: sector0State2g :: sector1State2g :: sector2State2g :: sector3State2g :: vendorId3g :: sector0State3g :: sector1State3g :: sector2State3g :: sector3State3g :: vendorId4g :: sector0State4g :: sector1State4g :: sector2State4g :: sector3State4g :: HNil
  }
  /** GetResult implicit for fetching VDashboardSectorOutageHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardSectorOutageHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Int], e4: GR[Option[Long]]): GR[VDashboardSectorOutageHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<[Int] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: HNil
  }
  /** Table description of table v_dashboard_sector_outage_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardSectorOutageHistory(_tableTag: Tag) extends Table[VDashboardSectorOutageHistoryRow](_tableTag, "v_dashboard_sector_outage_history") {
    def * = measurementTime :: groupId :: siteId :: sitePriority :: siteExclude :: exclude2g :: exclude3g :: exclude4g :: siteSticky :: coos2g :: coos3g :: coos4g :: coosAll :: downtime :: ticketPriority :: noteCount :: vendorId2g :: sector0State2g :: sector1State2g :: sector2State2g :: sector3State2g :: vendorId3g :: sector0State3g :: sector1State3g :: sector2State3g :: sector3State3g :: vendorId4g :: sector0State4g :: sector1State4g :: sector2State4g :: sector3State4g :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column site_priority DBType(INT) */
    val sitePriority: Column[Option[Int]] = column[Option[Int]]("site_priority")
    /** Database column site_exclude DBType(INT), Default(0) */
    val siteExclude: Column[Int] = column[Int]("site_exclude", O.Default(0))
    /** Database column exclude_2g DBType(INT) */
    val exclude2g: Column[Option[Int]] = column[Option[Int]]("exclude_2g")
    /** Database column exclude_3g DBType(INT) */
    val exclude3g: Column[Option[Int]] = column[Option[Int]]("exclude_3g")
    /** Database column exclude_4g DBType(INT) */
    val exclude4g: Column[Option[Int]] = column[Option[Int]]("exclude_4g")
    /** Database column site_sticky DBType(INT), Default(0) */
    val siteSticky: Column[Int] = column[Int]("site_sticky", O.Default(0))
    /** Database column coos_2g DBType(BIGINT) */
    val coos2g: Column[Option[Long]] = column[Option[Long]]("coos_2g")
    /** Database column coos_3g DBType(BIGINT) */
    val coos3g: Column[Option[Long]] = column[Option[Long]]("coos_3g")
    /** Database column coos_4g DBType(BIGINT) */
    val coos4g: Column[Option[Long]] = column[Option[Long]]("coos_4g")
    /** Database column coos_all DBType(BIGINT) */
    val coosAll: Column[Option[Long]] = column[Option[Long]]("coos_all")
    /** Database column downtime DBType(VARCHAR), Length(10,true) */
    val downtime: Column[Option[String]] = column[Option[String]]("downtime", O.Length(10,varying=true))
    /** Database column ticket_priority DBType(VARCHAR), Length(20,true) */
    val ticketPriority: Column[Option[String]] = column[Option[String]]("ticket_priority", O.Length(20,varying=true))
    /** Database column note_count DBType(BIGINT), Default(Some(0)) */
    val noteCount: Column[Option[Long]] = column[Option[Long]]("note_count", O.Default(Some(0L)))
    /** Database column vendor_id_2g DBType(VARCHAR), Length(50,true) */
    val vendorId2g: Column[Option[String]] = column[Option[String]]("vendor_id_2g", O.Length(50,varying=true))
    /** Database column sector_0_state_2g DBType(BIGINT) */
    val sector0State2g: Column[Option[Long]] = column[Option[Long]]("sector_0_state_2g")
    /** Database column sector_1_state_2g DBType(BIGINT) */
    val sector1State2g: Column[Option[Long]] = column[Option[Long]]("sector_1_state_2g")
    /** Database column sector_2_state_2g DBType(BIGINT) */
    val sector2State2g: Column[Option[Long]] = column[Option[Long]]("sector_2_state_2g")
    /** Database column sector_3_state_2g DBType(BIGINT) */
    val sector3State2g: Column[Option[Long]] = column[Option[Long]]("sector_3_state_2g")
    /** Database column vendor_id_3g DBType(VARCHAR), Length(50,true) */
    val vendorId3g: Column[Option[String]] = column[Option[String]]("vendor_id_3g", O.Length(50,varying=true))
    /** Database column sector_0_state_3g DBType(BIGINT) */
    val sector0State3g: Column[Option[Long]] = column[Option[Long]]("sector_0_state_3g")
    /** Database column sector_1_state_3g DBType(BIGINT) */
    val sector1State3g: Column[Option[Long]] = column[Option[Long]]("sector_1_state_3g")
    /** Database column sector_2_state_3g DBType(BIGINT) */
    val sector2State3g: Column[Option[Long]] = column[Option[Long]]("sector_2_state_3g")
    /** Database column sector_3_state_3g DBType(BIGINT) */
    val sector3State3g: Column[Option[Long]] = column[Option[Long]]("sector_3_state_3g")
    /** Database column vendor_id_4g DBType(VARCHAR), Length(50,true) */
    val vendorId4g: Column[Option[String]] = column[Option[String]]("vendor_id_4g", O.Length(50,varying=true))
    /** Database column sector_0_state_4g DBType(BIGINT) */
    val sector0State4g: Column[Option[Long]] = column[Option[Long]]("sector_0_state_4g")
    /** Database column sector_1_state_4g DBType(BIGINT) */
    val sector1State4g: Column[Option[Long]] = column[Option[Long]]("sector_1_state_4g")
    /** Database column sector_2_state_4g DBType(BIGINT) */
    val sector2State4g: Column[Option[Long]] = column[Option[Long]]("sector_2_state_4g")
    /** Database column sector_3_state_4g DBType(BIGINT) */
    val sector3State4g: Column[Option[Long]] = column[Option[Long]]("sector_3_state_4g")
  }
  /** Collection-like TableQuery object for table VDashboardSectorOutageHistory */
  lazy val VDashboardSectorOutageHistory = new TableQuery(tag => new VDashboardSectorOutageHistory(tag))
  
  /** Entity class storing rows of table VDashboardSite
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param generation Database column generation DBType(INT)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param exclude Database column exclude DBType(BIT)
   *  @param sticky Database column sticky DBType(BIT)
   *  @param priority Database column priority DBType(INT), Default(99) */
  case class VDashboardSiteRow(siteId: String, nodeId: Option[String], groupId: String, generation: Int, vendorId: String, exclude: Boolean, sticky: Boolean, priority: Int = 99)
  /** GetResult implicit for fetching VDashboardSiteRow objects using plain SQL queries */
  implicit def GetResultVDashboardSiteRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Int], e3: GR[Boolean]): GR[VDashboardSiteRow] = GR{
    prs => import prs._
    VDashboardSiteRow.tupled((<<[String], <<?[String], <<[String], <<[Int], <<[String], <<[Boolean], <<[Boolean], <<[Int]))
  }
  /** Table description of table v_dashboard_site. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardSite(_tableTag: Tag) extends Table[VDashboardSiteRow](_tableTag, "v_dashboard_site") {
    def * = (siteId, nodeId, groupId, generation, vendorId, exclude, sticky, priority) <> (VDashboardSiteRow.tupled, VDashboardSiteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (siteId.?, nodeId, groupId.?, generation.?, vendorId.?, exclude.?, sticky.?, priority.?).shaped.<>({r=>import r._; _1.map(_=> VDashboardSiteRow.tupled((_1.get, _2, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[String] = column[String]("vendor_id", O.Length(50,varying=true))
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Boolean] = column[Boolean]("exclude")
    /** Database column sticky DBType(BIT) */
    val sticky: Column[Boolean] = column[Boolean]("sticky")
    /** Database column priority DBType(INT), Default(99) */
    val priority: Column[Int] = column[Int]("priority", O.Default(99))
  }
  /** Collection-like TableQuery object for table VDashboardSite */
  lazy val VDashboardSite = new TableQuery(tag => new VDashboardSite(tag))
  
  /** Row type of table VDashboardSiteOperatorPerformanceHistory */
  type VDashboardSiteOperatorPerformanceHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardSiteOperatorPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardSiteOperatorPerformanceHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], siteId: Option[String], knownCellsAll: Option[Long], knownCells4g: Option[Long], knownCells3g: Option[Long], knownCells2g: Option[Long], downCellsAll: Option[Long], downCells4g: Option[Long], downCells3g: Option[Long], downCells2g: Option[Long], blockedCellsAll: Option[Long], blockedCells4g: Option[Long], blockedCells3g: Option[Long], blockedCells2g: Option[Long], cisKpiAll: Option[scala.math.BigDecimal], cisKpi4g: Option[scala.math.BigDecimal], cisKpi3g: Option[scala.math.BigDecimal], cisKpi2g: Option[scala.math.BigDecimal], cisKpiSeverityAll: Option[Int], cisKpiSeverity4g: Option[Int], cisKpiSeverity3g: Option[Int], cisKpiSeverity2g: Option[Int], sectorNo: Option[Int]): VDashboardSiteOperatorPerformanceHistoryRow = {
    measurementTime :: groupId :: siteId :: knownCellsAll :: knownCells4g :: knownCells3g :: knownCells2g :: downCellsAll :: downCells4g :: downCells3g :: downCells2g :: blockedCellsAll :: blockedCells4g :: blockedCells3g :: blockedCells2g :: cisKpiAll :: cisKpi4g :: cisKpi3g :: cisKpi2g :: cisKpiSeverityAll :: cisKpiSeverity4g :: cisKpiSeverity3g :: cisKpiSeverity2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VDashboardSiteOperatorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardSiteOperatorPerformanceHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VDashboardSiteOperatorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: HNil
  }
  /** Table description of table v_dashboard_site_operator_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardSiteOperatorPerformanceHistory(_tableTag: Tag) extends Table[VDashboardSiteOperatorPerformanceHistoryRow](_tableTag, "v_dashboard_site_operator_performance_history") {
    def * = measurementTime :: groupId :: siteId :: knownCellsAll :: knownCells4g :: knownCells3g :: knownCells2g :: downCellsAll :: downCells4g :: downCells3g :: downCells2g :: blockedCellsAll :: blockedCells4g :: blockedCells3g :: blockedCells2g :: cisKpiAll :: cisKpi4g :: cisKpi3g :: cisKpi2g :: cisKpiSeverityAll :: cisKpiSeverity4g :: cisKpiSeverity3g :: cisKpiSeverity2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column cis_kpi_all DBType(DECIMAL) */
    val cisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_all")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column cis_kpi_severity_all DBType(INT) */
    val cisKpiSeverityAll: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_all")
    /** Database column cis_kpi_severity_4g DBType(INT) */
    val cisKpiSeverity4g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_4g")
    /** Database column cis_kpi_severity_3g DBType(INT) */
    val cisKpiSeverity3g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_3g")
    /** Database column cis_kpi_severity_2g DBType(INT) */
    val cisKpiSeverity2g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VDashboardSiteOperatorPerformanceHistory */
  lazy val VDashboardSiteOperatorPerformanceHistory = new TableQuery(tag => new VDashboardSiteOperatorPerformanceHistory(tag))
  
  /** Entity class storing rows of table VDashboardTicket
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param ticketId Database column ticket_id DBType(VARCHAR), Length(50,true)
   *  @param cellId Database column cell_id DBType(VARCHAR), Length(20,true)
   *  @param priority Database column priority DBType(VARCHAR), Length(20,true)
   *  @param status Database column status DBType(VARCHAR), Length(50,true)
   *  @param statusTimestamp Database column status_timestamp DBType(TIMESTAMP)
   *  @param department Database column department DBType(VARCHAR), Length(256,true)
   *  @param owner Database column owner DBType(VARCHAR), Length(256,true)
   *  @param notes Database column notes DBType(VARCHAR), Length(4096,true) */
  case class VDashboardTicketRow(groupId: String, siteId: String, ticketId: String, cellId: Option[String], priority: String, status: String, statusTimestamp: java.sql.Timestamp, department: Option[String], owner: Option[String], notes: String)
  /** GetResult implicit for fetching VDashboardTicketRow objects using plain SQL queries */
  implicit def GetResultVDashboardTicketRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[VDashboardTicketRow] = GR{
    prs => import prs._
    VDashboardTicketRow.tupled((<<[String], <<[String], <<[String], <<?[String], <<[String], <<[String], <<[java.sql.Timestamp], <<?[String], <<?[String], <<[String]))
  }
  /** Table description of table v_dashboard_ticket. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardTicket(_tableTag: Tag) extends Table[VDashboardTicketRow](_tableTag, "v_dashboard_ticket") {
    def * = (groupId, siteId, ticketId, cellId, priority, status, statusTimestamp, department, owner, notes) <> (VDashboardTicketRow.tupled, VDashboardTicketRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, siteId.?, ticketId.?, cellId, priority.?, status.?, statusTimestamp.?, department, owner, notes.?).shaped.<>({r=>import r._; _1.map(_=> VDashboardTicketRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get, _7.get, _8, _9, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column ticket_id DBType(VARCHAR), Length(50,true) */
    val ticketId: Column[String] = column[String]("ticket_id", O.Length(50,varying=true))
    /** Database column cell_id DBType(VARCHAR), Length(20,true) */
    val cellId: Column[Option[String]] = column[Option[String]]("cell_id", O.Length(20,varying=true))
    /** Database column priority DBType(VARCHAR), Length(20,true) */
    val priority: Column[String] = column[String]("priority", O.Length(20,varying=true))
    /** Database column status DBType(VARCHAR), Length(50,true) */
    val status: Column[String] = column[String]("status", O.Length(50,varying=true))
    /** Database column status_timestamp DBType(TIMESTAMP) */
    val statusTimestamp: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("status_timestamp")
    /** Database column department DBType(VARCHAR), Length(256,true) */
    val department: Column[Option[String]] = column[Option[String]]("department", O.Length(256,varying=true))
    /** Database column owner DBType(VARCHAR), Length(256,true) */
    val owner: Column[Option[String]] = column[Option[String]]("owner", O.Length(256,varying=true))
    /** Database column notes DBType(VARCHAR), Length(4096,true) */
    val notes: Column[String] = column[String]("notes", O.Length(4096,varying=true))
  }
  /** Collection-like TableQuery object for table VDashboardTicket */
  lazy val VDashboardTicket = new TableQuery(tag => new VDashboardTicket(tag))
  
  /** Entity class storing rows of table VDashboardVendor
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(20,true)
   *  @param vendorName Database column vendor_name DBType(VARCHAR), Length(50,true)
   *  @param enabled Database column enabled DBType(BIT) */
  case class VDashboardVendorRow(vendorId: String, vendorName: String, enabled: Option[Boolean])
  /** GetResult implicit for fetching VDashboardVendorRow objects using plain SQL queries */
  implicit def GetResultVDashboardVendorRow(implicit e0: GR[String], e1: GR[Option[Boolean]]): GR[VDashboardVendorRow] = GR{
    prs => import prs._
    VDashboardVendorRow.tupled((<<[String], <<[String], <<?[Boolean]))
  }
  /** Table description of table v_dashboard_vendor. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardVendor(_tableTag: Tag) extends Table[VDashboardVendorRow](_tableTag, "v_dashboard_vendor") {
    def * = (vendorId, vendorName, enabled) <> (VDashboardVendorRow.tupled, VDashboardVendorRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (vendorId.?, vendorName.?, enabled).shaped.<>({r=>import r._; _1.map(_=> VDashboardVendorRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column vendor_id DBType(VARCHAR), Length(20,true) */
    val vendorId: Column[String] = column[String]("vendor_id", O.Length(20,varying=true))
    /** Database column vendor_name DBType(VARCHAR), Length(50,true) */
    val vendorName: Column[String] = column[String]("vendor_name", O.Length(50,varying=true))
    /** Database column enabled DBType(BIT) */
    val enabled: Column[Option[Boolean]] = column[Option[Boolean]]("enabled")
  }
  /** Collection-like TableQuery object for table VDashboardVendor */
  lazy val VDashboardVendor = new TableQuery(tag => new VDashboardVendor(tag))
  
  /** Row type of table VDashboardVendorPerformanceHistory */
  type VDashboardVendorPerformanceHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardVendorPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardVendorPerformanceHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], vendorId: Option[String], knownCellsAll: Option[Long], knownCells4g: Option[Long], knownCells3g: Option[Long], knownCells2g: Option[Long], downCellsAll: Option[Long], downCells4g: Option[Long], downCells3g: Option[Long], downCells2g: Option[Long], blockedCellsAll: Option[Long], blockedCells4g: Option[Long], blockedCells3g: Option[Long], blockedCells2g: Option[Long], cisKpiAll: Option[scala.math.BigDecimal], cisKpi4g: Option[scala.math.BigDecimal], cisKpi3g: Option[scala.math.BigDecimal], cisKpi2g: Option[scala.math.BigDecimal], cisKpiSeverityAll: Option[Int], cisKpiSeverity4g: Option[Int], cisKpiSeverity3g: Option[Int], cisKpiSeverity2g: Option[Int], sectorNo: Option[Int]): VDashboardVendorPerformanceHistoryRow = {
    measurementTime :: groupId :: vendorId :: knownCellsAll :: knownCells4g :: knownCells3g :: knownCells2g :: downCellsAll :: downCells4g :: downCells3g :: downCells2g :: blockedCellsAll :: blockedCells4g :: blockedCells3g :: blockedCells2g :: cisKpiAll :: cisKpi4g :: cisKpi3g :: cisKpi2g :: cisKpiSeverityAll :: cisKpiSeverity4g :: cisKpiSeverity3g :: cisKpiSeverity2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VDashboardVendorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardVendorPerformanceHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VDashboardVendorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: HNil
  }
  /** Table description of table v_dashboard_vendor_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardVendorPerformanceHistory(_tableTag: Tag) extends Table[VDashboardVendorPerformanceHistoryRow](_tableTag, "v_dashboard_vendor_performance_history") {
    def * = measurementTime :: groupId :: vendorId :: knownCellsAll :: knownCells4g :: knownCells3g :: knownCells2g :: downCellsAll :: downCells4g :: downCells3g :: downCells2g :: blockedCellsAll :: blockedCells4g :: blockedCells3g :: blockedCells2g :: cisKpiAll :: cisKpi4g :: cisKpi3g :: cisKpi2g :: cisKpiSeverityAll :: cisKpiSeverity4g :: cisKpiSeverity3g :: cisKpiSeverity2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column cis_kpi_all DBType(DECIMAL) */
    val cisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_all")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column cis_kpi_severity_all DBType(INT) */
    val cisKpiSeverityAll: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_all")
    /** Database column cis_kpi_severity_4g DBType(INT) */
    val cisKpiSeverity4g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_4g")
    /** Database column cis_kpi_severity_3g DBType(INT) */
    val cisKpiSeverity3g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_3g")
    /** Database column cis_kpi_severity_2g DBType(INT) */
    val cisKpiSeverity2g: Column[Option[Int]] = column[Option[Int]]("cis_kpi_severity_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VDashboardVendorPerformanceHistory */
  lazy val VDashboardVendorPerformanceHistory = new TableQuery(tag => new VDashboardVendorPerformanceHistory(tag))
  
  /** Row type of table VDashboardWeeklyPerformanceHistory */
  type VDashboardWeeklyPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardWeeklyPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardWeeklyPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], minKnownCellsAll: Option[Long], minKnownCells4g: Option[Long], minKnownCells3g: Option[Long], minKnownCells2g: Option[Long], maxKnownCellsAll: Option[Long], maxKnownCells4g: Option[Long], maxKnownCells3g: Option[Long], maxKnownCells2g: Option[Long], avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Option[scala.math.BigDecimal], avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Option[scala.math.BigDecimal], minCisKpiAll: Option[Long], minCisKpi4g: Option[scala.math.BigDecimal], minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Option[scala.math.BigDecimal], maxCisKpiAll: Option[Long], maxCisKpi4g: Option[scala.math.BigDecimal], maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Option[scala.math.BigDecimal], avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Option[scala.math.BigDecimal], avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Option[scala.math.BigDecimal]): VDashboardWeeklyPerformanceHistoryRow = {
    measurementTime :: groupId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: HNil
  }
  /** GetResult implicit for fetching VDashboardWeeklyPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardWeeklyPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]]): GR[VDashboardWeeklyPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: HNil
  }
  /** Table description of table v_dashboard_weekly_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardWeeklyPerformanceHistory(_tableTag: Tag) extends Table[VDashboardWeeklyPerformanceHistoryRow](_tableTag, "v_dashboard_weekly_performance_history") {
    def * = measurementTime :: groupId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(BIGINT) */
    val minKnownCells4g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_4g")
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(BIGINT) */
    val minKnownCells2g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_2g")
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(BIGINT) */
    val maxKnownCells4g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_4g")
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(BIGINT) */
    val maxKnownCells2g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_2g")
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(DECIMAL) */
    val avgKnownCells4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_4g")
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(DECIMAL) */
    val avgKnownCells2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_2g")
    /** Database column min_cis_kpi_all DBType(BIGINT) */
    val minCisKpiAll: Column[Option[Long]] = column[Option[Long]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(DECIMAL) */
    val minCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_4g")
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(DECIMAL) */
    val minCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_2g")
    /** Database column max_cis_kpi_all DBType(BIGINT) */
    val maxCisKpiAll: Column[Option[Long]] = column[Option[Long]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(DECIMAL) */
    val maxCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_4g")
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(DECIMAL) */
    val maxCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_2g")
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(DECIMAL) */
    val avgCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_4g")
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(DECIMAL) */
    val avgCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_2g")
  }
  /** Collection-like TableQuery object for table VDashboardWeeklyPerformanceHistory */
  lazy val VDashboardWeeklyPerformanceHistory = new TableQuery(tag => new VDashboardWeeklyPerformanceHistory(tag))
  
  /** Row type of table VDashboardWeeklyVendorPerformanceHistory */
  type VDashboardWeeklyVendorPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VDashboardWeeklyVendorPerformanceHistoryRow providing default values if available in the database schema. */
  def VDashboardWeeklyVendorPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], vendorId: Option[String], minKnownCellsAll: Option[Long], minKnownCells4g: Option[Long], minKnownCells3g: Option[Long], minKnownCells2g: Option[Long], maxKnownCellsAll: Option[Long], maxKnownCells4g: Option[Long], maxKnownCells3g: Option[Long], maxKnownCells2g: Option[Long], avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Option[scala.math.BigDecimal], avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Option[scala.math.BigDecimal], minCisKpiAll: Option[scala.math.BigDecimal], minCisKpi4g: Option[scala.math.BigDecimal], minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Option[scala.math.BigDecimal], maxCisKpiAll: Option[scala.math.BigDecimal], maxCisKpi4g: Option[scala.math.BigDecimal], maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Option[scala.math.BigDecimal], avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Option[scala.math.BigDecimal], avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VDashboardWeeklyVendorPerformanceHistoryRow = {
    measurementTime :: groupId :: vendorId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VDashboardWeeklyVendorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVDashboardWeeklyVendorPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VDashboardWeeklyVendorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table v_dashboard_weekly_vendor_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VDashboardWeeklyVendorPerformanceHistory(_tableTag: Tag) extends Table[VDashboardWeeklyVendorPerformanceHistoryRow](_tableTag, "v_dashboard_weekly_vendor_performance_history") {
    def * = measurementTime :: groupId :: vendorId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(BIGINT) */
    val minKnownCells4g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_4g")
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(BIGINT) */
    val minKnownCells2g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_2g")
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(BIGINT) */
    val maxKnownCells4g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_4g")
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(BIGINT) */
    val maxKnownCells2g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_2g")
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(DECIMAL) */
    val avgKnownCells4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_4g")
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(DECIMAL) */
    val avgKnownCells2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_2g")
    /** Database column min_cis_kpi_all DBType(DECIMAL) */
    val minCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(DECIMAL) */
    val minCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_4g")
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(DECIMAL) */
    val minCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_2g")
    /** Database column max_cis_kpi_all DBType(DECIMAL) */
    val maxCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(DECIMAL) */
    val maxCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_4g")
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(DECIMAL) */
    val maxCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_2g")
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(DECIMAL) */
    val avgCisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_4g")
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(DECIMAL) */
    val avgCisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VDashboardWeeklyVendorPerformanceHistory */
  lazy val VDashboardWeeklyVendorPerformanceHistory = new TableQuery(tag => new VDashboardWeeklyVendorPerformanceHistory(tag))
  
  /** Row type of table VendorPerformanceHistory */
  type VendorPerformanceHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VendorPerformanceHistoryRow providing default values if available in the database schema. */
  def VendorPerformanceHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], vendorId: Option[String], unknownCellsAll: Option[Long], knownCellsAll: Option[Long], blockedCellsAll: Option[Long], downCellsAll: Option[Long], upCellsAll: Option[Long], cisKpiAll: Option[scala.math.BigDecimal], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long], cisKpi4g: Option[scala.math.BigDecimal], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], cisKpi3g: Option[scala.math.BigDecimal], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], cisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VendorPerformanceHistoryRow = {
    measurementTime :: groupId :: vendorId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VendorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVendorPerformanceHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VendorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table vendor_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VendorPerformanceHistory(_tableTag: Tag) extends Table[VendorPerformanceHistoryRow](_tableTag, "vendor_performance_history") {
    def * = measurementTime :: groupId :: vendorId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column unknown_cells_all DBType(BIGINT) */
    val unknownCellsAll: Column[Option[Long]] = column[Option[Long]]("unknown_cells_all")
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column up_cells_all DBType(BIGINT) */
    val upCellsAll: Column[Option[Long]] = column[Option[Long]]("up_cells_all")
    /** Database column cis_kpi_all DBType(DECIMAL) */
    val cisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_all")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
    
    /** Index over (groupId) (database name ranmateFemto_vendorPerformanceHistory_groupId) */
    val index1 = index("ranmateFemto_vendorPerformanceHistory_groupId", groupId :: HNil)
    /** Index over (measurementTime) (database name ranmateFemto_vendorPerformanceHistory_measurementTime) */
    val index2 = index("ranmateFemto_vendorPerformanceHistory_measurementTime", measurementTime :: HNil)
    /** Index over (sectorNo) (database name ranmateFemto_vendorPerformanceHistory_sectorNo) */
    val index3 = index("ranmateFemto_vendorPerformanceHistory_sectorNo", sectorNo :: HNil)
    /** Index over (vendorId) (database name ranmateFemto_vendorPerformanceHistory_vendorId) */
    val index4 = index("ranmateFemto_vendorPerformanceHistory_vendorId", vendorId :: HNil)
  }
  /** Collection-like TableQuery object for table VendorPerformanceHistory */
  lazy val VendorPerformanceHistory = new TableQuery(tag => new VendorPerformanceHistory(tag))
  
  /** Entity class storing rows of table Vendors
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(20,true)
   *  @param vendorName Database column vendor_name DBType(VARCHAR), Length(50,true)
   *  @param enabled Database column enabled DBType(BIT) */
  case class VendorsRow(vendorId: String, vendorName: String, enabled: Option[Boolean])
  /** GetResult implicit for fetching VendorsRow objects using plain SQL queries */
  implicit def GetResultVendorsRow(implicit e0: GR[String], e1: GR[Option[Boolean]]): GR[VendorsRow] = GR{
    prs => import prs._
    VendorsRow.tupled((<<[String], <<[String], <<?[Boolean]))
  }
  /** Table description of table vendors. Objects of this class serve as prototypes for rows in queries. */
  class Vendors(_tableTag: Tag) extends Table[VendorsRow](_tableTag, "vendors") {
    def * = (vendorId, vendorName, enabled) <> (VendorsRow.tupled, VendorsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (vendorId.?, vendorName.?, enabled).shaped.<>({r=>import r._; _1.map(_=> VendorsRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column vendor_id DBType(VARCHAR), Length(20,true) */
    val vendorId: Column[String] = column[String]("vendor_id", O.Length(20,varying=true))
    /** Database column vendor_name DBType(VARCHAR), Length(50,true) */
    val vendorName: Column[String] = column[String]("vendor_name", O.Length(50,varying=true))
    /** Database column enabled DBType(BIT) */
    val enabled: Column[Option[Boolean]] = column[Option[Boolean]]("enabled")
  }
  /** Collection-like TableQuery object for table Vendors */
  lazy val Vendors = new TableQuery(tag => new Vendors(tag))
  
  /** Entity class storing rows of table VGenerationNo
   *  @param generationNo Database column generation_no DBType(BIGINT), Default(0) */
  case class VGenerationNoRow(generationNo: Long = 0L)
  /** GetResult implicit for fetching VGenerationNoRow objects using plain SQL queries */
  implicit def GetResultVGenerationNoRow(implicit e0: GR[Long]): GR[VGenerationNoRow] = GR{
    prs => import prs._
    VGenerationNoRow(<<[Long])
  }
  /** Table description of table v_generation_no. Objects of this class serve as prototypes for rows in queries. */
  class VGenerationNo(_tableTag: Tag) extends Table[VGenerationNoRow](_tableTag, "v_generation_no") {
    def * = generationNo <> (VGenerationNoRow, VGenerationNoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = generationNo.?.shaped.<>(r => r.map(_=> VGenerationNoRow(r.get)), (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column generation_no DBType(BIGINT), Default(0) */
    val generationNo: Column[Long] = column[Long]("generation_no", O.Default(0L))
  }
  /** Collection-like TableQuery object for table VGenerationNo */
  lazy val VGenerationNo = new TableQuery(tag => new VGenerationNo(tag))
  
  /** Row type of table VHourlySiteOperatorPerformanceHistory */
  type VHourlySiteOperatorPerformanceHistoryRow = HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Int,HCons[Option[Long],HCons[Int,HCons[Option[Long],HCons[Int,HCons[Option[Long],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[scala.math.BigDecimal],HCons[Int,HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VHourlySiteOperatorPerformanceHistoryRow providing default values if available in the database schema. */
  def VHourlySiteOperatorPerformanceHistoryRow(measurementTime: Option[java.sql.Timestamp], groupId: Option[String], siteId: Option[String], minKnownCellsAll: Option[Long], minKnownCells4g: Int = 0, minKnownCells3g: Option[Long], minKnownCells2g: Int = 0, maxKnownCellsAll: Option[Long], maxKnownCells4g: Int = 0, maxKnownCells3g: Option[Long], maxKnownCells2g: Int = 0, avgKnownCellsAll: Option[scala.math.BigDecimal], avgKnownCells4g: Int = 0, avgKnownCells3g: Option[scala.math.BigDecimal], avgKnownCells2g: Int = 0, minCisKpiAll: Option[scala.math.BigDecimal], minCisKpi4g: Int = 0, minCisKpi3g: Option[scala.math.BigDecimal], minCisKpi2g: Int = 0, maxCisKpiAll: Option[scala.math.BigDecimal], maxCisKpi4g: Int = 0, maxCisKpi3g: Option[scala.math.BigDecimal], maxCisKpi2g: Int = 0, avgCisKpiAll: Option[scala.math.BigDecimal], avgCisKpi4g: Int = 0, avgCisKpi3g: Option[scala.math.BigDecimal], avgCisKpi2g: Int = 0, sectorNo: Option[Int]): VHourlySiteOperatorPerformanceHistoryRow = {
    measurementTime :: groupId :: siteId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VHourlySiteOperatorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVHourlySiteOperatorPerformanceHistoryRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Int], e4: GR[Option[scala.math.BigDecimal]], e5: GR[Option[Int]]): GR[VHourlySiteOperatorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<[Int] :: <<?[Long] :: <<[Int] :: <<?[Long] :: <<[Int] :: <<?[Long] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[scala.math.BigDecimal] :: <<[Int] :: <<?[Int] :: HNil
  }
  /** Table description of table v_hourly_site_operator_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VHourlySiteOperatorPerformanceHistory(_tableTag: Tag) extends Table[VHourlySiteOperatorPerformanceHistoryRow](_tableTag, "v_hourly_site_operator_performance_history") {
    def * = measurementTime :: groupId :: siteId :: minKnownCellsAll :: minKnownCells4g :: minKnownCells3g :: minKnownCells2g :: maxKnownCellsAll :: maxKnownCells4g :: maxKnownCells3g :: maxKnownCells2g :: avgKnownCellsAll :: avgKnownCells4g :: avgKnownCells3g :: avgKnownCells2g :: minCisKpiAll :: minCisKpi4g :: minCisKpi3g :: minCisKpi2g :: maxCisKpiAll :: maxCisKpi4g :: maxCisKpi3g :: maxCisKpi2g :: avgCisKpiAll :: avgCisKpi4g :: avgCisKpi3g :: avgCisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column min_known_cells_all DBType(BIGINT) */
    val minKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("min_known_cells_all")
    /** Database column min_known_cells_4g DBType(INT), Default(0) */
    val minKnownCells4g: Column[Int] = column[Int]("min_known_cells_4g", O.Default(0))
    /** Database column min_known_cells_3g DBType(BIGINT) */
    val minKnownCells3g: Column[Option[Long]] = column[Option[Long]]("min_known_cells_3g")
    /** Database column min_known_cells_2g DBType(INT), Default(0) */
    val minKnownCells2g: Column[Int] = column[Int]("min_known_cells_2g", O.Default(0))
    /** Database column max_known_cells_all DBType(BIGINT) */
    val maxKnownCellsAll: Column[Option[Long]] = column[Option[Long]]("max_known_cells_all")
    /** Database column max_known_cells_4g DBType(INT), Default(0) */
    val maxKnownCells4g: Column[Int] = column[Int]("max_known_cells_4g", O.Default(0))
    /** Database column max_known_cells_3g DBType(BIGINT) */
    val maxKnownCells3g: Column[Option[Long]] = column[Option[Long]]("max_known_cells_3g")
    /** Database column max_known_cells_2g DBType(INT), Default(0) */
    val maxKnownCells2g: Column[Int] = column[Int]("max_known_cells_2g", O.Default(0))
    /** Database column avg_known_cells_all DBType(DECIMAL) */
    val avgKnownCellsAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_all")
    /** Database column avg_known_cells_4g DBType(INT), Default(0) */
    val avgKnownCells4g: Column[Int] = column[Int]("avg_known_cells_4g", O.Default(0))
    /** Database column avg_known_cells_3g DBType(DECIMAL) */
    val avgKnownCells3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_known_cells_3g")
    /** Database column avg_known_cells_2g DBType(INT), Default(0) */
    val avgKnownCells2g: Column[Int] = column[Int]("avg_known_cells_2g", O.Default(0))
    /** Database column min_cis_kpi_all DBType(DECIMAL) */
    val minCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_all")
    /** Database column min_cis_kpi_4g DBType(INT), Default(0) */
    val minCisKpi4g: Column[Int] = column[Int]("min_cis_kpi_4g", O.Default(0))
    /** Database column min_cis_kpi_3g DBType(DECIMAL) */
    val minCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("min_cis_kpi_3g")
    /** Database column min_cis_kpi_2g DBType(INT), Default(0) */
    val minCisKpi2g: Column[Int] = column[Int]("min_cis_kpi_2g", O.Default(0))
    /** Database column max_cis_kpi_all DBType(DECIMAL) */
    val maxCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_all")
    /** Database column max_cis_kpi_4g DBType(INT), Default(0) */
    val maxCisKpi4g: Column[Int] = column[Int]("max_cis_kpi_4g", O.Default(0))
    /** Database column max_cis_kpi_3g DBType(DECIMAL) */
    val maxCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("max_cis_kpi_3g")
    /** Database column max_cis_kpi_2g DBType(INT), Default(0) */
    val maxCisKpi2g: Column[Int] = column[Int]("max_cis_kpi_2g", O.Default(0))
    /** Database column avg_cis_kpi_all DBType(DECIMAL) */
    val avgCisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_all")
    /** Database column avg_cis_kpi_4g DBType(INT), Default(0) */
    val avgCisKpi4g: Column[Int] = column[Int]("avg_cis_kpi_4g", O.Default(0))
    /** Database column avg_cis_kpi_3g DBType(DECIMAL) */
    val avgCisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("avg_cis_kpi_3g")
    /** Database column avg_cis_kpi_2g DBType(INT), Default(0) */
    val avgCisKpi2g: Column[Int] = column[Int]("avg_cis_kpi_2g", O.Default(0))
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VHourlySiteOperatorPerformanceHistory */
  lazy val VHourlySiteOperatorPerformanceHistory = new TableQuery(tag => new VHourlySiteOperatorPerformanceHistory(tag))
  
  /** Entity class storing rows of table VKpiHistory
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param cisKpi Database column cis_kpi DBType(DECIMAL) */
  case class VKpiHistoryRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], cisKpi: Option[scala.math.BigDecimal])
  /** GetResult implicit for fetching VKpiHistoryRow objects using plain SQL queries */
  implicit def GetResultVKpiHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[scala.math.BigDecimal]]): GR[VKpiHistoryRow] = GR{
    prs => import prs._
    VKpiHistoryRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[scala.math.BigDecimal]))
  }
  /** Table description of table v_kpi_history. Objects of this class serve as prototypes for rows in queries. */
  class VKpiHistory(_tableTag: Tag) extends Table[VKpiHistoryRow](_tableTag, "v_kpi_history") {
    def * = (measurementTime, generation, groupId, cisKpi) <> (VKpiHistoryRow.tupled, VKpiHistoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, cisKpi).shaped.<>({r=>import r._; _1.map(_=> VKpiHistoryRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column cis_kpi DBType(DECIMAL) */
    val cisKpi: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi")
  }
  /** Collection-like TableQuery object for table VKpiHistory */
  lazy val VKpiHistory = new TableQuery(tag => new VKpiHistory(tag))
  
  /** Entity class storing rows of table VKpiThreshold
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param effectiveFrom Database column effective_from DBType(TIMESTAMP)
   *  @param effectiveTo Database column effective_to DBType(TIMESTAMP)
   *  @param major Database column major DBType(INT)
   *  @param minor Database column minor DBType(INT) */
  case class VKpiThresholdRow(groupId: String, effectiveFrom: java.sql.Timestamp, effectiveTo: java.sql.Timestamp, major: Int, minor: Int)
  /** GetResult implicit for fetching VKpiThresholdRow objects using plain SQL queries */
  implicit def GetResultVKpiThresholdRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp], e2: GR[Int]): GR[VKpiThresholdRow] = GR{
    prs => import prs._
    VKpiThresholdRow.tupled((<<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Int], <<[Int]))
  }
  /** Table description of table v_kpi_threshold. Objects of this class serve as prototypes for rows in queries. */
  class VKpiThreshold(_tableTag: Tag) extends Table[VKpiThresholdRow](_tableTag, "v_kpi_threshold") {
    def * = (groupId, effectiveFrom, effectiveTo, major, minor) <> (VKpiThresholdRow.tupled, VKpiThresholdRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, effectiveFrom.?, effectiveTo.?, major.?, minor.?).shaped.<>({r=>import r._; _1.map(_=> VKpiThresholdRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column effective_from DBType(TIMESTAMP) */
    val effectiveFrom: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_from")
    /** Database column effective_to DBType(TIMESTAMP) */
    val effectiveTo: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_to")
    /** Database column major DBType(INT) */
    val major: Column[Int] = column[Int]("major")
    /** Database column minor DBType(INT) */
    val minor: Column[Int] = column[Int]("minor")
  }
  /** Collection-like TableQuery object for table VKpiThreshold */
  lazy val VKpiThreshold = new TableQuery(tag => new VKpiThreshold(tag))
  
  /** Entity class storing rows of table VLastCellUptime
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param cellState Database column cell_state DBType(INT) */
  case class VLastCellUptimeRow(measurementTime: Option[java.sql.Timestamp], generation: Option[Int], groupId: Option[String], siteId: Option[String], cellNo: Option[Int], cellState: Option[Int])
  /** GetResult implicit for fetching VLastCellUptimeRow objects using plain SQL queries */
  implicit def GetResultVLastCellUptimeRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[VLastCellUptimeRow] = GR{
    prs => import prs._
    VLastCellUptimeRow.tupled((<<?[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table v_last_cell_uptime. Objects of this class serve as prototypes for rows in queries. */
  class VLastCellUptime(_tableTag: Tag) extends Table[VLastCellUptimeRow](_tableTag, "v_last_cell_uptime") {
    def * = (measurementTime, generation, groupId, siteId, cellNo, cellState) <> (VLastCellUptimeRow.tupled, VLastCellUptimeRow.unapply)
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column cell_state DBType(INT) */
    val cellState: Column[Option[Int]] = column[Option[Int]]("cell_state")
  }
  /** Collection-like TableQuery object for table VLastCellUptime */
  lazy val VLastCellUptime = new TableQuery(tag => new VLastCellUptime(tag))
  
  /** Entity class storing rows of table VNewCellUptime
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param cellState Database column cell_state DBType(INT) */
  case class VNewCellUptimeRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], cellNo: Option[Int], cellState: Option[Int])
  /** GetResult implicit for fetching VNewCellUptimeRow objects using plain SQL queries */
  implicit def GetResultVNewCellUptimeRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[VNewCellUptimeRow] = GR{
    prs => import prs._
    VNewCellUptimeRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table v_new_cell_uptime. Objects of this class serve as prototypes for rows in queries. */
  class VNewCellUptime(_tableTag: Tag) extends Table[VNewCellUptimeRow](_tableTag, "v_new_cell_uptime") {
    def * = (measurementTime, generation, groupId, siteId, cellNo, cellState) <> (VNewCellUptimeRow.tupled, VNewCellUptimeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, cellNo, cellState).shaped.<>({r=>import r._; _1.map(_=> VNewCellUptimeRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column cell_state DBType(INT) */
    val cellState: Column[Option[Int]] = column[Option[Int]]("cell_state")
  }
  /** Collection-like TableQuery object for table VNewCellUptime */
  lazy val VNewCellUptime = new TableQuery(tag => new VNewCellUptime(tag))
  
  /** Entity class storing rows of table VPerformanceAlertEvents
   *  @param alertTimestamp Database column alert_timestamp DBType(TIMESTAMP)
   *  @param entity Database column entity DBType(VARCHAR), Length(9,true)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param generation Database column generation DBType(INT)
   *  @param information Database column information DBType(VARCHAR), Length(70,true) */
  case class VPerformanceAlertEventsRow(alertTimestamp: Option[java.sql.Timestamp], entity: String, groupId: Option[String], generation: Option[Int], information: Option[String])
  /** GetResult implicit for fetching VPerformanceAlertEventsRow objects using plain SQL queries */
  implicit def GetResultVPerformanceAlertEventsRow(implicit e0: GR[Option[java.sql.Timestamp]], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[Int]]): GR[VPerformanceAlertEventsRow] = GR{
    prs => import prs._
    VPerformanceAlertEventsRow.tupled((<<?[java.sql.Timestamp], <<[String], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table v_performance_alert_events. Objects of this class serve as prototypes for rows in queries. */
  class VPerformanceAlertEvents(_tableTag: Tag) extends Table[VPerformanceAlertEventsRow](_tableTag, "v_performance_alert_events") {
    def * = (alertTimestamp, entity, groupId, generation, information) <> (VPerformanceAlertEventsRow.tupled, VPerformanceAlertEventsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (alertTimestamp, entity.?, groupId, generation, information).shaped.<>({r=>import r._; _2.map(_=> VPerformanceAlertEventsRow.tupled((_1, _2.get, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column alert_timestamp DBType(TIMESTAMP) */
    val alertTimestamp: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("alert_timestamp")
    /** Database column entity DBType(VARCHAR), Length(9,true) */
    val entity: Column[String] = column[String]("entity", O.Length(9,varying=true))
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column information DBType(VARCHAR), Length(70,true) */
    val information: Column[Option[String]] = column[Option[String]]("information", O.Length(70,varying=true))
  }
  /** Collection-like TableQuery object for table VPerformanceAlertEvents */
  lazy val VPerformanceAlertEvents = new TableQuery(tag => new VPerformanceAlertEvents(tag))
  
  /** Row type of table VPerformanceHistory */
  type VPerformanceHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VPerformanceHistoryRow providing default values if available in the database schema. */
  def VPerformanceHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], unknownCellsAll: Option[Long], knownCellsAll: Option[Long], blockedCellsAll: Option[Long], downCellsAll: Option[Long], upCellsAll: Option[Long], cisKpiAll: Option[Long], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long], cisKpi4g: Option[scala.math.BigDecimal], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], cisKpi3g: Option[scala.math.BigDecimal], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], cisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VPerformanceHistoryRow = {
    measurementTime :: groupId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVPerformanceHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VPerformanceHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table v_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VPerformanceHistory(_tableTag: Tag) extends Table[VPerformanceHistoryRow](_tableTag, "v_performance_history") {
    def * = measurementTime :: groupId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column unknown_cells_all DBType(BIGINT) */
    val unknownCellsAll: Column[Option[Long]] = column[Option[Long]]("unknown_cells_all")
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column up_cells_all DBType(BIGINT) */
    val upCellsAll: Column[Option[Long]] = column[Option[Long]]("up_cells_all")
    /** Database column cis_kpi_all DBType(BIGINT) */
    val cisKpiAll: Column[Option[Long]] = column[Option[Long]]("cis_kpi_all")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VPerformanceHistory */
  lazy val VPerformanceHistory = new TableQuery(tag => new VPerformanceHistory(tag))
  
  /** Row type of table VPerformanceHistory2 */
  type VPerformanceHistory2Row = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VPerformanceHistory2Row providing default values if available in the database schema. */
  def VPerformanceHistory2Row(measurementTime: java.sql.Timestamp, groupId: Option[String], unknownCellsAll: Option[Long], knownCellsAll: Option[Long], blockedCellsAll: Option[Long], downCellsAll: Option[Long], upCellsAll: Option[Long], cisKpiAll: Option[Long], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long], cisKpi4g: Option[scala.math.BigDecimal], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], cisKpi3g: Option[scala.math.BigDecimal], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], cisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VPerformanceHistory2Row = {
    measurementTime :: groupId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VPerformanceHistory2Row objects using plain SQL queries */
  implicit def GetResultVPerformanceHistory2Row(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VPerformanceHistory2Row] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table v_performance_history2. Objects of this class serve as prototypes for rows in queries. */
  class VPerformanceHistory2(_tableTag: Tag) extends Table[VPerformanceHistory2Row](_tableTag, "v_performance_history2") {
    def * = measurementTime :: groupId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column unknown_cells_all DBType(BIGINT) */
    val unknownCellsAll: Column[Option[Long]] = column[Option[Long]]("unknown_cells_all")
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column up_cells_all DBType(BIGINT) */
    val upCellsAll: Column[Option[Long]] = column[Option[Long]]("up_cells_all")
    /** Database column cis_kpi_all DBType(BIGINT) */
    val cisKpiAll: Column[Option[Long]] = column[Option[Long]]("cis_kpi_all")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VPerformanceHistory2 */
  lazy val VPerformanceHistory2 = new TableQuery(tag => new VPerformanceHistory2(tag))
  
  /** Row type of table VPerformanceSiteOperatorHistory */
  type VPerformanceSiteOperatorHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VPerformanceSiteOperatorHistoryRow providing default values if available in the database schema. */
  def VPerformanceSiteOperatorHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], siteId: Option[String], unknownCellsAll: Option[Long], knownCellsAll: Option[Long], blockedCellsAll: Option[Long], downCellsAll: Option[Long], upCellsAll: Option[Long], cisKpiAll: Option[Long], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long], cisKpi4g: Option[scala.math.BigDecimal], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], cisKpi3g: Option[scala.math.BigDecimal], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], cisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VPerformanceSiteOperatorHistoryRow = {
    measurementTime :: groupId :: siteId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VPerformanceSiteOperatorHistoryRow objects using plain SQL queries */
  implicit def GetResultVPerformanceSiteOperatorHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VPerformanceSiteOperatorHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table v_performance_site_operator_history. Objects of this class serve as prototypes for rows in queries. */
  class VPerformanceSiteOperatorHistory(_tableTag: Tag) extends Table[VPerformanceSiteOperatorHistoryRow](_tableTag, "v_performance_site_operator_history") {
    def * = measurementTime :: groupId :: siteId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column unknown_cells_all DBType(BIGINT) */
    val unknownCellsAll: Column[Option[Long]] = column[Option[Long]]("unknown_cells_all")
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column up_cells_all DBType(BIGINT) */
    val upCellsAll: Column[Option[Long]] = column[Option[Long]]("up_cells_all")
    /** Database column cis_kpi_all DBType(BIGINT) */
    val cisKpiAll: Column[Option[Long]] = column[Option[Long]]("cis_kpi_all")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VPerformanceSiteOperatorHistory */
  lazy val VPerformanceSiteOperatorHistory = new TableQuery(tag => new VPerformanceSiteOperatorHistory(tag))
  
  /** Entity class storing rows of table VReportStickyCell
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellId Database column cell_id DBType(VARCHAR), Length(20,true)
   *  @param generation Database column generation DBType(INT)
   *  @param exist Database column exist DBType(BIT)
   *  @param exclude Database column exclude DBType(BIT)
   *  @param effectiveFrom Database column effective_from DBType(TIMESTAMP) */
  case class VReportStickyCellRow(groupId: String, siteId: String, cellId: Option[String], generation: Int, exist: Boolean, exclude: Boolean, effectiveFrom: java.sql.Timestamp)
  /** GetResult implicit for fetching VReportStickyCellRow objects using plain SQL queries */
  implicit def GetResultVReportStickyCellRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Int], e3: GR[Boolean], e4: GR[java.sql.Timestamp]): GR[VReportStickyCellRow] = GR{
    prs => import prs._
    VReportStickyCellRow.tupled((<<[String], <<[String], <<?[String], <<[Int], <<[Boolean], <<[Boolean], <<[java.sql.Timestamp]))
  }
  /** Table description of table v_report_sticky_cell. Objects of this class serve as prototypes for rows in queries. */
  class VReportStickyCell(_tableTag: Tag) extends Table[VReportStickyCellRow](_tableTag, "v_report_sticky_cell") {
    def * = (groupId, siteId, cellId, generation, exist, exclude, effectiveFrom) <> (VReportStickyCellRow.tupled, VReportStickyCellRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, siteId.?, cellId, generation.?, exist.?, exclude.?, effectiveFrom.?).shaped.<>({r=>import r._; _1.map(_=> VReportStickyCellRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column cell_id DBType(VARCHAR), Length(20,true) */
    val cellId: Column[Option[String]] = column[Option[String]]("cell_id", O.Length(20,varying=true))
    /** Database column generation DBType(INT) */
    val generation: Column[Int] = column[Int]("generation")
    /** Database column exist DBType(BIT) */
    val exist: Column[Boolean] = column[Boolean]("exist")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Boolean] = column[Boolean]("exclude")
    /** Database column effective_from DBType(TIMESTAMP) */
    val effectiveFrom: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_from")
  }
  /** Collection-like TableQuery object for table VReportStickyCell */
  lazy val VReportStickyCell = new TableQuery(tag => new VReportStickyCell(tag))
  
  /** Entity class storing rows of table VReportStickySite
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param nodeId Database column node_id DBType(VARCHAR), Length(50,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param priority Database column priority DBType(INT), Default(99)
   *  @param exclude Database column exclude DBType(BIT)
   *  @param effectiveFrom Database column effective_from DBType(TIMESTAMP) */
  case class VReportStickySiteRow(groupId: String, nodeId: Option[String], siteId: String, priority: Int = 99, exclude: Boolean, effectiveFrom: java.sql.Timestamp)
  /** GetResult implicit for fetching VReportStickySiteRow objects using plain SQL queries */
  implicit def GetResultVReportStickySiteRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Int], e3: GR[Boolean], e4: GR[java.sql.Timestamp]): GR[VReportStickySiteRow] = GR{
    prs => import prs._
    VReportStickySiteRow.tupled((<<[String], <<?[String], <<[String], <<[Int], <<[Boolean], <<[java.sql.Timestamp]))
  }
  /** Table description of table v_report_sticky_site. Objects of this class serve as prototypes for rows in queries. */
  class VReportStickySite(_tableTag: Tag) extends Table[VReportStickySiteRow](_tableTag, "v_report_sticky_site") {
    def * = (groupId, nodeId, siteId, priority, exclude, effectiveFrom) <> (VReportStickySiteRow.tupled, VReportStickySiteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, nodeId, siteId.?, priority.?, exclude.?, effectiveFrom.?).shaped.<>({r=>import r._; _1.map(_=> VReportStickySiteRow.tupled((_1.get, _2, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column priority DBType(INT), Default(99) */
    val priority: Column[Int] = column[Int]("priority", O.Default(99))
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Boolean] = column[Boolean]("exclude")
    /** Database column effective_from DBType(TIMESTAMP) */
    val effectiveFrom: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("effective_from")
  }
  /** Collection-like TableQuery object for table VReportStickySite */
  lazy val VReportStickySite = new TableQuery(tag => new VReportStickySite(tag))
  
  /** Entity class storing rows of table VServiceCounters
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param existCells Database column exist_cells DBType(BIGINT)
   *  @param excludeCells Database column exclude_cells DBType(BIGINT)
   *  @param includeCells Database column include_cells DBType(BIGINT)
   *  @param unknownCells Database column unknown_cells DBType(BIGINT)
   *  @param knownCells Database column known_cells DBType(BIGINT)
   *  @param blockedCells Database column blocked_cells DBType(BIGINT)
   *  @param downCells Database column down_cells DBType(BIGINT)
   *  @param upCells Database column up_cells DBType(BIGINT)
   *  @param sectorNo Database column sector_no DBType(INT) */
  case class VServiceCountersRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], vendorId: Option[String], existCells: Option[Long], excludeCells: Option[Long], includeCells: Option[Long], unknownCells: Option[Long], knownCells: Option[Long], blockedCells: Option[Long], downCells: Option[Long], upCells: Option[Long], sectorNo: Option[Int])
  /** GetResult implicit for fetching VServiceCountersRow objects using plain SQL queries */
  implicit def GetResultVServiceCountersRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Long]]): GR[VServiceCountersRow] = GR{
    prs => import prs._
    VServiceCountersRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Int]))
  }
  /** Table description of table v_service_counters. Objects of this class serve as prototypes for rows in queries. */
  class VServiceCounters(_tableTag: Tag) extends Table[VServiceCountersRow](_tableTag, "v_service_counters") {
    def * = (measurementTime, generation, groupId, vendorId, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo) <> (VServiceCountersRow.tupled, VServiceCountersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, vendorId, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo).shaped.<>({r=>import r._; _1.map(_=> VServiceCountersRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column exist_cells DBType(BIGINT) */
    val existCells: Column[Option[Long]] = column[Option[Long]]("exist_cells")
    /** Database column exclude_cells DBType(BIGINT) */
    val excludeCells: Column[Option[Long]] = column[Option[Long]]("exclude_cells")
    /** Database column include_cells DBType(BIGINT) */
    val includeCells: Column[Option[Long]] = column[Option[Long]]("include_cells")
    /** Database column unknown_cells DBType(BIGINT) */
    val unknownCells: Column[Option[Long]] = column[Option[Long]]("unknown_cells")
    /** Database column known_cells DBType(BIGINT) */
    val knownCells: Column[Option[Long]] = column[Option[Long]]("known_cells")
    /** Database column blocked_cells DBType(BIGINT) */
    val blockedCells: Column[Option[Long]] = column[Option[Long]]("blocked_cells")
    /** Database column down_cells DBType(BIGINT) */
    val downCells: Column[Option[Long]] = column[Option[Long]]("down_cells")
    /** Database column up_cells DBType(BIGINT) */
    val upCells: Column[Option[Long]] = column[Option[Long]]("up_cells")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VServiceCounters */
  lazy val VServiceCounters = new TableQuery(tag => new VServiceCounters(tag))
  
  /** Row type of table VSiteCounters */
  type VSiteCountersRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VSiteCountersRow providing default values if available in the database schema. */
  def VSiteCountersRow(measurementTime: java.sql.Timestamp, groupId: Option[String], siteId: Option[String], exclude2g: Option[Int], exclude3g: Option[Int], exclude4g: Option[Int], vendorId2g: Option[String], existCells2g: Option[Long], excludeCells2g: Option[Long], includeCells2g: Option[Long], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], vendorId3g: Option[String], existCells3g: Option[Long], excludeCells3g: Option[Long], includeCells3g: Option[Long], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], vendorId4g: Option[String], existCells4g: Option[Long], excludeCells4g: Option[Long], includeCells4g: Option[Long], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long]): VSiteCountersRow = {
    measurementTime :: groupId :: siteId :: exclude2g :: exclude3g :: exclude4g :: vendorId2g :: existCells2g :: excludeCells2g :: includeCells2g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: vendorId3g :: existCells3g :: excludeCells3g :: includeCells3g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: vendorId4g :: existCells4g :: excludeCells4g :: includeCells4g :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: HNil
  }
  /** GetResult implicit for fetching VSiteCountersRow objects using plain SQL queries */
  implicit def GetResultVSiteCountersRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Long]]): GR[VSiteCountersRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: HNil
  }
  /** Table description of table v_site_counters. Objects of this class serve as prototypes for rows in queries. */
  class VSiteCounters(_tableTag: Tag) extends Table[VSiteCountersRow](_tableTag, "v_site_counters") {
    def * = measurementTime :: groupId :: siteId :: exclude2g :: exclude3g :: exclude4g :: vendorId2g :: existCells2g :: excludeCells2g :: includeCells2g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: vendorId3g :: existCells3g :: excludeCells3g :: includeCells3g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: vendorId4g :: existCells4g :: excludeCells4g :: includeCells4g :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column exclude_2g DBType(INT) */
    val exclude2g: Column[Option[Int]] = column[Option[Int]]("exclude_2g")
    /** Database column exclude_3g DBType(INT) */
    val exclude3g: Column[Option[Int]] = column[Option[Int]]("exclude_3g")
    /** Database column exclude_4g DBType(INT) */
    val exclude4g: Column[Option[Int]] = column[Option[Int]]("exclude_4g")
    /** Database column vendor_id_2g DBType(VARCHAR), Length(50,true) */
    val vendorId2g: Column[Option[String]] = column[Option[String]]("vendor_id_2g", O.Length(50,varying=true))
    /** Database column exist_cells_2g DBType(BIGINT) */
    val existCells2g: Column[Option[Long]] = column[Option[Long]]("exist_cells_2g")
    /** Database column exclude_cells_2g DBType(BIGINT) */
    val excludeCells2g: Column[Option[Long]] = column[Option[Long]]("exclude_cells_2g")
    /** Database column include_cells_2g DBType(BIGINT) */
    val includeCells2g: Column[Option[Long]] = column[Option[Long]]("include_cells_2g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column vendor_id_3g DBType(VARCHAR), Length(50,true) */
    val vendorId3g: Column[Option[String]] = column[Option[String]]("vendor_id_3g", O.Length(50,varying=true))
    /** Database column exist_cells_3g DBType(BIGINT) */
    val existCells3g: Column[Option[Long]] = column[Option[Long]]("exist_cells_3g")
    /** Database column exclude_cells_3g DBType(BIGINT) */
    val excludeCells3g: Column[Option[Long]] = column[Option[Long]]("exclude_cells_3g")
    /** Database column include_cells_3g DBType(BIGINT) */
    val includeCells3g: Column[Option[Long]] = column[Option[Long]]("include_cells_3g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column vendor_id_4g DBType(VARCHAR), Length(50,true) */
    val vendorId4g: Column[Option[String]] = column[Option[String]]("vendor_id_4g", O.Length(50,varying=true))
    /** Database column exist_cells_4g DBType(BIGINT) */
    val existCells4g: Column[Option[Long]] = column[Option[Long]]("exist_cells_4g")
    /** Database column exclude_cells_4g DBType(BIGINT) */
    val excludeCells4g: Column[Option[Long]] = column[Option[Long]]("exclude_cells_4g")
    /** Database column include_cells_4g DBType(BIGINT) */
    val includeCells4g: Column[Option[Long]] = column[Option[Long]]("include_cells_4g")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
  }
  /** Collection-like TableQuery object for table VSiteCounters */
  lazy val VSiteCounters = new TableQuery(tag => new VSiteCounters(tag))
  
  /** Entity class storing rows of table VSiteNote
   *  @param groupId Database column group_id DBType(VARCHAR), Length(3,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param noteCount Database column note_count DBType(BIGINT), Default(0) */
  case class VSiteNoteRow(groupId: String, siteId: String, noteCount: Long = 0L)
  /** GetResult implicit for fetching VSiteNoteRow objects using plain SQL queries */
  implicit def GetResultVSiteNoteRow(implicit e0: GR[String], e1: GR[Long]): GR[VSiteNoteRow] = GR{
    prs => import prs._
    VSiteNoteRow.tupled((<<[String], <<[String], <<[Long]))
  }
  /** Table description of table v_site_note. Objects of this class serve as prototypes for rows in queries. */
  class VSiteNote(_tableTag: Tag) extends Table[VSiteNoteRow](_tableTag, "v_site_note") {
    def * = (groupId, siteId, noteCount) <> (VSiteNoteRow.tupled, VSiteNoteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, siteId.?, noteCount.?).shaped.<>({r=>import r._; _1.map(_=> VSiteNoteRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(3,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(3,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column note_count DBType(BIGINT), Default(0) */
    val noteCount: Column[Long] = column[Long]("note_count", O.Default(0L))
  }
  /** Collection-like TableQuery object for table VSiteNote */
  lazy val VSiteNote = new TableQuery(tag => new VSiteNote(tag))
  
  /** Entity class storing rows of table VSiteOperatorCounters
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT), Default(0)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param existCells Database column exist_cells DBType(BIGINT)
   *  @param excludeCells Database column exclude_cells DBType(BIGINT)
   *  @param includeCells Database column include_cells DBType(BIGINT)
   *  @param unknownCells Database column unknown_cells DBType(BIGINT)
   *  @param knownCells Database column known_cells DBType(BIGINT)
   *  @param blockedCells Database column blocked_cells DBType(BIGINT)
   *  @param downCells Database column down_cells DBType(BIGINT)
   *  @param upCells Database column up_cells DBType(BIGINT)
   *  @param sectorNo Database column sector_no DBType(INT) */
  case class VSiteOperatorCountersRow(measurementTime: java.sql.Timestamp, generation: Int = 0, groupId: Option[String], siteId: Option[String], existCells: Option[Long], excludeCells: Option[Long], includeCells: Option[Long], unknownCells: Option[Long], knownCells: Option[Long], blockedCells: Option[Long], downCells: Option[Long], upCells: Option[Long], sectorNo: Option[Int])
  /** GetResult implicit for fetching VSiteOperatorCountersRow objects using plain SQL queries */
  implicit def GetResultVSiteOperatorCountersRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Int], e2: GR[Option[String]], e3: GR[Option[Long]], e4: GR[Option[Int]]): GR[VSiteOperatorCountersRow] = GR{
    prs => import prs._
    VSiteOperatorCountersRow.tupled((<<[java.sql.Timestamp], <<[Int], <<?[String], <<?[String], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Int]))
  }
  /** Table description of table v_site_operator_counters. Objects of this class serve as prototypes for rows in queries. */
  class VSiteOperatorCounters(_tableTag: Tag) extends Table[VSiteOperatorCountersRow](_tableTag, "v_site_operator_counters") {
    def * = (measurementTime, generation, groupId, siteId, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo) <> (VSiteOperatorCountersRow.tupled, VSiteOperatorCountersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation.?, groupId, siteId, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo).shaped.<>({r=>import r._; _1.map(_=> VSiteOperatorCountersRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT), Default(0) */
    val generation: Column[Int] = column[Int]("generation", O.Default(0))
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column exist_cells DBType(BIGINT) */
    val existCells: Column[Option[Long]] = column[Option[Long]]("exist_cells")
    /** Database column exclude_cells DBType(BIGINT) */
    val excludeCells: Column[Option[Long]] = column[Option[Long]]("exclude_cells")
    /** Database column include_cells DBType(BIGINT) */
    val includeCells: Column[Option[Long]] = column[Option[Long]]("include_cells")
    /** Database column unknown_cells DBType(BIGINT) */
    val unknownCells: Column[Option[Long]] = column[Option[Long]]("unknown_cells")
    /** Database column known_cells DBType(BIGINT) */
    val knownCells: Column[Option[Long]] = column[Option[Long]]("known_cells")
    /** Database column blocked_cells DBType(BIGINT) */
    val blockedCells: Column[Option[Long]] = column[Option[Long]]("blocked_cells")
    /** Database column down_cells DBType(BIGINT) */
    val downCells: Column[Option[Long]] = column[Option[Long]]("down_cells")
    /** Database column up_cells DBType(BIGINT) */
    val upCells: Column[Option[Long]] = column[Option[Long]]("up_cells")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VSiteOperatorCounters */
  lazy val VSiteOperatorCounters = new TableQuery(tag => new VSiteOperatorCounters(tag))
  
  /** Row type of table VSiteOperatorPerformanceHistory */
  type VSiteOperatorPerformanceHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VSiteOperatorPerformanceHistoryRow providing default values if available in the database schema. */
  def VSiteOperatorPerformanceHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], siteId: Option[String], unknownCellsAll: Option[Long], knownCellsAll: Option[Long], blockedCellsAll: Option[Long], downCellsAll: Option[Long], upCellsAll: Option[Long], cisKpiAll: Option[scala.math.BigDecimal], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long], cisKpi4g: Option[scala.math.BigDecimal], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], cisKpi3g: Option[scala.math.BigDecimal], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], cisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VSiteOperatorPerformanceHistoryRow = {
    measurementTime :: groupId :: siteId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VSiteOperatorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVSiteOperatorPerformanceHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VSiteOperatorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table v_site_operator_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VSiteOperatorPerformanceHistory(_tableTag: Tag) extends Table[VSiteOperatorPerformanceHistoryRow](_tableTag, "v_site_operator_performance_history") {
    def * = measurementTime :: groupId :: siteId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column unknown_cells_all DBType(BIGINT) */
    val unknownCellsAll: Column[Option[Long]] = column[Option[Long]]("unknown_cells_all")
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column up_cells_all DBType(BIGINT) */
    val upCellsAll: Column[Option[Long]] = column[Option[Long]]("up_cells_all")
    /** Database column cis_kpi_all DBType(DECIMAL) */
    val cisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_all")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VSiteOperatorPerformanceHistory */
  lazy val VSiteOperatorPerformanceHistory = new TableQuery(tag => new VSiteOperatorPerformanceHistory(tag))
  
  /** Entity class storing rows of table VSiteServiceCounters
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param excludeSite Database column exclude_site DBType(BIT)
   *  @param existCells Database column exist_cells DBType(BIGINT)
   *  @param excludeCells Database column exclude_cells DBType(BIGINT)
   *  @param includeCells Database column include_cells DBType(BIGINT)
   *  @param unknownCells Database column unknown_cells DBType(BIGINT)
   *  @param knownCells Database column known_cells DBType(BIGINT)
   *  @param blockedCells Database column blocked_cells DBType(BIGINT)
   *  @param downCells Database column down_cells DBType(BIGINT)
   *  @param upCells Database column up_cells DBType(BIGINT) */
  case class VSiteServiceCountersRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], vendorId: Option[String], excludeSite: Option[Boolean], existCells: Option[Long], excludeCells: Option[Long], includeCells: Option[Long], unknownCells: Option[Long], knownCells: Option[Long], blockedCells: Option[Long], downCells: Option[Long], upCells: Option[Long])
  /** GetResult implicit for fetching VSiteServiceCountersRow objects using plain SQL queries */
  implicit def GetResultVSiteServiceCountersRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]], e4: GR[Option[Long]]): GR[VSiteServiceCountersRow] = GR{
    prs => import prs._
    VSiteServiceCountersRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Boolean], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long]))
  }
  /** Table description of table v_site_service_counters. Objects of this class serve as prototypes for rows in queries. */
  class VSiteServiceCounters(_tableTag: Tag) extends Table[VSiteServiceCountersRow](_tableTag, "v_site_service_counters") {
    def * = (measurementTime, generation, groupId, siteId, vendorId, excludeSite, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells) <> (VSiteServiceCountersRow.tupled, VSiteServiceCountersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, vendorId, excludeSite, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells).shaped.<>({r=>import r._; _1.map(_=> VSiteServiceCountersRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column exclude_site DBType(BIT) */
    val excludeSite: Column[Option[Boolean]] = column[Option[Boolean]]("exclude_site")
    /** Database column exist_cells DBType(BIGINT) */
    val existCells: Column[Option[Long]] = column[Option[Long]]("exist_cells")
    /** Database column exclude_cells DBType(BIGINT) */
    val excludeCells: Column[Option[Long]] = column[Option[Long]]("exclude_cells")
    /** Database column include_cells DBType(BIGINT) */
    val includeCells: Column[Option[Long]] = column[Option[Long]]("include_cells")
    /** Database column unknown_cells DBType(BIGINT) */
    val unknownCells: Column[Option[Long]] = column[Option[Long]]("unknown_cells")
    /** Database column known_cells DBType(BIGINT) */
    val knownCells: Column[Option[Long]] = column[Option[Long]]("known_cells")
    /** Database column blocked_cells DBType(BIGINT) */
    val blockedCells: Column[Option[Long]] = column[Option[Long]]("blocked_cells")
    /** Database column down_cells DBType(BIGINT) */
    val downCells: Column[Option[Long]] = column[Option[Long]]("down_cells")
    /** Database column up_cells DBType(BIGINT) */
    val upCells: Column[Option[Long]] = column[Option[Long]]("up_cells")
  }
  /** Collection-like TableQuery object for table VSiteServiceCounters */
  lazy val VSiteServiceCounters = new TableQuery(tag => new VSiteServiceCounters(tag))
  
  /** Entity class storing rows of table VSiteServiceDowntime
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param downtime Database column downtime DBType(TIME) */
  case class VSiteServiceDowntimeRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], downtime: Option[java.sql.Time])
  /** GetResult implicit for fetching VSiteServiceDowntimeRow objects using plain SQL queries */
  implicit def GetResultVSiteServiceDowntimeRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[java.sql.Time]]): GR[VSiteServiceDowntimeRow] = GR{
    prs => import prs._
    VSiteServiceDowntimeRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[java.sql.Time]))
  }
  /** Table description of table v_site_service_downtime. Objects of this class serve as prototypes for rows in queries. */
  class VSiteServiceDowntime(_tableTag: Tag) extends Table[VSiteServiceDowntimeRow](_tableTag, "v_site_service_downtime") {
    def * = (measurementTime, generation, groupId, siteId, downtime) <> (VSiteServiceDowntimeRow.tupled, VSiteServiceDowntimeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, downtime).shaped.<>({r=>import r._; _1.map(_=> VSiteServiceDowntimeRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column downtime DBType(TIME) */
    val downtime: Column[Option[java.sql.Time]] = column[Option[java.sql.Time]]("downtime")
  }
  /** Collection-like TableQuery object for table VSiteServiceDowntime */
  lazy val VSiteServiceDowntime = new TableQuery(tag => new VSiteServiceDowntime(tag))
  
  /** Entity class storing rows of table VSiteServiceOperatorCounterHistory
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(50,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param vendorId Database column vendor_id DBType(VARCHAR), Length(50,true)
   *  @param excludeSite Database column exclude_site DBType(BIT)
   *  @param existCells Database column exist_cells DBType(BIGINT)
   *  @param excludeCells Database column exclude_cells DBType(BIGINT)
   *  @param includeCells Database column include_cells DBType(BIGINT)
   *  @param unknownCells Database column unknown_cells DBType(BIGINT)
   *  @param knownCells Database column known_cells DBType(BIGINT)
   *  @param blockedCells Database column blocked_cells DBType(BIGINT)
   *  @param downCells Database column down_cells DBType(BIGINT)
   *  @param upCells Database column up_cells DBType(BIGINT)
   *  @param sectorNo Database column sector_no DBType(INT) */
  case class VSiteServiceOperatorCounterHistoryRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], vendorId: Option[String], excludeSite: Option[Boolean], existCells: Option[Long], excludeCells: Option[Long], includeCells: Option[Long], unknownCells: Option[Long], knownCells: Option[Long], blockedCells: Option[Long], downCells: Option[Long], upCells: Option[Long], sectorNo: Option[Int])
  /** GetResult implicit for fetching VSiteServiceOperatorCounterHistoryRow objects using plain SQL queries */
  implicit def GetResultVSiteServiceOperatorCounterHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]], e4: GR[Option[Long]]): GR[VSiteServiceOperatorCounterHistoryRow] = GR{
    prs => import prs._
    VSiteServiceOperatorCounterHistoryRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Boolean], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Long], <<?[Int]))
  }
  /** Table description of table v_site_service_operator_counter_history. Objects of this class serve as prototypes for rows in queries. */
  class VSiteServiceOperatorCounterHistory(_tableTag: Tag) extends Table[VSiteServiceOperatorCounterHistoryRow](_tableTag, "v_site_service_operator_counter_history") {
    def * = (measurementTime, generation, groupId, siteId, vendorId, excludeSite, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo) <> (VSiteServiceOperatorCounterHistoryRow.tupled, VSiteServiceOperatorCounterHistoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, vendorId, excludeSite, existCells, excludeCells, includeCells, unknownCells, knownCells, blockedCells, downCells, upCells, sectorNo).shaped.<>({r=>import r._; _1.map(_=> VSiteServiceOperatorCounterHistoryRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(50,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column exclude_site DBType(BIT) */
    val excludeSite: Column[Option[Boolean]] = column[Option[Boolean]]("exclude_site")
    /** Database column exist_cells DBType(BIGINT) */
    val existCells: Column[Option[Long]] = column[Option[Long]]("exist_cells")
    /** Database column exclude_cells DBType(BIGINT) */
    val excludeCells: Column[Option[Long]] = column[Option[Long]]("exclude_cells")
    /** Database column include_cells DBType(BIGINT) */
    val includeCells: Column[Option[Long]] = column[Option[Long]]("include_cells")
    /** Database column unknown_cells DBType(BIGINT) */
    val unknownCells: Column[Option[Long]] = column[Option[Long]]("unknown_cells")
    /** Database column known_cells DBType(BIGINT) */
    val knownCells: Column[Option[Long]] = column[Option[Long]]("known_cells")
    /** Database column blocked_cells DBType(BIGINT) */
    val blockedCells: Column[Option[Long]] = column[Option[Long]]("blocked_cells")
    /** Database column down_cells DBType(BIGINT) */
    val downCells: Column[Option[Long]] = column[Option[Long]]("down_cells")
    /** Database column up_cells DBType(BIGINT) */
    val upCells: Column[Option[Long]] = column[Option[Long]]("up_cells")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VSiteServiceOperatorCounterHistory */
  lazy val VSiteServiceOperatorCounterHistory = new TableQuery(tag => new VSiteServiceOperatorCounterHistory(tag))
  
  /** Row type of table VSiteServiceState */
  type VSiteServiceStateRow = HCons[java.sql.Timestamp,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Int],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HCons[Option[scala.math.BigDecimal],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VSiteServiceStateRow providing default values if available in the database schema. */
  def VSiteServiceStateRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], nodeId: Option[String], siteId: Option[String], vendorId: Option[String], priority: Option[Int], exclude: Option[Boolean], siteSticky: Option[Boolean], cellSticky: Option[Int], minSector0State: Option[Long], minSector1State: Option[Long], minSector2State: Option[Long], minSector3State: Option[Long], maxSector0State: Option[Long], maxSector1State: Option[Long], maxSector2State: Option[Long], maxSector3State: Option[Long], cell0State: Option[Long], cell1State: Option[Long], cell2State: Option[Long], cell3State: Option[Long], cell4State: Option[Long], cell5State: Option[Long], cell6State: Option[Long], cell7State: Option[Long], cell8State: Option[Long], cell9State: Option[Long], cell10State: Option[Long], cell11State: Option[Long], cell12State: Option[Long], cell13State: Option[Long], cell14State: Option[Long], cell15State: Option[Long], cell16State: Option[Long], cell17State: Option[Long], cell18State: Option[Long], cell19State: Option[Long], cell20State: Option[Long], cell21State: Option[Long], cell22State: Option[Long], cell23State: Option[Long], cell24State: Option[Long], cell25State: Option[Long], cell26State: Option[Long], cell27State: Option[Long], cell28State: Option[Long], cell29State: Option[Long], cell30State: Option[Long], cell31State: Option[Long], existCells: Option[scala.math.BigDecimal], excludeCells: Option[scala.math.BigDecimal], includeCells: Option[scala.math.BigDecimal], unknownCells: Option[scala.math.BigDecimal], knownCells: Option[scala.math.BigDecimal], blockedCells: Option[scala.math.BigDecimal], downCells: Option[scala.math.BigDecimal], upCells: Option[scala.math.BigDecimal]): VSiteServiceStateRow = {
    measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: priority :: exclude :: siteSticky :: cellSticky :: minSector0State :: minSector1State :: minSector2State :: minSector3State :: maxSector0State :: maxSector1State :: maxSector2State :: maxSector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: existCells :: excludeCells :: includeCells :: unknownCells :: knownCells :: blockedCells :: downCells :: upCells :: HNil
  }
  /** GetResult implicit for fetching VSiteServiceStateRow objects using plain SQL queries */
  implicit def GetResultVSiteServiceStateRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]], e4: GR[Option[Long]], e5: GR[Option[scala.math.BigDecimal]]): GR[VSiteServiceStateRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Int] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: <<?[scala.math.BigDecimal] :: HNil
  }
  /** Table description of table v_site_service_state. Objects of this class serve as prototypes for rows in queries. */
  class VSiteServiceState(_tableTag: Tag) extends Table[VSiteServiceStateRow](_tableTag, "v_site_service_state") {
    def * = measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: priority :: exclude :: siteSticky :: cellSticky :: minSector0State :: minSector1State :: minSector2State :: minSector3State :: maxSector0State :: maxSector1State :: maxSector2State :: maxSector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: existCells :: excludeCells :: includeCells :: unknownCells :: knownCells :: blockedCells :: downCells :: upCells :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column priority DBType(INT) */
    val priority: Column[Option[Int]] = column[Option[Int]]("priority")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Option[Boolean]] = column[Option[Boolean]]("exclude")
    /** Database column site_sticky DBType(BIT) */
    val siteSticky: Column[Option[Boolean]] = column[Option[Boolean]]("site_sticky")
    /** Database column cell_sticky DBType(INT) */
    val cellSticky: Column[Option[Int]] = column[Option[Int]]("cell_sticky")
    /** Database column min_sector_0_state DBType(BIGINT) */
    val minSector0State: Column[Option[Long]] = column[Option[Long]]("min_sector_0_state")
    /** Database column min_sector_1_state DBType(BIGINT) */
    val minSector1State: Column[Option[Long]] = column[Option[Long]]("min_sector_1_state")
    /** Database column min_sector_2_state DBType(BIGINT) */
    val minSector2State: Column[Option[Long]] = column[Option[Long]]("min_sector_2_state")
    /** Database column min_sector_3_state DBType(BIGINT) */
    val minSector3State: Column[Option[Long]] = column[Option[Long]]("min_sector_3_state")
    /** Database column max_sector_0_state DBType(BIGINT) */
    val maxSector0State: Column[Option[Long]] = column[Option[Long]]("max_sector_0_state")
    /** Database column max_sector_1_state DBType(BIGINT) */
    val maxSector1State: Column[Option[Long]] = column[Option[Long]]("max_sector_1_state")
    /** Database column max_sector_2_state DBType(BIGINT) */
    val maxSector2State: Column[Option[Long]] = column[Option[Long]]("max_sector_2_state")
    /** Database column max_sector_3_state DBType(BIGINT) */
    val maxSector3State: Column[Option[Long]] = column[Option[Long]]("max_sector_3_state")
    /** Database column cell_0_state DBType(BIGINT) */
    val cell0State: Column[Option[Long]] = column[Option[Long]]("cell_0_state")
    /** Database column cell_1_state DBType(BIGINT) */
    val cell1State: Column[Option[Long]] = column[Option[Long]]("cell_1_state")
    /** Database column cell_2_state DBType(BIGINT) */
    val cell2State: Column[Option[Long]] = column[Option[Long]]("cell_2_state")
    /** Database column cell_3_state DBType(BIGINT) */
    val cell3State: Column[Option[Long]] = column[Option[Long]]("cell_3_state")
    /** Database column cell_4_state DBType(BIGINT) */
    val cell4State: Column[Option[Long]] = column[Option[Long]]("cell_4_state")
    /** Database column cell_5_state DBType(BIGINT) */
    val cell5State: Column[Option[Long]] = column[Option[Long]]("cell_5_state")
    /** Database column cell_6_state DBType(BIGINT) */
    val cell6State: Column[Option[Long]] = column[Option[Long]]("cell_6_state")
    /** Database column cell_7_state DBType(BIGINT) */
    val cell7State: Column[Option[Long]] = column[Option[Long]]("cell_7_state")
    /** Database column cell_8_state DBType(BIGINT) */
    val cell8State: Column[Option[Long]] = column[Option[Long]]("cell_8_state")
    /** Database column cell_9_state DBType(BIGINT) */
    val cell9State: Column[Option[Long]] = column[Option[Long]]("cell_9_state")
    /** Database column cell_10_state DBType(BIGINT) */
    val cell10State: Column[Option[Long]] = column[Option[Long]]("cell_10_state")
    /** Database column cell_11_state DBType(BIGINT) */
    val cell11State: Column[Option[Long]] = column[Option[Long]]("cell_11_state")
    /** Database column cell_12_state DBType(BIGINT) */
    val cell12State: Column[Option[Long]] = column[Option[Long]]("cell_12_state")
    /** Database column cell_13_state DBType(BIGINT) */
    val cell13State: Column[Option[Long]] = column[Option[Long]]("cell_13_state")
    /** Database column cell_14_state DBType(BIGINT) */
    val cell14State: Column[Option[Long]] = column[Option[Long]]("cell_14_state")
    /** Database column cell_15_state DBType(BIGINT) */
    val cell15State: Column[Option[Long]] = column[Option[Long]]("cell_15_state")
    /** Database column cell_16_state DBType(BIGINT) */
    val cell16State: Column[Option[Long]] = column[Option[Long]]("cell_16_state")
    /** Database column cell_17_state DBType(BIGINT) */
    val cell17State: Column[Option[Long]] = column[Option[Long]]("cell_17_state")
    /** Database column cell_18_state DBType(BIGINT) */
    val cell18State: Column[Option[Long]] = column[Option[Long]]("cell_18_state")
    /** Database column cell_19_state DBType(BIGINT) */
    val cell19State: Column[Option[Long]] = column[Option[Long]]("cell_19_state")
    /** Database column cell_20_state DBType(BIGINT) */
    val cell20State: Column[Option[Long]] = column[Option[Long]]("cell_20_state")
    /** Database column cell_21_state DBType(BIGINT) */
    val cell21State: Column[Option[Long]] = column[Option[Long]]("cell_21_state")
    /** Database column cell_22_state DBType(BIGINT) */
    val cell22State: Column[Option[Long]] = column[Option[Long]]("cell_22_state")
    /** Database column cell_23_state DBType(BIGINT) */
    val cell23State: Column[Option[Long]] = column[Option[Long]]("cell_23_state")
    /** Database column cell_24_state DBType(BIGINT) */
    val cell24State: Column[Option[Long]] = column[Option[Long]]("cell_24_state")
    /** Database column cell_25_state DBType(BIGINT) */
    val cell25State: Column[Option[Long]] = column[Option[Long]]("cell_25_state")
    /** Database column cell_26_state DBType(BIGINT) */
    val cell26State: Column[Option[Long]] = column[Option[Long]]("cell_26_state")
    /** Database column cell_27_state DBType(BIGINT) */
    val cell27State: Column[Option[Long]] = column[Option[Long]]("cell_27_state")
    /** Database column cell_28_state DBType(BIGINT) */
    val cell28State: Column[Option[Long]] = column[Option[Long]]("cell_28_state")
    /** Database column cell_29_state DBType(BIGINT) */
    val cell29State: Column[Option[Long]] = column[Option[Long]]("cell_29_state")
    /** Database column cell_30_state DBType(BIGINT) */
    val cell30State: Column[Option[Long]] = column[Option[Long]]("cell_30_state")
    /** Database column cell_31_state DBType(BIGINT) */
    val cell31State: Column[Option[Long]] = column[Option[Long]]("cell_31_state")
    /** Database column exist_cells DBType(DECIMAL) */
    val existCells: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("exist_cells")
    /** Database column exclude_cells DBType(DECIMAL) */
    val excludeCells: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("exclude_cells")
    /** Database column include_cells DBType(DECIMAL) */
    val includeCells: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("include_cells")
    /** Database column unknown_cells DBType(DECIMAL) */
    val unknownCells: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("unknown_cells")
    /** Database column known_cells DBType(DECIMAL) */
    val knownCells: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("known_cells")
    /** Database column blocked_cells DBType(DECIMAL) */
    val blockedCells: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("blocked_cells")
    /** Database column down_cells DBType(DECIMAL) */
    val downCells: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("down_cells")
    /** Database column up_cells DBType(DECIMAL) */
    val upCells: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("up_cells")
  }
  /** Collection-like TableQuery object for table VSiteServiceState */
  lazy val VSiteServiceState = new TableQuery(tag => new VSiteServiceState(tag))
  
  /** Row type of table VSiteServiceStateHistory */
  type VSiteServiceStateHistoryRow = HCons[java.sql.Timestamp,HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[Int],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[Int],HCons[Option[java.sql.Time],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VSiteServiceStateHistoryRow providing default values if available in the database schema. */
  def VSiteServiceStateHistoryRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], nodeId: Option[String], siteId: Option[String], vendorId: Option[String], priority: Option[Int], exclude: Option[Boolean], sticky: Option[Int], sector0State: Option[Long], sector1State: Option[Long], sector2State: Option[Long], sector3State: Option[Long], cell0State: Option[Int], cell1State: Option[Int], cell2State: Option[Int], cell3State: Option[Int], cell4State: Option[Int], cell5State: Option[Int], cell6State: Option[Int], cell7State: Option[Int], cell8State: Option[Int], cell9State: Option[Int], cell10State: Option[Int], cell11State: Option[Int], cell12State: Option[Int], cell13State: Option[Int], cell14State: Option[Int], cell15State: Option[Int], cell16State: Option[Int], cell17State: Option[Int], cell18State: Option[Int], cell19State: Option[Int], cell20State: Option[Int], cell21State: Option[Int], cell22State: Option[Int], cell23State: Option[Int], cell24State: Option[Int], cell25State: Option[Int], cell26State: Option[Int], cell27State: Option[Int], cell28State: Option[Int], cell29State: Option[Int], cell30State: Option[Int], cell31State: Option[Int], existCells: Option[Int], excludeCells: Option[Int], includeCells: Option[Int], unknownCells: Option[Int], knownCells: Option[Int], blockedCells: Option[Int], downCells: Option[Int], upCells: Option[Int], downtime: Option[java.sql.Time]): VSiteServiceStateHistoryRow = {
    measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: priority :: exclude :: sticky :: sector0State :: sector1State :: sector2State :: sector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: existCells :: excludeCells :: includeCells :: unknownCells :: knownCells :: blockedCells :: downCells :: upCells :: downtime :: HNil
  }
  /** GetResult implicit for fetching VSiteServiceStateHistoryRow objects using plain SQL queries */
  implicit def GetResultVSiteServiceStateHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]], e4: GR[Option[Long]], e5: GR[Option[java.sql.Time]]): GR[VSiteServiceStateHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Boolean] :: <<?[Int] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[Int] :: <<?[java.sql.Time] :: HNil
  }
  /** Table description of table v_site_service_state_history. Objects of this class serve as prototypes for rows in queries. */
  class VSiteServiceStateHistory(_tableTag: Tag) extends Table[VSiteServiceStateHistoryRow](_tableTag, "v_site_service_state_history") {
    def * = measurementTime :: generation :: groupId :: nodeId :: siteId :: vendorId :: priority :: exclude :: sticky :: sector0State :: sector1State :: sector2State :: sector3State :: cell0State :: cell1State :: cell2State :: cell3State :: cell4State :: cell5State :: cell6State :: cell7State :: cell8State :: cell9State :: cell10State :: cell11State :: cell12State :: cell13State :: cell14State :: cell15State :: cell16State :: cell17State :: cell18State :: cell19State :: cell20State :: cell21State :: cell22State :: cell23State :: cell24State :: cell25State :: cell26State :: cell27State :: cell28State :: cell29State :: cell30State :: cell31State :: existCells :: excludeCells :: includeCells :: unknownCells :: knownCells :: blockedCells :: downCells :: upCells :: downtime :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column node_id DBType(VARCHAR), Length(50,true) */
    val nodeId: Column[Option[String]] = column[Option[String]]("node_id", O.Length(50,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column priority DBType(INT) */
    val priority: Column[Option[Int]] = column[Option[Int]]("priority")
    /** Database column exclude DBType(BIT) */
    val exclude: Column[Option[Boolean]] = column[Option[Boolean]]("exclude")
    /** Database column sticky DBType(INT) */
    val sticky: Column[Option[Int]] = column[Option[Int]]("sticky")
    /** Database column sector_0_state DBType(BIGINT) */
    val sector0State: Column[Option[Long]] = column[Option[Long]]("sector_0_state")
    /** Database column sector_1_state DBType(BIGINT) */
    val sector1State: Column[Option[Long]] = column[Option[Long]]("sector_1_state")
    /** Database column sector_2_state DBType(BIGINT) */
    val sector2State: Column[Option[Long]] = column[Option[Long]]("sector_2_state")
    /** Database column sector_3_state DBType(BIGINT) */
    val sector3State: Column[Option[Long]] = column[Option[Long]]("sector_3_state")
    /** Database column cell_0_state DBType(INT) */
    val cell0State: Column[Option[Int]] = column[Option[Int]]("cell_0_state")
    /** Database column cell_1_state DBType(INT) */
    val cell1State: Column[Option[Int]] = column[Option[Int]]("cell_1_state")
    /** Database column cell_2_state DBType(INT) */
    val cell2State: Column[Option[Int]] = column[Option[Int]]("cell_2_state")
    /** Database column cell_3_state DBType(INT) */
    val cell3State: Column[Option[Int]] = column[Option[Int]]("cell_3_state")
    /** Database column cell_4_state DBType(INT) */
    val cell4State: Column[Option[Int]] = column[Option[Int]]("cell_4_state")
    /** Database column cell_5_state DBType(INT) */
    val cell5State: Column[Option[Int]] = column[Option[Int]]("cell_5_state")
    /** Database column cell_6_state DBType(INT) */
    val cell6State: Column[Option[Int]] = column[Option[Int]]("cell_6_state")
    /** Database column cell_7_state DBType(INT) */
    val cell7State: Column[Option[Int]] = column[Option[Int]]("cell_7_state")
    /** Database column cell_8_state DBType(INT) */
    val cell8State: Column[Option[Int]] = column[Option[Int]]("cell_8_state")
    /** Database column cell_9_state DBType(INT) */
    val cell9State: Column[Option[Int]] = column[Option[Int]]("cell_9_state")
    /** Database column cell_10_state DBType(INT) */
    val cell10State: Column[Option[Int]] = column[Option[Int]]("cell_10_state")
    /** Database column cell_11_state DBType(INT) */
    val cell11State: Column[Option[Int]] = column[Option[Int]]("cell_11_state")
    /** Database column cell_12_state DBType(INT) */
    val cell12State: Column[Option[Int]] = column[Option[Int]]("cell_12_state")
    /** Database column cell_13_state DBType(INT) */
    val cell13State: Column[Option[Int]] = column[Option[Int]]("cell_13_state")
    /** Database column cell_14_state DBType(INT) */
    val cell14State: Column[Option[Int]] = column[Option[Int]]("cell_14_state")
    /** Database column cell_15_state DBType(INT) */
    val cell15State: Column[Option[Int]] = column[Option[Int]]("cell_15_state")
    /** Database column cell_16_state DBType(INT) */
    val cell16State: Column[Option[Int]] = column[Option[Int]]("cell_16_state")
    /** Database column cell_17_state DBType(INT) */
    val cell17State: Column[Option[Int]] = column[Option[Int]]("cell_17_state")
    /** Database column cell_18_state DBType(INT) */
    val cell18State: Column[Option[Int]] = column[Option[Int]]("cell_18_state")
    /** Database column cell_19_state DBType(INT) */
    val cell19State: Column[Option[Int]] = column[Option[Int]]("cell_19_state")
    /** Database column cell_20_state DBType(INT) */
    val cell20State: Column[Option[Int]] = column[Option[Int]]("cell_20_state")
    /** Database column cell_21_state DBType(INT) */
    val cell21State: Column[Option[Int]] = column[Option[Int]]("cell_21_state")
    /** Database column cell_22_state DBType(INT) */
    val cell22State: Column[Option[Int]] = column[Option[Int]]("cell_22_state")
    /** Database column cell_23_state DBType(INT) */
    val cell23State: Column[Option[Int]] = column[Option[Int]]("cell_23_state")
    /** Database column cell_24_state DBType(INT) */
    val cell24State: Column[Option[Int]] = column[Option[Int]]("cell_24_state")
    /** Database column cell_25_state DBType(INT) */
    val cell25State: Column[Option[Int]] = column[Option[Int]]("cell_25_state")
    /** Database column cell_26_state DBType(INT) */
    val cell26State: Column[Option[Int]] = column[Option[Int]]("cell_26_state")
    /** Database column cell_27_state DBType(INT) */
    val cell27State: Column[Option[Int]] = column[Option[Int]]("cell_27_state")
    /** Database column cell_28_state DBType(INT) */
    val cell28State: Column[Option[Int]] = column[Option[Int]]("cell_28_state")
    /** Database column cell_29_state DBType(INT) */
    val cell29State: Column[Option[Int]] = column[Option[Int]]("cell_29_state")
    /** Database column cell_30_state DBType(INT) */
    val cell30State: Column[Option[Int]] = column[Option[Int]]("cell_30_state")
    /** Database column cell_31_state DBType(INT) */
    val cell31State: Column[Option[Int]] = column[Option[Int]]("cell_31_state")
    /** Database column exist_cells DBType(INT) */
    val existCells: Column[Option[Int]] = column[Option[Int]]("exist_cells")
    /** Database column exclude_cells DBType(INT) */
    val excludeCells: Column[Option[Int]] = column[Option[Int]]("exclude_cells")
    /** Database column include_cells DBType(INT) */
    val includeCells: Column[Option[Int]] = column[Option[Int]]("include_cells")
    /** Database column unknown_cells DBType(INT) */
    val unknownCells: Column[Option[Int]] = column[Option[Int]]("unknown_cells")
    /** Database column known_cells DBType(INT) */
    val knownCells: Column[Option[Int]] = column[Option[Int]]("known_cells")
    /** Database column blocked_cells DBType(INT) */
    val blockedCells: Column[Option[Int]] = column[Option[Int]]("blocked_cells")
    /** Database column down_cells DBType(INT) */
    val downCells: Column[Option[Int]] = column[Option[Int]]("down_cells")
    /** Database column up_cells DBType(INT) */
    val upCells: Column[Option[Int]] = column[Option[Int]]("up_cells")
    /** Database column downtime DBType(TIME) */
    val downtime: Column[Option[java.sql.Time]] = column[Option[java.sql.Time]]("downtime")
  }
  /** Collection-like TableQuery object for table VSiteServiceStateHistory */
  lazy val VSiteServiceStateHistory = new TableQuery(tag => new VSiteServiceStateHistory(tag))
  
  /** Entity class storing rows of table VSiteTicket
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param maxPriority Database column max_priority DBType(VARCHAR), Length(20,true) */
  case class VSiteTicketRow(groupId: String, siteId: String, maxPriority: Option[String])
  /** GetResult implicit for fetching VSiteTicketRow objects using plain SQL queries */
  implicit def GetResultVSiteTicketRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[VSiteTicketRow] = GR{
    prs => import prs._
    VSiteTicketRow.tupled((<<[String], <<[String], <<?[String]))
  }
  /** Table description of table v_site_ticket. Objects of this class serve as prototypes for rows in queries. */
  class VSiteTicket(_tableTag: Tag) extends Table[VSiteTicketRow](_tableTag, "v_site_ticket") {
    def * = (groupId, siteId, maxPriority) <> (VSiteTicketRow.tupled, VSiteTicketRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupId.?, siteId.?, maxPriority).shaped.<>({r=>import r._; _1.map(_=> VSiteTicketRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[String] = column[String]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[String] = column[String]("site_id", O.Length(50,varying=true))
    /** Database column max_priority DBType(VARCHAR), Length(20,true) */
    val maxPriority: Column[Option[String]] = column[Option[String]]("max_priority", O.Length(20,varying=true))
  }
  /** Collection-like TableQuery object for table VSiteTicket */
  lazy val VSiteTicket = new TableQuery(tag => new VSiteTicket(tag))
  
  /** Entity class storing rows of table VStates
   *  @param measurementTime Database column measurement_time DBType(TIMESTAMP)
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param cellState Database column cell_state DBType(INT) */
  case class VStatesRow(measurementTime: java.sql.Timestamp, generation: Option[Int], groupId: Option[String], siteId: Option[String], cellNo: Option[Int], cellState: Option[Int])
  /** GetResult implicit for fetching VStatesRow objects using plain SQL queries */
  implicit def GetResultVStatesRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[VStatesRow] = GR{
    prs => import prs._
    VStatesRow.tupled((<<[java.sql.Timestamp], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table v_states. Objects of this class serve as prototypes for rows in queries. */
  class VStates(_tableTag: Tag) extends Table[VStatesRow](_tableTag, "v_states") {
    def * = (measurementTime, generation, groupId, siteId, cellNo, cellState) <> (VStatesRow.tupled, VStatesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (measurementTime.?, generation, groupId, siteId, cellNo, cellState).shaped.<>({r=>import r._; _1.map(_=> VStatesRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column cell_state DBType(INT) */
    val cellState: Column[Option[Int]] = column[Option[Int]]("cell_state")
  }
  /** Collection-like TableQuery object for table VStates */
  lazy val VStates = new TableQuery(tag => new VStates(tag))
  
  /** Entity class storing rows of table VStatesDowntime
   *  @param generation Database column generation DBType(INT)
   *  @param groupId Database column group_id DBType(VARCHAR), Length(256,true)
   *  @param siteId Database column site_id DBType(VARCHAR), Length(50,true)
   *  @param cellNo Database column cell_no DBType(INT)
   *  @param downtime Database column downtime DBType(DATETIME) */
  case class VStatesDowntimeRow(generation: Option[Int], groupId: Option[String], siteId: Option[String], cellNo: Option[Int], downtime: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching VStatesDowntimeRow objects using plain SQL queries */
  implicit def GetResultVStatesDowntimeRow(implicit e0: GR[Option[Int]], e1: GR[Option[String]], e2: GR[Option[java.sql.Timestamp]]): GR[VStatesDowntimeRow] = GR{
    prs => import prs._
    VStatesDowntimeRow.tupled((<<?[Int], <<?[String], <<?[String], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table v_states_downtime. Objects of this class serve as prototypes for rows in queries. */
  class VStatesDowntime(_tableTag: Tag) extends Table[VStatesDowntimeRow](_tableTag, "v_states_downtime") {
    def * = (generation, groupId, siteId, cellNo, downtime) <> (VStatesDowntimeRow.tupled, VStatesDowntimeRow.unapply)
    
    /** Database column generation DBType(INT) */
    val generation: Column[Option[Int]] = column[Option[Int]]("generation")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column site_id DBType(VARCHAR), Length(50,true) */
    val siteId: Column[Option[String]] = column[Option[String]]("site_id", O.Length(50,varying=true))
    /** Database column cell_no DBType(INT) */
    val cellNo: Column[Option[Int]] = column[Option[Int]]("cell_no")
    /** Database column downtime DBType(DATETIME) */
    val downtime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("downtime")
  }
  /** Collection-like TableQuery object for table VStatesDowntime */
  lazy val VStatesDowntime = new TableQuery(tag => new VStatesDowntime(tag))
  
  /** Row type of table VVendorPerformanceHistory */
  type VVendorPerformanceHistoryRow = HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[String],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[scala.math.BigDecimal],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for VVendorPerformanceHistoryRow providing default values if available in the database schema. */
  def VVendorPerformanceHistoryRow(measurementTime: java.sql.Timestamp, groupId: Option[String], vendorId: Option[String], unknownCellsAll: Option[Long], knownCellsAll: Option[Long], blockedCellsAll: Option[Long], downCellsAll: Option[Long], upCellsAll: Option[Long], cisKpiAll: Option[scala.math.BigDecimal], unknownCells4g: Option[Long], knownCells4g: Option[Long], blockedCells4g: Option[Long], downCells4g: Option[Long], upCells4g: Option[Long], cisKpi4g: Option[scala.math.BigDecimal], unknownCells3g: Option[Long], knownCells3g: Option[Long], blockedCells3g: Option[Long], downCells3g: Option[Long], upCells3g: Option[Long], cisKpi3g: Option[scala.math.BigDecimal], unknownCells2g: Option[Long], knownCells2g: Option[Long], blockedCells2g: Option[Long], downCells2g: Option[Long], upCells2g: Option[Long], cisKpi2g: Option[scala.math.BigDecimal], sectorNo: Option[Int]): VVendorPerformanceHistoryRow = {
    measurementTime :: groupId :: vendorId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
  }
  /** GetResult implicit for fetching VVendorPerformanceHistoryRow objects using plain SQL queries */
  implicit def GetResultVVendorPerformanceHistoryRow(implicit e0: GR[java.sql.Timestamp], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[scala.math.BigDecimal]], e4: GR[Option[Int]]): GR[VVendorPerformanceHistoryRow] = GR{
    prs => import prs._
    <<[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[scala.math.BigDecimal] :: <<?[Int] :: HNil
  }
  /** Table description of table v_vendor_performance_history. Objects of this class serve as prototypes for rows in queries. */
  class VVendorPerformanceHistory(_tableTag: Tag) extends Table[VVendorPerformanceHistoryRow](_tableTag, "v_vendor_performance_history") {
    def * = measurementTime :: groupId :: vendorId :: unknownCellsAll :: knownCellsAll :: blockedCellsAll :: downCellsAll :: upCellsAll :: cisKpiAll :: unknownCells4g :: knownCells4g :: blockedCells4g :: downCells4g :: upCells4g :: cisKpi4g :: unknownCells3g :: knownCells3g :: blockedCells3g :: downCells3g :: upCells3g :: cisKpi3g :: unknownCells2g :: knownCells2g :: blockedCells2g :: downCells2g :: upCells2g :: cisKpi2g :: sectorNo :: HNil
    
    /** Database column measurement_time DBType(TIMESTAMP) */
    val measurementTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("measurement_time")
    /** Database column group_id DBType(VARCHAR), Length(256,true) */
    val groupId: Column[Option[String]] = column[Option[String]]("group_id", O.Length(256,varying=true))
    /** Database column vendor_id DBType(VARCHAR), Length(50,true) */
    val vendorId: Column[Option[String]] = column[Option[String]]("vendor_id", O.Length(50,varying=true))
    /** Database column unknown_cells_all DBType(BIGINT) */
    val unknownCellsAll: Column[Option[Long]] = column[Option[Long]]("unknown_cells_all")
    /** Database column known_cells_all DBType(BIGINT) */
    val knownCellsAll: Column[Option[Long]] = column[Option[Long]]("known_cells_all")
    /** Database column blocked_cells_all DBType(BIGINT) */
    val blockedCellsAll: Column[Option[Long]] = column[Option[Long]]("blocked_cells_all")
    /** Database column down_cells_all DBType(BIGINT) */
    val downCellsAll: Column[Option[Long]] = column[Option[Long]]("down_cells_all")
    /** Database column up_cells_all DBType(BIGINT) */
    val upCellsAll: Column[Option[Long]] = column[Option[Long]]("up_cells_all")
    /** Database column cis_kpi_all DBType(DECIMAL) */
    val cisKpiAll: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_all")
    /** Database column unknown_cells_4g DBType(BIGINT) */
    val unknownCells4g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_4g")
    /** Database column known_cells_4g DBType(BIGINT) */
    val knownCells4g: Column[Option[Long]] = column[Option[Long]]("known_cells_4g")
    /** Database column blocked_cells_4g DBType(BIGINT) */
    val blockedCells4g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_4g")
    /** Database column down_cells_4g DBType(BIGINT) */
    val downCells4g: Column[Option[Long]] = column[Option[Long]]("down_cells_4g")
    /** Database column up_cells_4g DBType(BIGINT) */
    val upCells4g: Column[Option[Long]] = column[Option[Long]]("up_cells_4g")
    /** Database column cis_kpi_4g DBType(DECIMAL) */
    val cisKpi4g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_4g")
    /** Database column unknown_cells_3g DBType(BIGINT) */
    val unknownCells3g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_3g")
    /** Database column known_cells_3g DBType(BIGINT) */
    val knownCells3g: Column[Option[Long]] = column[Option[Long]]("known_cells_3g")
    /** Database column blocked_cells_3g DBType(BIGINT) */
    val blockedCells3g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_3g")
    /** Database column down_cells_3g DBType(BIGINT) */
    val downCells3g: Column[Option[Long]] = column[Option[Long]]("down_cells_3g")
    /** Database column up_cells_3g DBType(BIGINT) */
    val upCells3g: Column[Option[Long]] = column[Option[Long]]("up_cells_3g")
    /** Database column cis_kpi_3g DBType(DECIMAL) */
    val cisKpi3g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_3g")
    /** Database column unknown_cells_2g DBType(BIGINT) */
    val unknownCells2g: Column[Option[Long]] = column[Option[Long]]("unknown_cells_2g")
    /** Database column known_cells_2g DBType(BIGINT) */
    val knownCells2g: Column[Option[Long]] = column[Option[Long]]("known_cells_2g")
    /** Database column blocked_cells_2g DBType(BIGINT) */
    val blockedCells2g: Column[Option[Long]] = column[Option[Long]]("blocked_cells_2g")
    /** Database column down_cells_2g DBType(BIGINT) */
    val downCells2g: Column[Option[Long]] = column[Option[Long]]("down_cells_2g")
    /** Database column up_cells_2g DBType(BIGINT) */
    val upCells2g: Column[Option[Long]] = column[Option[Long]]("up_cells_2g")
    /** Database column cis_kpi_2g DBType(DECIMAL) */
    val cisKpi2g: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("cis_kpi_2g")
    /** Database column sector_no DBType(INT) */
    val sectorNo: Column[Option[Int]] = column[Option[Int]]("sector_no")
  }
  /** Collection-like TableQuery object for table VVendorPerformanceHistory */
  lazy val VVendorPerformanceHistory = new TableQuery(tag => new VVendorPerformanceHistory(tag))
}
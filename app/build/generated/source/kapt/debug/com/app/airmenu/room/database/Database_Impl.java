package com.app.airmenu.room.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.app.airmenu.room.dao.OrderDAO;
import com.app.airmenu.room.dao.OrderDAO_Impl;
import com.app.airmenu.room.dao.UberNotificationDAO;
import com.app.airmenu.room.dao.UberNotificationDAO_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Database_Impl extends Database {
  private volatile OrderDAO _orderDAO;

  private volatile UberNotificationDAO _uberNotificationDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `orderInfo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `airmenuOrderId` TEXT NOT NULL, `uberOrderId` TEXT NOT NULL, `keyFlag` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `uber_notification` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `uber_order_id` TEXT NOT NULL, `uber_store_id` TEXT NOT NULL, `timestamp` TEXT NOT NULL, `local_time` TEXT NOT NULL, `status` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '13aa972238717e042847953da29986e1')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `orderInfo`");
        _db.execSQL("DROP TABLE IF EXISTS `uber_notification`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsOrderInfo = new HashMap<String, TableInfo.Column>(4);
        _columnsOrderInfo.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderInfo.put("airmenuOrderId", new TableInfo.Column("airmenuOrderId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderInfo.put("uberOrderId", new TableInfo.Column("uberOrderId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderInfo.put("keyFlag", new TableInfo.Column("keyFlag", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOrderInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOrderInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOrderInfo = new TableInfo("orderInfo", _columnsOrderInfo, _foreignKeysOrderInfo, _indicesOrderInfo);
        final TableInfo _existingOrderInfo = TableInfo.read(_db, "orderInfo");
        if (! _infoOrderInfo.equals(_existingOrderInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "orderInfo(com.app.airmenu.room.model.OrderInfo).\n"
                  + " Expected:\n" + _infoOrderInfo + "\n"
                  + " Found:\n" + _existingOrderInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsUberNotification = new HashMap<String, TableInfo.Column>(6);
        _columnsUberNotification.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUberNotification.put("uber_order_id", new TableInfo.Column("uber_order_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUberNotification.put("uber_store_id", new TableInfo.Column("uber_store_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUberNotification.put("timestamp", new TableInfo.Column("timestamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUberNotification.put("local_time", new TableInfo.Column("local_time", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUberNotification.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUberNotification = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUberNotification = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUberNotification = new TableInfo("uber_notification", _columnsUberNotification, _foreignKeysUberNotification, _indicesUberNotification);
        final TableInfo _existingUberNotification = TableInfo.read(_db, "uber_notification");
        if (! _infoUberNotification.equals(_existingUberNotification)) {
          return new RoomOpenHelper.ValidationResult(false, "uber_notification(com.app.airmenu.room.model.UberNotification).\n"
                  + " Expected:\n" + _infoUberNotification + "\n"
                  + " Found:\n" + _existingUberNotification);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "13aa972238717e042847953da29986e1", "aed5599ee82691bca40f82437c0f7f07");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "orderInfo","uber_notification");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `orderInfo`");
      _db.execSQL("DELETE FROM `uber_notification`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(OrderDAO.class, OrderDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(UberNotificationDAO.class, UberNotificationDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public OrderDAO orderDAO() {
    if (_orderDAO != null) {
      return _orderDAO;
    } else {
      synchronized(this) {
        if(_orderDAO == null) {
          _orderDAO = new OrderDAO_Impl(this);
        }
        return _orderDAO;
      }
    }
  }

  @Override
  public UberNotificationDAO uberNotificationDAO() {
    if (_uberNotificationDAO != null) {
      return _uberNotificationDAO;
    } else {
      synchronized(this) {
        if(_uberNotificationDAO == null) {
          _uberNotificationDAO = new UberNotificationDAO_Impl(this);
        }
        return _uberNotificationDAO;
      }
    }
  }
}

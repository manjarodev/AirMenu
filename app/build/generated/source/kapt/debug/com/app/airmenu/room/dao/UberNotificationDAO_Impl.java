package com.app.airmenu.room.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.app.airmenu.room.model.UberNotification;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UberNotificationDAO_Impl implements UberNotificationDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UberNotification> __insertionAdapterOfUberNotification;

  public UberNotificationDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUberNotification = new EntityInsertionAdapter<UberNotification>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `uber_notification` (`id`,`uber_order_id`,`uber_store_id`,`timestamp`,`local_time`,`status`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UberNotification value) {
        stmt.bindLong(1, value.getId());
        if (value.getOrderId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOrderId());
        }
        if (value.getStoreId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStoreId());
        }
        if (value.getTimemstamp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimemstamp());
        }
        if (value.getLocalTime() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLocalTime());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStatus());
        }
      }
    };
  }

  @Override
  public Object insertUberNotification(final UberNotification orderInfo,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUberNotification.insert(orderInfo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllNotification(
      final Continuation<? super List<UberNotification>> continuation) {
    final String _sql = "SELECT * FROM uber_notification ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<UberNotification>>() {
      @Override
      public List<UberNotification> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "uber_order_id");
          final int _cursorIndexOfStoreId = CursorUtil.getColumnIndexOrThrow(_cursor, "uber_store_id");
          final int _cursorIndexOfTimemstamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLocalTime = CursorUtil.getColumnIndexOrThrow(_cursor, "local_time");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<UberNotification> _result = new ArrayList<UberNotification>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UberNotification _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpOrderId;
            if (_cursor.isNull(_cursorIndexOfOrderId)) {
              _tmpOrderId = null;
            } else {
              _tmpOrderId = _cursor.getString(_cursorIndexOfOrderId);
            }
            final String _tmpStoreId;
            if (_cursor.isNull(_cursorIndexOfStoreId)) {
              _tmpStoreId = null;
            } else {
              _tmpStoreId = _cursor.getString(_cursorIndexOfStoreId);
            }
            final String _tmpTimemstamp;
            if (_cursor.isNull(_cursorIndexOfTimemstamp)) {
              _tmpTimemstamp = null;
            } else {
              _tmpTimemstamp = _cursor.getString(_cursorIndexOfTimemstamp);
            }
            final String _tmpLocalTime;
            if (_cursor.isNull(_cursorIndexOfLocalTime)) {
              _tmpLocalTime = null;
            } else {
              _tmpLocalTime = _cursor.getString(_cursorIndexOfLocalTime);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            _item = new UberNotification(_tmpId,_tmpOrderId,_tmpStoreId,_tmpTimemstamp,_tmpLocalTime,_tmpStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

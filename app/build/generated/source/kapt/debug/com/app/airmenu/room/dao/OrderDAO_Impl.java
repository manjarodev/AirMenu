package com.app.airmenu.room.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.app.airmenu.room.model.OrderInfo;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OrderDAO_Impl implements OrderDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OrderInfo> __insertionAdapterOfOrderInfo;

  public OrderDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOrderInfo = new EntityInsertionAdapter<OrderInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `orderInfo` (`id`,`airmenuOrderId`,`uberOrderId`,`keyFlag`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OrderInfo value) {
        stmt.bindLong(1, value.getId());
        if (value.getAirmenuOrderId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAirmenuOrderId());
        }
        if (value.getUberOrderId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUberOrderId());
        }
        if (value.getKeyFlag() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getKeyFlag());
        }
      }
    };
  }

  @Override
  public Object insertOrder(final OrderInfo orderInfo,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfOrderInfo.insert(orderInfo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getOrderId(final String id, final Continuation<? super String> continuation) {
    final String _sql = "SELECT airmenuOrderId FROM orderInfo WHERE uberOrderId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getString(0);
            }
          } else {
            _result = null;
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

package com.example.android.architecture.blueprints.todoapp.data.source.local;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.android.architecture.blueprints.todoapp.data.Task;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class TasksDao_Impl implements TasksDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTask;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCompleted;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTaskById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTasks;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCompletedTasks;

  public TasksDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTask = new EntityInsertionAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tasks`(`entryid`,`title`,`description`,`completed`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        final int _tmp;
        _tmp = value.isCompleted() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__updateAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tasks` SET `entryid` = ?,`title` = ?,`description` = ?,`completed` = ? WHERE `entryid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        final int _tmp;
        _tmp = value.isCompleted() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getId());
        }
      }
    };
    this.__preparedStmtOfUpdateCompleted = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE tasks SET completed = ? WHERE entryid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteTaskById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Tasks WHERE entryid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteTasks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Tasks";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCompletedTasks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Tasks WHERE completed = 1";
        return _query;
      }
    };
  }

  @Override
  public void insertTask(Task task) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTask.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateTask(Task task) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfTask.handle(task);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCompleted(String taskId, boolean completed) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCompleted.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      final int _tmp;
      _tmp = completed ? 1 : 0;
      _stmt.bindLong(_argIndex, _tmp);
      _argIndex = 2;
      if (taskId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, taskId);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCompleted.release(_stmt);
    }
  }

  @Override
  public int deleteTaskById(String taskId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTaskById.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (taskId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, taskId);
      }
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteTaskById.release(_stmt);
    }
  }

  @Override
  public void deleteTasks() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTasks.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteTasks.release(_stmt);
    }
  }

  @Override
  public int deleteCompletedTasks() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCompletedTasks.acquire();
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCompletedTasks.release(_stmt);
    }
  }

  @Override
  public List<Task> getTasks() {
    final String _sql = "SELECT * FROM Tasks";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfMId = _cursor.getColumnIndexOrThrow("entryid");
      final int _cursorIndexOfMTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfMDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfMCompleted = _cursor.getColumnIndexOrThrow("completed");
      final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Task _item;
        final String _tmpMId;
        _tmpMId = _cursor.getString(_cursorIndexOfMId);
        final String _tmpMTitle;
        _tmpMTitle = _cursor.getString(_cursorIndexOfMTitle);
        final String _tmpMDescription;
        _tmpMDescription = _cursor.getString(_cursorIndexOfMDescription);
        final boolean _tmpMCompleted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfMCompleted);
        _tmpMCompleted = _tmp != 0;
        _item = new Task(_tmpMTitle,_tmpMDescription,_tmpMId,_tmpMCompleted);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Task getTaskById(String taskId) {
    final String _sql = "SELECT * FROM Tasks WHERE entryid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (taskId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, taskId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfMId = _cursor.getColumnIndexOrThrow("entryid");
      final int _cursorIndexOfMTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfMDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfMCompleted = _cursor.getColumnIndexOrThrow("completed");
      final Task _result;
      if(_cursor.moveToFirst()) {
        final String _tmpMId;
        _tmpMId = _cursor.getString(_cursorIndexOfMId);
        final String _tmpMTitle;
        _tmpMTitle = _cursor.getString(_cursorIndexOfMTitle);
        final String _tmpMDescription;
        _tmpMDescription = _cursor.getString(_cursorIndexOfMDescription);
        final boolean _tmpMCompleted;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfMCompleted);
        _tmpMCompleted = _tmp != 0;
        _result = new Task(_tmpMTitle,_tmpMDescription,_tmpMId,_tmpMCompleted);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}

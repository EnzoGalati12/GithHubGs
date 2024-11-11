package br.com.rm1234.ondeeh.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.rm1234.ondeeh.data.local.dao.GitDao
import br.com.rm1234.ondeeh.data.local.entity.GitEntity

@Database(entities = [GitEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gitDao(): GitDao
}

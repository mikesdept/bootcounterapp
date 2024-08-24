package mikes.dept.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import mikes.dept.data.database.dao.BootEventDao
import mikes.dept.data.database.entities.BootEventDBEntity

@Database(
    entities = [
        BootEventDBEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class BootCounterAppAppDatabase : RoomDatabase() {

    abstract fun bootEventDao(): BootEventDao

}

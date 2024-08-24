package mikes.dept.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mikes.dept.data.database.entities.BootEventDBEntity

@Dao
interface BootEventDao {

    @Query("SELECT * FROM BootEventDBEntity")
    suspend fun getAll(): List<BootEventDBEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bootEventDBEntity: BootEventDBEntity)

}

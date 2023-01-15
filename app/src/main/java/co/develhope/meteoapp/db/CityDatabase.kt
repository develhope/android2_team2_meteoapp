package co.develhope.meteoapp.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import co.develhope.meteoapp.data.dataModel.Cities
import co.develhope.meteoapp.utils.DB_NAME

@Database(
    entities = [Cities::class],
    version = 1
)

abstract class CityDatabase: RoomDatabase() {

    abstract fun getCityDao(): CityDao

    companion object{
        private const val TAG = "CityDatabase"

        private val MIGRATION_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                // do update query
                // works like onUpgrade method of SQLite
                Log.d(TAG, "migrate: I am here")

                //adding save table
                database.execSQL("ALTER TABLE city_db ADD COLUMN isSaved INTEGER DEFAULT NULL")
            }
        }

        @Volatile
        private var instance: CityDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?:createDatabase(context).also{instance = it}
        }

        private fun createDatabase(context: Context) = Room
            .databaseBuilder(context.applicationContext, CityDatabase::class.java, DB_NAME)
            .createFromAsset(DB_NAME).build()

    }
}
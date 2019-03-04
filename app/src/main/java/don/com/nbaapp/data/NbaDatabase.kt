package don.com.nbaapp.data

/**
 * Created by gideon on 28,February,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */



import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.util.Log
import don.com.nbaapp.model.Teams.Teams
import don.com.nbaapp.model.Teams.TeamsDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */
@Database(entities = [Teams::class], version = 1,exportSchema = false)
abstract class NbaDatabase : RoomDatabase() {

    abstract fun wordDao(): TeamsDao

    companion object {
        @Volatile
        private var INSTANCE: NbaDatabase? = null

        fun getDatabase(
                context: Context,
                scope: CoroutineScope
        ): NbaDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        NbaDatabase::class.java,
                        "incomeExpense"
                )
                        // Wipes and rebuilds instead of migrating if no Migration object.
                        // Migration is not part of this codelab.
                        .fallbackToDestructiveMigration()
                        .addCallback(WordDatabaseCallback(scope))
                        .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class WordDatabaseCallback(
                private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.wordDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        fun populateDatabase(wordDao: TeamsDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
//            wordDao.deleteAll()

            /*   var word = IncomeExpense(0,"Pengeluaran","Uang listrik",2000f)
               wordDao.insert(word)
               word = IncomeExpense(0,"Pengeluran","Uang Sabun",4000f)
               wordDao.insert(word)*/
            Log.e("tag",wordDao.toString())
        }



    }

}
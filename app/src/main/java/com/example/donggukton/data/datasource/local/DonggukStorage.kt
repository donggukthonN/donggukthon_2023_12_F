package com.example.donggukton.data.datasource.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.donggukton.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DonggukStorage @Inject constructor(@ApplicationContext context: Context) {
    private val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val pref: SharedPreferences =
        if (BuildConfig.DEBUG) {
            context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        } else {
            EncryptedSharedPreferences.create(
                context,
                FILE_NAME,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
            )
        }

    var userId: String
        set(value) = pref.edit { putString(USERID, value) }
        get() = pref.getString(
            USERID,
            "",
        ) ?: ""

    var userName: String
        set(value) = pref.edit { putString(USERNAME, value) }
        get() = pref.getString(
            USERNAME,
            "",
        ) ?: ""

    var startDate: String
        set(value) = pref.edit { putString(START_DATE, value) }
        get() = pref.getString(
            START_DATE,
            "",
        ) ?: ""

    companion object {
        const val FILE_NAME = "HdDataStore"
        const val USERID = "userID"
        const val USERNAME = "userName"
        const val START_DATE = "startDate"
    }
}

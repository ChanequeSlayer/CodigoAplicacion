package com.example.bdapp
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper





class SQLite(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
     db?.execSQL("create table usuarios (Membrecia INT NOT NULL PRIMARY KEY UNIQUE, nombre VARCHAR(45) NOT NULL,apellidoP VARCHAR(45) NOT NULL,apellidoM VARCHAR(45) NOT NULL,edad INT NOT NULL,Telefono VARCHAR(10) NOT NULL UNIQUE,Direccion VARCHAR(45) NOT NULL)")
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
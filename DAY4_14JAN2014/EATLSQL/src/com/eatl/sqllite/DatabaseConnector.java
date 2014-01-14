package com.eatl.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseConnector {
	
	private static final String DB_NAME = "Phonebook";
	private SQLiteDatabase database;
	private DatabaseOpenHelper dbOpenHelper;
	   
	public DatabaseConnector(Context context) {
		dbOpenHelper = new DatabaseOpenHelper(context, DB_NAME, null, 1);
	}
	
	   public void open() throws SQLException 
	   {
	      //open database in reading/writing mode
	      database = dbOpenHelper.getWritableDatabase();
	   } 

	   public void close() 
	   {
	      if (database != null)
	         database.close();
	   }	   
	   
	   public void insertContact(String name, String cap, String code) 
			   {
			      ContentValues newCon = new ContentValues();
			      newCon.put("name", name);
			      newCon.put("email", cap);
			      newCon.put("number", code);

			      open();
			      database.insert("phone", null, newCon);
			      close();
			   }

			
			   public void updateContact(long id, String name, String cap,String code) 
			   {
			      ContentValues editCon = new ContentValues();
			      editCon.put("name", name);
			      editCon.put("email", cap);
			      editCon.put("number", code);

			      open();
			      database.update("phone", editCon, "_id=" + id, null);
			      close();
			   }

			  
			   public Cursor getAllContacts() 
			   {
			      return database.query("phone", new String[] {"_id", "name"}, 
			         null, null, null, null, "name");
			   }

			   public Cursor getOneContact(long id) 
			   {
			      return database.query("phone", null, "_id=" + id, null, null, null, null);
			   }
			   
			   public void deleteContact(long id) 
			   {
			      open(); 
			      database.delete("phone", "_id=" + id, null);
			      close();
			   }
}

package com.ust.training.student.constant;

public interface IStudentDbConstants {
  
 String COLLECTION_NAME                    ="studentDb";
 String DATABASE_NAME                      ="${azure.cosmosdb.database}";
 String DATABASE_KEY                       ="${azure.cosmosdb.key}";
 String DATABASE_URI                       ="${azure.cosmosdb.uri}";
}

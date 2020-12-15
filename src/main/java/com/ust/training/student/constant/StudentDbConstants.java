/***
 * Project : Student
 */
package com.ust.training.student.constant;
/***
 * Db Constants
 * @author SACHIN AJITHKUMAR
 *
 */

public class StudentDbConstants {
  /***
   * Default constructor
   */
  private StudentDbConstants() {
    
  }
  public static final String COLLECTION_NAME                    ="studentDb";
  public static final String DATABASE_NAME                      ="${azure.cosmosdb.database}";
  public static final String DATABASE_KEY                       ="${azure.cosmosdb.key}";
  public static final String DATABASE_URI                       ="${azure.cosmosdb.uri}";

}

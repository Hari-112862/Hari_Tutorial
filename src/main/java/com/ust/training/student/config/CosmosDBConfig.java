/***
 * Project : Student
 */

package com.ust.training.student.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.cosmos.GatewayConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.repository.config.EnableReactiveCosmosRepositories;
import com.ust.training.student.constant.ISqlQueryConstants;
import com.ust.training.student.constant.IStudentApplicationConstants;

/***
 * CosmosDbConfiguration class
 * @author SACHIN AJITHKUMAR
 *
 */
@Configuration
@EnableReactiveCosmosRepositories(basePackages = IStudentApplicationConstants.STUDENT_BASE_PACKAGE)
public class CosmosDBConfig extends AbstractCosmosConfiguration {

  @Value(ISqlQueryConstants.DATABASE_URI)
  private String cosmosDbUrl;
  @Value(ISqlQueryConstants.DATABASE_KEY)
  private String cosmosDbKey;
  @Value(ISqlQueryConstants.DATABASE_NAME)
  private String databaseName;
	/***
	 * Method for returning the dburl and key
	 * @return CosmosClientBuilder
	 */
	@Bean
	public CosmosClientBuilder getCosmosClientBuilder() {
		return new CosmosClientBuilder()
				.endpoint(cosmosDbUrl)
				.key(cosmosDbKey)
				.directMode(new DirectConnectionConfig(),
						new GatewayConnectionConfig());

	}
/***
 * method for database name
 * @return databaseName
 */
	@Override
	protected String getDatabaseName() {
		return databaseName;
	}
}

/***
 * Project : Student
 */

package com.training.student.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.cosmos.GatewayConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.repository.config.EnableReactiveCosmosRepositories;
import com.training.student.constant.StudentConstants;

/***
 * CosmosDbConfiguration class
 * @author SACHIN AJITHKUMAR
 *
 */

@Configuration
@EnableReactiveCosmosRepositories(basePackages = StudentConstants.STUDENT_BASE_PACKAGE)
public class CosmosDBConfig extends AbstractCosmosConfiguration {

	@Value(StudentConstants.DATABASE_URI)
	private String cosmosDbUrl;

	@Value(StudentConstants.DATABASE_KEY)
	private String cosmosDbKey;

	@Value(StudentConstants.DATABASE_NAME)
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

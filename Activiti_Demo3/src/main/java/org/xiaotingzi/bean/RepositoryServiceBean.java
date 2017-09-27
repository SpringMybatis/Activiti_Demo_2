package org.xiaotingzi.bean;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RepositoryServiceBean {
	
	@Bean
	public RepositoryService getRepositoryServiceBean() {
		ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
				.setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000").setJdbcUsername("sa").setJdbcPassword("")
				.setJdbcDriver("org.h2.Driver")
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
//		ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
//		.setJdbcUrl("jdbc:mysql://localhost:3308/activiti").setJdbcUsername("root").setJdbcPassword("root")
//		.setJdbcDriver("com.mysql.jdbc.Driver")
//		.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE);
//		
		ProcessEngine processEngine = cfg.buildProcessEngine();
		
//		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

		RepositoryService repositoryService = processEngine.getRepositoryService();

		return repositoryService;
	}
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}

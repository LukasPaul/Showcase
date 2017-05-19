package org.educama.services.flightinformation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoDbConfig {

	@Bean
	public MongoClient client(@Value("classpath:myTrustStore") Resource trustStore,
	    @Value("${mongocredential.url}") String url,
	    @Value("${mongocredential.port}") Integer port,
	    @Value("${mongocredential.userName}") String userName,
	    @Value("${mongocredential.userPassword}") String password,
	    @Value("${mongocredential.database}") String database) throws IOException {
		Path tempDirPath = Files.createTempDirectory("sllTempFolder");

		Files.copy(trustStore.getInputStream(), tempDirPath, StandardCopyOption.REPLACE_EXISTING);

		System.setProperty("javax.net.ssl.trustStore", tempDirPath.toString());
		
		ServerAddress serverAddress = new ServerAddress(url, port);
		List<MongoCredential> mongoCredentials = Arrays.asList(MongoCredential.createCredential(userName, database, password.toCharArray()));
		MongoClientOptions mongoClientOptions = MongoClientOptions.builder()
		    .sslEnabled(true)
		    .sslInvalidHostNameAllowed(true)
		    .build();
		MongoClient mongoClient = new MongoClient(serverAddress, mongoCredentials, mongoClientOptions);

		return mongoClient;
	}

}

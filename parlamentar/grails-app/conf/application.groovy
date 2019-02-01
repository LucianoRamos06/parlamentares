grails{
	profile ="web"
	codegen{
		defaultPackage = "com.vibe.parlamentar"
	}

	gorm{
		reactor{
			events = false
		}
	}

	cors{
		enabled: true
	}
}

info{
	app{
		name = "@info.app.name@"
		version = "@info.app.version@"
		grailsVersion = "@info.app.grailsVersion@"
	}
}

spring{
	main.'banner-mode' = "off"
	groovy.template.'check-template-location' = false

}

endpoints{
	enabled =false
	jmx{
		enabled = true
	}
}

hibernate{
	cache{
		queries = false
		use_second_level_cache = false
		use_query_cache = false
	}
}

dataSource{
	pooled = true
	jmxExport = true
}

environments{
	development{

		server.contextPath = '/vibe'
		grails.serverURL = 'http://localhost:8080'

		dataSource{
			dbCreate = "create-drop"
			driverClassName = "org.h2.Driver"
			url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
			username = "sa"
			password = ""
		}
	}

	staging{

		server.contextPath = '/vibe'
		grails.serverURL = 'http://localhost:8080'

		dataSource{
			dbCreate = "update"
			driverClassName = "org.postgresql.Driver"
			url = "jdbc:postgresql://localhost/parlamentar_staging"
			username = "postgres"
			password = "postgres"
		}
	}

	production{

		server.contextPath = '/vibe'
		grails.serverURL = 'http://localhost:8080'

		dataSource{
			dbCreate = "update"
			driverClassName = "org.postgresql.Driver"
			url = "jdbc:postgresql://localhost/parlamentar_production"
			password = "postgres"
			username = "postgres"
			properties = {
				jmxEnabled = true
				initialSize = 5
				maxActive = 50
				minIdle = 5
				maxIdle = 25
				maxWait = 10000
				maxAge = 600000
				timeBetweenEvictionRunsMillis = 5000
				minEvictableIdleTimeMillis = 60000
				validationQuery = "SELECT 1"
				validationQueryTimeout = 3
				validationInterval = 15000
				testOnBorrow = true
				testWhileIdle = true
				testOnReturn = false
				jdbcInterceptors = "ConnectionState;StatementCache(max=200)"
				defaultTransactionIsolation = 2
			}
		}
	}
}

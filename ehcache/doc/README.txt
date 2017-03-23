http://localhost:8080/ehcache/cacheTest/update/3
http://localhost:8080/ehcache/cacheTest/get/3
http://localhost:8081/ehcache/cacheTest/get/3

mvn tomcat:run -Dmaven.tomcat.port=8080
<!-- RMI tomcat_1:8080,tomcat_2:127.0.0.1:9002....-->
	<cacheManagerPeerListenerFactory
		class="net.sf.ehcache.distribution.RMICacheManagerPeerListenerFactory"
		properties="hostName=127.0.0.1,
					port=9001, 
					socketTimeoutMillis=2000"
					
mvn tomcat:run -Dmaven.tomcat.port=8081
<!-- RMI tomcat_2:8081....-->
	<cacheManagerPeerListenerFactory
		class="net.sf.ehcache.distribution.RMICacheManagerPeerListenerFactory"
		properties="hostName=127.0.0.1,
					port=9002, 
					socketTimeoutMillis=2000"
					
JGroup为测试
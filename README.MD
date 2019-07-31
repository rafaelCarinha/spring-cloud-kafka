**Spring Cloud - Kafka**

Build an Audit configuration, sending messages to Kafka topics.  

Listen to a topic, and process the data as desired.  

SpringCloud, Kafka, AOP, Lombok, SpringBoot.  

**Requirements:**

Kafka and Zookeeper: brew install kafka  

**Start Zookeeper and Kafka:**

zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties  
kafka-server-start /usr/local/etc/kafka/server.properties  

**Create a PRODUCER topic:**

Producer Console:
kafka-console-producer --broker-list localhost:9092 --topic audit  

**Create a CONSUMER for the above topic:**

Consumer console:
kafka-console-consumer --bootstrap-server localhost:9092 --topic audit --from-beginning  



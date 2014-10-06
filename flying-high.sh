#!/bin/bash
startMongo() {
	mongod --fork --logpath mongodb.log
}

stopMongo() {
	mongod --shutdown
}

startAccountsService() {
	java -jar accounts-web-service/build/libs/accounts-web-service-1.0.0.jar & >/dev/null 2>&1
}

stopAccountsService() {
 	export pid=`ps | grep accounts-web-service | awk 'NR==1{print $1}' | cut -d' ' -f1`;kill $pid
}

startFlightsService() {
	java -jar flights-web-service/build/libs/flights-web-service-1.0.0.jar & >/dev/null 2>&1
}

stopFlightsService() {
 	export pid=`ps | grep flights-web-service | awk 'NR==1{print $1}' | cut -d' ' -f1`;kill $pid
}

startApp() {
	cd flying-high-app
	npm install
	bower install
	grunt serve & >/dev/null 2>&1
}

if [ "$1" = "start" ] ; 
then
	echo "Starting Flying High services"
	startMongo
	startAccountsService
	startFlightsService
	startApp
fi

if [ "$1" = "stop" ] ; 
then
	echo "Shutting down Flying High services"
	stopMongo
	stopAccountsService
	stopFlightsService
	stopApp
fi
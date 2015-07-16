#!/usr/bin/env bash

cd microservices/core/person-service;                ./gradlew clean; cd ../../..;  
cd microservices/core/threat-service;                ./gradlew clean; cd ../../..;
cd microservices/composite/check-status-composite-service; ./gradlew clean; cd ../../..;

cd microservices/support/discovery-server;            ./gradlew clean; cd ../../..;
cd microservices/support/edge-server;                 ./gradlew clean; cd ../../..;
cd microservices/support/monitor-dashboard;           ./gradlew clean; cd ../../..;
cd microservices/support/turbine;                     ./gradlew clean; cd ../../..;


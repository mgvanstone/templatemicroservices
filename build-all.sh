#!/usr/bin/env bash

cd microservices/core/person-service;                ./gradlew clean publishToMavenLocal; cd -
cd microservices/core/threat-service;                ./gradlew clean publishToMavenLocal; cd -
cd microservices/composite/check-status-composite-service; ./gradlew clean build; cd -

cd microservices/support/discovery-server;            ./gradlew clean build; cd -
cd microservices/support/edge-server;                 ./gradlew clean build; cd -
cd microservices/support/monitor-dashboard;           ./gradlew clean build; cd -
cd microservices/support/turbine;                     ./gradlew clean build; cd -


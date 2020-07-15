#!/usr/bin/env groovy

pipeline {
    agent any

    options { disableConcurrentBuilds() }
 
    stages {
		/*stage('Clean workspace') {
            steps {
			    deleteDir()
                sh 'ls -lah'
            }
        }*/
		stage('Checkout code') {
            steps {
			    checkout scm
            }
        }
        stage('Compile code') {
            steps {
				sh 'gradle build'
            }
        }
		
		/*stage('Run test') {
            steps {
				sh 'gradle test'
            }
        } */
		
		stage('PCF Login') {
            login('https://api.run.pivotal.io', 'uki-engineering', 'AnjanaShenoy')
        }
		
		

    }

	
	def login(url, org, space){

		withCredentials([usernamePassword(credentialsId: 'fca040d6-6d0f-4423-9ffa-25dbe62b1a27', usernameVariable: 'uName', passwordVariable: 'password')]) {
			CONNECT = sh (
						script: "cf login -a ${url} -u \"${uName}\" -p \"${password}\" -o ${org} -s ${space}",
						returnStatus: true
					).trim()
		}
		
	/*post {
			wrap([$class: 'CloudFoundryCliBuildWrapper',
			cloudFoundryCliVersion: 'Cloud Foundry CLI (built-in)',
			apiEndpoint: 'https://api.run.pivotal.io',
			skipSslValidation: true,
			credentialsId: 'pcf-runtime-credentials',
			organization: 'uki-engineering',
			space: 'AnjanaShenoy']) {

			   sh 'cf push user-service -p /build/libs/user-service-0.0.1-SNAPSHOT.jar'
			}
    }*/ //post block in pipeline scope
}
pipeline {
    agent {
        docker {
         image 'maven:3-alpine'
         args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn $(MAVEN_CLI_OPTS) test-compile'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn test'
            }
        }
    }

    environment {
        MAVEN_CLI_OPTS = '--batch-mode --errors --fail-at-end --show-version -DinstallAtEnd=true -DdeployAtEnd=true'
        MAVEN_OPTS = '-Dmaven.repo.local=.m2/repository -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN -Dorg.slf4j.simpleLogger.showDateTime=true -Djava.awt.headless=true'
    }
}
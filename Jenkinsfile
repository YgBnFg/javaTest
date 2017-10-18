pipeline {
  agent none
  stages {
    stage('build') {
      steps {
        sh 'mvn $MAVEN_CLI_OPTS test-compile'
      }
    }
    stage('test') {
      steps {
        sh 'mvn package test'
      }
    }
  }
  environment {
    MAVEN_CLI_OPTS = '--batch-mode --errors --fail-at-end --show-version -DinstallAtEnd=true -DdeployAtEnd=true'
    MAVEN_OPTS = '-Dmaven.repo.local=.m2/repository -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN -Dorg.slf4j.simpleLogger.showDateTime=true -Djava.awt.headless=true'
  }
}
pipeline {
    agent {
        docker {
         image 'maven:3-alpine'
         args '-v /root/.m2:/root/.m2 -v /usr/bin/docker:/usr/bin/docker -v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn $MAVEN_CLI_OPTS test-compile'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn package test'
            }
        }
        stage('Publish') {
            steps {
                sh 'echo BUILD_TAG=$BUILD_TAG'
                sh 'cp target/$PACKAGENAME.war script/docker/$PACKAGENAME.war'
                sh 'cd script/docker'
                sh 'docker build -t javatest:$BUILD_TAG .'
                sh 'ls -alh'
                sh 'docker push javatest:$BUILD_TAG'
                sh 'cd $WORKSPACE'
                sh 'echo $BUILD_TAG > javatest-tag.txt'
            }
        }
    }

    environment {
        MAVEN_CLI_OPTS = '--batch-mode --errors --fail-at-end --show-version -DinstallAtEnd=true -DdeployAtEnd=true'
        MAVEN_OPTS = '-Dmaven.repo.local=.m2/repository -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN -Dorg.slf4j.simpleLogger.showDateTime=true -Djava.awt.headless=true'
        PACKAGENAME = 'javatest'
    }
}
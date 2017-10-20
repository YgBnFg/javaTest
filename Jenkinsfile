pipeline {
    agent {
        docker {
         image 'maven:3-alpine'
         args '-v /home/.m2:/home/.m2 -v /usr/bin/docker:/usr/bin/docker -v /var/run/docker.sock:/var/run/docker.sock'
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
                archiveArtifacts artifacts:'target/*.war'
            }
        }
        stage('Publish') {
            when {
                branch 'master'
            }
            steps {
                echo 'BUILD_TAG=$BUILD_TAG'
                sh 'cp target/$PACKAGENAME.war script/docker/$PACKAGENAME.war'
                sh 'docker build -t $PACKAGENAME:$BUILD_TAG script/docker'
                sh 'cd $WORKSPACE'
                sh 'echo $BUILD_TAG > $PACKAGENAME-tag.txt'
            }
        }
        stage('deploy') {
            when {
                branch 'master'
            }
            steps {
                sh 'bash script/deploy.sh dev'
            }
        }
    }

    environment {
        MAVEN_CLI_OPTS = '--batch-mode --errors --fail-at-end --show-version -DinstallAtEnd=true -DdeployAtEnd=true'
        MAVEN_OPTS = '-Dmaven.repo.local=/home/.m2/repository -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN -Dorg.slf4j.simpleLogger.showDateTime=true -Djava.awt.headless=true'
        PACKAGENAME = 'javatest'
        RUNPORT = '8081'
    }
}
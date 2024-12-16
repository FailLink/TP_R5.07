pipeline {
    agent any
    tools {
        // Installez Java et Maven dans Jenkins si ce n’est pas fait
        maven 'Maven-Installation'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/FailLink/TP_R5.07.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }
        stage('SonarQube Analysis') {
            environment {
                SONAR_HOST_URL = 'http://your-sonarqube-server'
                SONAR_LOGIN = credentials('your-sonar-token-id')
            }
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=TP_R5.07 -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=$SONAR_LOGIN'
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            publishCoverage adapters: [jacocoAdapter('**/target/site/jacoco/jacoco.xml')]
        }
    }
}

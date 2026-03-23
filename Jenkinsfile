pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'Java17'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/Sakarihon/Shoppingcart.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco(execPattern: 'target/jacoco.exec')
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
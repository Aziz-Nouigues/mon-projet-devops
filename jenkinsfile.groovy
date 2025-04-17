pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'mon-app-java'
        SONAR_PROJECT_KEY = 'mon-projet-java'
    }
    
    stages {
        stage('Checkout GitHub') {
            steps {
                git branch: 'main',
                url: 'https://github.com/votre-user/mon-projet-java.git'
            }
        }
        
        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Analyse SonarQube') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}:${env.BUILD_ID}")
                }
            }
        }
    }
}
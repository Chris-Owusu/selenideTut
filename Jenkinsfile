pipeline {
    agent any

    tools {
        maven 'Maven 3.9.1' // Replace with your Maven version
        jdk 'JDK 20' // Replace with your JDK version
    }

    stages {
        stage('Set Console Code Page') {
            steps {
                echo "Setting console code page to UTF-8"
                script {
                    if (isUnix()) {
                        bat 'echo "This step is only necessary on Windows"'
                    } else {
                        bat 'chcp 65001'
                    }
                }
            }
        }
        stage('Checkout') {
            steps {
                echo "Checking out the code"
                checkout scm
            }
        }
        stage('Building') {
            steps {
                echo "Building the application"
                bat "mvn clean install -DskipTests"
            }
        }
        stage('Testing') {
            steps {
                echo "Running tests"
                bat "mvn verify"
            }
        }
        stage('Deploying') {
            steps {
                echo "Deploying the application"
                // Add your deployment steps here
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
            // Add additional success actions, e.g., notifications
        }
        failure {
            echo 'Build failed!'
            // Add additional failure actions, e.g., notifications
        }
        always {
            echo 'Cleaning up...'
            cleanWs()
        }
    }
}

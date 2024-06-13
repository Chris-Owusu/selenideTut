pipeline {
    agent any

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
}

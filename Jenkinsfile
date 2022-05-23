pipeline {
    agent { docker { image 'python:3.10.1-alpine' } }
    stages {
        stage('build') {
            steps {
                sh 'python --version'
				sh 'cd practice'
				sh 'sudo apt update'
				sh 'sudo apt install maven'
				sh 'mvn test'
            }
        }
    }
}

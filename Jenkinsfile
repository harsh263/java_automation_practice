pipeline {
    agent { docker { image 'python:3.8.3-ubuntu-20.04' } }
    stages {
        stage('build') {
            steps {
                sh 'python --version'
				sh 'cd practice'
				sh 'apt update'
				sh 'apt install maven'
				sh 'mvn test'
            }
        }
    }
}

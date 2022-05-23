pipeline {
    agent { docker { image 'python:3.10.1-alpine' } }
    stages {
        stage('build') {
            steps {
                sh 'python --version'
				sh 'cd practice'
				sh 'mvn test'
            }
        }
    }
}

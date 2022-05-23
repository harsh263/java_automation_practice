pipeline {
    agent any
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

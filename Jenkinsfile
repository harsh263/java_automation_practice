pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "We are in buils step"
				sh 'mvn -version'
				sh 'cd practice'
				sh 'mvn -f /practice/pom.xml test'
            }
        }
    }
}

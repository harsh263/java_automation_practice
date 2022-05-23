pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "We are in buils step"
				sh 'mvn -version'
				echo "Current workspace is ${env.WORKSPACE}"
				sh 'mvn -f /practice/pom.xml test'
            }
        }
    }
}

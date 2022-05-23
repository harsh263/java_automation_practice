pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "We are in buil step"
				sh 'mvn -version'
				echo "Current workspace is ${env.WORKSPACE}"
				sh 'mvn -f ${env.WORKSPACE}/practice test'
            }
        }
    }
}

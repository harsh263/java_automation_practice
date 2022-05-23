pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "We are in buils step"
				sh 'mvn -version'
				PATH=${env.WORKSPACE}/practice/pom.xml
				echo PATH
				sh 'mvn -f PATH test'
            }
        }
    }
}

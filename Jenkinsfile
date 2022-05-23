pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "We are in buils step"
				sh 'mvn -version'
				sh 'PATH=${env.WORKSPACE}/practice/pom.xml'
				echo "Current workspace is ${env.WORKSPACE}"
				sh 'mvn -f /var/lib/jenkins/workspace/Jenkins_file_practice_main/practice/pom.xml test'
            }
        }
    }
}

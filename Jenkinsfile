pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean install'
            }
        }
        stage('Example Test') {
                    steps {
                        echo '--------------------TESTING---------------------------------------'
                        sh 'java -version'
                    }
                }
    }
}
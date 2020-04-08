pipeline {
    agent any 
    stages {
        stage('compile'){
            steps {
                sh './gradlew compileJava'
            }
        }
        stage('unit test'){
            steps{
                sh './gradlew test'
            }
        }
        stage('code coverage'){
            steps{
                sh './gradlew test jacocoTestReport'
                sh './gradlew test jacocoTestCoverageVerification'
            }
        }
    }
}
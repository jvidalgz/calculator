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
                publishHTML(target:[
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'Jacoco Report',
                ])
                sh './gradlew test jacocoTestCoverageVerification'
            }
        }
    }
}
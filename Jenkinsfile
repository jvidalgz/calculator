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
        stage('static code analysis'){
            steps{
                sh './gradlew checkstyleMain'
                publishHTML(target:[
                    reportDir: 'build/reports/checkstyle',
                    reportFiles: 'main.html',
                    reportName: 'Checkstyle Report',
                ])
            }
        }
        stage('package'){
            steps{
                sh './gradlew build'               
            }
        }
        stage('docker build'){
            steps{
                sh 'docker build -t localhost:5000/calculator .'               
            }
        }
        stage('docker push'){
            steps{
                sh 'docker push localhost:5000/calculator'               
            }
        }
        stage('deploy to staging'){
            steps {
                sh 'docker run -d --rm -p 8765:8080 --name calculator localhost:5000/calculator'
            }
        }
        stage('acceptance test'){
            steps{
                sleep 60
                sh 'chmod +x acceptance_test.sh && ./acceptance_test.sh'
            }
        }
        
    }
    post{
        always{
            sh 'docker stop calculator'
        }
    }
}
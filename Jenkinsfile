#!groovy

pipeline{
    agent any

    parameters {
      base64File description: 'Upload the file', name: 'FILE'
    }


    stages{
        stage('checkout code'){
                    steps{
                        checkout scmGit(branches: [[name: '*/jenkins-setup']], extensions: [], userRemoteConfigs: [[credentialsId: 'github-dba-rsa', url: 'https://github.com/doingERP-com/doingERP.git']])
                    }
                }

        stage('process input file'){
            steps{
                 withFileParameter('FILE') {
                        bat 'copy /Y %FILE% %WORKSPACE%\\src\\test\\resources\\businessflows\\sample.xlsx'

                    }
            }
        }

        stage('Clean repo'){
            steps{

                bat 'mvn clean'
            }
        }
        stage('Test script'){
            steps{
                bat 'mvn test'
            }
        }

    }
    post {
        always {

                publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'target/results/latest', reportFiles: 'TestReport.html', reportName: 'Summary Report', reportTitles: ''])

        }
    }

}
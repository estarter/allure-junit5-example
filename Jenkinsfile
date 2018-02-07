pipeline {
    agent any
    stages {
        stage("Delete All") {
            steps {
                deleteDir()
            }
        }
        stage("Build") {
            steps {
                withMaven(maven: 'mvn') {
                    sh 'mvn -Dmaven.test.failure.ignore=true clean verify'
                }
            }
        }
        stage('Publish') {
            steps {
                echo 'Publish Allure report'
                publishHTML(
                    target: [
                        allowMissing         : false,
                        alwaysLinkToLastBuild: false,
                        keepAll              : true,
                        reportDir            : 'target/site/allure-maven-plugin',
                        reportFiles          : 'index.html',
                        reportName           : "Allure Report"
                    ]
                )
            }
        }
    }
}
